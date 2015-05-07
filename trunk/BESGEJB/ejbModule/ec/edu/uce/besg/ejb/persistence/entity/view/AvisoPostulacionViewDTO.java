package ec.edu.uce.besg.ejb.persistence.entity.view;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * The persistent class for the bem_aviso_postulacion_view database table.
 * 
 */
@Entity
@Table(name="bem_aviso_postulacion_view")
@NamedQuery(name="AvisoPostulacionViewDTO.findAll", query="SELECT a FROM AvisoPostulacionViewDTO a")
public class AvisoPostulacionViewDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="avi_codigo")
	private Integer aviCodigo;

	@Column(name="avi_descripcion")
	private String aviDescripcion;

	@Column(name="avi_empresa")
	private Integer aviEmpresa;

	@Column(name="avi_fecha_caducidad")
	private Timestamp aviFechaCaducidad;

	@Column(name="avi_puesto")
	private Integer aviPuesto;

	@Column(name="avi_remuneracion")
	private BigDecimal aviRemuneracion;

	@Column(name="avi_vacantes")
	private Integer aviVacantes;

	@Column(name="cat_puesto")
	private String catPuesto;

	@Column(name="emp_ciudad")
	private Integer empCiudad;

	@Column(name="emp_codigo")
	private Integer empCodigo;

	@Column(name="emp_nombre_comercial")
	private String empNombreComercial;

	@Column(name="emp_pais")
	private Integer empPais;

	@Column(name="emp_provincia")
	private Integer empProvincia;

	@Column(name="emp_razon_social")
	private String empRazonSocial;

	@Column(name="emp_ruc")
	private String empRuc;

	@Column(name="emp_sector")
	private Integer empSector;

	@Column(name="emp_usuario")
	private Integer empUsuario;

	@Column(name="emp_web")
	private String empWeb;

	@Column(name="pos_aceptado")
	private Boolean posAceptado;

	@Column(name="pos_aviso")
	private Integer posAviso;

	@Column(name="pos_candidato")
	private Integer posCandidato;

	@Column(name="pos_codigo")
	private Integer posCodigo;

	public AvisoPostulacionViewDTO() {
	}

	public Integer getAviCodigo() {
		return this.aviCodigo;
	}

	public void setAviCodigo(Integer aviCodigo) {
		this.aviCodigo = aviCodigo;
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

	public Integer getAviPuesto() {
		return this.aviPuesto;
	}

	public void setAviPuesto(Integer aviPuesto) {
		this.aviPuesto = aviPuesto;
	}

	public BigDecimal getAviRemuneracion() {
		return this.aviRemuneracion;
	}

	public void setAviRemuneracion(BigDecimal aviRemuneracion) {
		this.aviRemuneracion = aviRemuneracion;
	}

	public Integer getAviVacantes() {
		return this.aviVacantes;
	}

	public void setAviVacantes(Integer aviVacantes) {
		this.aviVacantes = aviVacantes;
	}

	public String getCatPuesto() {
		return this.catPuesto;
	}

	public void setCatPuesto(String catPuesto) {
		this.catPuesto = catPuesto;
	}

	public Integer getEmpCiudad() {
		return this.empCiudad;
	}

	public void setEmpCiudad(Integer empCiudad) {
		this.empCiudad = empCiudad;
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

	public Integer getEmpPais() {
		return this.empPais;
	}

	public void setEmpPais(Integer empPais) {
		this.empPais = empPais;
	}

	public Integer getEmpProvincia() {
		return this.empProvincia;
	}

	public void setEmpProvincia(Integer empProvincia) {
		this.empProvincia = empProvincia;
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

	public Boolean getPosAceptado() {
		return this.posAceptado;
	}

	public void setPosAceptado(Boolean posAceptado) {
		this.posAceptado = posAceptado;
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