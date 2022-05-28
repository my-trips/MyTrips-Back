package ar.com.mytrips

import ar.com.mytrips.destination.Day
import ar.com.mytrips.destination.Destination
import ar.com.mytrips.destination.Itinerary
import grails.gorm.transactions.Transactional
import grails.plugin.springsecurity.annotation.Secured

@Transactional
@Secured("ROLE_USER")
class ItineraryController implements ModelRequestResolver {

    ItineraryService itineraryService
    TripService tripService

    def delete(String tripId, String destinationId, String dayId, String id) {
        def trip = assertExistence(tripService.get(tripId), "El trip no existe")
        def destination = assertExistence(Destination.findByIdAndTrip(destinationId, trip), "La destino no existe")
        def day = assertExistence(Day.findByIdAndDestination(dayId, destination), "El day no existe")
        def itinerary = assertExistence(Itinerary.findById(id), "El itinerario no existe")
        def transport = itineraryService.delete(trip, day, itinerary)
        respond  transport, view: 'show'
    }

}
