package com.nisum.api.nisum.exception;

public class BusinessException extends Exception {

    public BusinessException(String errorMessage) {
        super(errorMessage);
    }

    public BusinessException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }

}
