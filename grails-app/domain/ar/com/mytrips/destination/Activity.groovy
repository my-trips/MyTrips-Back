package ar.com.mytrips.destination

import ar.com.mytrips.Cost
import ar.com.mytrips.Currency
import ar.com.mytrips.request.TriposoActivity

import java.time.LocalTime

class Activity {
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
    Double score

    static belongsTo = [day:Day]
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
        score nullable: true
    }

    static embedded = ['cost']

    static mapping = {
        description type: "text"
        snippet type: "text"
        images joinTable:[name:'activity_images', key:'activity_id', column:'image', type:"text"]
        id generator: 'uuid'
        notes type: "text"
    }

    static Activity fromTriposo(TriposoActivity activity, Day day){
        return new Activity(day:day, title: activity.title, description: activity.description, name: activity.poi.name,
        snippet: activity.poi.snippet, images: activity.poi.images.collect{it.sourceUrl}.toSet(), latitude: activity.poi.coordinates?.latitude,
        longitude: activity.poi.coordinates?.longitude)
    }

    Map<Currency, Cost> addCost(Map<Currency, Cost> cost) {
        this.cost?.accumulate(cost)
    }

    Activity duplicate(Day day){
        new Activity(this.properties + [id:null, day:day, images: images.toList()])
    }
}
