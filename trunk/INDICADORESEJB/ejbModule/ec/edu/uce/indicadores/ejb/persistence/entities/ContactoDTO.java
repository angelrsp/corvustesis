package ec.edu.uce.indicadores.ejb.persistence.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ind_contacto database table.
 * 
 */
@Entity
@Table(name="ind_contacto")
@NamedQuery(name="ContactoDTO.findAll", query="SELECT c FROM ContactoDTO c")
public class ContactoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="IND_CONTACTO_CONCODIGO_GENERATOR", sequenceName="IND_CONTACTO_CON_CODIGO_SEQ",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="IND_CONTACTO_CONCODIGO_GENERATOR")
	@Column(name="con_codigo")
	private Integer conCodigo;

	@Column(name="con_tipo")
	private Integer conTipo;

	@Column(name="con_valor")
	private String conValor;

	//bi-directional many-to-one association to RepresentanteLegalDTO
	@ManyToOne
	@JoinColumn(name="con_representante_legal")
	private RepresentanteLegalDTO indRepresentanteLegal;

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

	public RepresentanteLegalDTO getIndRepresentanteLegal() {
		return this.indRepresentanteLegal;
	}

	public void setIndRepresentanteLegal(RepresentanteLegalDTO indRepresentanteLegal) {
		this.indRepresentanteLegal = indRepresentanteLegal;
	}

}