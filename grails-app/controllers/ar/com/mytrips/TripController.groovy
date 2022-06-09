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
        def trip = assertExistence(tripService.get(id), "El trip no existe")
        respond  trip, view: 'show'
    }

    def delete(String id) {
        def trip = assertExistence(tripService.get(id), "El trip no existe")
        tripService.delete(trip)
        render(contentType: "application/json", text: [:] as JSON)
    }

    def save() {
        def request = getBody(CreateTripRequest)
        def trip = tripService.create(request.toModel())
        respond  trip, view: 'show'
    }

    def copy(String id) {
        def trip = assertExistence(tripService.get(id), "El trip no existe")
        def newTrip = tripService.copy(trip)
        respond  newTrip, view: 'show'
    }

    def addCollaborator(String id, String userId) {
        def trip = assertExistence(tripService.get(id), "invalidTrip")
        def collaborator = assertExistence(userService.get(userId), "invalidCollaborator")
        def newTrip = tripService.addCollaborator(trip, collaborator)
        respond  newTrip, view: 'show'
    }

    def removeCollaborator(String id, String userId) {
        def trip = assertExistence(tripService.get(id), "invalidTrip")
        def collaborator = assertExistence(userService.get(userId), "invalidCollaborator")
        def newTrip = tripService.removeCollaborator(trip, collaborator)
        respond  newTrip, view: 'show'
    }
}
