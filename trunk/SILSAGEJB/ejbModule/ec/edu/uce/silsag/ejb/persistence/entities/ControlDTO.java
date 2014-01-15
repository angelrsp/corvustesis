package ec.edu.uce.silsag.ejb.persistence.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the bem_control database table.
 * 
 */
@Entity
@Table(name="bem_control")
@NamedQuery(name="ControlDTO.findAll", query="SELECT c FROM ControlDTO c")
public class ControlDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="BEM_CONTROL_CONCODIGO_GENERATOR", sequenceName="BEM_CONTROL_CON_CODIGO_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="BEM_CONTROL_CONCODIGO_GENERATOR")
	@Column(name="con_codigo")
	private Integer conCodigo;

	@Column(name="con_descripcion")
	private String conDescripcion;

	//bi-directional many-to-one association to RespuestaDTO
	@OneToMany(mappedBy="bemControl")
	private List<RespuestaDTO> bemRespuestas;

	public ControlDTO() {
	}

	public Integer getConCodigo() {
		return this.conCodigo;
	}

	public void setConCodigo(Integer conCodigo) {
		this.conCodigo = conCodigo;
	}

	public String getConDescripcion() {
		return this.conDescripcion;
	}

	public void setConDescripcion(String conDescripcion) {
		this.conDescripcion = conDescripcion;
	}

	public List<RespuestaDTO> getBemRespuestas() {
		return this.bemRespuestas;
	}

	public void setBemRespuestas(List<RespuestaDTO> bemRespuestas) {
		this.bemRespuestas = bemRespuestas;
	}

	public RespuestaDTO addBemRespuesta(RespuestaDTO bemRespuesta) {
		getBemRespuestas().add(bemRespuesta);
		bemRespuesta.setBemControl(this);

		return bemRespuesta;
	}

	public RespuestaDTO removeBemRespuesta(RespuestaDTO bemRespuesta) {
		getBemRespuestas().remove(bemRespuesta);
		bemRespuesta.setBemControl(null);

		return bemRespuesta;
	}

}