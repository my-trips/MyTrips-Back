package ar.com.mytrips

import ar.com.mytrips.destination.Destination
import ar.com.mytrips.destination.Stay
import javax.transaction.Transactional

@Transactional
class StayService {

    Stay create(Trip trip, Destination destination, Stay stay) {
        destination.addStay(stay)
        trip.changeLastUpdated()
        stay.save()
    }
}
