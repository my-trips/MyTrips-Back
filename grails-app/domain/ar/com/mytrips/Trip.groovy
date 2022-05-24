package ar.com.mytrips

import ar.com.mytrips.destination.Destination

import java.time.temporal.ChronoUnit

class Trip {

    Integer totalDays
    String id
    OriginDestination startDestination
    OriginDestination endDestination
    Boolean deleted = false

    static hasMany = [destinations: Destination]

    static constraints = {
        startDestination nullable: true
        endDestination nullable: true
        deleted nullable: false
    }

    static mapping = {
        id generator: 'uuid'
        startDestination cascade: 'all-delete-orphan'
        endDestination cascade: 'all-delete-orphan'
        destinations sort: 'relevance', cascade: 'all-delete-orphan'
    }
    static mappedBy = [destinations: 'trip']


    def Trip(OriginDestination startDestination, OriginDestination endDestination){
        this.startDestination = startDestination
        this.endDestination = endDestination
        totalDays = startDestination.date.until(endDestination.date, ChronoUnit.DAYS).toInteger()
    }

    Map<Currency, Cost> getTotalCost(){
        Map<Currency, Cost> cost = [:]
        startDestination.transport?.cost?.accumulate(cost)
        destinations.each {it.addCost(cost) }
        cost
    }
}
