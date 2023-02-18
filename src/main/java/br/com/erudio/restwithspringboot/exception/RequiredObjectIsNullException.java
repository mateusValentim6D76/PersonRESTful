package br.com.erudio.restwithspringboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class RequiredObjectIsNullException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public RequiredObjectIsNullException(String exception) {
		 super(exception);
	}
	public RequiredObjectIsNullException() {
		super("It is not allowed to persist a null object !");
	}

}
