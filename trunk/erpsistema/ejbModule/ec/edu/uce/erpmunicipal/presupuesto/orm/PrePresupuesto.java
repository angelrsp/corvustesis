package ec.edu.uce.erpmunicipal.presupuesto.orm;

import java.io.Serializable;
import javax.persistence.*;

import ec.edu.uce.erpmunicipal.contabilidad.orm.ConCuenta;

import java.sql.Timestamp;
import java.math.BigDecimal;


/**
 * The persistent class for the pre_presupuesto database table.
 * 
 */
@Entity
@Table(name="pre_presupuesto")
public class PrePresupuesto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PRE_PRESUPUESTO_PRECODIGO_GENERATOR", sequenceName="PRE_PRESUPUESTO_PRE_CODIGO_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PRE_PRESUPUESTO_PRECODIGO_GENERATOR")
	@Column(name="pre_codigo")
	private Integer preCodigo;

	@Column(name="pre_egreso")
	private BigDecimal preEgreso;

	@Column(name="pre_fecha")
	private Timestamp preFecha;

	@Column(name="pre_ingreso")
	private BigDecimal preIngreso;

	@Column(name="pre_inicial")
	private Boolean preInicial;

	@Column(name="pre_saldo")
	private BigDecimal preSaldo;

	@Column(name="pre_ultimo")
	private Boolean preUltimo;
	
	@ManyToOne
	@JoinColumn(name="pre_cuenta")
	private ConCuenta conCuenta;
	
	
	public PrePresupuesto() {
	}

	public Integer getPreCodigo() {
		return this.preCodigo;
	}

	public void setPreCodigo(Integer preCodigo) {
		this.preCodigo = preCodigo;
	}

	public ConCuenta getConCuenta() {
		return this.conCuenta;
	}

	public void setConCuenta(ConCuenta conCuenta) {
		this.conCuenta = conCuenta;
	}

	public BigDecimal getPreEgreso() {
		return this.preEgreso;
	}

	public void setPreEgreso(BigDecimal preEgreso) {
		this.preEgreso = preEgreso;
	}

	public Timestamp getPreFecha() {
		return this.preFecha;
	}

	public void setPreFecha(Timestamp preFecha) {
		this.preFecha = preFecha;
	}

	public BigDecimal getPreIngreso() {
		return this.preIngreso;
	}

	public void setPreIngreso(BigDecimal preIngreso) {
		this.preIngreso = preIngreso;
	}

	public Boolean getPreInicial() {
		return this.preInicial;
	}

	public void setPreInicial(Boolean preInicial) {
		this.preInicial = preInicial;
	}

	public BigDecimal getPreSaldo() {
		return this.preSaldo;
	}

	public void setPreSaldo(BigDecimal preSaldo) {
		this.preSaldo = preSaldo;
	}

	public Boolean getPreUltimo() {
		return this.preUltimo;
	}

	public void setPreUltimo(Boolean preUltimo) {
		this.preUltimo = preUltimo;
	}

}