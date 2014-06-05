package net.ciespal.redxxi.ejb.persistence.entities.espejo;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the esp_gran_maestro database table.
 * 
 */
@Entity
@Table(name="esp_gran_maestro")
@NamedQuery(name="GranMaestroDTO.findAll", query="SELECT g FROM GranMaestroDTO g")
public class GranMaestroDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ESP_GRAN_MAESTRO_GMACODIGO_GENERATOR", sequenceName="ESP_GRAN_MAESTRO_GMA_CODIGO_SEQ",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ESP_GRAN_MAESTRO_GMACODIGO_GENERATOR")
	@Column(name="gma_codigo")
	private Integer gmaCodigo;

	@Column(name="gma_apellidos")
	private String gmaApellidos;

	@Column(name="gma_ciudad")
	private Integer gmaCiudad;

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

	@Transient
	private String gmaFotoPath;

	@Transient
	private long gmaCount;

	//bi-directional many-to-one association to EntidadDTO
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="gma_entidad")
	private EntidadEspejoDTO espEntidad;

	public GranMaestroDTO() {
	}

	public GranMaestroDTO(long gmaCount) {
		this.gmaCount=gmaCount;
	}

	public Integer getGmaCodigo() {
		return this.gmaCodigo;
	}

	public void setGmaCodigo(Integer gmaCodigo) {
		this.gmaCodigo = gmaCodigo;
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
		return gmaFotoNombre;
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

	public String getGmaFotoPath() {
		return gmaFotoPath;
	}

	public void setGmaFotoPath(String gmaFotoPath) {
		this.gmaFotoPath = gmaFotoPath;
	}

	public long getGmaCount() {
		return gmaCount;
	}

	public void setGmaCount(long gmaCount) {
		this.gmaCount = gmaCount;
	}

	public EntidadEspejoDTO getEspEntidad() {
		return this.espEntidad;
	}

	public void setEspEntidad(EntidadEspejoDTO espEntidad) {
		this.espEntidad = espEntidad;
	}

}