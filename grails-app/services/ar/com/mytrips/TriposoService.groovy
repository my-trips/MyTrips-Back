package ar.com.mytrips

import ar.com.mytrips.request.TriposoDayPlanner
import ar.com.mytrips.request.TriposoDayPlannerResponse
import ar.com.mytrips.request.TriposoLocation
import ar.com.mytrips.request.TriposoLocationResponse
import grails.config.Config
import grails.core.support.GrailsConfigurationAware
import io.micronaut.http.HttpRequest
import io.micronaut.http.client.BlockingHttpClient
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.exceptions.HttpClientResponseException
import io.micronaut.http.uri.UriBuilder

import java.time.LocalDateTime

class TriposoService implements GrailsConfigurationAware {

    String account
    String token
    BlockingHttpClient client
    ModelResolverService modelResolverService

    @Override
    void setConfiguration(Config co) {
        account = co.getProperty('triposo.account', String)
        token = co.getProperty('triposo.token', String)
        setupHttpClient("https://www.triposo.com")
    }

    void setupHttpClient(String url) {
        this.client = HttpClient.create(url.toURL()).toBlocking()
    }



    TriposoLocation getLocation(String country, String place) {
        try {
            def params = [
                    part_of: country,
                    tag_labels: "city",
                    count: 1,
                    fields: "name,id,snippet,parent_id,score,type,images",
                    annotate: "trigram:${place}",
                    trigram: ">=1",
                    order_by: "-score",
            ]
            def request = HttpRequest.GET(triposoUri("location.json", params))
            request.headers([
                "X-Triposo-Account": account,
                "X-Triposo-Token": token,
            ])
            def response = client.retrieve(request, TriposoLocationResponse)
            if(!response.results.isEmpty()){
                return response.results.first()
            }

        } catch (HttpClientResponseException e) {
            e.printStackTrace()
            return null
        }
    }

    TriposoDayPlanner getDayPlanner(String country, String locationId, LocalDateTime startDate, LocalDateTime endDate, Boolean findLocation=true) {
        try {
            def params = [
                location_id: locationId.replaceAll(" ", "_"),
                start_date: startDate.toLocalDate().toString(),
                arrival_time:startDate.toLocalTime().toString(),
                end_date: endDate.toLocalDate().toString(),
                departure_time:endDate.toLocalTime().toString(),
            ]
            def request = HttpRequest.GET(triposoUri("day_planner.json", params))
            request.headers([
                    "X-Triposo-Account": account,
                    "X-Triposo-Token": token,
            ])
            def planner = client.retrieve(request, TriposoDayPlannerResponse)
            if(!planner.results.isEmpty()){
                return planner.results.first()
            }
        } catch (HttpClientResponseException e) {
            e.printStackTrace()
            if(findLocation){
                def location = getLocation(country, locationId)
                return getDayPlanner(country, location.id, startDate, endDate, false)
            }
            return null
        }
    }

    URI triposoUri(String path, Map<String, Object> params) {
        UriBuilder uriBuilder = UriBuilder.of("/api/20220411/$path")
        params.forEach{key, value ->
            uriBuilder.queryParam(key, value)
        }
        uriBuilder.build()
    }
}
