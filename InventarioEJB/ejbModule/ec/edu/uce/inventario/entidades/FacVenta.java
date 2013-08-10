package ec.edu.uce.inventario.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the fac_ventas database table.
 * 
 */
@Entity
@Table(name="fac_ventas")
public class FacVenta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="FAC_VENTAS_VENCODIGO_GENERATOR", sequenceName="FAC_VENTAS_VEN_CODIGO_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="FAC_VENTAS_VENCODIGO_GENERATOR")
	@Column(name="ven_codigo")
	private Integer venCodigo;

	@Column(name="ven_descuento")
	private BigDecimal venDescuento;

	@Column(name="ven_fecha")
	private Timestamp venFecha;

	@Column(name="ven_iva")
	private BigDecimal venIva;

	@Column(name="ven_subtotal")
	private BigDecimal venSubtotal;

	@Column(name="ven_total")
	private BigDecimal venTotal;

	//bi-directional many-to-one association to FacDetalleVenta
	@OneToMany(mappedBy="facVenta")
	private List<FacDetalleVenta> facDetalleVentas;

	//bi-directional many-to-one association to FacCliente
	@ManyToOne
	@JoinColumn(name="ven_cliente")
	private FacCliente facCliente;

	public FacVenta() {
	}

	public Integer getVenCodigo() {
		return this.venCodigo;
	}

	public void setVenCodigo(Integer venCodigo) {
		this.venCodigo = venCodigo;
	}

	public BigDecimal getVenDescuento() {
		return this.venDescuento;
	}

	public void setVenDescuento(BigDecimal venDescuento) {
		this.venDescuento = venDescuento;
	}

	public Timestamp getVenFecha() {
		return this.venFecha;
	}

	public void setVenFecha(Timestamp venFecha) {
		this.venFecha = venFecha;
	}

	public BigDecimal getVenIva() {
		return this.venIva;
	}

	public void setVenIva(BigDecimal venIva) {
		this.venIva = venIva;
	}

	public BigDecimal getVenSubtotal() {
		return this.venSubtotal;
	}

	public void setVenSubtotal(BigDecimal venSubtotal) {
		this.venSubtotal = venSubtotal;
	}

	public BigDecimal getVenTotal() {
		return this.venTotal;
	}

	public void setVenTotal(BigDecimal venTotal) {
		this.venTotal = venTotal;
	}

	public List<FacDetalleVenta> getFacDetalleVentas() {
		return this.facDetalleVentas;
	}

	public void setFacDetalleVentas(List<FacDetalleVenta> facDetalleVentas) {
		this.facDetalleVentas = facDetalleVentas;
	}

	public FacDetalleVenta addFacDetalleVenta(FacDetalleVenta facDetalleVenta) {
		getFacDetalleVentas().add(facDetalleVenta);
		facDetalleVenta.setFacVenta(this);

		return facDetalleVenta;
	}

	public FacDetalleVenta removeFacDetalleVenta(FacDetalleVenta facDetalleVenta) {
		getFacDetalleVentas().remove(facDetalleVenta);
		facDetalleVenta.setFacVenta(null);

		return facDetalleVenta;
	}

	public FacCliente getFacCliente() {
		return this.facCliente;
	}

	public void setFacCliente(FacCliente facCliente) {
		this.facCliente = facCliente;
	}

}