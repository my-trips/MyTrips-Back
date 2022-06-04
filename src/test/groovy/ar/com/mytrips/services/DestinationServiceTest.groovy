package ar.com.mytrips.services

import ar.com.mytrips.DestinationService
import ar.com.mytrips.exception.ServiceException
import grails.testing.services.ServiceUnitTest
import org.springframework.http.HttpStatus

class DestinationServiceTest extends MyTripServiceTest implements ServiceUnitTest<DestinationService> {

    def "when a trip is added a day to one of its destinations, it should return the updated destination"() {
        given:
        def destination = trip.destinationsWithoutOrigin.first()
        def destinationNext = destination.departTransport.destination
        def expectedDate = "2022-10-13T12:50"
        def expectedDestDays = 2
        def expectedDestNextDays = 1

        when:
        service.plusDay(destination, trip)

        then:
        destination.departDate.toString() == expectedDate
        destination.days.size() > expectedDestDays
        destinationNext.arriveDate.toString() == expectedDate
        destinationNext.days.size() == expectedDestNextDays
    }

    def "when adding days, the next destination cannot run out of days"() {
        given:
        def destination = trip.destinationsWithoutOrigin.first()

        when:
        service.plusDay(destination, trip)
        service.plusDay(destination, trip)

        then:
        def exception = thrown(ServiceException)
        exception.status == HttpStatus.BAD_REQUEST
        exception.message == "daysCannotBeEmpty"
    }

    def "hen a trip is subtract a day to one of its destinations, it should return the updated destination"() {
        given:
        def destination = trip.destinationsWithoutOrigin.first()
        def destinationNext = destination.departTransport.destination
        def expectedDate = "2022-10-11T12:50"
        def expectedDestDays = 1
        def expectedDestNextDays = 2

        when:
        service.minusDay(destination, trip)

        then:
        destination.departDate.toString() == expectedDate
        destination.days.size() == expectedDestDays
        destinationNext.arriveDate.toString() == expectedDate
        destinationNext.days.size() > expectedDestNextDays
    }

    def "by subtracting days, the previous destination cannot run out of days\n"() {
        given:
        def destination = trip.destinationsWithoutOrigin.first()

        when:
        service.minusDay(destination, trip)
        service.minusDay(destination, trip)

        then:
        def exception = thrown(ServiceException)
        exception.status == HttpStatus.BAD_REQUEST
        exception.message == "daysCannotBeEmpty"
    }
}
