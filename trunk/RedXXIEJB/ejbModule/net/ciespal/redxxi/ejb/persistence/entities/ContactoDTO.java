package net.ciespal.redxxi.ejb.persistence.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ate_contacto database table.
 * 
 */
@Entity
@Table(name="ate_contacto")
@NamedQuery(name="ContactoDTO.findAll", query="SELECT c FROM ContactoDTO c")
public class ContactoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ATE_CONTACTO_CONCODIGO_GENERATOR", sequenceName="ATE_CONTACTO_CON_CODIGO_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ATE_CONTACTO_CONCODIGO_GENERATOR")
	@Column(name="con_codigo")
	private Integer conCodigo;

	@Column(name="con_tipo")
	private Integer conTipo;

	@Column(name="con_valor")
	private String conValor;

	//bi-directional many-to-one association to EntidadDTO
	@OneToMany(mappedBy="ateContacto")
	private List<EntidadDTO> ateEntidads;

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

	public List<EntidadDTO> getAteEntidads() {
		return this.ateEntidads;
	}

	public void setAteEntidads(List<EntidadDTO> ateEntidads) {
		this.ateEntidads = ateEntidads;
	}

	public EntidadDTO addAteEntidad(EntidadDTO ateEntidad) {
		getAteEntidads().add(ateEntidad);
		ateEntidad.setAteContacto(this);

		return ateEntidad;
	}

	public EntidadDTO removeAteEntidad(EntidadDTO ateEntidad) {
		getAteEntidads().remove(ateEntidad);
		ateEntidad.setAteContacto(null);

		return ateEntidad;
	}

}