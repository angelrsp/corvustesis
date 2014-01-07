package ec.edu.uce.silsae.ejb.persistence.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the bem_idioma database table.
 * 
 */
@Entity
@Table(name="bem_idioma")
public class IdiomaDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="BEM_IDIOMA_IDICODIGO_GENERATOR", sequenceName="BEM_IDIOMA_IDI_CODIGO_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="BEM_IDIOMA_IDICODIGO_GENERATOR")
	@Column(name="idi_codigo")
	private Integer idiCodigo;

	@Column(name="idi_idioma")
	private String idiIdioma;

	@Column(name="idi_nivel")
	private Integer idiNivel;

	//bi-directional many-to-one association to CandidatoDTO
    @ManyToOne
	@JoinColumn(name="idi_candidato")
	private CandidatoDTO bemCandidato;

    public IdiomaDTO() {
    }

	public Integer getIdiCodigo() {
		return this.idiCodigo;
	}

	public void setIdiCodigo(Integer idiCodigo) {
		this.idiCodigo = idiCodigo;
	}

	public String getIdiIdioma() {
		return this.idiIdioma;
	}

	public void setIdiIdioma(String idiIdioma) {
		this.idiIdioma = idiIdioma;
	}

	public Integer getIdiNivel() {
		return this.idiNivel;
	}

	public void setIdiNivel(Integer idiNivel) {
		this.idiNivel = idiNivel;
	}

	public CandidatoDTO getBemCandidato() {
		return this.bemCandidato;
	}

	public void setBemCandidato(CandidatoDTO bemCandidato) {
		this.bemCandidato = bemCandidato;
	}
	
}