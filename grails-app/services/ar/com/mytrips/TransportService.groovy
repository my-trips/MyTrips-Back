package ar.com.mytrips

import ar.com.mytrips.destination.Transport
import ar.com.mytrips.request.TransportCommand
import grails.gorm.services.Service

import javax.transaction.Transactional

@Service(Transport)
@Transactional
class TransportService {

    def update(TransportCommand transportCommand) {
        def transport = Transport.get(transportCommand.id)
        transport.properties = transportCommand.changes()
        transport.save()
    }
}
