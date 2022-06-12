package ar.com.mytrips

import ar.com.mytrips.destination.Day
import ar.com.mytrips.destination.Destination
import ar.com.mytrips.destination.Activity
import ar.com.mytrips.request.ActivityCommand
import grails.converters.JSON
import grails.gorm.transactions.Transactional
import grails.plugin.springsecurity.annotation.Secured

@Transactional
@Secured("ROLE_USER")
class ActivityController implements ModelRequestResolver {

    ActivityService activityService
    TripService tripService

    def delete(String tripId, String destinationId, String dayId, String id) {
        def trip = assertExistence(tripService.get(tripId), "tripNotFound")
        def destination = assertExistence(Destination.findByIdAndTrip(destinationId, trip), "La destino no existe")
        def day = assertExistence(Day.findByIdAndDestination(dayId, destination), "El day no existe")
        def activity = assertExistence(Activity.findById(id), "El itinerario no existe")
        activityService.delete(trip, day, activity)
        render(contentType: "application/json", text: [:] as JSON)
    }


    def update(String tripId, String destinationId, String dayId, String id) {
        def trip = assertExistence(tripService.get(tripId), "tripNotFound")
        def destination = assertExistence(Destination.findByIdAndTrip(destinationId, trip), "destinationNotFound")
        def day = assertExistence(Day.findByIdAndDestination(dayId, destination), "dayNotfound")
        def activity = assertExistence(Activity.findByIdAndDay(id, day), "activityNotFound")

        def request = getBody(ActivityCommand)
        activityService.update(trip, activity, request)
        respond  activity, view: 'show'
    }

    def save(String tripId, String destinationId, String dayId) {
        def trip = assertExistence(tripService.get(tripId), "tripNotFound")
        def destination = assertExistence(Destination.findByIdAndTrip(destinationId, trip), "La destino no existe")
        def day = assertExistence(Day.findByIdAndDestination(dayId, destination), "El day no existe")

        def request = getBody(ActivityCommand)
        def activity = activityService.create(trip, day, request.toModel())
        respond  activity, view: 'show'
    }


}
