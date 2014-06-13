package net.ciespal.redxxi.ejb.persistence.entities.espejo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the esp_etica_vie database table.
 * 
 */
@Entity
@Table(name="esp_etica_vie")
@NamedQuery(name="EticaVieDTO.findAll", query="SELECT e FROM EticaVieDTO e")
public class EticaVieDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="cat_pais")
	private String catPais;

	@Column(name="eti_anio")
	private Integer etiAnio;

	@Column(name="eti_archivo")
	private byte[] etiArchivo;

	@Column(name="eti_archivo_nombre")
	private String etiArchivoNombre;

	@Column(name="eti_autor_apellido")
	private String etiAutorApellido;

	@Column(name="eti_autor_nombre")
	private String etiAutorNombre;

	@Column(name="eti_biografia")
	private String etiBiografia;

	@Column(name="eti_ciudad")
	private Integer etiCiudad;

	@Id
	@Column(name="eti_codigo")
	private Integer etiCodigo;

	@Column(name="eti_entidad")
	private Integer etiEntidad;

	@Column(name="eti_genero_obra")
	private String etiGeneroObra;

	@Column(name="eti_pais")
	private Integer etiPais;

	@Column(name="eti_provincia")
	private Integer etiProvincia;

	@Column(name="eti_texto")
	private String etiTexto;

	@Column(name="eti_titulo_obra")
	private String etiTituloObra;

	public EticaVieDTO() {
	}

	public String getCatPais() {
		return this.catPais;
	}

	public void setCatPais(String catPais) {
		this.catPais = catPais;
	}

	public Integer getEtiAnio() {
		return this.etiAnio;
	}

	public void setEtiAnio(Integer etiAnio) {
		this.etiAnio = etiAnio;
	}

	public byte[] getEtiArchivo() {
		return this.etiArchivo;
	}

	public void setEtiArchivo(byte[] etiArchivo) {
		this.etiArchivo = etiArchivo;
	}

	public String getEtiArchivoNombre() {
		return this.etiArchivoNombre;
	}

	public void setEtiArchivoNombre(String etiArchivoNombre) {
		this.etiArchivoNombre = etiArchivoNombre;
	}

	public String getEtiAutorApellido() {
		return this.etiAutorApellido;
	}

	public void setEtiAutorApellido(String etiAutorApellido) {
		this.etiAutorApellido = etiAutorApellido;
	}

	public String getEtiAutorNombre() {
		return this.etiAutorNombre;
	}

	public void setEtiAutorNombre(String etiAutorNombre) {
		this.etiAutorNombre = etiAutorNombre;
	}

	public String getEtiBiografia() {
		return this.etiBiografia;
	}

	public void setEtiBiografia(String etiBiografia) {
		this.etiBiografia = etiBiografia;
	}

	public Integer getEtiCiudad() {
		return this.etiCiudad;
	}

	public void setEtiCiudad(Integer etiCiudad) {
		this.etiCiudad = etiCiudad;
	}

	public Integer getEtiCodigo() {
		return this.etiCodigo;
	}

	public void setEtiCodigo(Integer etiCodigo) {
		this.etiCodigo = etiCodigo;
	}

	public Integer getEtiEntidad() {
		return this.etiEntidad;
	}

	public void setEtiEntidad(Integer etiEntidad) {
		this.etiEntidad = etiEntidad;
	}

	public String getEtiGeneroObra() {
		return this.etiGeneroObra;
	}

	public void setEtiGeneroObra(String etiGeneroObra) {
		this.etiGeneroObra = etiGeneroObra;
	}

	public Integer getEtiPais() {
		return this.etiPais;
	}

	public void setEtiPais(Integer etiPais) {
		this.etiPais = etiPais;
	}

	public Integer getEtiProvincia() {
		return this.etiProvincia;
	}

	public void setEtiProvincia(Integer etiProvincia) {
		this.etiProvincia = etiProvincia;
	}

	public String getEtiTexto() {
		return this.etiTexto;
	}

	public void setEtiTexto(String etiTexto) {
		this.etiTexto = etiTexto;
	}

	public String getEtiTituloObra() {
		return this.etiTituloObra;
	}

	public void setEtiTituloObra(String etiTituloObra) {
		this.etiTituloObra = etiTituloObra;
	}

}