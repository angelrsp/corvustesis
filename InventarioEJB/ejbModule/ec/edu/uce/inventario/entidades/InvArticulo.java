package ec.edu.uce.inventario.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the inv_articulo database table.
 * 
 */
@Entity
@Table(name="inv_articulo")
public class InvArticulo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="INV_ARTICULO_ARTCODIGO_GENERATOR", sequenceName="INV_ARTICULO_ART_CODIGO_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="INV_ARTICULO_ARTCODIGO_GENERATOR")
	@Column(name="art_codigo")
	private Integer artCodigo;

	@Column(name="art_cantidad_actual")
	private BigDecimal artCantidadActual;

	@Column(name="art_cantidad_maxima")
	private BigDecimal artCantidadMaxima;

	@Column(name="art_cantidad_minima")
	private BigDecimal artCantidadMinima;

	@Column(name="art_estado")
	private Boolean artEstado;

	@Column(name="art_nombre")
	private String artNombre;

	@Column(name="art_precio")
	private BigDecimal artPrecio;

	//bi-directional many-to-one association to FacDetalleVenta
	@OneToMany(mappedBy="invArticulo")
	private List<FacDetalleVenta> facDetalleVentas;

	//bi-directional many-to-one association to InvUnidad
	@ManyToOne
	@JoinColumn(name="art_unidad_codigo")
	private InvUnidad invUnidad;

	//bi-directional many-to-one association to InvKardex
	@OneToMany(mappedBy="invArticulo")
	private List<InvKardex> invKardexs;

	//bi-directional many-to-one association to InvSaldo
	@OneToMany(mappedBy="invArticuloBean")
	private List<InvSaldo> invSaldos;

	public InvArticulo() {
	}

	public Integer getArtCodigo() {
		return this.artCodigo;
	}

	public void setArtCodigo(Integer artCodigo) {
		this.artCodigo = artCodigo;
	}

	public BigDecimal getArtCantidadActual() {
		return this.artCantidadActual;
	}

	public void setArtCantidadActual(BigDecimal artCantidadActual) {
		this.artCantidadActual = artCantidadActual;
	}

	public BigDecimal getArtCantidadMaxima() {
		return this.artCantidadMaxima;
	}

	public void setArtCantidadMaxima(BigDecimal artCantidadMaxima) {
		this.artCantidadMaxima = artCantidadMaxima;
	}

	public BigDecimal getArtCantidadMinima() {
		return this.artCantidadMinima;
	}

	public void setArtCantidadMinima(BigDecimal artCantidadMinima) {
		this.artCantidadMinima = artCantidadMinima;
	}

	public Boolean getArtEstado() {
		return this.artEstado;
	}

	public void setArtEstado(Boolean artEstado) {
		this.artEstado = artEstado;
	}

	public String getArtNombre() {
		return this.artNombre;
	}

	public void setArtNombre(String artNombre) {
		this.artNombre = artNombre;
	}

	public BigDecimal getArtPrecio() {
		return this.artPrecio;
	}

	public void setArtPrecio(BigDecimal artPrecio) {
		this.artPrecio = artPrecio;
	}

	public List<FacDetalleVenta> getFacDetalleVentas() {
		return this.facDetalleVentas;
	}

	public void setFacDetalleVentas(List<FacDetalleVenta> facDetalleVentas) {
		this.facDetalleVentas = facDetalleVentas;
	}

	public FacDetalleVenta addFacDetalleVenta(FacDetalleVenta facDetalleVenta) {
		getFacDetalleVentas().add(facDetalleVenta);
		facDetalleVenta.setInvArticulo(this);

		return facDetalleVenta;
	}

	public FacDetalleVenta removeFacDetalleVenta(FacDetalleVenta facDetalleVenta) {
		getFacDetalleVentas().remove(facDetalleVenta);
		facDetalleVenta.setInvArticulo(null);

		return facDetalleVenta;
	}

	public InvUnidad getInvUnidad() {
		return this.invUnidad;
	}

	public void setInvUnidad(InvUnidad invUnidad) {
		this.invUnidad = invUnidad;
	}

	public List<InvKardex> getInvKardexs() {
		return this.invKardexs;
	}

	public void setInvKardexs(List<InvKardex> invKardexs) {
		this.invKardexs = invKardexs;
	}

	public InvKardex addInvKardex(InvKardex invKardex) {
		getInvKardexs().add(invKardex);
		invKardex.setInvArticulo(this);

		return invKardex;
	}

	public InvKardex removeInvKardex(InvKardex invKardex) {
		getInvKardexs().remove(invKardex);
		invKardex.setInvArticulo(null);

		return invKardex;
	}

	public List<InvSaldo> getInvSaldos() {
		return this.invSaldos;
	}

	public void setInvSaldos(List<InvSaldo> invSaldos) {
		this.invSaldos = invSaldos;
	}

	public InvSaldo addInvSaldo(InvSaldo invSaldo) {
		getInvSaldos().add(invSaldo);
		invSaldo.setInvArticuloBean(this);

		return invSaldo;
	}

	public InvSaldo removeInvSaldo(InvSaldo invSaldo) {
		getInvSaldos().remove(invSaldo);
		invSaldo.setInvArticuloBean(null);

		return invSaldo;
	}

}