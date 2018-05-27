package com.paula.account.exception.handler;

import java.util.Objects;
import java.util.UUID;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * @author cesar.angiolucci on 10/04/2018
 */
@JsonInclude(Include.NON_NULL)
public class ErrorResponse {

	private String system = "Confucio";

	// TODO: Temporário, para evitar erros de compatibilidade, remover depois
	private int code;
	private String description;
	// ------------------------

	private String message;
	private int httpStatus;
	private UUID requestId;

	public String getSystem() {
		return system;
	}

	// TODO: Temporário, para evitar erros de compatibilidade, remover depois
	public int getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}
	// ----------------------

	public String getMessage() {
		return message;
	}

	public int getHttpStatus() {
		return httpStatus;
	}

	public UUID getRequestId() {
		return requestId;
	}

	public ErrorResponse withDescription(String description) {
		this.description = description;
		return this;
	}
	// -----------------------------

	public ErrorResponse withMessage(String message) {
		this.message = message;
		return this;
	}

	public ErrorResponse withHttpStatus(HttpStatus httpStatus) {
		Objects.requireNonNull(httpStatus);
		this.httpStatus = httpStatus.value();
		return this;
	}

	public ErrorResponse withHttpStatus(int httpStatus) {
		this.httpStatus = httpStatus;
		return this;
	}

	public ErrorResponse withRequestId(UUID requestId) {
		this.requestId = requestId;
		return this;
	}

}
