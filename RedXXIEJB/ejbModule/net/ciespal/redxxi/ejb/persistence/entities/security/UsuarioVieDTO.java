package net.ciespal.redxxi.ejb.persistence.entities.security;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the seg_usuario_vie database table.
 * 
 */
@Entity
@Table(name="seg_usuario_vie")
@NamedQuery(name="UsuarioVieDTO.findAll", query="SELECT u FROM UsuarioVieDTO u")
public class UsuarioVieDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="cat_ciudad")
	private String catCiudad;

	@Column(name="cat_pais")
	private String catPais;

	@Column(name="cat_provincia")
	private String catProvincia;

	@Column(name="usu_apellidos")
	private String usuApellidos;

	@Column(name="usu_ciudad")
	private Integer usuCiudad;

	@Column(name="usu_clave")
	private String usuClave;

	@Id
	@Column(name="usu_codigo")
	private Integer usuCodigo;

	@Column(name="usu_empresa")
	private Integer usuEmpresa;

	@Column(name="usu_login")
	private String usuLogin;

	@Column(name="usu_mail")
	private String usuMail;

	@Column(name="usu_nombres")
	private String usuNombres;

	@Column(name="usu_pais")
	private Integer usuPais;

	@Column(name="usu_provincia")
	private Integer usuProvincia;

	@Column(name="usu_tipo")
	private Integer usuTipo;

	public UsuarioVieDTO() {
	}

	public String getCatCiudad() {
		return this.catCiudad;
	}

	public void setCatCiudad(String catCiudad) {
		this.catCiudad = catCiudad;
	}

	public String getCatPais() {
		return this.catPais;
	}

	public void setCatPais(String catPais) {
		this.catPais = catPais;
	}

	public String getCatProvincia() {
		return this.catProvincia;
	}

	public void setCatProvincia(String catProvincia) {
		this.catProvincia = catProvincia;
	}

	public String getUsuApellidos() {
		return this.usuApellidos;
	}

	public void setUsuApellidos(String usuApellidos) {
		this.usuApellidos = usuApellidos;
	}

	public Integer getUsuCiudad() {
		return this.usuCiudad;
	}

	public void setUsuCiudad(Integer usuCiudad) {
		this.usuCiudad = usuCiudad;
	}

	public String getUsuClave() {
		return this.usuClave;
	}

	public void setUsuClave(String usuClave) {
		this.usuClave = usuClave;
	}

	public Integer getUsuCodigo() {
		return this.usuCodigo;
	}

	public void setUsuCodigo(Integer usuCodigo) {
		this.usuCodigo = usuCodigo;
	}

	public Integer getUsuEmpresa() {
		return this.usuEmpresa;
	}

	public void setUsuEmpresa(Integer usuEmpresa) {
		this.usuEmpresa = usuEmpresa;
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

	public String getUsuNombres() {
		return this.usuNombres;
	}

	public void setUsuNombres(String usuNombres) {
		this.usuNombres = usuNombres;
	}

	public Integer getUsuPais() {
		return this.usuPais;
	}

	public void setUsuPais(Integer usuPais) {
		this.usuPais = usuPais;
	}

	public Integer getUsuProvincia() {
		return this.usuProvincia;
	}

	public void setUsuProvincia(Integer usuProvincia) {
		this.usuProvincia = usuProvincia;
	}

	public Integer getUsuTipo() {
		return this.usuTipo;
	}

	public void setUsuTipo(Integer usuTipo) {
		this.usuTipo = usuTipo;
	}

}