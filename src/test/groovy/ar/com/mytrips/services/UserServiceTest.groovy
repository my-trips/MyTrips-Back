package ar.com.mytrips.services

import ar.com.mytrips.UserService
import ar.com.mytrips.auth.Role
import ar.com.mytrips.auth.User
import ar.com.mytrips.auth.UserRole
import ar.com.mytrips.exception.ServiceException
import ar.com.mytrips.request.UserCommand
import ar.com.mytrips.request.UserPasswordCommand
import grails.plugin.springsecurity.SpringSecurityService
import grails.testing.services.ServiceUnitTest
import org.springframework.http.HttpStatus
import org.springframework.security.crypto.password.PasswordEncoder

class UserServiceTest extends MyTripServiceTest implements ServiceUnitTest<UserService> {

    void setupSpec() {
        mockDomain User
        mockDomain Role
        mockDomain UserRole
    }

    private SpringSecurityService springSecurityService
    private PasswordEncoder passwordEncoder
    private User user
    private User otherUser

    def setup() {
        springSecurityService = Mock()
        passwordEncoder = Mock()

        user = new User(firstName:"Susan", lastName: "Rosito", email:"rosisusa@gmail.com", password:"12345")
        otherUser = new User(firstName:"Martin", lastName: "Gerald", email:"rosi.mart@gmail.com", password:"34234")

        springSecurityService.encodePassword(user.password) >> "ENCODE_PASSWORD"

        springSecurityService.currentUser >> user
        springSecurityService.passwordEncoder >> passwordEncoder
        service.springSecurityService =  springSecurityService

        def role = new Role("authority": "ROLE_USER")
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

    void "when get a user for email, if the user exists it should return it"() {
        given:
        user.save()

        when:
        def resultUser = service.getByEmail(user.email)

        then:
        resultUser.id == user.id
        resultUser.firstName == user.firstName
        resultUser.lastName == user.lastName
        resultUser.email == user.email
        resultUser == user
    }

    void "when fetch a user for email, if the user exists it should return it"() {
        given:
        user.save()

        when:
        def users = service.search("rosisusa@gmail.com")

        then:
        users.size() == 1
        users.first() == user
    }

    void "when I search by email, it returns the users that match"() {
        given:
        user.save()
        otherUser.save()

        when:
        def users = service.search("rosi")

        then:
        users.size() == 2
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
        otherUser.save()

        when:
        def users = service.search("Gera")

        then:
        users.size() == 1
        users.first() == otherUser
    }

    void "when I search for a nonexistent value, it should return an empty list"() {
        given:
        user.save()

        when:
        def users = service.search("anUser")

        then:
        users.isEmpty()
    }

    void "when get the profile data of the logged in user, it should return it"() {
        given:
        user.save()

        when:
        def currentUser = service.getCurrentUser()

        then:
        currentUser.firstName == "Susan"
        currentUser.lastName == "Rosito"
        currentUser.email == "rosisusa@gmail.com"
    }

    void "when update a profile for a user, it should return an updated profile"() {
        given:
        user.save()
        def changedProfile = new UserCommand(
                "firstName": "Marta",
                "lastName": "Haya",
                "email": "conso.suro@gmail.com"
        )

        when:
        def updatedProfileUser = service.updateProfile(user, changedProfile)

        then:
        updatedProfileUser.firstName == "Marta"
        updatedProfileUser.lastName == "Haya"
        updatedProfileUser.email == "conso.suro@gmail.com"
    }

    void "when update the password for a user, it should update the password"() {
        given:
        user.save()
        passwordEncoder.matches(_ as String, _ as String) >> true
        springSecurityService.encodePassword("RrtFs432") >> "OTHER_ENCODE_PASSWORD"
        def changedPassword = new UserPasswordCommand("currentPassword": "12345", "password": "RrtFs432")

        when:
        def updatedPasswordUser = service.updatePassword(user, changedPassword)

        then:
        updatedPasswordUser.password == "OTHER_ENCODE_PASSWORD"
    }

    void "when update the password for a user, if the current password does not match, it should throw an exception"() {
        given:
        user.save()
        passwordEncoder.matches(_ as String, _ as String) >> false
        def changedPassword = new UserPasswordCommand("currentPassword": "RrtFs432", "password": "12345")

        when:
        service.updatePassword(user, changedPassword)

        then:
        def exception = thrown(ServiceException)
        exception.status == HttpStatus.BAD_REQUEST
        exception.message == "wrongCurrentPassword"
    }
}
