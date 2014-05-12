package net.ciespal.redxxi.ejb.persistence.entities.argos;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the arg_veeduria database table.
 * 
 */
@Entity
@Table(name="arg_veeduria")
@NamedQuery(name="VeeduriaDTO.findAll", query="SELECT v FROM VeeduriaDTO v")
public class VeeduriaDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ARG_VEEDURIA_VEECODIGO_GENERATOR", sequenceName="ARG_VEEDURIA_VEE_CODIGO_SEQ",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ARG_VEEDURIA_VEECODIGO_GENERATOR")
	@Column(name="vee_codigo")
	private Integer veeCodigo;

	@Column(name="vee_actividad_princiapl")
	private String veeActividadPrinciapl;

	@Column(name="vee_anio_fundacion")
	private Integer veeAnioFundacion;

	@Column(name="vee_ciudad")
	private Integer veeCiudad;

	@Column(name="vee_dato_institucional")
	private String veeDatoInstitucional;

	@Column(name="vee_institucion_patrocinadora")
	private String veeInstitucionPatrocinadora;

	@Column(name="vee_linea_tematica")
	private String veeLineaTematica;

	@Column(name="vee_mision")
	private String veeMision;

	@Column(name="vee_nombre")
	private String veeNombre;

	@Column(name="vee_pais")
	private Integer veePais;

	@Column(name="vee_provincia")
	private Integer veeProvincia;

	@Transient
	private Long veeCount;
	
	//bi-directional many-to-one association to EntidadDTO
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="vee_entidad")
	private EntidadArgosDTO argEntidad;

	public VeeduriaDTO() {
	}

	public VeeduriaDTO(Long veeCount) {
		this.veeCount=veeCount;
	}

	
	public Integer getVeeCodigo() {
		return this.veeCodigo;
	}

	public void setVeeCodigo(Integer veeCodigo) {
		this.veeCodigo = veeCodigo;
	}

	public String getVeeActividadPrinciapl() {
		return this.veeActividadPrinciapl;
	}

	public void setVeeActividadPrinciapl(String veeActividadPrinciapl) {
		this.veeActividadPrinciapl = veeActividadPrinciapl;
	}

	public Integer getVeeAnioFundacion() {
		return this.veeAnioFundacion;
	}

	public void setVeeAnioFundacion(Integer veeAnioFundacion) {
		this.veeAnioFundacion = veeAnioFundacion;
	}

	public Integer getVeeCiudad() {
		return this.veeCiudad;
	}

	public void setVeeCiudad(Integer veeCiudad) {
		this.veeCiudad = veeCiudad;
	}

	public String getVeeDatoInstitucional() {
		return this.veeDatoInstitucional;
	}

	public void setVeeDatoInstitucional(String veeDatoInstitucional) {
		this.veeDatoInstitucional = veeDatoInstitucional;
	}

	public String getVeeInstitucionPatrocinadora() {
		return this.veeInstitucionPatrocinadora;
	}

	public void setVeeInstitucionPatrocinadora(String veeInstitucionPatrocinadora) {
		this.veeInstitucionPatrocinadora = veeInstitucionPatrocinadora;
	}

	public String getVeeLineaTematica() {
		return this.veeLineaTematica;
	}

	public void setVeeLineaTematica(String veeLineaTematica) {
		this.veeLineaTematica = veeLineaTematica;
	}

	public String getVeeMision() {
		return this.veeMision;
	}

	public void setVeeMision(String veeMision) {
		this.veeMision = veeMision;
	}

	public String getVeeNombre() {
		return this.veeNombre;
	}

	public void setVeeNombre(String veeNombre) {
		this.veeNombre = veeNombre;
	}

	public Integer getVeePais() {
		return this.veePais;
	}

	public void setVeePais(Integer veePais) {
		this.veePais = veePais;
	}

	public Integer getVeeProvincia() {
		return this.veeProvincia;
	}

	public void setVeeProvincia(Integer veeProvincia) {
		this.veeProvincia = veeProvincia;
	}

	public EntidadArgosDTO getArgEntidad() {
		return this.argEntidad;
	}

	public void setArgEntidad(EntidadArgosDTO argEntidad) {
		this.argEntidad = argEntidad;
	}

	public Long getVeeCount() {
		return veeCount;
	}

	public void setVeeCount(Long veeCount) {
		this.veeCount = veeCount;
	}

}