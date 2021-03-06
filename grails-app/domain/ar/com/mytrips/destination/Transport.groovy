package ar.com.mytrips.destination

import ar.com.mytrips.Cost
import ar.com.mytrips.TransportType

import java.time.LocalDateTime

class Transport {
    String id
    TransportType type
    LocalDateTime depart
    LocalDateTime arrive
    String line
    String confirmation
    String number
    String departLocation
    String arriveLocation
    Cost cost
    Destination destination

    static belongsTo = [origin:Destination]

    static constraints = {
        confirmation nullable: true
        line  nullable: true
        departLocation nullable: true
        arriveLocation nullable: true
        number nullable: true
        cost nullable: true
        origin nullable: true
        destination nullable: true
    }
    static embedded = ['cost']

    static mapping = {
        id generator: 'uuid'
        origin cascade: "all"
        destination cascade: "all"
    }

    def updateDestinationDates(){
        if(origin){
            origin.departDate = depart
        }

        if(destination && destination.arriveDate != arrive ){
            destination.updateArriveDate(arrive)
        }
    }

    Transport duplicate(Destination destination){
        new Transport(this.properties + [origin:destination, id:null, destination:null])
    }
}
