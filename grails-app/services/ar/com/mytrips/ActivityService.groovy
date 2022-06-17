package ar.com.mytrips

import ar.com.mytrips.destination.Day
import ar.com.mytrips.destination.Activity
import ar.com.mytrips.external.UnsplashService
import ar.com.mytrips.request.ActivityCommand
import grails.gorm.services.Service

import javax.transaction.Transactional

@Service(Activity)
@Transactional
class ActivityService {
    UnsplashService unsplashService

    def delete(Trip trip, Day day, Activity activity) {
        day.removeActivity(activity)
        trip.changeLastUpdated()
    }

    def update(Trip trip, Activity activity, ActivityCommand command) {
        activity.properties = command.changes()
        trip.changeLastUpdated()
        activity.save()
    }

    Activity create(Trip trip, Day day, Activity activity) {
        if(!activity.attraction.id) {
            activity.attraction.place = day.destination.place
            activity.attraction.images = unsplashService.getImages(day.destination.place.name + ", " +activity.attraction.name, 5)
        }
        day.addActivity(activity)
        trip.changeLastUpdated()
        activity.save()
    }
}
