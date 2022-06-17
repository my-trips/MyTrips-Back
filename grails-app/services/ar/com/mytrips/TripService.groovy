package ar.com.mytrips

import ar.com.mytrips.auth.User
import ar.com.mytrips.destination.Attraction
import ar.com.mytrips.destination.Destination
import ar.com.mytrips.destination.Place
import ar.com.mytrips.exception.ServiceException
import ar.com.mytrips.external.TriposoService
import ar.com.mytrips.external.UnsplashService
import grails.events.annotation.Publisher
import grails.events.annotation.Subscriber
import grails.gorm.DetachedCriteria
import grails.gorm.services.Service

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
        getTripCriteria(user).where {
            eq("id", anId)
        }.get()
    }

    Trip getPublic(String anId) {
        def user = userService.currentUser
        getPublicTripCriteria(user, anId).get()
    }

    List<Trip> list(Integer max = 25, Integer offset = 0 ) {
        def user = userService.currentUser
        getTripCriteria(user).list([max:max, offset:offset])
    }

    List<Trip> publicTripsInDestination(String destinationName, Integer max , Integer offset ) {
        def user = userService.currentUser
        return Trip.where {
            deleted == false
            isPublic == true
            owner != user
            destinations {
                place {
                    name == destinationName
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
        fetchPlaceData(trip)
        trip
    }

    Trip copy(Trip trip){
        def newTrip = trip.duplicate()
        newTrip.save()
        return newTrip
    }

    Trip addTraveller(Trip trip, User user){
        validateOwner(trip)
        trip.addTraveller(user)
        trip.save()
        return trip
    }

    Trip removeTraveller(Trip trip, User user){
        validateOwner(trip)
        trip.removeTraveller(user)
        trip.save()
        return trip
    }

    def delete(Trip trip) {
        validateOwner(trip)
        trip.deleted = true
        trip.save()
    }

    def changeVisibility(Trip trip, Boolean isVisible) {
        validateOwner(trip)
        trip.isPublic = isVisible
        trip.save()
    }

    private void validateOwner(Trip trip) {
        if (userService.currentUser != trip.owner) {
            throw ServiceException.forbidden("invalidUser")
        }
    }

    @Publisher("SuggestedItinerary")
    protected List<String> publishSuggestedItinerary(Trip trip) {
        trip.destinationsWithoutOrigin*.id
    }

    protected void fetchPlaceData(Trip trip) {
        trip.destinations*.place.forEach{
            if(it.placeId == null){
                fetchPlaceData(it)
            }
        }
    }

    @Publisher("FetchPlaceData")
    protected Map<String, String> fetchPlaceData(Place place) {
        [id: place.id, name: place.name, countryName:place.country.name]
    }

    @Subscriber("FetchPlaceData")
    def onFetchPlaceData(Map<String, String> placeData) {
        def  location = triposoService.getLocation(placeData.countryName, placeData.name)
        if (location) {
            def attractions = triposoService.getAttractions(location.id, location.name, 50, 0)
            Place.withNewTransaction {
                def place = Place.findById(placeData.id)
                place.setDataFromLocation(location)
                place.attractions = attractions.collect { Attraction.fromTriposo(place, it)}
                place.save()
            }
        }
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
            tasks.onError { Throwable err ->
                err.printStackTrace()
            }
            tasks.get()
        }

    }

    private DetachedCriteria<Trip> getTripCriteria(User user){
        Trip.where {
            join("travellers",  JoinType.LEFT)
            deleted == false
            or{

                owner {
                    eq("id", user.id)
                }
                travellers {
                    eq("id", user.id)
                }
            }
        }
    }

    private DetachedCriteria<Trip> getPublicTripCriteria(User user, String anId){
        Trip.where {
            join("travellers",  JoinType.LEFT)
            deleted == false
            id == anId
            or{
                eq("isPublic", true)
                owner {
                    eq("id", user.id)
                }
                travellers {
                    eq("id", user.id)
                }
            }
        }
    }



}
