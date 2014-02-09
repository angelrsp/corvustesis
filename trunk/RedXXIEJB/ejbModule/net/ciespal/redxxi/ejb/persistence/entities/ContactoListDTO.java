package net.ciespal.redxxi.ejb.persistence.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ate_contacto_vie database table.
 * 
 */
@Entity
@Table(name="ate_contacto_vie")
@NamedQuery(name="ContactoListDTO.findAll", query="SELECT c FROM ContactoListDTO c")
public class ContactoListDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="cat_tipo")
	private String catTipo;

	@Id
	@Column(name="con_codigo")
	private Integer conCodigo;

	@Column(name="con_entidad")
	private Integer conEntidad;

	@Column(name="con_tipo")
	private Integer conTipo;

	@Column(name="con_valor")
	private String conValor;

	@Column(name="ent_carrera")
	private Integer entCarrera;

	@Column(name="ent_codigo")
	private Integer entCodigo;

	@Column(name="ent_doctor")
	private Integer entDoctor;

	@Column(name="ent_evento")
	private Integer entEvento;

	@Column(name="ent_noticias")
	private Integer entNoticias;

	@Column(name="ent_obra")
	private Integer entObra;

	@Column(name="ent_organizacion")
	private Integer entOrganizacion;

	@Column(name="ent_proyecto_intestigacion")
	private Integer entProyectoIntestigacion;

	@Column(name="ent_publicacion")
	private Integer entPublicacion;

	public ContactoListDTO() {
	}

	public String getCatTipo() {
		return this.catTipo;
	}

	public void setCatTipo(String catTipo) {
		this.catTipo = catTipo;
	}

	public Integer getConCodigo() {
		return this.conCodigo;
	}

	public void setConCodigo(Integer conCodigo) {
		this.conCodigo = conCodigo;
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

	public String getConValor() {
		return this.conValor;
	}

	public void setConValor(String conValor) {
		this.conValor = conValor;
	}

	public Integer getEntCarrera() {
		return this.entCarrera;
	}

	public void setEntCarrera(Integer entCarrera) {
		this.entCarrera = entCarrera;
	}

	public Integer getEntCodigo() {
		return this.entCodigo;
	}

	public void setEntCodigo(Integer entCodigo) {
		this.entCodigo = entCodigo;
	}

	public Integer getEntDoctor() {
		return this.entDoctor;
	}

	public void setEntDoctor(Integer entDoctor) {
		this.entDoctor = entDoctor;
	}

	public Integer getEntEvento() {
		return this.entEvento;
	}

	public void setEntEvento(Integer entEvento) {
		this.entEvento = entEvento;
	}

	public Integer getEntNoticias() {
		return this.entNoticias;
	}

	public void setEntNoticias(Integer entNoticias) {
		this.entNoticias = entNoticias;
	}

	public Integer getEntObra() {
		return this.entObra;
	}

	public void setEntObra(Integer entObra) {
		this.entObra = entObra;
	}

	public Integer getEntOrganizacion() {
		return this.entOrganizacion;
	}

	public void setEntOrganizacion(Integer entOrganizacion) {
		this.entOrganizacion = entOrganizacion;
	}

	public Integer getEntProyectoIntestigacion() {
		return this.entProyectoIntestigacion;
	}

	public void setEntProyectoIntestigacion(Integer entProyectoIntestigacion) {
		this.entProyectoIntestigacion = entProyectoIntestigacion;
	}

	public Integer getEntPublicacion() {
		return this.entPublicacion;
	}

	public void setEntPublicacion(Integer entPublicacion) {
		this.entPublicacion = entPublicacion;
	}

}