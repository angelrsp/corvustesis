package com.corvustec.apce.files.dto.factura;

import java.math.BigDecimal;
import java.util.Date;

public class InfoFacturaDTO {

	
    private Date fechaEmisionDate;
   
    private String fechaEmision;
   
    private String dirEstablecimiento;
   
    private String contribuyenteEspecial;
   
    private String obligadoContabilidad;
   
    private String tipoIdentificacionComprador;
   
    private String guiaRemision;
   
    private String razonSocialComprador;
   
    private String identificacionComprador;
   
    private BigDecimal totalSinImpuestos;
   
    private BigDecimal totalDescuento;
   
    private TotalConImpuestosDTO totalConImpuestos;
   
    private BigDecimal propina;
   
    private BigDecimal importeTotal;
   
    private String moneda;

	public Date getFechaEmisionDate() {
		return fechaEmisionDate;
	}

	public void setFechaEmisionDate(Date fechaEmisionDate) {
		this.fechaEmisionDate = fechaEmisionDate;
	}

	public String getFechaEmision() {
		return fechaEmision;
	}

	public void setFechaEmision(String fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

	public String getDirEstablecimiento() {
		return dirEstablecimiento;
	}

	public void setDirEstablecimiento(String dirEstablecimiento) {
		this.dirEstablecimiento = dirEstablecimiento;
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

	public String getTipoIdentificacionComprador() {
		return tipoIdentificacionComprador;
	}

	public void setTipoIdentificacionComprador(String tipoIdentificacionComprador) {
		this.tipoIdentificacionComprador = tipoIdentificacionComprador;
	}

	public String getGuiaRemision() {
		return guiaRemision;
	}

	public void setGuiaRemision(String guiaRemision) {
		this.guiaRemision = guiaRemision;
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

	public BigDecimal getTotalSinImpuestos() {
		return totalSinImpuestos;
	}

	public void setTotalSinImpuestos(BigDecimal totalSinImpuestos) {
		this.totalSinImpuestos = totalSinImpuestos;
	}

	public BigDecimal getTotalDescuento() {
		return totalDescuento;
	}

	public void setTotalDescuento(BigDecimal totalDescuento) {
		this.totalDescuento = totalDescuento;
	}

	public BigDecimal getPropina() {
		return propina;
	}

	public void setPropina(BigDecimal propina) {
		this.propina = propina;
	}

	public BigDecimal getImporteTotal() {
		return importeTotal;
	}

	public void setImporteTotal(BigDecimal importeTotal) {
		this.importeTotal = importeTotal;
	}

	public TotalConImpuestosDTO getTotalConImpuestos() {
		return totalConImpuestos;
	}

	public void setTotalConImpuestos(TotalConImpuestosDTO totalConImpuestos) {
		this.totalConImpuestos = totalConImpuestos;
	}

	public String getMoneda() {
		return moneda;
	}

	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}
	
}
