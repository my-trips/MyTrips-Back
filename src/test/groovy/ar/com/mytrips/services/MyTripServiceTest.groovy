package ar.com.mytrips.services

import ar.com.mytrips.Cost
import ar.com.mytrips.destination.Country
import ar.com.mytrips.TransportType
import ar.com.mytrips.Trip
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
        def destFin = new Destination(relevance: 4,
                color: "green", place: new Place(country: new Country(name:"Argentina")),
                arriveDate: LocalDateTime.of(2022, 10, 14, 12, 50),
                departDate: null,
                departTransport: new Transport())

        def destSantiago = Destination.create("relevance": 3,
                "color": "green", "place": new Place(country: new Country(name:"Argentina")),
                "arriveDate": LocalDateTime.of(2022, 10, 12, 12, 50),
                "departDate": LocalDateTime.of(2022, 10, 14, 12, 50),
                "departTransport": new Transport(destination: destFin))

        def destLima = Destination.create("relevance": 2,
                "color": "yellow", "place": new Place(name: "Lima", country: new Country(name:"Peru")),
                "arriveDate": LocalDateTime.of(2022, 10, 10, 12, 50),
                "departDate": LocalDateTime.of(2022, 10, 12, 12, 50),
                "departTransport": new Transport(destination: destSantiago))

        transport = new Transport("type": TransportType.FLY,
                "arrive": LocalDateTime.of(2022, 10, 10, 12, 50, 00),
                "depart": LocalDateTime.of(2022, 10, 10, 12, 50, 00),
                "arriveLocation": "Lima",
                "departLocation": "Buenos Aires",
                "cost": new Cost(),
                "destination": destLima)

        def destInit = Destination.create("relevance": 1,
                "color": "", "place": new Place(country: new Country(name:"Argentina")),
                "departDate": LocalDateTime.of(2022, 10, 10, 12, 50),
                "departTransport": transport)

        destinations = [destInit, destLima, destSantiago, destFin]

        trip = new Trip(deleted: false, owner: new User(email: "user@gmail.com"), image: "image", lastUpdated: LocalDateTime.now())
        trip.addDestinations(destinations)
    }

    def cleanup() { }
}
