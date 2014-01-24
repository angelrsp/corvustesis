package ec.edu.uce.indicadores.ejb.persistence.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the vie_contacto database table.
 * 
 */
@Entity
@Table(name="vie_contacto")
@NamedQuery(name="ContactoListDTO.findAll", query="SELECT c FROM ContactoListDTO c")
public class ContactoListDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="cat_tipo_contacto")
	private String catTipoContacto;

	@Id
	@Column(name="con_codigo")
	private Integer conCodigo;

	@Column(name="con_representante_legal")
	private Integer conRepresentanteLegal;

	@Column(name="con_tipo")
	private Integer conTipo;

	@Column(name="con_valor")
	private String conValor;

	public ContactoListDTO() {
	}

	public String getCatTipoContacto() {
		return this.catTipoContacto;
	}

	public void setCatTipoContacto(String catTipoContacto) {
		this.catTipoContacto = catTipoContacto;
	}

	public Integer getConCodigo() {
		return this.conCodigo;
	}

	public void setConCodigo(Integer conCodigo) {
		this.conCodigo = conCodigo;
	}

	public Integer getConRepresentanteLegal() {
		return this.conRepresentanteLegal;
	}

	public void setConRepresentanteLegal(Integer conRepresentanteLegal) {
		this.conRepresentanteLegal = conRepresentanteLegal;
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

}