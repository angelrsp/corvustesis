package ec.edu.uce.erpmunicipal.presupuesto.orm;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the pre_tipo_reforma database table.
 * 
 */
@Entity
@Table(name="pre_tipo_reforma")
public class PreTipoReforma implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PRE_TIPO_REFORMA_TRECODIGO_GENERATOR", sequenceName="PRE_TIPO_REFORMA_TRE_CODIGO_SEQ",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PRE_TIPO_REFORMA_TRECODIGO_GENERATOR")
	@Column(name="tre_codigo")
	private Integer treCodigo;

	@Column(name="tre_descaripcion")
	private String treDescaripcion;

	//bi-directional many-to-one association to PreReformaDetalle
	@OneToMany(mappedBy="preTipoReforma")
	private List<PreReformaDetalle> preReformaDetalles;

	public PreTipoReforma() {
	}

	public Integer getTreCodigo() {
		return this.treCodigo;
	}

	public void setTreCodigo(Integer treCodigo) {
		this.treCodigo = treCodigo;
	}

	public String getTreDescaripcion() {
		return this.treDescaripcion;
	}

	public void setTreDescaripcion(String treDescaripcion) {
		this.treDescaripcion = treDescaripcion;
	}

	public List<PreReformaDetalle> getPreReformaDetalles() {
		return this.preReformaDetalles;
	}

	public void setPreReformaDetalles(List<PreReformaDetalle> preReformaDetalles) {
		this.preReformaDetalles = preReformaDetalles;
	}

}