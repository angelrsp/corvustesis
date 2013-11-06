package com.corvustec.facee.files.xml.notaDebito;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import com.corvustec.facee.files.xml.factura.ImpuestosDTO;


/**
 * @author wilmerPC
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "infoNotaCredito", propOrder = { "fechaEmision",
		"dirEstablecimiento", "tipoIdentificacionComprador","razonSocialComprador",
		"identificacionComprador","contribuyenteEspecial", "obligadoContabilidad",
		"rise","codDocModificado","numDocModificado","fechaEmisionDocSustento",
		"totalSinImpuestos","impuestos","valorTotal"})

public class InfoNotaDebitoDTO implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Fecha con formato dd/mm/aaaa
	 */
	@XmlElement(required = true)
	private Date fechaEmision;
	
	private String dirEstablecimiento;
	
	@XmlElement(required = true)
	private String tipoIdentificacionComprador;
	
	@XmlElement(required = true)
	private String razonSocialComprador;
		
	@XmlElement(required = true)
	private String identificacionComprador;
	
	private String contribuyenteEspecial;
	
	private String obligadoContabilidad;
	
	private String rise;
	
	private String codDocModificado;
	
	@XmlElement(required = true)
	private String numDocModificado;
	
	@XmlElement(required = true)
	private String fechaEmisionDocSustento;
	
	@XmlElement(required = true)
	private BigDecimal totalSinImpuestos;
	
	@XmlElement(required = true)
	private ImpuestosDTO impuestos;
	
	@XmlElement(required = true)
	private BigDecimal valorTotal;
	
	
	
	public InfoNotaDebitoDTO () {}

	public Date getFechaEmision() {
		return fechaEmision;
	}

	public void setFechaEmision(Date fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

	public String getDirEstablecimiento() {
		return dirEstablecimiento;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setDirEstablecimiento(String dirEstablecimiento) {
		this.dirEstablecimiento = dirEstablecimiento;
	}

	public String getTipoIdentificacionComprador() {
		return tipoIdentificacionComprador;
	}

	public void setTipoIdentificacionComprador(String tipoIdentificacionComprador) {
		this.tipoIdentificacionComprador = tipoIdentificacionComprador;
	}

	public String getRazonSocialComprador() {
		return razonSocialComprador;
	}

	public void setRazonSocialComprador(String razonSocialComprador) {
		this.razonSocialComprador = razonSocialComprador;
	}

	public String getIdentificacionComprador() {
		return identificacionComprador;
	}

	public void setIdentificacionComprador(String identificacionComprador) {
		this.identificacionComprador = identificacionComprador;
	}

	public String getContribuyenteEspecial() {
		return contribuyenteEspecial;
	}

	public void setContribuyenteEspecial(String contribuyenteEspecial) {
		this.contribuyenteEspecial = contribuyenteEspecial;
	}

	public String getObligadoContabilidad() {
		return obligadoContabilidad;
	}

	public void setObligadoContabilidad(String obligadoContabilidad) {
		this.obligadoContabilidad = obligadoContabilidad;
	}

	public String getRise() {
		return rise;
	}

	public void setRise(String rise) {
		this.rise = rise;
	}

	public String getCodDocModificado() {
		return codDocModificado;
	}

	public void setCodDocModificado(String codDocModificado) {
		this.codDocModificado = codDocModificado;
	}

	public String getNumDocModificado() {
		return numDocModificado;
	}

	public void setNumDocModificado(String numDocModificado) {
		this.numDocModificado = numDocModificado;
	}

	public String getFechaEmisionDocSustento() {
		return fechaEmisionDocSustento;
	}

	public void setFechaEmisionDocSustento(String fechaEmisionDocSustento) {
		this.fechaEmisionDocSustento = fechaEmisionDocSustento;
	}

	public BigDecimal getTotalSinImpuestos() {
		return totalSinImpuestos;
	}

	public void setTotalSinImpuestos(BigDecimal totalSinImpuestos) {
		this.totalSinImpuestos = totalSinImpuestos;
	}

	public ImpuestosDTO getImpuestos() {
		return impuestos;
	}

	public void setImpuestos(ImpuestosDTO impuestos) {
		this.impuestos = impuestos;
	}
	
	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	
	


}
