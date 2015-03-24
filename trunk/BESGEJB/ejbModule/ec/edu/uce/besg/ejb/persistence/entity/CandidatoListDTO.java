package ec.edu.uce.besg.ejb.persistence.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the view_bem_candidato database table.
 * 
 */
@Entity
@Table(name="view_bem_candidato")
@NamedQuery(name="CandidatoListDTO.findAll", query="SELECT c FROM CandidatoListDTO c")
public class CandidatoListDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="can_apellidos")
	private String canApellidos;

	@Id
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

	@Column(name="estado_civil")
	private String estadoCivil;

	@Column(name="hab_candidato")
	private Integer habCandidato;

	@Column(name="hab_codigo")
	private Integer habCodigo;

	@Column(name="hab_descripcion")
	private String habDescripcion;

	@Column(name="hab_entidad")
	private String habEntidad;

	@Column(name="hab_fecha_fin")
	private Timestamp habFechaFin;

	@Column(name="hab_fecha_inicio")
	private Timestamp habFechaInicio;

	@Column(name="hab_tipo")
	private Integer habTipo;

	private String sexo;

	@Column(name="tipo_identificacion")
	private String tipoIdentificacion;

	@Column(name="usu_celular")
	private String usuCelular;

	@Column(name="usu_codigo")
	private Integer usuCodigo;

	@Column(name="usu_direccion")
	private String usuDireccion;

	@Column(name="usu_estado")
	private Boolean usuEstado;

	@Column(name="usu_login")
	private String usuLogin;

	@Column(name="usu_mail")
	private String usuMail;

	@Column(name="usu_password")
	private String usuPassword;

	@Column(name="usu_telefono")
	private String usuTelefono;

	public CandidatoListDTO() {
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

	public String getEstadoCivil() {
		return this.estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public Integer getHabCandidato() {
		return this.habCandidato;
	}

	public void setHabCandidato(Integer habCandidato) {
		this.habCandidato = habCandidato;
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

	public Integer getHabTipo() {
		return this.habTipo;
	}

	public void setHabTipo(Integer habTipo) {
		this.habTipo = habTipo;
	}

	public String getSexo() {
		return this.sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getTipoIdentificacion() {
		return this.tipoIdentificacion;
	}

	public void setTipoIdentificacion(String tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
	}

	public String getUsuCelular() {
		return this.usuCelular;
	}

	public void setUsuCelular(String usuCelular) {
		this.usuCelular = usuCelular;
	}

	public Integer getUsuCodigo() {
		return this.usuCodigo;
	}

	public void setUsuCodigo(Integer usuCodigo) {
		this.usuCodigo = usuCodigo;
	}

	public String getUsuDireccion() {
		return this.usuDireccion;
	}

	public void setUsuDireccion(String usuDireccion) {
		this.usuDireccion = usuDireccion;
	}

	public Boolean getUsuEstado() {
		return this.usuEstado;
	}

	public void setUsuEstado(Boolean usuEstado) {
		this.usuEstado = usuEstado;
	}

	public String getUsuLogin() {
		return this.usuLogin;
	}

	public void setUsuLogin(String usuLogin) {
		this.usuLogin = usuLogin;
	}

	public String getUsuMail() {
		return this.usuMail;
	}

	public void setUsuMail(String usuMail) {
		this.usuMail = usuMail;
	}

	public String getUsuPassword() {
		return this.usuPassword;
	}

	public void setUsuPassword(String usuPassword) {
		this.usuPassword = usuPassword;
	}

	public String getUsuTelefono() {
		return this.usuTelefono;
	}

	public void setUsuTelefono(String usuTelefono) {
		this.usuTelefono = usuTelefono;
	}

}