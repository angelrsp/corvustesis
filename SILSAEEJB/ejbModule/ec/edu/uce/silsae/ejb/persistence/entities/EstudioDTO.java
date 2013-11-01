package ec.edu.uce.silsae.ejb.persistence.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the bem_estudio database table.
 * 
 */
@Entity
@Table(name="bem_estudio")
public class EstudioDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="BEM_ESTUDIO_ESTCODIGO_GENERATOR", sequenceName="BEM_ESTUDIO_EST_CODIGO_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="BEM_ESTUDIO_ESTCODIGO_GENERATOR")
	@Column(name="est_codigo")
	private Integer estCodigo;

	@Column(name="est_anio_fin")
	private Integer estAnioFin;

	@Column(name="est_anio_inicio")
	private Integer estAnioInicio;

	@Column(name="est_carrera")
	private String estCarrera;

	@Column(name="est_establecimiento")
	private Integer estEstablecimiento;

	@Column(name="est_mes_fin")
	private Integer estMesFin;

	@Column(name="est_mes_inicio")
	private Integer estMesInicio;

	@Column(name="est_nivel")
	private Integer estNivel;

	@Column(name="est_pais")
	private Integer estPais;

	//bi-directional many-to-one association to CandidatoDTO
    @ManyToOne
	@JoinColumn(name="est_candidato")
	private CandidatoDTO bemCandidato;

    public EstudioDTO() {
    }

	public Integer getEstCodigo() {
		return this.estCodigo;
	}

	public void setEstCodigo(Integer estCodigo) {
		this.estCodigo = estCodigo;
	}

	public Integer getEstAnioFin() {
		return this.estAnioFin;
	}

	public void setEstAnioFin(Integer estAnioFin) {
		this.estAnioFin = estAnioFin;
	}

	public Integer getEstAnioInicio() {
		return this.estAnioInicio;
	}

	public void setEstAnioInicio(Integer estAnioInicio) {
		this.estAnioInicio = estAnioInicio;
	}

	public String getEstCarrera() {
		return this.estCarrera;
	}

	public void setEstCarrera(String estCarrera) {
		this.estCarrera = estCarrera;
	}

	public Integer getEstEstablecimiento() {
		return this.estEstablecimiento;
	}

	public void setEstEstablecimiento(Integer estEstablecimiento) {
		this.estEstablecimiento = estEstablecimiento;
	}

	public Integer getEstMesFin() {
		return this.estMesFin;
	}

	public void setEstMesFin(Integer estMesFin) {
		this.estMesFin = estMesFin;
	}

	public Integer getEstMesInicio() {
		return this.estMesInicio;
	}

	public void setEstMesInicio(Integer estMesInicio) {
		this.estMesInicio = estMesInicio;
	}

	public Integer getEstNivel() {
		return this.estNivel;
	}

	public void setEstNivel(Integer estNivel) {
		this.estNivel = estNivel;
	}

	public Integer getEstPais() {
		return this.estPais;
	}

	public void setEstPais(Integer estPais) {
		this.estPais = estPais;
	}

	public CandidatoDTO getBemCandidato() {
		return this.bemCandidato;
	}

	public void setBemCandidato(CandidatoDTO bemCandidato) {
		this.bemCandidato = bemCandidato;
	}
	
}