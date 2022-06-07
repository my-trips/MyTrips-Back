package ar.com.mytrips

import ar.com.mytrips.destination.Day
import ar.com.mytrips.destination.Stay
import javax.transaction.Transactional

@Transactional
class StayService {

    Stay create(Trip trip, Day day, Stay stay) {
        day.addStay(stay)
        trip.changeLastUpdated()
        stay.save()
    }
}
