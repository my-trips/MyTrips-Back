package ar.com.mytrips

import grails.gorm.services.Service

@Service(Trip)
class TripService {
    TriposoService triposoService


    def get(String id) {
        Trip.get(id)
    }

    def list(Integer max = 25, Integer offset = 0 ) {
        Trip.findAll([max:max, offset:offset])
    }

    Trip create(Trip trip){
        trip.destinations.forEach{
            def dayPlanner = triposoService.getDayPlanner(it.place.country, it.place.name, it.arrive, it.depart)
            if(dayPlanner){
                it.setDataFromPanner(dayPlanner, trip)
            }
        }
        trip.save()
    }

}
