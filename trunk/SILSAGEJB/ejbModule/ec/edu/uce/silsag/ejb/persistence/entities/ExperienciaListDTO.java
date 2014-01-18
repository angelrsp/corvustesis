package ec.edu.uce.silsag.ejb.persistence.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the vie_experiencia database table.
 * 
 */
@Entity
@Table(name="vie_experiencia")
@NamedQuery(name="ExperienciaListDTO.findAll", query="SELECT e FROM ExperienciaListDTO e")
public class ExperienciaListDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="cat_tipo_empresa")
	private String catTipoEmpresa;

	@Column(name="exp_candidato")
	private Integer expCandidato;

	@Id
	@Column(name="exp_codigo")
	private Integer expCodigo;

	@Column(name="exp_entidad")
	private String expEntidad;

	@Column(name="exp_fecha_fin")
	private Timestamp expFechaFin;

	@Column(name="exp_fecha_inicio")
	private Timestamp expFechaInicio;

	@Column(name="exp_puesto")
	private String expPuesto;

	@Column(name="exp_tareas")
	private String expTareas;

	@Column(name="exp_tipo_empresa")
	private Integer expTipoEmpresa;

	public ExperienciaListDTO() {
	}

	public String getCatTipoEmpresa() {
		return this.catTipoEmpresa;
	}

	public void setCatTipoEmpresa(String catTipoEmpresa) {
		this.catTipoEmpresa = catTipoEmpresa;
	}

	public Integer getExpCandidato() {
		return this.expCandidato;
	}

	public void setExpCandidato(Integer expCandidato) {
		this.expCandidato = expCandidato;
	}

	public Integer getExpCodigo() {
		return this.expCodigo;
	}

	public void setExpCodigo(Integer expCodigo) {
		this.expCodigo = expCodigo;
	}

	public String getExpEntidad() {
		return this.expEntidad;
	}

	public void setExpEntidad(String expEntidad) {
		this.expEntidad = expEntidad;
	}

	public Timestamp getExpFechaFin() {
		return this.expFechaFin;
	}

	public void setExpFechaFin(Timestamp expFechaFin) {
		this.expFechaFin = expFechaFin;
	}

	public Timestamp getExpFechaInicio() {
		return this.expFechaInicio;
	}

	public void setExpFechaInicio(Timestamp expFechaInicio) {
		this.expFechaInicio = expFechaInicio;
	}

	public String getExpPuesto() {
		return this.expPuesto;
	}

	public void setExpPuesto(String expPuesto) {
		this.expPuesto = expPuesto;
	}

	public String getExpTareas() {
		return this.expTareas;
	}

	public void setExpTareas(String expTareas) {
		this.expTareas = expTareas;
	}

	public Integer getExpTipoEmpresa() {
		return this.expTipoEmpresa;
	}

	public void setExpTipoEmpresa(Integer expTipoEmpresa) {
		this.expTipoEmpresa = expTipoEmpresa;
	}

}