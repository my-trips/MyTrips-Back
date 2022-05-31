package ar.com.mytrips

import ar.com.mytrips.destination.Day
import ar.com.mytrips.destination.Destination
import ar.com.mytrips.destination.Itinerary
import ar.com.mytrips.request.ItineraryCommand
import grails.converters.JSON
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
        itineraryService.delete(trip, day, itinerary)
        render(contentType: "application/json", text: [:] as JSON)
    }


    def update(String tripId, String destinationId, String dayId, String id) {
        def trip = assertExistence(tripService.get(tripId), "El trip no existe")
        def destination = assertExistence(Destination.findByIdAndTrip(destinationId, trip), "La destino no existe")
        def day = assertExistence(Day.findByIdAndDestination(dayId, destination), "El day no existe")
        def itinerary = assertExistence(Itinerary.findByIdAndDay(id, day), "El itinerario no existe")

        def request = getBody(ItineraryCommand)
        itineraryService.update(trip, itinerary, request)
        respond  itinerary, view: 'show'
    }

    def save(String tripId, String destinationId, String dayId) {
        def trip = assertExistence(tripService.get(tripId), "El trip no existe")
        def destination = assertExistence(Destination.findByIdAndTrip(destinationId, trip), "La destino no existe")
        def day = assertExistence(Day.findByIdAndDestination(dayId, destination), "El day no existe")

        def request = getBody(ItineraryCommand)
        def itinerary = itineraryService.create(trip, day, request.toModel())
        respond  itinerary, view: 'show'
    }


}
