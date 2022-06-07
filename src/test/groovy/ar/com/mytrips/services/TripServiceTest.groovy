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
    private User collaborator

    def setup() {
        userService = Mock()
        unsplashService = Mock()
        user = new User(firstName:"Susan", lastName: "Rosito", email:"rosisusa@gmail.com", password:"12345")
        userService.currentUser >> user

        collaborator = new User(firstName:"Pepe", lastName: "Argento", email:"pepe@gmail.com", password:"12345")
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

    void "when a trip is copied, a new trip with the same configuration is returned"() {
        given:
            service.create(trip)
        when:
        def duplicatedTrip = service.copy(trip)

        then:
        duplicatedTrip.owner == trip.owner
        duplicatedTrip.image == trip.image
        duplicatedTrip.destinations.size() == trip.destinations.size()
    }

    void "when a collaborator is added, it should should increase the list of collaborators"() {
        given:
            service.create(trip)
        when:
          service.addCollaborator(trip, collaborator)

        then:
        trip.collaborators.size() == 1
        trip.collaborators.first() == collaborator
    }

    void "when add a collaborator that already exists, it should throw an exception"() {
        given:
        service.create(trip)
        service.addCollaborator(trip, collaborator)

        when:
            service.addCollaborator(trip, collaborator)

        then:
        def exception = thrown(ServiceException)
        exception.status == HttpStatus.BAD_REQUEST
        exception.message == "invalidCollaborator"
    }

    void "when the owner is added as a collaborator, it should throw an exception"() {
        given:
        service.create(trip)
        when:
        service.addCollaborator(trip, trip.owner)

        then:
        def exception = thrown(ServiceException)
        exception.status == HttpStatus.BAD_REQUEST
        exception.message == "invalidCollaborator"
    }

    void "when a collaborator is removed, it should be removed from the list of collaborators"() {
        given:
        service.create(trip)
        service.addCollaborator(trip, collaborator)

        when:
        service.removeCollaborator(trip, collaborator)

        then:
        trip.collaborators.isEmpty()
    }

    void "when removing a collaborator that doesn't exist, it should throw an exception"() {
        given:
        service.create(trip)
        when:
        service.removeCollaborator(trip, collaborator)

        then:
        def exception = thrown(ServiceException)
        exception.status == HttpStatus.BAD_REQUEST
        exception.message == "invalidCollaborator"
    }

    void "when the owner is removed as a collaborator, it should throw an exception"() {
        given:
        service.create(trip)
        when:
        service.removeCollaborator(trip, trip.owner)

        then:
        def exception = thrown(ServiceException)
        exception.status == HttpStatus.BAD_REQUEST
        exception.message == "invalidCollaborator"
    }

    void "when a non-owner user removes a collaborator, it should throw an exception"() {
        given:
        service.create(trip)
        trip.owner = collaborator
        when:
        service.removeCollaborator(trip, collaborator)

        then:
        def exception = thrown(ServiceException)
        exception.status == HttpStatus.BAD_REQUEST
        exception.message == "invalidUser"
    }
}
