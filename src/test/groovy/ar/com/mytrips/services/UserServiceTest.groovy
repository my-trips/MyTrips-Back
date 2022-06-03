package ar.com.mytrips.services

import ar.com.mytrips.UserService
import ar.com.mytrips.auth.Role
import ar.com.mytrips.auth.User
import ar.com.mytrips.auth.UserRole
import ar.com.mytrips.exception.ServiceException
import com.google.common.collect.Lists
import grails.plugin.springsecurity.SpringSecurityService
import grails.plugin.springsecurity.rest.authentication.RestAuthenticationEventPublisher
import grails.plugin.springsecurity.rest.token.AccessToken
import grails.plugin.springsecurity.rest.token.generation.TokenGenerator
import grails.plugin.springsecurity.rest.token.storage.TokenStorageService
import grails.testing.services.ServiceUnitTest
import org.springframework.http.HttpStatus
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

class UserServiceTest extends MyTripServiceTest implements ServiceUnitTest<UserService> {

    void setupSpec() {
        mockDomain User
        mockDomain Role
        mockDomain UserRole
    }

    private SpringSecurityService springSecurityService
    private AuthenticationManager authenticationManager
    private TokenGenerator tokenGenerator
    private TokenStorageService tokenStorageService
    private RestAuthenticationEventPublisher authenticationEventPublisher
    private User user

    def setup() {

        springSecurityService = Mock()
        authenticationManager = Mock()
        tokenStorageService = Mock()
        authenticationEventPublisher = Mock()
        tokenGenerator = Mock()

        service.setTokenStorageService(tokenStorageService)
        service.setAuthenticationEventPublisher(authenticationEventPublisher)

        user = new User(HashMap.of("firstName", "Susan",
                "lastName", "Rosito",
                "email", "rosisusa@gmail.com",
                "password", "12345"))

        springSecurityService.encodePassword(user.password) >> "ENCODE_PASSWORD"
        service.setSpringSecurityService(springSecurityService)

        def authority = Lists.newArrayList(new SimpleGrantedAuthority("ROLE_NO_ROLES"))
        def userName = new UsernamePasswordAuthenticationToken("rosisusa@gmail.com", "Susan12#", authority)
        authenticationManager.authenticate(_ as UsernamePasswordAuthenticationToken) >> userName
        service.setAuthenticationManager(authenticationManager)

        def role = new Role(HashMap.of("authority", "ROLE_USER"))
        role.save()

        tokenGenerator.generateAccessToken(_ as UserDetails) >> new AccessToken("TOKEN")
        service.setTokenGenerator(tokenGenerator)
    }

    def cleanup() { }

    void "when create a user, it should return an access token"() {
        when:
        def accessToken = service.save(user)

        then:
        accessToken.getAccessToken() == "TOKEN"
        user.id == 1
        user.authorities.stream().anyMatch( role -> role.authority == "ROLE_USER")
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
