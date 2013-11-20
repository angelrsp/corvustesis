package ec.edu.uce.silsae.ejb.persistence.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.math.BigDecimal;


/**
 * The persistent class for the vie_experiencia database table.
 * 
 */
@Entity
@Table(name="vie_experiencia")
@NamedQuery(name="ExperienciaListDTO.findAll", query="SELECT e FROM ExperienciaListDTO e")
public class ExperienciaListDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="cat_tipo_experiencia")
	private String catTipoExperiencia;

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

	@Column(name="exp_rubro")
	private BigDecimal expRubro;

	@Column(name="exp_tareas")
	private String expTareas;

	@Column(name="exp_tipo_experiencia")
	private Integer expTipoExperiencia;

	public ExperienciaListDTO() {
	}

	public String getCatTipoExperiencia() {
		return this.catTipoExperiencia;
	}

	public void setCatTipoExperiencia(String catTipoExperiencia) {
		this.catTipoExperiencia = catTipoExperiencia;
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

	public BigDecimal getExpRubro() {
		return this.expRubro;
	}

	public void setExpRubro(BigDecimal expRubro) {
		this.expRubro = expRubro;
	}

	public String getExpTareas() {
		return this.expTareas;
	}

	public void setExpTareas(String expTareas) {
		this.expTareas = expTareas;
	}

	public Integer getExpTipoExperiencia() {
		return this.expTipoExperiencia;
	}

	public void setExpTipoExperiencia(Integer expTipoExperiencia) {
		this.expTipoExperiencia = expTipoExperiencia;
	}

}