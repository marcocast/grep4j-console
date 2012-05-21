package org.grep4j.console.exception;

public class Grep4jConsoleIllegalArgumentException extends IllegalArgumentException {

	private final static String errorMEssagePrefix = "ERROR[Illegal argument]:";

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Grep4jConsoleIllegalArgumentException(String message) {
		super(errorMEssagePrefix + message);
	}

	public Grep4jConsoleIllegalArgumentException(String message, Throwable cause)
	{
		super(errorMEssagePrefix + message, cause);
	}

}
