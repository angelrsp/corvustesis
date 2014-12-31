package ec.edu.uce.besg.ejb.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


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
	private Timestamp habFechaFin;

	@Column(name="hab_fecha_inicio")
	private Timestamp habFechaInicio;

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

	public Timestamp getHabFechaFin() {
		return this.habFechaFin;
	}

	public void setHabFechaFin(Timestamp habFechaFin) {
		this.habFechaFin = habFechaFin;
	}

	public Timestamp getHabFechaInicio() {
		return this.habFechaInicio;
	}

	public void setHabFechaInicio(Timestamp habFechaInicio) {
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

}