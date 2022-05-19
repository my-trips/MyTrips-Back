package ar.com.mytrips


import ar.com.mytrips.request.TransportCommand
import grails.gorm.transactions.Transactional

@Transactional
class TransportController implements ModelRequestResolver {

    TransportService transportService

    def update() {
        def request = getBody(TransportCommand)
        def transport = transportService.update(request)
        respond  transport, view: 'show'
    }

}
