package net.ciespal.redxxi.ejb.persistence.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ate_modalidad_vie database table.
 * 
 */
@Entity
@Table(name="ate_modalidad_vie")
@NamedQuery(name="ModalidadVieDTO.findAll", query="SELECT m FROM ModalidadVieDTO m")
public class ModalidadVieDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="cat_modalidad")
	private String catModalidad;

	@Column(name="mod_carrera")
	private Integer modCarrera;

	@Id
	@Column(name="mod_codigo")
	private Integer modCodigo;

	@Column(name="mod_modalidad")
	private Integer modModalidad;

	public ModalidadVieDTO() {
	}

	public String getCatModalidad() {
		return this.catModalidad;
	}

	public void setCatModalidad(String catModalidad) {
		this.catModalidad = catModalidad;
	}

	public Integer getModCarrera() {
		return this.modCarrera;
	}

	public void setModCarrera(Integer modCarrera) {
		this.modCarrera = modCarrera;
	}

	public Integer getModCodigo() {
		return this.modCodigo;
	}

	public void setModCodigo(Integer modCodigo) {
		this.modCodigo = modCodigo;
	}

	public Integer getModModalidad() {
		return this.modModalidad;
	}

	public void setModModalidad(Integer modModalidad) {
		this.modModalidad = modModalidad;
	}

}