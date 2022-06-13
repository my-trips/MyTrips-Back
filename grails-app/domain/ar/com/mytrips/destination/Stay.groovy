package ar.com.mytrips.destination

import ar.com.mytrips.Cost
import ar.com.mytrips.Currency
import java.time.LocalDateTime

class Stay {

    String id
    String title
    String name
    String address
    Double longitude
    Double latitude
    String notes
    LocalDateTime checkIn
    LocalDateTime checkOut
    Cost cost
    String confirmation
    String placeReservation
    String link

    static belongsTo = [destination:Destination]

    static constraints = {
        title nullable: true
        address nullable: true
        longitude nullable: true
        latitude nullable: true
        notes nullable: true
        checkIn nullable: true
        checkOut nullable: true
        cost nullable: true
        placeReservation nullable: true
        confirmation nullable: true
        link nullable: true
    }

    static embedded = ['cost']

    static mapping = {
        id generator: 'uuid'
        notes type: "text"
    }

    Map<Currency, Cost> addCost(Map<Currency, Cost> cost) {
        this.cost?.accumulate(cost)
    }
}


