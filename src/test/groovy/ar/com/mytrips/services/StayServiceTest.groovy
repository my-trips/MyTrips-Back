package ar.com.mytrips.services

import ar.com.mytrips.Cost
import ar.com.mytrips.Currency
import ar.com.mytrips.StayService
import ar.com.mytrips.destination.Stay
import ar.com.mytrips.exception.ServiceException
import ar.com.mytrips.request.StayCommand
import grails.testing.services.ServiceUnitTest
import org.springframework.http.HttpStatus

import java.time.LocalDateTime

class StayServiceTest extends MyTripServiceTest implements ServiceUnitTest<StayService> {

    Stay stay
    StayCommand stayCommand

    def "when create an stay for a destination, it should return the full stay."() {
        given:
        stay = new Stay(
            name: "Paris Puro Hotel",
            title: "Hotel",
            address: "",
            notes: "Tiene buena ubicacion",
            checkIn: LocalDateTime.of(2022, 10, 10, 12, 50),
            checkOut: LocalDateTime.of(2022, 10, 14, 17, 50),
            cost: new Cost(currency: Currency.EUR, amount: 500),
            confirmation: "#Cod.Confirmation",
            placeReservation: "Despegar",
            link: "Link-pagina-de-reserva"
        )

        def destination = trip.destinationsWithoutOrigin.first()

        when:
        service.create(trip, destination, stay)

        then:
        destination.stays.size() != 0
        def stayOfDestination =  destination.stays.first()
        stayOfDestination.is(stay)
        stayOfDestination.destination.is(destination)
        stayOfDestination.name == "Paris Puro Hotel"
        stayOfDestination.confirmation == "#Cod.Confirmation"
        stayOfDestination.checkIn.toString() == "2022-10-10T12:50"
        stayOfDestination.checkOut.toString() == "2022-10-14T17:50"
        stayOfDestination.cost.getAmount() == 500
    }

    def "when update an stay for a destination, it should return an updated stay"() {
        given:
        stay = new Stay(
            name: "Paris Puro Hotel",
            title: "Hotel",
            address: "",
            notes: "Tiene buena ubicacion",
            checkIn: LocalDateTime.of(2022, 10, 10, 12, 50),
            checkOut: LocalDateTime.of(2022, 10, 14, 17, 50),
            cost: new Cost(currency: Currency.EUR, amount: 500),
            confirmation: "#Cod.Confirmation",
            placeReservation: "Despegar",
            link: "Link-pagina-de-reserva"
        )
        def destination = trip.destinationsWithoutOrigin.first()
        service.create(trip, destination, stay)

        stayCommand = new StayCommand(
            name: "Apart Paris Hol",
            title: "Apartment",
            address: "Av Siempre Viva 2013",
            notes: "La vista es bellisima",
            checkIn: "2022-10-09T12:50",
            checkOut: "2022-10-15T17:50",
            confirmation: "#237654345",
            placeReservation: "Booking",
            cost: new Cost(currency: Currency.USD, amount: 700),
            link: "Other-link-Page"
        )

        when:
        service.update(trip, stay, stayCommand)

        then:
        destination.stays.size() != 0
        def stayOfDestination =  destination.stays.first()
        stayOfDestination.destination.is(destination)
        stayOfDestination.name == "Apart Paris Hol"
        stayOfDestination.confirmation == "#237654345"
        stayOfDestination.checkIn.toString() == "2022-10-09T12:50"
        stayOfDestination.checkOut.toString() == "2022-10-15T17:50"
        stayOfDestination.cost.getCurrency() == Currency.USD
        stayOfDestination.cost.getAmount() == 700

    }

    def "when delete an stay for a destination, but the stay is valid, should be able to delete it"() {
        given:
        stay = new Stay(
            name: "Paris Puro Hotel",
            title: "Hotel",
            address: "",
            notes: "Tiene buena ubicacion",
            checkIn: LocalDateTime.of(2022, 10, 10, 12, 50),
            checkOut: LocalDateTime.of(2022, 10, 14, 17, 50),
            cost: new Cost(currency: Currency.EUR, amount: 500),
            confirmation: "#Cod.Confirmation",
            placeReservation: "Despegar",
            link: "Link-pagina-de-reserva"
        )
        def destination = trip.destinationsWithoutOrigin.first()
        service.create(trip, destination, stay)

        when:
        service.delete(trip, destination, stay)

        then:
        destination.stays.isEmpty()
    }

    def "when delete an stay for a destination, but the stay is invalid, it should throw an exception"() {
        given:
        stay = new Stay(
            title: "Apartment",
            notes: "Es un lugar muy bonito",
            name: "Apart Paris Hol",
            confirmation: "#346432312"
        )
        def destination = trip.destinationsWithoutOrigin.first()

        when:
        service.delete(trip, destination, stay)

        then:
        def exception = thrown(ServiceException)
        exception.status == HttpStatus.BAD_REQUEST
        exception.message == "invalidStay"
    }
}
