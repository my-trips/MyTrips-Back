package ar.com.mytrips.destination

import ar.com.mytrips.Cost
import ar.com.mytrips.Currency
import ar.com.mytrips.exception.ServiceException

import java.time.LocalDate


class Day {

    String id
    LocalDate date
    List<Activity> activities = []

    static belongsTo = [destination:Destination]

    static hasMany = [activities: Activity]
    static mapping = {
        id generator: 'uuid'
        activities cascade: 'all', sort: 'startTime'
    }

    LocalDate plusDay(Integer day) {
        date.plusDays(day)
    }
    LocalDate minusDay(Integer day) {
        date.minusDays(day)
    }

    def removeActivity(Activity activity){
        if(!activities.contains(activity)){
            throw ServiceException.badRequest("invalidActivity")
        }
        activity.day = null
        removeFromActivities(activity)
        activity.delete()
    }

    def addActivity(Activity activity){
        activity.day = this
        addToActivities(activity)
    }

    Map<Currency, Cost> addCost(Map<Currency, Cost> cost){
        activities.forEach{it.addCost(cost)}
        cost
    }

    Day duplicate(Destination destination){
        def day = new Day(date:date, destination:destination )
        day.activities = activities.collect{ it.duplicate(day)}
        day
    }

}
