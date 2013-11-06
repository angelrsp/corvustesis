/**
 * 
 */
package com.corvustec.facee.files.xml.factura;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @author wilmerPC
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="", propOrder={"detalle"})

public class DetallesDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@XmlElement(required = true)
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
