package net.ciespal.redxxi.ejb.persistence.entities.argos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the arg_entidad database table.
 * 
 */
@Entity
@Table(name="arg_entidad")
@NamedQuery(name="EntidadDTO.findAll", query="SELECT e FROM EntidadDTO e")
public class EntidadDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ARG_ENTIDAD_ENTCODIGO_GENERATOR", sequenceName="ARG_ENTIDAD_ENT_CODIGO_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ARG_ENTIDAD_ENTCODIGO_GENERATOR")
	@Column(name="ent_codigo")
	private Integer entCodigo;

	@Column(name="ent_tipo")
	private Integer entTipo;

	//bi-directional many-to-one association to ContactoDTO
	@OneToMany(mappedBy="argEntidad")
	private List<ContactoDTO> argContactos;

	//bi-directional many-to-one association to DefensorDTO
	@OneToMany(mappedBy="argEntidad")
	private List<DefensorDTO> argDefensors;

	//bi-directional many-to-one association to NoticiaDTO
	@OneToMany(mappedBy="argEntidad")
	private List<NoticiaDTO> argNoticias;

	//bi-directional many-to-one association to ObservatorioDTO
	@OneToMany(mappedBy="argEntidad")
	private List<ObservatorioDTO> argObservatorios;

	//bi-directional many-to-one association to VeeduriaDTO
	@OneToMany(mappedBy="argEntidad")
	private List<VeeduriaDTO> argVeedurias;

	public EntidadDTO() {
	}

	public Integer getEntCodigo() {
		return this.entCodigo;
	}

	public void setEntCodigo(Integer entCodigo) {
		this.entCodigo = entCodigo;
	}

	public Integer getEntTipo() {
		return this.entTipo;
	}

	public void setEntTipo(Integer entTipo) {
		this.entTipo = entTipo;
	}

	public List<ContactoDTO> getArgContactos() {
		return this.argContactos;
	}

	public void setArgContactos(List<ContactoDTO> argContactos) {
		this.argContactos = argContactos;
	}

	public ContactoDTO addArgContacto(ContactoDTO argContacto) {
		getArgContactos().add(argContacto);
		argContacto.setArgEntidad(this);

		return argContacto;
	}

	public ContactoDTO removeArgContacto(ContactoDTO argContacto) {
		getArgContactos().remove(argContacto);
		argContacto.setArgEntidad(null);

		return argContacto;
	}

	public List<DefensorDTO> getArgDefensors() {
		return this.argDefensors;
	}

	public void setArgDefensors(List<DefensorDTO> argDefensors) {
		this.argDefensors = argDefensors;
	}

	public DefensorDTO addArgDefensor(DefensorDTO argDefensor) {
		getArgDefensors().add(argDefensor);
		argDefensor.setArgEntidad(this);

		return argDefensor;
	}

	public DefensorDTO removeArgDefensor(DefensorDTO argDefensor) {
		getArgDefensors().remove(argDefensor);
		argDefensor.setArgEntidad(null);

		return argDefensor;
	}

	public List<NoticiaDTO> getArgNoticias() {
		return this.argNoticias;
	}

	public void setArgNoticias(List<NoticiaDTO> argNoticias) {
		this.argNoticias = argNoticias;
	}

	public NoticiaDTO addArgNoticia(NoticiaDTO argNoticia) {
		getArgNoticias().add(argNoticia);
		argNoticia.setArgEntidad(this);

		return argNoticia;
	}

	public NoticiaDTO removeArgNoticia(NoticiaDTO argNoticia) {
		getArgNoticias().remove(argNoticia);
		argNoticia.setArgEntidad(null);

		return argNoticia;
	}

	public List<ObservatorioDTO> getArgObservatorios() {
		return this.argObservatorios;
	}

	public void setArgObservatorios(List<ObservatorioDTO> argObservatorios) {
		this.argObservatorios = argObservatorios;
	}

	public ObservatorioDTO addArgObservatorio(ObservatorioDTO argObservatorio) {
		getArgObservatorios().add(argObservatorio);
		argObservatorio.setArgEntidad(this);

		return argObservatorio;
	}

	public ObservatorioDTO removeArgObservatorio(ObservatorioDTO argObservatorio) {
		getArgObservatorios().remove(argObservatorio);
		argObservatorio.setArgEntidad(null);

		return argObservatorio;
	}

	public List<VeeduriaDTO> getArgVeedurias() {
		return this.argVeedurias;
	}

	public void setArgVeedurias(List<VeeduriaDTO> argVeedurias) {
		this.argVeedurias = argVeedurias;
	}

	public VeeduriaDTO addArgVeeduria(VeeduriaDTO argVeeduria) {
		getArgVeedurias().add(argVeeduria);
		argVeeduria.setArgEntidad(this);

		return argVeeduria;
	}

	public VeeduriaDTO removeArgVeeduria(VeeduriaDTO argVeeduria) {
		getArgVeedurias().remove(argVeeduria);
		argVeeduria.setArgEntidad(null);

		return argVeeduria;
	}

}