package ar.com.mytrips

import ar.com.mytrips.destination.Itinerary
import ar.com.mytrips.exception.ServiceException
import ar.com.mytrips.external.UnsplashService
import ar.com.mytrips.request.ItineraryCommand
import com.google.common.collect.Lists
import grails.testing.services.ServiceUnitTest
import org.springframework.http.HttpStatus

class ItineraryServiceTest extends MyTripServiceTest implements ServiceUnitTest<ItineraryService> {

    UnsplashService unsplashService
    Itinerary itinerary
    ItineraryCommand itineraryCommand

    def setup() {
        unsplashService = Mock()
        service.unsplashService = unsplashService
        unsplashService.getImages("LIMA, COLISEO", 5) >>
                Lists.newArrayList("IMAGES_URL_0", "IMAGES_URL_1", "IMAGES_URL_2", "IMAGES_URL_3")

        unsplashService.getImages("LIMA, PIRAMIDES", 5) >>
                Lists.newArrayList("IMAGES_URL_5", "IMAGES_URL_7", "IMAGES_URL_8", "IMAGES_URL_10")

    }

    void "when create an itinerary for a day, it should return the full itinerary."() {
        given:
        itinerary = new Itinerary(title: "El Coliseo", description: "El coliseo es grande", name: "COLISEO")
        def day = trip.firstDestination.days.first()

        when:
        def resultItinerary = service.create(trip, day, itinerary)

        then:
        resultItinerary.title == "El Coliseo"
        resultItinerary.description == "El coliseo es grande"
        resultItinerary.name == "COLISEO"
        resultItinerary.day.is(day)
    }

    def "when update an itinerary for a day, it should return an updated itinerary"() {
        given:
        itinerary = new Itinerary(title: "Las Piramides", description: "Las Piramides de Egipto", name: "PIRAMIDES")
        def day = trip.firstDestination.days.first()
        service.create(trip, day, itinerary)

        itineraryCommand = new ItineraryCommand("title": "El Cerro Champaqui",
                "description": "Es el cerro más alto de cordoba", "name": "CERRO-CHAMPA",
                "startTime": "08:50", "endTime": "17:50")

        when:
        def resultItinerary = service.update(trip, itinerary, itineraryCommand)

        then:
        resultItinerary.title == "El Cerro Champaqui"
        resultItinerary.description == "Es el cerro más alto de cordoba"
        resultItinerary.name == "CERRO-CHAMPA"
        resultItinerary.startTime.toString() == "08:50"
        resultItinerary.endTime.toString() == "17:50"
        resultItinerary.day.is(day)
    }

    def "when delete an itinerary for a day, but the itinerary is valid, should be able to delete it"() {
        given:
        itinerary = new Itinerary(title: "Las Piramides", description: "Las Piramides de Egipto", name: "PIRAMIDES")
        def day = trip.firstDestination.days.first()
        service.create(trip, day, itinerary)

        when:
        def resultTrip = service.delete(trip, day, itinerary)

        then:
        resultTrip.firstDestination.days.first().itinerary.isEmpty()
    }

    def "when delete an itinerary for a day, but the itinerary is invalid, it should throw an exception"() {
        given:
        itinerary = new Itinerary(title: "Las Piramides", description: "Las Piramides de Egipto", name: "PIRAMIDES")
        def day = trip.firstDestination.days[0]

        when:
        service.delete(trip, day, itinerary)

        then:
        def exception = thrown(ServiceException)
        exception.status == HttpStatus.BAD_REQUEST
        exception.message == "invalid itinerary"
    }
}
