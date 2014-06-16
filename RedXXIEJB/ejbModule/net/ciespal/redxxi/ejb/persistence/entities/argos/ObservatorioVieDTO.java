package net.ciespal.redxxi.ejb.persistence.entities.argos;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the arg_observatorio_vie database table.
 * 
 */
@Entity
@Table(name="arg_observatorio_vie")
@NamedQuery(name="ObservatorioVieDTO.findAll", query="SELECT o FROM ObservatorioVieDTO o")
public class ObservatorioVieDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="cat_ciudad")
	private String catCiudad;

	@Column(name="cat_pais")
	private String catPais;

	@Column(name="cat_provincia")
	private String catProvincia;

	@Column(name="obs_actividades_principales")
	private String obsActividadesPrincipales;

	@Column(name="obs_anio_fundacion")
	private Integer obsAnioFundacion;

	@Column(name="obs_ciudad")
	private Integer obsCiudad;

	@Id
	@Column(name="obs_codigo")
	private Integer obsCodigo;

	@Column(name="obs_datos_institucionales")
	private String obsDatosInstitucionales;

	@Column(name="obs_entidad")
	private Integer obsEntidad;

	@Column(name="obs_institucion_patrocinadora")
	private String obsInstitucionPatrocinadora;

	@Column(name="obs_linea_tematica")
	private String obsLineaTematica;

	@Column(name="obs_mision")
	private String obsMision;

	@Column(name="obs_nombre")
	private String obsNombre;

	@Column(name="obs_pais")
	private Integer obsPais;

	@Column(name="obs_provincia")
	private Integer obsProvincia;

	@Column(name="obs_red")
	private Integer obsRed;

	public ObservatorioVieDTO() {
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

	public String getObsActividadesPrincipales() {
		return this.obsActividadesPrincipales;
	}

	public void setObsActividadesPrincipales(String obsActividadesPrincipales) {
		this.obsActividadesPrincipales = obsActividadesPrincipales;
	}

	public Integer getObsAnioFundacion() {
		return this.obsAnioFundacion;
	}

	public void setObsAnioFundacion(Integer obsAnioFundacion) {
		this.obsAnioFundacion = obsAnioFundacion;
	}

	public Integer getObsCiudad() {
		return this.obsCiudad;
	}

	public void setObsCiudad(Integer obsCiudad) {
		this.obsCiudad = obsCiudad;
	}

	public Integer getObsCodigo() {
		return this.obsCodigo;
	}

	public void setObsCodigo(Integer obsCodigo) {
		this.obsCodigo = obsCodigo;
	}

	public String getObsDatosInstitucionales() {
		return this.obsDatosInstitucionales;
	}

	public void setObsDatosInstitucionales(String obsDatosInstitucionales) {
		this.obsDatosInstitucionales = obsDatosInstitucionales;
	}

	public Integer getObsEntidad() {
		return this.obsEntidad;
	}

	public void setObsEntidad(Integer obsEntidad) {
		this.obsEntidad = obsEntidad;
	}

	public String getObsInstitucionPatrocinadora() {
		return this.obsInstitucionPatrocinadora;
	}

	public void setObsInstitucionPatrocinadora(String obsInstitucionPatrocinadora) {
		this.obsInstitucionPatrocinadora = obsInstitucionPatrocinadora;
	}

	public String getObsLineaTematica() {
		return this.obsLineaTematica;
	}

	public void setObsLineaTematica(String obsLineaTematica) {
		this.obsLineaTematica = obsLineaTematica;
	}

	public String getObsMision() {
		return this.obsMision;
	}

	public void setObsMision(String obsMision) {
		this.obsMision = obsMision;
	}

	public String getObsNombre() {
		return this.obsNombre;
	}

	public void setObsNombre(String obsNombre) {
		this.obsNombre = obsNombre;
	}

	public Integer getObsPais() {
		return this.obsPais;
	}

	public void setObsPais(Integer obsPais) {
		this.obsPais = obsPais;
	}

	public Integer getObsProvincia() {
		return this.obsProvincia;
	}

	public void setObsProvincia(Integer obsProvincia) {
		this.obsProvincia = obsProvincia;
	}

	public Integer getObsRed() {
		return this.obsRed;
	}

	public void setObsRed(Integer obsRed) {
		this.obsRed = obsRed;
	}

}