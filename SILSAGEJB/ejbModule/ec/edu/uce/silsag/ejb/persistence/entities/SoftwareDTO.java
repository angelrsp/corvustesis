package ec.edu.uce.silsag.ejb.persistence.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the bem_software database table.
 * 
 */
@Entity
@Table(name="bem_software")
public class SoftwareDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="BEM_SOFTWARE_PROCODIGO_GENERATOR", sequenceName="BEM_SOFTWARE_PRO_CODIGO_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="BEM_SOFTWARE_PROCODIGO_GENERATOR")
	@Column(name="pro_codigo")
	private Integer proCodigo;

	@Column(name="pro_nivel")
	private Integer proNivel;

	@Column(name="pro_programa")
	private String proPrograma;

	//bi-directional many-to-one association to CandidatoDTO
    @ManyToOne
	@JoinColumn(name="pro_candidato")
	private CandidatoDTO bemCandidato;

    public SoftwareDTO() {
    }

	public Integer getProCodigo() {
		return this.proCodigo;
	}

	public void setProCodigo(Integer proCodigo) {
		this.proCodigo = proCodigo;
	}

	public Integer getProNivel() {
		return this.proNivel;
	}

	public void setProNivel(Integer proNivel) {
		this.proNivel = proNivel;
	}

	public String getProPrograma() {
		return this.proPrograma;
	}

	public void setProPrograma(String proPrograma) {
		this.proPrograma = proPrograma;
	}

	public CandidatoDTO getBemCandidato() {
		return this.bemCandidato;
	}

	public void setBemCandidato(CandidatoDTO bemCandidato) {
		this.bemCandidato = bemCandidato;
	}
	
}