package ar.com.mytrips

import ar.com.mytrips.destination.Destination

import javax.transaction.Transactional

@Transactional
class DestinationService {

    def plusDay(Destination destination, Trip trip) {
        def days = 1
        if(trip.isNotLastDestination(destination)) {
            def destinNext = destination.nextDestination()
            if (!(destinNext.days.size() === 1)) {
                destination.plusDay(days)
                destination.addToImages("")

                destinNext.plusDayArriveDate(days)
                destinNext.removeFirstDay()
                destinNext.addToImages("")
            }
        }else {
            destination.plusDay(days)
            destination.addToImages("")

            Destination destinNext = destination.nextDestination()
            destinNext.plusDayArriveDate(days)
            destinNext.addToImages("")
        }
        trip.changeLastUpdated()
        trip.save()
    }

    def minusDay(Destination destination, Trip trip) {
        def days = 1
        if (!(destination.days.size() === 1)){
            destination.minusDayDepartDate(days)
            if(trip.isNotLastDestination(destination)) {
                destination.removeLastDay()
                destination.addToImages("")

                def destinNext = destination.nextDestination()
                destinNext.minusDayArriveDate(days)
                destinNext.addFirstDayMinusDay()
                destinNext.addToImages("")
            } else {
                destination.removeLastDay()
                destination.addToImages("")

                Destination destinNext = destination.nextDestination()
                destinNext.minusDayArriveDate(days)
                destinNext.addToImages("")
            }
        }
        trip.changeLastUpdated()
        trip.save()
    }
}
