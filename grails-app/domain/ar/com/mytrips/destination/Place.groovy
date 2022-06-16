package ar.com.mytrips.destination

import ar.com.mytrips.Country
import ar.com.mytrips.request.TriposoLocation

class Place {

    String id
    String placeId
    String name
    String placeName
    Double latitude
    Double longitude
    String district
    String region
    Country country
    List<Double> bbox
    String description
    String type
    String shortDescription

    static hasMany = [bbox: Double, images: String]
    static embedded = ['country']

    static constraints = {
        images nullable: true
        latitude nullable: true
        longitude nullable: true
        district nullable: true
        region nullable: true
        country nullable: true
        bbox nullable: true
        placeId nullable: true
        description  nullable: true
        type  nullable: true
        shortDescription  nullable: true
    }
    static mapping = {
        id generator: 'uuid'
        description type: 'text'
        shortDescription  type: 'text'
        images cascade: "all", joinTable:[name:'place_images', key:'place_id', column:'image', type:"text"]
    }

    def setDataFromLocation(TriposoLocation location) {
        placeId = location.id
        description = location.intro
        type = location.type
        shortDescription = location.snippet
        images = location.images.collect{ it.sourceUrl}.toSet()
    }

}
