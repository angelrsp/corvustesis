package com.corvustec.facturacionelectronica.xml.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


@XmlSeeAlso({FacturaDTO.class})
@XmlRootElement(name="factura")
@XmlAccessorType(XmlAccessType.FIELD)
//@XmlType(name = "", propOrder = { "infoTributaria", "infoFactura", "detalles", "retenciones" })
@XmlType(name = "", propOrder = { "infoTributaria" })
public class FacturaDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@XmlAttribute
	private String version;
	
	@XmlAttribute
	private String id;
	
	@XmlAttribute
	private String prueba;
	
	@XmlElement(required = true)
	private InfoTributariaDTO infoTributaria;
	
	public FacturaDTO () {}


	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the version
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * @param version the version to set
	 */
	public void setVersion(String version) {
		this.version = version;
	}


	public String getPrueba() {
		return prueba;
	}


	public void setPrueba(String prueba) {
		this.prueba = prueba;
	}


	public InfoTributariaDTO getInfoTributariaDTO() {
		return infoTributaria;
	}


	public void setInfoTributariaDTO(InfoTributariaDTO infoTributaria) {
		this.infoTributaria = infoTributaria;
	}



	
}
