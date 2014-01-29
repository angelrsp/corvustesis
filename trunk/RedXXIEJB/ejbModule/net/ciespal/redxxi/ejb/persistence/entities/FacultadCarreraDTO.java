package net.ciespal.redxxi.ejb.persistence.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ate_facultad_carrera database table.
 * 
 */
@Entity
@Table(name="ate_facultad_carrera")
@NamedQuery(name="FacultadCarreraDTO.findAll", query="SELECT f FROM FacultadCarreraDTO f")
public class FacultadCarreraDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ATE_FACULTAD_CARRERA_FACCODIGO_GENERATOR", sequenceName="ATE_FACULTAD_CARRERA_FAC_CODIGO_SEQ",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ATE_FACULTAD_CARRERA_FACCODIGO_GENERATOR")
	@Column(name="fac_codigo")
	private Integer facCodigo;

	@Column(name="fac_anio_fundacion")
	private Integer facAnioFundacion;

	@Column(name="fac_datos_institucionales")
	private String facDatosInstitucionales;

	@Column(name="fac_miembros_claustro")
	private Integer facMiembrosClaustro;

	@Column(name="fac_nombre")
	private String facNombre;

	@Column(name="fac_tipo")
	private Integer facTipo;

	//bi-directional many-to-one association to EventoDTO
	@OneToMany(mappedBy="ateFacultadCarrera")
	private List<EventoDTO> ateEventos;

	//bi-directional many-to-one association to EntidadDTO
	@ManyToOne
	@JoinColumn(name="fac_entidad")
	private EntidadDTO ateEntidad;

	//bi-directional many-to-one association to FacultadCarreraDTO
	@ManyToOne
	@JoinColumn(name="fac_predecesor")
	private FacultadCarreraDTO ateFacultadCarrera;

	//bi-directional many-to-one association to FacultadCarreraDTO
	@OneToMany(mappedBy="ateFacultadCarrera")
	private List<FacultadCarreraDTO> ateFacultadCarreras;

	//bi-directional many-to-one association to UniversidadDTO
	@ManyToOne
	@JoinColumn(name="fac_universidad")
	private UniversidadDTO ateUniversidad;

	//bi-directional many-to-one association to MencionDTO
	@OneToMany(mappedBy="ateFacultadCarrera")
	private List<MencionDTO> ateMenciones;

	//bi-directional many-to-one association to PublicacionPeriodicaDTO
	@OneToMany(mappedBy="ateFacultadCarrera")
	private List<PublicacionPeriodicaDTO> atePublicacionesPeriodicas;

	public FacultadCarreraDTO() {
	}

	public Integer getFacCodigo() {
		return this.facCodigo;
	}

	public void setFacCodigo(Integer facCodigo) {
		this.facCodigo = facCodigo;
	}

	public Integer getFacAnioFundacion() {
		return this.facAnioFundacion;
	}

	public void setFacAnioFundacion(Integer facAnioFundacion) {
		this.facAnioFundacion = facAnioFundacion;
	}

	public String getFacDatosInstitucionales() {
		return this.facDatosInstitucionales;
	}

	public void setFacDatosInstitucionales(String facDatosInstitucionales) {
		this.facDatosInstitucionales = facDatosInstitucionales;
	}

	public Integer getFacMiembrosClaustro() {
		return this.facMiembrosClaustro;
	}

	public void setFacMiembrosClaustro(Integer facMiembrosClaustro) {
		this.facMiembrosClaustro = facMiembrosClaustro;
	}

	public String getFacNombre() {
		return this.facNombre;
	}

	public void setFacNombre(String facNombre) {
		this.facNombre = facNombre;
	}

	public Integer getFacTipo() {
		return this.facTipo;
	}

	public void setFacTipo(Integer facTipo) {
		this.facTipo = facTipo;
	}

	public List<EventoDTO> getAteEventos() {
		return this.ateEventos;
	}

	public void setAteEventos(List<EventoDTO> ateEventos) {
		this.ateEventos = ateEventos;
	}

	public EventoDTO addAteEvento(EventoDTO ateEvento) {
		getAteEventos().add(ateEvento);
		ateEvento.setAteFacultadCarrera(this);

		return ateEvento;
	}

	public EventoDTO removeAteEvento(EventoDTO ateEvento) {
		getAteEventos().remove(ateEvento);
		ateEvento.setAteFacultadCarrera(null);

		return ateEvento;
	}

	public EntidadDTO getAteEntidad() {
		return this.ateEntidad;
	}

	public void setAteEntidad(EntidadDTO ateEntidad) {
		this.ateEntidad = ateEntidad;
	}

	public FacultadCarreraDTO getAteFacultadCarrera() {
		return this.ateFacultadCarrera;
	}

	public void setAteFacultadCarrera(FacultadCarreraDTO ateFacultadCarrera) {
		this.ateFacultadCarrera = ateFacultadCarrera;
	}

	public List<FacultadCarreraDTO> getAteFacultadCarreras() {
		return this.ateFacultadCarreras;
	}

	public void setAteFacultadCarreras(List<FacultadCarreraDTO> ateFacultadCarreras) {
		this.ateFacultadCarreras = ateFacultadCarreras;
	}

	public FacultadCarreraDTO addAteFacultadCarrera(FacultadCarreraDTO ateFacultadCarrera) {
		getAteFacultadCarreras().add(ateFacultadCarrera);
		ateFacultadCarrera.setAteFacultadCarrera(this);

		return ateFacultadCarrera;
	}

	public FacultadCarreraDTO removeAteFacultadCarrera(FacultadCarreraDTO ateFacultadCarrera) {
		getAteFacultadCarreras().remove(ateFacultadCarrera);
		ateFacultadCarrera.setAteFacultadCarrera(null);

		return ateFacultadCarrera;
	}

	public UniversidadDTO getAteUniversidad() {
		return this.ateUniversidad;
	}

	public void setAteUniversidad(UniversidadDTO ateUniversidad) {
		this.ateUniversidad = ateUniversidad;
	}

	public List<MencionDTO> getAteMenciones() {
		return this.ateMenciones;
	}

	public void setAteMenciones(List<MencionDTO> ateMenciones) {
		this.ateMenciones = ateMenciones;
	}

	public MencionDTO addAteMencione(MencionDTO ateMencione) {
		getAteMenciones().add(ateMencione);
		ateMencione.setAteFacultadCarrera(this);

		return ateMencione;
	}

	public MencionDTO removeAteMencione(MencionDTO ateMencione) {
		getAteMenciones().remove(ateMencione);
		ateMencione.setAteFacultadCarrera(null);

		return ateMencione;
	}

	public List<PublicacionPeriodicaDTO> getAtePublicacionesPeriodicas() {
		return this.atePublicacionesPeriodicas;
	}

	public void setAtePublicacionesPeriodicas(List<PublicacionPeriodicaDTO> atePublicacionesPeriodicas) {
		this.atePublicacionesPeriodicas = atePublicacionesPeriodicas;
	}

	public PublicacionPeriodicaDTO addAtePublicacionesPeriodica(PublicacionPeriodicaDTO atePublicacionesPeriodica) {
		getAtePublicacionesPeriodicas().add(atePublicacionesPeriodica);
		atePublicacionesPeriodica.setAteFacultadCarrera(this);

		return atePublicacionesPeriodica;
	}

	public PublicacionPeriodicaDTO removeAtePublicacionesPeriodica(PublicacionPeriodicaDTO atePublicacionesPeriodica) {
		getAtePublicacionesPeriodicas().remove(atePublicacionesPeriodica);
		atePublicacionesPeriodica.setAteFacultadCarrera(null);

		return atePublicacionesPeriodica;
	}

}