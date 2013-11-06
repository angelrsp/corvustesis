package com.corvustec.facee.files.xml.notaCredito;

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

public class DetallesNotaDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@XmlElement(required = true)
	private List<DetalleNotaCreditoDTO> detalle;

	public DetallesNotaDTO() {}

	public List<DetalleNotaCreditoDTO> getDetalle() {
		return detalle;
	}

	public void setDetalle(List<DetalleNotaCreditoDTO> detalle) {
		this.detalle = detalle;
	}

	
	
}


