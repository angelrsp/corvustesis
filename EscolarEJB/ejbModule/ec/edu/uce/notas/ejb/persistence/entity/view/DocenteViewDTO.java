package ec.edu.uce.notas.ejb.persistence.entity.view;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the not_docente_view database table.
 * 
 */
@Entity
@Table(name="not_docente_view")
@NamedQuery(name="DocenteViewDTO.findAll", query="SELECT n FROM DocenteViewDTO n")
public class DocenteViewDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="doc_codigo")
	private Integer docCodigo;

	@Column(name="doc_usuario")
	private Integer docUsuario;

	@Column(name="usu_apellidos")
	private String usuApellidos;

	@Column(name="usu_cargo")
	private Integer usuCargo;

	@Column(name="usu_codigo")
	private Integer usuCodigo;

	@Column(name="usu_empresa")
	private Integer usuEmpresa;

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

	public DocenteViewDTO() {
	}

	public Integer getDocCodigo() {
		return this.docCodigo;
	}

	public void setDocCodigo(Integer docCodigo) {
		this.docCodigo = docCodigo;
	}

	public Integer getDocUsuario() {
		return this.docUsuario;
	}

	public void setDocUsuario(Integer docUsuario) {
		this.docUsuario = docUsuario;
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

}