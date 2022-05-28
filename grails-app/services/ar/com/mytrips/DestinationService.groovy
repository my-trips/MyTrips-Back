package ar.com.mytrips

import ar.com.mytrips.destination.Destination
import grails.gorm.services.Service
import javax.transaction.Transactional

@Service(Destination)
@Transactional
class DestinationService {

    def plusDay(Destination destination, Trip trip) {
        def days = 1
        if(destination.relevance !== trip.destinations.size() - 1) {
            def destinNext = destination.nextDestination()
            if (!(destinNext.days.size() === 1)) {
                destination.plusDay(days)
                destination.addToImages("")

                destinNext.plusDayArriveDate(days)
                destinNext.removeFirstDay()
                destinNext.addToImages("")
                destinNext.save()
            }
        }else {
            destination.plusDay(days)
            destination.addToImages("")

            Destination destinNext = destination.nextDestination()
            destinNext.plusDayArriveDate(days)
            destinNext.addToImages("")
            destinNext.save()
        }
        trip.save()
        destination.save(flush:true)
    }

    def minusDay(Destination destination, Trip trip) {
        def days = 1
        if (!(destination.days.size() === 1)){
            destination.minusDayDepartDate(days)
            if(destination.relevance !== trip.destinations.size() - 1) {
                destination.removeLastDay()
                destination.addToImages("")

                def destinNext = destination.nextDestination()
                destinNext.minusDayArriveDate(days)
                destinNext.addFirstDayMinusDay()
                destinNext.addToImages("")
                destinNext.save()
            } else {
                destination.removeLastDay()
                destination.addToImages("")

                Destination destinNext = destination.nextDestination()
                destinNext.minusDayArriveDate(days)
                destinNext.addToImages("")
                destinNext.save()
            }
        }
        trip.save()
        destination.save(flush:true)
    }
}
