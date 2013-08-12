package ec.edu.uce.erpmunicipal.contabilidad.orm;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.math.BigDecimal;


/**
 * The persistent class for the con_movimiento_detalle database table.
 * 
 */
@Entity
@Table(name="con_movimiento_detalle")
public class ConMovimientoDetalle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CON_MOVIMIENTO_DETALLE_MDECODIGO_GENERATOR", sequenceName="CON_MOVIMIENTO_DETALLE_MDE_CODIGO_SEQ",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CON_MOVIMIENTO_DETALLE_MDECODIGO_GENERATOR")
	@Column(name="mde_codigo")
	private Integer mdeCodigo;

	@Column(name="mde_debe")
	private BigDecimal mdeDebe;

	@Column(name="mde_entidad")
	private Integer mdeEntidad;

	@Column(name="mde_fecha")
	private Timestamp mdeFecha;

	@Column(name="mde_haber")
	private BigDecimal mdeHaber;

	@Column(name="mde_saldo")
	private BigDecimal mdeSaldo;

	//bi-directional many-to-one association to ConCuenta
	@ManyToOne
	@JoinColumn(name="mde_cuenta")
	private ConCuenta conCuenta;

	//bi-directional many-to-one association to ConMovimiento
	@ManyToOne
	@JoinColumn(name="mde_movimiento")
	private ConMovimiento conMovimiento;

	//bi-directional many-to-one association to ConPeriodo
	@ManyToOne
	@JoinColumn(name="mde_periodo")
	private ConPeriodo conPeriodo;

	public ConMovimientoDetalle() {
	}

	public Integer getMdeCodigo() {
		return this.mdeCodigo;
	}

	public void setMdeCodigo(Integer mdeCodigo) {
		this.mdeCodigo = mdeCodigo;
	}

	public BigDecimal getMdeDebe() {
		return this.mdeDebe;
	}

	public void setMdeDebe(BigDecimal mdeDebe) {
		this.mdeDebe = mdeDebe;
	}

	public Integer getMdeEntidad() {
		return this.mdeEntidad;
	}

	public void setMdeEntidad(Integer mdeEntidad) {
		this.mdeEntidad = mdeEntidad;
	}

	public Timestamp getMdeFecha() {
		return this.mdeFecha;
	}

	public void setMdeFecha(Timestamp mdeFecha) {
		this.mdeFecha = mdeFecha;
	}

	public BigDecimal getMdeHaber() {
		return this.mdeHaber;
	}

	public void setMdeHaber(BigDecimal mdeHaber) {
		this.mdeHaber = mdeHaber;
	}

	public BigDecimal getMdeSaldo() {
		return this.mdeSaldo;
	}

	public void setMdeSaldo(BigDecimal mdeSaldo) {
		this.mdeSaldo = mdeSaldo;
	}

	public ConCuenta getConCuenta() {
		return this.conCuenta;
	}

	public void setConCuenta(ConCuenta conCuenta) {
		this.conCuenta = conCuenta;
	}

	public ConMovimiento getConMovimiento() {
		return this.conMovimiento;
	}

	public void setConMovimiento(ConMovimiento conMovimiento) {
		this.conMovimiento = conMovimiento;
	}

	public ConPeriodo getConPeriodo() {
		return this.conPeriodo;
	}

	public void setConPeriodo(ConPeriodo conPeriodo) {
		this.conPeriodo = conPeriodo;
	}

}