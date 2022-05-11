package ar.com.mytrips.exception


import grails.artefact.Enhances
import grails.converters.JSON
import grails.validation.ValidationException
import groovy.transform.CompileStatic
import groovy.transform.TypeCheckingMode
import org.grails.core.artefact.ControllerArtefactHandler
import org.springframework.http.HttpStatus

import java.nio.file.AccessDeniedException

@Enhances(ControllerArtefactHandler.TYPE)
@CompileStatic(TypeCheckingMode.SKIP)
trait ExceptionHandler {

    def handleServiceException(ServiceException exception) {
        renderException(exception, exception.status.value(),
                [requestId: request?.requestId, exceptionKey:exception.key, data:exception.data]
        )
    }

    def handleAccessDeniedException(AccessDeniedException exception) {
        renderException(exception, HttpStatus.FORBIDDEN.value(),
                [requestId: request?.requestId, exceptionKey:exception?.class?.name, data:exception?.message]
        )
    }

    def handleValidationException(ValidationException exception) {
        renderException(exception, HttpStatus.BAD_REQUEST.value(),
                [requestId: request?.requestId, exceptionKey: 'ValidationException', data: [
                        objectId: exception.errors?.target?.id,
                        objectName: exception.errors?.objectName,
                        errors: exception.errors.fieldErrors.collect { it ->
                            [
                                    path: it.field,
                                    value: it.rejectedValue,
                                    defaultMessage: it.defaultMessage
                            ]
                        }
                ]]
        )
    }


    def handleCommandObjectValidationException(ModelRequestValidationException exception) {
        renderException(exception, HttpStatus.BAD_REQUEST.value(),
                [requestId: request?.requestId, exceptionKey: 'ValidationException',
                 errors: exception.errors.fieldErrors.collect { it ->
                     [
                             path: it.field,
                             value: it.rejectedValue,
                     ]
                 }
                ]
        )
    }

    def handleRuntimeException(RuntimeException exception) {
        renderException(exception, HttpStatus.INTERNAL_SERVER_ERROR.value(),
                [requestId: request?.requestId, exceptionKey:exception?.class?.name, data:exception?.message]
        )
    }

    def handleException(Exception exception) {
        renderException(exception, HttpStatus.INTERNAL_SERVER_ERROR.value(),
                [requestId: request?.requestId, exceptionKey:exception?.class?.name, data:exception?.message]
        )
    }

    def renderException(Throwable throwable, status, data){
        log.error("{}",  (data as JSON), throwable)
        throwable.printStackTrace()
        request.withFormat {
            json {
                response.status =  status
                render (data as JSON)
            }
        }
    }
}
