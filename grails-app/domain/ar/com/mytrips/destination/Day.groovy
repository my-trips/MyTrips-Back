package ar.com.mytrips.destination

import grails.compiler.GrailsCompileStatic

import java.time.LocalDate


@GrailsCompileStatic
class Day {

    String id
    LocalDate date

    static belongsTo = [destination:Destination]

    static hasMany = [itinerary: Itinerary]
    static mapping = {
        id generator: 'uuid'
        itinerary cascade: 'all'
    }

    LocalDate plusDay(Integer day) {
        date.plusDays(day)
    }
    LocalDate minusDay(Integer day) {
        date.minusDays(day)
    }
}
