package ec.edu.uce.besg.ejb.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the view_bem_habilidad database table.
 * 
 */
@Entity
@Table(name="view_bem_habilidad")
@NamedQuery(name="HabilidadListDTO.findAll", query="SELECT h FROM HabilidadListDTO h")
public class HabilidadListDTO implements Serializable {
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

	private String especialidad;

	@Column(name="hab_candidato")
	private Integer habCandidato;

	@Column(name="hab_carrera")
	private String habCarrera;

	@Id
	@Column(name="hab_codigo")
	private Integer habCodigo;

	@Column(name="hab_descripcion")
	private String habDescripcion;

	@Column(name="hab_entidad")
	private String habEntidad;

	@Column(name="hab_especialidad")
	private Integer habEspecialidad;

	@Column(name="hab_fecha_fin")
	private Timestamp habFechaFin;

	@Column(name="hab_fecha_inicio")
	private Timestamp habFechaInicio;

	@Column(name="hab_nivel")
	private Integer habNivel;

	@Column(name="hab_pais")
	private Integer habPais;

	@Column(name="hab_registro")
	private String habRegistro;

	@Column(name="hab_tipo")
	private Integer habTipo;

	private String nivel;

	private String pais;

	@Column(name="tha_codigo")
	private Integer thaCodigo;

	@Column(name="tha_descripcion")
	private String thaDescripcion;

	public HabilidadListDTO() {
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

	public String getEspecialidad() {
		return this.especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public Integer getHabCandidato() {
		return this.habCandidato;
	}

	public void setHabCandidato(Integer habCandidato) {
		this.habCandidato = habCandidato;
	}

	public String getHabCarrera() {
		return this.habCarrera;
	}

	public void setHabCarrera(String habCarrera) {
		this.habCarrera = habCarrera;
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

	public Integer getHabEspecialidad() {
		return this.habEspecialidad;
	}

	public void setHabEspecialidad(Integer habEspecialidad) {
		this.habEspecialidad = habEspecialidad;
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

	public Integer getHabNivel() {
		return this.habNivel;
	}

	public void setHabNivel(Integer habNivel) {
		this.habNivel = habNivel;
	}

	public Integer getHabPais() {
		return this.habPais;
	}

	public void setHabPais(Integer habPais) {
		this.habPais = habPais;
	}

	public String getHabRegistro() {
		return this.habRegistro;
	}

	public void setHabRegistro(String habRegistro) {
		this.habRegistro = habRegistro;
	}

	public Integer getHabTipo() {
		return this.habTipo;
	}

	public void setHabTipo(Integer habTipo) {
		this.habTipo = habTipo;
	}

	public String getNivel() {
		return this.nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	public String getPais() {
		return this.pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public Integer getThaCodigo() {
		return this.thaCodigo;
	}

	public void setThaCodigo(Integer thaCodigo) {
		this.thaCodigo = thaCodigo;
	}

	public String getThaDescripcion() {
		return this.thaDescripcion;
	}

	public void setThaDescripcion(String thaDescripcion) {
		this.thaDescripcion = thaDescripcion;
	}

}