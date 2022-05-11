package ar.com.mytrips.request

import com.fasterxml.jackson.annotation.JsonProperty
import groovy.transform.CompileStatic
import io.micronaut.core.annotation.Introspected

import java.time.LocalDate


@Introspected
@CompileStatic
class TriposoLocationResponse {
    List<TriposoLocation> results
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
class TriposoDayPlannerResponse {
    List<TriposoDayPlanner> results
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
