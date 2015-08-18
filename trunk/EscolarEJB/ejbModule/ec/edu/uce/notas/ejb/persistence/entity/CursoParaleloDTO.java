package ec.edu.uce.notas.ejb.persistence.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the not_curso_paralelo database table.
 * 
 */
@Entity
@Table(name="not_curso_paralelo")
@NamedQuery(name="CursoParaleloDTO.findAll", query="SELECT c FROM CursoParaleloDTO c")
public class CursoParaleloDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="NOT_CURSO_PARALELO_CPACODIGO_GENERATOR", sequenceName="NOT_CURSO_PARALELO_CPA_CODIGO_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="NOT_CURSO_PARALELO_CPACODIGO_GENERATOR")
	@Column(name="cpa_codigo")
	private Integer cpaCodigo;

	//bi-directional many-to-one association to CursoAlumnoDTO
	@OneToMany(mappedBy="notCursoParalelo")
	private List<CursoAlumnoDTO> notCursoAlumnos;

	//bi-directional many-to-one association to CursoDTO
	@ManyToOne
	@JoinColumn(name="cpa_curso")
	private CursoDTO notCurso;

	//bi-directional many-to-one association to ParaleloDTO
	@ManyToOne
	@JoinColumn(name="cpa_paralelo")
	private ParaleloDTO notParalelo;

	public CursoParaleloDTO() {
	}

	public Integer getCpaCodigo() {
		return this.cpaCodigo;
	}

	public void setCpaCodigo(Integer cpaCodigo) {
		this.cpaCodigo = cpaCodigo;
	}

	public List<CursoAlumnoDTO> getNotCursoAlumnos() {
		return this.notCursoAlumnos;
	}

	public void setNotCursoAlumnos(List<CursoAlumnoDTO> notCursoAlumnos) {
		this.notCursoAlumnos = notCursoAlumnos;
	}

	public CursoAlumnoDTO addNotCursoAlumno(CursoAlumnoDTO notCursoAlumno) {
		getNotCursoAlumnos().add(notCursoAlumno);
		notCursoAlumno.setNotCursoParalelo(this);

		return notCursoAlumno;
	}

	public CursoAlumnoDTO removeNotCursoAlumno(CursoAlumnoDTO notCursoAlumno) {
		getNotCursoAlumnos().remove(notCursoAlumno);
		notCursoAlumno.setNotCursoParalelo(null);

		return notCursoAlumno;
	}

	public CursoDTO getNotCurso() {
		return this.notCurso;
	}

	public void setNotCurso(CursoDTO notCurso) {
		this.notCurso = notCurso;
	}

	public ParaleloDTO getNotParalelo() {
		return this.notParalelo;
	}

	public void setNotParalelo(ParaleloDTO notParalelo) {
		this.notParalelo = notParalelo;
	}

}