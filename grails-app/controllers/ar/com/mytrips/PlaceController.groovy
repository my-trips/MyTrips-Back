package ar.com.mytrips

import ar.com.mytrips.external.TriposoService
import grails.gorm.transactions.Transactional
import grails.plugin.springsecurity.annotation.Secured

@Secured("IS_AUTHENTICATED_ANONYMOUSLY")
@Transactional
class PlaceController implements ModelRequestResolver {
	TriposoService triposoService
    PlaceService placeService
    TripService tripService

    def get(String id) {
        def place = assertExistence(placeService.get(id), "placeNotFound")
        respond  place, view: 'show'
    }

    def getByName(String country, String name) {
        def place = assertExistence(placeService.getByCountryAndName(country, name), "placeNotFound", [country:country, name:name])
        respond  place, view: 'show'
    }

    def trending(){
        def places  = placeService.trending()
        respond  places, view: 'index'
    }

    def placesForTrip(String tripId){
        def trip = assertExistence(tripService.getPublic(tripId), "tripNotFound")
        def places = placeService.placesForTrip(trip)
        respond  places, view: 'index'
    }

    def attractions(String id, Integer max) {
        def place = assertExistence(placeService.get(id), "placeNotFound")
        respond place.attractions.take(max?:10), view: "/attraction/list"
    }
}
