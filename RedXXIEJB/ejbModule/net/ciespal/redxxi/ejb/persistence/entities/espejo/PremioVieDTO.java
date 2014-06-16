package net.ciespal.redxxi.ejb.persistence.entities.espejo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the esp_premio_vie database table.
 * 
 */
@Entity
@Table(name="esp_premio_vie")
@NamedQuery(name="PremioVieDTO.findAll", query="SELECT p FROM PremioVieDTO p")
public class PremioVieDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="cat_ciudad")
	private String catCiudad;

	@Column(name="cat_nivel_geofrafico")
	private String catNivelGeofrafico;

	@Column(name="cat_pais")
	private String catPais;

	@Column(name="cat_provincia")
	private String catProvincia;

	@Column(name="cat_tipo_medio")
	private String catTipoMedio;

	@Column(name="pre_archivo")
	private byte[] preArchivo;

	@Column(name="pre_archivo_nombre")
	private String preArchivoNombre;

	@Column(name="pre_ciudad")
	private Integer preCiudad;

	@Id
	@Column(name="pre_codigo")
	private Integer preCodigo;

	@Column(name="pre_descripcion")
	private String preDescripcion;

	@Column(name="pre_entidad")
	private Integer preEntidad;

	@Column(name="pre_institucion")
	private String preInstitucion;

	@Column(name="pre_nivel_geografico")
	private Integer preNivelGeografico;

	@Column(name="pre_pais")
	private Integer prePais;

	@Column(name="pre_periodicidad")
	private String prePeriodicidad;

	@Column(name="pre_provincia")
	private Integer preProvincia;

	@Column(name="pre_resumen")
	private String preResumen;

	@Column(name="pre_tipo_medio")
	private Integer preTipoMedio;

	@Column(name="pre_titulo")
	private String preTitulo;

	public PremioVieDTO() {
	}

	public String getCatCiudad() {
		return this.catCiudad;
	}

	public void setCatCiudad(String catCiudad) {
		this.catCiudad = catCiudad;
	}

	public String getCatNivelGeofrafico() {
		return this.catNivelGeofrafico;
	}

	public void setCatNivelGeofrafico(String catNivelGeofrafico) {
		this.catNivelGeofrafico = catNivelGeofrafico;
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

	public String getCatTipoMedio() {
		return this.catTipoMedio;
	}

	public void setCatTipoMedio(String catTipoMedio) {
		this.catTipoMedio = catTipoMedio;
	}

	public byte[] getPreArchivo() {
		return this.preArchivo;
	}

	public void setPreArchivo(byte[] preArchivo) {
		this.preArchivo = preArchivo;
	}

	public String getPreArchivoNombre() {
		return this.preArchivoNombre;
	}

	public void setPreArchivoNombre(String preArchivoNombre) {
		this.preArchivoNombre = preArchivoNombre;
	}

	public Integer getPreCiudad() {
		return this.preCiudad;
	}

	public void setPreCiudad(Integer preCiudad) {
		this.preCiudad = preCiudad;
	}

	public Integer getPreCodigo() {
		return this.preCodigo;
	}

	public void setPreCodigo(Integer preCodigo) {
		this.preCodigo = preCodigo;
	}

	public String getPreDescripcion() {
		return this.preDescripcion;
	}

	public void setPreDescripcion(String preDescripcion) {
		this.preDescripcion = preDescripcion;
	}

	public Integer getPreEntidad() {
		return this.preEntidad;
	}

	public void setPreEntidad(Integer preEntidad) {
		this.preEntidad = preEntidad;
	}

	public String getPreInstitucion() {
		return this.preInstitucion;
	}

	public void setPreInstitucion(String preInstitucion) {
		this.preInstitucion = preInstitucion;
	}

	public Integer getPreNivelGeografico() {
		return this.preNivelGeografico;
	}

	public void setPreNivelGeografico(Integer preNivelGeografico) {
		this.preNivelGeografico = preNivelGeografico;
	}

	public Integer getPrePais() {
		return this.prePais;
	}

	public void setPrePais(Integer prePais) {
		this.prePais = prePais;
	}

	public String getPrePeriodicidad() {
		return this.prePeriodicidad;
	}

	public void setPrePeriodicidad(String prePeriodicidad) {
		this.prePeriodicidad = prePeriodicidad;
	}

	public Integer getPreProvincia() {
		return this.preProvincia;
	}

	public void setPreProvincia(Integer preProvincia) {
		this.preProvincia = preProvincia;
	}

	public String getPreResumen() {
		return this.preResumen;
	}

	public void setPreResumen(String preResumen) {
		this.preResumen = preResumen;
	}

	public Integer getPreTipoMedio() {
		return this.preTipoMedio;
	}

	public void setPreTipoMedio(Integer preTipoMedio) {
		this.preTipoMedio = preTipoMedio;
	}

	public String getPreTitulo() {
		return this.preTitulo;
	}

	public void setPreTitulo(String preTitulo) {
		this.preTitulo = preTitulo;
	}

}