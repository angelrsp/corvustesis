package ec.edu.uce.besg.ejb.persistence.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the view_bem_experiencia database table.
 * 
 */
@Entity
@Table(name="view_bem_experiencia")
@NamedQuery(name="ExperienciaListDTO.findAll", query="SELECT e FROM ExperienciaListDTO e")
public class ExperienciaListDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="can_apellidos")
	private String canApellidos;

	@Column(name="can_codigo")
	private Integer canCodigo;

	@Column(name="can_estado_civil")
	private Integer canEstadoCivil;

	@Column(name="can_estado_estudio")
	private Integer canEstadoEstudio;

	@Column(name="can_fecha_nacimiento")
	private Timestamp canFechaNacimiento;

	@Column(name="can_identificacion")
	private String canIdentificacion;

	@Column(name="can_lugar_nacimiento")
	private String canLugarNacimiento;

	@Column(name="can_max_estudio")
	private Integer canMaxEstudio;

	@Column(name="can_nombres")
	private String canNombres;

	@Column(name="can_sexo")
	private Integer canSexo;

	@Column(name="can_tipo_identificacion")
	private Integer canTipoIdentificacion;

	@Column(name="can_usuario")
	private Integer canUsuario;

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

	public ExperienciaListDTO() {
	}

	public String getCanApellidos() {
		return this.canApellidos;
	}

	public void setCanApellidos(String canApellidos) {
		this.canApellidos = canApellidos;
	}

	public Integer getCanCodigo() {
		return this.canCodigo;
	}

	public void setCanCodigo(Integer canCodigo) {
		this.canCodigo = canCodigo;
	}

	public Integer getCanEstadoCivil() {
		return this.canEstadoCivil;
	}

	public void setCanEstadoCivil(Integer canEstadoCivil) {
		this.canEstadoCivil = canEstadoCivil;
	}

	public Integer getCanEstadoEstudio() {
		return this.canEstadoEstudio;
	}

	public void setCanEstadoEstudio(Integer canEstadoEstudio) {
		this.canEstadoEstudio = canEstadoEstudio;
	}

	public Timestamp getCanFechaNacimiento() {
		return this.canFechaNacimiento;
	}

	public void setCanFechaNacimiento(Timestamp canFechaNacimiento) {
		this.canFechaNacimiento = canFechaNacimiento;
	}

	public String getCanIdentificacion() {
		return this.canIdentificacion;
	}

	public void setCanIdentificacion(String canIdentificacion) {
		this.canIdentificacion = canIdentificacion;
	}

	public String getCanLugarNacimiento() {
		return this.canLugarNacimiento;
	}

	public void setCanLugarNacimiento(String canLugarNacimiento) {
		this.canLugarNacimiento = canLugarNacimiento;
	}

	public Integer getCanMaxEstudio() {
		return this.canMaxEstudio;
	}

	public void setCanMaxEstudio(Integer canMaxEstudio) {
		this.canMaxEstudio = canMaxEstudio;
	}

	public String getCanNombres() {
		return this.canNombres;
	}

	public void setCanNombres(String canNombres) {
		this.canNombres = canNombres;
	}

	public Integer getCanSexo() {
		return this.canSexo;
	}

	public void setCanSexo(Integer canSexo) {
		this.canSexo = canSexo;
	}

	public Integer getCanTipoIdentificacion() {
		return this.canTipoIdentificacion;
	}

	public void setCanTipoIdentificacion(Integer canTipoIdentificacion) {
		this.canTipoIdentificacion = canTipoIdentificacion;
	}

	public Integer getCanUsuario() {
		return this.canUsuario;
	}

	public void setCanUsuario(Integer canUsuario) {
		this.canUsuario = canUsuario;
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

}