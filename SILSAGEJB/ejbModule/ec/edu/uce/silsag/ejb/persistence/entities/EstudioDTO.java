package ec.edu.uce.silsag.ejb.persistence.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the bem_estudio database table.
 * 
 */
@Entity
@Table(name="bem_estudio")
@NamedQuery(name="EstudioDTO.findAll", query="SELECT e FROM EstudioDTO e")
public class EstudioDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="BEM_ESTUDIO_ESTCODIGO_GENERATOR", sequenceName="BEM_ESTUDIO_EST_CODIGO_SEQ",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="BEM_ESTUDIO_ESTCODIGO_GENERATOR")
	@Column(name="est_codigo")
	private Integer estCodigo;

	@Column(name="est_carrera")
	private String estCarrera;

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
	
	@Column(name="est_registro")
	private String estRegistro;
	
	@Column(name="est_archivo")
	private byte[] estArchivo;
	
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

	public String getEstCarrera() {
		return this.estCarrera;
	}

	public void setEstCarrera(String estCarrera) {
		this.estCarrera = estCarrera;
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

	public String getEstRegistro() {
		return estRegistro;
	}

	public void setEstRegistro(String estRegistro) {
		this.estRegistro = estRegistro;
	}

	public byte[] getEstArchivo() {
		return estArchivo;
	}

	public void setEstArchivo(byte[] estArchivo) {
		this.estArchivo = estArchivo;
	}

	public CandidatoDTO getBemCandidato() {
		return this.bemCandidato;
	}

	public void setBemCandidato(CandidatoDTO bemCandidato) {
		this.bemCandidato = bemCandidato;
	}

}