package ec.edu.uce.silsag.ejb.persistence.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the bem_curso database table.
 * 
 */
@Entity
@Table(name="bem_curso")
@NamedQuery(name="CursoDTO.findAll", query="SELECT c FROM CursoDTO c")
public class CursoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="BEM_CURSO_CURCODIGO_GENERATOR", sequenceName="BEM_CURSO_CUR_CODIGO_SEQ",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="BEM_CURSO_CURCODIGO_GENERATOR")
	@Column(name="cur_codigo")
	private Integer curCodigo;

	@Column(name="cur_entidad")
	private String curEntidad;

	@Column(name="cur_fecha_fin")
	private Timestamp curFechaFin;

	@Column(name="cur_fecha_inicio")
	private Timestamp curFechaInicio;

	@Column(name="cur_descripcion")
	private String curDescripcion;
	
	//bi-directional many-to-one association to CandidatoDTO
	@ManyToOne
	@JoinColumn(name="cur_candidato")
	private CandidatoDTO bemCandidato;

	public CursoDTO() {
	}

	public Integer getCurCodigo() {
		return this.curCodigo;
	}

	public void setCurCodigo(Integer curCodigo) {
		this.curCodigo = curCodigo;
	}

	public String getCurEntidad() {
		return this.curEntidad;
	}

	public void setCurEntidad(String curEntidad) {
		this.curEntidad = curEntidad;
	}

	public Timestamp getCurFechaFin() {
		return this.curFechaFin;
	}

	public void setCurFechaFin(Timestamp curFechaFin) {
		this.curFechaFin = curFechaFin;
	}

	public Timestamp getCurFechaInicio() {
		return this.curFechaInicio;
	}

	public void setCurFechaInicio(Timestamp curFechaInicio) {
		this.curFechaInicio = curFechaInicio;
	}

	public String getCurDescripcion() {
		return curDescripcion;
	}

	public void setCurDescripcion(String curDescripcion) {
		this.curDescripcion = curDescripcion;
	}

	public CandidatoDTO getBemCandidato() {
		return this.bemCandidato;
	}

	public void setBemCandidato(CandidatoDTO bemCandidato) {
		this.bemCandidato = bemCandidato;
	}

}