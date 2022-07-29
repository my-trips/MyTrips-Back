package ar.com.mytrips.services

import ar.com.mytrips.PlaceService
import ar.com.mytrips.destination.Country
import ar.com.mytrips.destination.Place
import grails.testing.services.ServiceUnitTest

class PlaceServiceTest  extends MyTripServiceTest implements ServiceUnitTest<PlaceService> {

    Place place

    def setup() {
        place = new Place(country: new Country(name:"Argentina"), name: "Obelisco")
    }

    void "when fetch a place for id, if the place exists it should return it"() {
        given:
        place.save()

        when:
        def resultPlace = service.get("1")

        then:
        resultPlace.name == "Obelisco"
    }

    void "when fetch a place for name, if the place exists it should return it"() {
        given:
        place.save()

        when:
        def resultPlace = service.getByCountryAndName("Argentina","Obelisco")

        then:
        resultPlace.id == "1"
    }
}