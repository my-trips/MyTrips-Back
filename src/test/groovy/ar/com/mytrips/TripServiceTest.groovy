package ar.com.mytrips

import ar.com.mytrips.auth.User
import ar.com.mytrips.destination.Destination
import ar.com.mytrips.destination.Place
import ar.com.mytrips.destination.Transport
import ar.com.mytrips.exception.ServiceException
import ar.com.mytrips.external.UnsplashService
import grails.testing.gorm.DomainUnitTest
import org.springframework.http.HttpStatus
import spock.lang.Specification

import java.time.LocalDateTime

class TripServiceTest extends Specification implements DomainUnitTest<Trip> {

    private TripService tripService
    private UserService userService
    private UnsplashService unsplashService
    private List<Destination> destinations
    private Trip trip
    private User user

    def setup() {
        userService = Mock()
        user = new User(HashMap.of("firstName", "Susan",
                "lastName", "Rosito",
                "email", "rosisusa@gmail.com",
                "password", "12345"))
        userService.getCurrentUser() >> user

        unsplashService = Mock()
        unsplashService.getImage("Lima") >> "IMAGE_LIMA_URL"

        tripService = new TripService(userService: userService, unsplashService: unsplashService)

        def destFin = new Destination(relevance: 3, color: "green", place: new Place(),
                arriveDate: LocalDateTime.of(2022, 10, 12, 12, 50, 00), departDate: null,
                departTransport: new Transport())

        def paramsDestLima = HashMap.of("relevance", 2,
                "color", "yellow", "place", new Place(name: "Lima"),
                "arriveDate", LocalDateTime.of(2022, 10, 10, 12, 50, 00),
                "departDate",LocalDateTime.of(2022, 10, 12, 12, 50, 00),
                "departTransport", new Transport(destination: destFin))

        def destLima = Destination.create(paramsDestLima)

        def paramsInit = HashMap.of("relevance", 1,
                "color", "", "place", new Place(),
                "departDate", LocalDateTime.of(2022, 10, 10, 12, 50, 00),
                "departTransport", new Transport(destination: destLima))

        def destInit = Destination.create(paramsInit)

        destinations = [destInit, destLima, destFin]

        trip = new Trip(deleted: false, lastUpdated: LocalDateTime.now())
        trip.addDestinations(destinations)
    }

    def cleanup() { }

    void "when create a trip, it should return a complete trip"() {
        when:
        def resultTrip = tripService.create(trip)

        then:
        resultTrip.getId() == "1"
        resultTrip.getOwner().getFirstName() == "Susan"
        resultTrip.getImage() == "IMAGE_LIMA_URL"
        resultTrip.getDestinations().size() == 3
        resultTrip.getDestinations().stream().allMatch(dest -> dest.getTrip().is(trip))
    }

    void "when fetch a trip for id, if the trip exists it should return it"() {
        given:
        trip = tripService.create(trip)

        when:
        def resultTrip = tripService.get("1")

        then:
        resultTrip.getOwner().getFirstName() == "Susan"
        resultTrip.getImage() == "IMAGE_LIMA_URL"
        resultTrip.getDestinations().size() == 3
        resultTrip.getDestinations().stream().allMatch(dest -> dest.getTrip().is(trip))
    }

    void "when fetch a trip for id, if the trip doesn't exits it shouldn't return it"() {
        when:
        def resultTrip = tripService.get("1")

        then:
        !resultTrip
    }

    void "when search for all trips for a user, it should return all of them"() {
        given:
        trip = tripService.create(trip)

        when:
        def listTrips = tripService.list(10, 0)

        then:
        listTrips.size() != 0
        listTrips.contains(trip)
        listTrips.get(0).getId() == "1"
        listTrips.get(0).getOwner().getFirstName() == "Susan"
    }

    void "when search for all trips for a user, and the user has no trips it should not return nothing."() {
        when:
        def listTrips = tripService.list(10, 0)

        then:
        listTrips.isEmpty()
    }

    void "when delete a trip from a user, you should be able to delete it"() {
        given:
        trip = tripService.create(trip)

        when:
        def resultTrip = tripService.delete(trip)

        then:
        resultTrip.getDeleted()
    }

    void "when delete a trip for a user, but the user is invalid, it should throw an exception"() {
        when:
        tripService.delete(trip)

        then:
        def exception = thrown(ServiceException)
        exception.getStatus() == HttpStatus.FORBIDDEN
        exception.getMessage() == "invalidUser"
    }
}
