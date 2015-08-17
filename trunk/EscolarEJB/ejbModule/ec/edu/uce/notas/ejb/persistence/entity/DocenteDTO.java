package ec.edu.uce.notas.ejb.persistence.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the not_docente database table.
 * 
 */
@Entity
@Table(name="not_docente")
@NamedQuery(name="DocenteDTO.findAll", query="SELECT d FROM DocenteDTO d")
public class DocenteDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="NOT_DOCENTE_DOCCODIGO_GENERATOR", sequenceName="NOT_DOCENTE_DOC_CODIGO_SEQ",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="NOT_DOCENTE_DOCCODIGO_GENERATOR")
	@Column(name="doc_codigo")
	private Integer docCodigo;

	@Column(name="doc_usuario")
	private Integer docUsuario;

	//bi-directional many-to-one association to CursoAlumnoDTO
	@OneToMany(mappedBy="notDocente")
	private List<CursoAlumnoDTO> notCursoAlumnos;

	public DocenteDTO() {
	}

	public Integer getDocCodigo() {
		return this.docCodigo;
	}

	public void setDocCodigo(Integer docCodigo) {
		this.docCodigo = docCodigo;
	}

	public Integer getDocUsuario() {
		return this.docUsuario;
	}

	public void setDocUsuario(Integer docUsuario) {
		this.docUsuario = docUsuario;
	}

	public List<CursoAlumnoDTO> getNotCursoAlumnos() {
		return this.notCursoAlumnos;
	}

	public void setNotCursoAlumnos(List<CursoAlumnoDTO> notCursoAlumnos) {
		this.notCursoAlumnos = notCursoAlumnos;
	}

	public CursoAlumnoDTO addNotCursoAlumno(CursoAlumnoDTO notCursoAlumno) {
		getNotCursoAlumnos().add(notCursoAlumno);
		notCursoAlumno.setNotDocente(this);

		return notCursoAlumno;
	}

	public CursoAlumnoDTO removeNotCursoAlumno(CursoAlumnoDTO notCursoAlumno) {
		getNotCursoAlumnos().remove(notCursoAlumno);
		notCursoAlumno.setNotDocente(null);

		return notCursoAlumno;
	}

}