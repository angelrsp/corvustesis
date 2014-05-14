package net.ciespal.redxxi.ejb.persistence.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ate_publicacion_vie database table.
 * 
 */
@Entity
@Table(name="ate_publicacion_vie")
@NamedQuery(name="PublicacionVieDTO.findAll", query="SELECT p FROM PublicacionVieDTO p")
public class PublicacionVieDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="cat_ciudad")
	private String catCiudad;

	@Column(name="cat_pais")
	private String catPais;

	@Column(name="cat_provincia")
	private String catProvincia;

	@Column(name="cat_tipo")
	private String catTipo;

	@Column(name="pub_anio_publicacion")
	private Integer pubAnioPublicacion;

	@Column(name="pub_apellidos")
	private String pubApellidos;

	@Column(name="pub_archivo")
	private byte[] pubArchivo;

	@Column(name="pub_archivo_nombre")
	private String pubArchivoNombre;

	@Column(name="pub_autor")
	private String pubAutor;

	@Column(name="pub_campo_conocimiento")
	private Integer pubCampoConocimiento;

	@Column(name="pub_ciudad")
	private Integer pubCiudad;

	@Id
	@Column(name="pub_codigo")
	private Integer pubCodigo;

	@Column(name="pub_isbn")
	private String pubIsbn;

	@Column(name="pub_nombres")
	private String pubNombres;

	@Column(name="pub_pais")
	private Integer pubPais;

	@Column(name="pub_provincia")
	private Integer pubProvincia;

	@Column(name="pub_resumen")
	private String pubResumen;

	@Column(name="pub_sipnosis")
	private String pubSipnosis;

	@Column(name="pub_tematica")
	private String pubTematica;

	@Column(name="pub_tipo")
	private Integer pubTipo;

	@Column(name="pub_titulo")
	private String pubTitulo;

	@Column(name="pub_titulo_publicacion")
	private String pubTituloPublicacion;

	public PublicacionVieDTO() {
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

	public String getCatTipo() {
		return this.catTipo;
	}

	public void setCatTipo(String catTipo) {
		this.catTipo = catTipo;
	}

	public Integer getPubAnioPublicacion() {
		return this.pubAnioPublicacion;
	}

	public void setPubAnioPublicacion(Integer pubAnioPublicacion) {
		this.pubAnioPublicacion = pubAnioPublicacion;
	}

	public String getPubApellidos() {
		return this.pubApellidos;
	}

	public void setPubApellidos(String pubApellidos) {
		this.pubApellidos = pubApellidos;
	}

	public byte[] getPubArchivo() {
		return this.pubArchivo;
	}

	public void setPubArchivo(byte[] pubArchivo) {
		this.pubArchivo = pubArchivo;
	}

	public String getPubArchivoNombre() {
		return this.pubArchivoNombre;
	}

	public void setPubArchivoNombre(String pubArchivoNombre) {
		this.pubArchivoNombre = pubArchivoNombre;
	}

	public String getPubAutor() {
		return this.pubAutor;
	}

	public void setPubAutor(String pubAutor) {
		this.pubAutor = pubAutor;
	}

	public Integer getPubCampoConocimiento() {
		return this.pubCampoConocimiento;
	}

	public void setPubCampoConocimiento(Integer pubCampoConocimiento) {
		this.pubCampoConocimiento = pubCampoConocimiento;
	}

	public Integer getPubCiudad() {
		return this.pubCiudad;
	}

	public void setPubCiudad(Integer pubCiudad) {
		this.pubCiudad = pubCiudad;
	}

	public Integer getPubCodigo() {
		return this.pubCodigo;
	}

	public void setPubCodigo(Integer pubCodigo) {
		this.pubCodigo = pubCodigo;
	}

	public String getPubIsbn() {
		return this.pubIsbn;
	}

	public void setPubIsbn(String pubIsbn) {
		this.pubIsbn = pubIsbn;
	}

	public String getPubNombres() {
		return this.pubNombres;
	}

	public void setPubNombres(String pubNombres) {
		this.pubNombres = pubNombres;
	}

	public Integer getPubPais() {
		return this.pubPais;
	}

	public void setPubPais(Integer pubPais) {
		this.pubPais = pubPais;
	}

	public Integer getPubProvincia() {
		return this.pubProvincia;
	}

	public void setPubProvincia(Integer pubProvincia) {
		this.pubProvincia = pubProvincia;
	}

	public String getPubResumen() {
		return this.pubResumen;
	}

	public void setPubResumen(String pubResumen) {
		this.pubResumen = pubResumen;
	}

	public String getPubSipnosis() {
		return this.pubSipnosis;
	}

	public void setPubSipnosis(String pubSipnosis) {
		this.pubSipnosis = pubSipnosis;
	}

	public String getPubTematica() {
		return this.pubTematica;
	}

	public void setPubTematica(String pubTematica) {
		this.pubTematica = pubTematica;
	}

	public Integer getPubTipo() {
		return this.pubTipo;
	}

	public void setPubTipo(Integer pubTipo) {
		this.pubTipo = pubTipo;
	}

	public String getPubTitulo() {
		return this.pubTitulo;
	}

	public void setPubTitulo(String pubTitulo) {
		this.pubTitulo = pubTitulo;
	}

	public String getPubTituloPublicacion() {
		return this.pubTituloPublicacion;
	}

	public void setPubTituloPublicacion(String pubTituloPublicacion) {
		this.pubTituloPublicacion = pubTituloPublicacion;
	}

}