package net.ciespal.redxxi.ejb.persistence.entities;

import java.io.Serializable;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the ate_publicacion database table.
 * 
 */
@Entity
@Table(name="ate_publicacion")
@NamedQuery(name="PublicacionDTO.findAll", query="SELECT p FROM PublicacionDTO p")
public class PublicacionDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ATE_PUBLICACION_PUBCODIGO_GENERATOR", sequenceName="ATE_PUBLICACION_PUB_CODIGO_SEQ",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ATE_PUBLICACION_PUBCODIGO_GENERATOR")
	@Column(name="pub_codigo")
	private Integer pubCodigo;

	@Column(name="pub_anio_publicacion")
	private Integer pubAnioPublicacion;

	@Column(name="pub_apellidos")
	private String pubApellidos;

	@Column(name="pub_archivo")
	private byte[] pubArchivo;

	@Column(name="pub_nombres")
	private String pubNombres;

	@Column(name="pub_resumen")
	private String pubResumen;

	@Column(name="pub_sipnosis")
	private String pubSipnosis;

	@Column(name="pub_tematica")
	private String pubTematica;

	@Column(name="pub_tipo")
	private Integer pubTipo;

	@Column(name="pub_titulo")
	private String pubTitulo;

	@Column(name="pub_titulo_publicacion")
	private String pubTituloPublicacion;

	@Column(name="pub_isbn")
	private String pubIsbn;

	@Column(name="pub_autor")
	private String pubAutor;

	@Column(name="pub_campo_conocimiento")
	private Integer pubCampoConocimiento;

	@Column(name="pub_ciudad")
	private Integer pubCiudad;

	@Column(name="pub_provincia")
	private Integer pubProvincia;

	@Column(name="pub_pais")
	private Integer pubPais;

	
	@Transient
	private Long pubCount;

	
	//bi-directional many-to-one association to EntidadDTO
	@OneToMany(mappedBy="atePublicacion",fetch=FetchType.EAGER,cascade=CascadeType.PERSIST)
	private List<EntidadDTO> ateEntidads;

	public PublicacionDTO() {
	}

	public PublicacionDTO(Long pubCount) {
		this.pubCount=pubCount;
	}

	public Integer getPubCodigo() {
		return this.pubCodigo;
	}

	public void setPubCodigo(Integer pubCodigo) {
		this.pubCodigo = pubCodigo;
	}

	public Integer getPubAnioPublicacion() {
		return this.pubAnioPublicacion;
	}

	public void setPubAnioPublicacion(Integer pubAnioPublicacion) {
		this.pubAnioPublicacion = pubAnioPublicacion;
	}

	public String getPubApellidos() {
		return this.pubApellidos;
	}

	public void setPubApellidos(String pubApellidos) {
		this.pubApellidos = pubApellidos;
	}

	public byte[] getPubArchivo() {
		return this.pubArchivo;
	}

	public void setPubArchivo(byte[] pubArchivo) {
		this.pubArchivo = pubArchivo;
	}

	public String getPubNombres() {
		return this.pubNombres;
	}

	public void setPubNombres(String pubNombres) {
		this.pubNombres = pubNombres;
	}

	public String getPubResumen() {
		return this.pubResumen;
	}

	public void setPubResumen(String pubResumen) {
		this.pubResumen = pubResumen;
	}

	public String getPubSipnosis() {
		return this.pubSipnosis;
	}

	public void setPubSipnosis(String pubSipnosis) {
		this.pubSipnosis = pubSipnosis;
	}

	public String getPubTematica() {
		return this.pubTematica;
	}

	public void setPubTematica(String pubTematica) {
		this.pubTematica = pubTematica;
	}

	public Integer getPubTipo() {
		return this.pubTipo;
	}

	public void setPubTipo(Integer pubTipo) {
		this.pubTipo = pubTipo;
	}

	public String getPubTitulo() {
		return this.pubTitulo;
	}

	public void setPubTitulo(String pubTitulo) {
		this.pubTitulo = pubTitulo;
	}

	public String getPubIsbn() {
		return pubIsbn;
	}

	public void setPubIsbn(String pubIsbn) {
		this.pubIsbn = pubIsbn;
	}

	public String getPubAutor() {
		return pubAutor;
	}

	public void setPubAutor(String pubAutor) {
		this.pubAutor = pubAutor;
	}

	public Integer getPubCampoConocimiento() {
		return pubCampoConocimiento;
	}

	public void setPubCampoConocimiento(Integer pubCampoConocimiento) {
		this.pubCampoConocimiento = pubCampoConocimiento;
	}

	public Integer getPubCiudad() {
		return pubCiudad;
	}

	public void setPubCiudad(Integer pubCiudad) {
		this.pubCiudad = pubCiudad;
	}

	public Integer getPubProvincia() {
		return pubProvincia;
	}

	public void setPubProvincia(Integer pubProvincia) {
		this.pubProvincia = pubProvincia;
	}

	public Integer getPubPais() {
		return pubPais;
	}

	public void setPubPais(Integer pubPais) {
		this.pubPais = pubPais;
	}

	public Long getPubCount() {
		return pubCount;
	}

	public void setPubCount(Long pubCount) {
		this.pubCount = pubCount;
	}

	public String getPubTituloPublicacion() {
		return this.pubTituloPublicacion;
	}

	public void setPubTituloPublicacion(String pubTituloPublicacion) {
		this.pubTituloPublicacion = pubTituloPublicacion;
	}

	public List<EntidadDTO> getAteEntidads() {
		return this.ateEntidads;
	}

	public void setAteEntidads(List<EntidadDTO> ateEntidads) {
		this.ateEntidads = ateEntidads;
	}

	public EntidadDTO addAteEntidad(EntidadDTO ateEntidad) {
		if(ateEntidad!=null)
		{
			if(getAteEntidads()==null)
				setAteEntidads(new ArrayList<EntidadDTO>());
			getAteEntidads().add(ateEntidad);
			ateEntidad.setAtePublicacion(this);
		}
		return ateEntidad;
	}

	public EntidadDTO removeAteEntidad(EntidadDTO ateEntidad) {
		getAteEntidads().remove(ateEntidad);
		ateEntidad.setAtePublicacion(null);

		return ateEntidad;
	}

}