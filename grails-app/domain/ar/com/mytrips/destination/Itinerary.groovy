package ar.com.mytrips.destination

import ar.com.mytrips.request.TriposoItinerary

class Itinerary {
    String id
    String title
    String description
    String name
    String snippet
    Double longitude
    Double latitude

    static hasMany = [images:String]

    static constraints = {
        title nullable: true
        images nullable: true
        longitude nullable: true
        latitude nullable: true
        snippet nullable: true
        description nullable: true
    }

    static mapping = {
        description type: "text"
        snippet type: "text"
        id generator: 'uuid'
    }

    static Itinerary fromTriposo(TriposoItinerary itinerary){
        return new Itinerary(title: itinerary.title, description: itinerary.description, name: itinerary.poi.name,
        snippet: itinerary.poi.snippet, images: itinerary.poi.images.collect{it.sourceUrl}, latitude: itinerary.poi.latitude,
        longitude: itinerary.poi.longitude)
    }
}
