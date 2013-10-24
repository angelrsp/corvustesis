package ec.edu.uce.silsae.commons.util;

public class SilsaeException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructor vacio
	 */
	public SilsaeException(){
		super();
	}
	
	/**
	 * 
	 * @param mensaje
	 */
	public SilsaeException(String mensaje){
		super(mensaje);
	}
	
	/**
	 * 
	 * @param causa
	 */
	public SilsaeException(Throwable causa){
		super(causa);
	}

}
