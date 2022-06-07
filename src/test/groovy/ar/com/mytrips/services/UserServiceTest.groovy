package ar.com.mytrips.services

import ar.com.mytrips.UserService
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

        user = new User(firstName:"Susan", lastName: "Rosito", email:"rosisusa@gmail.com", password:"12345")

        springSecurityService.encodePassword(user.password) >> "ENCODE_PASSWORD"
        service.springSecurityService =  springSecurityService

        def role = new Role(HashMap.of("authority", "ROLE_USER"))
        role.save()
    }

    def cleanup() { }

    void "when create a user, it should return an user with authorities"() {
        when:
        service.save(user)

        then:
        user.id != null
        user.authorities.every{ role -> role.authority == "ROLE_USER" }
    }

    void "when create a user, but there exists a user with the same email, it should throw an exception"() {
        given:
        user.save()
        user = new User(firstName:"Iris", lastName: "Raza", email:"rosisusa@gmail.com", password:"25643")
        when:
        service.save(user)

        then:
        def exception = thrown(ServiceException)
        exception.status == HttpStatus.BAD_REQUEST
        exception.message == "duplicateEmail: [email:rosisusa@gmail.com]"
    }

    void "when fetch a user for id, if the user exists it should return it"() {
        given:
        user.save()

        when:
        def retrievedUser = service.get(user.id)

        then:
        retrievedUser.id == user.id
        retrievedUser.email == user.email
        retrievedUser.firstName == user.firstName
        retrievedUser == user
    }

    void "when I search by email, it returns the users that match"() {
        given:
        user.save()

        when:
        def users = service.search("rosisusa")

        then:
        users.size() == 1
        users.first() == user
    }

    void "when I search by firstName, it returns the users that match"() {
        given:
        user.save()

        when:
        def users = service.search("Susa")

        then:
        users.size() == 1
        users.first() == user
    }

    void "when I search by lastName, it returns the users that match"() {
        given:
        user.save()

        when:
        def users = service.search("Rosi")

        then:
        users.size() == 1
        users.first() == user
    }

    void "when I search for a nonexistent value, it should return an empty list"() {
        given:
        user.save()

        when:
        def users = service.search("anUser")

        then:
        users.isEmpty()
    }
}
