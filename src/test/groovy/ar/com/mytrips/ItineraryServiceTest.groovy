package ar.com.mytrips

import ar.com.mytrips.auth.User
import ar.com.mytrips.destination.*
import ar.com.mytrips.exception.ServiceException
import ar.com.mytrips.external.UnsplashService
import ar.com.mytrips.request.ItineraryCommand
import com.google.common.collect.Lists
import grails.testing.gorm.DomainUnitTest
import org.springframework.http.HttpStatus
import spock.lang.Specification

import java.time.LocalDate
import java.time.LocalDateTime

class ItineraryServiceTest extends Specification implements DomainUnitTest<Itinerary> {

    private ItineraryService itineraryService
    private UnsplashService unsplashService
    private List<Destination> destinations
    private Destination destination
    private Itinerary itinerary
    private ItineraryCommand itineraryCommand
    private Day day
    private Trip trip

    def setup() {
        unsplashService = Mock()

        itineraryService = new ItineraryService()
        itineraryService.setUnsplashService(unsplashService)

        unsplashService.getImages("LIMA, COLISEO", 5) >>
                Lists.newArrayList("IMAGES_URL_0", "IMAGES_URL_1", "IMAGES_URL_2", "IMAGES_URL_3")

        unsplashService.getImages("LIMA, PIRAMIDES", 5) >>
                Lists.newArrayList("IMAGES_URL_5", "IMAGES_URL_7", "IMAGES_URL_8", "IMAGES_URL_10")

        def destFin = new Destination(relevance: 4, color: "green", place: new Place(),
                arriveDate: LocalDateTime.of(2020, 10, 14, 12, 50, 00),
                departDate: null,
                departTransport: new Transport())

        def paramsDestLima = HashMap.of("relevance", 2,
                "color", "yellow", "place", new Place(name: "LIMA"),
                "arriveDate", LocalDateTime.of(2022, 10, 10, 12, 50, 00),
                "departDate", LocalDateTime.of(2022, 10, 12, 12, 50, 00),
                "departTransport", new Transport(destination: destFin),
                "days",
                [new Day(date: LocalDate.of(2022, 10, 10), itinerary: [], destination: destination),
                 new Day(date: LocalDate.of(2022, 10, 11), itinerary: [], destination: destination)
                ]
        )

        destination = Destination.create(paramsDestLima)

        def paramsInit = HashMap.of("relevance", 1,
                "color", "", "place", new Place(),
                "departDate", LocalDateTime.of(2020, 10, 10, 12, 50, 00),
                "departTransport", new Transport(destination: destination))

        def destInit = Destination.create(paramsInit)

        destinations = [destInit, destination, destFin]

        trip = new Trip(deleted: false, owner: new User(), image: "image", lastUpdated: LocalDateTime.now())
        trip.addDestinations(destinations)
        trip.save()
    }

    def cleanup() { }

    void "when create an itinerary for a day, it should return the full itinerary."() {
        given:
        itinerary = new Itinerary(title: "El Coliseo", description: "El coliseo es grande", name: "COLISEO")
        def day = trip.getFirstDestination().getDays()[0]

        when:
        def resultItinerary = itineraryService.create(trip, day, itinerary)

        then:
        resultItinerary.getId() == "1"
        resultItinerary.getTitle() == "El Coliseo"
        resultItinerary.getDescription() == "El coliseo es grande"
        resultItinerary.getName() == "COLISEO"
        resultItinerary.getDay().is(day)
    }

    def "when update an itinerary for a day, it should return an updated itinerary"() {
        given:
        itinerary = new Itinerary(title: "Las Piramides", description: "Las Piramides de Egipto", name: "PIRAMIDES")
        def day = trip.getFirstDestination().getDays()[0]
        itineraryService.create(trip, day, itinerary)

        itineraryCommand = new ItineraryCommand("title": "El Cerro Champaqui",
                "description": "Es el cerro más alto de cordoba", "name": "CERRO-CHAMPA",
                "startTime": "08:50", "endTime": "17:50")

        when:
        def resultItinerary = itineraryService.update(trip, itinerary, itineraryCommand)

        then:
        resultItinerary.getId() == "1"
        resultItinerary.getTitle() == "El Cerro Champaqui"
        resultItinerary.getDescription() == "Es el cerro más alto de cordoba"
        resultItinerary.getName() == "CERRO-CHAMPA"
        resultItinerary.getStartTime().toString() == "08:50"
        resultItinerary.getEndTime().toString() == "17:50"
        resultItinerary.getDay().is(day)
    }

    def "when delete an itinerary for a day, but the itinerary is valid, should be able to delete it"() {
        given:
        itinerary = new Itinerary(title: "Las Piramides", description: "Las Piramides de Egipto", name: "PIRAMIDES")
        def day = trip.getFirstDestination().getDays()[0]
        itineraryService.create(trip, day, itinerary)

        when:
        def resultTrip = itineraryService.delete(trip, day, itinerary)

        then:
        resultTrip.getFirstDestination().getDays()[0].getItinerary().isEmpty()
    }

    def "when delete an itinerary for a day, but the itinerary is invalid, it should throw an exception"() {
        given:
        itinerary = new Itinerary(title: "Las Piramides", description: "Las Piramides de Egipto", name: "PIRAMIDES")
        def day = trip.getFirstDestination().getDays()[0]

        when:
        itineraryService.delete(trip, day, itinerary)

        then:
        def exception = thrown(ServiceException)
        exception.getStatus() == HttpStatus.BAD_REQUEST
        exception.getMessage() == "invalid itinerary"
    }
}
