package ar.com.mytrips.services

import ar.com.mytrips.TripService
import ar.com.mytrips.UserService
import ar.com.mytrips.auth.User
import ar.com.mytrips.exception.ServiceException
import ar.com.mytrips.external.UnsplashService
import grails.testing.services.ServiceUnitTest
import org.springframework.http.HttpStatus

class TripServiceTest extends MyTripServiceTest implements ServiceUnitTest<TripService> {

    private UserService userService
    private UnsplashService unsplashService
    private User user

    def setup() {
        userService = Mock()
        unsplashService = Mock()
        user = new User(HashMap.of("firstName", "Susan",
                "lastName", "Rosito",
                "email", "rosisusa@gmail.com",
                "password", "12345"))
        userService.getCurrentUser() >> user
        unsplashService.getImage("Lima") >> "IMAGE_LIMA_URL"

        service.userService = userService
        service.unsplashService = unsplashService

    }

    void "when create a trip, it should return a complete trip"() {
        when:
        def resultTrip = service.create(trip)

        then:
        resultTrip.owner.getFirstName() == "Susan"
        resultTrip.image == "IMAGE_LIMA_URL"
        resultTrip.destinations.size() == 4
        resultTrip.destinations.every{dest -> dest.trip.is(trip)}
    }

    void "when fetch a trip for id, if the trip exists it should return it"() {
        given:
        trip = service.create(trip)

        when:
        def resultTrip = service.get(trip.id)

        then:
        resultTrip.owner.getFirstName() == "Susan"
        resultTrip.image == "IMAGE_LIMA_URL"
        resultTrip.destinations.size() == 4
        resultTrip.destinations.every{dest -> dest.trip.is(trip)}
    }

    void "when fetch a trip for id, if the trip doesn't exits it shouldn't return it"() {
        when:
        def resultTrip = service.get(trip.id)

        then:
        !resultTrip
    }

    void "when search for all trips for a user, it should return all of them"() {
        given:
        trip = service.create(trip)

        when:
        def listTrips = service.list(10, 0)

        then:
        listTrips.size() != 0
        listTrips.contains(trip)
        listTrips.first().id == trip.id
        listTrips.first().owner.firstName == "Susan"
    }

    void "when search for all trips for a user, and the user has no trips it should not return nothing."() {
        when:
        def listTrips = service.list(10, 0)

        then:
        listTrips.isEmpty()
    }

    void "when delete a trip from a user, you should be able to delete it"() {
        given:
        trip = service.create(trip)

        when:
        def resultTrip = service.delete(trip)

        then:
        resultTrip.deleted
    }

    void "when delete a trip for a user, but the user is invalid, it should throw an exception"() {
        when:
        service.delete(trip)

        then:
        def exception = thrown(ServiceException)
        exception.status == HttpStatus.FORBIDDEN
        exception.message == "invalidUser"
    }
}
