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
	@SequenceGenerator(name="NOT_MATERIA_MATCODIGO_GENERATOR", sequenceName="NOT_MATERIA_MAT_CODIGO_SEQ",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="NOT_MATERIA_MATCODIGO_GENERATOR")
	@Column(name="mat_codigo")
	private Integer matCodigo;

	@Column(name="mat_descripcion")
	private String matDescripcion;

	//bi-directional many-to-one association to MateriaDocenteDTO
	@OneToMany(mappedBy="notMateria")
	private List<MateriaDocenteDTO> notMateriaDocentes;

	public MateriaDTO() {
	}

	public Integer getMatCodigo() {
		return this.matCodigo;
	}

	public void setMatCodigo(Integer matCodigo) {
		this.matCodigo = matCodigo;
	}

	public String getMatDescripcion() {
		return this.matDescripcion;
	}

	public void setMatDescripcion(String matDescripcion) {
		this.matDescripcion = matDescripcion;
	}

	public List<MateriaDocenteDTO> getNotMateriaDocentes() {
		return this.notMateriaDocentes;
	}

	public void setNotMateriaDocentes(List<MateriaDocenteDTO> notMateriaDocentes) {
		this.notMateriaDocentes = notMateriaDocentes;
	}

	public MateriaDocenteDTO addNotMateriaDocente(MateriaDocenteDTO notMateriaDocente) {
		getNotMateriaDocentes().add(notMateriaDocente);
		notMateriaDocente.setNotMateria(this);

		return notMateriaDocente;
	}

	public MateriaDocenteDTO removeNotMateriaDocente(MateriaDocenteDTO notMateriaDocente) {
		getNotMateriaDocentes().remove(notMateriaDocente);
		notMateriaDocente.setNotMateria(null);

		return notMateriaDocente;
	}

}