package ar.com.mytrips

import ar.com.mytrips.destination.Destination
import ar.com.mytrips.destination.Stay
import ar.com.mytrips.request.StayCommand
import grails.gorm.transactions.Transactional
import grails.plugin.springsecurity.annotation.Secured

@Transactional
@Secured("ROLE_USER")
class StayController implements ModelRequestResolver {

    StayService stayService
    TripService tripService

    def save(String tripId, String destinationId) {
        def trip = assertExistence(tripService.get(tripId), "tripNotFound")
        def destination = assertExistence(Destination.findByIdAndTrip(destinationId, trip), "La destino no existe")

        def request = getBody(StayCommand)
        def stay = stayService.create(trip, destination, request.toModel())
        respond  stay, view: 'show'
    }

    def update(String tripId, String destinationId, String stayId) {
        def trip = assertExistence(tripService.get(tripId), "tripNotFound")
        def destination = assertExistence(Destination.findByIdAndTrip(destinationId, trip), "La destino no existe")
        def stay = assertExistence(Stay.findByIdAndDestination(stayId, destination), "La estadia no existe")

        def request = getBody(StayCommand)
        stayService.update(trip, stay, request)
        respond  stay, view: 'show'
    }
}
