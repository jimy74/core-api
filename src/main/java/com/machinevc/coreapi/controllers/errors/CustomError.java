package com.machinevc.coreapi.controllers.errors;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public enum CustomError {
    UNEXPECTED_INTERNAL_ERROR(
            new CustomErrorContent(
                    1001,
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "UNEXPECTED_INTERNAL_ERROR",
                    "An unexpected error occurred."
            )
    ),
    ATTRIBUTE_TYPE_PARSING_ERROR(
            new CustomErrorContent(
                    1002,
                    HttpStatus.BAD_REQUEST,
                    "ATTRIBUTE_TYPE_PARSING_ERROR",
                    "The attribute value doesn't match its type."
            )
    );

    private CustomErrorContent error;

    CustomError(CustomErrorContent error) {
        this.error = error;
    }

    public CustomErrorContent getError() {
        return error;
    }
}

