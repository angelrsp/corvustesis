package net.ciespal.redxxi.ejb.persistence.entities.espejo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the esp_ley_vie database table.
 * 
 */
@Entity
@Table(name="esp_ley_vie")
@NamedQuery(name="LeyVieDTO.findAll", query="SELECT l FROM LeyVieDTO l")
public class LeyVieDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="cat_ciudad")
	private String catCiudad;

	@Column(name="cat_pais")
	private String catPais;

	@Column(name="cat_provincia")
	private String catProvincia;

	@Column(name="cat_tipo_documento")
	private String catTipoDocumento;

	@Column(name="ley_anio")
	private Integer leyAnio;

	@Column(name="ley_archivo")
	private byte[] leyArchivo;

	@Column(name="ley_archivo_nombre")
	private String leyArchivoNombre;

	@Column(name="ley_ciudad")
	private Integer leyCiudad;

	@Id
	@Column(name="ley_codigo")
	private Integer leyCodigo;

	@Column(name="ley_entidad")
	private Integer leyEntidad;

	@Column(name="ley_entidad_emisora")
	private String leyEntidadEmisora;

	@Column(name="ley_pais")
	private Integer leyPais;

	@Column(name="ley_provincia")
	private Integer leyProvincia;

	@Column(name="ley_texto")
	private String leyTexto;

	@Column(name="ley_tipo")
	private Integer leyTipo;

	@Column(name="ley_titulo")
	private String leyTitulo;

	public LeyVieDTO() {
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

	public String getCatTipoDocumento() {
		return this.catTipoDocumento;
	}

	public void setCatTipoDocumento(String catTipoDocumento) {
		this.catTipoDocumento = catTipoDocumento;
	}

	public Integer getLeyAnio() {
		return this.leyAnio;
	}

	public void setLeyAnio(Integer leyAnio) {
		this.leyAnio = leyAnio;
	}

	public byte[] getLeyArchivo() {
		return this.leyArchivo;
	}

	public void setLeyArchivo(byte[] leyArchivo) {
		this.leyArchivo = leyArchivo;
	}

	public String getLeyArchivoNombre() {
		return this.leyArchivoNombre;
	}

	public void setLeyArchivoNombre(String leyArchivoNombre) {
		this.leyArchivoNombre = leyArchivoNombre;
	}

	public Integer getLeyCiudad() {
		return this.leyCiudad;
	}

	public void setLeyCiudad(Integer leyCiudad) {
		this.leyCiudad = leyCiudad;
	}

	public Integer getLeyCodigo() {
		return this.leyCodigo;
	}

	public void setLeyCodigo(Integer leyCodigo) {
		this.leyCodigo = leyCodigo;
	}

	public Integer getLeyEntidad() {
		return this.leyEntidad;
	}

	public void setLeyEntidad(Integer leyEntidad) {
		this.leyEntidad = leyEntidad;
	}

	public String getLeyEntidadEmisora() {
		return this.leyEntidadEmisora;
	}

	public void setLeyEntidadEmisora(String leyEntidadEmisora) {
		this.leyEntidadEmisora = leyEntidadEmisora;
	}

	public Integer getLeyPais() {
		return this.leyPais;
	}

	public void setLeyPais(Integer leyPais) {
		this.leyPais = leyPais;
	}

	public Integer getLeyProvincia() {
		return this.leyProvincia;
	}

	public void setLeyProvincia(Integer leyProvincia) {
		this.leyProvincia = leyProvincia;
	}

	public String getLeyTexto() {
		return this.leyTexto;
	}

	public void setLeyTexto(String leyTexto) {
		this.leyTexto = leyTexto;
	}

	public Integer getLeyTipo() {
		return this.leyTipo;
	}

	public void setLeyTipo(Integer leyTipo) {
		this.leyTipo = leyTipo;
	}

	public String getLeyTitulo() {
		return this.leyTitulo;
	}

	public void setLeyTitulo(String leyTitulo) {
		this.leyTitulo = leyTitulo;
	}

}