package com.machinevc.coreapi.domain.errors;

import com.machinevc.coreapi.controllers.errors.CustomError;
import com.machinevc.coreapi.controllers.errors.CustomErrorContent;
import org.springframework.http.HttpStatus;

public class AttributeTypeParseException extends Exception {

    private static final CustomErrorContent ERROR_CONTENT = CustomError.ATTRIBUTE_TYPE_PARSING_ERROR.getError();
    public HttpStatus getHttpStatus(){
        return ERROR_CONTENT.getHttpStatus();
    }
    public AttributeTypeParseException(String detail) {
        super(String.format("%s %s", ERROR_CONTENT.toString(), detail));
    }
}
