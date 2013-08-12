package ec.edu.uce.erpmunicipal.contabilidad.orm;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the con_periodo database table.
 * 
 */
@Entity
@Table(name="con_periodo")
public class ConPeriodo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CON_PERIODO_PERCODIGO_GENERATOR", sequenceName="CON_PERIODO_PER_CODIGO_SEQ",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CON_PERIODO_PERCODIGO_GENERATOR")
	@Column(name="per_codigo")
	private Integer perCodigo;

	@Column(name="per_anio")
	private Integer perAnio;

	@Column(name="per_mes")
	private Integer perMes;

	//bi-directional many-to-one association to ConMovimientoDetalle
	@OneToMany(mappedBy="conPeriodo")
	private List<ConMovimientoDetalle> conMovimientoDetalles;

	public ConPeriodo() {
	}

	public Integer getPerCodigo() {
		return this.perCodigo;
	}

	public void setPerCodigo(Integer perCodigo) {
		this.perCodigo = perCodigo;
	}

	public Integer getPerAnio() {
		return this.perAnio;
	}

	public void setPerAnio(Integer perAnio) {
		this.perAnio = perAnio;
	}

	public Integer getPerMes() {
		return this.perMes;
	}

	public void setPerMes(Integer perMes) {
		this.perMes = perMes;
	}

	public List<ConMovimientoDetalle> getConMovimientoDetalles() {
		return this.conMovimientoDetalles;
	}

	public void setConMovimientoDetalles(List<ConMovimientoDetalle> conMovimientoDetalles) {
		this.conMovimientoDetalles = conMovimientoDetalles;
	}

}