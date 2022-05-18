package ar.com.mytrips

import ar.com.mytrips.exception.ServiceException
import ar.com.mytrips.request.CreateTripRequest
import grails.converters.JSON
import grails.gorm.transactions.Transactional

@Transactional
class TripController implements ModelRequestResolver {

    TripService tripService

    def list(Integer max, Integer offset) {
        def trips = tripService.list(max, offset)
        respond  trips, view: 'index'
    }

    def get(String id) {
        def trip = assertExistence(tripService.get(id), "El trip no existe")
        respond  trip, view: 'show'
    }

    def delete(String id) {
        def trip = assertExistence(tripService.get(id), "El trip no existe")
        tripService.delete(trip)
        render(contentType: "application/json", text: [:] as JSON)
    }

    def save() {
        def request = getBody(CreateTripRequest)
        def trip = tripService.create(request.toModel())
        respond  trip, view: 'show'
    }

    protected  <T> T assertExistence(T object, String message){
        if(!object){
            throw ServiceException.badRequest(message)
        }
        return object
    }
}
