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
	@SequenceGenerator(name="INV_ARTICULO_ARTCODIGO_GENERATOR", sequenceName="INV_ARTICULO_ART_CODIGO_SEQ",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="INV_ARTICULO_ARTCODIGO_GENERATOR")
	@Column(name="art_codigo")
	private Integer artCodigo;

	@Column(name="art_cantidad_minima")
	private BigDecimal artCantidadMinima;

	@Column(name="art_catalogo")
	private String artCatalogo;

	@Column(name="art_codigo_manual")
	private Integer artCodigoManual;

	@Column(name="art_enlace")
	private String artEnlace;

	@Column(name="art_estado")
	private Boolean artEstado;

	@Column(name="art_imagen")
	private String artImagen;

	@Column(name="art_nombre_corto")
	private String artNombreCorto;

	@Column(name="art_nombre_largo")
	private String artNombreLargo;

	@Column(name="art_pagina")
	private BigDecimal artPagina;

	@Column(name="art_paquete")
	private BigDecimal artPaquete;

	@Column(name="art_peso")
	private BigDecimal artPeso;

	@Column(name="art_precio")
	private BigDecimal artPrecio;

	@Column(name="art_tipo")
	private String artTipo;

	//bi-directional many-to-one association to FacDetalleVenta
	@OneToMany(mappedBy="invArticulo")
	private List<FacDetalleVenta> facDetalleVentas;

	//bi-directional many-to-one association to InvUnidad
	@ManyToOne
	@JoinColumn(name="art_unidad")
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

	public BigDecimal getArtCantidadMinima() {
		return this.artCantidadMinima;
	}

	public void setArtCantidadMinima(BigDecimal artCantidadMinima) {
		this.artCantidadMinima = artCantidadMinima;
	}

	public String getArtCatalogo() {
		return this.artCatalogo;
	}

	public void setArtCatalogo(String artCatalogo) {
		this.artCatalogo = artCatalogo;
	}

	public Integer getArtCodigoManual() {
		return this.artCodigoManual;
	}

	public void setArtCodigoManual(Integer artCodigoManual) {
		this.artCodigoManual = artCodigoManual;
	}

	public String getArtEnlace() {
		return this.artEnlace;
	}

	public void setArtEnlace(String artEnlace) {
		this.artEnlace = artEnlace;
	}

	public Boolean getArtEstado() {
		return this.artEstado;
	}

	public void setArtEstado(Boolean artEstado) {
		this.artEstado = artEstado;
	}

	public String getArtImagen() {
		return this.artImagen;
	}

	public void setArtImagen(String artImagen) {
		this.artImagen = artImagen;
	}

	public String getArtNombreCorto() {
		return this.artNombreCorto;
	}

	public void setArtNombreCorto(String artNombreCorto) {
		this.artNombreCorto = artNombreCorto;
	}

	public String getArtNombreLargo() {
		return this.artNombreLargo;
	}

	public void setArtNombreLargo(String artNombreLargo) {
		this.artNombreLargo = artNombreLargo;
	}

	public BigDecimal getArtPagina() {
		return this.artPagina;
	}

	public void setArtPagina(BigDecimal artPagina) {
		this.artPagina = artPagina;
	}

	public BigDecimal getArtPaquete() {
		return this.artPaquete;
	}

	public void setArtPaquete(BigDecimal artPaquete) {
		this.artPaquete = artPaquete;
	}

	public BigDecimal getArtPeso() {
		return this.artPeso;
	}

	public void setArtPeso(BigDecimal artPeso) {
		this.artPeso = artPeso;
	}

	public BigDecimal getArtPrecio() {
		return this.artPrecio;
	}

	public void setArtPrecio(BigDecimal artPrecio) {
		this.artPrecio = artPrecio;
	}

	public String getArtTipo() {
		return this.artTipo;
	}

	public void setArtTipo(String artTipo) {
		this.artTipo = artTipo;
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