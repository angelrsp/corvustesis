/**
 * 
 */
package com.corvustec.apce.files.dto;

import java.io.Serializable;
import java.util.List;

/**
 * @author wilmerPC
 *
 */
public class ImpuestosDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<ImpuestoDTO> impuesto;
	
	public ImpuestosDTO () {}

	/**
	 * @return the impuesto
	 */
	public List<ImpuestoDTO> getImpuesto() {
		return impuesto;
	}

	/**
	 * @param impuesto the impuesto to set
	 */
	public void setImpuesto(List<ImpuestoDTO> impuesto) {
		this.impuesto = impuesto;
	}
	
}
