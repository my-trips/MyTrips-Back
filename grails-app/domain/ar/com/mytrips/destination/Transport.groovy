package ar.com.mytrips.destination

import ar.com.mytrips.TransportType

import java.time.LocalDateTime

class Transport {

    TransportType type
    LocalDateTime depart
    LocalDateTime arrive
    String line
    String confirmation
    String number
    String departLocation
    String arriveLocation

    static constraints = {
        confirmation nullable: true
        line  nullable: true
        departLocation nullable: true
        arriveLocation nullable: true
        number nullable: true
    }

    static mapping = {
        id generator: 'uuid'
    }
}
