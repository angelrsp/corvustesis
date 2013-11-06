/**
 * 
 */
package com.corvustec.facee.files.commons.exception;

/**
 * @author wilmerPC
 *
 */
public class ProcessFileException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * C&oacute;digo del error.
	 */
	private String codigoError;
	
	/**
	 * Descripci&oacute;n del error.
	 */
	private String descripcionError;
	
	/**
	 * Constructor
	 */
	public ProcessFileException () {}
	
	/**
	 * 
	 * @param mensaje
	 */
	public ProcessFileException(String mensaje){
		super(mensaje);
	}
	
	/**
	 * 
	 * @param mensaje Mensaje de error.
	 * @param causa Causa del error.
	 */
	public ProcessFileException(String mensaje, Throwable causa){
		super(mensaje, causa);
	}
	
	/**
	 * 
	 * @param causa
	 */
	public ProcessFileException(Throwable causa){
		super(causa);
	}
	
	/**
	 * 
	 * @param codigoError C&oacute;digo del error.
	 * @param descripcionError Descripci&oacute;n del error.
	 */
	public ProcessFileException(String codigoError, String descripcionError){
		this.setCodigoError(codigoError);
		this.setDescripcionError(descripcionError);
	}
	
	/**
	 * 
	 * @param codigoError C&oacute;digo del error.
	 * @param mensaje
	 * @param descripcion Descripci&oacute;n del error.
	 */
	public ProcessFileException(String codigoError, String mensaje, String descripcion){
		super(mensaje);
		this.setCodigoError(codigoError);
		this.setDescripcionError(descripcionError);
	}

	/**
	 * @return the codigoError 
	 */
	public String getCodigoError() {
		return codigoError;
	}

	/**
	 * @param codigoError the codigoError to set
	 */
	public void setCodigoError(String codigoError) {
		this.codigoError = codigoError;
	}

	/**
	 * @return the descripcionError
	 */
	public String getDescripcionError() {
		return descripcionError;
	}

	/**
	 * @param descripcionError the descripcionError to set
	 */
	public void setDescripcionError(String descripcionError) {
		this.descripcionError = descripcionError;
	}

}
