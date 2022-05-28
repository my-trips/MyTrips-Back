package ar.com.mytrips

import ar.com.mytrips.destination.Transport
import ar.com.mytrips.request.TransportCommand
import grails.gorm.services.Service

import javax.transaction.Transactional
import java.time.LocalDateTime

@Service(Transport)
@Transactional
class TransportService {

    def update(Trip trip, Transport transport, TransportCommand transportCommand) {
        transport.properties = transportCommand.changes()
        transport.updateDestinationDates()
        trip.save()
    }
}
