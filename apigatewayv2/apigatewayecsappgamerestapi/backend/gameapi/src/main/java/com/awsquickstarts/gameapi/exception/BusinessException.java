package com.awsquickstarts.gameapi.exception;

public class BusinessException extends RuntimeException {

    public BusinessException(final String message) {
        super(message);
    }
    
}
