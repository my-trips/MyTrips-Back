package ar.com.mytrips

import ar.com.mytrips.destination.Destination
import ar.com.mytrips.request.TransportCommand
import grails.gorm.transactions.Transactional
import grails.plugin.springsecurity.annotation.Secured

@Transactional
@Secured("ROLE_USER")
class TransportController implements ModelRequestResolver {

    TransportService transportService
    TripService tripService

    def update(String tripId, String destinationId) {
        def trip = assertExistence(tripService.get(tripId), "tripNotFound")
        def destination = assertExistence(Destination.findByIdAndTrip(destinationId, trip), "La destino no existe")
        def request = getBody(TransportCommand)
        def transport = transportService.update(trip, destination.departTransport, request)
        respond  transport, view: 'show'
    }

}
