package com.paula.account.error.code;

/**
 * @author cesar.angiolucci on 11/04/2018
 */
public class ErrorCodeMessages {
	
	private ErrorCodeMessages() {
	}

	// 7xxxx: Client request errors
	public static final String MESSAGE_7001 = "Invalid URL received; no handler configured";
	public static final String MESSAGE_7002 = "Invalid data type received in parameter";
	public static final String MESSAGE_7003 = "Unsupported media type";
	public static final String MESSAGE_7004 = "Request not supported or not allowed";
	public static final String MESSAGE_7005 = "Parameter validation error";

	// 8xxxx: Business and application specific errors
	public static final String MESSAGE_8001 = "Account e-mail cannot be null";
	public static final String MESSAGE_8002 = "Account e-mail exists";
	public static final String MESSAGE_8003 = "Account not exists";
	
	// -1: Unknown error
	public static final String MESSAGE_UNKNOWN = "Unknown or unexpected error";
	
}
