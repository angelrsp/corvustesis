package ec.edu.uce.silsag.ejb.persistence.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the bem_pregunta database table.
 * 
 */
@Entity
@Table(name="bem_pregunta")
@NamedQuery(name="PreguntaDTO.findAll", query="SELECT p FROM PreguntaDTO p")
public class PreguntaDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="BEM_PREGUNTA_PRECODIGO_GENERATOR", sequenceName="BEM_PREGUNTA_PRE_CODIGO_SEQ",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="BEM_PREGUNTA_PRECODIGO_GENERATOR")
	@Column(name="pre_codigo")
	private Integer preCodigo;

	@Column(name="pre_descripcion")
	private String preDescripcion;

	//bi-directional many-to-one association to RespuestaDTO
	@OneToMany(mappedBy="bemPregunta")
	private List<RespuestaDTO> bemRespuestas;

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

	public List<RespuestaDTO> getBemRespuestas() {
		return this.bemRespuestas;
	}

	public void setBemRespuestas(List<RespuestaDTO> bemRespuestas) {
		this.bemRespuestas = bemRespuestas;
	}

	public RespuestaDTO addBemRespuesta(RespuestaDTO bemRespuesta) {
		getBemRespuestas().add(bemRespuesta);
		bemRespuesta.setBemPregunta(this);

		return bemRespuesta;
	}

	public RespuestaDTO removeBemRespuesta(RespuestaDTO bemRespuesta) {
		getBemRespuestas().remove(bemRespuesta);
		bemRespuesta.setBemPregunta(null);

		return bemRespuesta;
	}

}