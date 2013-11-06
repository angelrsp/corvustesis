package com.corvustec.facee.files.xml.guiaRemision;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "destinatarios", propOrder ={"identificacionDestinatario","razonSocialDestinatario","dirDestinatario","motivoTraslado",
	"docAduaneroUnico","codEstabDestino","ruta","codDocSustento","numDocSustento","numAutDocSustento",
	"fechaEmisionDocSustento","detalles"})

public class DestinatariosDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@XmlElement(required= true)
	private String identificacionDestinatario;
	
	@XmlElement(required= true)
	private String razonSocialDestinatario;
	
	@XmlElement(required= true)
	private String dirDestinatario;
	
	@XmlElement(required= true)
	private String motivoTraslado;
	
	
	@XmlElement(required= true)
	private String docAduaneroUnico;
	
	
	@XmlElement(required= true)
	private String codEstabDestino;
	
	@XmlElement(required= true)
	private String ruta;
	
	@XmlElement(required= true)
	private String codDocSustento;

	@XmlElement(required= true)
	private String numAutDocSustento;
	
	@XmlElement(required= true)
	private String numDocSustento;
	
	@XmlElement(required= true)
	private String fechaEmisionDocSustento;
	
	@XmlElement(required= true)
	private DetallesGuiaDTO detalles;
	
	
	
	public  DestinatariosDTO(){}

	public String getIdentificacionDestinatario() {
		return identificacionDestinatario;
	
	}

	public void setIdentificacionDestinatario(String identificacionDestinatario) {
		this.identificacionDestinatario = identificacionDestinatario;
	}

	public String getRazonSocialDestinatario() {
		return razonSocialDestinatario;
	}

	public void setRazonSocialDestinatario(String razonSocialDestinatario) {
		this.razonSocialDestinatario = razonSocialDestinatario;
	}

	public String getDirDestinatario() {
		return dirDestinatario;
	}

	public void setDirDestinatario(String dirDestinatario) {
		this.dirDestinatario = dirDestinatario;
	}

	public String getMotivoTraslado() {
		return motivoTraslado;
	}

	public void setMotivoTraslado(String motivoTraslado) {
		this.motivoTraslado = motivoTraslado;
	}

	public String getDocAduaneroUnico() {
		return docAduaneroUnico;
	}

	public void setDocAduaneroUnico(String docAduaneroUnico) {
		this.docAduaneroUnico = docAduaneroUnico;
	}

	public String getCodEstabDestino() {
		return codEstabDestino;
	}

	public void setCodEstabDestino(String codEstabDestino) {
		this.codEstabDestino = codEstabDestino;
	}

	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	public String getCodDocSustento() {
		return codDocSustento;
	}

	public void setCodDocSustento(String codDocSustento) {
		this.codDocSustento = codDocSustento;
	}

	public String getNumAutDocSustento() {
		return numAutDocSustento;
	}

	public void setNumAutDocSustento(String numAutDocSustento) {
		this.numAutDocSustento = numAutDocSustento;
	}

	public String getNumDocSustento() {
		return numDocSustento;
	}

	public void setNumDocSustento(String numDocSustento) {
		this.numDocSustento = numDocSustento;
	}

	public String getFechaEmisionDocSustento() {
		return fechaEmisionDocSustento;
	}

	public void setFechaEmisionDocSustento(String fechaEmisionDocSustento) {
		this.fechaEmisionDocSustento = fechaEmisionDocSustento;
	}
	
	public DetallesGuiaDTO getDetalles() {
		return detalles;
	}

	public void setDetalles(DetallesGuiaDTO detalles) {
		this.detalles = detalles;
	
	}
	
		
	
}
