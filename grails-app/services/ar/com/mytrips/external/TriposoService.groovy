package ar.com.mytrips.external

import ar.com.mytrips.Country
import ar.com.mytrips.destination.Destination
import ar.com.mytrips.request.*
import grails.config.Config
import grails.core.support.GrailsConfigurationAware
import io.micronaut.http.HttpRequest
import io.micronaut.http.client.BlockingHttpClient
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.exceptions.HttpClientResponseException
import io.micronaut.http.uri.UriBuilder

class TriposoService implements GrailsConfigurationAware {

    String account
    String token
    BlockingHttpClient client

    TriposoLocation getLocation(Country country, String place) {
        def params = [
                part_of: country.name,
                tag_labels: "city",
                count: 1,
                fields: "name,id,snippet,parent_id,score,type,images",
                annotate: "trigram:${place}",
                trigram: ">=1",
                order_by: "-score",
        ]
        def location = get("location.json", params, TriposoLocationResponse)
        return !location.isEmpty()? location.first():null
    }

    List<TriposoAttraction> getAttractions(String locationId) {
        def params = [
                tag_labels:
                        "poitype-Canal|city|poitype-Church|poitype-City_hall|diving|history|poitype-Lake|poitype-Mausoleum|location|poitype-Mountain_pass|poitype-Obelisk|poitype-Necropolis|poitype-Park|poitype-Palace|shopping|topattractions|poitype-Tower|poitype-Volcano|poitype-View_point",
                location_id: locationId.replaceAll(" ", "_"),
                count: 10,
                fields: "id,name,coordinates,facebook_id,score,intro,images,price_tier",
                order_by: "-score",
        ]
        return get("poi.json", params, TriposoAttractionResponse)
    }

    TriposoDayPlanner getDayPlanner(Destination destination, Boolean findLocation=true) {
        try {
            def params = [
                location_id: destination.place.name.replaceAll(" ", "_"),
                start_date: destination.arriveDate.toLocalDate().toString(),
                arrival_time: destination.arriveDate.toLocalTime().toString(),
                end_date: destination.departDate.toLocalDate().toString(),
                departure_time:destination.departDate.toLocalTime().toString(),
            ]
            List<TriposoDayPlanner> planner = get("day_planner.json", params, TriposoDayPlannerResponse)
            !planner.isEmpty()? planner.first():null
        } catch (HttpClientResponseException e) {
            e.printStackTrace()
            if(findLocation){
                def location = getLocation(destination.place.country, destination.place.name)
                return getDayPlanner(destination, false)
            }
            return null
        }
    }

    public <T> List<T> get(String path, Map<String, Object> params, Class<TriposoResponse<T>> returnType) {
        try {
            def request = HttpRequest.GET(triposoUri(path, params))
            request.headers([
                    "X-Triposo-Account": account,
                    "X-Triposo-Token": token,
            ])
            def response = client.retrieve(request, returnType)
            if(!response.results.isEmpty()){
                return response.results
            }
            return []
        } catch (HttpClientResponseException e) {
            e.printStackTrace()
            return []
        }
    }


    URI triposoUri(String path, Map<String, Object> params) {
        UriBuilder uriBuilder = UriBuilder.of("/api/20220411/$path")
        params.forEach{key, value ->
            uriBuilder.queryParam(key, value)
        }
        uriBuilder.build()
    }

    @Override
    void setConfiguration(Config co) {
        account = co.getProperty('triposo.account', String)
        token = co.getProperty('triposo.token', String)
        setupHttpClient("https://www.triposo.com")
    }

    void setupHttpClient(String url) {
        this.client = HttpClient.create(url.toURL()).toBlocking()
    }
}
