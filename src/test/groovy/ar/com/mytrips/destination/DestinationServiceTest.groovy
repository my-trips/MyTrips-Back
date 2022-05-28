package ar.com.mytrips.destination

import ar.com.mytrips.DestinationService
import ar.com.mytrips.Trip
import ar.com.mytrips.auth.User
import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification
import java.time.LocalDate
import java.time.LocalDateTime

class DestinationServiceTest  extends Specification implements DomainUnitTest<Trip> {

    private DestinationService destinationService
    private Destination destination
    private Destination destinationNext
    private Trip trip

    def setup() {
        destinationService = new DestinationService()
    }

    def cleanup() {
    }

    def "when the trip plus a day to one of its destinations, it should return the updated destination"() {
        given:

        def destFin = new Destination(id: 4, relevance: 1, color: "green", place: new Place(),
                arriveDate: LocalDateTime.of(2020, 10, 14, 12, 50, 00), departDate: null,
                departTransport: new Transport(), days: []
        )

        def destSantiago = new Destination(id: 3, relevance: 1, color: "green", place: new Place(),
                arriveDate: LocalDateTime.of(2020, 10, 12, 12, 50, 00), departDate: LocalDateTime.of(2020, 10, 14, 12, 50, 00),
                departTransport: new Transport(destination: destFin), days: [
                new Day(date: LocalDate.of(2020, 10, 12), itinerary: [], destination: this),
                new Day(date: LocalDate.of(2020, 10, 13), itinerary: [], destination: this) ])

        def destLima = new Destination(id: 2, relevance: 1, color: "yellow", place: new Place(),
                arriveDate: LocalDateTime.of(2020, 10, 10, 12, 50, 00), departDate: LocalDateTime.of(2020, 10, 12, 12, 50, 00),
                departTransport: new Transport(destination: destSantiago), days: [
                new Day(date: LocalDate.of(2020, 10, 10), itinerary: [], destination: this),
                new Day(date: LocalDate.of(2020, 10, 11), itinerary: [], destination: this) ])

        def destInit = new Destination(id: 1, relevance: 1, color: "yellow", place: new Place(),
                arriveDate: null, departDate: LocalDateTime.of(2020, 10, 10, 12, 50, 00),
                departTransport: new Transport(destination: destLima), days: [])

        trip = new Trip(id: 1, deleted: false, owner: new User(), image: "image", lastUpdated:
                LocalDateTime.now(), destinations: [destInit, destLima, destSantiago, destFin])

        destination = destLima
        destinationNext = destSantiago

        when:
        destinationService.plusDay(destination, trip)

        then:
        destination.getDays().size() > 2
        destinationNext.getDays().size() == 1
    }

    def "when the trip minus a day to one of its destinations, it should return the updated destination"() {
        given:

        def destFin = new Destination(id: 4, relevance: 1, color: "green", place: new Place(),
                arriveDate: LocalDateTime.of(2020, 10, 14, 12, 50, 00), departDate: null,
                departTransport: new Transport(), days: [])

        def destSantiago = new Destination(id: 3, relevance: 1, color: "green", place: new Place(),
                arriveDate: LocalDateTime.of(2020, 10, 12, 12, 50, 00), departDate: LocalDateTime.of(2020, 10, 14, 12, 50, 00),
                departTransport: new Transport(destination: destFin), days: [
                new Day(date: LocalDate.of(2020, 10, 12), itinerary: [], destination: this),
                new Day(date: LocalDate.of(2020, 10, 13), itinerary: [], destination: this) ])

        def destLima = new Destination(id: 2, relevance: 1, color: "yellow", place: new Place(),
                arriveDate: LocalDateTime.of(2020, 10, 10, 12, 50, 00), departDate: LocalDateTime.of(2020, 10, 12, 12, 50, 00),
                departTransport: new Transport(destination: destSantiago), days: [
                new Day(date: LocalDate.of(2020, 10, 10), itinerary: [], destination: this),
                new Day(date: LocalDate.of(2020, 10, 11), itinerary: [], destination: this) ])

        def destInit = new Destination(id: 1, relevance: 1, color: "yellow", place: new Place(),
                arriveDate: null, departDate: LocalDateTime.of(2020, 10, 10, 12, 50, 00),
                departTransport: new Transport(destination: destLima), days: [])

        trip = new Trip(id: 1, deleted: false, owner: new User(), image: "image", lastUpdated:
                LocalDateTime.now(), destinations: [destInit, destLima, destSantiago, destFin])

        destination = destLima
        destinationNext = destSantiago

        when:
        destinationService.minusDay(destination, trip)

        then:
        destination.getDays().size() == 1
        destinationNext.getDays().size() > 2
    }
}
