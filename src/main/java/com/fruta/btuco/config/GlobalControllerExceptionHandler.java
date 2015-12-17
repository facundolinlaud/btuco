package com.fruta.btuco.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.fruta.btuco.exceptions.ResourceAlreadyExistsException;
import com.fruta.btuco.exceptions.ResourceNotFoundException;
import com.fruta.btuco.model.ErrorResponse;

import java.io.IOException;

@ControllerAdvice
public class GlobalControllerExceptionHandler {

	private static final Logger LOGGER = LoggerFactory.getLogger(GlobalControllerExceptionHandler.class);

	@ExceptionHandler(value = IllegalStateException.class)
	@ResponseStatus(value = HttpStatus.I_AM_A_TEAPOT)
	@ResponseBody
	public ErrorResponse handleIllegalStateException(Exception e) {
		LOGGER.error("Internal error", e);
		return new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.toString(), e.toString());
	}

	@ExceptionHandler(value = ResourceAlreadyExistsException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ErrorResponse handleResourceAlreadyExists(ResourceAlreadyExistsException e) {
		return new ErrorResponse(e.getCode(), e.getMessage());
	}

	@ExceptionHandler(value = ResourceNotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ResponseBody
	public ErrorResponse handleResourceNotFound(ResourceNotFoundException e) {
		return new ErrorResponse(e.getCode(), e.getMessage());
	}

	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ErrorResponse handleValidationException(MethodArgumentNotValidException e) {
		BindingResult validationResult = e.getBindingResult();
		String object = validationResult.getObjectName();
		ErrorResponse response = new ErrorResponse("RESOURCE_NOT_VALID", "Validation error: " + object + " is not valid. ");
		validationResult
				.getFieldErrors()
				.stream()
				.forEach(
						error -> response.addCause("Invalid " + error.getField(),
								StringUtils.capitalize(error.getField() + " " + error.getDefaultMessage())));

		LOGGER.info("BAD_REQUEST:", e);
		return response;
	}

	@ExceptionHandler(value = Exception.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public ErrorResponse handleException(Exception e) {
		LOGGER.error("Internal error", e);
		return new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.toString(), e.toString());
	}
}
