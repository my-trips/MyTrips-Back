package ar.com.mytrips

import ar.com.mytrips.auth.User
import ar.com.mytrips.destination.Destination
import ar.com.mytrips.exception.ServiceException
import ar.com.mytrips.external.TriposoService
import ar.com.mytrips.external.UnsplashService
import grails.events.annotation.Publisher
import grails.events.annotation.Subscriber
import grails.gorm.services.Service
import org.hibernate.criterion.CriteriaSpecification

import javax.persistence.criteria.JoinType
import javax.transaction.Transactional

import static grails.async.Promises.task
import static grails.async.Promises.tasks

@Service(Trip)
@Transactional
class TripService {
    TriposoService triposoService
    UnsplashService unsplashService
    UserService userService


    Trip get(String anId) {
        def user = userService.currentUser
        Trip.where {
            join("travellers",  JoinType.LEFT)
            id == anId
            deleted == false
            or{
                owner {
                    eq("id", user.id)
                }
                travellers {
                    eq("id", user.id)
                }
            }
        }.get()
    }

    List<Trip> list(Integer max = 25, Integer offset = 0 ) {
        def user = userService.currentUser
        Trip.where {
            join("travellers",  JoinType.LEFT)
            deleted == false
            or{
                eq("owner.id", user.id)
                travellers {
                    eq("id", user.id)
                }
            }
        }.list([max:max, offset:offset])
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

    Trip copy(Trip trip){
        def newTrip = trip.duplicate()
        newTrip.save()
        return newTrip
    }

    Trip addTraveller(Trip trip, User user){
        trip.addTraveller(user)
        trip.save()
        return trip
    }

    Trip removeTraveller(Trip trip, User user){
        if(trip.owner != userService.currentUser){
            throw ServiceException.badRequest("invalidUser")
        }
        trip.removeTraveller(user)
        trip.save()
        return trip
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
