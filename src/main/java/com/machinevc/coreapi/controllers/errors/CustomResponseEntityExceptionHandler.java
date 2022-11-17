package com.machinevc.coreapi.controllers.errors;

import com.machinevc.coreapi.domain.errors.AttributeTypeParseException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * This class allow us to customise errors encountered while processing API requests
 */
@ControllerAdvice
@Slf4j
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * @param exception
     * @param request
     * @return a response entity ApiErrorDetails and an internal error http status
     */
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<String> handleAllException(Exception exception, WebRequest request) {
        log.error(exception.getMessage());
        CustomErrorContent error = CustomError.UNEXPECTED_INTERNAL_ERROR.getError();
        return new ResponseEntity<>(error.toString(), error.getHttpStatus());
    }

    /**
     * @param exception of type AttributeTypeParseException
     * @param request
     * @return a response entity ApiErrorDetails and a AttributeTypeParseException http status
     */
    @ExceptionHandler(AttributeTypeParseException.class)
    public final ResponseEntity<String> handleAttributeTypeParseException(
            AttributeTypeParseException exception,
            WebRequest request) {
        return new ResponseEntity<>(exception.toString(), exception.getHttpStatus());
    }
}
