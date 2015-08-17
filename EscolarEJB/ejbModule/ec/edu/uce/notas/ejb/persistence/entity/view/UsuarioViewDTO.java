package ec.edu.uce.notas.ejb.persistence.entity.view;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the seg_usuario_view database table.
 * 
 */
@Entity
@Table(name="seg_usuario_view")
@NamedQuery(name="UsuarioViewDTO.findAll", query="SELECT u FROM UsuarioViewDTO u")
public class UsuarioViewDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="cat_area_trabajo")
	private String catAreaTrabajo;

	@Column(name="cat_canton")
	private String catCanton;

	@Column(name="cat_provincia")
	private String catProvincia;

	@Column(name="cat_region")
	private String catRegion;

	@Column(name="cat_sexo")
	private String catSexo;

	@Column(name="usu_apellidos")
	private String usuApellidos;

	@Column(name="usu_area_trabajo")
	private Integer usuAreaTrabajo;

	@Column(name="usu_canton")
	private Integer usuCanton;

	@Id
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

	@Column(name="usu_provincia")
	private Integer usuProvincia;

	@Column(name="usu_region")
	private Integer usuRegion;

	@Column(name="usu_sexo")
	private Integer usuSexo;

	@Column(name="usu_tipo_identificacion")
	private Integer usuTipoIdentificacion;

	public UsuarioViewDTO() {
	}

	public String getCatAreaTrabajo() {
		return this.catAreaTrabajo;
	}

	public void setCatAreaTrabajo(String catAreaTrabajo) {
		this.catAreaTrabajo = catAreaTrabajo;
	}

	public String getCatCanton() {
		return this.catCanton;
	}

	public void setCatCanton(String catCanton) {
		this.catCanton = catCanton;
	}

	public String getCatProvincia() {
		return this.catProvincia;
	}

	public void setCatProvincia(String catProvincia) {
		this.catProvincia = catProvincia;
	}

	public String getCatRegion() {
		return this.catRegion;
	}

	public void setCatRegion(String catRegion) {
		this.catRegion = catRegion;
	}

	public String getCatSexo() {
		return this.catSexo;
	}

	public void setCatSexo(String catSexo) {
		this.catSexo = catSexo;
	}

	public String getUsuApellidos() {
		return this.usuApellidos;
	}

	public void setUsuApellidos(String usuApellidos) {
		this.usuApellidos = usuApellidos;
	}

	public Integer getUsuAreaTrabajo() {
		return this.usuAreaTrabajo;
	}

	public void setUsuAreaTrabajo(Integer usuAreaTrabajo) {
		this.usuAreaTrabajo = usuAreaTrabajo;
	}

	public Integer getUsuCanton() {
		return this.usuCanton;
	}

	public void setUsuCanton(Integer usuCanton) {
		this.usuCanton = usuCanton;
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

	public Integer getUsuProvincia() {
		return this.usuProvincia;
	}

	public void setUsuProvincia(Integer usuProvincia) {
		this.usuProvincia = usuProvincia;
	}

	public Integer getUsuRegion() {
		return this.usuRegion;
	}

	public void setUsuRegion(Integer usuRegion) {
		this.usuRegion = usuRegion;
	}

	public Integer getUsuSexo() {
		return this.usuSexo;
	}

	public void setUsuSexo(Integer usuSexo) {
		this.usuSexo = usuSexo;
	}

	public Integer getUsuTipoIdentificacion() {
		return this.usuTipoIdentificacion;
	}

	public void setUsuTipoIdentificacion(Integer usuTipoIdentificacion) {
		this.usuTipoIdentificacion = usuTipoIdentificacion;
	}

}