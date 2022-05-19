package ar.com.mytrips

import ar.com.mytrips.destination.Transport

import java.time.LocalDate

class OriginDestination {

    String id
    String name
    String country
    LocalDate date
    String image
    Transport transport

    static constraints = {
        image nullable: true
        transport nullable: true
    }
    static mapping = {
        id generator: 'uuid'
    }
}
