package ec.edu.uce.erpmunicipal.presupuesto.orm;

import java.io.Serializable;
import javax.persistence.*;

import ec.edu.uce.erpmunicipal.contabilidad.orm.ConCuenta;

import java.math.BigDecimal;


/**
 * The persistent class for the pre_reforma_detalle database table.
 * 
 */
@Entity
@Table(name="pre_reforma_detalle")
public class PreReformaDetalle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PRE_REFORMA_DETALLE_RDECODIGO_GENERATOR", sequenceName="PRE_REFORMA_DETALLE_RDE_CODIGO_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PRE_REFORMA_DETALLE_RDECODIGO_GENERATOR")
	@Column(name="rde_codigo")
	private Integer rdeCodigo;

	@Column(name="rde_valor")
	private BigDecimal rdeValor;

	//bi-directional many-to-one association to PreReforma
	@ManyToOne
	@JoinColumn(name="rde_reforma")
	private PreReforma preReforma;

	//bi-directional many-to-one association to PreTipoReforma
	@ManyToOne
	@JoinColumn(name="rde_tipo_reforma")
	private PreTipoReforma preTipoReforma;
	
	@ManyToOne
	@JoinColumn(name="rde_cuenta")
	private ConCuenta conCuenta;


	public PreReformaDetalle() {
	}

	public Integer getRdeCodigo() {
		return this.rdeCodigo;
	}

	public void setRdeCodigo(Integer rdeCodigo) {
		this.rdeCodigo = rdeCodigo;
	}

	public BigDecimal getRdeValor() {
		return this.rdeValor;
	}

	public void setRdeValor(BigDecimal rdeValor) {
		this.rdeValor = rdeValor;
	}

	public PreReforma getPreReforma() {
		return this.preReforma;
	}

	public void setPreReforma(PreReforma preReforma) {
		this.preReforma = preReforma;
	}

	public PreTipoReforma getPreTipoReforma() {
		return this.preTipoReforma;
	}

	public void setPreTipoReforma(PreTipoReforma preTipoReforma) {
		this.preTipoReforma = preTipoReforma;
	}

	public ConCuenta getConCuenta() {
		return conCuenta;
	}

	public void setConCuenta(ConCuenta conCuenta) {
		this.conCuenta = conCuenta;
	}

}