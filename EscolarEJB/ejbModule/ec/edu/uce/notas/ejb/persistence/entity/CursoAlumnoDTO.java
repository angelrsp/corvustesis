package ec.edu.uce.notas.ejb.persistence.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


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
	@SequenceGenerator(name="NOT_CURSO_ALUMNO_CALCODIGO_GENERATOR", sequenceName="NOT_CURSO_ALUMNO_CAL_CODIGO_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="NOT_CURSO_ALUMNO_CALCODIGO_GENERATOR")
	@Column(name="cal_codigo")
	private Integer calCodigo;

	//bi-directional many-to-one association to AlumnoDTO
	@ManyToOne
	@JoinColumn(name="cal_alumno")
	private AlumnoDTO notAlumno;

	//bi-directional many-to-one association to CursoDTO
	@ManyToOne
	@JoinColumn(name="cal_curso")
	private CursoDTO notCurso;
	
	@ManyToOne
	@JoinColumn(name="cal_materia")
	private MateriaDTO notMateria;

	//bi-directional many-to-one association to DocenteDTO
	@ManyToOne
	@JoinColumn(name="cal_docente")
	private DocenteDTO notDocente;

	//bi-directional many-to-one association to NotaDTO
	@OneToMany(mappedBy="notCursoAlumnoBean")
	private List<NotaDTO> notNotas;

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

	public CursoDTO getNotCurso() {
		return this.notCurso;
	}

	public void setNotCurso(CursoDTO notCurso) {
		this.notCurso = notCurso;
	}

	public DocenteDTO getNotDocente() {
		return this.notDocente;
	}

	public void setNotDocente(DocenteDTO notDocente) {
		this.notDocente = notDocente;
	}

	public List<NotaDTO> getNotNotas() {
		return this.notNotas;
	}

	public void setNotNotas(List<NotaDTO> notNotas) {
		this.notNotas = notNotas;
	}

	public NotaDTO addNotNota(NotaDTO notNota) {
		getNotNotas().add(notNota);
		notNota.setNotCursoAlumnoBean(this);

		return notNota;
	}

	public NotaDTO removeNotNota(NotaDTO notNota) {
		getNotNotas().remove(notNota);
		notNota.setNotCursoAlumnoBean(null);

		return notNota;
	}

	public MateriaDTO getNotMateria() {
		return notMateria;
	}

	public void setNotMateria(MateriaDTO notMateria) {
		this.notMateria = notMateria;
	}

	
	
}