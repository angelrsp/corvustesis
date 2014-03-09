package com.corvustec.commons.util;

public class CorvustecException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructor vacio
	 */
	public CorvustecException(){
		super();
	}
	
	/**
	 * 
	 * @param mensaje
	 */
	public CorvustecException(String mensaje){
		super(mensaje);
	}
	
	/**
	 * 
	 * @param causa
	 */
	public CorvustecException(Throwable causa){
		super(causa);
	}

}
