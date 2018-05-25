package com.fundoonotes.exception;

import com.fundoonotes.utility.Response;

public class EmailAlreadyExistsException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public EmailAlreadyExistsException() {
		super("Email already registered");
	}

	public Response getResponse() {
		Response response = new Response();
		response.setMsg(this.getMessage());
		response.setStatus(-1);
		return response;
	}
<<<<<<< HEAD
=======

>>>>>>> cab15fd899c58b94bca5aab4dd9a0a17fba0a01c
}
