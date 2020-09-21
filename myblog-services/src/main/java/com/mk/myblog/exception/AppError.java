package com.mk.myblog.exception;

import java.io.Serializable;

public class AppError implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer errorCode;
	private String message;
	private String description;

	public AppError() {
	}

	public AppError(Integer errorCode, String message, String description) {
		super();
		this.errorCode = errorCode;
		this.message = message;
		this.description = description;
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
