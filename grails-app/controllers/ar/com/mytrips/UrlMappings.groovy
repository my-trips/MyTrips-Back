package ar.com.mytrips

import groovy.transform.CompileStatic
import groovy.transform.TypeCheckingMode

class UrlMappings {

    static mappings = {
        delete "/$controller/$id(.$format)?"(action:"delete")
        get "/$controller(.$format)?"(action:"index")
        get "/$controller/$id(.$format)?"(action:"get")
        post "/$controller(.$format)?"(action:"save")
        put "/$controller/$id(.$format)?"(action:"update")
        patch "/$controller/$id(.$format)?"(action:"patch")

        "/"(controller: 'application', action:'index')
        "500"(view: '/error')
        "404"(view: '/notFound')

        group "/api/$controller", {
            delete "/$id"(action: "delete")
            get "/"(action: "list")
            get "/$id"(action: "get")
            post "/"(action: "save")
            put "/$id"(action: "update")
            patch "/$id"(action: "patch")
            post "/$id/$action"()
        }

        "/api/location/attractions/$location"(controller: 'location', action: "attractions", method: 'GET')
        "/api/location/$country/$city"(controller: 'location', action: "location", method: 'GET')
    }
}
