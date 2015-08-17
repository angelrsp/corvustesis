package ec.edu.uce.notas.ejb.persistence.entity;

import java.io.Serializable;
import javax.persistence.*;
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

	@Column(name="usu_apellidos")
	private String usuApellidos;

	@Column(name="usu_cargo")
	private Integer usuCargo;

	@Column(name="usu_identificacion")
	private String usuIdentificacion;

	@Column(name="usu_mail")
	private String usuMail;

	@Column(name="usu_nombres")
	private String usuNombres;

	@Column(name="usu_password")
	private String usuPassword;

	@Column(name="usu_tipo_identificacion")
	private Integer usuTipoIdentificacion;

	//bi-directional many-to-one association to HistoryPasswordDTO
	@OneToMany(mappedBy="segUsuario")
	private List<HistoryPasswordDTO> segHistoryPasswords;

	//bi-directional many-to-one association to EmpresaDTO
	@ManyToOne
	@JoinColumn(name="usu_empresa")
	private EmpresaDTO segEmpresa;

	//bi-directional many-to-one association to UsuarioPerfilDTO
	@OneToMany(mappedBy="segUsuario",fetch=FetchType.EAGER)
	private List<UsuarioPerfilDTO> segUsuarioPerfils;

	public UsuarioDTO() {
	}

	public Integer getUsuCodigo() {
		return this.usuCodigo;
	}

	public void setUsuCodigo(Integer usuCodigo) {
		this.usuCodigo = usuCodigo;
	}

	public String getUsuApellidos() {
		return this.usuApellidos;
	}

	public void setUsuApellidos(String usuApellidos) {
		this.usuApellidos = usuApellidos;
	}

	public Integer getUsuCargo() {
		return this.usuCargo;
	}

	public void setUsuCargo(Integer usuCargo) {
		this.usuCargo = usuCargo;
	}

	public String getUsuIdentificacion() {
		return this.usuIdentificacion;
	}

	public void setUsuIdentificacion(String usuIdentificacion) {
		this.usuIdentificacion = usuIdentificacion;
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

	public String getUsuPassword() {
		return this.usuPassword;
	}

	public void setUsuPassword(String usuPassword) {
		this.usuPassword = usuPassword;
	}

	public Integer getUsuTipoIdentificacion() {
		return this.usuTipoIdentificacion;
	}

	public void setUsuTipoIdentificacion(Integer usuTipoIdentificacion) {
		this.usuTipoIdentificacion = usuTipoIdentificacion;
	}

	public List<HistoryPasswordDTO> getSegHistoryPasswords() {
		return this.segHistoryPasswords;
	}

	public void setSegHistoryPasswords(List<HistoryPasswordDTO> segHistoryPasswords) {
		this.segHistoryPasswords = segHistoryPasswords;
	}

	public HistoryPasswordDTO addSegHistoryPassword(HistoryPasswordDTO segHistoryPassword) {
		getSegHistoryPasswords().add(segHistoryPassword);
		segHistoryPassword.setSegUsuario(this);

		return segHistoryPassword;
	}

	public HistoryPasswordDTO removeSegHistoryPassword(HistoryPasswordDTO segHistoryPassword) {
		getSegHistoryPasswords().remove(segHistoryPassword);
		segHistoryPassword.setSegUsuario(null);

		return segHistoryPassword;
	}

	public EmpresaDTO getSegEmpresa() {
		return this.segEmpresa;
	}

	public void setSegEmpresa(EmpresaDTO segEmpresa) {
		this.segEmpresa = segEmpresa;
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

}