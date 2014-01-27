package ec.edu.uce.silsag.ejb.persistence.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the bem_experiencia database table.
 * 
 */
@Entity
@Table(name="bem_experiencia")
@NamedQuery(name="ExperienciaDTO.findAll", query="SELECT e FROM ExperienciaDTO e")
public class ExperienciaDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="BEM_EXPERIENCIA_EXPCODIGO_GENERATOR", sequenceName="BEM_EXPERIENCIA_EXP_CODIGO_SEQ",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="BEM_EXPERIENCIA_EXPCODIGO_GENERATOR")
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

	@Column(name="exp_archivo")
	private byte[] expArchivo;

	
	//bi-directional many-to-one association to CandidatoDTO
	@ManyToOne
	@JoinColumn(name="exp_candidato")
	private CandidatoDTO bemCandidato;

	public ExperienciaDTO() {
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

	public Integer getExpTipoEmpresa() {
		return expTipoEmpresa;
	}

	public void setExpTipoEmpresa(Integer expTipoEmpresa) {
		this.expTipoEmpresa = expTipoEmpresa;
	}

	public void setExpTareas(String expTareas) {
		this.expTareas = expTareas;
	}

	public byte[] getExpArchivo() {
		return expArchivo;
	}

	public void setExpArchivo(byte[] expArchivo) {
		this.expArchivo = expArchivo;
	}

	public CandidatoDTO getBemCandidato() {
		return this.bemCandidato;
	}

	public void setBemCandidato(CandidatoDTO bemCandidato) {
		this.bemCandidato = bemCandidato;
	}

}