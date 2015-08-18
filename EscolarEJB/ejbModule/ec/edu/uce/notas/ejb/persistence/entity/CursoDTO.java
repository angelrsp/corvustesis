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
	@SequenceGenerator(name="NOT_CURSO_CURCODIGO_GENERATOR", sequenceName="NOT_CURSO_CUR_CODIGO_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="NOT_CURSO_CURCODIGO_GENERATOR")
	@Column(name="cur_codigo")
	private Integer curCodigo;

	@Column(name="cur_descripcion")
	private String curDescripcion;

	//bi-directional many-to-one association to CursoParaleloDTO
	@OneToMany(mappedBy="notCurso")
	private List<CursoParaleloDTO> notCursoParalelos;

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

	public List<CursoParaleloDTO> getNotCursoParalelos() {
		return this.notCursoParalelos;
	}

	public void setNotCursoParalelos(List<CursoParaleloDTO> notCursoParalelos) {
		this.notCursoParalelos = notCursoParalelos;
	}

	public CursoParaleloDTO addNotCursoParalelo(CursoParaleloDTO notCursoParalelo) {
		getNotCursoParalelos().add(notCursoParalelo);
		notCursoParalelo.setNotCurso(this);

		return notCursoParalelo;
	}

	public CursoParaleloDTO removeNotCursoParalelo(CursoParaleloDTO notCursoParalelo) {
		getNotCursoParalelos().remove(notCursoParalelo);
		notCursoParalelo.setNotCurso(null);

		return notCursoParalelo;
	}

}