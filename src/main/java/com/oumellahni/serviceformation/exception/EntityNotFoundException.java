package com.oumellahni.serviceformation.exception;

import lombok.Getter;

/**
 * @author N.Oumellahni
 * at 11:28 AM - 8/19/2022
 */

public class EntityNotFoundException extends RuntimeException {

    @Getter
    private ErrorCodes errorCode;

    public EntityNotFoundException(String message) {
        super(message);
    }

    public EntityNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public EntityNotFoundException(String message, Throwable cause, ErrorCodes errorCode) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public EntityNotFoundException(String message, ErrorCodes errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
