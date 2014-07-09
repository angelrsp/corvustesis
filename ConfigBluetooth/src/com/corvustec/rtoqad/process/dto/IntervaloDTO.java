package com.corvustec.rtoqad.process.dto;

import java.io.Serializable;
import java.sql.Timestamp;

public class IntervaloDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private Timestamp fecha;
	private String mac;
	private int rssi;

	private Timestamp intervaloSegundo;
	private Timestamp intervaloMinuto;
	
	public IntervaloDTO() {
	
	}

	public Timestamp getFecha() {
		return fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
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

	public Timestamp getIntervaloSegundo() {
		return intervaloSegundo;
	}

	public void setIntervaloSegundo(Timestamp intervaloSegundo) {
		this.intervaloSegundo = intervaloSegundo;
	}

	public Timestamp getIntervaloMinuto() {
		return intervaloMinuto;
	}

	public void setIntervaloMinuto(Timestamp intervaloMinuto) {
		this.intervaloMinuto = intervaloMinuto;
	}
}


