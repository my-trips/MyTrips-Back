package ar.com.mytrips


import ar.com.mytrips.destination.Itinerary
import ar.com.mytrips.exception.ServiceException
import ar.com.mytrips.external.UnsplashService
import ar.com.mytrips.request.ItineraryCommand
import com.google.common.collect.Lists
import grails.testing.gorm.DomainUnitTest
import org.springframework.http.HttpStatus

class ItineraryServiceTest extends MyTripTest implements DomainUnitTest<Itinerary> {

    private ItineraryService itineraryService
    private UnsplashService unsplashService
    private Itinerary itinerary
    private ItineraryCommand itineraryCommand

    def setup() {
        unsplashService = Mock()

        itineraryService = new ItineraryService()
        itineraryService.setUnsplashService(unsplashService)

        unsplashService.getImages("LIMA, COLISEO", 5) >>
                Lists.newArrayList("IMAGES_URL_0", "IMAGES_URL_1", "IMAGES_URL_2", "IMAGES_URL_3")

        unsplashService.getImages("LIMA, PIRAMIDES", 5) >>
                Lists.newArrayList("IMAGES_URL_5", "IMAGES_URL_7", "IMAGES_URL_8", "IMAGES_URL_10")

    }

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
