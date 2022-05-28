package ar.com.mytrips

import ar.com.mytrips.auth.User
import ar.com.mytrips.destination.Destination

import java.time.LocalDate
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit

class Trip {

    String id
    Boolean deleted = false
    User owner
    String image
    LocalDateTime lastUpdated

    static hasMany = [destinations: Destination]

    static constraints = {
        deleted nullable: false
        image nullable: true
        lastUpdated nullable: true
    }

    static mapping = {
        id generator: 'uuid'
        destinations sort: 'relevance', cascade: 'all-delete-orphan'
    }
    static mappedBy = [destinations: 'trip']


    def addDestinations(List<Destination> destinations){
        Destination prevDestination = null
        destinations.forEach{
            it.trip = this
            if(prevDestination){
                prevDestination.departTransport?.destination = it
            }
            prevDestination = it
        }

        this.destinations = destinations
    }

    Integer getTotalDays(){
        startDate.until(endDate, ChronoUnit.DAYS).toInteger()
    }

    LocalDate getStartDate(){
        destinations.find{ it.relevance== 1}?.departDate?.toLocalDate()
    }

    LocalDate getEndDate(){
        destinations.max { it.relevance}?.arriveDate?.toLocalDate()
    }

    Destination getFirstDestination(){
        destinationsWithoutOrigin.first()
    }

    Set<Destination> getDestinationsWithoutOrigin(){
        def totalDestinations = destinations.size()
        destinations.findAll {it.relevance > 1 && it.relevance < totalDestinations }
    }

    Map<Currency, Cost> getTotalCost(){
        Map<Currency, Cost> cost = [:]
        destinations.each {it.addCost(cost) }
        cost
    }

    def beforeInsert() {
        changeLastUpdated()
    }
    def beforeUpdate() {
        changeLastUpdated()
    }

    def changeLastUpdated() {
        lastUpdated = LocalDateTime.now()
    }
}
