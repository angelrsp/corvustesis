package net.ciespal.redxxi.ejb.persistence.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ate_entidad database table.
 * 
 */
@Entity
@Table(name="ate_entidad")
@NamedQuery(name="EntidadDTO.findAll", query="SELECT e FROM EntidadDTO e")
public class EntidadDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ATE_ENTIDAD_ENTCODIGO_GENERATOR", sequenceName="ATE_ENTIDAD_ENT_CODIGO_SEQ",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ATE_ENTIDAD_ENTCODIGO_GENERATOR")
	@Column(name="ent_codigo")
	private Integer entCodigo;

	//bi-directional many-to-one association to ContactoDTO
	@OneToMany(mappedBy="ateEntidad")
	private List<ContactoDTO> ateContactos;

	//bi-directional many-to-one association to DoctorDTO
	@OneToMany(mappedBy="ateEntidad")
	private List<DoctorDTO> ateDoctors;

	//bi-directional many-to-one association to UbicacionDTO
	@ManyToOne
	@JoinColumn(name="ent_ubicacion")
	private UbicacionDTO ateUbicacion;

	//bi-directional many-to-one association to FacultadCarreraDTO
	@OneToMany(mappedBy="ateEntidad")
	private List<FacultadCarreraDTO> ateFacultadCarreras;

	//bi-directional many-to-one association to NoticiaDTO
	@OneToMany(mappedBy="ateEntidad")
	private List<NoticiaDTO> ateNoticias;

	//bi-directional many-to-one association to OrganizacionDTO
	@OneToMany(mappedBy="ateEntidad")
	private List<OrganizacionDTO> ateOrganizacions;

	//bi-directional many-to-one association to ProyectosInvestigacionDTO
	@OneToMany(mappedBy="ateEntidad")
	private List<ProyectosInvestigacionDTO> ateProyectosInvestigacions;

	//bi-directional many-to-one association to PublicacionDTO
	@OneToMany(mappedBy="ateEntidad")
	private List<PublicacionDTO> atePublicacions;

	public EntidadDTO() {
	}

	public Integer getEntCodigo() {
		return this.entCodigo;
	}

	public void setEntCodigo(Integer entCodigo) {
		this.entCodigo = entCodigo;
	}

	public List<ContactoDTO> getAteContactos() {
		return this.ateContactos;
	}

	public void setAteContactos(List<ContactoDTO> ateContactos) {
		this.ateContactos = ateContactos;
	}

	public ContactoDTO addAteContacto(ContactoDTO ateContacto) {
		getAteContactos().add(ateContacto);
		ateContacto.setAteEntidad(this);

		return ateContacto;
	}

	public ContactoDTO removeAteContacto(ContactoDTO ateContacto) {
		getAteContactos().remove(ateContacto);
		ateContacto.setAteEntidad(null);

		return ateContacto;
	}

	public List<DoctorDTO> getAteDoctors() {
		return this.ateDoctors;
	}

	public void setAteDoctors(List<DoctorDTO> ateDoctors) {
		this.ateDoctors = ateDoctors;
	}

	public DoctorDTO addAteDoctor(DoctorDTO ateDoctor) {
		getAteDoctors().add(ateDoctor);
		ateDoctor.setAteEntidad(this);

		return ateDoctor;
	}

	public DoctorDTO removeAteDoctor(DoctorDTO ateDoctor) {
		getAteDoctors().remove(ateDoctor);
		ateDoctor.setAteEntidad(null);

		return ateDoctor;
	}

	public UbicacionDTO getAteUbicacion() {
		return this.ateUbicacion;
	}

	public void setAteUbicacion(UbicacionDTO ateUbicacion) {
		this.ateUbicacion = ateUbicacion;
	}

	public List<FacultadCarreraDTO> getAteFacultadCarreras() {
		return this.ateFacultadCarreras;
	}

	public void setAteFacultadCarreras(List<FacultadCarreraDTO> ateFacultadCarreras) {
		this.ateFacultadCarreras = ateFacultadCarreras;
	}

	public FacultadCarreraDTO addAteFacultadCarrera(FacultadCarreraDTO ateFacultadCarrera) {
		getAteFacultadCarreras().add(ateFacultadCarrera);
		ateFacultadCarrera.setAteEntidad(this);

		return ateFacultadCarrera;
	}

	public FacultadCarreraDTO removeAteFacultadCarrera(FacultadCarreraDTO ateFacultadCarrera) {
		getAteFacultadCarreras().remove(ateFacultadCarrera);
		ateFacultadCarrera.setAteEntidad(null);

		return ateFacultadCarrera;
	}

	public List<NoticiaDTO> getAteNoticias() {
		return this.ateNoticias;
	}

	public void setAteNoticias(List<NoticiaDTO> ateNoticias) {
		this.ateNoticias = ateNoticias;
	}

	public NoticiaDTO addAteNoticia(NoticiaDTO ateNoticia) {
		getAteNoticias().add(ateNoticia);
		ateNoticia.setAteEntidad(this);

		return ateNoticia;
	}

	public NoticiaDTO removeAteNoticia(NoticiaDTO ateNoticia) {
		getAteNoticias().remove(ateNoticia);
		ateNoticia.setAteEntidad(null);

		return ateNoticia;
	}

	public List<OrganizacionDTO> getAteOrganizacions() {
		return this.ateOrganizacions;
	}

	public void setAteOrganizacions(List<OrganizacionDTO> ateOrganizacions) {
		this.ateOrganizacions = ateOrganizacions;
	}

	public OrganizacionDTO addAteOrganizacion(OrganizacionDTO ateOrganizacion) {
		getAteOrganizacions().add(ateOrganizacion);
		ateOrganizacion.setAteEntidad(this);

		return ateOrganizacion;
	}

	public OrganizacionDTO removeAteOrganizacion(OrganizacionDTO ateOrganizacion) {
		getAteOrganizacions().remove(ateOrganizacion);
		ateOrganizacion.setAteEntidad(null);

		return ateOrganizacion;
	}

	public List<ProyectosInvestigacionDTO> getAteProyectosInvestigacions() {
		return this.ateProyectosInvestigacions;
	}

	public void setAteProyectosInvestigacions(List<ProyectosInvestigacionDTO> ateProyectosInvestigacions) {
		this.ateProyectosInvestigacions = ateProyectosInvestigacions;
	}

	public ProyectosInvestigacionDTO addAteProyectosInvestigacion(ProyectosInvestigacionDTO ateProyectosInvestigacion) {
		getAteProyectosInvestigacions().add(ateProyectosInvestigacion);
		ateProyectosInvestigacion.setAteEntidad(this);

		return ateProyectosInvestigacion;
	}

	public ProyectosInvestigacionDTO removeAteProyectosInvestigacion(ProyectosInvestigacionDTO ateProyectosInvestigacion) {
		getAteProyectosInvestigacions().remove(ateProyectosInvestigacion);
		ateProyectosInvestigacion.setAteEntidad(null);

		return ateProyectosInvestigacion;
	}

	public List<PublicacionDTO> getAtePublicacions() {
		return this.atePublicacions;
	}

	public void setAtePublicacions(List<PublicacionDTO> atePublicacions) {
		this.atePublicacions = atePublicacions;
	}

	public PublicacionDTO addAtePublicacion(PublicacionDTO atePublicacion) {
		getAtePublicacions().add(atePublicacion);
		atePublicacion.setAteEntidad(this);

		return atePublicacion;
	}

	public PublicacionDTO removeAtePublicacion(PublicacionDTO atePublicacion) {
		getAtePublicacions().remove(atePublicacion);
		atePublicacion.setAteEntidad(null);

		return atePublicacion;
	}

}