package ec.edu.uce.silsag.ejb.persistence.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the vie_postulacion database table.
 * 
 */
@Entity
@Table(name="vie_postulacion")
@NamedQuery(name="PostulacionListDTO.findAll", query="SELECT p FROM PostulacionListDTO p")
public class PostulacionListDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="avi_descripcion")
	private String aviDescripcion;

	@Column(name="avi_empresa")
	private Integer aviEmpresa;

	@Column(name="avi_fecha_caducidad")
	private Timestamp aviFechaCaducidad;

	@Column(name="avi_nombre")
	private Integer aviNombre;

	@Column(name="avi_puesto")
	private Integer aviPuesto;

	@Column(name="avi_remuneracion")
	private String aviRemuneracion;

	@Column(name="avi_vacantes")
	private Integer aviVacantes;

	@Column(name="can_apellido_materno")
	private String canApellidoMaterno;

	@Column(name="can_apellido_paterno")
	private String canApellidoPaterno;

	@Column(name="can_codigo")
	private Integer canCodigo;

	@Column(name="can_foto")
	private byte[] canFoto;

	@Column(name="can_identificacion")
	private String canIdentificacion;

	@Column(name="can_nombres")
	private String canNombres;

	@Column(name="can_tipo_identificacion")
	private Integer canTipoIdentificacion;

	@Column(name="can_usuario")
	private Integer canUsuario;

	@Column(name="cat_puesto")
	private String catPuesto;

	@Column(name="emp_codigo")
	private Integer empCodigo;

	@Column(name="emp_nombre_comercial")
	private String empNombreComercial;

	@Column(name="emp_razon_social")
	private String empRazonSocial;

	@Column(name="emp_ruc")
	private String empRuc;

	@Column(name="emp_sector")
	private Integer empSector;

	@Column(name="emp_ubicacion")
	private Integer empUbicacion;

	@Column(name="emp_usuario")
	private Integer empUsuario;

	@Column(name="emp_web")
	private String empWeb;

	@Column(name="pos_aviso")
	private Integer posAviso;

	@Column(name="pos_candidato")
	private Integer posCandidato;

	@Id
	@Column(name="pos_codigo")
	private Integer posCodigo;

	public PostulacionListDTO() {
	}

	public String getAviDescripcion() {
		return this.aviDescripcion;
	}

	public void setAviDescripcion(String aviDescripcion) {
		this.aviDescripcion = aviDescripcion;
	}

	public Integer getAviEmpresa() {
		return this.aviEmpresa;
	}

	public void setAviEmpresa(Integer aviEmpresa) {
		this.aviEmpresa = aviEmpresa;
	}

	public Timestamp getAviFechaCaducidad() {
		return this.aviFechaCaducidad;
	}

	public void setAviFechaCaducidad(Timestamp aviFechaCaducidad) {
		this.aviFechaCaducidad = aviFechaCaducidad;
	}

	public Integer getAviNombre() {
		return this.aviNombre;
	}

	public void setAviNombre(Integer aviNombre) {
		this.aviNombre = aviNombre;
	}

	public Integer getAviPuesto() {
		return this.aviPuesto;
	}

	public void setAviPuesto(Integer aviPuesto) {
		this.aviPuesto = aviPuesto;
	}

	public String getAviRemuneracion() {
		return this.aviRemuneracion;
	}

	public void setAviRemuneracion(String aviRemuneracion) {
		this.aviRemuneracion = aviRemuneracion;
	}

	public Integer getAviVacantes() {
		return this.aviVacantes;
	}

	public void setAviVacantes(Integer aviVacantes) {
		this.aviVacantes = aviVacantes;
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

	public String getCanNombres() {
		return this.canNombres;
	}

	public void setCanNombres(String canNombres) {
		this.canNombres = canNombres;
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

	public String getCatPuesto() {
		return this.catPuesto;
	}

	public void setCatPuesto(String catPuesto) {
		this.catPuesto = catPuesto;
	}

	public Integer getEmpCodigo() {
		return this.empCodigo;
	}

	public void setEmpCodigo(Integer empCodigo) {
		this.empCodigo = empCodigo;
	}

	public String getEmpNombreComercial() {
		return this.empNombreComercial;
	}

	public void setEmpNombreComercial(String empNombreComercial) {
		this.empNombreComercial = empNombreComercial;
	}

	public String getEmpRazonSocial() {
		return this.empRazonSocial;
	}

	public void setEmpRazonSocial(String empRazonSocial) {
		this.empRazonSocial = empRazonSocial;
	}

	public String getEmpRuc() {
		return this.empRuc;
	}

	public void setEmpRuc(String empRuc) {
		this.empRuc = empRuc;
	}

	public Integer getEmpSector() {
		return this.empSector;
	}

	public void setEmpSector(Integer empSector) {
		this.empSector = empSector;
	}

	public Integer getEmpUbicacion() {
		return this.empUbicacion;
	}

	public void setEmpUbicacion(Integer empUbicacion) {
		this.empUbicacion = empUbicacion;
	}

	public Integer getEmpUsuario() {
		return this.empUsuario;
	}

	public void setEmpUsuario(Integer empUsuario) {
		this.empUsuario = empUsuario;
	}

	public String getEmpWeb() {
		return this.empWeb;
	}

	public void setEmpWeb(String empWeb) {
		this.empWeb = empWeb;
	}

	public Integer getPosAviso() {
		return this.posAviso;
	}

	public void setPosAviso(Integer posAviso) {
		this.posAviso = posAviso;
	}

	public Integer getPosCandidato() {
		return this.posCandidato;
	}

	public void setPosCandidato(Integer posCandidato) {
		this.posCandidato = posCandidato;
	}

	public Integer getPosCodigo() {
		return this.posCodigo;
	}

	public void setPosCodigo(Integer posCodigo) {
		this.posCodigo = posCodigo;
	}

}