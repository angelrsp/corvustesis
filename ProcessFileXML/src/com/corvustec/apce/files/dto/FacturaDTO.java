package com.corvustec.apce.files.dto;

import java.io.Serializable;


public class FacturaDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String version;
	
	private String id;
	
	private InfoTributariaDTO infoTributaria;
	
	private InfoFacturaDTO infoFactura;
	
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
