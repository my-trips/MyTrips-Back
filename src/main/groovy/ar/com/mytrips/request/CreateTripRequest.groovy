package ar.com.mytrips.request

import ar.com.mytrips.OriginDestination
import ar.com.mytrips.TransportType
import ar.com.mytrips.Trip
import ar.com.mytrips.destination.Destination
import ar.com.mytrips.destination.Place
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
    String date
    TransportType transport

    static constraints = {
        transport nullable: true
        name(blank: false, minSize: 6)
        date nullable: false
    }

    @Override
    OriginDestination toModel() {
        new OriginDestination(changes())
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
    TransportType transport
    String arrive
    String depart
    PlaceCommand place

    Destination toModel(Trip trip) {
        def params = changes()
        params.place = place.toModel()
        params.trip = trip
        new Destination(params)
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