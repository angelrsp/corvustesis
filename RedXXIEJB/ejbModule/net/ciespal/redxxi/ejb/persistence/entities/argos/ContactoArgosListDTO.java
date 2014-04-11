package net.ciespal.redxxi.ejb.persistence.entities.argos;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the arg_contacto_vie database table.
 * 
 */
@Entity
@Table(name="arg_contacto_vie")
@NamedQuery(name="ContactoArgosListVie.findAll", query="SELECT c FROM ContactoArgosListVie c")
public class ContactoArgosListDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="con_codigo")
	private Integer conCodigo;

	@Column(name="con_descripcion")
	private String conDescripcion;

	@Column(name="con_entidad")
	private Integer conEntidad;

	@Column(name="con_tipo")
	private Integer conTipo;

	@Column(name="ent_codigo")
	private Integer entCodigo;

	@Column(name="ent_tipo")
	private Integer entTipo;

	public ContactoArgosListDTO() {
	}

	public Integer getConCodigo() {
		return this.conCodigo;
	}

	public void setConCodigo(Integer conCodigo) {
		this.conCodigo = conCodigo;
	}

	public String getConDescripcion() {
		return this.conDescripcion;
	}

	public void setConDescripcion(String conDescripcion) {
		this.conDescripcion = conDescripcion;
	}

	public Integer getConEntidad() {
		return this.conEntidad;
	}

	public void setConEntidad(Integer conEntidad) {
		this.conEntidad = conEntidad;
	}

	public Integer getConTipo() {
		return this.conTipo;
	}

	public void setConTipo(Integer conTipo) {
		this.conTipo = conTipo;
	}

	public Integer getEntCodigo() {
		return this.entCodigo;
	}

	public void setEntCodigo(Integer entCodigo) {
		this.entCodigo = entCodigo;
	}

	public Integer getEntTipo() {
		return this.entTipo;
	}

	public void setEntTipo(Integer entTipo) {
		this.entTipo = entTipo;
	}

}