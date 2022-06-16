package ar.com.mytrips


import ar.com.mytrips.destination.Place
import grails.gorm.services.Service

import javax.transaction.Transactional

@Service(Place)
@Transactional
class PlaceService {

    Place get(String id) {
        return Place.get(id)
    }

    Place getByCountryAndName(String country, String name) {
        return Place.findByName(name)
    }

    List<Place> trending() {
        Place.executeQuery("""
        select place
        from Destination destination
         join destination.place place
         group by place
         order by count(place) desc
        """, [], [max:6])
    }
}
