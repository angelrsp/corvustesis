package ec.edu.uce.notas.ejb.persistence.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the not_curso database table.
 * 
 */
@Entity
@Table(name="not_materia")
@NamedQuery(name="MateriaDTO.findAll", query="SELECT c FROM MateriaDTO c")
public class MateriaDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="NOT_MATERIA_MATCODIGO_GENERATOR", sequenceName="NOT_MATERIA_MAT_CODIGO_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="NOT_MATERIA_MATCODIGO_GENERATOR")
	@Column(name="mat_codigo")
	private Integer matCodigo;

	@Column(name="mat_descripcion")
	private String matDescripcion;

	//bi-directional many-to-one association to CursoAlumnoDTO
	@OneToMany(mappedBy="notMateria")
	private List<CursoAlumnoDTO> notCursoAlumnos;

	public MateriaDTO() {
	}
	

	public Integer getMatCodigo() {
		return matCodigo;
	}



	public void setMatCodigo(Integer matCodigo) {
		this.matCodigo = matCodigo;
	}



	public String getMatDescripcion() {
		return matDescripcion;
	}



	public void setMatDescripcion(String matDescripcion) {
		this.matDescripcion = matDescripcion;
	}



	public List<CursoAlumnoDTO> getNotCursoAlumnos() {
		return this.notCursoAlumnos;
	}

	public void setNotCursoAlumnos(List<CursoAlumnoDTO> notCursoAlumnos) {
		this.notCursoAlumnos = notCursoAlumnos;
	}

	public CursoAlumnoDTO addNotCursoAlumno(CursoAlumnoDTO notCursoAlumno) {
		getNotCursoAlumnos().add(notCursoAlumno);
		notCursoAlumno.setNotMateria(this);

		return notCursoAlumno;
	}

	public CursoAlumnoDTO removeNotCursoAlumno(CursoAlumnoDTO notCursoAlumno) {
		getNotCursoAlumnos().remove(notCursoAlumno);
		notCursoAlumno.setNotMateria(null);

		return notCursoAlumno;
	}

}