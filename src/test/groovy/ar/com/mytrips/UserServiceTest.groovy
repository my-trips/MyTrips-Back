package ar.com.mytrips

import ar.com.mytrips.auth.*
import grails.plugin.springsecurity.SpringSecurityService
import grails.plugin.springsecurity.rest.authentication.RestAuthenticationEventPublisher
import grails.plugin.springsecurity.rest.token.generation.TokenGenerator
import grails.plugin.springsecurity.rest.token.storage.TokenStorageService
import grails.testing.gorm.DomainUnitTest
import org.springframework.security.authentication.AuthenticationManager
import spock.lang.Specification

class UserServiceTest extends Specification implements DomainUnitTest<User> {

    private SpringSecurityService springSecurityService
    private AuthenticationManager authenticationManager
    private TokenGenerator tokenGenerator
    private TokenStorageService tokenStorageService
    private RestAuthenticationEventPublisher authenticationEventPublisher
    private UserService userService
    private User user
    private Role role
/*

    User getCurrentUser(){
        springSecurityService.currentUser as User
    }

    AccessToken save(User user){
        if(User.findByEmail(user.email) != null){
            throw ServiceException.badRequest("duplicateEmail", [email: user.email])
        }
        def plainPassword = user.password
        user.password = springSecurityService.encodePassword(user.password)
        user.save()

        def role = Role.defaultRole
        UserRole.create user, role
        authenticate(user, plainPassword)
    }

    private AccessToken authenticate(User user, String password){
        def authorities = user.authorities.collect { new SimpleGrantedAuthority(it.authority) }

        def usernameAuth= new UsernamePasswordAuthenticationToken(user.email, password, authorities);
        def auth = authenticationManager.authenticate(usernameAuth)
        SecurityContextHolder.getContext().setAuthentication(auth);

        def accessToken = tokenGenerator.generateAccessToken(auth.principal as UserDetails)
        tokenStorageService.storeToken(accessToken.accessToken, auth.principal as UserDetails)
        authenticationEventPublisher.publishTokenCreation(accessToken)
        SecurityContextHolder.context.setAuthentication(accessToken)
        accessToken
    }
}
*/

    def setup() {

        userService = new UserService()
        userService.setAuthenticationManager(authenticationManager)
        userService.setTokenGenerator(tokenGenerator)
        userService.setTokenStorageService(tokenStorageService)
        userService.setAuthenticationEventPublisher(authenticationEventPublisher)

        user = new User(HashMap.of("firstName", "Susan",
                "lastName", "Rosito",
                "email", "rosisusa@gmail.com",
                "password", "12345"))

        springSecurityService = Mock()
        springSecurityService.encodePassword(user.password) >> "ENCODE_PASSWORD"
        userService.setSpringSecurityService(springSecurityService)

        role = new Role(HashMap.of("authority", "ROLE_USER"))
        role.save()
    }

    def cleanup() { }

    void "when create a trip, it should return a complete trip"() {
        when:
        def accessToken = userService.save(user)

        then:
        accessToken.toString() != null
        resultTrip.getOwner().getFirstName() == "Susan"
        resultTrip.getImage() == "IMAGE_LIMA_URL"
        resultTrip.getDestinations().size() == 3
        resultTrip.getDestinations().stream().allMatch(dest -> dest.getTrip().is(trip))
    }

}
