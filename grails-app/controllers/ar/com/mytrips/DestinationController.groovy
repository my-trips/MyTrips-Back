package ar.com.mytrips

import ar.com.mytrips.destination.Destination
import grails.gorm.transactions.Transactional
import grails.plugin.springsecurity.annotation.Secured

@Transactional
@Secured("ROLE_USER")
class DestinationController implements ModelRequestResolver {

    DestinationService destinationService
    TripService tripService

    def plusDay(String tripId, String destinationId) {
        def trip = assertExistence(tripService.get(tripId), "tripNotFound")
        def destination = assertExistence(Destination.findByIdAndTrip(destinationId, trip), "El destino no existe")
        destinationService.plusDay(destination, trip)
        respond  trip, view: '/trip/show'
    }

    def minusDay(String tripId, String destinationId) {
        def trip = assertExistence(tripService.get(tripId), "tripNotFound")
        def destination = assertExistence(Destination.findByIdAndTrip(destinationId, trip), "El destino no existe")
        destinationService.minusDay(destination, trip)
        respond  trip, view: '/trip/show'
    }
}
