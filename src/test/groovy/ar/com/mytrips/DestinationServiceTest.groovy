package ar.com.mytrips

import ar.com.mytrips.auth.User
import ar.com.mytrips.destination.Destination
import ar.com.mytrips.destination.Place
import ar.com.mytrips.destination.Transport
import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

import java.time.LocalDateTime

class DestinationServiceTest extends Specification implements DomainUnitTest<Destination> {

    private DestinationService destinationService
    private List<Destination> destinations
    private Trip trip

    def setup() {
        destinationService = new DestinationService()

        def destFin = new Destination(relevance: 4, color: "green", place: new Place(),
                arriveDate: LocalDateTime.of(2020, 10, 14, 12, 50, 00),
                departDate: null,
                departTransport: new Transport(), days: [])

        def paramsDestSantiago = HashMap.of("relevance", 3,
                "color", "green", "place", new Place(),
                "arriveDate", LocalDateTime.of(2022, 10, 12, 12, 50, 00),
                "departDate", LocalDateTime.of(2022, 10, 14, 12, 50, 00),
                "departTransport", new Transport(destination: destFin))

        def destSantiago = Destination.create(paramsDestSantiago)

        def paramsDestLima = HashMap.of("relevance", 2,
                "color", "yellow", "place", new Place(),
                "arriveDate", LocalDateTime.of(2022, 10, 10, 12, 50, 00),
                "departDate",LocalDateTime.of(2022, 10, 12, 12, 50, 00),
                "departTransport", new Transport(destination: destSantiago))

        def destLima = Destination.create(paramsDestLima)

        def paramsInit = HashMap.of("relevance", 1,
                "color", "", "place", new Place(),
                "departDate", LocalDateTime.of(2020, 10, 10, 12, 50, 00),
                "departTransport", new Transport(destination: destLima))

        def destInit = Destination.create(paramsInit)

        destinations = [destInit, destLima, destSantiago, destFin]

        trip = new Trip(deleted: false, owner: new User(), image: "image", lastUpdated: LocalDateTime.now())
        trip.addDestinations(destinations)
    }

    def cleanup() {
    }

    def "when the trip plus a day to one of its destinations, it should return the updated destination"() {
        given:
        def destination = trip.getDestinations()[1]
        def destinationNext = destination.getDepartTransport().getDestination()
        def expectedDate = "2022-10-13T12:50"
        def expectedDestDays = 2
        def expectedDestNextDays = 1

        when:
        destinationService.plusDay(destination, trip)

        then:
        destination.getDepartDate().toString() == expectedDate
        destination.getDays().size() > expectedDestDays
        destinationNext.getArriveDate().toString() == expectedDate
        destinationNext.getDays().size() == expectedDestNextDays
    }

    def "when the trip minus a day to one of its destinations, it should return the updated destination"() {
        given:
        def destination = trip.getDestinations()[1]
        def destinationNext = destination.getDepartTransport().getDestination()
        def expectedDate = "2022-10-11T12:50"
        def expectedDestDays = 1
        def expectedDestNextDays = 2

        when:
        destinationService.minusDay(destination, trip)

        then:
        destination.getDepartDate().toString() == expectedDate
        destination.getDays().size() == expectedDestDays
        destinationNext.getArriveDate().toString() == expectedDate
        destinationNext.getDays().size() > expectedDestNextDays
    }
}
