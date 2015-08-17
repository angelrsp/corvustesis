package ec.edu.uce.notas.ejb.persistence.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the not_nota database table.
 * 
 */
@Entity
@Table(name="not_nota")
@NamedQuery(name="NotaDTO.findAll", query="SELECT n FROM NotaDTO n")
public class NotaDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="NOT_NOTA_NOTCODIGO_GENERATOR", sequenceName="NOT_NOTA_NOT_CODIGO_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="NOT_NOTA_NOTCODIGO_GENERATOR")
	@Column(name="not_codigo")
	private Integer notCodigo;

	@Column(name="not_valor")
	private BigDecimal notValor;

	//bi-directional many-to-one association to CursoAlumnoDTO
	@ManyToOne
	@JoinColumn(name="not_curso_alumno")
	private CursoAlumnoDTO notCursoAlumnoBean;

	//bi-directional many-to-one association to TipoNotaDTO
	@ManyToOne
	@JoinColumn(name="not_tipo_nota")
	private TipoNotaDTO notTipoNotaBean;

	public NotaDTO() {
	}

	public Integer getNotCodigo() {
		return this.notCodigo;
	}

	public void setNotCodigo(Integer notCodigo) {
		this.notCodigo = notCodigo;
	}

	public BigDecimal getNotValor() {
		return this.notValor;
	}

	public void setNotValor(BigDecimal notValor) {
		this.notValor = notValor;
	}

	public CursoAlumnoDTO getNotCursoAlumnoBean() {
		return this.notCursoAlumnoBean;
	}

	public void setNotCursoAlumnoBean(CursoAlumnoDTO notCursoAlumnoBean) {
		this.notCursoAlumnoBean = notCursoAlumnoBean;
	}

	public TipoNotaDTO getNotTipoNotaBean() {
		return this.notTipoNotaBean;
	}

	public void setNotTipoNotaBean(TipoNotaDTO notTipoNotaBean) {
		this.notTipoNotaBean = notTipoNotaBean;
	}

}