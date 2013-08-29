package ec.edu.uce.erpmunicipal.contabilidad.orm;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.math.BigDecimal;


/**
 * The persistent class for the rep_diario_general_integrado database table.
 * 
 */
@Entity
@Table(name="rep_diario_general_integrado")
public class RepDiarioGeneralIntegrado implements Serializable {
	private static final long serialVersionUID = 1L;

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

	@Id
	@Column(name="mde_codigo")
	private Integer mdeCodigo;

	@Column(name="mde_cuenta")
	private Integer mdeCuenta;

	@Column(name="mde_debe")
	private BigDecimal mdeDebe;

	@Column(name="mde_entidad")
	private Integer mdeEntidad;

	@Column(name="mde_fecha")
	private Timestamp mdeFecha;

	@Column(name="mde_haber")
	private BigDecimal mdeHaber;

	@Column(name="mde_movimiento")
	private Integer mdeMovimiento;

	@Column(name="mde_periodo")
	private Integer mdePeriodo;

	@Column(name="mde_saldo")
	private BigDecimal mdeSaldo;

	@Column(name="mov_clase")
	private Integer movClase;

	@Column(name="mov_codigo")
	private Integer movCodigo;

	@Column(name="mov_concepto")
	private String movConcepto;

	@Column(name="mov_documento")
	private String movDocumento;

	@Column(name="mov_entidad")
	private Integer movEntidad;

	@Column(name="mov_estado")
	private Boolean movEstado;

	@Column(name="mov_fecha")
	private Timestamp movFecha;

	@Column(name="mov_fecha_contable")
	private Timestamp movFechaContable;

	@Column(name="mov_tipo_movimiento")
	private Integer movTipoMovimiento;

	public RepDiarioGeneralIntegrado() {
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

	public Integer getMdeCodigo() {
		return this.mdeCodigo;
	}

	public void setMdeCodigo(Integer mdeCodigo) {
		this.mdeCodigo = mdeCodigo;
	}

	public Integer getMdeCuenta() {
		return this.mdeCuenta;
	}

	public void setMdeCuenta(Integer mdeCuenta) {
		this.mdeCuenta = mdeCuenta;
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

	public Integer getMdeMovimiento() {
		return this.mdeMovimiento;
	}

	public void setMdeMovimiento(Integer mdeMovimiento) {
		this.mdeMovimiento = mdeMovimiento;
	}

	public Integer getMdePeriodo() {
		return this.mdePeriodo;
	}

	public void setMdePeriodo(Integer mdePeriodo) {
		this.mdePeriodo = mdePeriodo;
	}

	public BigDecimal getMdeSaldo() {
		return this.mdeSaldo;
	}

	public void setMdeSaldo(BigDecimal mdeSaldo) {
		this.mdeSaldo = mdeSaldo;
	}

	public Integer getMovClase() {
		return this.movClase;
	}

	public void setMovClase(Integer movClase) {
		this.movClase = movClase;
	}

	public Integer getMovCodigo() {
		return this.movCodigo;
	}

	public void setMovCodigo(Integer movCodigo) {
		this.movCodigo = movCodigo;
	}

	public String getMovConcepto() {
		return this.movConcepto;
	}

	public void setMovConcepto(String movConcepto) {
		this.movConcepto = movConcepto;
	}

	public String getMovDocumento() {
		return this.movDocumento;
	}

	public void setMovDocumento(String movDocumento) {
		this.movDocumento = movDocumento;
	}

	public Integer getMovEntidad() {
		return this.movEntidad;
	}

	public void setMovEntidad(Integer movEntidad) {
		this.movEntidad = movEntidad;
	}

	public Boolean getMovEstado() {
		return this.movEstado;
	}

	public void setMovEstado(Boolean movEstado) {
		this.movEstado = movEstado;
	}

	public Timestamp getMovFecha() {
		return this.movFecha;
	}

	public void setMovFecha(Timestamp movFecha) {
		this.movFecha = movFecha;
	}

	public Timestamp getMovFechaContable() {
		return this.movFechaContable;
	}

	public void setMovFechaContable(Timestamp movFechaContable) {
		this.movFechaContable = movFechaContable;
	}

	public Integer getMovTipoMovimiento() {
		return this.movTipoMovimiento;
	}

	public void setMovTipoMovimiento(Integer movTipoMovimiento) {
		this.movTipoMovimiento = movTipoMovimiento;
	}

}