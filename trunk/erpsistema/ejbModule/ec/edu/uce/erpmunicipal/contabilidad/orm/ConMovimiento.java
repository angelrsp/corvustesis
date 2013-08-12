package ec.edu.uce.erpmunicipal.contabilidad.orm;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the con_movimiento database table.
 * 
 */
@Entity
@Table(name="con_movimiento")
public class ConMovimiento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CON_MOVIMIENTO_MOVCODIGO_GENERATOR", sequenceName="CON_MOVIMIENTO_MOV_CODIGO_SEQ",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CON_MOVIMIENTO_MOVCODIGO_GENERATOR")
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

	//bi-directional many-to-one association to ConClase
	@ManyToOne
	@JoinColumn(name="mov_clase")
	private ConClase conClase;

	//bi-directional many-to-one association to ConTipoMovimiento
	@ManyToOne
	@JoinColumn(name="mov_tipo_movimiento")
	private ConTipoMovimiento conTipoMovimiento;

	//bi-directional many-to-one association to ConMovimientoDetalle
	@OneToMany(mappedBy="conMovimiento")
	private List<ConMovimientoDetalle> conMovimientoDetalles;

	public ConMovimiento() {
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

	public ConClase getConClase() {
		return this.conClase;
	}

	public void setConClase(ConClase conClase) {
		this.conClase = conClase;
	}

	public ConTipoMovimiento getConTipoMovimiento() {
		return this.conTipoMovimiento;
	}

	public void setConTipoMovimiento(ConTipoMovimiento conTipoMovimiento) {
		this.conTipoMovimiento = conTipoMovimiento;
	}

	public List<ConMovimientoDetalle> getConMovimientoDetalles() {
		return this.conMovimientoDetalles;
	}

	public void setConMovimientoDetalles(List<ConMovimientoDetalle> conMovimientoDetalles) {
		this.conMovimientoDetalles = conMovimientoDetalles;
	}

}