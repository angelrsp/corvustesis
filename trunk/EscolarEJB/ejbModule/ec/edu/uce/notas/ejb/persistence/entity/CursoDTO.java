package ec.edu.uce.notas.ejb.persistence.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the not_curso database table.
 * 
 */
@Entity
@Table(name="not_curso")
@NamedQuery(name="CursoDTO.findAll", query="SELECT c FROM CursoDTO c")
public class CursoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="NOT_CURSO_CURCODIGO_GENERATOR", sequenceName="NOT_CURSO_CUR_CODIGO_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="NOT_CURSO_CURCODIGO_GENERATOR")
	@Column(name="cur_codigo")
	private Integer curCodigo;

	@Column(name="cur_descripcion")
	private String curDescripcion;

	//bi-directional many-to-one association to CursoAlumnoDTO
	@OneToMany(mappedBy="notCurso")
	private List<CursoAlumnoDTO> notCursoAlumnos;

	public CursoDTO() {
	}

	public Integer getCurCodigo() {
		return this.curCodigo;
	}

	public void setCurCodigo(Integer curCodigo) {
		this.curCodigo = curCodigo;
	}

	public String getCurDescripcion() {
		return this.curDescripcion;
	}

	public void setCurDescripcion(String curDescripcion) {
		this.curDescripcion = curDescripcion;
	}

	public List<CursoAlumnoDTO> getNotCursoAlumnos() {
		return this.notCursoAlumnos;
	}

	public void setNotCursoAlumnos(List<CursoAlumnoDTO> notCursoAlumnos) {
		this.notCursoAlumnos = notCursoAlumnos;
	}

	public CursoAlumnoDTO addNotCursoAlumno(CursoAlumnoDTO notCursoAlumno) {
		getNotCursoAlumnos().add(notCursoAlumno);
		notCursoAlumno.setNotCurso(this);

		return notCursoAlumno;
	}

	public CursoAlumnoDTO removeNotCursoAlumno(CursoAlumnoDTO notCursoAlumno) {
		getNotCursoAlumnos().remove(notCursoAlumno);
		notCursoAlumno.setNotCurso(null);

		return notCursoAlumno;
	}

}