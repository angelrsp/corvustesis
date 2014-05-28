package net.ciespal.redxxi.ejb.persistence.entities.espejo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the esp_etica database table.
 * 
 */
@Entity
@Table(name="esp_etica")
@NamedQuery(name="EticaDTO.findAll", query="SELECT e FROM EticaDTO e")
public class EticaDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ESP_ETICA_ETICODIGO_GENERATOR", sequenceName="ESP_ETICA_ETI_CODIGO_SEQ",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ESP_ETICA_ETICODIGO_GENERATOR")
	@Column(name="eti_codigo")
	private Integer etiCodigo;

	@Column(name="eti_anio")
	private Integer etiAnio;

	@Column(name="eti_autor_apellido")
	private String etiAutorApellido;

	@Column(name="eti_autor_nombre")
	private String etiAutorNombre;

	@Column(name="eti_biografia")
	private String etiBiografia;

	@Column(name="eti_ciudad")
	private Integer etiCiudad;

	@Column(name="eti_genero_obra")
	private String etiGeneroObra;

	@Column(name="eti_pais")
	private Integer etiPais;

	@Column(name="eti_provincia")
	private Integer etiProvincia;

	@Column(name="eti_texto")
	private String etiTexto;

	@Column(name="eti_archivo")
	private byte[] etiArchivo;

	@Column(name="eti_archivo_nombre")
	private String etiArchivoNombre;
	
	@Transient
	private String etiArchivoPath;
	
	@Transient
	private long etiCount;
	
	@Column(name="eti_titulo_obra")
	private String etiTituloObra;

	//bi-directional many-to-one association to EntidadDTO
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="eti_entidad")
	private EntidadEspejoDTO espEntidad;

	public EticaDTO() {
	}
	
	public EticaDTO(long etiCount){
		this.etiCount=etiCount;
	}

	public Integer getEtiCodigo() {
		return this.etiCodigo;
	}

	public void setEtiCodigo(Integer etiCodigo) {
		this.etiCodigo = etiCodigo;
	}

	public Integer getEtiAnio() {
		return this.etiAnio;
	}

	public void setEtiAnio(Integer etiAnio) {
		this.etiAnio = etiAnio;
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

	public byte[] getEtiArchivo() {
		return this.etiArchivo;
	}

	public void setEtiArchivo(byte[] etiArchivo) {
		this.etiArchivo = etiArchivo;
	}

	public String getEtiArchivoNombre() {
		return etiArchivoNombre;
	}

	public void setEtiArchivoNombre(String etiArchivoNombre) {
		this.etiArchivoNombre = etiArchivoNombre;
	}

	public String getEtiArchivoPath() {
		return etiArchivoPath;
	}

	public void setEtiArchivoPath(String etiArchivoPath) {
		this.etiArchivoPath = etiArchivoPath;
	}

	public long getEtiCount() {
		return etiCount;
	}

	public void setEtiCount(long etiCount) {
		this.etiCount = etiCount;
	}

	public String getEtiTituloObra() {
		return this.etiTituloObra;
	}

	public void setEtiTituloObra(String etiTituloObra) {
		this.etiTituloObra = etiTituloObra;
	}

	public EntidadEspejoDTO getEspEntidad() {
		return this.espEntidad;
	}

	public void setEspEntidad(EntidadEspejoDTO espEntidad) {
		this.espEntidad = espEntidad;
	}

}