package com.shopping.exception;

public class customerDataInvalidException extends RuntimeException {

	private String exceptionmessage;

	public customerDataInvalidException() {

	}

	public customerDataInvalidException(String exceptionmessage) {

		this.exceptionmessage = exceptionmessage;
	}

	public String getExceptionmessage() {
		return exceptionmessage;
	}

	public void setExceptionmessage(String exceptionmessage) {
		this.exceptionmessage = exceptionmessage;
	}

	@Override
	public String toString() {
		return "customerDataInvalidException [exceptionmessage=" + exceptionmessage + "]";
	}

}
