package ec.edu.uce.erpmunicipal.contabilidad.orm;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the rep_balance_comprobacion database table.
 * 
 */
@Entity
@Table(name="rep_balance_comprobacion")
public class RepBalanceComprobacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cue_codigo")
	private Integer cueCodigo;

	@Column(name="cue_codigo_padre")
	private Integer cueCodigoPadre;

	@Column(name="cue_descripcion")
	private String cueDescripcion;

	@Column(name="cue_entidad")
	private Integer cueEntidad;

	@Column(name="cue_numero")
	private String cueNumero;

	@Column(name="cue_permite_movimiento")
	private Boolean cuePermiteMovimiento;

	@Column(name="cue_subcuenta")
	private Integer cueSubcuenta;

	@Column(name="cue_tipo_cuenta")
	private Integer cueTipoCuenta;

	@Column(name="sal_acreedor")
	private BigDecimal salAcreedor;

	@Column(name="sal_codigo")
	private Integer salCodigo;

	@Column(name="sal_cuenta")
	private Integer salCuenta;

	@Column(name="sal_debe")
	private BigDecimal salDebe;

	@Column(name="sal_deudor")
	private BigDecimal salDeudor;

	@Column(name="sal_haber")
	private BigDecimal salHaber;

	@Column(name="sal_periodo")
	private Integer salPeriodo;

	@Column(name="sal_saldo")
	private BigDecimal salSaldo;

	public RepBalanceComprobacion() {
	}

	public Integer getCueCodigo() {
		return this.cueCodigo;
	}

	public void setCueCodigo(Integer cueCodigo) {
		this.cueCodigo = cueCodigo;
	}

	public Integer getCueCodigoPadre() {
		return this.cueCodigoPadre;
	}

	public void setCueCodigoPadre(Integer cueCodigoPadre) {
		this.cueCodigoPadre = cueCodigoPadre;
	}

	public String getCueDescripcion() {
		return this.cueDescripcion;
	}

	public void setCueDescripcion(String cueDescripcion) {
		this.cueDescripcion = cueDescripcion;
	}

	public Integer getCueEntidad() {
		return this.cueEntidad;
	}

	public void setCueEntidad(Integer cueEntidad) {
		this.cueEntidad = cueEntidad;
	}

	public String getCueNumero() {
		return this.cueNumero;
	}

	public void setCueNumero(String cueNumero) {
		this.cueNumero = cueNumero;
	}

	public Boolean getCuePermiteMovimiento() {
		return this.cuePermiteMovimiento;
	}

	public void setCuePermiteMovimiento(Boolean cuePermiteMovimiento) {
		this.cuePermiteMovimiento = cuePermiteMovimiento;
	}

	public Integer getCueSubcuenta() {
		return this.cueSubcuenta;
	}

	public void setCueSubcuenta(Integer cueSubcuenta) {
		this.cueSubcuenta = cueSubcuenta;
	}

	public Integer getCueTipoCuenta() {
		return this.cueTipoCuenta;
	}

	public void setCueTipoCuenta(Integer cueTipoCuenta) {
		this.cueTipoCuenta = cueTipoCuenta;
	}

	public BigDecimal getSalAcreedor() {
		return this.salAcreedor;
	}

	public void setSalAcreedor(BigDecimal salAcreedor) {
		this.salAcreedor = salAcreedor;
	}

	public Integer getSalCodigo() {
		return this.salCodigo;
	}

	public void setSalCodigo(Integer salCodigo) {
		this.salCodigo = salCodigo;
	}

	public Integer getSalCuenta() {
		return this.salCuenta;
	}

	public void setSalCuenta(Integer salCuenta) {
		this.salCuenta = salCuenta;
	}

	public BigDecimal getSalDebe() {
		return this.salDebe;
	}

	public void setSalDebe(BigDecimal salDebe) {
		this.salDebe = salDebe;
	}

	public BigDecimal getSalDeudor() {
		return this.salDeudor;
	}

	public void setSalDeudor(BigDecimal salDeudor) {
		this.salDeudor = salDeudor;
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

}