package ar.com.mytrips.destination

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
    String country
    List<Double> bbox

    static hasMany = [bbox: Double]
    static belongsTo = [destination: Destination]

    static constraints = {
        latitude nullable: true
        longitude nullable: true
        district nullable: true
        region nullable: true
        country nullable: true
    }
    static mapping = {
        id generator: 'uuid'
    }

}
