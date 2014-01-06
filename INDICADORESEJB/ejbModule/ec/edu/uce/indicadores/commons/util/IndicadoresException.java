package ec.edu.uce.indicadores.commons.util;

public class IndicadoresException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructor vacio
	 */
	public IndicadoresException(){
		super();
	}
	
	/**
	 * 
	 * @param mensaje
	 */
	public IndicadoresException(String mensaje){
		super(mensaje);
	}
	
	/**
	 * 
	 * @param causa
	 */
	public IndicadoresException(Throwable causa){
		super(causa);
	}

}
