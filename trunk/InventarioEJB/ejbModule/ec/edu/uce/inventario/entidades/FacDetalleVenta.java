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
	@SequenceGenerator(name="FAC_DETALLE_VENTAS_DVECODIGO_GENERATOR", sequenceName="FAC_DETALLE_VENTAS_DVE_CODIGO_SEQ",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="FAC_DETALLE_VENTAS_DVECODIGO_GENERATOR")
	@Column(name="dve_codigo")
	private Integer dveCodigo;

	@Column(name="dve_cantidad")
	private BigDecimal dveCantidad;

	@Column(name="dve_descuento")
	private BigDecimal dveDescuento;

	@Column(name="dve_descuento_porcentaje")
	private BigDecimal dveDescuentoPorcentaje;

	@Column(name="dve_iva")
	private BigDecimal dveIva;

	@Column(name="dve_precio")
	private BigDecimal dvePrecio;

	@Column(name="dve_total")
	private BigDecimal dveTotal;

	//bi-directional many-to-one association to FacVenta
	@ManyToOne
	@JoinColumn(name="dve_ventas")
	private FacVenta facVenta;

	//bi-directional many-to-one association to InvArticulo
	@ManyToOne
	@JoinColumn(name="dve_articulo")
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

	public BigDecimal getDveDescuento() {
		return this.dveDescuento;
	}

	public void setDveDescuento(BigDecimal dveDescuento) {
		this.dveDescuento = dveDescuento;
	}

	public BigDecimal getDveDescuentoPorcentaje() {
		return this.dveDescuentoPorcentaje;
	}

	public void setDveDescuentoPorcentaje(BigDecimal dveDescuentoPorcentaje) {
		this.dveDescuentoPorcentaje = dveDescuentoPorcentaje;
	}

	public BigDecimal getDveIva() {
		return this.dveIva;
	}

	public void setDveIva(BigDecimal dveIva) {
		this.dveIva = dveIva;
	}

	public BigDecimal getDvePrecio() {
		return this.dvePrecio;
	}

	public void setDvePrecio(BigDecimal dvePrecio) {
		this.dvePrecio = dvePrecio;
	}

	public BigDecimal getDveTotal() {
		return this.dveTotal;
	}

	public void setDveTotal(BigDecimal dveTotal) {
		this.dveTotal = dveTotal;
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