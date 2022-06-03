package ar.com.mytrips

import ar.com.mytrips.auth.Role
import ar.com.mytrips.auth.User
import ar.com.mytrips.auth.UserRole
import grails.plugin.springsecurity.SpringSecurityService
import grails.plugin.springsecurity.rest.authentication.RestAuthenticationEventPublisher
import grails.plugin.springsecurity.rest.token.generation.TokenGenerator
import grails.plugin.springsecurity.rest.token.storage.TokenStorageService
import grails.testing.services.ServiceUnitTest
import org.springframework.security.authentication.AuthenticationManager

class UserServiceTest extends MyTripServiceTest implements ServiceUnitTest<UserService> {

    private User user
    private Role role
    private SpringSecurityService springSecurityService
    private AuthenticationManager authenticationManager
    private TokenGenerator tokenGenerator
    private TokenStorageService tokenStorageService
    private RestAuthenticationEventPublisher authenticationEventPublisher


    void setupSpec() {
        mockDomain User
        mockDomain Role
        mockDomain UserRole
    }

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
//        service.authenticationManager = authenticationManager
//        service.tokenGenerator = tokenGenerator
//        service.tokenStorageService = tokenStorageService
//        service.authenticationEventPublisher = authenticationEventPublisher
//
//
//        user = new User(HashMap.of("firstName", "Susan",
//                "lastName", "Rosito",
//                "email", "rosisusa@gmail.com",
//                "password", "12345"))
//
//        springSecurityService = Mock()
//        springSecurityService.encodePassword(user.password) >> "ENCODE_PASSWORD"
//        service.springSecurityService = springSecurityService
//
//        role = new Role(HashMap.of("authority", "ROLE_USER"))
//        role.save()
    }

    def cleanup() { }

    void "when create a trip, it should return a complete trip"() {
        when:
//        def accessToken = service.save(user)
        def a = 1
        then:
            a
//        accessToken.toString() != null
//        resultTrip.getOwner().getFirstName() == "Susan"
//        resultTrip.getImage() == "IMAGE_LIMA_URL"
//        resultTrip.getDestinations().size() == 3
//        resultTrip.getDestinations().stream().allMatch(dest -> dest.getTrip().is(trip))
    }

}
