package ec.edu.uce.silsag.ejb.persistence.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the vie_aviso database table.
 * 
 */
@Entity
@Table(name="vie_aviso")
@NamedQuery(name="AvisoListDTO.findAll", query="SELECT a FROM AvisoListDTO a")
public class AvisoListDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="avi_descripcion")
	private String aviDescripcion;

	@Column(name="avi_empresa")
	private Integer aviEmpresa;

	@Column(name="avi_fecha_caducidad")
	private Timestamp aviFechaCaducidad;

	@Id
	@Column(name="avi_nombre")
	private Integer aviNombre;

	@Column(name="avi_puesto")
	private Integer aviPuesto;

	@Column(name="avi_remuneracion")
	private String aviRemuneracion;

	@Column(name="avi_vacantes")
	private Integer aviVacantes;

	@Column(name="cat_descripcion")
	private String catDescripcion;
	
	@Column(name="emp_nombre_comercial")
	private String empNombreComercial;
	

	public AvisoListDTO() {
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

	public String getCatDescripcion() {
		return this.catDescripcion;
	}

	public void setCatDescripcion(String catDescripcion) {
		this.catDescripcion = catDescripcion;
	}

	public String getEmpNombreComercial() {
		return empNombreComercial;
	}

	public void setEmpNombreComercial(String empNombreComercial) {
		this.empNombreComercial = empNombreComercial;
	}

}