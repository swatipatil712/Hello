package com.example.demo.exception;

public class StudentNotAdded extends RuntimeException{
	public StudentNotAdded(String errorMessage) {
        super(errorMessage);
    }

}
