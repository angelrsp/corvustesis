/**
 * 
 */
package com.corvustec.facee.files.xml.notaCredito;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import com.corvustec.facee.files.xml.commons.TotalConImpuestosDTO;

/**
 * @author wilmerPC
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "infoNotaCredito", propOrder = { "fechaEmision",
		"dirEstablecimiento", "tipoIdentificacionComprador","razonSocialComprador",
		"identificacionComprador","contribuyenteEspecial", "obligadoContabilidad",
		"rise","codDocModificado","numDocModificado","fechaEmisionDocSustento",
		"totalSinImpuestos","valorModificacion","moneda","totalConImpuestos","motivo" })
public class InfoNotaCreditoDTO implements Serializable{

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
	private BigDecimal valorModificacion;
	

	private String moneda;
	
	@XmlElement(required = true)
	private TotalConImpuestosDTO totalConImpuestos;
	
	@XmlElement(required = true)
	private String motivo;
	
	public InfoNotaCreditoDTO () {}

	/**
	 * @return the fechaEmision
	 */
	public Date getFechaEmision() {
		return fechaEmision;
	}

	/**
	 * @param fechaEmision the fechaEmision to set
	 */
	public void setFechaEmision(Date fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

	/**
	 * @return the dirEstablecimiento
	 */
	public String getDirEstablecimiento() {
		return dirEstablecimiento;
	}

	/**
	 * @param dirEstablecimiento the dirEstablecimiento to set
	 */
	public void setDirEstablecimiento(String dirEstablecimiento) {
		this.dirEstablecimiento = dirEstablecimiento;
	}

	/**
	 * @return the tipoIdentificacionComprador
	 */
	public String getTipoIdentificacionComprador() {
		return tipoIdentificacionComprador;
	}

	/**
	 * @param tipoIdentificacionComprador the tipoIdentificacionComprador to set
	 */
	public void setTipoIdentificacionComprador(String tipoIdentificacionComprador ) {
		this.tipoIdentificacionComprador = tipoIdentificacionComprador;
	}
	
	/**
	 * @param razonSocialComprador the razonSocialComprador to set
	 */
	public void setRazonSocialComprador(String razonSocialComprador) {
		this.razonSocialComprador = razonSocialComprador;
	}
	
	/**
	 * @return the identificacionComprador
	 */
	public String getIdentificacionComprador() {
		return identificacionComprador;
	}

	/**
	 * @param identificacionComprador the identificacionComprador to set
	 */
	public void setIdentificacionComprador(String identificacionComprador) {
		this.identificacionComprador = identificacionComprador;
	}
	
	/**
	 * @param identificacionComprador the identificacionComprador to set
	 */
	
	public String getContribuyenteEspecial() {
		return contribuyenteEspecial;
	}

	/**
	 * @param contribuyenteEspecial the contribuyenteEspecial to set
	 */
	public void setContribuyenteEspecial(String contribuyenteEspecial) {
		this.contribuyenteEspecial = contribuyenteEspecial;
	}
	
	
	/**
	 * @return the obligadoContabilidad
	 */
	public String getObligadoContabilidad() {
		return obligadoContabilidad;
	}

	/**
	 * @param obligadoContabilidad the obligadoContabilidad to set
	 */
	public void setObligadoContabilidad(String obligadoContabilidad) {
		this.obligadoContabilidad = obligadoContabilidad;
	}

	/**
	 * @return the rise
	 * 
	*/
	public String getRise() {
		return rise;
	}

	/**
	 * @param rise the rise to set
	 */
	public void setRise(String rise) {
		this.rise = rise;
	}

	/**
	 * @return the codDocModificado
	 */
	public String getCodDocModificado() {
		return codDocModificado;
	}

	/**
	 * @param codDocModificado the codDcModificado to set
	 */
	public void setCodDocModificado(String codDocModificado) {
		this.codDocModificado = codDocModificado;
	}
	
	/**
	 * @return the numDocModificado
	 */
	public String getNumDocModificado() {
		return numDocModificado;
	}

	/**
	 * @param codDocModificado the codDcModificado to set
	 */
	public void setNumDocModificado(String numDocModificado) {
		this.numDocModificado = numDocModificado;
	}
	
	
	/**
	 * @return the totalSinImpuesto
	 */
	public BigDecimal getTotalSinImpuestos() {
		return totalSinImpuestos;
	}

	/**
	 * @param totalSinImpuestos the totalSinImpuestos to set
	 */
	public void setTotalSinImpuestos(BigDecimal totalSinImpuestos) {
		this.totalSinImpuestos = totalSinImpuestos;
	}

	/**
	 * @return the valorModificacion
	 */
	public BigDecimal getValorModificacion() {
		return valorModificacion;
	}

	/**
	 * @param valorModificacion the valorModificacion to set
	 */
	public void setValorModificacion(BigDecimal valorModificacion) {
		this.valorModificacion = valorModificacion;
	}

	/**
	 * @return the moneda
	 */
	public String getMoneda() {
		return moneda;
	}

	/**
	 * @param moneda the moneda to set
	 */
	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}

	/**
	 * @return the totalConImpuestos
	 */
	public TotalConImpuestosDTO getTotalConImpuestos() {
		return totalConImpuestos;
	}

	/**
	 * @param moneda the totalConImpuestos to set
	 */
	public void setTotalConImpuestos(TotalConImpuestosDTO totalConImpuestos) {
		this.totalConImpuestos = totalConImpuestos;
	}

	@Override
	public String toString() {
		return "InfoNotaCreditoDTO [fechaEmision=" + fechaEmision
				+ ", dirEstablecimiento=" + dirEstablecimiento
				+ ", tipoIdentificacionComprador="
				+ tipoIdentificacionComprador + ", razonSocialComprador="
				+ razonSocialComprador + ", identificacionComprador="
				+ identificacionComprador + ", contribuyenteEspecial="
				+ contribuyenteEspecial + ", obligadoContabilidad="
				+ obligadoContabilidad + ", rise=" + rise
				+ ", codDocModificado=" + codDocModificado
				+ ", numDocModificado=" + numDocModificado
				+ ", fechaEmisionDocSustento=" + fechaEmisionDocSustento
				+ ", totalSinImpuestos=" + totalSinImpuestos
				+ ", valorModificacion=" + valorModificacion + ", moneda="
				+ moneda + ", totalConImpuestos=" + totalConImpuestos + "]";
	}

	public String getFechaEmisionDocSustento() {
		return fechaEmisionDocSustento;
	}

	public void setFechaEmisionDocSustento(String fechaEmisionDocSustento) {
		this.fechaEmisionDocSustento = fechaEmisionDocSustento;
	}

	public String getRazonSocialComprador() {
		return razonSocialComprador;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}


	
	
	
	
}
