package ar.com.mytrips

import ar.com.mytrips.destination.Destination
import ar.com.mytrips.destination.Stay
import ar.com.mytrips.request.StayCommand
import javax.transaction.Transactional

@Transactional
class StayService {

    Stay create(Trip trip, Destination destination, Stay stay) {
        destination.addStay(stay)
        trip.changeLastUpdated()
        stay.save()
    }

    def update(Trip trip, Stay stay, StayCommand command) {
        stay.properties = command.changes()
        trip.changeLastUpdated()
        stay.save()
    }
}
