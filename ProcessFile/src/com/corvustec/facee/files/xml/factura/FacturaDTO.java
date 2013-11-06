package com.corvustec.facee.files.xml.factura;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

import com.corvustec.facee.files.xml.commons.InfoTributariaDTO;

@XmlSeeAlso({FacturaDTO.class})
@XmlRootElement(name="factura")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "infoTributaria", "infoFactura", "detalles", "retenciones" })
public class FacturaDTO implements Serializable{
	
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
	private InfoFacturaDTO infoFactura;
	
	@XmlElement(required = true)
	private DetallesDTO detalles;
	
	private RetencionesDTO retenciones;
	
	public FacturaDTO () {}

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
	 * @return the infoFactura
	 */
	public InfoFacturaDTO getInfoFactura() {
		return infoFactura;
	}

	/**
	 * @param infoFactura the infoFactura to set
	 */
	public void setInfoFactura(InfoFacturaDTO infoFactura) {
		this.infoFactura = infoFactura;
	}

	/**
	 * @return the detalles
	 */
	public DetallesDTO getDetalles() {
		return detalles;
	}

	/**
	 * @param detalles the detalles to set
	 */
	public void setDetalles(DetallesDTO detalles) {
		this.detalles = detalles;
	}

	/**
	 * @return the retenciones
	 */
	public RetencionesDTO getRetenciones() {
		return retenciones;
	}

	/**
	 * @param retenciones the retenciones to set
	 */
	public void setRetenciones(RetencionesDTO retenciones) {
		this.retenciones = retenciones;
	}
	
}
