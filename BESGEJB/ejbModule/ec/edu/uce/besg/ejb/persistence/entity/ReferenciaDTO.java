package ec.edu.uce.besg.ejb.persistence.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the bem_referencia database table.
 * 
 */
@Entity
@Table(name="bem_referencia")
@NamedQuery(name="ReferenciaDTO.findAll", query="SELECT r FROM ReferenciaDTO r")
public class ReferenciaDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="BEM_REFERENCIA_REFCODIGO_GENERATOR", sequenceName="BEM_REFERENCIA_REF_CODIGO_SEQ",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="BEM_REFERENCIA_REFCODIGO_GENERATOR")
	@Column(name="ref_codigo")
	private Integer refCodigo;

	@Column(name="ref_mail")
	private String refMail;

	@Column(name="ref_nombre")
	private String refNombre;

	@Column(name="ref_telefono")
	private String refTelefono;

	@Column(name="ref_tipo_empresa")
	private Integer refTipoEmpresa;

	//bi-directional many-to-one association to CandidatoDTO
	@ManyToOne
	@JoinColumn(name="ref_candidato")
	private CandidatoDTO bemCandidato;

	public ReferenciaDTO() {
	}

	public Integer getRefCodigo() {
		return this.refCodigo;
	}

	public void setRefCodigo(Integer refCodigo) {
		this.refCodigo = refCodigo;
	}

	public String getRefMail() {
		return this.refMail;
	}

	public void setRefMail(String refMail) {
		this.refMail = refMail;
	}

	public String getRefNombre() {
		return this.refNombre;
	}

	public void setRefNombre(String refNombre) {
		this.refNombre = refNombre;
	}

	public String getRefTelefono() {
		return this.refTelefono;
	}

	public void setRefTelefono(String refTelefono) {
		this.refTelefono = refTelefono;
	}

	public Integer getRefTipoEmpresa() {
		return this.refTipoEmpresa;
	}

	public void setRefTipoEmpresa(Integer refTipoEmpresa) {
		this.refTipoEmpresa = refTipoEmpresa;
	}

	public CandidatoDTO getBemCandidato() {
		return this.bemCandidato;
	}

	public void setBemCandidato(CandidatoDTO bemCandidato) {
		this.bemCandidato = bemCandidato;
	}

}