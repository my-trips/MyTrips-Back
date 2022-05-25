package ar.com.mytrips


import ar.com.mytrips.request.TransportCommand
import grails.gorm.transactions.Transactional
import grails.plugin.springsecurity.annotation.Secured

@Transactional
@Secured("ROLE_USER")
class TransportController implements ModelRequestResolver {

    TransportService transportService

    def update(String tripId) {
        def request = getBody(TransportCommand)
        def transport = transportService.update(request)
        respond  transport, view: 'show'
    }

}
