package ar.com.mytrips.destination

import ar.com.mytrips.request.TriposoActivity
import ar.com.mytrips.request.TriposoPoi

class Attraction {
    String id
    String description
    String name
    String snippet
    Double longitude
    Double latitude
    Double score
    String link
    String direction
    String referenceId

    static belongsTo = [place:Place]

    static hasMany = [images:String, labels:String]

    static constraints = {
        images nullable: true
        longitude nullable: true
        latitude nullable: true
        snippet nullable: true
        description nullable: true
        score nullable: true
        link nullable: true
        direction nullable: true
        labels nullable: true
        referenceId nullable: true
    }

    static embedded = ['cost']

    static mapping = {
        description type: "text"
        snippet type: "text"
        images joinTable:[name:'attraction_images', key:'attraction_id', column:'image', type:"text"]
        labels joinTable:[name:'attraction_labels', key:'attraction_id', column:'label', type:"text"]
        id generator: 'uuid'
    }

    static Attraction fromTriposo(Place place, TriposoPoi poi){
        return new Attraction(referenceId:poi.id, place:place, description: poi.description, name: poi.name, snippet: poi.snippet,
                images: poi.images.collect{it.sourceUrl}.toSet(), latitude: poi.coordinates?.latitude,
                longitude: poi.coordinates?.longitude, link: poi.link, direction: poi.direction,
                title: poi.labels?.subList(0, Math.min(poi.labels?.size()?:0, 3)))
    }

    static Attraction getByTriposo(Place place, TriposoActivity activity) {
        def attraction = findByReferenceIdOrName(activity.poi.id, activity.poi.name)
        if(!attraction){
            attraction = fromTriposo(place, activity.poi)
            attraction.description = activity.description
            attraction.labels = activity.title.isEmpty()? [] : [activity.title]
            attraction.save()
        }
        return attraction
    }

}
