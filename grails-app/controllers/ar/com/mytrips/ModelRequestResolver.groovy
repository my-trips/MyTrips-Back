package ar.com.mytrips

import ar.com.mytrips.exception.ExceptionHandler
import ar.com.mytrips.exception.ServiceException
import ar.com.mytrips.request.ModelRequest
import grails.web.api.ServletAttributes
import org.grails.web.json.JSONObject

trait ModelRequestResolver implements ExceptionHandler, ServletAttributes {

    ModelResolverService modelResolverService

    def <T extends ModelRequest> T getBody(Class<T> type) {
        modelResolverService.getModel(type, request.getJSON() as JSONObject)
    }

     def <T> T assertExistence(T object, String message){
        if(!object){
            throw ServiceException.badRequest(message)
        }
        return object
    }

}