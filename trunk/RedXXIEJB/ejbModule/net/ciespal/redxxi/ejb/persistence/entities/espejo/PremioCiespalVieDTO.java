package net.ciespal.redxxi.ejb.persistence.entities.espejo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the esp_premio_ciespal_vie database table.
 * 
 */
@Entity
@Table(name="esp_premio_ciespal_vie")
@NamedQuery(name="PremioCiespalVieDTO.findAll", query="SELECT p FROM PremioCiespalVieDTO p")
public class PremioCiespalVieDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="cat_ciudad")
	private String catCiudad;

	@Column(name="cat_medio")
	private String catMedio;

	@Column(name="cat_pais")
	private String catPais;

	@Column(name="cat_provincia")
	private String catProvincia;

	@Column(name="pci_anio")
	private Integer pciAnio;

	@Column(name="pci_apellido_autor")
	private String pciApellidoAutor;

	@Column(name="pci_archivo")
	private byte[] pciArchivo;

	@Column(name="pci_archivo_nombre")
	private String pciArchivoNombre;

	@Column(name="pci_ciudad")
	private Integer pciCiudad;

	@Id
	@Column(name="pci_codigo")
	private Integer pciCodigo;

	@Column(name="pci_entidad")
	private Integer pciEntidad;

	@Column(name="pci_genero")
	private String pciGenero;

	@Column(name="pci_medio")
	private Integer pciMedio;

	@Column(name="pci_muestra_obra")
	private String pciMuestraObra;

	@Column(name="pci_nombre_autor")
	private String pciNombreAutor;

	@Column(name="pci_obra_autor")
	private String pciObraAutor;

	@Column(name="pci_pais")
	private Integer pciPais;

	@Column(name="pci_premio_instituido")
	private String pciPremioInstituido;

	@Column(name="pci_provincia")
	private Integer pciProvincia;

	@Column(name="pci_titulo")
	private String pciTitulo;

	public PremioCiespalVieDTO() {
	}

	public String getCatCiudad() {
		return this.catCiudad;
	}

	public void setCatCiudad(String catCiudad) {
		this.catCiudad = catCiudad;
	}

	public String getCatMedio() {
		return this.catMedio;
	}

	public void setCatMedio(String catMedio) {
		this.catMedio = catMedio;
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

	public Integer getPciAnio() {
		return this.pciAnio;
	}

	public void setPciAnio(Integer pciAnio) {
		this.pciAnio = pciAnio;
	}

	public String getPciApellidoAutor() {
		return this.pciApellidoAutor;
	}

	public void setPciApellidoAutor(String pciApellidoAutor) {
		this.pciApellidoAutor = pciApellidoAutor;
	}

	public byte[] getPciArchivo() {
		return this.pciArchivo;
	}

	public void setPciArchivo(byte[] pciArchivo) {
		this.pciArchivo = pciArchivo;
	}

	public String getPciArchivoNombre() {
		return this.pciArchivoNombre;
	}

	public void setPciArchivoNombre(String pciArchivoNombre) {
		this.pciArchivoNombre = pciArchivoNombre;
	}

	public Integer getPciCiudad() {
		return this.pciCiudad;
	}

	public void setPciCiudad(Integer pciCiudad) {
		this.pciCiudad = pciCiudad;
	}

	public Integer getPciCodigo() {
		return this.pciCodigo;
	}

	public void setPciCodigo(Integer pciCodigo) {
		this.pciCodigo = pciCodigo;
	}

	public Integer getPciEntidad() {
		return this.pciEntidad;
	}

	public void setPciEntidad(Integer pciEntidad) {
		this.pciEntidad = pciEntidad;
	}

	public String getPciGenero() {
		return this.pciGenero;
	}

	public void setPciGenero(String pciGenero) {
		this.pciGenero = pciGenero;
	}

	public Integer getPciMedio() {
		return this.pciMedio;
	}

	public void setPciMedio(Integer pciMedio) {
		this.pciMedio = pciMedio;
	}

	public String getPciMuestraObra() {
		return this.pciMuestraObra;
	}

	public void setPciMuestraObra(String pciMuestraObra) {
		this.pciMuestraObra = pciMuestraObra;
	}

	public String getPciNombreAutor() {
		return this.pciNombreAutor;
	}

	public void setPciNombreAutor(String pciNombreAutor) {
		this.pciNombreAutor = pciNombreAutor;
	}

	public String getPciObraAutor() {
		return this.pciObraAutor;
	}

	public void setPciObraAutor(String pciObraAutor) {
		this.pciObraAutor = pciObraAutor;
	}

	public Integer getPciPais() {
		return this.pciPais;
	}

	public void setPciPais(Integer pciPais) {
		this.pciPais = pciPais;
	}

	public String getPciPremioInstituido() {
		return this.pciPremioInstituido;
	}

	public void setPciPremioInstituido(String pciPremioInstituido) {
		this.pciPremioInstituido = pciPremioInstituido;
	}

	public Integer getPciProvincia() {
		return this.pciProvincia;
	}

	public void setPciProvincia(Integer pciProvincia) {
		this.pciProvincia = pciProvincia;
	}

	public String getPciTitulo() {
		return this.pciTitulo;
	}

	public void setPciTitulo(String pciTitulo) {
		this.pciTitulo = pciTitulo;
	}

}