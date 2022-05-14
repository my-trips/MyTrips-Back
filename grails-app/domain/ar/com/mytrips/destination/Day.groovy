package ar.com.mytrips.destination

import java.time.LocalDate

class Day {

    String id
    LocalDate date

    static belongsTo = [destination:Destination]

    static hasMany = [itinerary: Itinerary]
    static mapping = {
        id generator: 'uuid'
    }
}
