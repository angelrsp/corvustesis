package net.ciespal.redxxi.ejb.persistence.entities;

import java.io.Serializable;

public class AteneaDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private int codigo;
	private int pais;
	private String descripcion;
	private int count;
	private int tipo;
	
	public AteneaDTO() {

	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getPais() {
		return pais;
	}

	public void setPais(int pais) {
		this.pais = pais;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
}
