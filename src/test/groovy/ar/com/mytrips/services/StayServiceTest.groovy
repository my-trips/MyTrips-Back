package ar.com.mytrips.services


import ar.com.mytrips.StayService
import ar.com.mytrips.destination.Stay
import grails.testing.services.ServiceUnitTest

import java.time.LocalDateTime

class StayServiceTest extends MyTripServiceTest implements ServiceUnitTest<StayService> {

    def "when a dfsfsdf is subtract a day to one of its destinations, it should return the updated destination"() {
        given:
        def stay = new Stay(
            title: "Hostel",
            name: "Saranata",
            address: "Av Siempre Viva 2013",
            longitude: 0.0,
            latitude: 0.0,
            notes: "Tiene buena ubicacion",
            checkIn: LocalDateTime.of(2022, 10, 10, 12, 50),
            checkOut: LocalDateTime.of(2022, 10, 14, 17, 50),
        )
        def destination = trip.destinationsWithoutOrigin.first()

        when:
        service.create(trip, destination, stay)

        then:
        destination.stays.size() != 0
        destination.stays.first().name == "Saranata"
    }
}
