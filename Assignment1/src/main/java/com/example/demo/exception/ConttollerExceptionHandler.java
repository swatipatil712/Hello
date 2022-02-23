package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

public class ConttollerExceptionHandler {
	@ExceptionHandler
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public String customerNotFound(StudentNotAdded exception) {
		return exception.getMessage();
	}
	
	@ExceptionHandler
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public String customerNotAdded(StudentNotFound exception) {
		return exception.getMessage();
	}
	
	@ExceptionHandler
	@ResponseStatus(value = HttpStatus.EXPECTATION_FAILED)
	public String healthCheckFailedM(HealthCheckFailed exception) {
		return exception.getMessage();
	}

}
