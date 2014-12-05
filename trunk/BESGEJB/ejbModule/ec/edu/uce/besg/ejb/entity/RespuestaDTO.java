package ec.edu.uce.besg.ejb.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cue_respuesta database table.
 * 
 */
@Entity
@Table(name="cue_respuesta")
@NamedQuery(name="RespuestaDTO.findAll", query="SELECT r FROM RespuestaDTO r")
public class RespuestaDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CUE_RESPUESTA_RESCODIGO_GENERATOR", sequenceName="CUE_RESPUESTA_RES_CODIGO_SEQ",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CUE_RESPUESTA_RESCODIGO_GENERATOR")
	@Column(name="res_codigo")
	private Integer resCodigo;

	@Column(name="res_descripcion")
	private String resDescripcion;

	//bi-directional many-to-one association to ControlDTO
	@ManyToOne
	@JoinColumn(name="res_control")
	private ControlDTO cueControl;

	//bi-directional many-to-one association to PreguntaDTO
	@ManyToOne
	@JoinColumn(name="res_pregunta")
	private PreguntaDTO cuePregunta;

	//bi-directional many-to-one association to ResultadoDTO
	@OneToMany(mappedBy="cueRespuesta")
	private List<ResultadoDTO> cueResultados;

	public RespuestaDTO() {
	}

	public Integer getResCodigo() {
		return this.resCodigo;
	}

	public void setResCodigo(Integer resCodigo) {
		this.resCodigo = resCodigo;
	}

	public String getResDescripcion() {
		return this.resDescripcion;
	}

	public void setResDescripcion(String resDescripcion) {
		this.resDescripcion = resDescripcion;
	}

	public ControlDTO getCueControl() {
		return this.cueControl;
	}

	public void setCueControl(ControlDTO cueControl) {
		this.cueControl = cueControl;
	}

	public PreguntaDTO getCuePregunta() {
		return this.cuePregunta;
	}

	public void setCuePregunta(PreguntaDTO cuePregunta) {
		this.cuePregunta = cuePregunta;
	}

	public List<ResultadoDTO> getCueResultados() {
		return this.cueResultados;
	}

	public void setCueResultados(List<ResultadoDTO> cueResultados) {
		this.cueResultados = cueResultados;
	}

	public ResultadoDTO addCueResultado(ResultadoDTO cueResultado) {
		getCueResultados().add(cueResultado);
		cueResultado.setCueRespuesta(this);

		return cueResultado;
	}

	public ResultadoDTO removeCueResultado(ResultadoDTO cueResultado) {
		getCueResultados().remove(cueResultado);
		cueResultado.setCueRespuesta(null);

		return cueResultado;
	}

}