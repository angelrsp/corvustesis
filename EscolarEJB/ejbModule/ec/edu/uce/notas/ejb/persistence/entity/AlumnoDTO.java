package ec.edu.uce.notas.ejb.persistence.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the not_alumno database table.
 * 
 */
@Entity
@Table(name="not_alumno")
@NamedQuery(name="AlumnoDTO.findAll", query="SELECT a FROM AlumnoDTO a")
public class AlumnoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="NOT_ALUMNO_ALUCODIGO_GENERATOR", sequenceName="NOT_ALUMNO_ALU_CODIGO_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="NOT_ALUMNO_ALUCODIGO_GENERATOR")
	@Column(name="alu_codigo")
	private Integer aluCodigo;

	@Column(name="alu_usuario")
	private Integer aluUsuario;

	//bi-directional many-to-one association to CursoAlumnoDTO
	@OneToMany(mappedBy="notAlumno")
	private List<CursoAlumnoDTO> notCursoAlumnos;

	public AlumnoDTO() {
	}

	public Integer getAluCodigo() {
		return this.aluCodigo;
	}

	public void setAluCodigo(Integer aluCodigo) {
		this.aluCodigo = aluCodigo;
	}

	public Integer getAluUsuario() {
		return this.aluUsuario;
	}

	public void setAluUsuario(Integer aluUsuario) {
		this.aluUsuario = aluUsuario;
	}

	public List<CursoAlumnoDTO> getNotCursoAlumnos() {
		return this.notCursoAlumnos;
	}

	public void setNotCursoAlumnos(List<CursoAlumnoDTO> notCursoAlumnos) {
		this.notCursoAlumnos = notCursoAlumnos;
	}

	public CursoAlumnoDTO addNotCursoAlumno(CursoAlumnoDTO notCursoAlumno) {
		getNotCursoAlumnos().add(notCursoAlumno);
		notCursoAlumno.setNotAlumno(this);

		return notCursoAlumno;
	}

	public CursoAlumnoDTO removeNotCursoAlumno(CursoAlumnoDTO notCursoAlumno) {
		getNotCursoAlumnos().remove(notCursoAlumno);
		notCursoAlumno.setNotAlumno(null);

		return notCursoAlumno;
	}

}