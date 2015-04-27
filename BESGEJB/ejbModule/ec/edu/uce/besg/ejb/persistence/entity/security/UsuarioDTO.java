package ec.edu.uce.besg.ejb.persistence.entity.security;

import java.io.Serializable;

import javax.persistence.*;

import ec.edu.uce.besg.ejb.persistence.entity.CandidatoDTO;
import ec.edu.uce.besg.ejb.persistence.entity.EmpresaDTO;

import java.util.List;


/**
 * The persistent class for the seg_usuario database table.
 * 
 */
@Entity
@Table(name="seg_usuario")
@NamedQuery(name="UsuarioDTO.findAll", query="SELECT u FROM UsuarioDTO u")
public class UsuarioDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SEG_USUARIO_USUCODIGO_GENERATOR", sequenceName="SEG_USUARIO_USU_CODIGO_SEQ",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEG_USUARIO_USUCODIGO_GENERATOR")
	@Column(name="usu_codigo")
	private Integer usuCodigo;

	@Column(name="usu_celular")
	private String usuCelular;

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

	@Column(name="usu_facultad")
	private Integer usuFacultad;
	
	//bi-directional many-to-one association to HistorialPasswordDTO
	@OneToMany(mappedBy="segUsuario")
	private List<HistorialPasswordDTO> segHistorialPasswords;

	//bi-directional many-to-one association to LogDTO
	@OneToMany(mappedBy="segUsuario")
	private List<LogDTO> segLogs;

	//bi-directional many-to-one association to RegistroLoginDTO
	@OneToMany(mappedBy="segUsuario")
	private List<RegistroLoginDTO> segRegistroLogins;

	//bi-directional many-to-one association to UsuarioPerfilDTO
	@OneToMany(mappedBy="segUsuario")
	private List<UsuarioPerfilDTO> segUsuarioPerfils;
	
	//bi-directional many-to-one association to RegistroLoginDTOs
	@OneToMany(mappedBy="segUsuario")
	private List<EmpresaDTO> bemEmpresas;

	//bi-directional many-to-one association to RegistroLoginDTOs
	@OneToMany(mappedBy="segUsuario")
	private List<CandidatoDTO> bemCandidatos;


	public UsuarioDTO() {
	}

	public Integer getUsuCodigo() {
		return this.usuCodigo;
	}

	public void setUsuCodigo(Integer usuCodigo) {
		this.usuCodigo = usuCodigo;
	}

	public String getUsuCelular() {
		return this.usuCelular;
	}

	public void setUsuCelular(String usuCelular) {
		this.usuCelular = usuCelular;
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

	public Integer getUsuFacultad() {
		return usuFacultad;
	}

	public void setUsuFacultad(Integer usuFacultad) {
		this.usuFacultad = usuFacultad;
	}

	public List<HistorialPasswordDTO> getSegHistorialPasswords() {
		return this.segHistorialPasswords;
	}

	public void setSegHistorialPasswords(List<HistorialPasswordDTO> segHistorialPasswords) {
		this.segHistorialPasswords = segHistorialPasswords;
	}

	public List<EmpresaDTO> getBemEmpresas() {
		return bemEmpresas;
	}

	public void setBemEmpresas(List<EmpresaDTO> bemEmpresas) {
		this.bemEmpresas = bemEmpresas;
	}

	public HistorialPasswordDTO addSegHistorialPassword(HistorialPasswordDTO segHistorialPassword) {
		getSegHistorialPasswords().add(segHistorialPassword);
		segHistorialPassword.setSegUsuario(this);

		return segHistorialPassword;
	}

	public HistorialPasswordDTO removeSegHistorialPassword(HistorialPasswordDTO segHistorialPassword) {
		getSegHistorialPasswords().remove(segHistorialPassword);
		segHistorialPassword.setSegUsuario(null);

		return segHistorialPassword;
	}

	public List<LogDTO> getSegLogs() {
		return this.segLogs;
	}

	public void setSegLogs(List<LogDTO> segLogs) {
		this.segLogs = segLogs;
	}

	public LogDTO addSegLog(LogDTO segLog) {
		getSegLogs().add(segLog);
		segLog.setSegUsuario(this);

		return segLog;
	}

	public LogDTO removeSegLog(LogDTO segLog) {
		getSegLogs().remove(segLog);
		segLog.setSegUsuario(null);

		return segLog;
	}

	public List<RegistroLoginDTO> getSegRegistroLogins() {
		return this.segRegistroLogins;
	}

	public void setSegRegistroLogins(List<RegistroLoginDTO> segRegistroLogins) {
		this.segRegistroLogins = segRegistroLogins;
	}

	public RegistroLoginDTO addSegRegistroLogin(RegistroLoginDTO segRegistroLogin) {
		getSegRegistroLogins().add(segRegistroLogin);
		segRegistroLogin.setSegUsuario(this);

		return segRegistroLogin;
	}

	public RegistroLoginDTO removeSegRegistroLogin(RegistroLoginDTO segRegistroLogin) {
		getSegRegistroLogins().remove(segRegistroLogin);
		segRegistroLogin.setSegUsuario(null);

		return segRegistroLogin;
	}

	public List<UsuarioPerfilDTO> getSegUsuarioPerfils() {
		return this.segUsuarioPerfils;
	}

	public void setSegUsuarioPerfils(List<UsuarioPerfilDTO> segUsuarioPerfils) {
		this.segUsuarioPerfils = segUsuarioPerfils;
	}

	public UsuarioPerfilDTO addSegUsuarioPerfil(UsuarioPerfilDTO segUsuarioPerfil) {
		getSegUsuarioPerfils().add(segUsuarioPerfil);
		segUsuarioPerfil.setSegUsuario(this);

		return segUsuarioPerfil;
	}

	public UsuarioPerfilDTO removeSegUsuarioPerfil(UsuarioPerfilDTO segUsuarioPerfil) {
		getSegUsuarioPerfils().remove(segUsuarioPerfil);
		segUsuarioPerfil.setSegUsuario(null);

		return segUsuarioPerfil;
	}

	public List<CandidatoDTO> getBemCandidatos() {
		return bemCandidatos;
	}

	public void setBemCandidatos(List<CandidatoDTO> bemCandidatos) {
		this.bemCandidatos = bemCandidatos;
	}

}