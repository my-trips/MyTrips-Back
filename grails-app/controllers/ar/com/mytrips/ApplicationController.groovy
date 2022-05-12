package ar.com.mytrips

import grails.core.GrailsApplication

class ApplicationController {

    GrailsApplication grailsApplication

    def index() {
        [grailsApplication: grailsApplication]
    }
}
