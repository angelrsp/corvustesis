package ec.edu.uce.inventario.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the fac_detalle_ventas database table.
 * 
 */
@Entity
@Table(name="fac_detalle_ventas")
public class FacDetalleVenta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="FAC_DETALLE_VENTAS_DVECODIGO_GENERATOR", sequenceName="FAC_DETALLE_VENTAS_DVE_CODIGO_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="FAC_DETALLE_VENTAS_DVECODIGO_GENERATOR")
	@Column(name="dve_codigo")
	private Integer dveCodigo;

	@Column(name="dve_cantidad")
	private BigDecimal dveCantidad;

	@Column(name="dve_precio_total")
	private BigDecimal dvePrecioTotal;

	@Column(name="dve_precio_unitario")
	private BigDecimal dvePrecioUnitario;

	//bi-directional many-to-one association to FacVenta
	@ManyToOne
	@JoinColumn(name="dve_ventas")
	private FacVenta facVenta;

	//bi-directional many-to-one association to InvArticulo
	@ManyToOne
	@JoinColumn(name="dve_aritulo")
	private InvArticulo invArticulo;

	public FacDetalleVenta() {
	}

	public Integer getDveCodigo() {
		return this.dveCodigo;
	}

	public void setDveCodigo(Integer dveCodigo) {
		this.dveCodigo = dveCodigo;
	}

	public BigDecimal getDveCantidad() {
		return this.dveCantidad;
	}

	public void setDveCantidad(BigDecimal dveCantidad) {
		this.dveCantidad = dveCantidad;
	}

	public BigDecimal getDvePrecioTotal() {
		return this.dvePrecioTotal;
	}

	public void setDvePrecioTotal(BigDecimal dvePrecioTotal) {
		this.dvePrecioTotal = dvePrecioTotal;
	}

	public BigDecimal getDvePrecioUnitario() {
		return this.dvePrecioUnitario;
	}

	public void setDvePrecioUnitario(BigDecimal dvePrecioUnitario) {
		this.dvePrecioUnitario = dvePrecioUnitario;
	}

	public FacVenta getFacVenta() {
		return this.facVenta;
	}

	public void setFacVenta(FacVenta facVenta) {
		this.facVenta = facVenta;
	}

	public InvArticulo getInvArticulo() {
		return this.invArticulo;
	}

	public void setInvArticulo(InvArticulo invArticulo) {
		this.invArticulo = invArticulo;
	}

}