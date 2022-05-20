package ar.com.mytrips

import grails.gorm.services.Service
import javax.transaction.Transactional
import static grails.async.Promises.*


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
        def tasks = trip.destinations.collect{destination ->
            task {
                def dayPlanner = triposoService.getDayPlanner(
                    destination.place.country, destination.place.name, destination.transport.arrive, destination.transport.depart
                )
                if (dayPlanner) {
                    destination.setDataFromPlanner(dayPlanner, trip)
                }
            }
        }
        waitAll(tasks)
        trip.save()
    }

    def delete(Trip trip) {
        trip.deleted = true
        trip.save()
    }
}
