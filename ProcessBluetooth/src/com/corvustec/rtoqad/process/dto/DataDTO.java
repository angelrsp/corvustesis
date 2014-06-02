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
	
	private Time entradaAgencia;
	private Time salidaAgencia;
	private Time entradaFila;
	private Time salidaFila;
	
	private Double tiempoAgencia;
	private Double tiempoFila;
	
	
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

	public Time getEntradaAgencia() {
		return entradaAgencia;
	}

	public void setEntradaAgencia(Time entradaAgencia) {
		this.entradaAgencia = entradaAgencia;
	}

	public Time getSalidaAgencia() {
		return salidaAgencia;
	}

	public void setSalidaAgencia(Time salidaAgencia) {
		this.salidaAgencia = salidaAgencia;
	}

	public Time getEntradaFila() {
		return entradaFila;
	}

	public void setEntradaFila(Time entradaFila) {
		this.entradaFila = entradaFila;
	}

	public Time getSalidaFila() {
		return salidaFila;
	}

	public void setSalidaFila(Time salidaFila) {
		this.salidaFila = salidaFila;
	}

	public Double getTiempoAgencia() {
		return tiempoAgencia;
	}

	public void setTiempoAgencia(Double tiempoAgencia) {
		this.tiempoAgencia = tiempoAgencia;
	}

	public Double getTiempoFila() {
		return tiempoFila;
	}

	public void setTiempoFila(Double tiempoFila) {
		this.tiempoFila = tiempoFila;
	}

	public double getMedia() {
		return media;
	}

	public void setMedia(double media) {
		this.media = media;
	}


	
	
}
