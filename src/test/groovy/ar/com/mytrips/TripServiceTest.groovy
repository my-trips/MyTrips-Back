package ar.com.mytrips

import ar.com.mytrips.external.TriposoService
import ar.com.mytrips.external.UnsplashService
import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class TripServiceTest extends Specification implements DomainUnitTest<Trip> {

    private TripService tripService
    private TriposoService triposoService
    private UnsplashService unsplashService
    private UserService userService

    def setup() {
        triposoService = Mock()
        unsplashService = Mock()
        userService = Mock()
    }

    def cleanup() {
    }

    void "test something"() {
        expect:"fix me"
        true
    }
}
