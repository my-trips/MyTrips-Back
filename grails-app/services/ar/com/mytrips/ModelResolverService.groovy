package ar.com.mytrips

import ar.com.mytrips.exception.ModelRequestValidationException
import ar.com.mytrips.exception.ServiceException
import ar.com.mytrips.request.ModelRequest
import grails.databinding.DataBindingSource
import grails.web.api.ServletAttributes
import grails.web.databinding.DataBinder
import grails.web.databinding.DataBindingUtils
import org.codehaus.groovy.runtime.metaclass.MissingPropertyExceptionNoStack
import org.grails.web.json.JSONObject

class ModelResolverService implements  ServletAttributes, DataBinder {

    def <T extends ModelRequest> T getModel(Class<T> type, JSONObject json) {
        try {
            T body = type.getDeclaredConstructor().newInstance()
            final DataBindingSource dataBindingSource = DataBindingUtils.createDataBindingSource(getGrailsApplication(), type, json)
            bindData(body, dataBindingSource, Collections.EMPTY_MAP, null)
            if (!body.validate()) {
                throw new ModelRequestValidationException(body.errors)
            }
            body.setJson(json)
            return body
        } catch (MissingPropertyExceptionNoStack e) {
            throw ServiceException.badRequest("invalidProperty", [property: e.property])
        }
    }
}
