package ec.edu.uce.erpmunicipal.contabilidad.orm;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the con_cuenta database table.
 * 
 */
@Entity
@Table(name="con_cuenta")
public class ConCuenta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CON_CUENTA_CUECODIGO_GENERATOR", sequenceName="CON_CUENTA_CUE_CODIGO_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CON_CUENTA_CUECODIGO_GENERATOR")
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

	//bi-directional many-to-one association to ConTipoCuenta
	@ManyToOne
	@JoinColumn(name="cue_tipo_cuenta")
	private ConTipoCuenta conTipoCuenta;

	//bi-directional many-to-one association to ConMovimientoDetalle
	@OneToMany(mappedBy="conCuenta")
	private List<ConMovimientoDetalle> conMovimientoDetalles;

	//bi-directional many-to-one association to ConSaldo
	@OneToMany(mappedBy="conCuenta")
	private List<ConSaldo> conSaldos;

	public ConCuenta() {
	}
	
	public ConCuenta(Integer cueCodigo, Integer cueCodigoPadre,
			String cueDescripcion, Integer cueEntidad, String cueNumero,
			Boolean cuePermiteMovimiento, Integer cueSubcuenta,
			ConTipoCuenta conTipoCuenta,
			List<ConMovimientoDetalle> conMovimientoDetalles,
			List<ConSaldo> conSaldos) {
		super();
		this.cueCodigo = cueCodigo;
		this.cueCodigoPadre = cueCodigoPadre;
		this.cueDescripcion = cueDescripcion;
		this.cueEntidad = cueEntidad;
		this.cueNumero = cueNumero;
		this.cuePermiteMovimiento = cuePermiteMovimiento;
		this.cueSubcuenta = cueSubcuenta;
		this.conTipoCuenta = conTipoCuenta;
		this.conMovimientoDetalles = conMovimientoDetalles;
		this.conSaldos = conSaldos;
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

	public ConTipoCuenta getConTipoCuenta() {
		return this.conTipoCuenta;
	}

	public void setConTipoCuenta(ConTipoCuenta conTipoCuenta) {
		this.conTipoCuenta = conTipoCuenta;
	}

	public List<ConMovimientoDetalle> getConMovimientoDetalles() {
		return this.conMovimientoDetalles;
	}

	public void setConMovimientoDetalles(List<ConMovimientoDetalle> conMovimientoDetalles) {
		this.conMovimientoDetalles = conMovimientoDetalles;
	}

	public List<ConSaldo> getConSaldos() {
		return this.conSaldos;
	}

	public void setConSaldos(List<ConSaldo> conSaldos) {
		this.conSaldos = conSaldos;
	}

}