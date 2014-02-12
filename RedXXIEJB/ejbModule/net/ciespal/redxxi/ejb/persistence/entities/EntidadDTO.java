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

	//bi-directional many-to-one association to CarreraDTO
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="ent_carrera")
	private CarreraDTO ateCarrera;

	//bi-directional many-to-one association to DoctorDTO
	@ManyToOne
	@JoinColumn(name="ent_doctor")
	private DoctorDTO ateDoctor;

	//bi-directional many-to-one association to EventoDTO
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="ent_evento")
	private EventoDTO ateEvento;

	//bi-directional many-to-one association to NoticiaDTO
	@ManyToOne
	@JoinColumn(name="ent_noticias")
	private NoticiaDTO ateNoticia;

	//bi-directional many-to-one association to ObraDTO
	@ManyToOne
	@JoinColumn(name="ent_obra")
	private ObraDTO ateObra;

	//bi-directional many-to-one association to OrganizacionDTO
	@ManyToOne
	@JoinColumn(name="ent_organizacion")
	private OrganizacionDTO ateOrganizacion;

	//bi-directional many-to-one association to ProyectoInvestigacionDTO
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="ent_proyecto_intestigacion")
	private ProyectoInvestigacionDTO ateProyectoInvestigacion;

	//bi-directional many-to-one association to PublicacionDTO
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="ent_publicacion")
	private PublicacionDTO atePublicacion;

	//bi-directional many-to-one association to ContactoDTO
	@OneToMany(mappedBy="ateEntidad",fetch=FetchType.EAGER)
	private List<ContactoDTO> ateContactos;

	public EntidadDTO() {
	}

	public Integer getEntCodigo() {
		return this.entCodigo;
	}

	public void setEntCodigo(Integer entCodigo) {
		this.entCodigo = entCodigo;
	}

	public CarreraDTO getAteCarrera() {
		return this.ateCarrera;
	}

	public void setAteCarrera(CarreraDTO ateCarrera) {
		this.ateCarrera = ateCarrera;
	}

	public DoctorDTO getAteDoctor() {
		return this.ateDoctor;
	}

	public void setAteDoctor(DoctorDTO ateDoctor) {
		this.ateDoctor = ateDoctor;
	}

	public EventoDTO getAteEvento() {
		return this.ateEvento;
	}

	public void setAteEvento(EventoDTO ateEvento) {
		this.ateEvento = ateEvento;
	}

	public NoticiaDTO getAteNoticia() {
		return this.ateNoticia;
	}

	public void setAteNoticia(NoticiaDTO ateNoticia) {
		this.ateNoticia = ateNoticia;
	}

	public ObraDTO getAteObra() {
		return this.ateObra;
	}

	public void setAteObra(ObraDTO ateObra) {
		this.ateObra = ateObra;
	}

	public OrganizacionDTO getAteOrganizacion() {
		return this.ateOrganizacion;
	}

	public void setAteOrganizacion(OrganizacionDTO ateOrganizacion) {
		this.ateOrganizacion = ateOrganizacion;
	}

	public ProyectoInvestigacionDTO getAteProyectoInvestigacion() {
		return this.ateProyectoInvestigacion;
	}

	public void setAteProyectoInvestigacion(ProyectoInvestigacionDTO ateProyectoInvestigacion) {
		this.ateProyectoInvestigacion = ateProyectoInvestigacion;
	}

	public PublicacionDTO getAtePublicacion() {
		return this.atePublicacion;
	}

	public void setAtePublicacion(PublicacionDTO atePublicacion) {
		this.atePublicacion = atePublicacion;
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

}