package ar.com.mytrips

import ar.com.mytrips.auth.Role
import ar.com.mytrips.auth.User
import ar.com.mytrips.auth.UserRole
import com.google.common.collect.Lists
import grails.plugin.springsecurity.SpringSecurityService
import grails.plugin.springsecurity.rest.authentication.RestAuthenticationEventPublisher
import grails.plugin.springsecurity.rest.token.AccessToken
import grails.plugin.springsecurity.rest.token.generation.TokenGenerator
import grails.plugin.springsecurity.rest.token.storage.TokenStorageService
import grails.testing.gorm.DataTest
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import spock.lang.Specification

class UserServiceTest extends Specification implements DataTest {

    Class<?>[] getDomainClassesToMock(){
        return [User, Role, UserRole] as Class[]
    }

    private SpringSecurityService springSecurityService
    private AuthenticationManager authenticationManager
    private TokenGenerator tokenGenerator
    private TokenStorageService tokenStorageService
    private RestAuthenticationEventPublisher authenticationEventPublisher
    private UserService userService
    private User user

    def setup() {

        userService = new UserService()
        tokenStorageService = Mock()
        userService.setTokenStorageService(tokenStorageService)
        authenticationEventPublisher = Mock()
        userService.setAuthenticationEventPublisher(authenticationEventPublisher)

        user = new User(HashMap.of("firstName", "Susan",
                "lastName", "Rosito",
                "email", "rosisusa@gmail.com",
                "password", "12345"))

        springSecurityService = Mock()
        springSecurityService.encodePassword(user.password) >> "ENCODE_PASSWORD"
        userService.setSpringSecurityService(springSecurityService)

        authenticationManager = Mock()
        def authority = Lists.newArrayList(new SimpleGrantedAuthority("ROLE_NO_ROLES"))
        def userName = new UsernamePasswordAuthenticationToken("rosisusa@gmail.com", "Susan12#", authority)
        authenticationManager.authenticate(_ as UsernamePasswordAuthenticationToken) >> userName
        userService.setAuthenticationManager(authenticationManager)

        def role = new Role(HashMap.of("authority", "ROLE_USER"))
        role.save()

        tokenGenerator = Mock()
        tokenGenerator.generateAccessToken(_ as UserDetails) >> new AccessToken("TOKEN")
        userService.setTokenGenerator(tokenGenerator)
    }

    def cleanup() { }

    void "when create a user, it should return accessToken"() {
        when:
        def accessToken = userService.save(user)

        then:
        accessToken.getAccessToken() == "TOKEN"
        user.getId() == 1
    }

    void "when create a user, but there exists a user with the same email, it should throw an exception"() {
        when:
        def accessToken = userService.save(user)

        then:
        accessToken.getAccessToken() == "TOKEN"
    }
}
