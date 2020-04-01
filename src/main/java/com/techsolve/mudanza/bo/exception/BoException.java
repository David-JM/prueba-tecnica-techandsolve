package com.techsolve.mudanza.bo.exception;

/**
 * Class to manage exceptions in the Business layer
 * 
 * @author David Martinez
 *
 */
public class BoException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public BoException(String message) {
		super(message);
	}

}
