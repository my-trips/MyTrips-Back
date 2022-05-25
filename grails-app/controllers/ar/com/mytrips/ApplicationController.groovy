package ar.com.mytrips

import grails.core.GrailsApplication
import grails.plugin.springsecurity.annotation.Secured

@Secured("IS_AUTHENTICATED_ANONYMOUSLY")
class ApplicationController {

    GrailsApplication grailsApplication

    @Secured("IS_AUTHENTICATED_ANONYMOUSLY")
    def index() {
        [grailsApplication: grailsApplication]
    }
}
