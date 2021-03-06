package ar.com.mytrips

import ar.com.mytrips.auth.User
import ar.com.mytrips.destination.Country
import ar.com.mytrips.destination.Destination
import ar.com.mytrips.destination.Place
import ar.com.mytrips.exception.ServiceException

import java.time.LocalDate
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit

class Trip {

    String id
    Boolean deleted = false
    String image
    LocalDateTime lastUpdated = LocalDateTime.now()
    Set<User> travellers = []
    Boolean isPublic = false

    static belongsTo = [owner: User]
    static hasMany = [destinations: Destination, travellers:User]

    static constraints = {
        deleted nullable: false
        image nullable: true
        lastUpdated nullable: true
        travellers nullable: true
    }

    static mapping = {
        id generator: 'uuid'
        destinations sort: 'relevance', cascade: 'all-delete-orphan'
        owner cascade: 'all'
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

    def addTraveller(User user) {
        if(user == owner || travellers.contains(user)){
            throw ServiceException.badRequest("invalidTraveller")
        }
        addToTravellers(user)
    }

    def removeTraveller(User user) {
        if(!travellers.contains(user)) {
            throw ServiceException.badRequest("invalidTraveller")
        }
        removeFromTravellers(user)
    }

    Trip duplicate(){
        def trip = new Trip(owner: owner, image: image)
        trip.addDestinations(destinations.collect { it.duplicate()})
        trip
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

    Boolean isNotLastDestination(Destination destination) {
        def positionLast = destinations.size() - 1
        destination.relevance !== positionLast
    }

    Set<Country> getCountries() {
        return destinationsWithoutOrigin*.place*.country.toSet()
    }

    Set<Place> getPlaces() {
        return destinationsWithoutOrigin*.place.toSet()
    }
    
    def beforeInsert() {
        changeLastUpdated()
    }
    def beforeUpdate() {
        changeLastUpdated()
    }

    def changeLastUpdated() {
        lastUpdated = LocalDateTime.now()
        save()
    }
}
