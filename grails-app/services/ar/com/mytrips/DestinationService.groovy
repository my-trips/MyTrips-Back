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
        def transport = destination.transport

        if(destination.relevance !== trip.destinations.size() -1){
            Destination destinNext = trip.destinations[destination.relevance +1]
            if (!(destinNext.days.size() === 1)) {
                transport.depart = transport.depart.plusDays(days)
                def lastDay = destination.days[destination.days.size() - 1]
                def dayNew = new Day(date: lastDay.date.plusDays(days), itinerary: [], destination: destination)
                destination.days.add(dayNew)
                destinNext.transport.arrive = destinNext.transport.arrive.plusDays(days)
                def firstDay = destinNext.days[0]
                destinNext.days.remove(firstDay)
            }
        } else {
            transport.depart = transport.depart.plusDays(days)
            trip.endDestination.date = trip.endDestination.date.plusDays(days)
            def lastDay = destination.days[destination.days.size() - 1]
            def dayNew = new Day(date: lastDay.date.plusDays(days), itinerary: [], destination: destination)
            destination.days.add(dayNew)
        }
        trip.totalDays = trip.startDestination.date.until(trip.endDestination.date, ChronoUnit.DAYS).toInteger()
        trip.save()
        destination.save(flush:true)
    }
}
