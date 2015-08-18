package ec.edu.uce.notas.ejb.persistence.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the not_curso database table.
 * 
 */
@Entity
@Table(name="not_periodo")
@NamedQuery(name="PeriodoDTO.findAll", query="SELECT c FROM PeriodoDTO c")
public class PeriodoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="NOT_PERIODO_PERCODIGO_GENERATOR", sequenceName="NOT_PERIODO_PER_CODIGO_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="NOT_PERIODO_PERCODIGO_GENERATOR")
	@Column(name="per_codigo")
	private Integer perCodigo;

	@Column(name="per_descripcion")
	private String perDescripcion;
/**
 
	//bi-directional many-to-one association to CursoAlumnoDTO
	@OneToMany(mappedBy="notPeriodo")
	private List<CursoAlumnoDTO> notCursoAlumnos;
* 
 */
	public PeriodoDTO() {
	}
public Integer getPerCodigo() {
	return perCodigo;
}
public void setPerCodigo(Integer perCodigo) {
	this.perCodigo = perCodigo;
}
public String getPerDescripcion() {
	return perDescripcion;
}
public void setPerDescripcion(String perDescripcion) {
	this.perDescripcion = perDescripcion;
}
	
	
	/**
	 * 

	public List<CursoAlumnoDTO> getNotCursoAlumnos() {
		return this.notCursoAlumnos;
	}

	public void setNotCursoAlumnos(List<CursoAlumnoDTO> notCursoAlumnos) {
		this.notCursoAlumnos = notCursoAlumnos;
	}

 
	public CursoAlumnoDTO addNotCursoAlumno(CursoAlumnoDTO notCursoAlumno) {
		getNotCursoAlumnos().add(notCursoAlumno);
		notCursoAlumno.setNotPeriodo(this);

		return notCursoAlumno;
	}

	public CursoAlumnoDTO removeNotCursoAlumno(CursoAlumnoDTO notCursoAlumno) {
		getNotCursoAlumnos().remove(notCursoAlumno);
		notCursoAlumno.setNotPeriodo(null);

		return notCursoAlumno;
	}
*
 */
}