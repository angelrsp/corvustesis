package com.corvustec.notas.common.util;

public class CorvustecException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CorvustecException() {
		super();
	}
	
	public CorvustecException(String message)
	{
		super(message);
	}
	
	public CorvustecException(String message,Throwable cause)
	{
		super(message, cause);
	}

	public CorvustecException(Throwable cause) {
		super(cause);
	}
	
}
