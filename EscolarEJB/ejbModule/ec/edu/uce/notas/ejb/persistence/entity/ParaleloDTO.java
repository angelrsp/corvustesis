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
	@SequenceGenerator(name="NOT_PARALELO_PARCODIGO_GENERATOR", sequenceName="NOT_PARALELO_PAR_CODIGO_SEQ"  ,allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="NOT_PARALELO_PARCODIGO_GENERATOR")
	@Column(name="par_codigo")
	private Integer parCodigo;

	@Column(name="par_descripcion")
	private String parDescripcion;

	//bi-directional many-to-one association to CursoParaleloDTO
	@OneToMany(mappedBy="notParalelo")
	private List<CursoParaleloDTO> notCursoParalelos;

	public ParaleloDTO() {
	}

	public Integer getParCodigo() {
		return this.parCodigo;
	}

	public void setParCodigo(Integer parCodigo) {
		this.parCodigo = parCodigo;
	}

	public String getParDescripcion() {
		return this.parDescripcion;
	}

	public void setParDescripcion(String parDescripcion) {
		this.parDescripcion = parDescripcion;
	}

	public List<CursoParaleloDTO> getNotCursoParalelos() {
		return this.notCursoParalelos;
	}

	public void setNotCursoParalelos(List<CursoParaleloDTO> notCursoParalelos) {
		this.notCursoParalelos = notCursoParalelos;
	}

	public CursoParaleloDTO addNotCursoParalelo(CursoParaleloDTO notCursoParalelo) {
		getNotCursoParalelos().add(notCursoParalelo);
		notCursoParalelo.setNotParalelo(this);

		return notCursoParalelo;
	}

	public CursoParaleloDTO removeNotCursoParalelo(CursoParaleloDTO notCursoParalelo) {
		getNotCursoParalelos().remove(notCursoParalelo);
		notCursoParalelo.setNotParalelo(null);

		return notCursoParalelo;
	}


}