package ec.edu.uce.notas.ejb.persistence.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the not_curso database table.
 * 
 */
@Entity
@Table(name="not_paralelo")
@NamedQuery(name="ParaleloDTO.findAll", query="SELECT c FROM ParaleloDTO c")
public class ParaleloDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="NOT_PERdIODO_PROCODIGO_GENERATOR", sequenceName="NOT_PERIODO_PRO_CODIGO_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="NOT_PERdIODO_PROCODIGO_GENERATOR")
	@Column(name="par_codigo")
	private Integer parCodigo;

	@Column(name="par_descripcion")
	private String parDescripcion;
/**
 
	//bi-directional many-to-one association to CursoAlumnoDTO
	@OneToMany(mappedBy="notParalelo")
	private List<CursoAlumnoDTO> notCursoAlumnos;
* 
 */
	public ParaleloDTO() {
	}
	

	public Integer getParCodigo() {
		return parCodigo;
	}



	public void setParCodigo(Integer parCodigo) {
		this.parCodigo = parCodigo;
	}



	public String getParDescripcion() {
		return parDescripcion;
	}



	public void setParDescripcion(String parDescripcion) {
		this.parDescripcion = parDescripcion;
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
		notCursoAlumno.setNotParalelo(this);

		return notCursoAlumno;
	}

	public CursoAlumnoDTO removeNotCursoAlumno(CursoAlumnoDTO notCursoAlumno) {
		getNotCursoAlumnos().remove(notCursoAlumno);
		notCursoAlumno.setNotParalelo(null);

		return notCursoAlumno;
	}
*
 */
}