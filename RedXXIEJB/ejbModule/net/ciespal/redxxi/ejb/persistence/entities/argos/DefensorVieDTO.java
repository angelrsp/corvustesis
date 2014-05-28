package net.ciespal.redxxi.ejb.persistence.entities.argos;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the arg_defensor_vie database table.
 * 
 */
@Entity
@Table(name="arg_defensor_vie")
@NamedQuery(name="DefensorVieDTO.findAll", query="SELECT d FROM DefensorVieDTO d")
public class DefensorVieDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="def_activo")
	private Boolean defActivo;

	@Column(name="def_ciudad")
	private Integer defCiudad;

	@Column(name="def_codigo")
	private Integer defCodigo;

	@Column(name="def_entidad")
	private Integer defEntidad;

	@Column(name="def_medio")
	private String defMedio;

	@Column(name="def_opinion")
	private String defOpinion;

	@Column(name="def_pais")
	private Integer defPais;

	@Column(name="def_provincia")
	private Integer defProvincia;

	@Column(name="def_tema_referencia")
	private String defTemaReferencia;

	@Column(name="def_usuario")
	private Integer defUsuario;

	@Column(name="opi_ciudad")
	private Integer opiCiudad;

	@Id
	@Column(name="opi_codigo")
	private Integer opiCodigo;

	@Column(name="opi_comentario")
	private String opiComentario;

	@Column(name="opi_defesor")
	private Integer opiDefesor;

	@Column(name="opi_estado")
	private Boolean opiEstado;

	@Column(name="opi_fecha")
	private Timestamp opiFecha;

	@Column(name="opi_fecha_referencia")
	private Timestamp opiFechaReferencia;

	@Column(name="opi_medio")
	private String opiMedio;

	@Column(name="opi_pais")
	private Integer opiPais;

	@Column(name="opi_provincia")
	private Integer opiProvincia;

	@Column(name="opi_tema_referencia")
	private String opiTemaReferencia;

	@Column(name="usu_apellidos")
	private String usuApellidos;

	@Column(name="usu_clave")
	private String usuClave;

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

	public DefensorVieDTO() {
	}

	public Boolean getDefActivo() {
		return this.defActivo;
	}

	public void setDefActivo(Boolean defActivo) {
		this.defActivo = defActivo;
	}

	public Integer getDefCiudad() {
		return this.defCiudad;
	}

	public void setDefCiudad(Integer defCiudad) {
		this.defCiudad = defCiudad;
	}

	public Integer getDefCodigo() {
		return this.defCodigo;
	}

	public void setDefCodigo(Integer defCodigo) {
		this.defCodigo = defCodigo;
	}

	public Integer getDefEntidad() {
		return this.defEntidad;
	}

	public void setDefEntidad(Integer defEntidad) {
		this.defEntidad = defEntidad;
	}

	public String getDefMedio() {
		return this.defMedio;
	}

	public void setDefMedio(String defMedio) {
		this.defMedio = defMedio;
	}

	public String getDefOpinion() {
		return this.defOpinion;
	}

	public void setDefOpinion(String defOpinion) {
		this.defOpinion = defOpinion;
	}

	public Integer getDefPais() {
		return this.defPais;
	}

	public void setDefPais(Integer defPais) {
		this.defPais = defPais;
	}

	public Integer getDefProvincia() {
		return this.defProvincia;
	}

	public void setDefProvincia(Integer defProvincia) {
		this.defProvincia = defProvincia;
	}

	public String getDefTemaReferencia() {
		return this.defTemaReferencia;
	}

	public void setDefTemaReferencia(String defTemaReferencia) {
		this.defTemaReferencia = defTemaReferencia;
	}

	public Integer getDefUsuario() {
		return this.defUsuario;
	}

	public void setDefUsuario(Integer defUsuario) {
		this.defUsuario = defUsuario;
	}

	public Integer getOpiCiudad() {
		return this.opiCiudad;
	}

	public void setOpiCiudad(Integer opiCiudad) {
		this.opiCiudad = opiCiudad;
	}

	public Integer getOpiCodigo() {
		return this.opiCodigo;
	}

	public void setOpiCodigo(Integer opiCodigo) {
		this.opiCodigo = opiCodigo;
	}

	public String getOpiComentario() {
		return this.opiComentario;
	}

	public void setOpiComentario(String opiComentario) {
		this.opiComentario = opiComentario;
	}

	public Integer getOpiDefesor() {
		return this.opiDefesor;
	}

	public void setOpiDefesor(Integer opiDefesor) {
		this.opiDefesor = opiDefesor;
	}

	public Boolean getOpiEstado() {
		return this.opiEstado;
	}

	public void setOpiEstado(Boolean opiEstado) {
		this.opiEstado = opiEstado;
	}

	public Timestamp getOpiFecha() {
		return this.opiFecha;
	}

	public void setOpiFecha(Timestamp opiFecha) {
		this.opiFecha = opiFecha;
	}

	public Timestamp getOpiFechaReferencia() {
		return this.opiFechaReferencia;
	}

	public void setOpiFechaReferencia(Timestamp opiFechaReferencia) {
		this.opiFechaReferencia = opiFechaReferencia;
	}

	public String getOpiMedio() {
		return this.opiMedio;
	}

	public void setOpiMedio(String opiMedio) {
		this.opiMedio = opiMedio;
	}

	public Integer getOpiPais() {
		return this.opiPais;
	}

	public void setOpiPais(Integer opiPais) {
		this.opiPais = opiPais;
	}

	public Integer getOpiProvincia() {
		return this.opiProvincia;
	}

	public void setOpiProvincia(Integer opiProvincia) {
		this.opiProvincia = opiProvincia;
	}

	public String getOpiTemaReferencia() {
		return this.opiTemaReferencia;
	}

	public void setOpiTemaReferencia(String opiTemaReferencia) {
		this.opiTemaReferencia = opiTemaReferencia;
	}

	public String getUsuApellidos() {
		return this.usuApellidos;
	}

	public void setUsuApellidos(String usuApellidos) {
		this.usuApellidos = usuApellidos;
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

}