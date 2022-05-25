package ar.com.mytrips


import ar.com.mytrips.request.CreateUserRequest
import grails.converters.JSON
import grails.gorm.transactions.Transactional
import grails.plugin.springsecurity.annotation.Secured

@Transactional
@Secured("ROLE_USER")
class UserController implements ModelRequestResolver {

    UserService userService

    @Secured("IS_AUTHENTICATED_ANONYMOUSLY")
    def save() {
        def userRequest = getBody(CreateUserRequest)
        def user = userRequest.toModel()
        def authToken = userService.save(user)
        render model: [user:user, token: authToken], view: 'save'
    }


}