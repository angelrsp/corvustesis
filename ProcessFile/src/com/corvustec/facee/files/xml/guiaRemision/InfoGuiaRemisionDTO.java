package com.corvustec.facee.files.xml.guiaRemision;


import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import com.corvustec.facee.files.commons.util.Constantes;
import com.corvustec.facee.files.commons.util.UtilApplication;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "infoNotaGuia", propOrder ={"dirEstablecimiento","dirPartida","razonSocialTransportista",
		"tipoIdentificacionTransportista","rucTransportista","rise","obligadoContabilidad",
		"contribuyenteEspecial","fechaIniTransporte","fechaFinTransporte","placa"})


public class InfoGuiaRemisionDTO implements Serializable {



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String dirEstablecimiento;
	
	@XmlElement(required= true)
	private String dirPartida;
	
	@XmlElement(required= true)
	private String razonSocialTransportista;

	@XmlElement(required= true)
	private String tipoIdentificacionTransportista;
	
	@XmlElement(required= true)
	private String rucTransportista;
	

	private String rise;
	
	private String obligadoContabilidad;
	
	private String contribuyenteEspecial;
	
	@XmlElement(required= true)
	private String fechaIniTransporte;
	
	@XmlElement(required= true)
	private String fechaFinTransporte;
	
	@XmlElement(required= true)
	private String placa;
	
	@XmlTransient
	private Date fechaIniTransporteDate;
	
	public Date getFechaIniTransporteDate() {
		return fechaIniTransporteDate;
	}

	public void setFechaIniTransporteDate(Date fechaIniTransporteDate) {
		this.fechaIniTransporteDate = fechaIniTransporteDate;
	}

	public InfoGuiaRemisionDTO(){}

	public String getDirEstablecimiento() {
		return dirEstablecimiento;
	}

	public void setDirEstablecimiento(String dirEstablecimiento) {
		this.dirEstablecimiento = dirEstablecimiento;
	}

	public String getDirPartida() {
		return dirPartida;
	}

	public void setDirPartida(String dirPartida) {
		this.dirPartida = dirPartida;
	}

	public String getRazonSocialTransportista() {
		return razonSocialTransportista;
	}

	public void setRazonSocialTransportista(String razonSocialTransportista) {
		this.razonSocialTransportista = razonSocialTransportista;
	}

	public String getTipoIdentificacionTransportista() {
		return tipoIdentificacionTransportista;
	}

	public void setTipoIdentificacionTransportista(
			String tipoIdentificacionTransportista) {
		this.tipoIdentificacionTransportista = tipoIdentificacionTransportista;
	}

	public String getRucTransportista() {
		return rucTransportista;
	}

	public void setRucTransportista(String rucTransportista) {
		this.rucTransportista = rucTransportista;
	}

	public String getRise() {
		return rise;
	}

	public void setRise(String rise) {
		this.rise = rise;
	}

	public String getObligadoContabilidad() {
		return obligadoContabilidad;
	}

	public void setObligadoContabilidad(String obligadoContabilidad) {
		this.obligadoContabilidad = obligadoContabilidad;
	}

	public String getContribuyenteEspecial() {
		return contribuyenteEspecial;
	}

	public void setContribuyenteEspecial(String contribuyenteEspecial) {
		this.contribuyenteEspecial = contribuyenteEspecial;
	}

	public String getFechaIniTransporte() {
		fechaIniTransporte = UtilApplication.formatDateToString(fechaIniTransporteDate, Constantes.FORMATO_FECHA_SRI);
		return fechaIniTransporte;
	}

	public void setFechaIniTransporte(String fechaIniTransporte) {
		this.fechaIniTransporte = fechaIniTransporte;
	}

	public String getFechaFinTransporte() {
		return fechaFinTransporte;
	}

	public void setFechaFinTransporte(String fechaFinTransporte) {
		this.fechaFinTransporte = fechaFinTransporte;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
	
	
	
}