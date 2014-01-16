package ec.edu.uce.silsag.ejb.persistence.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the bem_respuesta database table.
 * 
 */
@Entity
@Table(name="bem_respuesta")
@NamedQuery(name="RespuestaDTO.findAll", query="SELECT r FROM RespuestaDTO r")
public class RespuestaDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="BEM_RESPUESTA_RESCODIGO_GENERATOR", sequenceName="BEM_RESPUESTA_RES_CODIGO_SEQ",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="BEM_RESPUESTA_RESCODIGO_GENERATOR")
	@Column(name="res_codigo")
	private Integer resCodigo;

	@Column(name="res_descripcion")
	private String resDescripcion;

	//bi-directional many-to-one association to ControlDTO
	@ManyToOne
	@JoinColumn(name="res_control")
	private ControlDTO bemControl;

	//bi-directional many-to-one association to PreguntaDTO
	@ManyToOne
	@JoinColumn(name="res_pregunta")
	private PreguntaDTO bemPregunta;

	//bi-directional many-to-one association to ResultadoDTO
	@OneToMany(mappedBy="bemRespuesta")
	private List<ResultadoDTO> bemResultados;

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

	public ControlDTO getBemControl() {
		return this.bemControl;
	}

	public void setBemControl(ControlDTO bemControl) {
		this.bemControl = bemControl;
	}

	public PreguntaDTO getBemPregunta() {
		return this.bemPregunta;
	}

	public void setBemPregunta(PreguntaDTO bemPregunta) {
		this.bemPregunta = bemPregunta;
	}

	public List<ResultadoDTO> getBemResultados() {
		return this.bemResultados;
	}

	public void setBemResultados(List<ResultadoDTO> bemResultados) {
		this.bemResultados = bemResultados;
	}

	public ResultadoDTO addBemResultado(ResultadoDTO bemResultado) {
		getBemResultados().add(bemResultado);
		bemResultado.setBemRespuesta(this);

		return bemResultado;
	}

	public ResultadoDTO removeBemResultado(ResultadoDTO bemResultado) {
		getBemResultados().remove(bemResultado);
		bemResultado.setBemRespuesta(null);

		return bemResultado;
	}

}