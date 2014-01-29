package net.ciespal.redxxi.ejb.persistence.entities;

import java.io.Serializable;
import javax.persistence.*;


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
	private String pubArchivo;

	@Column(name="pub_nombres")
	private String pubNombres;

	@Column(name="pub_resumen")
	private String pubResumen;

	@Column(name="pub_sipnosis")
	private String pubSipnosis;

	@Column(name="pub_tematica")
	private String pubTematica;

	@Column(name="pub_titulo")
	private String pubTitulo;

	@Column(name="pub_titulo_publicacion")
	private String pubTituloPublicacion;

	//bi-directional many-to-one association to EntidadDTO
	@ManyToOne
	@JoinColumn(name="pub_entidad")
	private EntidadDTO ateEntidad;

	public PublicacionDTO() {
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

	public String getPubArchivo() {
		return this.pubArchivo;
	}

	public void setPubArchivo(String pubArchivo) {
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

	public String getPubTitulo() {
		return this.pubTitulo;
	}

	public void setPubTitulo(String pubTitulo) {
		this.pubTitulo = pubTitulo;
	}

	public String getPubTituloPublicacion() {
		return this.pubTituloPublicacion;
	}

	public void setPubTituloPublicacion(String pubTituloPublicacion) {
		this.pubTituloPublicacion = pubTituloPublicacion;
	}

	public EntidadDTO getAteEntidad() {
		return this.ateEntidad;
	}

	public void setAteEntidad(EntidadDTO ateEntidad) {
		this.ateEntidad = ateEntidad;
	}

}