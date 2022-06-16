package ar.com.mytrips


import ar.com.mytrips.external.TriposoService
import grails.gorm.transactions.Transactional
import grails.plugin.springsecurity.annotation.Secured

@Secured("IS_AUTHENTICATED_ANONYMOUSLY")
@Transactional
class PlaceController implements ModelRequestResolver {
	TriposoService triposoService
    PlaceService placeService

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
}