package ar.com.mytrips

import ar.com.mytrips.auth.Role
import ar.com.mytrips.auth.User
import ar.com.mytrips.auth.UserRole
import grails.gorm.transactions.Transactional

class BootStrap {

    UserService userService

    def init = { servletContext ->
        addTestUser()
    }
    def destroy = {
    }

    @Transactional
    void addTestUser() {
        def user = User.findByEmail('user@gmail.com')
        if(!user){
            def adminRole = new Role(authority: 'ROLE_USER').save()

            user = new User(email: 'user@gmail.com', password: 'password')
            userService.save(user)
        }

    }
}
