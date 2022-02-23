package com.example.demo.exception;

public class HealthCheckFailed extends Exception{
	private static final long serialVersionUID = 1L;

	public HealthCheckFailed() {
		super("Health Check Failed");
	}

}
