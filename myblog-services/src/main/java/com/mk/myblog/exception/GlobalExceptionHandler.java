package com.mk.myblog.exception;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@Autowired
	private Mapper mapper;

	@ExceptionHandler(value = AppException.class)
	public ResponseEntity<AppError> appExceptionHandler(AppException appException) {
		final AppError appError = mapper.map(appException, AppError.class);
		return new ResponseEntity<AppError>(appError, HttpStatus.OK);
	}

	@ExceptionHandler(value = Exception.class)
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR, value = HttpStatus.INTERNAL_SERVER_ERROR)
	public AppError exceptionHandler(Exception exception) {
		final AppError appError = new AppError(HttpStatus.INTERNAL_SERVER_ERROR.value(), exception.getMessage(),
				"Contact dev team for more information");
		return appError;
	}

}
