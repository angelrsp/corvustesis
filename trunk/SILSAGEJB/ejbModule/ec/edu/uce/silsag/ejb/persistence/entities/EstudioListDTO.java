package ec.edu.uce.silsag.ejb.persistence.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the vie_estudio database table.
 * 
 */
@Entity
@Table(name="vie_estudio")
@NamedQuery(name="EstudioListDTO.findAll", query="SELECT e FROM EstudioListDTO e")
public class EstudioListDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="cat_especialidad")
	private String catEspecialidad;

	@Column(name="cat_nivel")
	private String catNivel;

	@Column(name="cat_pais")
	private String catPais;

	@Column(name="est_candidato")
	private Integer estCandidato;

	@Column(name="est_carrera")
	private String estCarrera;

	@Id
	@Column(name="est_codigo")
	private Integer estCodigo;

	@Column(name="est_especialidad")
	private Integer estEspecialidad;

	@Column(name="est_especialidad_otro")
	private String estEspecialidadOtro;

	@Column(name="est_establecimiento")
	private String estEstablecimiento;

	@Column(name="est_fecha_fin")
	private Timestamp estFechaFin;

	@Column(name="est_fecha_inicio")
	private Timestamp estFechaInicio;

	@Column(name="est_nivel")
	private Integer estNivel;

	@Column(name="est_pais")
	private Integer estPais;

	public EstudioListDTO() {
	}

	public String getCatEspecialidad() {
		return this.catEspecialidad;
	}

	public void setCatEspecialidad(String catEspecialidad) {
		this.catEspecialidad = catEspecialidad;
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

	public Integer getEstEspecialidad() {
		return this.estEspecialidad;
	}

	public void setEstEspecialidad(Integer estEspecialidad) {
		this.estEspecialidad = estEspecialidad;
	}

	public String getEstEspecialidadOtro() {
		return this.estEspecialidadOtro;
	}

	public void setEstEspecialidadOtro(String estEspecialidadOtro) {
		this.estEspecialidadOtro = estEspecialidadOtro;
	}

	public String getEstEstablecimiento() {
		return this.estEstablecimiento;
	}

	public void setEstEstablecimiento(String estEstablecimiento) {
		this.estEstablecimiento = estEstablecimiento;
	}

	public Timestamp getEstFechaFin() {
		return this.estFechaFin;
	}

	public void setEstFechaFin(Timestamp estFechaFin) {
		this.estFechaFin = estFechaFin;
	}

	public Timestamp getEstFechaInicio() {
		return this.estFechaInicio;
	}

	public void setEstFechaInicio(Timestamp estFechaInicio) {
		this.estFechaInicio = estFechaInicio;
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