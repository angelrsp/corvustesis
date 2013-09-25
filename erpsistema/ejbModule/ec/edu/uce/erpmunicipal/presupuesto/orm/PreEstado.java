package ec.edu.uce.erpmunicipal.presupuesto.orm;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the pre_estado database table.
 * 
 */
@Entity
@Table(name="pre_estado")
public class PreEstado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PRE_ESTADO_ESTCODIGO_GENERATOR", sequenceName="PRE_ESTADO_EST_CODIGO_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PRE_ESTADO_ESTCODIGO_GENERATOR")
	@Column(name="est_codigo")
	private Integer estCodigo;

	@Column(name="est_descripcion")
	private String estDescripcion;

	//bi-directional many-to-one association to PreReforma
	@OneToMany(mappedBy="preEstado")
	private List<PreReforma> preReformas;

	public PreEstado() {
	}

	public Integer getEstCodigo() {
		return this.estCodigo;
	}

	public void setEstCodigo(Integer estCodigo) {
		this.estCodigo = estCodigo;
	}

	public String getEstDescripcion() {
		return this.estDescripcion;
	}

	public void setEstDescripcion(String estDescripcion) {
		this.estDescripcion = estDescripcion;
	}

	public List<PreReforma> getPreReformas() {
		return this.preReformas;
	}

	public void setPreReformas(List<PreReforma> preReformas) {
		this.preReformas = preReformas;
	}

}