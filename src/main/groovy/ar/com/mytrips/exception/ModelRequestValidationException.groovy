package ar.com.mytrips.exception

import org.springframework.validation.Errors

class ModelRequestValidationException extends RuntimeException {

    Errors errors;

    ModelRequestValidationException(Errors errors) {
        this.errors = errors
    }

}