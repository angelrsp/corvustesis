package ec.edu.uce.besg.ejb.persistence.entity;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the cue_pregunta database table.
 * 
 */
@Entity
@Table(name="cue_pregunta")
@NamedQuery(name="PreguntaDTO.findAll", query="SELECT p FROM PreguntaDTO p")
public class PreguntaDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CUE_PREGUNTA_PRECODIGO_GENERATOR", sequenceName="CUE_PREGUNTA_PRE_CODIGO_SEQ",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CUE_PREGUNTA_PRECODIGO_GENERATOR")
	@Column(name="pre_codigo")
	private Integer preCodigo;

	@Column(name="pre_descripcion")
	private String preDescripcion;

	@Column(name="pre_orden")
	private Integer preOrden;

	@Column(name="pre_requerido")
	private Boolean preRequerido;
	
	//bi-directional many-to-one association to ControlDTO
	@ManyToOne
	@JoinColumn(name="pre_control")
	private ControlDTO cueControl;

	//bi-directional many-to-one association to ControlDTO
	@ManyToOne
	@JoinColumn(name="pre_categoria")
	private CategoriaDTO cueCategoria;

	//bi-directional many-to-one association to RespuestaDTO
	@OneToMany(mappedBy="cuePregunta")
	private List<RespuestaDTO> cueRespuestas;

	public PreguntaDTO() {
	}

	public Integer getPreCodigo() {
		return this.preCodigo;
	}

	public void setPreCodigo(Integer preCodigo) {
		this.preCodigo = preCodigo;
	}

	public String getPreDescripcion() {
		return this.preDescripcion;
	}

	public void setPreDescripcion(String preDescripcion) {
		this.preDescripcion = preDescripcion;
	}

	public List<RespuestaDTO> getCueRespuestas() {
		return this.cueRespuestas;
	}

	public ControlDTO getCueControl() {
		return cueControl;
	}

	public void setCueControl(ControlDTO cueControl) {
		this.cueControl = cueControl;
	}

	public CategoriaDTO getCueCategoria() {
		return cueCategoria;
	}

	public Integer getPreOrden() {
		return preOrden;
	}

	public void setPreOrden(Integer preOrden) {
		this.preOrden = preOrden;
	}

	public Boolean getPreRequerido() {
		return preRequerido;
	}

	public void setPreRequerido(Boolean preRequerido) {
		this.preRequerido = preRequerido;
	}

	public void setCueCategoria(CategoriaDTO cueCategoria) {
		this.cueCategoria = cueCategoria;
	}

	public void setCueRespuestas(List<RespuestaDTO> cueRespuestas) {
		this.cueRespuestas = cueRespuestas;
	}

	public RespuestaDTO addCueRespuesta(RespuestaDTO cueRespuesta) {
		getCueRespuestas().add(cueRespuesta);
		cueRespuesta.setCuePregunta(this);

		return cueRespuesta;
	}

	public RespuestaDTO removeCueRespuesta(RespuestaDTO cueRespuesta) {
		getCueRespuestas().remove(cueRespuesta);
		cueRespuesta.setCuePregunta(null);

		return cueRespuesta;
	}

}