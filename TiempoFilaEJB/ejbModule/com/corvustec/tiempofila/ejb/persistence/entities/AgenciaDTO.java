package com.corvustec.tiempofila.ejb.persistence.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tfi_agencia database table.
 * 
 */
@Entity
@Table(name="tfi_agencia")
@NamedQuery(name="AgenciaDTO.findAll", query="SELECT a FROM AgenciaDTO a")
public class AgenciaDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TFI_AGENCIA_AGECODIGO_GENERATOR", sequenceName="TFI_AGENCIA_AGE_CODIGO_SEQ",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TFI_AGENCIA_AGECODIGO_GENERATOR")
	@Column(name="age_codigo")
	private Integer ageCodigo;

	@Column(name="age_descripcion")
	private String ageDescripcion;

	@Column(name="age_ubiccion")
	private Integer ageUbiccion;

	//bi-directional many-to-one association to AsesorDTO
	@OneToMany(mappedBy="tfiAgencia")
	private List<AsesorDTO> tfiAsesors;

	public AgenciaDTO() {
	}

	public Integer getAgeCodigo() {
		return this.ageCodigo;
	}

	public void setAgeCodigo(Integer ageCodigo) {
		this.ageCodigo = ageCodigo;
	}

	public String getAgeDescripcion() {
		return this.ageDescripcion;
	}

	public void setAgeDescripcion(String ageDescripcion) {
		this.ageDescripcion = ageDescripcion;
	}

	public Integer getAgeUbiccion() {
		return this.ageUbiccion;
	}

	public void setAgeUbiccion(Integer ageUbiccion) {
		this.ageUbiccion = ageUbiccion;
	}

	public List<AsesorDTO> getTfiAsesors() {
		return this.tfiAsesors;
	}

	public void setTfiAsesors(List<AsesorDTO> tfiAsesors) {
		this.tfiAsesors = tfiAsesors;
	}

	public AsesorDTO addTfiAsesor(AsesorDTO tfiAsesor) {
		getTfiAsesors().add(tfiAsesor);
		tfiAsesor.setTfiAgencia(this);

		return tfiAsesor;
	}

	public AsesorDTO removeTfiAsesor(AsesorDTO tfiAsesor) {
		getTfiAsesors().remove(tfiAsesor);
		tfiAsesor.setTfiAgencia(null);

		return tfiAsesor;
	}

}