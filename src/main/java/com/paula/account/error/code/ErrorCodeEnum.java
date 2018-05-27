package com.paula.account.error.code;

import static com.paula.account.error.code.ErrorCodeMessages.*;

import java.util.Objects;

public enum ErrorCodeEnum {

	// 6xxxx: Environment and configuration errors
	
	// 7xxxx: Client request errors
	CLIENT_NO_HANDLER_FOR_URL_ERROR_7001(7001, MESSAGE_7001),
	CLIENT_INVALID_DATA_TYPE_ERROR_7002(7002, MESSAGE_7002),
	CLIENT_UNSUPPORTED_MEDIA_TYPE_ERROR_7003(7003, MESSAGE_7003),
	CLIENT_METHOD_NOT_SUPPORTED_OR_ALLOWED_ERROR_7004(7004, MESSAGE_7004),
	CLIENT_PARAMETER_VALIDATION_ERROR_7005(7005, MESSAGE_7005),

	// 8xxxx: Business and application specific errors
	BUSINESS_MISSING_MESSAGE_AUTHOR_8001(8001, MESSAGE_8001),
	BUSINESS_MISSING_MESSAGE_AUTHOR_ID_8002(8002, MESSAGE_8002),
	BUSINESS_SIZE_MESSAGE_AUTHOR_NAME_8003(8003, MESSAGE_8003),

	// -1: Unknown error
	UNKNOWN_ERROR(-1, MESSAGE_UNKNOWN);
	
	private final int code;
    private final String message;

    private ErrorCodeEnum(int code, String message) {
            this.code = code;
            this.message = message;
    }

	public int getCode() {
		return this.code;
	}
	
	public String getMessage() {
		return this.message;
	}
	
	public static ErrorCodeEnum findByCode(int code) {
		for(ErrorCodeEnum e : ErrorCodeEnum.values()) {
			if (e.getCode() == code) {
				return e;
			}
		}
		
		return null;
	}
	
	public static ErrorCodeEnum fingByMessage(String message) {
		Objects.requireNonNull(message);
		for(ErrorCodeEnum e : ErrorCodeEnum.values()) {
			if (e.getMessage().equals(message)) {
				return e;
			}
		}
		
		return null;
	}
	
	public static ErrorCodeEnum fingByMessageOrElseDefault(String message, ErrorCodeEnum defaultEnum) {
		Objects.requireNonNull(message);
		for(ErrorCodeEnum e : ErrorCodeEnum.values()) {
			if (e.getMessage().equals(message)) {
				return e;
			}
		}
		
		return defaultEnum;
	}
	
}
