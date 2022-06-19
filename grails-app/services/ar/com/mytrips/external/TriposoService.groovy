package ar.com.mytrips.external

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

    TriposoLocation getLocation(String country, String place) {
        def params = [
                part_of: country.replaceAll(" ", "_"),
                tag_labels: "city",
                count: 1,
                fields: "name,id,snippet,parent_id,score,type,images,generated_intro,country_id,coordinates",
                annotate: "trigram:${place.replaceAll(" ", "_")}",
                trigram: ">=1",
                order_by: "-score",
        ]
        def location = get("location.json", params, TriposoLocationResponse)
        return !location.isEmpty()? location.first():null
    }

    List<TriposoPoi> getAttractions(String locationId, String name="", Integer max, Integer offset) {
        def params = [
                tag_labels:
                        "city|diving|history|location|shopping|topattractions|sightseeing",
                location_id: locationId.replaceAll(" ", "_"),
                count: max,
                fields: "id,name,coordinates,snippet,score,intro,images,price_tier,generated_intro,properties",
                order_by: "-score",
        ]
        if(name != null){
            params.annotate = "trigram:$name".toString()
        }
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
//            e.printStackTrace()
            if(findLocation){
                def location = getLocation(destination.place.country.name, destination.place.name)
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
