package ar.com.mytrips.services

import ar.com.mytrips.ActivityService
import ar.com.mytrips.destination.Activity
import ar.com.mytrips.exception.ServiceException
import ar.com.mytrips.external.UnsplashService
import ar.com.mytrips.request.ActivityCommand
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
        activity = new Activity(title: "El Coliseo", description: "El coliseo es grande", name: "COLISEO")
        def day = trip.firstDestination.days.first()

        when:
        def resultActivity = service.create(trip, day, activity)

        then:
        resultActivity.title == "El Coliseo"
        resultActivity.description == "El coliseo es grande"
        resultActivity.name == "COLISEO"
        resultActivity.day.is(day)
    }

    def "when update an activity for a day, it should return an updated activity"() {
        given:
        activity = new Activity(title: "Las Piramides", description: "Las Piramides de Egipto", name: "PIRAMIDES")
        def day = trip.firstDestination.days.first()
        service.create(trip, day, activity)

        activityCommand = new ActivityCommand("title": "El Cerro Champaqui",
                "description": "Es el cerro más alto de cordoba", "name": "CERRO-CHAMPA",
                "startTime": "08:50", "endTime": "17:50")

        when:
        def resultActivity = service.update(trip, activity, activityCommand)

        then:
        resultActivity.title == "El Cerro Champaqui"
        resultActivity.description == "Es el cerro más alto de cordoba"
        resultActivity.name == "CERRO-CHAMPA"
        resultActivity.startTime.toString() == "08:50"
        resultActivity.endTime.toString() == "17:50"
        resultActivity.day.is(day)
    }

    def "when delete an activity for a day, but the activity is valid, should be able to delete it"() {
        given:
        activity = new Activity(title: "Las Piramides", description: "Las Piramides de Egipto", name: "PIRAMIDES")
        def day = trip.firstDestination.days.first()
        service.create(trip, day, activity)

        when:
        def resultTrip = service.delete(trip, day, activity)

        then:
        resultTrip.firstDestination.days.first().activities.isEmpty()
    }

    def "when delete an activity for a day, but the activity is invalid, it should throw an exception"() {
        given:
        activity = new Activity(title: "Las Piramides", description: "Las Piramides de Egipto", name: "PIRAMIDES")
        def day = trip.firstDestination.days[0]

        when:
        service.delete(trip, day, activity)

        then:
        def exception = thrown(ServiceException)
        exception.status == HttpStatus.BAD_REQUEST
        exception.message == "invalidActivity"
    }
}
