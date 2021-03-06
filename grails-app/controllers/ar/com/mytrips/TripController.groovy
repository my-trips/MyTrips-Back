package ar.com.mytrips

import ar.com.mytrips.request.CreateTripRequest
import grails.converters.JSON
import grails.gorm.transactions.Transactional
import grails.plugin.springsecurity.annotation.Secured

@Transactional
@Secured("ROLE_USER")
class TripController implements ModelRequestResolver {

    TripService tripService
    UserService userService

    def list(Integer max, Integer offset) {
        def trips = tripService.list(max, offset)
        respond  trips, view: 'index'
    }

    def get(String id) {
        def trip = assertExistence(tripService.getPublic(id), "tripNotFound")
        respond  trip, view: 'show'
    }

    def delete(String id) {
        def trip = assertExistence(tripService.get(id), "tripNotFound")
        tripService.delete(trip)
        render(contentType: "application/json", text: [:] as JSON)
    }

    def save() {
        def request = getBody(CreateTripRequest)
        def trip = tripService.create(request.toModel())
        respond  trip, view: 'show'
    }

    def copy(String id) {
        def trip = assertExistence(tripService.getPublic(id), "tripNotFound")
        def newTrip = tripService.copy(trip)
        respond  newTrip, view: 'show'
    }

    def addTraveller(String id, String email) {
        def trip = assertExistence(tripService.get(id), "tripNotFound")
        def traveller = assertExistence(userService.getByEmail(email), "userNotFound")
        def newTrip = tripService.addTraveller(trip, traveller)
        respond  newTrip, view: 'show'
    }

    def removeTraveller(String id, String userId) {
        def trip = assertExistence(tripService.get(id), "tripNotFound")
        def traveller = assertExistence(userService.get(userId), "userNotFound")
        def newTrip = tripService.removeTraveller(trip, traveller)
        respond  newTrip, view: 'show'
    }

    def changeVisibility(String id) {
        def trip = assertExistence(tripService.get(id), "tripNotFound")
        tripService.changeVisibility(trip, !trip.isPublic)
        respond  trip, view: 'show'
    }

    @Secured("IS_AUTHENTICATED_ANONYMOUSLY")
    def publicTripsInDestination(String destinationName, Integer max, Integer offset){
        def trips = tripService.publicTripsInDestination(destinationName, max?:25, offset?:0)
        respond  trips, view: 'index'
    }

    @Secured("IS_AUTHENTICATED_ANONYMOUSLY")
    def plan(String id){
        def trip = Trip.get(id)
        tripService.publishSuggestedItinerary(trip)
        respond  trip, view: 'index'
    }

}
