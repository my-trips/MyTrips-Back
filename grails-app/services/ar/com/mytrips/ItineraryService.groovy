package ar.com.mytrips

import ar.com.mytrips.destination.Day
import ar.com.mytrips.destination.Itinerary
import grails.gorm.services.Service

import javax.transaction.Transactional
import java.time.LocalDateTime

@Service(Itinerary)
@Transactional
class ItineraryService {

    def delete(Trip trip, Day day, Itinerary itinerary) {
        day.removeItinerary(itinerary)
        day.save()
        trip.lastUpdated = LocalDateTime.now()
        trip.changeLastUpdated()
    }
}
