package ar.com.mytrips

import ar.com.mytrips.exception.ServiceException
import grails.gorm.services.Service
import javax.transaction.Transactional
import static grails.async.Promises.*


@Service(Trip)
@Transactional
class TripService {
    TriposoService triposoService
    UserService userService


    def get(String id) {
        Trip.findByIdAndOwnerAndDeleted(id, userService.currentUser, false)
    }

    def list(Integer max = 25, Integer offset = 0 ) {
        Trip.findAllByOwnerAndDeleted(userService.currentUser,false, [max:max, offset:offset])
    }

    Trip create(Trip trip){
        trip.owner = userService.getCurrentUser()
        def tasks = trip.destinationsWithoutOrigin.collect{destination ->
            task {
                def dayPlanner = triposoService.getDayPlanner(
                    destination.place.country, destination.place.name, destination.arriveDate, destination.departDate
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
        if(userService.currentUser != trip.owner){
            throw ServiceException.forbidden("invalidUser")
        }
        trip.deleted = true
        trip.save()
    }
}
