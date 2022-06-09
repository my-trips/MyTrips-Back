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

        "/api/trip/$id/copy"(controller: 'trip', action: "copy", method: 'POST')
        "/api/trip/$id/travellers/$email"(controller: 'trip', action: "addTraveller", method: 'POST')
        "/api/trip/$id/travellers/$userId"(controller: 'trip', action: "removeTraveller", method: 'DELETE')

        "/api/trip/$tripId/destination/$destinationId/plusDay"(controller: 'destination', action: "plusDay", method: 'GET')
        "/api/trip/$tripId/destination/$destinationId/minusDay"(controller: 'destination', action: "minusDay", method: 'GET')
        "/api/trip/$tripId/destination/$destinationId/transport/$transportId"(controller: 'transport', action: "update", method: 'PUT')

        "/api/trip/$tripId/destination/$destinationId/day/$dayId/activity/$id"(controller: 'activity', action: "delete", method: 'DELETE')
        "/api/trip/$tripId/destination/$destinationId/day/$dayId/activity/$id"(controller: 'activity', action: "update", method: 'PUT')
        "/api/trip/$tripId/destination/$destinationId/day/$dayId/activity"(controller: 'activity', action: "save", method: 'POST')

        "/api/trip/$tripId/destination/$destinationId/stay"(controller: 'stay', action: "save", method: 'POST')
    }
}
