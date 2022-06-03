package ar.com.mytrips

import ar.com.mytrips.auth.Role
import ar.com.mytrips.auth.User
import ar.com.mytrips.auth.UserRole
import ar.com.mytrips.exception.ServiceException
import grails.plugin.springsecurity.SpringSecurityService
import grails.testing.services.ServiceUnitTest
import org.springframework.http.HttpStatus

class UserServiceTest extends MyTripServiceTest implements ServiceUnitTest<UserService> {

    void setupSpec() {
        mockDomain User
        mockDomain Role
        mockDomain UserRole
    }

    private SpringSecurityService springSecurityService
    private User user

    def setup() {
        springSecurityService = Mock()

        user = new User(HashMap.of("firstName", "Susan",
                "lastName", "Rosito",
                "email", "rosisusa@gmail.com",
                "password", "12345"))

        springSecurityService.encodePassword(user.password) >> "ENCODE_PASSWORD"
        service.springSecurityService =  springSecurityService

        def role = new Role(HashMap.of("authority", "ROLE_USER"))
        role.save()
    }

    def cleanup() { }

    void "when create a user, it should return an access token"() {
        when:
        service.save(user)

        then:
        user.id != null
        user.authorities.every{ role -> role.authority == "ROLE_USER" }
    }

    void "when create a user, but there exists a user with the same email, it should throw an exception"() {
        given:
        user.save()
        user = new User(HashMap.of("firstName", "Iris",
                "lastName", "Raza",
                "email", "rosisusa@gmail.com",
                "password", "25643"))
        when:
        service.save(user)

        then:
        def exception = thrown(ServiceException)
        exception.status == HttpStatus.BAD_REQUEST
        exception.message == "duplicateEmail: [email:rosisusa@gmail.com]"
    }
}
