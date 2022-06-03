package ar.com.mytrips


import ar.com.mytrips.destination.Destination
import grails.testing.gorm.DomainUnitTest

class DestinationServiceTest extends MyTripTest implements DomainUnitTest<Destination> {

    private DestinationService destinationService

    def setup() {
        destinationService = new DestinationService()
    }

    def "when a trip is added a day to one of its destinations, it should return the updated destination"() {
        given:
        def destination = trip.getDestinations()[1]
        def destinationNext = destination.getDepartTransport().getDestination()
        def expectedDate = "2022-10-13T12:50"
        def expectedDestDays = 2
        def expectedDestNextDays = 1

        when:
        destinationService.plusDay(destination, trip)

        then:
        destination.getDepartDate().toString() == expectedDate
        destination.getDays().size() > expectedDestDays
        destinationNext.getArriveDate().toString() == expectedDate
        destinationNext.getDays().size() == expectedDestNextDays
    }

    def "hen a trip is subtract a day to one of its destinations, it should return the updated destination"() {
        given:
        def destination = trip.getDestinations()[1]
        def destinationNext = destination.getDepartTransport().getDestination()
        def expectedDate = "2022-10-11T12:50"
        def expectedDestDays = 1
        def expectedDestNextDays = 2

        when:
        destinationService.minusDay(destination, trip)

        then:
        destination.getDepartDate().toString() == expectedDate
        destination.getDays().size() == expectedDestDays
        destinationNext.getArriveDate().toString() == expectedDate
        destinationNext.getDays().size() > expectedDestNextDays
    }
}
