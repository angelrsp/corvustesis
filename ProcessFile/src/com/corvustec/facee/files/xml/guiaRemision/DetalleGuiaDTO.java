package com.corvustec.facee.files.xml.guiaRemision;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "codigoInterno", "codigoAdicional",
		"descripcion", "cantidad"})

public class DetalleGuiaDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@XmlElement(required = true)
	private String codigoInterno;
	

	private String codigoAdicional;
	
	@XmlElement(required = true)
	private String descripcion;
	
	@XmlElement(required = true)
	private BigDecimal cantidad;
	
	
	
	public DetalleGuiaDTO() {}



	public String getCodigoInterno() {
		return codigoInterno;
	}



	public void setCodigoInterno(String codigoInterno) {
		this.codigoInterno = codigoInterno;
	}



	public String getCodigoAdicional() {
		return codigoAdicional;
	}



	public void setCodigoAdicional(String codigoAdicional) {
		this.codigoAdicional = codigoAdicional;
	}



	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}



	public BigDecimal getCantidad() {
		return cantidad;
	}



	public void setCantidad(BigDecimal cantidad) {
		this.cantidad = cantidad;
	}
	
	
	
	

}
