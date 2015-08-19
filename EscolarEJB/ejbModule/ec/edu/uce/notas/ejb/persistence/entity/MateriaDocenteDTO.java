package ec.edu.uce.notas.ejb.persistence.entity;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the not_materia_docente database table.
 * 
 */
@Entity
@Table(name="not_materia_docente")
@NamedQuery(name="MateriaDocenteDTO.findAll", query="SELECT m FROM MateriaDocenteDTO m")
public class MateriaDocenteDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="NOT_MATERIA_DOCENTE_MADCODIGO_GENERATOR", sequenceName="IND_MATERIA_DOCENTE_MAD_CODIGO_SEQ",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="NOT_MATERIA_DOCENTE_MADCODIGO_GENERATOR")
	@Column(name="mad_codigo")
	private Integer madCodigo;

	//bi-directional many-to-one association to CursoAlumnoDTO
	@OneToMany(mappedBy="notMateriaDocente")
	private List<CursoAlumnoDTO> notCursoAlumnos;

	//bi-directional many-to-one association to DocenteDTO
	@ManyToOne
	@JoinColumn(name="mad_docente")
	private DocenteDTO notDocente;

	//bi-directional many-to-one association to MateriaDTO
	@ManyToOne
	@JoinColumn(name="mad_materia")
	private MateriaDTO notMateria;

	//bi-directional many-to-one association to PeriodoDTO
	@ManyToOne
	@JoinColumn(name="mad_periodo")
	private PeriodoDTO notPeriodo;
	
	//bi-directional many-to-one association to MateriaDDTO
	@ManyToOne
	@JoinColumn(name="cal_curso_paralelo")
	private CursoParaleloDTO notCursoParalelo;

	public MateriaDocenteDTO() {
	}

	public Integer getMadCodigo() {
		return this.madCodigo;
	}

	public void setMadCodigo(Integer madCodigo) {
		this.madCodigo = madCodigo;
	}

	public List<CursoAlumnoDTO> getNotCursoAlumnos() {
		return this.notCursoAlumnos;
	}

	public void setNotCursoAlumnos(List<CursoAlumnoDTO> notCursoAlumnos) {
		this.notCursoAlumnos = notCursoAlumnos;
	}

	public CursoAlumnoDTO addNotCursoAlumno(CursoAlumnoDTO notCursoAlumno) {
		getNotCursoAlumnos().add(notCursoAlumno);
		notCursoAlumno.setNotMateriaDocente(this);

		return notCursoAlumno;
	}

	public CursoAlumnoDTO removeNotCursoAlumno(CursoAlumnoDTO notCursoAlumno) {
		getNotCursoAlumnos().remove(notCursoAlumno);
		notCursoAlumno.setNotMateriaDocente(null);

		return notCursoAlumno;
	}

	public DocenteDTO getNotDocente() {
		return this.notDocente;
	}

	public void setNotDocente(DocenteDTO notDocente) {
		this.notDocente = notDocente;
	}

	public MateriaDTO getNotMateria() {
		return this.notMateria;
	}

	public void setNotMateria(MateriaDTO notMateria) {
		this.notMateria = notMateria;
	}

	public PeriodoDTO getNotPeriodo() {
		return this.notPeriodo;
	}

	public void setNotPeriodo(PeriodoDTO notPeriodo) {
		this.notPeriodo = notPeriodo;
	}

	public CursoParaleloDTO getNotCursoParalelo() {
		return notCursoParalelo;
	}

	public void setNotCursoParalelo(CursoParaleloDTO notCursoParalelo) {
		this.notCursoParalelo = notCursoParalelo;
	}
   
	
	
}