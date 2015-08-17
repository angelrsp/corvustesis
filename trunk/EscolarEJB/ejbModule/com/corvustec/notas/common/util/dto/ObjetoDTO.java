package com.corvustec.notas.common.util.dto;

import java.io.Serializable;

public class ObjetoDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private int codigo;
	private String descripcion;
	
	public ObjetoDTO() {
	
	}
	
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}
