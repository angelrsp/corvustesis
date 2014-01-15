package ec.edu.uce.silsag.commons.util;

public class SilsagException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructor vacio
	 */
	public SilsagException(){
		super();
	}
	
	/**
	 * 
	 * @param mensaje
	 */
	public SilsagException(String mensaje){
		super(mensaje);
	}
	
	/**
	 * 
	 * @param causa
	 */
	public SilsagException(Throwable causa){
		super(causa);
	}

}
