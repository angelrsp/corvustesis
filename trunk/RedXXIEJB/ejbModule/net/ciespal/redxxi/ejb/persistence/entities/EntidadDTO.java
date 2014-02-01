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
	@SequenceGenerator(name="ATE_ENTIDAD_ENTCODIGO_GENERATOR", sequenceName="ATE_ENTIDAD_ENT_CODIGO_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ATE_ENTIDAD_ENTCODIGO_GENERATOR")
	@Column(name="ent_codigo")
	private Integer entCodigo;

	//bi-directional many-to-one association to CentroDTO
	@OneToMany(mappedBy="ateEntidad")
	private List<CentroDTO> ateCentros;

	//bi-directional many-to-one association to ContactoDTO
	@OneToMany(mappedBy="ateEntidad")
	private List<ContactoDTO> ateContactos;

	//bi-directional many-to-one association to DoctorDTO
	@OneToMany(mappedBy="ateEntidad")
	private List<DoctorDTO> ateDoctors;

	//bi-directional many-to-one association to EventoDTO
	@OneToMany(mappedBy="ateEntidad")
	private List<EventoDTO> ateEventos;

	//bi-directional many-to-one association to NoticiaDTO
	@OneToMany(mappedBy="ateEntidad")
	private List<NoticiaDTO> ateNoticias;

	//bi-directional many-to-one association to ObraDTO
	@OneToMany(mappedBy="ateEntidad")
	private List<ObraDTO> ateObras;

	//bi-directional many-to-one association to OrganizacionDTO
	@OneToMany(mappedBy="ateEntidad")
	private List<OrganizacionDTO> ateOrganizacions;

	//bi-directional many-to-one association to ProyectoInvestigacionDTO
	@OneToMany(mappedBy="ateEntidad")
	private List<ProyectoInvestigacionDTO> ateProyectoInvestigacions;

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

	public List<CentroDTO> getAteCentros() {
		return this.ateCentros;
	}

	public void setAteCentros(List<CentroDTO> ateCentros) {
		this.ateCentros = ateCentros;
	}

	public CentroDTO addAteCentro(CentroDTO ateCentro) {
		getAteCentros().add(ateCentro);
		ateCentro.setAteEntidad(this);

		return ateCentro;
	}

	public CentroDTO removeAteCentro(CentroDTO ateCentro) {
		getAteCentros().remove(ateCentro);
		ateCentro.setAteEntidad(null);

		return ateCentro;
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

	public List<EventoDTO> getAteEventos() {
		return this.ateEventos;
	}

	public void setAteEventos(List<EventoDTO> ateEventos) {
		this.ateEventos = ateEventos;
	}

	public EventoDTO addAteEvento(EventoDTO ateEvento) {
		getAteEventos().add(ateEvento);
		ateEvento.setAteEntidad(this);

		return ateEvento;
	}

	public EventoDTO removeAteEvento(EventoDTO ateEvento) {
		getAteEventos().remove(ateEvento);
		ateEvento.setAteEntidad(null);

		return ateEvento;
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

	public List<ObraDTO> getAteObras() {
		return this.ateObras;
	}

	public void setAteObras(List<ObraDTO> ateObras) {
		this.ateObras = ateObras;
	}

	public ObraDTO addAteObra(ObraDTO ateObra) {
		getAteObras().add(ateObra);
		ateObra.setAteEntidad(this);

		return ateObra;
	}

	public ObraDTO removeAteObra(ObraDTO ateObra) {
		getAteObras().remove(ateObra);
		ateObra.setAteEntidad(null);

		return ateObra;
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

	public List<ProyectoInvestigacionDTO> getAteProyectoInvestigacions() {
		return this.ateProyectoInvestigacions;
	}

	public void setAteProyectoInvestigacions(List<ProyectoInvestigacionDTO> ateProyectoInvestigacions) {
		this.ateProyectoInvestigacions = ateProyectoInvestigacions;
	}

	public ProyectoInvestigacionDTO addAteProyectoInvestigacion(ProyectoInvestigacionDTO ateProyectoInvestigacion) {
		getAteProyectoInvestigacions().add(ateProyectoInvestigacion);
		ateProyectoInvestigacion.setAteEntidad(this);

		return ateProyectoInvestigacion;
	}

	public ProyectoInvestigacionDTO removeAteProyectoInvestigacion(ProyectoInvestigacionDTO ateProyectoInvestigacion) {
		getAteProyectoInvestigacions().remove(ateProyectoInvestigacion);
		ateProyectoInvestigacion.setAteEntidad(null);

		return ateProyectoInvestigacion;
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