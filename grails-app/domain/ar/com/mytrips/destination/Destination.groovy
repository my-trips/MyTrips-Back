package ar.com.mytrips.destination

import ar.com.mytrips.Cost
import ar.com.mytrips.Currency
import ar.com.mytrips.Trip
import ar.com.mytrips.request.TriposoDay
import ar.com.mytrips.request.TriposoDayPlanner
import grails.compiler.GrailsCompileStatic

import java.time.LocalDateTime
import java.time.temporal.ChronoUnit

@GrailsCompileStatic
class Destination {

    String id
    Integer relevance
    String color
    Place place
    LocalDateTime arriveDate
    LocalDateTime departDate
    Transport departTransport
    List<Day> days

    static belongsTo = [trip: Trip]

    static hasMany = [images: String, days:Day]

    static mapping = {
        id generator: 'uuid'
        days sort: "date", order: "asc", cascade: 'all-delete-orphan'
        departTransport cascade: 'all-delete-orphan'
        images joinTable:[name:'destination_images', key:'destination_id', column:'image', type:"text"]
    }

    static mappedBy = [days: "destination", departTransport: "origin"]

    static constraints = {
        images nullable: true
        departTransport nullable: true
        arriveDate nullable: true
        departDate nullable: true
        color nullable: true
    }

    static Destination create(Map params){
        def destination = new Destination(params)
        destination.departTransport?.origin = destination
        destination.generateDays()
        return destination
    }

    protected def generateDays(){
        if(arriveDate && departDate){
            days = (0..(arriveDate.until(departDate, ChronoUnit.DAYS)-1)).collect {
                new Day(date: arriveDate.toLocalDate().plusDays(it), destination: this)
            }
        }
    }

    def setDataFromPlanner(TriposoDayPlanner dayPlanner, Trip trip) {
        this.trip = trip
        place.placeId = dayPlanner.location.id
        images = dayPlanner.location.images.collect{ it.sourceUrl}.toSet()
        dayPlanner.days.collect { TriposoDay it ->
            def day = days.find {day->  day.date == it.date}
            day?.itinerary =  it.itineraryItems.collect{Itinerary.fromTriposo(it)}.toSet()
        }
    }

    Map<Currency, Cost> addCost(Map<Currency, Cost> cost){
        departTransport?.cost?.accumulate(cost)
        cost
    }
}
