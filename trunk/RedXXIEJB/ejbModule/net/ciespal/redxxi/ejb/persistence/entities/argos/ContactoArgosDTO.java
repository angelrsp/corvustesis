package net.ciespal.redxxi.ejb.persistence.entities.argos;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the arg_contacto database table.
 * 
 */
@Entity
@Table(name="arg_contacto")
@NamedQuery(name="ContactoArgosDTO.findAll", query="SELECT c FROM ContactoDTO c")
public class ContactoArgosDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ARG_CONTACTO_CONCODIGO_GENERATOR", sequenceName="ARG_CONTACTO_CON_CODIGO_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ARG_CONTACTO_CONCODIGO_GENERATOR")
	@Column(name="con_codigo")
	private Integer conCodigo;

	@Column(name="con_descripcion")
	private String conDescripcion;

	@Column(name="con_tipo")
	private Integer conTipo;

	//bi-directional many-to-one association to EntidadDTO
	@ManyToOne
	@JoinColumn(name="con_entidad")
	private EntidadArgosDTO argEntidad;

	public ContactoArgosDTO() {
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

	public Integer getConTipo() {
		return this.conTipo;
	}

	public void setConTipo(Integer conTipo) {
		this.conTipo = conTipo;
	}

	public EntidadArgosDTO getArgEntidad() {
		return this.argEntidad;
	}

	public void setArgEntidad(EntidadArgosDTO argEntidad) {
		this.argEntidad = argEntidad;
	}

}