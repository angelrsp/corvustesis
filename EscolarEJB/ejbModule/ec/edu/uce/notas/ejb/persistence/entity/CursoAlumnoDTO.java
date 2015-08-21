package ec.edu.uce.notas.ejb.persistence.entity;

import java.io.Serializable;

import javax.persistence.*;

/**
 * The persistent class for the not_curso_alumno database table.
 * 
 */
@Entity
@Table(name="not_curso_alumno")
@NamedQuery(name="CursoAlumnoDTO.findAll", query="SELECT c FROM CursoAlumnoDTO c")
public class CursoAlumnoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="NOT_CURSO_ALUMNO_CALCODIGO_GENERATOR", sequenceName="NOT_CURSO_ALUMNO_CAL_CODIGO_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="NOT_CURSO_ALUMNO_CALCODIGO_GENERATOR")
    @Column(name="cal_codigo")
	private Integer calCodigo;

	//bi-directional many-to-one association to AlumnoDTO
	@ManyToOne
	@JoinColumn(name="cal_alumno")
	private AlumnoDTO notAlumno;

	//bi-directional many-to-one association to CursoParaleloDTO
	@ManyToOne
	@JoinColumn(name="cal_curso_paralelo")
	private CursoParaleloDTO notCursoParalelo;

	//bi-directional many-to-one association to MateriaDocenteDTO
	@ManyToOne
	@JoinColumn(name="cal_curso_docente")
	private MateriaDocenteDTO notMateriaDocente;
	
	@ManyToOne
	@JoinColumn(name="cal_periodo")
	private PeriodoDTO notPeriodo;

	public CursoAlumnoDTO() {
	}

	public Integer getCalCodigo() {
		return this.calCodigo;
	}

	public void setCalCodigo(Integer calCodigo) {
		this.calCodigo = calCodigo;
	}

	public AlumnoDTO getNotAlumno() {
		return this.notAlumno;
	}

	public void setNotAlumno(AlumnoDTO notAlumno) {
		this.notAlumno = notAlumno;
	}

	public CursoParaleloDTO getNotCursoParalelo() {
		return this.notCursoParalelo;
	}

	public void setNotCursoParalelo(CursoParaleloDTO notCursoParalelo) {
		this.notCursoParalelo = notCursoParalelo;
	}

	public MateriaDocenteDTO getNotMateriaDocente() {
		return this.notMateriaDocente;
	}

	public void setNotMateriaDocente(MateriaDocenteDTO notMateriaDocente) {
		this.notMateriaDocente = notMateriaDocente;
	}

	public PeriodoDTO getNotPeriodo() {
		return notPeriodo;
	}

	public void setNotPeriodo(PeriodoDTO notPeriodo) {
		this.notPeriodo = notPeriodo;
	}

 
	

}