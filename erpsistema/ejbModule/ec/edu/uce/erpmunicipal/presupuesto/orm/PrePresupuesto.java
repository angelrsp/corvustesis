package ec.edu.uce.erpmunicipal.presupuesto.orm;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.math.BigDecimal;


/**
 * The persistent class for the pre_presupuesto database table.
 * 
 */
@Entity
@Table(name="pre_presupuesto")
@NamedQuery(name="PrePresupuesto.findAll", query="SELECT p FROM PrePresupuesto p")
public class PrePresupuesto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PRE_PRESUPUESTO_PRECODIGO_GENERATOR", sequenceName="PRE_PRESUPUESTO_PRE_CODIGO_SEQ",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PRE_PRESUPUESTO_PRECODIGO_GENERATOR")
	@Column(name="pre_codigo")
	private Integer preCodigo;

	@Column(name="pre_cuenta")
	private Integer preCuenta;

	@Column(name="pre_egreso")
	private BigDecimal preEgreso;

	@Column(name="pre_fecha")
	private Timestamp preFecha;

	@Column(name="pre_ingreso")
	private BigDecimal preIngreso;

	@Column(name="pre_saldo")
	private BigDecimal preSaldo;

	@Column(name="pre_ultimo")
	private Boolean preUltimo;

	@Column(name="pre_inicial")
	private Boolean preInicial;

	
	public PrePresupuesto() {
	}

	public Integer getPreCodigo() {
		return this.preCodigo;
	}

	public void setPreCodigo(Integer preCodigo) {
		this.preCodigo = preCodigo;
	}

	public Integer getPreCuenta() {
		return this.preCuenta;
	}

	public void setPreCuenta(Integer preCuenta) {
		this.preCuenta = preCuenta;
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

	public BigDecimal getPreSaldo() {
		return this.preSaldo;
	}

	public void setPreSaldo(BigDecimal preSaldo) {
		this.preSaldo = preSaldo;
	}

	public Boolean getPreUltimo() {
		return preUltimo;
	}

	public void setPreUltimo(Boolean preUltimo) {
		this.preUltimo = preUltimo;
	}

	public Boolean getPreInicial() {
		return preInicial;
	}

	public void setPreInicial(Boolean preInicial) {
		this.preInicial = preInicial;
	}

}