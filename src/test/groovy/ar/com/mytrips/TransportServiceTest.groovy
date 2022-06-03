package ar.com.mytrips


import ar.com.mytrips.destination.Transport
import ar.com.mytrips.request.TransportCommand
import grails.testing.gorm.DomainUnitTest

class TransportServiceTest extends MyTripTest implements DomainUnitTest<Transport> {

    private TransportService transportService
    private TransportCommand transportCommand

    def setup() {
        transportService = new TransportService()
    }

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
