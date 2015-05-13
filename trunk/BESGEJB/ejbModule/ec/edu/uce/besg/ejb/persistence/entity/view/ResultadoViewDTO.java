package ec.edu.uce.besg.ejb.persistence.entity.view;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the cue_resultado_view database table.
 * 
 */
@Entity
@Table(name="cue_resultado_view")
@NamedQuery(name="ResultadoViewDTO.findAll", query="SELECT r FROM ResultadoViewDTO r")
public class ResultadoViewDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="cat_codigo")
	private Integer catCodigo;

	@Column(name="cat_descripcion")
	private String catDescripcion;

	@Column(name="cat_encuesta")
	private Integer catEncuesta;

	@Column(name="cat_orden")
	private Integer catOrden;

	@Column(name="pre_categoria")
	private Integer preCategoria;

	@Column(name="pre_codigo")
	private Integer preCodigo;

	@Column(name="pre_control")
	private Integer preControl;

	@Column(name="pre_descripcion")
	private String preDescripcion;

	@Column(name="pre_orden")
	private Integer preOrden;

	@Column(name="res_codigo")
	private Integer resCodigo;

	@Column(name="res_descripcion")
	private String resDescripcion;

	@Column(name="res_pregunta")
	private Integer resPregunta;

	@Column(name="rsu_candidato")
	private Integer rsuCandidato;

	@Id
	@Column(name="rsu_codigo")
	private Integer rsuCodigo;

	@Column(name="rsu_respuesta")
	private Integer rsuRespuesta;

	@Column(name="rsu_valor_int")
	private Integer rsuValorInt;

	@Column(name="rsu_valor_string")
	private String rsuValorString;

	public ResultadoViewDTO() {
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

	public Integer getCatEncuesta() {
		return this.catEncuesta;
	}

	public void setCatEncuesta(Integer catEncuesta) {
		this.catEncuesta = catEncuesta;
	}

	public Integer getCatOrden() {
		return this.catOrden;
	}

	public void setCatOrden(Integer catOrden) {
		this.catOrden = catOrden;
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

	public Integer getPreControl() {
		return this.preControl;
	}

	public void setPreControl(Integer preControl) {
		this.preControl = preControl;
	}

	public String getPreDescripcion() {
		return this.preDescripcion;
	}

	public void setPreDescripcion(String preDescripcion) {
		this.preDescripcion = preDescripcion;
	}

	public Integer getPreOrden() {
		return this.preOrden;
	}

	public void setPreOrden(Integer preOrden) {
		this.preOrden = preOrden;
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

	public Integer getResPregunta() {
		return this.resPregunta;
	}

	public void setResPregunta(Integer resPregunta) {
		this.resPregunta = resPregunta;
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

	public Integer getRsuValorInt() {
		return this.rsuValorInt;
	}

	public void setRsuValorInt(Integer rsuValorInt) {
		this.rsuValorInt = rsuValorInt;
	}

	public String getRsuValorString() {
		return this.rsuValorString;
	}

	public void setRsuValorString(String rsuValorString) {
		this.rsuValorString = rsuValorString;
	}

}