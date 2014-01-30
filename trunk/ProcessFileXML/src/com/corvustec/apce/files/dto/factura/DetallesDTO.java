/**
 * 
 */
package com.corvustec.apce.files.dto.factura;

import java.io.Serializable;
import java.util.List;


/**
 * @author wilmerPC
 *
 */
public class DetallesDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	private List<DetalleFacturaDTO> detalle;

	public DetallesDTO() {}

	/**
	 * @return the detalle
	 */
	public List<DetalleFacturaDTO> getDetalle() {
		return detalle;
	}

	/**
	 * @param detalle the detalle to set
	 */
	public void setDetalle(List<DetalleFacturaDTO> detalle) {
		this.detalle = detalle;
	}
	
}
