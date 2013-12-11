package ec.edu.uce.silsae.ejb.persistence.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the vie_software database table.
 * 
 */
@Entity
@Table(name="vie_software")
@NamedQuery(name="SoftwareListDTO.findAll", query="SELECT s FROM SoftwareListDTO s")
public class SoftwareListDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="cat_nivel")
	private String catNivel;

	@Column(name="cat_programa")
	private String catPrograma;

	@Column(name="pro_candidato")
	private Integer proCandidato;

	@Id
	@Column(name="pro_codigo")
	private Integer proCodigo;

	@Column(name="pro_nivel")
	private Integer proNivel;

	@Column(name="pro_programa")
	private Integer proPrograma;

	public SoftwareListDTO() {
	}

	public String getCatNivel() {
		return this.catNivel;
	}

	public void setCatNivel(String catNivel) {
		this.catNivel = catNivel;
	}

	public String getCatPrograma() {
		return this.catPrograma;
	}

	public void setCatPrograma(String catPrograma) {
		this.catPrograma = catPrograma;
	}

	public Integer getProCandidato() {
		return this.proCandidato;
	}

	public void setProCandidato(Integer proCandidato) {
		this.proCandidato = proCandidato;
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

	public Integer getProPrograma() {
		return this.proPrograma;
	}

	public void setProPrograma(Integer proPrograma) {
		this.proPrograma = proPrograma;
	}

}