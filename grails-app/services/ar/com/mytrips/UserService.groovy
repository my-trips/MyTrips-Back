package ar.com.mytrips

import ar.com.mytrips.auth.Role
import ar.com.mytrips.auth.User
import ar.com.mytrips.auth.UserRole
import ar.com.mytrips.exception.ServiceException
import grails.gorm.transactions.Transactional
import grails.plugin.springsecurity.SpringSecurityService
import grails.plugin.springsecurity.rest.authentication.RestAuthenticationEventPublisher
import grails.plugin.springsecurity.rest.token.AccessToken
import grails.plugin.springsecurity.rest.token.generation.TokenGenerator
import grails.plugin.springsecurity.rest.token.storage.TokenStorageService
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetails

@Transactional
class UserService {

    SpringSecurityService springSecurityService
    AuthenticationManager authenticationManager
    TokenGenerator tokenGenerator
    TokenStorageService tokenStorageService
    RestAuthenticationEventPublisher authenticationEventPublisher

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
