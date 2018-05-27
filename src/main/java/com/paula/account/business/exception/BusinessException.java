package com.paula.account.business.exception;

public class BusinessException extends RuntimeException{

	private static final long serialVersionUID = -6645580034905419238L;

	/**
     * @param message
     */
    public BusinessException(String message) {
        super(message);
    }

    /**
     * @param message
     * @param throwable
     */
    public BusinessException(String message, Throwable throwable) {
        super(message, throwable);
    }

}
