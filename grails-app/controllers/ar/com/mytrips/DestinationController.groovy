package ar.com.mytrips

import ar.com.mytrips.destination.Destination
import grails.gorm.transactions.Transactional
import grails.plugin.springsecurity.annotation.Secured

@Transactional
@Secured("ROLE_USER")
class DestinationController implements ModelRequestResolver {

    DestinationService destinationService
    TripService tripService

    def update(String tripId, String destinationId) {
        def trip = assertExistence(tripService.get(tripId), "El trip no existe")
        def destination = assertExistence(Destination.findByIdAndTrip(destinationId, trip), "El destino no existe")
        destinationService.update(destination, trip)
        respond  trip, view: '/trip/show'
    }
}
