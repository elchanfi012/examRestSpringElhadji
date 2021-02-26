package com.humanbooster.exam_rest_elhadji_chanfi.exceptions;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.humanbooster.exam_rest_elhadji_chanfi.models.ErrorValidation;

@ControllerAdvice
@ResponseBody
public class RestApplicationHandler extends ResponseEntityExceptionHandler{
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<ErrorValidation> errors = new ArrayList<ErrorValidation>();
		BindingResult result = ex.getBindingResult();
		List<FieldError> fieldsErrors = result.getFieldErrors();
		
		for (FieldError error : fieldsErrors) {
			errors.add(new ErrorValidation(error.getField(), error.getDefaultMessage()));
		}
		return this.handleExceptionInternal(ex, errors, headers, status, request);
	}
}
