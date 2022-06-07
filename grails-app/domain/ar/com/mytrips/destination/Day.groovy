package ar.com.mytrips.destination

import ar.com.mytrips.Cost
import ar.com.mytrips.Currency
import ar.com.mytrips.exception.ServiceException

import java.time.LocalDate


class Day {

    String id
    LocalDate date
    List<Itinerary> itinerary = []

    static belongsTo = [destination:Destination]

    static hasMany = [itinerary: Itinerary]
    static mapping = {
        id generator: 'uuid'
        itinerary cascade: 'all', sort: 'startTime'
    }

    LocalDate plusDay(Integer day) {
        date.plusDays(day)
    }
    LocalDate minusDay(Integer day) {
        date.minusDays(day)
    }

    def removeItinerary(Itinerary anItinerary){
        if(!itinerary.contains(anItinerary)){
            throw ServiceException.badRequest("invalid itinerary")
        }
        anItinerary.day = null
        removeFromItinerary(anItinerary)
        anItinerary.delete()
    }

    def addItinerary(Itinerary itinerary){
        itinerary.day = this
        addToItinerary(itinerary)
    }

    Map<Currency, Cost> addCost(Map<Currency, Cost> cost){
        itinerary.forEach{it.addCost(cost)}
        cost
    }

    Day duplicate(Destination destination){
        def day = new Day(date:date, destination:destination )
        day.itinerary = itinerary.collect{ it.duplicate(day)}
        day
    }

}
