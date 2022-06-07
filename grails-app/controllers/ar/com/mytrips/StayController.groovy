package ar.com.mytrips

import ar.com.mytrips.destination.Day
import ar.com.mytrips.destination.Destination
import ar.com.mytrips.request.StayCommand
import grails.gorm.transactions.Transactional
import grails.plugin.springsecurity.annotation.Secured

@Transactional
@Secured("ROLE_USER")
class StayController implements ModelRequestResolver {

    StayService stayService
    TripService tripService

    def save(String tripId, String destinationId, String dayId) {
        def trip = assertExistence(tripService.get(tripId), "El trip no existe")
        def destination = assertExistence(Destination.findByIdAndTrip(destinationId, trip), "La destino no existe")
        def day = assertExistence(Day.findByIdAndDestination(dayId, destination), "El day no existe")

        def request = getBody(StayCommand)
        def stay = stayService.create(trip, day, request.toModel())
        respond  stay, view: 'show'
    }


}
