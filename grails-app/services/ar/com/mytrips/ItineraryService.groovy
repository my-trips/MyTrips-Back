package ar.com.mytrips

import ar.com.mytrips.destination.Day
import ar.com.mytrips.destination.Itinerary
import ar.com.mytrips.external.UnsplashService
import ar.com.mytrips.request.ItineraryCommand
import grails.gorm.services.Service

import javax.transaction.Transactional

@Service(Itinerary)
@Transactional
class ItineraryService {
    UnsplashService unsplashService

    def delete(Trip trip, Day day, Itinerary itinerary) {
        day.removeItinerary(itinerary)
        trip.changeLastUpdated()
    }

    def update(Trip trip, Itinerary itinerary, ItineraryCommand command) {
        itinerary.properties = command.changes()
        trip.changeLastUpdated()
        itinerary.save()
    }

    Itinerary create(Trip trip, Day day, Itinerary itinerary) {
        itinerary.images = unsplashService.getImages(day.destination.place.name + ", " +itinerary.name, 5)
        day.addItinerary(itinerary)
        trip.changeLastUpdated()
        itinerary.save()
    }
}
