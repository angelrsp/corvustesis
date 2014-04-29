package com.corvustec.rtoqad.process.dto;

import java.io.Serializable;
import java.sql.Timestamp;

public class DataDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Timestamp fecha;
	private String mac;
	private int rssi;
	
	public DataDTO() {
	
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
	
	
}
