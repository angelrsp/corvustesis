package net.ciespal.redxxi.ejb.persistence.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ate_organizacion_vie database table.
 * 
 */
@Entity
@Table(name="ate_organizacion_vie")
@NamedQuery(name="OrganizacionVieDTO.findAll", query="SELECT o FROM OrganizacionVieDTO o")
public class OrganizacionVieDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="cat_ciudad")
	private String catCiudad;

	@Column(name="cat_pais")
	private String catPais;

	@Column(name="cat_provincia")
	private String catProvincia;

	@Column(name="org_anio_fundacion")
	private Integer orgAnioFundacion;

	@Column(name="org_ciudad")
	private Integer orgCiudad;

	@Id
	@Column(name="org_codigo")
	private Integer orgCodigo;

	@Column(name="org_datos_institucionales")
	private String orgDatosInstitucionales;

	@Column(name="org_institucion_superior")
	private String orgInstitucionSuperior;

	@Column(name="org_mienbros")
	private Integer orgMienbros;

	@Column(name="org_mision")
	private String orgMision;

	@Column(name="org_nombre")
	private String orgNombre;

	@Column(name="org_pais")
	private Integer orgPais;

	@Column(name="org_provincia")
	private Integer orgProvincia;

	public OrganizacionVieDTO() {
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

	public Integer getOrgAnioFundacion() {
		return this.orgAnioFundacion;
	}

	public void setOrgAnioFundacion(Integer orgAnioFundacion) {
		this.orgAnioFundacion = orgAnioFundacion;
	}

	public Integer getOrgCiudad() {
		return this.orgCiudad;
	}

	public void setOrgCiudad(Integer orgCiudad) {
		this.orgCiudad = orgCiudad;
	}

	public Integer getOrgCodigo() {
		return this.orgCodigo;
	}

	public void setOrgCodigo(Integer orgCodigo) {
		this.orgCodigo = orgCodigo;
	}

	public String getOrgDatosInstitucionales() {
		return this.orgDatosInstitucionales;
	}

	public void setOrgDatosInstitucionales(String orgDatosInstitucionales) {
		this.orgDatosInstitucionales = orgDatosInstitucionales;
	}

	public String getOrgInstitucionSuperior() {
		return this.orgInstitucionSuperior;
	}

	public void setOrgInstitucionSuperior(String orgInstitucionSuperior) {
		this.orgInstitucionSuperior = orgInstitucionSuperior;
	}

	public Integer getOrgMienbros() {
		return this.orgMienbros;
	}

	public void setOrgMienbros(Integer orgMienbros) {
		this.orgMienbros = orgMienbros;
	}

	public String getOrgMision() {
		return this.orgMision;
	}

	public void setOrgMision(String orgMision) {
		this.orgMision = orgMision;
	}

	public String getOrgNombre() {
		return this.orgNombre;
	}

	public void setOrgNombre(String orgNombre) {
		this.orgNombre = orgNombre;
	}

	public Integer getOrgPais() {
		return this.orgPais;
	}

	public void setOrgPais(Integer orgPais) {
		this.orgPais = orgPais;
	}

	public Integer getOrgProvincia() {
		return this.orgProvincia;
	}

	public void setOrgProvincia(Integer orgProvincia) {
		this.orgProvincia = orgProvincia;
	}

}