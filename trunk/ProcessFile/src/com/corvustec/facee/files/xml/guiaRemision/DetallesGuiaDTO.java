package com.corvustec.facee.files.xml.guiaRemision;


import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="",propOrder={"detalle"})

public class DetallesGuiaDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	
	@XmlElement(required=true)
	private List<DetalleGuiaDTO> detalle;
	
	public DetallesGuiaDTO(){}
	

	public List<DetalleGuiaDTO> getDetalle() {
		return detalle;
	}

	public void setDetalle(List<DetalleGuiaDTO> detalle) {
		this.detalle = detalle;
	}
	
	
	

}
