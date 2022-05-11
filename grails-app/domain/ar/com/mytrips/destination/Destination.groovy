package ar.com.mytrips.destination

import ar.com.mytrips.TransportType
import ar.com.mytrips.Trip
import ar.com.mytrips.request.TriposoDayPlanner

import java.time.LocalDateTime

class Destination {

    String id
    Integer relevance
    TransportType transport
    LocalDateTime depart
    LocalDateTime arrive
    String color
    Place place

    static belongsTo = [trip: Trip]

    static hasMany = [images: String, days:Day]

    static mapping = {
        id generator: 'uuid'
    }

    static constraints = {
        images nullable: true
    }

    def setDataFromPanner(TriposoDayPlanner dayPlanner, Trip trip) {
        this.trip = trip
        place.placeId = dayPlanner.location.id
        images = dayPlanner.location.images.collect{ it.sourceUrl}
        days = dayPlanner.days.collect {
            new Day(date: it.date, itinerary: it.itineraryItems.collect{Itinerary.fromTriposo(it)})
        }
    }
}
