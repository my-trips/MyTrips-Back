package ar.com.mytrips

import ar.com.mytrips.destination.Destination
import ar.com.mytrips.destination.Stay
import ar.com.mytrips.request.StayCommand
import grails.converters.JSON
import grails.gorm.transactions.Transactional
import grails.plugin.springsecurity.annotation.Secured

@Transactional
@Secured("ROLE_USER")
class StayController implements ModelRequestResolver {

    StayService stayService
    TripService tripService

    def save(String tripId, String destinationId) {
        def trip = assertExistence(tripService.get(tripId), "tripNotFound")
        def destination = assertExistence(Destination.findByIdAndTrip(destinationId, trip), "destinationNotFound")

        def request = getBody(StayCommand)
        def stay = stayService.create(trip, destination, request.toModel())
        respond  stay, view: 'show'
    }

    def update(String tripId, String destinationId, String stayId) {
        def trip = assertExistence(tripService.get(tripId), "tripNotFound")
        def destination = assertExistence(Destination.findByIdAndTrip(destinationId, trip), "destinationNotFound")
        def stay = assertExistence(Stay.findByIdAndDestination(stayId, destination), "stayNotFound")

        def request = getBody(StayCommand)
        stayService.update(trip, stay, request)
        respond  stay, view: 'show'
    }

    def delete(String tripId, String destinationId, String stayId) {
        def trip = assertExistence(tripService.get(tripId), "tripNotFound")
        def destination = assertExistence(Destination.findByIdAndTrip(destinationId, trip), "destinationNotFound")
        def stay = assertExistence(Stay.findByIdAndDestination(stayId, destination), "stayNotFound")

        stayService.delete(trip, destination, stay)
        render(contentType: "application/json", text: [:] as JSON)
    }
}
