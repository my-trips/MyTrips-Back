package ar.com.mytrips.external


import ar.com.mytrips.request.UnsplashImage
import ar.com.mytrips.request.UnsplashResponse
import grails.config.Config
import grails.core.support.GrailsConfigurationAware
import io.micronaut.http.HttpRequest
import io.micronaut.http.client.BlockingHttpClient
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.exceptions.HttpClientResponseException
import io.micronaut.http.uri.UriBuilder

class UnsplashService implements GrailsConfigurationAware {

    String clientId
    BlockingHttpClient client

    String getImage(String location) {
        def images = getImages(location)
        return images.isEmpty() ? null : images.first()
    }

    List<String> getImages(String location, Integer elements = 1) {
        def params = [
                query: location,
                client_id: clientId,
                per_page: elements,
                orientation: "landscape"
        ]
        def result = get("search/photos", params)
        return result.collect{ it?.urls?.full}
    }

    public List<UnsplashImage> get(String path, Map<String, Object> params) {
        try {
            def request = HttpRequest.GET(triposoUri(path, params))
            def response = client.retrieve(request, UnsplashResponse)
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
        UriBuilder uriBuilder = UriBuilder.of("/$path")
        params.forEach{key, value ->
            uriBuilder.queryParam(key, value)
        }
        uriBuilder.build()
    }

    @Override
    void setConfiguration(Config co) {
        clientId = co.getProperty('unsplash.id', String)
        setupHttpClient("https://api.unsplash.com")
    }

    void setupHttpClient(String url) {
        this.client = HttpClient.create(url.toURL()).toBlocking()
    }
}
