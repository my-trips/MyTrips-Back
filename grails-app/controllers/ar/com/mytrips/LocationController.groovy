package ar.com.mytrips

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
