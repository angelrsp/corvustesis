package ec.edu.uce.besg.ejb.persistence.entity.view;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the cue_cuestionario_view database table.
 * 
 */
@Entity
@Table(name="cue_cuestionario_view")
@NamedQuery(name="CuestionarioViewDTO.findAll", query="SELECT c FROM CuestionarioViewDTO c")
public class CuestionarioViewDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="con_codigo")
	private Integer conCodigo;

	@Column(name="con_descripcion")
	private String conDescripcion;

	@Column(name="pre_codigo")
	private Integer preCodigo;

	@Column(name="pre_descripcion")
	private String preDescripcion;

	@Id
	@Column(name="res_codigo")
	private Integer resCodigo;

	@Column(name="res_control")
	private Integer resControl;

	@Column(name="res_descripcion")
	private String resDescripcion;

	@Column(name="res_pregunta")
	private Integer resPregunta;

	public CuestionarioViewDTO() {
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

}