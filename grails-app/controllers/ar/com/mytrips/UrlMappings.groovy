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

        "/api/trip/$tripId/destination/$destinationId/plusDay"(controller: 'destination', action: "plusDay", method: 'GET')
        "/api/trip/$tripId/destination/$destinationId/minusDay"(controller: 'destination', action: "minusDay", method: 'GET')
        "/api/trip/$tripId/destination/$destinationId/transport/$transportId"(controller: 'transport', action: "update", method: 'PUT')

        "/api/trip/$tripId/destination/$destinationId/day/$dayId/itinerary/$id"(controller: 'itinerary', action: "delete", method: 'DELETE')
        "/api/trip/$tripId/destination/$destinationId/day/$dayId/itinerary/$id"(controller: 'itinerary', action: "update", method: 'PUT')
        "/api/trip/$tripId/destination/$destinationId/day/$dayId/itinerary"(controller: 'itinerary', action: "save", method: 'POST')
    }
}
