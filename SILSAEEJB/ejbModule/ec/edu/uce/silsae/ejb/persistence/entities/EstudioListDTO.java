package ec.edu.uce.silsae.ejb.persistence.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import ec.edu.uce.silsae.commons.util.CalendarUtil;


/**
 * The persistent class for the vie_estudio database table.
 * 
 */
@Entity
@Table(name="vie_estudio")
@NamedQuery(name="EstudioListDTO.findAll", query="SELECT e FROM EstudioListDTO e")
public class EstudioListDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="cat_nivel")
	private String catNivel;

	@Column(name="cat_pais")
	private String catPais;

	@Column(name="est_anio_fin")
	private Integer estAnioFin;

	@Column(name="est_anio_inicio")
	private Integer estAnioInicio;

	@Column(name="est_candidato")
	private Integer estCandidato;

	@Column(name="est_carrera")
	private String estCarrera;

	@Id
	@Column(name="est_codigo")
	private Integer estCodigo;

	@Column(name="est_establecimiento")
	private String estEstablecimiento;

	@Column(name="est_mes_fin")
	private Integer estMesFin;

	@Column(name="est_mes_inicio")
	private Integer estMesInicio;

	@Column(name="est_nivel")
	private Integer estNivel;

	@Column(name="est_pais")
	private Integer estPais;

	public EstudioListDTO() {
	}

	public String getCatNivel() {
		return this.catNivel;
	}

	public void setCatNivel(String catNivel) {
		this.catNivel = catNivel;
	}

	public String getCatPais() {
		return this.catPais;
	}

	public void setCatPais(String catPais) {
		this.catPais = catPais;
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

	public Integer getEstCandidato() {
		return this.estCandidato;
	}

	public void setEstCandidato(Integer estCandidato) {
		this.estCandidato = estCandidato;
	}

	public String getEstCarrera() {
		return this.estCarrera;
	}

	public void setEstCarrera(String estCarrera) {
		this.estCarrera = estCarrera;
	}

	public Integer getEstCodigo() {
		return this.estCodigo;
	}

	public void setEstCodigo(Integer estCodigo) {
		this.estCodigo = estCodigo;
	}

	public String getEstEstablecimiento() {
		return this.estEstablecimiento;
	}

	public void setEstEstablecimiento(String estEstablecimiento) {
		this.estEstablecimiento = estEstablecimiento;
	}

	public Integer getEstMesFin() {
		return this.estMesFin;
	}
	
	public String getEstMesFinNombre() {
		return CalendarUtil.getMonthName(this.estMesFin);
	}

	public void setEstMesFin(Integer estMesFin) {
		this.estMesFin = estMesFin;
	}

	public Integer getEstMesInicio() {
		return this.estMesInicio;
	}

	public String getEstMesInicioNombre() {
		return CalendarUtil.getMonthName(this.estMesInicio);
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

}