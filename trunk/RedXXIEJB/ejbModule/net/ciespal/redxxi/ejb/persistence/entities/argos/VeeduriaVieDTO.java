package net.ciespal.redxxi.ejb.persistence.entities.argos;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the arg_veeduria_vie database table.
 * 
 */
@Entity
@Table(name="arg_veeduria_vie")
@NamedQuery(name="VeeduriaVieDTO.findAll", query="SELECT v FROM VeeduriaVieDTO v")
public class VeeduriaVieDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="cat_ciudad")
	private String catCiudad;

	@Column(name="cat_pais")
	private String catPais;

	@Column(name="cat_provincia")
	private String catProvincia;

	@Column(name="vee_actividad_princiapl")
	private String veeActividadPrinciapl;

	@Column(name="vee_anio_fundacion")
	private Integer veeAnioFundacion;

	@Column(name="vee_ciudad")
	private Integer veeCiudad;

	@Id
	@Column(name="vee_codigo")
	private Integer veeCodigo;

	@Column(name="vee_dato_institucional")
	private String veeDatoInstitucional;

	@Column(name="vee_entidad")
	private Integer veeEntidad;

	@Column(name="vee_institucion_patrocinadora")
	private String veeInstitucionPatrocinadora;

	@Column(name="vee_linea_tematica")
	private String veeLineaTematica;

	@Column(name="vee_mision")
	private String veeMision;

	@Column(name="vee_nombre")
	private String veeNombre;

	@Column(name="vee_pais")
	private Integer veePais;

	@Column(name="vee_provincia")
	private Integer veeProvincia;

	public VeeduriaVieDTO() {
	}

	public String getCatCiudad() {
		return this.catCiudad;
	}

	public void setCatCiudad(String catCiudad) {
		this.catCiudad = catCiudad;
	}

	public String getCatPais() {
		return this.catPais;
	}

	public void setCatPais(String catPais) {
		this.catPais = catPais;
	}

	public String getCatProvincia() {
		return this.catProvincia;
	}

	public void setCatProvincia(String catProvincia) {
		this.catProvincia = catProvincia;
	}

	public String getVeeActividadPrinciapl() {
		return this.veeActividadPrinciapl;
	}

	public void setVeeActividadPrinciapl(String veeActividadPrinciapl) {
		this.veeActividadPrinciapl = veeActividadPrinciapl;
	}

	public Integer getVeeAnioFundacion() {
		return this.veeAnioFundacion;
	}

	public void setVeeAnioFundacion(Integer veeAnioFundacion) {
		this.veeAnioFundacion = veeAnioFundacion;
	}

	public Integer getVeeCiudad() {
		return this.veeCiudad;
	}

	public void setVeeCiudad(Integer veeCiudad) {
		this.veeCiudad = veeCiudad;
	}

	public Integer getVeeCodigo() {
		return this.veeCodigo;
	}

	public void setVeeCodigo(Integer veeCodigo) {
		this.veeCodigo = veeCodigo;
	}

	public String getVeeDatoInstitucional() {
		return this.veeDatoInstitucional;
	}

	public void setVeeDatoInstitucional(String veeDatoInstitucional) {
		this.veeDatoInstitucional = veeDatoInstitucional;
	}

	public Integer getVeeEntidad() {
		return this.veeEntidad;
	}

	public void setVeeEntidad(Integer veeEntidad) {
		this.veeEntidad = veeEntidad;
	}

	public String getVeeInstitucionPatrocinadora() {
		return this.veeInstitucionPatrocinadora;
	}

	public void setVeeInstitucionPatrocinadora(String veeInstitucionPatrocinadora) {
		this.veeInstitucionPatrocinadora = veeInstitucionPatrocinadora;
	}

	public String getVeeLineaTematica() {
		return this.veeLineaTematica;
	}

	public void setVeeLineaTematica(String veeLineaTematica) {
		this.veeLineaTematica = veeLineaTematica;
	}

	public String getVeeMision() {
		return this.veeMision;
	}

	public void setVeeMision(String veeMision) {
		this.veeMision = veeMision;
	}

	public String getVeeNombre() {
		return this.veeNombre;
	}

	public void setVeeNombre(String veeNombre) {
		this.veeNombre = veeNombre;
	}

	public Integer getVeePais() {
		return this.veePais;
	}

	public void setVeePais(Integer veePais) {
		this.veePais = veePais;
	}

	public Integer getVeeProvincia() {
		return this.veeProvincia;
	}

	public void setVeeProvincia(Integer veeProvincia) {
		this.veeProvincia = veeProvincia;
	}

}