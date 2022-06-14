package ar.com.mytrips

import ar.com.mytrips.external.TriposoService
import grails.plugin.springsecurity.annotation.Secured

@Secured("IS_AUTHENTICATED_ANONYMOUSLY")
class LocationController {
	TriposoService triposoService
	
    def attractions(String location, String name, Integer max, Integer offset) {
        def attractions = triposoService.getAttractions(location, name, max?:10, offset?:0)
        render(model: [list: attractions], view: "attractions")
    }

    def location(String country, String city) {
        def location = triposoService.getLocation(country, city)
        respond  location, view: 'location'
    }
}
