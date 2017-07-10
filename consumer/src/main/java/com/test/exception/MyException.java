package com.test.exception;


public class MyException extends Exception {
	private static final long serialVersionUID = -8085490381389011258L;

	public MyException(Exception e) {
		super(e.getMessage());
	}

	/**
	 * 
	 * @param message
	 */
	public MyException(ExceptionConstantsEnum message) {
		super(message.toString());
	}
}
