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

    List<Place> placesForTrip(Trip trip) {
        Place.executeQuery("""
        select distinct place
        from Destination destination
            right join destination.place place
            join place.country country
         where country.id in :countries and place.id not in :places
         group by place
         order by count(place) desc
        """, [countries:trip.countries*.id, places: trip.places*.id], [max:3])
    }

    List<Place> trending() {
        Place.executeQuery("""
        select distinct place
        from Destination destination
         right join destination.place place
         group by place
         order by count(place) desc
        """, [], [max:6])
    }
}
