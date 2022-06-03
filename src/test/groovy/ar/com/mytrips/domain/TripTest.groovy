package ar.com.mytrips.domain

import ar.com.mytrips.Cost
import ar.com.mytrips.Currency
import ar.com.mytrips.Trip
import grails.testing.gorm.DomainUnitTest

class TripTest extends MyTripTest implements DomainUnitTest<Trip> {

    def "when destinations are added to a trip, it must return the updated trip."() {
        when:
        domain.addDestinations(destinations)

        then:
        domain.destinations.size() > 0
        domain.firstDestination.place.name == "Lima"
        domain.firstDestination.nextDestination().place.name == "Santiago"
    }

    def "when total days of a trip is requested, it should return the number of days."() {
        when:
        domain.addDestinations(destinations)
        def expectedTotalDays = 4

        then:
        domain.totalDays == expectedTotalDays
    }

    def "when a trip is asked for the start date, it should return it."() {
        when:
        domain.addDestinations(destinations)
        def expectedStartDate = "2022-10-10"

        then:
        domain.startDate.toString() == expectedStartDate
    }

    def "when a trip is asked for the end date, it should return it."() {
        when:
        domain.addDestinations(destinations)
        def expectedEndDate = "2022-10-14"

        then:
        domain.endDate.toString() == expectedEndDate
    }

    def "when a trip is asked for the first destination, it should return it."() {
        when:
        domain.addDestinations(destinations)
        def expectedRelevance = 2
        def expectedName = "Lima"

        then:
        domain.firstDestination.relevance == expectedRelevance
        domain.firstDestination.place.name == expectedName
    }

    def "when a trip is asked for the destinations without origin, it should return it."() {
        when:
        domain.addDestinations(destinations)
        def expectedSizeDestination = 2

        then:
        domain.destinations.size() > domain.destinationsWithoutOrigin.size()
        domain.destinationsWithoutOrigin.size() == expectedSizeDestination
    }

    def "when a trip is asked for the total cost, it should return it."() {
        when:
        domain.addDestinations(destinations)
        def expectedAmount = domain.firstDestination.departTransport.cost

        then:
        domain.totalCost.size() > 0
        domain.totalCost.get(Currency.ARS) == expectedAmount
    }

    def "when ask a trip if a destination is not the last, and it is not, it should return true."() {
        when:
        domain.addDestinations(destinations)

        then:
        domain.isNotLastDestination(domain.firstDestination)
    }
}
