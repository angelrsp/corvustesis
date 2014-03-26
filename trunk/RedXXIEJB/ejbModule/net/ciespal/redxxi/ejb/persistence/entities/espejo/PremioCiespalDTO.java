package net.ciespal.redxxi.ejb.persistence.entities.espejo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the esp_premio_ciespal database table.
 * 
 */
@Entity
@Table(name="esp_premio_ciespal")
@NamedQuery(name="PremioCiespalDTO.findAll", query="SELECT p FROM PremioCiespalDTO p")
public class PremioCiespalDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ESP_PREMIO_CIESPAL_PCICODIGO_GENERATOR", sequenceName="ESP_PREMIO_CIESPAL_PCI_CODIGO_SEQ",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ESP_PREMIO_CIESPAL_PCICODIGO_GENERATOR")
	@Column(name="pci_codigo")
	private Integer pciCodigo;

	@Column(name="pci_anio")
	private Integer pciAnio;

	@Column(name="pci_apellido_autor")
	private String pciApellidoAutor;

	@Column(name="pci_ciudad")
	private Integer pciCiudad;

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

	//bi-directional many-to-one association to EntidadDTO
	@ManyToOne
	@JoinColumn(name="pci_entidad")
	private EntidadEspejoDTO espEntidad;

	public PremioCiespalDTO() {
	}

	public Integer getPciCodigo() {
		return this.pciCodigo;
	}

	public void setPciCodigo(Integer pciCodigo) {
		this.pciCodigo = pciCodigo;
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

	public Integer getPciCiudad() {
		return this.pciCiudad;
	}

	public void setPciCiudad(Integer pciCiudad) {
		this.pciCiudad = pciCiudad;
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

	public EntidadEspejoDTO getEspEntidad() {
		return this.espEntidad;
	}

	public void setEspEntidad(EntidadEspejoDTO espEntidad) {
		this.espEntidad = espEntidad;
	}

}