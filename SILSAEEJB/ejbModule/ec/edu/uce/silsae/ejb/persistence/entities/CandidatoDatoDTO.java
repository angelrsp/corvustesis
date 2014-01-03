package ec.edu.uce.silsae.ejb.persistence.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the vie_candidato_dato database table.
 * 
 */
@Entity
@Table(name="vie_candidato_dato")
@NamedQuery(name="CandidatoDatoDTO.findAll", query="SELECT c FROM CandidatoDatoDTO c")
public class CandidatoDatoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="can_apellido_materno")
	private String canApellidoMaterno;

	@Column(name="can_apellido_paterno")
	private String canApellidoPaterno;

	@Id
	@Column(name="can_codigo")
	private Integer canCodigo;

	@Column(name="can_estado_civil")
	private Integer canEstadoCivil;

	@Column(name="can_fecha_nacimiento")
	private Timestamp canFechaNacimiento;

	@Column(name="can_foto")
	private byte[] canFoto;

	@Column(name="can_identificacion")
	private String canIdentificacion;

	@Column(name="can_lugar_nacimiento")
	private String canLugarNacimiento;

	@Column(name="can_primer_nombre")
	private String canPrimerNombre;

	@Column(name="can_segundo_nombre")
	private String canSegundoNombre;

	@Column(name="can_tipo_identificacion")
	private Integer canTipoIdentificacion;

	@Column(name="can_usuario")
	private Integer canUsuario;

	@Column(name="cat_estado_civil")
	private String catEstadoCivil;

	@Column(name="cat_tipo_identificacion")
	private String catTipoIdentificacion;

	@Column(name="usu_celular")
	private String usuCelular;

	@Column(name="usu_codigo")
	private Integer usuCodigo;

	@Column(name="usu_direccion")
	private String usuDireccion;

	@Column(name="usu_login")
	private String usuLogin;

	@Column(name="usu_mail")
	private String usuMail;

	@Column(name="usu_password")
	private String usuPassword;

	@Column(name="usu_perfil")
	private Integer usuPerfil;

	@Column(name="usu_telefono")
	private String usuTelefono;

	public CandidatoDatoDTO() {
	}

	public String getCanApellidoMaterno() {
		return this.canApellidoMaterno;
	}

	public void setCanApellidoMaterno(String canApellidoMaterno) {
		this.canApellidoMaterno = canApellidoMaterno;
	}

	public String getCanApellidoPaterno() {
		return this.canApellidoPaterno;
	}

	public void setCanApellidoPaterno(String canApellidoPaterno) {
		this.canApellidoPaterno = canApellidoPaterno;
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

	public Timestamp getCanFechaNacimiento() {
		return this.canFechaNacimiento;
	}

	public void setCanFechaNacimiento(Timestamp canFechaNacimiento) {
		this.canFechaNacimiento = canFechaNacimiento;
	}

	public byte[] getCanFoto() {
		return this.canFoto;
	}

	public void setCanFoto(byte[] canFoto) {
		this.canFoto = canFoto;
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

	public String getCanPrimerNombre() {
		return this.canPrimerNombre;
	}

	public void setCanPrimerNombre(String canPrimerNombre) {
		this.canPrimerNombre = canPrimerNombre;
	}

	public String getCanSegundoNombre() {
		return this.canSegundoNombre;
	}

	public void setCanSegundoNombre(String canSegundoNombre) {
		this.canSegundoNombre = canSegundoNombre;
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

	public String getCatEstadoCivil() {
		return this.catEstadoCivil;
	}

	public void setCatEstadoCivil(String catEstadoCivil) {
		this.catEstadoCivil = catEstadoCivil;
	}

	public String getCatTipoIdentificacion() {
		return this.catTipoIdentificacion;
	}

	public void setCatTipoIdentificacion(String catTipoIdentificacion) {
		this.catTipoIdentificacion = catTipoIdentificacion;
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

	public Integer getUsuPerfil() {
		return this.usuPerfil;
	}

	public void setUsuPerfil(Integer usuPerfil) {
		this.usuPerfil = usuPerfil;
	}

	public String getUsuTelefono() {
		return this.usuTelefono;
	}

	public void setUsuTelefono(String usuTelefono) {
		this.usuTelefono = usuTelefono;
	}

}