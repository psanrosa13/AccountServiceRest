package com.paula.account.exception.handler;

import java.util.Objects;

import com.paula.account.error.code.ErrorCodeEnum;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * @author cesar.angiolucci on 10/04/2018
 */
@JsonInclude(Include.NON_NULL)
public class ErrorDetailResponse {

	private int code;
	private String description;
	private String fieldName;
	private Object rejectedValue;
	private String expected;

	public int getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}

	public String getFieldName() {
		return fieldName;
	}

	public Object getRejectedValue() {
		return rejectedValue;
	}
	
	public String getExpected() {
		return expected;
	}

	public ErrorDetailResponse withErrorCodeEnum(ErrorCodeEnum errorCodeEnum) {
		Objects.requireNonNull(errorCodeEnum);
		this.code = errorCodeEnum.getCode();
		this.description = errorCodeEnum.getMessage();
		return this;
	}
	
	public ErrorDetailResponse withCode(int code) {
		this.code = code;
		return this;
	}

	public ErrorDetailResponse withDescription(String description) {
		this.description = description;
		return this;
	}

	public ErrorDetailResponse withFieldName(String fieldName) {
		this.fieldName = fieldName;
		return this;
	}

	public ErrorDetailResponse withRejectedValue(Object rejectedValue) {
		this.rejectedValue = rejectedValue;
		return this;
	}
	
	public ErrorDetailResponse withExpected(String expected) {
		this.expected = expected;
		return this;
	}
	
}
