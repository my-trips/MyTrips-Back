package ar.com.mytrips.services

import ar.com.mytrips.ActivityService
import ar.com.mytrips.destination.Activity
import ar.com.mytrips.destination.Attraction
import ar.com.mytrips.exception.ServiceException
import ar.com.mytrips.external.UnsplashService
import ar.com.mytrips.request.ActivityCommand
import ar.com.mytrips.request.AttractionCommand
import com.google.common.collect.Lists
import grails.testing.services.ServiceUnitTest
import org.springframework.http.HttpStatus

class ActivityServiceTest extends MyTripServiceTest implements ServiceUnitTest<ActivityService> {

    UnsplashService unsplashService
    Activity activity
    ActivityCommand activityCommand

    def setup() {
        unsplashService = Mock()
        service.unsplashService = unsplashService
        unsplashService.getImages("LIMA, COLISEO", 5) >>
                Lists.newArrayList("IMAGES_URL_0", "IMAGES_URL_1", "IMAGES_URL_2", "IMAGES_URL_3")

        unsplashService.getImages("LIMA, PIRAMIDES", 5) >>
                Lists.newArrayList("IMAGES_URL_5", "IMAGES_URL_7", "IMAGES_URL_8", "IMAGES_URL_10")

    }

    void "when create an activity for a day, it should return the full activity."() {
        given:
        activity = new Activity(attraction: new Attraction( labels: ["place"], description: "El coliseo es grande", name: "COLISEO", images: []))
        def day = trip.firstDestination.days.first()

        when:
        def resultActivity = service.create(trip, day, activity)

        then:
        resultActivity.attraction.labels == ["place"].toSet()
        resultActivity.attraction.description == "El coliseo es grande"
        resultActivity.attraction.name == "COLISEO"
        resultActivity.day.is(day)
        day.activities.contains(resultActivity)
    }

    def "when update an activity for a day, it should return an updated activity"() {
        given:
        activity = new Activity(attraction: new Attraction( labels: ["place"], description: "Es el cerro más alto de cordoba", name: "CERRO-CHAMPA", images: []))
        def day = trip.firstDestination.days.first()
        service.create(trip, day, activity)

        activityCommand = new ActivityCommand("startTime": "08:50", "endTime": "17:50")

        when:
        def resultActivity = service.update(trip, activity, activityCommand)

        then:
        resultActivity.startTime.toString() == "08:50"
        resultActivity.endTime.toString() == "17:50"
        resultActivity.day.is(day)
    }

    def "when delete an activity for a day, but the activity is valid, should be able to delete it"() {
        given:
        activity = new Activity(attraction: new Attraction( labels: ["place"], description: "Las Piramides de Egipto", name: "PIRAMIDES", images: []))
        def day = trip.firstDestination.days.first()
        service.create(trip, day, activity)

        when:
        def resultTrip = service.delete(trip, day, activity)

        then:
        resultTrip.firstDestination.days.first().activities.isEmpty()
    }

    def "when delete an activity for a day, but the activity is invalid, it should throw an exception"() {
        given:
        activity = new Activity(attraction: new Attraction( labels: ["place"], description: "Las Piramides de Egipto", name: "PIRAMIDES", images: []))
        def day = trip.firstDestination.days[0]

        when:
        service.delete(trip, day, activity)

        then:
        def exception = thrown(ServiceException)
        exception.status == HttpStatus.BAD_REQUEST
        exception.message == "invalidActivity"
    }
}
