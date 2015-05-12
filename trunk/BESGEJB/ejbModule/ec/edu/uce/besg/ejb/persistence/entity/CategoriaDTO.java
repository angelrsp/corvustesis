package ec.edu.uce.besg.ejb.persistence.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


/**
 * The persistent class for the cue_categoria database table.
 * 
 */
@Entity
@Table(name="cue_categoria")
@NamedQuery(name="CategoriaDTO.findAll", query="SELECT c FROM CategoriaDTO c")
public class CategoriaDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CUE_CATEGORIA_CATCODIGO_GENERATOR", sequenceName="CUE_CATEGORIA_CAT_CODIGO_SEQ",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CUE_CATEGORIA_CATCODIGO_GENERATOR")
	@Column(name="cat_codigo")
	private Integer catCodigo;

	@Column(name="cat_descripcion")
	private String catDescripcion;

	@Column(name="cat_orden")
	private Integer catOrden;
	
	//bi-directional many-to-one association to ControlDTO
	@ManyToOne
	@JoinColumn(name="cat_encuesta")
	private EncuestaDTO cueEncuesta;

	//bi-directional many-to-one association to RespuestaDTO
	@OneToMany(mappedBy="cueCategoria")
	private List<PreguntaDTO> cuePreguntas;

	
	public CategoriaDTO() {
	}

	public Integer getCatCodigo() {
		return this.catCodigo;
	}

	public void setCatCodigo(Integer catCodigo) {
		this.catCodigo = catCodigo;
	}

	public String getCatDescripcion() {
		return this.catDescripcion;
	}

	public void setCatDescripcion(String catDescripcion) {
		this.catDescripcion = catDescripcion;
	}

	public EncuestaDTO getCueEncuesta() {
		return cueEncuesta;
	}

	public void setCueEncuesta(EncuestaDTO cueEncuesta) {
		this.cueEncuesta = cueEncuesta;
	}

	public List<PreguntaDTO> getCuePreguntas() {
		return cuePreguntas;
	}

	public Integer getCatOrden() {
		return catOrden;
	}

	public void setCatOrden(Integer catOrden) {
		this.catOrden = catOrden;
	}

	public void setCuePreguntas(List<PreguntaDTO> cuePreguntas) {
		this.cuePreguntas = cuePreguntas;
	}

}