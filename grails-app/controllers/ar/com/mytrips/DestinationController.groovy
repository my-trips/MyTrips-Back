package ar.com.mytrips

import ar.com.mytrips.destination.Destination
import grails.gorm.transactions.Transactional

@Transactional
class DestinationController implements ModelRequestResolver {

    DestinationService destinationService

    def update(String tripId, String destinationId) {
        def trip = Trip.get(tripId)
        def destination = Destination.findByIdAndTrip(destinationId, trip)
        destinationService.update(destination, trip)
        respond  trip, view: '/trip/show'
    }
}
