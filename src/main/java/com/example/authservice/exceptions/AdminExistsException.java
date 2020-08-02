package com.example.authservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class AdminExistsException extends RuntimeException {
    public AdminExistsException() {
        super();
    }

    public AdminExistsException(String message) {
        super(message);
    }

    public AdminExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public AdminExistsException(Throwable cause) {
        super(cause);
    }

    protected AdminExistsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}