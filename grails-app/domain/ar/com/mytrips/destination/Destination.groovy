package ar.com.mytrips.destination

import ar.com.mytrips.Cost
import ar.com.mytrips.Currency
import ar.com.mytrips.Trip
import ar.com.mytrips.exception.ServiceException
import ar.com.mytrips.request.TriposoDay
import ar.com.mytrips.request.TriposoDayPlanner

import java.time.LocalDateTime
import java.time.temporal.ChronoUnit

class Destination {

    String id
    Integer relevance
    String color
    Place place
    LocalDateTime arriveDate
    LocalDateTime departDate
    Transport departTransport
    List<Day> days = []

    static belongsTo = [trip: Trip]

    static hasMany = [images: String, days:Day]

    static mapping = {
        id generator: 'uuid'
        days sort: "date", order: "asc", cascade: 'all'
        departTransport cascade: 'all'
        images cascade: "all", joinTable:[name:'destination_images', key:'destination_id', column:'image', type:"text"]
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

    def plusDay(Integer days) {
        def safeDays = days
        def destinNext = nextDestination()

        if (destinNext.days.size() === 1) {
            throw ServiceException.badRequest("daysCannotBeEmpty")
        }

        if(trip.isNotLastDestination(this)) {
            safeDays = Math.min(destinNext.days.size()-1, days)
            destinNext.removeFirstNDay(safeDays)
        }

        plusDayDepartDate(safeDays)
        addToLastDay(safeDays)
        destinNext.plusDayArriveDate(days)
    }

    def minusDay(Integer days) {
        if (this.days.size() <= 1){
            throw ServiceException.badRequest("daysCannotBeEmpty")
        }
        minusDayDepartDate(days)
        removeLastNDay(days)
        def destinNext = nextDestination()
        destinNext.minusDayArriveDate(days)

        if(trip.isNotLastDestination(this)) {
            destinNext.addToFirstDay(days)
        }
    }

    def updateArriveDate(LocalDateTime newDate){
        if(arriveDate.dayOfMonth < newDate.dayOfMonth){
            removeFirstNDay(1)
        }else if(arriveDate.dayOfMonth > newDate.dayOfMonth){
            addToFirstDay()
        }
        arriveDate = newDate
    }

    Destination duplicate(){
        def destination = new Destination(relevance: relevance, color: color, arriveDate: arriveDate, departDate: departDate, images: images.toList())
        destination.place = place.duplicate(destination)
        destination.departTransport = departTransport?.duplicate(destination)
        destination.days = days.collect{it.duplicate(destination)}
        destination
    }

    Destination nextDestination() {
      departTransport.destination
    }

    def plusDayDepartDate(Integer day) {
        departDate = departDate.plusDays(day)
    }

    def minusDayDepartDate(Integer day) {
        departDate = departDate.minusDays(day)
    }

    def minusDayArriveDate(Integer day) {
        arriveDate = arriveDate.minusDays(day)
    }

    def plusDayArriveDate(Integer day) {
        arriveDate = arriveDate.plusDays(day)
    }

    Day getLastDay() {
        this.days.last()
    }

    Day getFirstDay() {
        this.days.first()
    }

    def removeFirstNDay(Integer n) {
        days.take(n).forEach{ day ->
            removeDay(day)
        }
    }

    def removeLastNDay(Integer n){
        days.takeRight(n).forEach{ day ->
            removeDay(day)
        }
    }

    def removeDay(Day day){
        removeFromDays(day)
        day.delete()
    }

    def addToLastDay(Integer n=1) {
        (1..n).each {
            addToDays(new Day(date: lastDay.plusDay(1), itinerary: [], destination: this))
        }
    }

    def addToFirstDay(Integer n = 1) {
        (1..n).each {
            this.days.add(0, new Day(date: firstDay.minusDay(1), itinerary: [], destination: this))
        }
    }

    protected def generateDays(){
        if(arriveDate && departDate){
            days = (0..(arriveDate.until(departDate, ChronoUnit.DAYS)-1)).collect {
                new Day(date: arriveDate.toLocalDate().plusDays(it), destination: this)
            }
        }
    }

    def setDataFromPlanner(TriposoDayPlanner dayPlanner) {
        place.placeId = dayPlanner.location.id
        images = dayPlanner.location.images.collect{ it.sourceUrl}.toSet()
        dayPlanner.days.collect { TriposoDay it ->
            def day = days.find {day->  day.date == it.date}
            day?.itinerary =  it.itineraryItems.collect{Itinerary.fromTriposo(it, day)}
        }
    }

    Map<Currency, Cost> addCost(Map<Currency, Cost> cost){
        departTransport?.cost?.accumulate(cost)
        days.forEach {    it.addCost(cost)}
        cost
    }
}
