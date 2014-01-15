package ec.edu.uce.silsag.ejb.persistence.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the bem_referencia database table.
 * 
 */
@Entity
@Table(name="bem_referencia")
public class ReferenciaDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="BEM_REFERENCIA_REFCODIGO_GENERATOR", sequenceName="BEM_REFERENCIA_REF_CODIGO_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="BEM_REFERENCIA_REFCODIGO_GENERATOR")
	@Column(name="ref_codigo")
	private Integer refCodigo;

	@Column(name="ref_mail")
	private String refMail;

	@Column(name="ref_nombre")
	private String refNombre;

	@Column(name="ref_telefono")
	private String refTelefono;

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

	public CandidatoDTO getBemCandidato() {
		return this.bemCandidato;
	}

	public void setBemCandidato(CandidatoDTO bemCandidato) {
		this.bemCandidato = bemCandidato;
	}
	
}