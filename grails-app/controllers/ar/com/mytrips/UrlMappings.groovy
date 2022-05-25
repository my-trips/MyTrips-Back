package ar.com.mytrips

class UrlMappings {

    static mappings = {
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

        "/api/trip/$tripId/destination/$destinationId/plusDays"(controller: 'destination', action: "update", method: 'GET')
    }
}
