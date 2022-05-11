package ar.com.mytrips.exception

import org.springframework.http.HttpStatus

class ServiceException extends RuntimeException {

    def key
    def data
    HttpStatus status

    ServiceException(HttpStatus status, String key, data = null) {
        this(status, key, data, data ? "$key: $data".toString() : key)
    }

    ServiceException(HttpStatus status, String key, data, String message) {
        super(message)
        this.status = status
        this.key = key
        this.data = data
    }

    def causedBy(Throwable aCause) {
        this.initCause(aCause)
        this
    }

    static def badRequest(String key, data = null) {
        new ServiceException(HttpStatus.BAD_REQUEST, key, data)
    }

    static def notFound(String key, data = null) {
        new ServiceException(HttpStatus.NOT_FOUND, key, data)
    }

    static def atCapacity(String key, data = null) {
        new ServiceException(HttpStatus.TOO_MANY_REQUESTS, key, data)
    }

    static def forbidden(String key, data = null) {
        new ServiceException(HttpStatus.FORBIDDEN, key, data)
    }

    static def unauthorized(String key, data = null) {
        new ServiceException(HttpStatus.UNAUTHORIZED, key, data)
    }

    static def invalidOptionForPlan(){
        new ServiceException(HttpStatus.FORBIDDEN, "notAllowedForPlan",null)
    }
}