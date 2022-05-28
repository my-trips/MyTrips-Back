package ar.com.mytrips.destination

import ar.com.mytrips.Cost
import ar.com.mytrips.Currency
import ar.com.mytrips.request.TriposoItinerary
import grails.compiler.GrailsCompileStatic

import java.time.LocalTime

@GrailsCompileStatic
class Itinerary {
    String id
    String title
    String description
    String name
    String snippet
    Double longitude
    Double latitude
    String notes
    LocalTime startTime
    LocalTime endTime
    Cost cost

    static hasMany = [images:String]

    static constraints = {
        title nullable: true
        images nullable: true
        longitude nullable: true
        latitude nullable: true
        snippet nullable: true
        description nullable: true
        notes nullable: true
        startTime nullable: true
        endTime nullable: true
        cost nullable: true
    }

    static embedded = ['cost']

    static mapping = {
        description type: "text"
        snippet type: "text"
        images joinTable:[name:'itinerary_images', key:'itinerary_id', column:'image', type:"text"]
        id generator: 'uuid'
        notes type: "text"
    }

    static Itinerary fromTriposo(TriposoItinerary itinerary){
        return new Itinerary(title: itinerary.title, description: itinerary.description, name: itinerary.poi.name,
        snippet: itinerary.poi.snippet, images: itinerary.poi.images.collect{it.sourceUrl}.toSet(), latitude: itinerary.poi.coordinates?.latitude,
        longitude: itinerary.poi.coordinates?.longitude)
    }

    Map<Currency, Cost> addCost(Map<Currency, Cost> cost) {
        this.cost?.accumulate(cost)
    }
}
