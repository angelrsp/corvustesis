package ec.edu.uce.indicadores.ejb.persistence.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ind_contacto database table.
 * 
 */
@Entity
@Table(name="ind_contacto")
public class ContactoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="IND_CONTACTO_CONCODIGO_GENERATOR", sequenceName="IND_CONTACTO_CON_CODIGO_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="IND_CONTACTO_CONCODIGO_GENERATOR")
	@Column(name="con_codigo")
	private Integer conCodigo;

	@Column(name="con_nombre")
	private String conNombre;

	@Column(name="con_valor")
	private String conValor;

	//bi-directional many-to-one association to RepresentanteLegal
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

	public String getConNombre() {
		return this.conNombre;
	}

	public void setConNombre(String conNombre) {
		this.conNombre = conNombre;
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