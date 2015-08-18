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
	@SequenceGenerator(name="NOT_DOCENTE_DOCCODIGO_GENERATOR" , sequenceName="NOT_DOCENTE_DOC_CODIGO_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="NOT_DOCENTE_DOCCODIGO_GENERATOR")
	@Column(name="doc_codigo")
	private Integer docCodigo;

	@Column(name="doc_usuario")
	private Integer docUsuario;

	//bi-directional many-to-one association to MateriaDocenteDTO
	@OneToMany(mappedBy="notDocente")
	private List<MateriaDocenteDTO> notMateriaDocentes;

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

	public List<MateriaDocenteDTO> getNotMateriaDocentes() {
		return this.notMateriaDocentes;
	}

	public void setNotMateriaDocentes(List<MateriaDocenteDTO> notMateriaDocentes) {
		this.notMateriaDocentes = notMateriaDocentes;
	}

	public MateriaDocenteDTO addNotMateriaDocente(MateriaDocenteDTO notMateriaDocente) {
		getNotMateriaDocentes().add(notMateriaDocente);
		notMateriaDocente.setNotDocente(this);

		return notMateriaDocente;
	}

	public MateriaDocenteDTO removeNotMateriaDocente(MateriaDocenteDTO notMateriaDocente) {
		getNotMateriaDocentes().remove(notMateriaDocente);
		notMateriaDocente.setNotDocente(null);

		return notMateriaDocente;
	}

}