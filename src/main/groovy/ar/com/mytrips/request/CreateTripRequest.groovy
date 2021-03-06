package ar.com.mytrips.request

import ar.com.mytrips.Cost
import ar.com.mytrips.TransportType
import ar.com.mytrips.Trip
import ar.com.mytrips.auth.User
import ar.com.mytrips.destination.*
import io.micronaut.core.annotation.Introspected

class CreateTripRequest implements ModelRequest<Trip> {
    List<DestinationCommand> destinations

    @Override
    Trip toModel() {
        def trip = new Trip()
        trip.addDestinations(destinations.collect{it.toModel(trip)})
        trip
    }
}

@Introspected
class DestinationCommand implements ModelRequest<Destination> {
    Integer relevance
    String color
    String arriveDate
    String departDate
    PlaceCommand place
    TransportCommand departTransport

    static constraints = {
        departTransport nullable: true
    }

    Destination toModel(Trip trip) {
        def params = changes()
        params.place = place.toModel()
        params.departTransport = departTransport?.toModel()
        params.trip = trip
        Destination.create(params)
    }

    @Override
    Map<String, Closure> getTransformations() {
        ["arriveDate": STRING_TO_DATETIME, "departDate": STRING_TO_DATETIME]
    }

    @Override
    Collection<String> getKeys() {
        return ["relevance"]
    }
}

class PlaceCommand implements ModelRequest<Place>  {
    String placeId
    Integer relevance
    String name
    String placeName
    Double latitude
    Double longitude
    String district
    String region
    CountryCommand country
    List<Double> bbox

    @Override
    Place toModel() {
        def place = Place.findByPlaceName(placeName)
        if(!place){
            def params = changes()
            params.country = country.toModel()
            place = new Place(params).save()
        }
        return place
    }
}

class TransportCommand implements ModelRequest<Transport>  {
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
        type nullable: true
        depart nullable: true
        arrive nullable: true
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

class UserCommand implements ModelRequest<User> {
    String firstName
    String lastName
    String email

    static constraints = {
        firstName nullable: true
        lastName nullable: true
        email nullable: true, email: true
    }

    @Override
    User toModel() {
        new User(changes())
    }
}


class UserPasswordCommand implements ModelRequest<User> {
    String currentPassword
    String password
    String confirmNewPassword

    static constraints = {
        confirmNewPassword nullable: true
    }

        @Override
    User toModel() {
        new User(changes())
    }
}

class CountryCommand implements ModelRequest<Country>  {
    String name
    String code

    @Override
    Country toModel() {
        def country = Country.findByNameOrCode(name, code)
        if(!country){
            country = new Country(changes()).save()
        }
        return country
    }
}


class ActivityCommand implements ModelRequest<Activity>  {
    String notes
    String startTime
    String endTime
    Cost cost
    Double score
    AttractionCommand attraction
    Boolean done

    static constraints = {
        notes nullable: true
        endTime nullable: true
        startTime nullable: true
        cost nullable: true
        score   nullable: true
        attraction nullable: true
        done nullable: true
    }

    @Override
    Activity toModel() {
        def values = changes()
        if(attraction){
            values.attraction = attraction.toModel()
        }

        new Activity(values)
    }

    @Override
    Map<String, Closure> getTransformations() {
        ["startTime": STRING_TO_TIME, "endTime": STRING_TO_TIME]
    }
}

class AttractionCommand implements ModelRequest<Attraction>  {
    String id
    String description
    String name
    String snippet
    Double longitude
    Double latitude
    Double score
    String link
    List<String> images
    List<String> labels

    static constraints = {
        id nullable: true
        description nullable: true
        name  nullable: true
        snippet nullable: true
        longitude nullable: true
        latitude nullable: true
        score   nullable: true
        link nullable: true
        images nullable: true
        labels nullable: true
    }

    @Override
    Attraction toModel() {
        def attraction = Attraction.get(id)
        if(!attraction){
            attraction = new Attraction(changes()).save()
        }
        return attraction
    }

}

class StayCommand implements ModelRequest<Stay>  {

    String title
    String name
    String address
    Double longitude
    Double latitude
    String notes
    String checkIn
    String checkOut
    Cost cost
    String placeReservation
    String confirmation
    String link

    static constraints = {
        title nullable: true
        name nullable: true
        address nullable: true
        longitude nullable: true
        latitude nullable: true
        notes nullable: true
        checkOut nullable: true
        checkIn nullable: true
        cost nullable: true
        placeReservation nullable: true
        confirmation nullable: true
        link nullable: true
    }

    @Override
    Stay toModel() { new Stay(changes()) }

    @Override
    Map<String, Closure> getTransformations() {
        ["checkIn": STRING_TO_DATETIME, "checkOut": STRING_TO_DATETIME]
    }
}

