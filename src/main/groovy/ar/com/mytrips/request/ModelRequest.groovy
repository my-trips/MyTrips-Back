package ar.com.mytrips.request

import grails.validation.Validateable
import groovy.transform.CompileStatic
import groovy.transform.TypeCheckingMode
import org.grails.web.json.JSONArray
import org.grails.web.json.JSONObject

import java.lang.reflect.Field
import java.lang.reflect.ParameterizedType
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime

@CompileStatic(TypeCheckingMode.SKIP)
trait ModelRequest<T> extends Validateable{

    static Closure STRING_TO_TIME = {String value -> value?LocalTime.parse(value):null}
    static Closure STRING_TO_DATE = {String value -> value?LocalDate.parse(value):null}
    static Closure STRING_TO_DATETIME = {String value -> value?LocalDateTime.parse(value):null}

    private JSONObject requestJson

    T toModel(){
        null
    }

    Map<String,Closure> getTransformations() {
        [:]
    }

    Collection<String> getKeys(){
        []
    }

    String getHash(){
        return keys?.collect{this[it]}?.toString()?:""
    }

    String getHash(Object json){
        return keys?.collect{json[it]}?.toString()
    }

    def setJson( JSONObject json){
        requestJson = json
        commandProperties().each {
            if(requestJson.has(it.key as String)){
                switch (it.value) {
                    case ModelRequest:
                        def nested =  (it.value as ModelRequest)
                        nested.setJson(requestJson[it.key] as JSONObject)
                        break;
                    case Collection:
                        Field field = this.class.getDeclaredField(it.key.toString())
                        def listType = field.getGenericType() as ParameterizedType
                        if (listType.getActualTypeArguments()[0] in ModelRequest) {
                            def nested = (it.value as Collection<ModelRequest>)
                            nested.forEach{ ModelRequest command->
                                JSONArray jsonList = requestJson[it.key] as JSONArray
                                command.setJson(jsonList.find{ jsonElement->
                                    command.hash == command.getHash(jsonElement)
                                } as JSONObject)
                            }
                        }
                        break
                }
            }
        }
    }

    Map changes(){
        Map changes = [:]
        commandProperties().each {
            if(!requestJson || requestJson.has(it.key as String)){
                if(transformations.containsKey(it.key)){
                    changes[it.key] = transformations[it.key.toString()](it.value)
                } else {
                    switch (it.value) {
                        case ModelRequest:
                            def nested = (it.value as ModelRequest)
                            changes[it.key] = nested.changes()
                            break;
                        case Collection:
                            try{
                                Field field = this.class.getDeclaredField(it.key.toString())
                                def listType = field.getGenericType() as ParameterizedType
                                if (listType.getActualTypeArguments()[0] in ModelRequest) {
                                    def nested = (it.value as Collection<ModelRequest>)
                                    changes[it.key] = nested.collect{ it.changes()}
                                } else {
                                    changes[it.key] = it.value
                                }
                            }catch(e){}

                            break;
                        default:
                            changes[it.key] = it.value
                    }
                }

            }
        }
        changes
    }

    private Set<Map.Entry<String, Object>> commandProperties(){
        def excludedProperites = ["keys", "transformations", "class", "hash","errors", "constraints", "constraintsMap", "STRING_TO_DATE", "STRING_TO_TIME", "STRING_TO_DATETIME" ]
        properties.entrySet().findAll { !excludedProperites.contains(it.key)} as Set<Map.Entry<String, Object>>
    }
}