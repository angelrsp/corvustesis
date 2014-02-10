package ec.edu.uce.silsag.commons.dto.util;

import java.io.Serializable;

public class ResultadoReportDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long cantidad;
	private int resCodigo;
	private String resDescripcion;
	
	
	public ResultadoReportDTO() {

	}
	
	public ResultadoReportDTO(long cantidad,int resCodigo, String resDescripcion) {
		super();
		this.cantidad = cantidad;		
		this.resCodigo = resCodigo;
		this.resDescripcion = resDescripcion;
	}

	public int getResCodigo() {
		return resCodigo;
	}
	public void setResCodigo(int resCodigo) {
		this.resCodigo = resCodigo;
	}
	public String getResDescripcion() {
		return resDescripcion;
	}
	public void setResDescripcion(String resDescripcion) {
		this.resDescripcion = resDescripcion;
	}

	public long getCantidad() {
		return cantidad;
	}

	public void setCantidad(long cantidad) {
		this.cantidad = cantidad;
	}
	
}
