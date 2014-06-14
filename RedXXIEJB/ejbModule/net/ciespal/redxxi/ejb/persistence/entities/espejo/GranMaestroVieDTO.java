package net.ciespal.redxxi.ejb.persistence.entities.espejo;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the esp_gran_maestro_vie database table.
 * 
 */
@Entity
@Table(name="esp_gran_maestro_vie")
@NamedQuery(name="GranMaestroVieDTO.findAll", query="SELECT g FROM GranMaestroVieDTO g")
public class GranMaestroVieDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="cat_ciudad")
	private String catCiudad;

	@Column(name="cat_pais")
	private String catPais;

	@Column(name="cat_provincia")
	private String catProvincia;

	@Column(name="gma_apellidos")
	private String gmaApellidos;

	@Column(name="gma_ciudad")
	private Integer gmaCiudad;

	@Id
	@Column(name="gma_codigo")
	private Integer gmaCodigo;

	@Column(name="gma_entidad")
	private Integer gmaEntidad;

	@Column(name="gma_fecha_fallecimiento")
	private Timestamp gmaFechaFallecimiento;

	@Column(name="gma_fecha_nacimiento")
	private Timestamp gmaFechaNacimiento;

	@Column(name="gma_foto")
	private byte[] gmaFoto;

	@Column(name="gma_foto_nombre")
	private String gmaFotoNombre;

	@Column(name="gma_nombres")
	private String gmaNombres;

	@Column(name="gma_pais")
	private Integer gmaPais;

	@Column(name="gma_perfil_biografico")
	private String gmaPerfilBiografico;

	@Column(name="gma_provincia")
	private Integer gmaProvincia;

	public GranMaestroVieDTO() {
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

	public String getGmaApellidos() {
		return this.gmaApellidos;
	}

	public void setGmaApellidos(String gmaApellidos) {
		this.gmaApellidos = gmaApellidos;
	}

	public Integer getGmaCiudad() {
		return this.gmaCiudad;
	}

	public void setGmaCiudad(Integer gmaCiudad) {
		this.gmaCiudad = gmaCiudad;
	}

	public Integer getGmaCodigo() {
		return this.gmaCodigo;
	}

	public void setGmaCodigo(Integer gmaCodigo) {
		this.gmaCodigo = gmaCodigo;
	}

	public Integer getGmaEntidad() {
		return this.gmaEntidad;
	}

	public void setGmaEntidad(Integer gmaEntidad) {
		this.gmaEntidad = gmaEntidad;
	}

	public Timestamp getGmaFechaFallecimiento() {
		return this.gmaFechaFallecimiento;
	}

	public void setGmaFechaFallecimiento(Timestamp gmaFechaFallecimiento) {
		this.gmaFechaFallecimiento = gmaFechaFallecimiento;
	}

	public Timestamp getGmaFechaNacimiento() {
		return this.gmaFechaNacimiento;
	}

	public void setGmaFechaNacimiento(Timestamp gmaFechaNacimiento) {
		this.gmaFechaNacimiento = gmaFechaNacimiento;
	}

	public byte[] getGmaFoto() {
		return this.gmaFoto;
	}

	public void setGmaFoto(byte[] gmaFoto) {
		this.gmaFoto = gmaFoto;
	}

	public String getGmaFotoNombre() {
		return this.gmaFotoNombre;
	}

	public void setGmaFotoNombre(String gmaFotoNombre) {
		this.gmaFotoNombre = gmaFotoNombre;
	}

	public String getGmaNombres() {
		return this.gmaNombres;
	}

	public void setGmaNombres(String gmaNombres) {
		this.gmaNombres = gmaNombres;
	}

	public Integer getGmaPais() {
		return this.gmaPais;
	}

	public void setGmaPais(Integer gmaPais) {
		this.gmaPais = gmaPais;
	}

	public String getGmaPerfilBiografico() {
		return this.gmaPerfilBiografico;
	}

	public void setGmaPerfilBiografico(String gmaPerfilBiografico) {
		this.gmaPerfilBiografico = gmaPerfilBiografico;
	}

	public Integer getGmaProvincia() {
		return this.gmaProvincia;
	}

	public void setGmaProvincia(Integer gmaProvincia) {
		this.gmaProvincia = gmaProvincia;
	}

}