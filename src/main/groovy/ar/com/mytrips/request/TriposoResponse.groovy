package ar.com.mytrips.request

import com.fasterxml.jackson.annotation.JsonProperty
import groovy.transform.CompileStatic
import io.micronaut.core.annotation.Introspected

import java.time.LocalDate

@Introspected
@CompileStatic
interface TriposoResponse<T>{
    List<T> getResults()
}


@Introspected
@CompileStatic
class TriposoLocationResponse implements TriposoResponse<TriposoLocation>{
    List<TriposoLocation> results
}

@Introspected
@CompileStatic
class TriposoAttractionResponse implements TriposoResponse<TriposoAttraction>{
    List<TriposoAttraction> results
}

@Introspected
@CompileStatic
class TriposoDayPlannerResponse implements TriposoResponse<TriposoDayPlanner> {
    List<TriposoDayPlanner> results
}

@Introspected
@CompileStatic
class TriposoLocation {
    String id
    BigDecimal score
    String name
    String snippet
    String type
    List<TriposoImage> images

}

@Introspected
@CompileStatic
class TriposoImage {
    String caption
    @JsonProperty("source_url")
    String sourceUrl

}

@Introspected
@CompileStatic
class TriposoDayPlanner {
    List<TriposoDay> days
    TriposoLocation location
}

@Introspected
@CompileStatic
class TriposoDay {
    LocalDate date
    @JsonProperty("itinerary_items")
    List<TriposoItinerary> itineraryItems
}

@Introspected
@CompileStatic
class TriposoItinerary {
    String description
    String title
    TriposoPoi poi
}

@Introspected
@CompileStatic
class TriposoPoi {
    String name
    String id
    String snippet
    List<TriposoImage> images
    @JsonProperty("location_id")
    String locationId
    BigDecimal score
    @JsonProperty("coordinates.longitude")
    Long longitude
    @JsonProperty("coordinates.latitude")
    Long latitude
}

@Introspected
@CompileStatic
class TriposoAttraction {
    String name
    String id
    String intro
    @JsonProperty("coordinates.longitude")
    Long longitude
    @JsonProperty("coordinates.latitude")
    Long latitude
    List<TriposoImage> images
    BigDecimal score
    @JsonProperty("facebook_id")
    String facebookId
}