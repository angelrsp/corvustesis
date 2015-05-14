package ec.edu.uce.besg.ejb.persistence.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the bem_habilidad database table.
 * 
 */
@Entity
@Table(name="bem_habilidad")
@NamedQuery(name="HabilidadDTO.findAll", query="SELECT h FROM HabilidadDTO h")
public class HabilidadDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="BEM_HABILIDAD_HABCODIGO_GENERATOR", sequenceName="BEM_HABILIDAD_HAB_CODIGO_SEQ",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="BEM_HABILIDAD_HABCODIGO_GENERATOR")
	@Column(name="hab_codigo")
	private Integer habCodigo;

	@Column(name="hab_descripcion")
	private String habDescripcion;
	
	@Column(name="hab_nivel")
	private Integer habNivel;
	
	@Column(name="hab_especialidad")
	private Integer habEspecialidad;
	
	@Column(name="hab_carrera")
	private String habCarrera;
	
	@Column(name="hab_pais")
	private Integer habPais;
	
	@Column(name="hab_registro")
	private String habRegistro;

	@Column(name="hab_entidad")
	private String habEntidad;

	@Column(name="hab_fecha_fin")
	@Temporal(TemporalType.DATE)
	private Date habFechaFin;

	@Column(name="hab_fecha_inicio")
	@Temporal(TemporalType.DATE)
	private Date habFechaInicio;

	@Column(name="hab_idioma")
	private Integer habIdioma;
	
	//bi-directional many-to-one association to CandidatoDTO
	@ManyToOne
	@JoinColumn(name="hab_candidato")
	private CandidatoDTO bemCandidato;

	//bi-directional many-to-one association to TipoHabilidadDTO
	@ManyToOne
	@JoinColumn(name="hab_tipo")
	private TipoHabilidadDTO bemTipoHabilidad;

	public HabilidadDTO() {
	}

	public Integer getHabCodigo() {
		return this.habCodigo;
	}

	public void setHabCodigo(Integer habCodigo) {
		this.habCodigo = habCodigo;
	}

	public String getHabDescripcion() {
		return this.habDescripcion;
	}

	public void setHabDescripcion(String habDescripcion) {
		this.habDescripcion = habDescripcion;
	}

	public String getHabEntidad() {
		return this.habEntidad;
	}

	public void setHabEntidad(String habEntidad) {
		this.habEntidad = habEntidad;
	}

	public Date getHabFechaFin() {
		return this.habFechaFin;
	}

	public void setHabFechaFin(Date habFechaFin) {
		this.habFechaFin = habFechaFin;
	}

	public Date getHabFechaInicio() {
		return this.habFechaInicio;
	}

	public void setHabFechaInicio(Date habFechaInicio) {
		this.habFechaInicio = habFechaInicio;
	}

	public CandidatoDTO getBemCandidato() {
		return this.bemCandidato;
	}

	public void setBemCandidato(CandidatoDTO bemCandidato) {
		this.bemCandidato = bemCandidato;
	}

	public TipoHabilidadDTO getBemTipoHabilidad() {
		return this.bemTipoHabilidad;
	}

	public void setBemTipoHabilidad(TipoHabilidadDTO bemTipoHabilidad) {
		this.bemTipoHabilidad = bemTipoHabilidad;
	}

	public Integer getHabNivel() {
		return habNivel;
	}

	public void setHabNivel(Integer habNivel) {
		this.habNivel = habNivel;
	}

	public Integer getHabEspecialidad() {
		return habEspecialidad;
	}

	public void setHabEspecialidad(Integer habEspecialidad) {
		this.habEspecialidad = habEspecialidad;
	}

	public String getHabCarrera() {
		return habCarrera;
	}

	public void setHabCarrera(String habCarrera) {
		this.habCarrera = habCarrera;
	}

	public Integer getHabPais() {
		return habPais;
	}

	public void setHabPais(Integer habPais) {
		this.habPais = habPais;
	}

	public String getHabRegistro() {
		return habRegistro;
	}

	public void setHabRegistro(String habRegistro) {
		this.habRegistro = habRegistro;
	}

	public Integer getHabIdioma() {
		return habIdioma;
	}

	public void setHabIdioma(Integer habIdioma) {
		this.habIdioma = habIdioma;
	}

}