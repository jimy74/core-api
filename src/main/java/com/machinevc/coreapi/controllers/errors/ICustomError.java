package com.machinevc.coreapi.controllers.errors;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;


public interface ICustomError {
    LocalDateTime getDateTime();
    Integer getErrorCode();

    HttpStatus getHttpStatus();

    String getName();

    String getMessage();
}
