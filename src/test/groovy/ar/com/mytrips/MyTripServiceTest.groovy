package ar.com.mytrips

import ar.com.mytrips.auth.User
import ar.com.mytrips.destination.Destination
import ar.com.mytrips.destination.Place
import ar.com.mytrips.destination.Transport
import grails.testing.gorm.DataTest
import spock.lang.Specification

import java.time.LocalDateTime

class MyTripServiceTest extends Specification implements  DataTest {

    Trip trip
    List<Destination> destinations
    Transport transport

    void setupSpec() {
        mockDomain Destination
    }

    def setup() {
        def destFin = new Destination(relevance: 4, color: "green", place: new Place(),
                arriveDate: LocalDateTime.of(2020, 10, 14, 12, 50),
                departDate: null,
                departTransport: new Transport())

        def paramsDestSantiago = HashMap.of("relevance", 3,
                "color", "green", "place", new Place(),
                "arriveDate", LocalDateTime.of(2022, 10, 12, 12, 50),
                "departDate", LocalDateTime.of(2022, 10, 14, 12, 50),
                "departTransport", new Transport(destination: destFin))

        def destSantiago = Destination.create(paramsDestSantiago)

        def paramsDestLima = HashMap.of("relevance", 2,
                "color", "yellow", "place", new Place(name: "Lima"),
                "arriveDate", LocalDateTime.of(2022, 10, 10, 12, 50),
                "departDate",LocalDateTime.of(2022, 10, 12, 12, 50),
                "departTransport", new Transport(destination: destSantiago))

        def destLima = Destination.create(paramsDestLima)

        transport = new Transport(HashMap.of("type", TransportType.FLY,
                "arrive", LocalDateTime.of(2022, 10, 10, 12, 50, 00),
                "depart", LocalDateTime.of(2022, 10, 10, 12, 50, 00),
                "arriveLocation", "Lima",
                "departLocation", "Buenos Aires",
                "cost", new Cost(),
                "destination", destLima))

        def paramsInit = HashMap.of("relevance", 1,
                "color", "", "place", new Place(),
                "departDate", LocalDateTime.of(2020, 10, 10, 12, 50),
                "departTransport", transport)

        def destInit = Destination.create(paramsInit)

        destinations = [destInit, destLima, destSantiago, destFin]

        trip = new Trip(deleted: false, owner: new User(), image: "image", lastUpdated: LocalDateTime.now())
        trip.addDestinations(destinations)
    }

    def cleanup() { }
}
