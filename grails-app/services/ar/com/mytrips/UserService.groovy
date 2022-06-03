package ar.com.mytrips

import ar.com.mytrips.auth.Role
import ar.com.mytrips.auth.User
import ar.com.mytrips.auth.UserRole
import ar.com.mytrips.exception.ServiceException
import grails.gorm.transactions.Transactional
import grails.plugin.springsecurity.SpringSecurityService

@Transactional
class UserService {

    SpringSecurityService springSecurityService

    User getCurrentUser(){
        springSecurityService.currentUser as User
    }

    void save(User user){
        if(User.findByEmail(user.email) != null){
            throw ServiceException.badRequest("duplicateEmail", [email: user.email])
        }
        def plainPassword = user.password
        user.password = springSecurityService.encodePassword(user.password)
        user.save()

        def role = Role.defaultRole
        UserRole.create user, role
    }
}
