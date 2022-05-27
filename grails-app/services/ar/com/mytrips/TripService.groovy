package ar.com.mytrips

import ar.com.mytrips.destination.Destination
import ar.com.mytrips.exception.ServiceException
import ar.com.mytrips.external.TriposoService
import ar.com.mytrips.external.UnsplashService
import grails.events.annotation.Publisher
import grails.events.annotation.Subscriber
import grails.gorm.services.Service

import javax.transaction.Transactional
import static grails.async.Promises.*


@Service(Trip)
@Transactional
class TripService {
    TriposoService triposoService
    UnsplashService unsplashService
    UserService userService


    def get(String id) {
        Trip.findByIdAndOwnerAndDeleted(id, userService.currentUser, false)
    }

    def list(Integer max = 25, Integer offset = 0 ) {
        Trip.findAllByOwnerAndDeleted(userService.currentUser,false, [max:max, offset:offset])
    }

    Trip create(Trip trip){
        trip.owner = userService.getCurrentUser()
        trip.destinations.each {
            it.trip = trip
        }
        trip.image = unsplashService.getImage(trip.firstDestination.place.name)
        trip.save()
        publishSuggestedItinerary(trip)
        trip
    }

    @Publisher("SuggestedItinerary")
    protected List<String> publishSuggestedItinerary(Trip trip) {
        trip.destinations*.id
    }

    @Subscriber('SuggestedItinerary')
    def loadSuggestedItinerary(List<String> destinationId) {
        task {
            def tasks = tasks(destinationId.collect { id ->
                return {
                    Destination.withNewTransaction {
                        def destination = Destination.findById(id)
                        def dayPlanner = triposoService.getDayPlanner(destination)
                        if (dayPlanner) {
                            destination.setDataFromPlanner(dayPlanner)
                        }
                        destination.save(flush:true)
                        destination
                    }
                }
            })
            tasks.get()
        }

    }

    def delete(Trip trip) {
        if(userService.currentUser != trip.owner){
            throw ServiceException.forbidden("invalidUser")
        }
        trip.deleted = true
        trip.save()
    }
}
