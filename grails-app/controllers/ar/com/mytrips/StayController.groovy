package ar.com.mytrips

import ar.com.mytrips.destination.Destination
import ar.com.mytrips.request.StayCommand
import grails.gorm.transactions.Transactional
import grails.plugin.springsecurity.annotation.Secured

@Transactional
@Secured("ROLE_USER")
class StayController implements ModelRequestResolver {

    StayService stayService
    TripService tripService

    def save(String tripId, String destinationId) {
        def trip = assertExistence(tripService.get(tripId), "El trip no existe")
        def destination = assertExistence(Destination.findByIdAndTrip(destinationId, trip), "La destino no existe")

        def request = getBody(StayCommand)
        def stay = stayService.create(trip, destination, request.toModel())
        respond  stay, view: 'show'
    }


}
