package ar.com.mytrips.destination

import ar.com.mytrips.Country

class Place {

    String id
    String placeId
    Integer relevance
    String name
    String placeName
    Double latitude
    Double longitude
    String district
    String region
    Country country
    List<Double> bbox

    static hasMany = [bbox: Double]
    static belongsTo = [destination: Destination]
    static embedded = ['country']

    static constraints = {
        latitude nullable: true
        longitude nullable: true
        district nullable: true
        region nullable: true
        country nullable: true
        bbox nullable: true
        placeId nullable: true
        relevance nullable: true
    }
    static mapping = {
        id generator: 'uuid'
    }

    Place duplicate(Destination destination){
        new Place(this.properties +  [destination: destination, id:null])
    }

}