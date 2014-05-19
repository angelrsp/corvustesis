/**
 * 
 */
package com.corvustec.facturacionelectronica.xml.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @author wilmerPC
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "infoTributaria", propOrder = { "ambiente", "tipoEmision",
		"razonSocial" })
public class InfoTributariaDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@XmlElement(required = true)
	private String ambiente;
	
	@XmlElement(required = true)
	private String tipoEmision;
	
	@XmlElement(required = true)
	private String razonSocial;
	
	
	
	public InfoTributariaDTO() {}

	/**
	 * @return the ambiente
	 */
	public String getAmbiente() {
		return ambiente;
	}

	/**
	 * @param ambiente the ambiente to set
	 */
	public void setAmbiente(String ambiente) {
		this.ambiente = ambiente;
	}

	/**
	 * @return the tipoEmision
	 */
	public String getTipoEmision() {
		return tipoEmision;
	}

	/**
	 * @param tipoEmision the tipoEmision to set
	 */
	public void setTipoEmision(String tipoEmision) {
		this.tipoEmision = tipoEmision;
	}

	/**
	 * @return the razonSocial
	 */
	public String getRazonSocial() {
		return razonSocial;
	}

	/**
	 * @param razonSocial the razonSocial to set
	 */
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}


}
