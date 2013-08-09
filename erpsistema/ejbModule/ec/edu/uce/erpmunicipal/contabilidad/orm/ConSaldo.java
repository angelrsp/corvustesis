package ec.edu.uce.erpmunicipal.contabilidad.orm;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the con_saldo database table.
 * 
 */
@Entity
@Table(name="con_saldo")
public class ConSaldo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CON_SALDO_SALCODIGO_GENERATOR", sequenceName="CON_SALDO_SAL_CODIGO_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CON_SALDO_SALCODIGO_GENERATOR")
	@Column(name="sal_codigo")
	private Integer salCodigo;

	@Column(name="sal_debe")
	private BigDecimal salDebe;

	@Column(name="sal_haber")
	private BigDecimal salHaber;

	@Column(name="sal_periodo")
	private Integer salPeriodo;

	@Column(name="sal_saldo")
	private BigDecimal salSaldo;

	//bi-directional many-to-one association to ConCuenta
	@ManyToOne
	@JoinColumn(name="sal_cuenta")
	private ConCuenta conCuenta;

	public ConSaldo() {
	}

	public Integer getSalCodigo() {
		return this.salCodigo;
	}

	public void setSalCodigo(Integer salCodigo) {
		this.salCodigo = salCodigo;
	}

	public BigDecimal getSalDebe() {
		return this.salDebe;
	}

	public void setSalDebe(BigDecimal salDebe) {
		this.salDebe = salDebe;
	}

	public BigDecimal getSalHaber() {
		return this.salHaber;
	}

	public void setSalHaber(BigDecimal salHaber) {
		this.salHaber = salHaber;
	}

	public Integer getSalPeriodo() {
		return this.salPeriodo;
	}

	public void setSalPeriodo(Integer salPeriodo) {
		this.salPeriodo = salPeriodo;
	}

	public BigDecimal getSalSaldo() {
		return this.salSaldo;
	}

	public void setSalSaldo(BigDecimal salSaldo) {
		this.salSaldo = salSaldo;
	}

	public ConCuenta getConCuenta() {
		return this.conCuenta;
	}

	public void setConCuenta(ConCuenta conCuenta) {
		this.conCuenta = conCuenta;
	}

}