package net.ciespal.redxxi.ejb.persistence.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ate_carrera database table.
 * 
 */
@Entity
@Table(name="ate_carrera")
@NamedQuery(name="CarreraDTO.findAll", query="SELECT c FROM CarreraDTO c")
public class CarreraDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ATE_CARRERA_CARCODIGO_GENERATOR", sequenceName="ATE_CARRERA_CAR_CODIGO_SEQ",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ATE_CARRERA_CARCODIGO_GENERATOR")
	@Column(name="car_codigo")
	private Integer carCodigo;

	@Column(name="car_alumno")
	private Integer carAlumno;

	@Column(name="car_modalidad")
	private Integer carModalidad;

	@Column(name="car_perfil")
	private String carPerfil;

	@Column(name="car_profesor")
	private Integer carProfesor;

	@Column(name="car_requisitos")
	private String carRequisitos;

	@Column(name="car_tipo")
	private Integer carTipo;

	@Column(name="car_titulo")
	private Integer carTitulo;

	//bi-directional many-to-one association to CentroDTO
	@ManyToOne
	@JoinColumn(name="car_centro")
	private CentroDTO ateCentro;

	//bi-directional many-to-one association to EntidadDTO
	@OneToMany(mappedBy="ateCarrera",cascade={CascadeType.ALL},fetch=FetchType.EAGER)
	private List<EntidadDTO> ateEntidads;

	//bi-directional many-to-one association to MencionDTO
	@OneToMany(mappedBy="ateCarrera")
	private List<MencionDTO> ateMenciones;

	public CarreraDTO() {
	}

	public Integer getCarCodigo() {
		return this.carCodigo;
	}

	public void setCarCodigo(Integer carCodigo) {
		this.carCodigo = carCodigo;
	}

	public Integer getCarAlumno() {
		return this.carAlumno;
	}

	public void setCarAlumno(Integer carAlumno) {
		this.carAlumno = carAlumno;
	}

	public Integer getCarModalidad() {
		return this.carModalidad;
	}

	public void setCarModalidad(Integer carModalidad) {
		this.carModalidad = carModalidad;
	}

	public String getCarPerfil() {
		return this.carPerfil;
	}

	public void setCarPerfil(String carPerfil) {
		this.carPerfil = carPerfil;
	}

	public Integer getCarProfesor() {
		return this.carProfesor;
	}

	public void setCarProfesor(Integer carProfesor) {
		this.carProfesor = carProfesor;
	}

	public String getCarRequisitos() {
		return this.carRequisitos;
	}

	public void setCarRequisitos(String carRequisitos) {
		this.carRequisitos = carRequisitos;
	}

	public Integer getCarTipo() {
		return this.carTipo;
	}

	public void setCarTipo(Integer carTipo) {
		this.carTipo = carTipo;
	}

	public Integer getCarTitulo() {
		return this.carTitulo;
	}

	public void setCarTitulo(Integer carTitulo) {
		this.carTitulo = carTitulo;
	}

	public CentroDTO getAteCentro() {
		return this.ateCentro;
	}

	public void setAteCentro(CentroDTO ateCentro) {
		this.ateCentro = ateCentro;
	}

	public List<EntidadDTO> getAteEntidads() {
		return this.ateEntidads;
	}

	public void setAteEntidads(List<EntidadDTO> ateEntidads) {
		this.ateEntidads = ateEntidads;
	}

	public EntidadDTO addAteEntidad(EntidadDTO ateEntidad) {
		getAteEntidads().add(ateEntidad);
		ateEntidad.setAteCarrera(this);

		return ateEntidad;
	}

	public EntidadDTO removeAteEntidad(EntidadDTO ateEntidad) {
		getAteEntidads().remove(ateEntidad);
		ateEntidad.setAteCarrera(null);

		return ateEntidad;
	}

	public List<MencionDTO> getAteMenciones() {
		return this.ateMenciones;
	}

	public void setAteMenciones(List<MencionDTO> ateMenciones) {
		this.ateMenciones = ateMenciones;
	}

	public MencionDTO addAteMencione(MencionDTO ateMencione) {
		getAteMenciones().add(ateMencione);
		ateMencione.setAteCarrera(this);

		return ateMencione;
	}

	public MencionDTO removeAteMencione(MencionDTO ateMencione) {
		getAteMenciones().remove(ateMencione);
		ateMencione.setAteCarrera(null);

		return ateMencione;
	}

}