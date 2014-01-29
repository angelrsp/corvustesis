package net.ciespal.redxxi.ejb.persistence.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ate_contactos database table.
 * 
 */
@Entity
@Table(name="ate_contactos")
@NamedQuery(name="ContactoDTO.findAll", query="SELECT c FROM ContactoDTO c")
public class ContactoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ATE_CONTACTOS_CONCODIGO_GENERATOR", sequenceName="ATE_CONTACTOS_CON_CODIGO_SEQ",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ATE_CONTACTOS_CONCODIGO_GENERATOR")
	@Column(name="con_codigo")
	private Integer conCodigo;

	@Column(name="con_tipo")
	private Integer conTipo;

	@Column(name="con_valor")
	private String conValor;

	//bi-directional many-to-one association to EntidadDTO
	@ManyToOne
	@JoinColumn(name="con_entidad")
	private EntidadDTO ateEntidad;

	public ContactoDTO() {
	}

	public Integer getConCodigo() {
		return this.conCodigo;
	}

	public void setConCodigo(Integer conCodigo) {
		this.conCodigo = conCodigo;
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

	public EntidadDTO getAteEntidad() {
		return this.ateEntidad;
	}

	public void setAteEntidad(EntidadDTO ateEntidad) {
		this.ateEntidad = ateEntidad;
	}

}