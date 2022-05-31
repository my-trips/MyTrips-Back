package ar.com.mytrips

import ar.com.mytrips.destination.Destination
import javax.transaction.Transactional

@Transactional
class DestinationService {

    def plusDay(Destination destination, Trip trip) {
        destination.plusDay(1)
        trip.changeLastUpdated()
        trip.save()
    }

    def minusDay(Destination destination, Trip trip) {
        destination.minusDay(1)
        trip.changeLastUpdated()
        trip.save()
    }
}
