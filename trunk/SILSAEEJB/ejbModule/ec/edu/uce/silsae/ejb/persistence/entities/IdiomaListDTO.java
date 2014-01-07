package ec.edu.uce.silsae.ejb.persistence.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the vie_idioma database table.
 * 
 */
@Entity
@Table(name="vie_idioma")
@NamedQuery(name="IdiomaListDTO.findAll", query="SELECT i FROM IdiomaListDTO i")
public class IdiomaListDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="cat_nivel")
	private String catNivel;

	@Column(name="idi_candidato")
	private Integer idiCandidato;

	@Id
	@Column(name="idi_codigo")
	private Integer idiCodigo;

	@Column(name="idi_idioma")
	private String idiIdioma;

	@Column(name="idi_nivel")
	private Integer idiNivel;

	public IdiomaListDTO() {
	}

	public String getCatNivel() {
		return this.catNivel;
	}

	public void setCatNivel(String catNivel) {
		this.catNivel = catNivel;
	}

	public Integer getIdiCandidato() {
		return this.idiCandidato;
	}

	public void setIdiCandidato(Integer idiCandidato) {
		this.idiCandidato = idiCandidato;
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

}