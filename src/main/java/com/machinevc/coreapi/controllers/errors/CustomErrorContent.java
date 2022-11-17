package com.machinevc.coreapi.controllers.errors;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class CustomErrorContent implements ICustomError {
    LocalDateTime dateTime;
    private Integer errorCode;
    private HttpStatus httpStatus;

    private String name;
    private String message;

    public CustomErrorContent(Integer errorCode, HttpStatus httpStatus, String name, String message) {
        this.dateTime = LocalDateTime.now();
        this.errorCode = errorCode;
        this.httpStatus = httpStatus;
        this.name = name;
        this.message = message;
    }

    @Override
    public LocalDateTime getDateTime() {
        return dateTime;
    }

    @Override
    public Integer getErrorCode() {
        return errorCode;
    }

    @Override
    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return String.format("%s(%s) at %s, %s", name, errorCode, dateTime.toString(), message);
    }
}
