package ar.com.mytrips

import ar.com.mytrips.auth.User
import ar.com.mytrips.exception.ServiceException
import ar.com.mytrips.external.UnsplashService
import grails.testing.gorm.DomainUnitTest
import org.springframework.http.HttpStatus

class TripServiceTest extends MyTripTest implements DomainUnitTest<Trip> {

    private TripService tripService
    private UserService userService
    private UnsplashService unsplashService
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
    }

    void "when create a trip, it should return a complete trip"() {
        when:
        def resultTrip = tripService.create(trip)

        then:
        resultTrip.getId() == "1"
        resultTrip.getOwner().getFirstName() == "Susan"
        resultTrip.getImage() == "IMAGE_LIMA_URL"
        resultTrip.getDestinations().size() == 4
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
        resultTrip.getDestinations().size() == 4
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
