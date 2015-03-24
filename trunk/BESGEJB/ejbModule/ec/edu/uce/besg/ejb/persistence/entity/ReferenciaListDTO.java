package ec.edu.uce.besg.ejb.persistence.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the view_bem_referencia database table.
 * 
 */
@Entity
@Table(name="view_bem_referencia")
@NamedQuery(name="ReferenciaListDTO.findAll", query="SELECT r FROM ReferenciaListDTO r")
public class ReferenciaListDTO implements Serializable {
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

	@Column(name="cat_codigo")
	private Integer catCodigo;

	@Column(name="cat_descripcion")
	private String catDescripcion;

	@Column(name="cat_predecesor")
	private Integer catPredecesor;

	@Column(name="ref_candidato")
	private Integer refCandidato;

	@Id
	@Column(name="ref_codigo")
	private Integer refCodigo;

	@Column(name="ref_mail")
	private String refMail;

	@Column(name="ref_nombre")
	private String refNombre;

	@Column(name="ref_telefono")
	private String refTelefono;

	@Column(name="ref_tipo_empresa")
	private Integer refTipoEmpresa;

	public ReferenciaListDTO() {
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

	public Integer getCatCodigo() {
		return this.catCodigo;
	}

	public void setCatCodigo(Integer catCodigo) {
		this.catCodigo = catCodigo;
	}

	public String getCatDescripcion() {
		return this.catDescripcion;
	}

	public void setCatDescripcion(String catDescripcion) {
		this.catDescripcion = catDescripcion;
	}

	public Integer getCatPredecesor() {
		return this.catPredecesor;
	}

	public void setCatPredecesor(Integer catPredecesor) {
		this.catPredecesor = catPredecesor;
	}

	public Integer getRefCandidato() {
		return this.refCandidato;
	}

	public void setRefCandidato(Integer refCandidato) {
		this.refCandidato = refCandidato;
	}

	public Integer getRefCodigo() {
		return this.refCodigo;
	}

	public void setRefCodigo(Integer refCodigo) {
		this.refCodigo = refCodigo;
	}

	public String getRefMail() {
		return this.refMail;
	}

	public void setRefMail(String refMail) {
		this.refMail = refMail;
	}

	public String getRefNombre() {
		return this.refNombre;
	}

	public void setRefNombre(String refNombre) {
		this.refNombre = refNombre;
	}

	public String getRefTelefono() {
		return this.refTelefono;
	}

	public void setRefTelefono(String refTelefono) {
		this.refTelefono = refTelefono;
	}

	public Integer getRefTipoEmpresa() {
		return this.refTipoEmpresa;
	}

	public void setRefTipoEmpresa(Integer refTipoEmpresa) {
		this.refTipoEmpresa = refTipoEmpresa;
	}

}