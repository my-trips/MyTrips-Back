package ar.com.mytrips


import ar.com.mytrips.request.TransportCommand
import grails.testing.services.ServiceUnitTest

class TransportServiceTest extends MyTripServiceTest implements ServiceUnitTest<TransportService> {

    private TransportCommand transportCommand


    void "when update the type of transport between two destinations of a trip, it should return an updated transport"() {
        given:
        transportCommand = new TransportCommand(
                type: TransportType.TRAIN,
                "arrive": "2022-10-10T12:50:00.000",
                "depart": "2022-10-10T12:50:00.000"
        )

        when:
        def resultTransport= service.update(trip, transport, transportCommand)

        then:
        resultTransport.type == TransportType.TRAIN
        resultTransport.arrive.toString() == "2022-10-10T12:50"
        resultTransport.depart.toString() == "2022-10-10T12:50"
    }

    void "when update the arrival and departure dates of a transport between two destinations of a trip, it should return an updated transport"() {
        given:
        transportCommand = new TransportCommand(
                type: TransportType.FLY,
                "arrive": "2022-10-16T12:50:00.000",
                "depart": "2022-10-12T12:50:00.000"
        )

        when:
        def resultTransport= service.update(trip, transport, transportCommand)

        then:
        resultTransport.type == TransportType.FLY
        resultTransport.arrive.toString() == "2022-10-16T12:50"
        resultTransport.depart.toString() == "2022-10-12T12:50"
        resultTransport.origin.departDate.toString() == "2022-10-12T12:50"
        resultTransport.destination.arriveDate.toString() == "2022-10-16T12:50"
    }
}
