package com.paula.account.exception.handler;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.paula.account.business.exception.BusinessException;
import com.paula.account.error.code.ErrorCodeEnum;

@ControllerAdvice
public class ResourceExceptionHandler {

	private static final String INVALID_REQUEST_MESSAGE = "Invalid request received";
	private static final String BUSINESS_MESSAGE = "Business error";

	/**
	 * @param e
	 * @return
	 */
	@ResponseBody
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(value = { BusinessException.class })
	public ErrorResponse handleBusinessException(BusinessException e) {
		return new ErrorResponse()
				.withHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR)
				.withMessage(BUSINESS_MESSAGE)
				.withDescription(e.getMessage());
	}

	// ----------------------------------------------------------------------- //
	// EXCEÇÕES DO NÍVEL DA APLICAÇÃO - TIPOS DE PARÂMETROS/VERBOS HTTP, ETC //
	// ----------------------------------------------------------------------- //

	/**
	 * @param e
	 * @return
	 */
	@ResponseBody
	@ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
	@ExceptionHandler(NoHandlerFoundException.class)
	public ErrorResponse handleNoHandlerFoundException(NoHandlerFoundException e) {
		return new ErrorResponse()
				.withHttpStatus(HttpStatus.SERVICE_UNAVAILABLE)
				.withMessage(INVALID_REQUEST_MESSAGE)
				.withDescription(e.getMessage());
	}

	/**
	 * @param e
	 * @return
	 */
	@ResponseBody
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public ErrorResponse handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e) {
		return new ErrorResponse()
				.withHttpStatus(HttpStatus.BAD_REQUEST)
				.withMessage(INVALID_REQUEST_MESSAGE)
				.withDescription(e.getMessage());
	}

	/**
	 * @param e
	 * @return
	 */
	@ResponseBody
	@ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
	@ExceptionHandler(HttpMediaTypeNotAcceptableException.class)
	public ErrorResponse handleHttpMediaTypeNotAcceptableException(HttpMediaTypeNotAcceptableException e) {
		return new ErrorResponse()
				.withHttpStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
				.withMessage(INVALID_REQUEST_MESSAGE)
				.withDescription(e.getMessage());
	}

	/**
	 * @param e
	 * @return
	 */
	@ResponseBody
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(ConstraintViolationException.class)
	public ErrorResponse handleMethodConstraintViolationException(ConstraintViolationException e) {
		return new ErrorResponse()
				.withHttpStatus(HttpStatus.BAD_REQUEST)
				.withMessage(INVALID_REQUEST_MESSAGE)
				.withDescription(e.getMessage());
	}

	/**
	 * @param e
	 * @return
	 */
	@ResponseBody
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ErrorResponse handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
		return new ErrorResponse()
				.withHttpStatus(HttpStatus.BAD_REQUEST)
				.withMessage(INVALID_REQUEST_MESSAGE)
				.withDescription(e.getMessage());
	}

	/**
	 * @param e
	 * @return
	 */
	@ResponseBody
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ErrorResponse handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
		return new ErrorResponse()
				.withHttpStatus(HttpStatus.BAD_REQUEST)
				.withMessage(INVALID_REQUEST_MESSAGE)
				.withDescription(e.getMessage());
	}

	/**
	 * @param e
	 * @return
	 */
	@ResponseBody
	@ResponseStatus(HttpStatus.PRECONDITION_REQUIRED)
	@ExceptionHandler(ServletRequestBindingException.class)
	public ErrorResponse handleServletRequestBindingException(ServletRequestBindingException e) {
		return new ErrorResponse()
				.withHttpStatus(HttpStatus.PRECONDITION_REQUIRED)
				.withMessage(INVALID_REQUEST_MESSAGE)
				.withDescription(e.getMessage());
	}

	/**
	 * @param e
	 * @return
	 */
	@ResponseBody
	@ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public ErrorResponse handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
		return new ErrorResponse().withHttpStatus(HttpStatus.METHOD_NOT_ALLOWED)
				.withMessage(INVALID_REQUEST_MESSAGE)
				.withDescription(e.getMessage());
	}

	/**
	 * @param e
	 * @return
	 */
	@ResponseBody
	@ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
	@ExceptionHandler(HttpMediaTypeNotSupportedException.class)
	public ErrorResponse handleHttpMediaTypeNotSupportedException(HttpMediaTypeNotSupportedException e) {
		return new ErrorResponse().withHttpStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
				.withMessage(INVALID_REQUEST_MESSAGE)
				.withDescription(e.getMessage());
	}

	// ----------------------------------------------------------------------- //
	// PARA TODAS AS OUTRAS EXCEÇÕES NÃO CAPTURADAS //
	// ----------------------------------------------------------------------- //

	/**
	 * @param e
	 * @return
	 */
	@ResponseBody
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(Exception.class)
	public ErrorResponse handleUncaughtException(Exception e) {
		return new ErrorResponse().withHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR)
				.withMessage(ErrorCodeEnum.UNKNOWN_ERROR.getMessage())
				.withDescription(e.getMessage());
	}

}
