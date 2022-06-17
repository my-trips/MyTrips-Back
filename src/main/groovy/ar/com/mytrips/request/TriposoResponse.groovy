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
class TriposoAttractionResponse implements TriposoResponse<TriposoPoi>{
    List<TriposoPoi> results
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
    TriposoCoordinates coordinates
    @JsonProperty("country_id")
    String country
    @JsonProperty("generated_intro")
    String intro

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
    List<TriposoActivity> itineraryItems
}

@Introspected
@CompileStatic
class TriposoActivity {
    String description
    String title
    TriposoPoi poi
}

//@Introspected
//@CompileStatic
//class TriposoPo3i {
//    String name
//    String id
//    String snippet
//    List<TriposoImage> images
//    @JsonProperty("location_id")
//    String locationId
//    BigDecimal score
//    TriposoCoordinates coordinates
//}

@Introspected
@CompileStatic
class TriposoPoi {
    String name
    String id
    String intro
    String snippet
    @JsonProperty("generated_intro")
    String description
    TriposoCoordinates coordinates
    List<TriposoImage> images
    BigDecimal score
    @JsonProperty("facebook_id")
    String facebookId
    @JsonProperty("booking_info")
    TriposoBookingInfo cost
    List<TriposoProperty> properties
    @JsonProperty("tag_labels")
    List<String> labels

    String  getDirection(){
        return properties?.find { it.key == "address"}?.value
    }

    String  getLink(){
        return properties?.find { it.key == "website"}?.value
    }
}

@Introspected
@CompileStatic
class TriposoProperty {
    String key
    String name
    String value
}



@Introspected
@CompileStatic
class TriposoCoordinates {
    Double longitude
    Double latitude
}

@Introspected
@CompileStatic
class TriposoBookingInfo {
    @JsonProperty("price.amount")
    Double price
    @JsonProperty("price.currency")
    String currency
}


@Introspected
@CompileStatic
class UnsplashImage {
    UnsplashImageUrl urls
    String id
    String description
}

@Introspected
@CompileStatic
class UnsplashImageUrl {
    String full
}

@Introspected
@CompileStatic
class UnsplashResponse {
    List<UnsplashImage> results
}