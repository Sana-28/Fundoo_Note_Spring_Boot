package com.fundoonotes.utility;

import java.util.List;

import org.springframework.validation.FieldError;

public class RegisterErrors extends Response {
	List<FieldError> errors;

	public List<FieldError> getErrors() {
		return errors;
	}

	public void setErrors(List<FieldError> errors) {
		this.errors = errors;
	}
<<<<<<< HEAD
=======

>>>>>>> cab15fd899c58b94bca5aab4dd9a0a17fba0a01c
}
