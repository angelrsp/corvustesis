package ec.edu.uce.silsag.ejb.persistence.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the bem_resultado database table.
 * 
 */
@Entity
@Table(name="bem_resultado")
@NamedQuery(name="ResultadoDTO.findAll", query="SELECT r FROM ResultadoDTO r")
public class ResultadoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="BEM_RESULTADO_RSUCODIGO_GENERATOR", sequenceName="BEM_RESULTADO_RSU_CODIGO_SEQ",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="BEM_RESULTADO_RSUCODIGO_GENERATOR")
	@Column(name="rsu_codigo")
	private Integer rsuCodigo;

	@Column(name="rsu_adicional")
	private String rsuAdicional;
	
	//bi-directional many-to-one association to CandidatoDTO
	@ManyToOne
	@JoinColumn(name="rsu_candidato")
	private CandidatoDTO bemCandidato;

	//bi-directional many-to-one association to RespuestaDTO
	@ManyToOne
	@JoinColumn(name="rsu_respuesta")
	private RespuestaDTO bemRespuesta;

	public ResultadoDTO() {
	}

	public Integer getRsuCodigo() {
		return this.rsuCodigo;
	}

	public void setRsuCodigo(Integer rsuCodigo) {
		this.rsuCodigo = rsuCodigo;
	}

	public String getRsuAdicional() {
		return rsuAdicional;
	}

	public void setRsuAdicional(String rsuAdicional) {
		this.rsuAdicional = rsuAdicional;
	}

	public CandidatoDTO getBemCandidato() {
		return this.bemCandidato;
	}

	public void setBemCandidato(CandidatoDTO bemCandidato) {
		this.bemCandidato = bemCandidato;
	}

	public RespuestaDTO getBemRespuesta() {
		return this.bemRespuesta;
	}

	public void setBemRespuesta(RespuestaDTO bemRespuesta) {
		this.bemRespuesta = bemRespuesta;
	}

}