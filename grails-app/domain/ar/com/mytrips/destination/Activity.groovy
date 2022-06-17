package ar.com.mytrips.destination

import ar.com.mytrips.Cost
import ar.com.mytrips.Currency
import ar.com.mytrips.request.TriposoActivity

import java.time.LocalTime

class Activity {
    String id
    String notes
    LocalTime startTime
    LocalTime endTime
    Cost cost
    Double score
    Attraction attraction

    static belongsTo = [day:Day]

    static constraints = {
        notes nullable: true
        startTime nullable: true
        endTime nullable: true
        cost nullable: true
        score nullable: true
    }

    static embedded = ['cost']

    static mapping = {
        id generator: 'uuid'
        notes type: "text"
        attraction cascade: "all"
    }

    Map<Currency, Cost> addCost(Map<Currency, Cost> cost) {
        this.cost?.accumulate(cost)
    }

    Activity duplicate(Day day){
        new Activity(this.properties + [id:null, day:day])
    }

    static Activity fromTriposo(TriposoActivity activity, Day day){
        return new Activity(day:day, attraction: Attraction.getByTriposo(day.destination.place, activity))
    }
}
