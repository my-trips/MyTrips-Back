package ar.com.mytrips

import ar.com.mytrips.auth.User
import ar.com.mytrips.destination.Destination
import ar.com.mytrips.destination.Place
import ar.com.mytrips.destination.Transport
import ar.com.mytrips.request.TransportCommand
import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

import java.time.LocalDateTime

class TransportServiceTest extends Specification implements DomainUnitTest<Transport> {

    private TransportService transportService
    private List<Destination> destinations
    private Trip trip
    private Transport transport
    private TransportCommand transportCommand

    def setup() {
        transportService = new TransportService()

        def destFin = new Destination(relevance: 4, color: "green", place: new Place(),
                arriveDate: LocalDateTime.of(2020, 10, 14, 12, 50, 00),
                departDate: null,
                departTransport: new Transport())

        def paramsDestSantiago = HashMap.of("relevance", 3,
                "color", "green", "place", new Place(),
                "arriveDate", LocalDateTime.of(2022, 10, 12, 12, 50, 00),
                "departDate", LocalDateTime.of(2022, 10, 14, 12, 50, 00),
                "departTransport", new Transport(destination: destFin))

        def destSantiago = Destination.create(paramsDestSantiago)

        def paramsDestLima = HashMap.of("relevance", 2,
                "color", "yellow", "place", new Place(),
                "arriveDate", LocalDateTime.of(2022, 10, 10, 12, 50, 00),
                "departDate",LocalDateTime.of(2022, 10, 12, 12, 50, 00),
                "departTransport", new Transport(destination: destSantiago))

        def destLima = Destination.create(paramsDestLima)

        transport = new Transport(HashMap.of("type", TransportType.FLY,
                    "arrive", LocalDateTime.of(2022, 10, 10, 12, 50, 00),
                    "depart", LocalDateTime.of(2022, 10, 10, 12, 50, 00),
                    "arriveLocation", "Lima",
                    "departLocation", "Buenos Aires",
                    "cost", new Cost(),
                    "destination", destLima))

        def paramsInit = HashMap.of("relevance", 1,
                "color", "", "place", new Place(),
                "departDate", LocalDateTime.of(2020, 10, 10, 12, 50, 00),
                "departTransport", transport)

        def destInit = Destination.create(paramsInit)

        destinations = [destInit, destLima, destSantiago, destFin]

        trip = new Trip(deleted: false, owner: new User(), image: "image",
                lastUpdated: LocalDateTime.now())
        trip.addDestinations(destinations)
    }

    def cleanup() { }

    void "when update the type of transport between two destinations of a trip, it should return an updated transport"() {
        given:
        transportCommand = new TransportCommand(
                type: TransportType.TRAIN,
                "arrive": "2022-10-10T12:50:00.000",
                "depart": "2022-10-10T12:50:00.000"
        )

        when:
        def resultTransport= transportService.update(trip, transport, transportCommand)

        then:
        resultTransport.getType() == TransportType.TRAIN
        resultTransport.getArrive().toString() == "2022-10-10T12:50"
        resultTransport.getDepart().toString() == "2022-10-10T12:50"
    }

    void "when update the arrival and departure dates of a transport between two destinations of a trip, it should return an updated transport"() {
        given:
        transportCommand = new TransportCommand(
                type: TransportType.FLY,
                "arrive": "2022-10-16T12:50:00.000",
                "depart": "2022-10-12T12:50:00.000"
        )

        when:
        def resultTransport= transportService.update(trip, transport, transportCommand)

        then:
        resultTransport.getType() == TransportType.FLY
        resultTransport.getArrive().toString() == "2022-10-16T12:50"
        resultTransport.getDepart().toString() == "2022-10-12T12:50"
        resultTransport.getOrigin().getDepartDate().toString() == "2022-10-12T12:50"
        resultTransport.getDestination().getArriveDate().toString() == "2022-10-16T12:50"
    }
}
