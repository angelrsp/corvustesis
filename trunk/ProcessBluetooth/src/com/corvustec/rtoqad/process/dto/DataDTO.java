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
	
	private double media;
	private double desviacion;
	
	private int numeroIntervalo;
	//1 in 0 out
	private int estado;
	
	public DataDTO() {
		estado=-1;
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

	public double getMedia() {
		return media;
	}

	public void setMedia(double media) {
		this.media = media;
	}

	public double getDesviacion() {
		return desviacion;
	}

	public void setDesviacion(double desviacion) {
		this.desviacion = desviacion;
	}

	public int getNumeroIntervalo() {
		return numeroIntervalo;
	}

	public void setNumeroIntervalo(int numeroIntervalo) {
		this.numeroIntervalo = numeroIntervalo;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	
	
}
