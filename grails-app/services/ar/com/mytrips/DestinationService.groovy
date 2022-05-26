package ar.com.mytrips

import ar.com.mytrips.destination.Day
import ar.com.mytrips.destination.Destination
import grails.gorm.services.Service
import javax.transaction.Transactional

@Service(Destination)
@Transactional
class DestinationService {

    def plusDay(Destination destination, Trip trip) {
        def days = 1

        if(destination.relevance !== trip.destinations.size() - 1){
            Destination destinNext = destination.departTransport.destination
            if (!(destinNext.days.size() === 1)) {
                destination.departDate = destination.departDate.plusDays(days)
                def lastDay = destination.days[destination.days.size() - 1]
                def dayNew = new Day(date: lastDay.date.plusDays(days), itinerary: [], destination: destination)
                destination.days.add(dayNew)
                destinNext.arriveDate = destinNext.arriveDate.plusDays(days)
                def firstDay = destinNext.days[0]
                destinNext.days.remove(firstDay)
                destinNext.save()
            }
        } else {
            destination.departDate = destination.departDate.plusDays(days)
            destination.departTransport.destination?.arriveDate = destination.departTransport.destination?.arriveDate?.plusDays(days)
            def lastDay = destination.days[destination.days.size() - 1]
            def dayNew = new Day(date: lastDay.date.plusDays(days), itinerary: [], destination: destination)
            destination.days.add(dayNew)
        }
        trip.save()
        destination.save(flush:true)
    }

    def minusDay(Destination destination, Trip trip) {
        def days = 1
        if (!(destination.days.size() === 1)){
            destination.departDate = destination.departDate.minusDays(days)
            if(destination.relevance !== trip.destinations.size() - 1) {
                def lastDay = destination.days[destination.days.size() - 1]
                destination.days.remove(lastDay)
                def destinNext = destination.departTransport.destination
                destinNext.arriveDate = destinNext.arriveDate.minusDays(days)

                def firstDay = destinNext.days[0]
                def dayNew = new Day(date: firstDay.date.minusDays(days), itinerary: [], destination: destinNext)
                destinNext.days.add(0, dayNew)
            } else {
                destination.departTransport.destination?.departDate = destination.departTransport.destination?.departDate?.minusDays(days)
                def lastDay = destination.days[destination.days.size() - 1]
                destination.days.remove(lastDay)
            }
        }
        trip.save()
        destination.save(flush:true)
    }
}
