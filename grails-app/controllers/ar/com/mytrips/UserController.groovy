package ar.com.mytrips

import ar.com.mytrips.request.CreateUserRequest
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
        userService.save(user)
        render model: [user:user], view: 'save'
    }

    def search(String query, Integer max, Integer offset) {
        def users = userService.search(query, max?: 20, offset?:0)
        render model: [users:users], view: 'list'
    }

    def profile() {
        def user = userService.currentUser
        respond  user, view: 'show'
    }

}
