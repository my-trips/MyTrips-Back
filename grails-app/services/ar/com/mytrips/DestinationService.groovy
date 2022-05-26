package ar.com.mytrips

import ar.com.mytrips.destination.Day
import ar.com.mytrips.destination.Destination

import grails.gorm.services.Service
import javax.transaction.Transactional
import java.time.temporal.ChronoUnit

@Service(Destination)
@Transactional
class DestinationService {

    def update(Destination destination, Trip trip) {
        def days = 1

        if(destination.relevance !== trip.destinations.size() -1){
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
}
