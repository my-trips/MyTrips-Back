package ar.com.mytrips

import grails.gorm.services.Service
import javax.transaction.Transactional

@Service(Trip)
@Transactional
class TripService {
    TriposoService triposoService


    def get(String id) {
        Trip.findByIdAndDeleted(id, false)
    }

    def list(Integer max = 25, Integer offset = 0 ) {
        Trip.findAllByDeleted(false, [max:max, offset:offset])
    }

    Trip create(Trip trip){
        trip.destinations.forEach{
            def dayPlanner = triposoService.getDayPlanner(it.place.country, it.place.name, it.arrive, it.depart)
            if(dayPlanner){
                it.setDataFromPlanner(dayPlanner, trip)
            }
        }
        trip.save()
    }

    def delete(Trip trip) {
        trip.deleted = true
        trip.save()
    }
}
