package com.corvustec.rtoqad.process.dto;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

public class DataDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Date fecha;
	private Time minuto;
	private String mac;
	private int rssi;
	private Time intervaloSegundoDesde;
	private Time intervaloSegundoHasta;
	private Time intervaloMinutoDesde;
	private Time intervaloMinutoHasta;
	
	
	public DataDTO() {
	
	}

	public String getMac() {
		return mac;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}

	public int getRssi() {
		return rssi;
	}

	public void setRssi(int rssi) {
		this.rssi = rssi;
	}

	public Time getIntervaloSegundoDesde() {
		return intervaloSegundoDesde;
	}

	public void setIntervaloSegundoDesde(Time intervaloSegundoDesde) {
		this.intervaloSegundoDesde = intervaloSegundoDesde;
	}

	public Time getIntervaloSegundoHasta() {
		return intervaloSegundoHasta;
	}

	public void setIntervaloSegundoHasta(Time intervaloSegundoHasta) {
		this.intervaloSegundoHasta = intervaloSegundoHasta;
	}

	public Time getIntervaloMinutoDesde() {
		return intervaloMinutoDesde;
	}

	public void setIntervaloMinutoDesde(Time intervaloMinutoDesde) {
		this.intervaloMinutoDesde = intervaloMinutoDesde;
	}

	public Time getIntervaloMinutoHasta() {
		return intervaloMinutoHasta;
	}

	public void setIntervaloMinutoHasta(Time intervaloMinutoHasta) {
		this.intervaloMinutoHasta = intervaloMinutoHasta;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Time getMinuto() {
		return minuto;
	}

	public void setMinuto(Time minuto) {
		this.minuto = minuto;
	}

	
	
}
