package ar.com.mytrips

import ar.com.mytrips.external.TriposoService
import grails.plugin.springsecurity.annotation.Secured

@Secured("IS_AUTHENTICATED_ANONYMOUSLY")
class LocationController {
	TriposoService triposoService
	
    def attractions(String location) {
        def attractions = triposoService.getAttractions(location)
        render(model: [list: attractions], view: "attractions")
    }

    def location(String country, String city) {
        def location = triposoService.getLocation(country, city)
        respond  location, view: 'location'
    }
}
