package ar.com.mytrips

import ar.com.mytrips.auth.Role
import ar.com.mytrips.auth.User
import ar.com.mytrips.auth.UserRole
import ar.com.mytrips.destination.Destination
import ar.com.mytrips.destination.Place
import ar.com.mytrips.destination.Transport
import grails.gorm.transactions.Transactional

import java.time.LocalDateTime

class BootStrap {

    UserService userService

    def init = { servletContext ->
        addRole()
        addTestUser('user@gmail.com')
        addTestUser('user2@gmail.com')
    }
    def destroy = {
    }

    @Transactional
    void addRole() {
        def role = Role.defaultRole
        if(!role){
            new Role(authority: 'ROLE_USER').save()
        }
    }

    @Transactional
    User addTestUser(String email) {
        def user = User.findByEmail(email)
        if(!user){
            user = new User(email: email, password: 'password')
            userService.save(user)
        }
        return user
    }

}
