package com.corvustec.apce.files.dto.factura;

import java.io.Serializable;

import com.corvustec.apce.files.commons.util.MessagesApplication;

public class InfoTributariaDTO implements Serializable{

	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private String ambiente;
   
    private String tipoEmision;
   
    private String razonSocial;
   
    private String nombreComercial;
   
    private String ruc;
   
    private String claveAcceso;
   
    private String codDoc;
   
    private String ambienteText;
    
    private String tipoEmisonText;
    
    /**
     * establecimiento
     */
    private String estab;
   
    /**
     * puntoEmision
     */
    private String ptoEmi;
   
    private String secuencial;
   
    private String dirMatriz;

	public String getAmbiente() {
		return ambiente;
	}

	public void setAmbiente(String ambiente) {
		this.ambiente = ambiente;
	}

	public String getTipoEmision() {
		return tipoEmision;
	}

	public void setTipoEmision(String tipoEmision) {
		this.tipoEmision = tipoEmision;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getNombreComercial() {
		return nombreComercial;
	}

	public void setNombreComercial(String nombreComercial) {
		this.nombreComercial = nombreComercial;
	}

	public String getRuc() {
		return ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public String getClaveAcceso() {
		return claveAcceso;
	}

	public void setClaveAcceso(String claveAcceso) {
		this.claveAcceso = claveAcceso;
	}

	public String getCodDoc() {
		return codDoc;
	}

	public void setCodDoc(String codDoc) {
		this.codDoc = codDoc;
	}

	public String getEstab() {
		return estab;
	}

	public void setEstab(String estab) {
		this.estab = estab;
	}

	public String getPtoEmi() {
		return ptoEmi;
	}

	public void setPtoEmi(String ptoEmi) {
		this.ptoEmi = ptoEmi;
	}

	public String getSecuencial() {
		return secuencial;
	}

	public void setSecuencial(String secuencial) {
		this.secuencial = secuencial;
	}

	public String getDirMatriz() {
		return dirMatriz;
	}

	public void setDirMatriz(String dirMatriz) {
		this.dirMatriz = dirMatriz;
	}

	public String getAmbienteText() {
		if(getAmbiente().equals(MessagesApplication.getInstancia().getString("com.corvustec.apce.files.ambiente.desarrollo"))){
			ambienteText=MessagesApplication.getInstancia().getString("com.corvustec.apce.files.ambiente.desarrolloText");
		}
		else if(getAmbiente().equals(MessagesApplication.getInstancia().getString("com.corvustec.apce.files.ambiente.produccion"))){
			ambienteText=MessagesApplication.getInstancia().getString("com.corvustec.apce.files.ambiente.produccionText");
		}
		return ambienteText;
	}

	public void setAmbienteText(String ambienteText) {
		this.ambienteText = ambienteText;
	}

	public String getTipoEmisonText() {
		if(getTipoEmision().equals(MessagesApplication.getInstancia().getString("com.corvustec.apce.files.tipo.emision.normal"))){
			tipoEmisonText=MessagesApplication.getInstancia().getString("com.corvustec.apce.files.tipo.emision.normalText");
		}
		else if(getTipoEmision().equals(MessagesApplication.getInstancia().getString("com.corvustec.apce.files.tipo.emision.contingencia"))){
			tipoEmisonText=MessagesApplication.getInstancia().getString("com.corvustec.apce.files.tipo.emision.contingenciaText");
		}
		return tipoEmisonText;
	}

	public void setTipoEmisonText(String tipoEmisonText) {
		this.tipoEmisonText = tipoEmisonText;
	}

}
