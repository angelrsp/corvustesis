/**
 * 
 */
package com.corvustec.facee.files.xml.factura;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import com.corvustec.facee.files.commons.util.Constantes;
import com.corvustec.facee.files.commons.util.UtilApplication;
import com.corvustec.facee.files.xml.commons.TotalConImpuestosDTO;

/**
 * @author wilmerPC
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "infoFactura", propOrder = { "fechaEmision",
		"dirEstablecimiento", "contribuyenteEspecial", "obligadoContabilidad",
		"tipoIdentificacionComprador", "guiaRemision", "razonSocialComprador",
		"identificacionComprador", "totalSinImpuestos", "totalDescuento",
		"totalConImpuestos", "propina", "importeTotal", "moneda" })
public class InfoFacturaDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Fecha con formato dd/mm/aaaa
	 */
	@XmlTransient
	private Date fechaEmisionDate;
	
	@XmlElement(required = true)
	private String fechaEmision;
	
	private String dirEstablecimiento;
	
	private String contribuyenteEspecial;
	
	private String obligadoContabilidad;
	
	@XmlElement(required = true)
	private String tipoIdentificacionComprador;
	
	private String guiaRemision;
	
	@XmlElement(required = true)
	private String razonSocialComprador;
	
	@XmlElement(required = true)
	private String identificacionComprador;
	
	@XmlElement(required = true)
	private BigDecimal totalSinImpuestos;
	
	@XmlElement(required = true)
	private BigDecimal totalDescuento;
	
	@XmlElement(required = true)
	private TotalConImpuestosDTO totalConImpuestos;
	
	@XmlElement(required = true)
	private BigDecimal propina;
	
	@XmlElement(required = true)
	private BigDecimal importeTotal;
	
	private String moneda;
	
	
	public InfoFacturaDTO () {}

	/**
	 * @return the fechaEmision
	 */
	public Date getFechaEmisionDate() {
		return fechaEmisionDate;
	}
	
	/**
	 * @param fechaEmisionDate the fechaEmisionDate to set
	 */
	public void setFechaEmisionDate(Date fechaEmisionDate) {
		this.fechaEmisionDate = fechaEmisionDate;
	}
	
	public String getFechaEmision() {
		
		fechaEmision = UtilApplication.formatDateToString(fechaEmisionDate, Constantes.FORMATO_FECHA_SRI);
		return fechaEmision;
	}
	
	/**
	 * @param fechaEmision the fechaEmision to set
	 */
	public void setFechaEmision(String fechaEmision) {
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
	 * @return the contribuyenteEspecial
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
	 * @return the tipoIdentificacionComprador
	 */
	public String getTipoIdentificacionComprador() {
		return tipoIdentificacionComprador;
	}

	/**
	 * @param tipoIdentificacionComprador the tipoIdentificacionComprador to set
	 */
	public void setTipoIdentificacionComprador(String tipoIdentificacionComprador) {
		this.tipoIdentificacionComprador = tipoIdentificacionComprador;
	}

	/**
	 * @return the razonSocialComprador
	 */
	public String getRazonSocialComprador() {
		return razonSocialComprador;
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
	 * @return the totalSinImpuestos
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
	 * @return the totalDescuento
	 */
	public BigDecimal getTotalDescuento() {
		return totalDescuento;
	}

	/**
	 * @param totalDescuento the totalDescuento to set
	 */
	public void setTotalDescuento(BigDecimal totalDescuento) {
		this.totalDescuento = totalDescuento;
	}

	/**
	 * @return the propina
	 */
	public BigDecimal getPropina() {
		return propina;
	}

	/**
	 * @param propina the propina to set
	 */
	public void setPropina(BigDecimal propina) {
		this.propina = propina;
	}

	/**
	 * @return the importeTotal
	 */
	public BigDecimal getImporteTotal() {
		return importeTotal;
	}

	/**
	 * @param importeTotal the importeTotal to set
	 */
	public void setImporteTotal(BigDecimal importeTotal) {
		this.importeTotal = importeTotal;
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
	 * @return the guiaRemision
	 */
	public String getGuiaRemision() {
		return guiaRemision;
	}

	/**
	 * @param guiaRemision the guiaRemision to set
	 */
	public void setGuiaRemision(String guiaRemision) {
		this.guiaRemision = guiaRemision;
	}


	/**
	 * @return the totalConImpuestos
	 */
	public TotalConImpuestosDTO getTotalConImpuestos() {
		return totalConImpuestos;
	}
	
	/**
	 * @param totalConImpuestos the totalConImpuestos to set
	 */
	public void setTotalConImpuestos(TotalConImpuestosDTO totalConImpuestos) {
		this.totalConImpuestos = totalConImpuestos;
	}
	
	

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "InfoFacturaDTO [fechaEmision=" 
//	+ fechaEmision
				+ ", dirEstablecimiento=" + dirEstablecimiento
				+ ", contribuyenteEspecial=" + contribuyenteEspecial
				+ ", obligadoContabilidad=" + obligadoContabilidad
				+ ", tipoIdentificacionComprador="
				+ tipoIdentificacionComprador + ", guiaRemision="
				+ guiaRemision + ", razonSocialComprador="
				+ razonSocialComprador + ", identificacionComprador="
				+ identificacionComprador + ", totalSinImpuestos="
				+ totalSinImpuestos + ", totalDescuento=" + totalDescuento
//				+ ", totalConImpuestos=" + totalConImpuestos 
				+ ", propina="
				+ propina + ", importeTotal=" + importeTotal + ", moneda="
				+ moneda + "]";
	}

	
	
}
