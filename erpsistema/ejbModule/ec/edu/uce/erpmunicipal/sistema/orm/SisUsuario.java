package ec.edu.uce.erpmunicipal.sistema.orm;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the sis_usuario database table.
 * 
 */
@Entity
@Table(name="sis_usuario")
public class SisUsuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SIS_USUARIO_USUCODIGO_GENERATOR", sequenceName="sis_usuario_usu_codigo_seq",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SIS_USUARIO_USUCODIGO_GENERATOR")
	@Column(name="usu_codigo")
	private Integer usuCodigo;

	@Column(name="usu_activo")
	private Boolean usuActivo;

	@Column(name="usu_apellidos")
	private String usuApellidos;

	@Column(name="usu_celular")
	private String usuCelular;

	@Column(name="usu_clave")
	private String usuClave;

	@Column(name="usu_direccion")
	private String usuDireccion;

	@Column(name="usu_identifiacion")
	private String usuIdentifiacion;

	@Column(name="usu_login")
	private String usuLogin;

	@Column(name="usu_mail")
	private String usuMail;

	@Column(name="usu_nombres")
	private String usuNombres;

	@Column(name="usu_telefono")
	private String usuTelefono;

	//bi-directional many-to-one association to SisAuditoriaMenu
	@OneToMany(mappedBy="sisUsuario")
	private List<SisAuditoriaMenu> sisAuditoriaMenus;

	//bi-directional many-to-one association to SisHistorialPass
	@OneToMany(mappedBy="sisUsuario")
	private List<SisHistorialPass> sisHistorialPasses;

	//bi-directional many-to-one association to SisInstitucion
	@ManyToOne
	@JoinColumn(name="usu_institucion")
	private SisInstitucion sisInstitucion;

	//bi-directional many-to-one association to SisUsuarioRol
	@OneToMany(mappedBy="sisUsuario")
	private List<SisUsuarioRol> sisUsuarioRols;

	public SisUsuario() {
	}

	public Integer getUsuCodigo() {
		return this.usuCodigo;
	}

	public void setUsuCodigo(Integer usuCodigo) {
		this.usuCodigo = usuCodigo;
	}

	public Boolean getUsuActivo() {
		return this.usuActivo;
	}

	public void setUsuActivo(Boolean usuActivo) {
		this.usuActivo = usuActivo;
	}

	public String getUsuApellidos() {
		return this.usuApellidos;
	}

	public void setUsuApellidos(String usuApellidos) {
		this.usuApellidos = usuApellidos;
	}

	public String getUsuCelular() {
		return this.usuCelular;
	}

	public void setUsuCelular(String usuCelular) {
		this.usuCelular = usuCelular;
	}

	public String getUsuClave() {
		return this.usuClave;
	}

	public void setUsuClave(String usuClave) {
		this.usuClave = usuClave;
	}

	public String getUsuDireccion() {
		return this.usuDireccion;
	}

	public void setUsuDireccion(String usuDireccion) {
		this.usuDireccion = usuDireccion;
	}

	public String getUsuIdentifiacion() {
		return this.usuIdentifiacion;
	}

	public void setUsuIdentifiacion(String usuIdentifiacion) {
		this.usuIdentifiacion = usuIdentifiacion;
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

	public String getUsuTelefono() {
		return this.usuTelefono;
	}

	public void setUsuTelefono(String usuTelefono) {
		this.usuTelefono = usuTelefono;
	}

	public List<SisAuditoriaMenu> getSisAuditoriaMenus() {
		return this.sisAuditoriaMenus;
	}

	public void setSisAuditoriaMenus(List<SisAuditoriaMenu> sisAuditoriaMenus) {
		this.sisAuditoriaMenus = sisAuditoriaMenus;
	}

	public List<SisHistorialPass> getSisHistorialPasses() {
		return this.sisHistorialPasses;
	}

	public void setSisHistorialPasses(List<SisHistorialPass> sisHistorialPasses) {
		this.sisHistorialPasses = sisHistorialPasses;
	}

	public SisInstitucion getSisInstitucion() {
		return this.sisInstitucion;
	}

	public void setSisInstitucion(SisInstitucion sisInstitucion) {
		this.sisInstitucion = sisInstitucion;
	}

	public List<SisUsuarioRol> getSisUsuarioRols() {
		return this.sisUsuarioRols;
	}

	public void setSisUsuarioRols(List<SisUsuarioRol> sisUsuarioRols) {
		this.sisUsuarioRols = sisUsuarioRols;
	}

}