package net.ciespal.redxxi.ejb.persistence.entities.argos;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the arg_observatorio database table.
 * 
 */
@Entity
@Table(name="arg_observatorio")
@NamedQuery(name="ObservatorioDTO.findAll", query="SELECT o FROM ObservatorioDTO o")
public class ObservatorioDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ARG_OBSERVATORIO_OBSCODIGO_GENERATOR", sequenceName="ARG_OBSERVATORIO_OBS_CODIGO_SEQ",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ARG_OBSERVATORIO_OBSCODIGO_GENERATOR")
	@Column(name="obs_codigo")
	private Integer obsCodigo;

	@Column(name="obs_actividades_principales")
	private String obsActividadesPrincipales;

	@Column(name="obs_anio_fundacion")
	private Integer obsAnioFundacion;

	@Column(name="obs_ciudad")
	private Integer obsCiudad;

	@Column(name="obs_datos_institucionales")
	private String obsDatosInstitucionales;

	@Column(name="obs_institucion_patrocinadora")
	private String obsInstitucionPatrocinadora;

	@Column(name="obs_linea_tematica")
	private String obsLineaTematica;

	@Column(name="obs_mision")
	private String obsMision;

	@Column(name="obs_nombre")
	private String obsNombre;

	@Column(name="obs_pais")
	private Integer obsPais;

	@Column(name="obs_provincia")
	private Integer obsProvincia;

	@Transient
	private Long obsCount;

	
	//bi-directional many-to-one association to EntidadDTO
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="obs_entidad")
	private EntidadArgosDTO argEntidad;

	//bi-directional many-to-one association to RedDTO
	@ManyToOne
	@JoinColumn(name="obs_red")
	private RedDTO argRed;

	public ObservatorioDTO() {
	}

	public ObservatorioDTO(Long obsCount)
	{
		this.obsCount=obsCount;
	}
	
	public Integer getObsCodigo() {
		return this.obsCodigo;
	}

	public void setObsCodigo(Integer obsCodigo) {
		this.obsCodigo = obsCodigo;
	}

	public String getObsActividadesPrincipales() {
		return this.obsActividadesPrincipales;
	}

	public void setObsActividadesPrincipales(String obsActividadesPrincipales) {
		this.obsActividadesPrincipales = obsActividadesPrincipales;
	}

	public Integer getObsAnioFundacion() {
		return this.obsAnioFundacion;
	}

	public void setObsAnioFundacion(Integer obsAnioFundacion) {
		this.obsAnioFundacion = obsAnioFundacion;
	}

	public Integer getObsCiudad() {
		return this.obsCiudad;
	}

	public void setObsCiudad(Integer obsCiudad) {
		this.obsCiudad = obsCiudad;
	}

	public String getObsDatosInstitucionales() {
		return this.obsDatosInstitucionales;
	}

	public void setObsDatosInstitucionales(String obsDatosInstitucionales) {
		this.obsDatosInstitucionales = obsDatosInstitucionales;
	}

	public String getObsInstitucionPatrocinadora() {
		return this.obsInstitucionPatrocinadora;
	}

	public void setObsInstitucionPatrocinadora(String obsInstitucionPatrocinadora) {
		this.obsInstitucionPatrocinadora = obsInstitucionPatrocinadora;
	}

	public String getObsLineaTematica() {
		return this.obsLineaTematica;
	}

	public void setObsLineaTematica(String obsLineaTematica) {
		this.obsLineaTematica = obsLineaTematica;
	}

	public String getObsMision() {
		return this.obsMision;
	}

	public void setObsMision(String obsMision) {
		this.obsMision = obsMision;
	}

	public String getObsNombre() {
		return this.obsNombre;
	}

	public void setObsNombre(String obsNombre) {
		this.obsNombre = obsNombre;
	}

	public Integer getObsPais() {
		return this.obsPais;
	}

	public void setObsPais(Integer obsPais) {
		this.obsPais = obsPais;
	}

	public Integer getObsProvincia() {
		return this.obsProvincia;
	}

	public void setObsProvincia(Integer obsProvincia) {
		this.obsProvincia = obsProvincia;
	}

	public EntidadArgosDTO getArgEntidad() {
		return this.argEntidad;
	}

	public void setArgEntidad(EntidadArgosDTO argEntidad) {
		this.argEntidad = argEntidad;
	}

	public RedDTO getArgRed() {
		return this.argRed;
	}

	public Long getObsCount() {
		return obsCount;
	}

	public void setObsCount(Long obsCount) {
		this.obsCount = obsCount;
	}

	public void setArgRed(RedDTO argRed) {
		this.argRed = argRed;
	}

}