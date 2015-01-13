package ec.edu.uce.besg.common.util;

/**
 * Clase para administrar exepciones en la aplicaci&oacute;n
 * @author 
 *
 */
public class CorvustecException extends Exception {

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
	
	/**
	 * 
	 * @param mensaje
	 * @param causa
	 */
	public CorvustecException(String mensaje, Throwable causa){
		super(mensaje, causa);
	}

}
