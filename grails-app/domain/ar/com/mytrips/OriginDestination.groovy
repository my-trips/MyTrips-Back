package ar.com.mytrips

import java.time.LocalDate

class OriginDestination {

    String id
    String name
    LocalDate date
    String image
    TransportType transport

    static constraints = {
        image nullable: true
    }
    static mapping = {
        id generator: 'uuid'
    }
}
