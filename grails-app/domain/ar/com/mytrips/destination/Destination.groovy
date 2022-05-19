package ar.com.mytrips.destination


import ar.com.mytrips.Trip
import ar.com.mytrips.request.TriposoDayPlanner

import java.time.temporal.ChronoUnit

class Destination {

    String id
    Integer relevance
    Transport transport
    String color
    Place place


    static belongsTo = [trip: Trip]

    static hasMany = [images: String, days:Day]

    static mapping = {
        id generator: 'uuid'
        days sort: "date", order: "asc", cascade: 'all-delete-orphan'
    }

    static mappedBy = [days: "destination"]

    static constraints = {
        images nullable: true
    }

    static Destination create(Map params){
        def destination = new Destination(params)
        destination.generateDays()
        return destination
    }

    protected def generateDays(){
        days = (0..(transport.arrive.until(transport.depart, ChronoUnit.DAYS)-1)).collect {
            new Day(date: transport.arrive.toLocalDate().plusDays(it), destination: this)
        }
    }

    def setDataFromPlanner(TriposoDayPlanner dayPlanner, Trip trip) {
        this.trip = trip
        place.placeId = dayPlanner.location.id
        images = dayPlanner.location.images.collect{ it.sourceUrl}
        dayPlanner.days.collect {
            def day = days.find {day->  day.date == it.date}
            day?.itinerary =  it.itineraryItems.collect{Itinerary.fromTriposo(it)}
        }
    }
}
