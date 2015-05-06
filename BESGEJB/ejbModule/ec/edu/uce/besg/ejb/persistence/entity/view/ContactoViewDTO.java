package ec.edu.uce.besg.ejb.persistence.entity.view;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the bem_contacto_view database table.
 * 
 */
@Entity
@Table(name="bem_contacto_view")
@NamedQuery(name="ContactoViewDTO.findAll", query="SELECT c FROM ContactoViewDTO c")
public class ContactoViewDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="cat_cargo")
	private String catCargo;

	@Column(name="con_apellidos")
	private String conApellidos;

	@Column(name="con_cargo")
	private Integer conCargo;

	@Id
	@Column(name="con_codigo")
	private Integer conCodigo;

	@Column(name="con_empresa")
	private Integer conEmpresa;

	@Column(name="con_mail")
	private String conMail;

	@Column(name="con_nombres")
	private String conNombres;

	@Column(name="con_telefono")
	private String conTelefono;

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

	public ContactoViewDTO() {
	}

	public String getCatCargo() {
		return this.catCargo;
	}

	public void setCatCargo(String catCargo) {
		this.catCargo = catCargo;
	}

	public String getConApellidos() {
		return this.conApellidos;
	}

	public void setConApellidos(String conApellidos) {
		this.conApellidos = conApellidos;
	}

	public Integer getConCargo() {
		return this.conCargo;
	}

	public void setConCargo(Integer conCargo) {
		this.conCargo = conCargo;
	}

	public Integer getConCodigo() {
		return this.conCodigo;
	}

	public void setConCodigo(Integer conCodigo) {
		this.conCodigo = conCodigo;
	}

	public Integer getConEmpresa() {
		return this.conEmpresa;
	}

	public void setConEmpresa(Integer conEmpresa) {
		this.conEmpresa = conEmpresa;
	}

	public String getConMail() {
		return this.conMail;
	}

	public void setConMail(String conMail) {
		this.conMail = conMail;
	}

	public String getConNombres() {
		return this.conNombres;
	}

	public void setConNombres(String conNombres) {
		this.conNombres = conNombres;
	}

	public String getConTelefono() {
		return this.conTelefono;
	}

	public void setConTelefono(String conTelefono) {
		this.conTelefono = conTelefono;
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

}