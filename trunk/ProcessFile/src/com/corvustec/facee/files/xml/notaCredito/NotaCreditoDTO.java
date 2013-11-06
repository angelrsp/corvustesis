/**
 * 
 */
package com.corvustec.facee.files.xml.notaCredito;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.corvustec.facee.files.xml.commons.InfoTributariaDTO;



@XmlRootElement(name="notaCredito")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"infoTributaria", "infoNotaCredito","detalles"})
public class NotaCreditoDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@XmlAttribute
	private String version;
	
	@XmlAttribute
	private String id;
	
	@XmlElement(required = true)
	private InfoTributariaDTO infoTributaria;
	
	@XmlElement(required = true)
	private InfoNotaCreditoDTO infoNotaCredito;
	
	
	@XmlElement(required = true)
	private DetallesNotaDTO detalles;
	
//	@XmlElement(required = true)
//	private infoAdicionalDTO infoAdicional;
	
	
	public NotaCreditoDTO () {}

	/**
	 * @return the infoTributaria
	 */
	public InfoTributariaDTO getInfoTributaria() {
		return infoTributaria;
	}

	/**
	 * @param infoTributaria the infoTributaria to set
	 */
	public void setInfoTributaria(InfoTributariaDTO infoTributaria) {
		this.infoTributaria = infoTributaria;
	}
	
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
	
	/**
	 * @return the infoNotaCredito
	 */
	public InfoNotaCreditoDTO getInfoNotaCredito() {
		return infoNotaCredito;
	}

	/**
	 * @param infoNotaCredito the infoNotaCredito to set
	 */
	public void setInfoNotaCredito(InfoNotaCreditoDTO infoNotaCredito) {
		this.infoNotaCredito = infoNotaCredito;
	}

	public DetallesNotaDTO getDetalles() {
		return detalles;
	}

	public void setDetalles(DetallesNotaDTO detalles) {
		this.detalles = detalles;
	}


	
	
}
