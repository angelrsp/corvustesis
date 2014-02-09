package ec.edu.uce.silsag.ejb.persistence.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the vie_resultado database table.
 * 
 */
@Entity
@Table(name="vie_resultado")
@NamedQuery(name="ResultadoListDTO.findAll", query="SELECT r FROM ResultadoListDTO r")
public class ResultadoListDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="pre_categoria")
	private Integer preCategoria;

	@Column(name="pre_codigo")
	private Integer preCodigo;

	@Column(name="pre_descripcion")
	private String preDescripcion;

	@Column(name="res_codigo")
	private Integer resCodigo;

	@Column(name="res_control")
	private Integer resControl;

	@Column(name="res_descripcion")
	private String resDescripcion;

	@Column(name="res_pregunta")
	private Integer resPregunta;

	@Column(name="rsu_adicional")
	private String rsuAdicional;

	@Column(name="rsu_candidato")
	private Integer rsuCandidato;

	@Id
	@Column(name="rsu_codigo")
	private Integer rsuCodigo;

	@Column(name="rsu_respuesta")
	private Integer rsuRespuesta;

	public ResultadoListDTO() {
	}

	public Integer getPreCategoria() {
		return this.preCategoria;
	}

	public void setPreCategoria(Integer preCategoria) {
		this.preCategoria = preCategoria;
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

	public Integer getResCodigo() {
		return this.resCodigo;
	}

	public void setResCodigo(Integer resCodigo) {
		this.resCodigo = resCodigo;
	}

	public Integer getResControl() {
		return this.resControl;
	}

	public void setResControl(Integer resControl) {
		this.resControl = resControl;
	}

	public String getResDescripcion() {
		return this.resDescripcion;
	}

	public void setResDescripcion(String resDescripcion) {
		this.resDescripcion = resDescripcion;
	}

	public Integer getResPregunta() {
		return this.resPregunta;
	}

	public void setResPregunta(Integer resPregunta) {
		this.resPregunta = resPregunta;
	}

	public String getRsuAdicional() {
		return this.rsuAdicional;
	}

	public void setRsuAdicional(String rsuAdicional) {
		this.rsuAdicional = rsuAdicional;
	}

	public Integer getRsuCandidato() {
		return this.rsuCandidato;
	}

	public void setRsuCandidato(Integer rsuCandidato) {
		this.rsuCandidato = rsuCandidato;
	}

	public Integer getRsuCodigo() {
		return this.rsuCodigo;
	}

	public void setRsuCodigo(Integer rsuCodigo) {
		this.rsuCodigo = rsuCodigo;
	}

	public Integer getRsuRespuesta() {
		return this.rsuRespuesta;
	}

	public void setRsuRespuesta(Integer rsuRespuesta) {
		this.rsuRespuesta = rsuRespuesta;
	}

}