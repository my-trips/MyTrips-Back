package ar.com.mytrips.request

import ar.com.mytrips.Cost
import ar.com.mytrips.OriginDestination
import ar.com.mytrips.TransportType
import ar.com.mytrips.Trip
import ar.com.mytrips.auth.User
import ar.com.mytrips.destination.Destination
import ar.com.mytrips.destination.Place
import ar.com.mytrips.destination.Transport
import io.micronaut.core.annotation.Introspected

class CreateTripRequest implements ModelRequest<Trip> {
    OriginDestinationCommand startDestination
    OriginDestinationCommand endDestination
    List<DestinationCommand> destinations

    @Override
    Trip toModel() {
        def trip = new Trip(startDestination.toModel(), endDestination.toModel())
        trip.destinations = destinations.collect{it.toModel(trip)}
        trip
    }
}

class OriginDestinationCommand implements ModelRequest<OriginDestination> {
    String name
    String country
    String date
    TransportCommand transport

    static constraints = {
        transport nullable: true
        name(blank: false)
        date nullable: false
    }

    @Override
    OriginDestination toModel() {
        def params = changes()
        if(transport){
            params.transport = transport.toModel()
        }
        new OriginDestination(params)
    }

    @Override
    Map<String, Closure> getTransformations() {
        ["date": STRING_TO_DATE]
    }

}

@Introspected
class DestinationCommand  implements ModelRequest<Destination> {
    Integer relevance
    String color
    TransportCommand transport
    String arrive
    String depart
    PlaceCommand place

    Destination toModel(Trip trip) {
        def params = changes()
        params.place = place.toModel()
        params.transport = transport.toModel()
        params.trip = trip
        Destination.create(params)
    }

    @Override
    Map<String, Closure> getTransformations() {
        ["arrive": STRING_TO_DATETIME, "depart": STRING_TO_DATETIME]
    }
}

class PlaceCommand  implements ModelRequest<Place>  {
    String placeId
    Integer relevance
    String name
    String placeName
    Double latitude
    Double longitude
    String district
    String region
    String country
    List<Double> bbox

    @Override
    Place toModel() {
        new Place(changes())
    }
}

class TransportCommand  implements ModelRequest<Transport>  {
    String id
    TransportType type
    String depart
    String arrive
    String line
    String confirmation
    String number
    String departLocation
    String arriveLocation
    Cost cost

    static constraints = {
        id nullable: true
        confirmation nullable: true
        line  nullable: true
        departLocation nullable: true
        arriveLocation nullable: true
        number nullable: true
        cost nullable: true
    }

    @Override
    Transport toModel() {
        new Transport(changes())
    }

    @Override
    Map<String, Closure> getTransformations() {
        ["arrive": STRING_TO_DATETIME, "depart": STRING_TO_DATETIME]
    }
}

class CreateUserRequest implements ModelRequest<User> {
    String firstName
    String lastName
    String email
    String password

    @Override
    User toModel() {
        new User(changes())
    }
}