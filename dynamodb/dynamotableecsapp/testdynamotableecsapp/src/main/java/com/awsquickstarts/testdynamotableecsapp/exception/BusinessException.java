package com.awsquickstarts.testdynamotableecsapp.exception;

public class BusinessException extends RuntimeException {

    public BusinessException(final String message) {
        super(message);
    }
    
}
