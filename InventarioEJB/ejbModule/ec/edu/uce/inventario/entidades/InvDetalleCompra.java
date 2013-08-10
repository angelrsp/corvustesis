package ec.edu.uce.inventario.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the inv_detalle_compras database table.
 * 
 */
@Entity
@Table(name="inv_detalle_compras")
public class InvDetalleCompra implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="INV_DETALLE_COMPRAS_DCOCODIGO_GENERATOR", sequenceName="INV_DETALLE_COMPRAS_DCO_CODIGO_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="INV_DETALLE_COMPRAS_DCOCODIGO_GENERATOR")
	@Column(name="dco_codigo")
	private Integer dcoCodigo;

	@Column(name="dco_cantidad")
	private BigDecimal dcoCantidad;

	@Column(name="dco_precio")
	private BigDecimal dcoPrecio;

	//bi-directional many-to-one association to InvArticulo
	@ManyToOne
	@JoinColumn(name="dco_articulo")
	private InvArticulo invArticulo;

	//bi-directional many-to-one association to InvCompra
	@ManyToOne
	@JoinColumn(name="dco_compras")
	private InvCompra invCompra;

	public InvDetalleCompra() {
	}

	public Integer getDcoCodigo() {
		return this.dcoCodigo;
	}

	public void setDcoCodigo(Integer dcoCodigo) {
		this.dcoCodigo = dcoCodigo;
	}

	public BigDecimal getDcoCantidad() {
		return this.dcoCantidad;
	}

	public void setDcoCantidad(BigDecimal dcoCantidad) {
		this.dcoCantidad = dcoCantidad;
	}

	public BigDecimal getDcoPrecio() {
		return this.dcoPrecio;
	}

	public void setDcoPrecio(BigDecimal dcoPrecio) {
		this.dcoPrecio = dcoPrecio;
	}

	public InvArticulo getInvArticulo() {
		return this.invArticulo;
	}

	public void setInvArticulo(InvArticulo invArticulo) {
		this.invArticulo = invArticulo;
	}

	public InvCompra getInvCompra() {
		return this.invCompra;
	}

	public void setInvCompra(InvCompra invCompra) {
		this.invCompra = invCompra;
	}

}