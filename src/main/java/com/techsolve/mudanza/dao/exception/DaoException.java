package com.techsolve.mudanza.dao.exception;

/**
 * Class to manage exceptions in the Dao layer
 * 
 * @author David Martinez
 *
 */
public class DaoException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public DaoException(String message) {
		super(message);
	}

	public DaoException(String message, Throwable cause) {
		super(message, cause);
	}

}
