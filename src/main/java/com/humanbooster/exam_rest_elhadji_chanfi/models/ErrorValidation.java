package com.humanbooster.exam_rest_elhadji_chanfi.models;

public class ErrorValidation {
	private String input;
	private String error;
	
	public ErrorValidation(String input, String error) {
		this.input = input;
		this.error = error;
	}

	public ErrorValidation() {
	}

	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
	
	
}
