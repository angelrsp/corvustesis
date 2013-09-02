package ec.edu.uce.inventario.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.math.BigDecimal;


/**
 * The persistent class for the rep_factura database table.
 * 
 */
@Entity
@Table(name="rep_factura")
@NamedQuery(name="RepFactura.findAll", query="SELECT r FROM RepFactura r")
public class RepFactura implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="art_cantidad_minima")
	private BigDecimal artCantidadMinima;

	@Column(name="art_catalogo")
	private String artCatalogo;

	@Column(name="art_codigo")
	private Integer artCodigo;

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

	@Column(name="art_unidad")
	private Integer artUnidad;

	@Column(name="cli_apellidos")
	private String cliApellidos;

	@Column(name="cli_celular")
	private String cliCelular;

	@Column(name="cli_codigo")
	private Integer cliCodigo;

	@Column(name="cli_direccion")
	private String cliDireccion;

	@Column(name="cli_mail")
	private String cliMail;

	@Column(name="cli_identificacion")
	private String cliIdentificacion;
	
	@Column(name="cli_nombres")
	private String cliNombres;

	@Column(name="cli_telefono")
	private String cliTelefono;

	@Column(name="dve_articulo")
	private Integer dveArticulo;

	@Column(name="dve_cantidad")
	private BigDecimal dveCantidad;

	@Id
	@Column(name="dve_codigo")
	private Integer dveCodigo;

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

	@Column(name="dve_ventas")
	private Integer dveVentas;

	@Column(name="ven_cliente")
	private Integer venCliente;

	@Column(name="ven_codigo")
	private Integer venCodigo;

	@Column(name="ven_fecha")
	private Timestamp venFecha;

	@Column(name="ven_pedido")
	private String venPedido;

	@Column(name="ven_total")
	private BigDecimal venTotal;

	public RepFactura() {
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

	public Integer getArtCodigo() {
		return this.artCodigo;
	}

	public void setArtCodigo(Integer artCodigo) {
		this.artCodigo = artCodigo;
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

	public Integer getArtUnidad() {
		return this.artUnidad;
	}

	public void setArtUnidad(Integer artUnidad) {
		this.artUnidad = artUnidad;
	}

	public String getCliApellidos() {
		return this.cliApellidos;
	}

	public void setCliApellidos(String cliApellidos) {
		this.cliApellidos = cliApellidos;
	}

	public String getCliCelular() {
		return this.cliCelular;
	}

	public void setCliCelular(String cliCelular) {
		this.cliCelular = cliCelular;
	}

	public Integer getCliCodigo() {
		return this.cliCodigo;
	}

	public void setCliCodigo(Integer cliCodigo) {
		this.cliCodigo = cliCodigo;
	}

	public String getCliDireccion() {
		return this.cliDireccion;
	}

	public void setCliDireccion(String cliDireccion) {
		this.cliDireccion = cliDireccion;
	}

	public String getCliMail() {
		return this.cliMail;
	}

	public void setCliMail(String cliMail) {
		this.cliMail = cliMail;
	}

	public String getCliIdentificacion() {
		return cliIdentificacion;
	}

	public void setCliIdentificacion(String cliIdentificacion) {
		this.cliIdentificacion = cliIdentificacion;
	}

	public String getCliNombres() {
		return this.cliNombres;
	}

	public void setCliNombres(String cliNombres) {
		this.cliNombres = cliNombres;
	}

	public String getCliTelefono() {
		return this.cliTelefono;
	}

	public void setCliTelefono(String cliTelefono) {
		this.cliTelefono = cliTelefono;
	}

	public Integer getDveArticulo() {
		return this.dveArticulo;
	}

	public void setDveArticulo(Integer dveArticulo) {
		this.dveArticulo = dveArticulo;
	}

	public BigDecimal getDveCantidad() {
		return this.dveCantidad;
	}

	public void setDveCantidad(BigDecimal dveCantidad) {
		this.dveCantidad = dveCantidad;
	}

	public Integer getDveCodigo() {
		return this.dveCodigo;
	}

	public void setDveCodigo(Integer dveCodigo) {
		this.dveCodigo = dveCodigo;
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

	public Integer getDveVentas() {
		return this.dveVentas;
	}

	public void setDveVentas(Integer dveVentas) {
		this.dveVentas = dveVentas;
	}

	public Integer getVenCliente() {
		return this.venCliente;
	}

	public void setVenCliente(Integer venCliente) {
		this.venCliente = venCliente;
	}

	public Integer getVenCodigo() {
		return this.venCodigo;
	}

	public void setVenCodigo(Integer venCodigo) {
		this.venCodigo = venCodigo;
	}

	public Timestamp getVenFecha() {
		return this.venFecha;
	}

	public void setVenFecha(Timestamp venFecha) {
		this.venFecha = venFecha;
	}

	public String getVenPedido() {
		return this.venPedido;
	}

	public void setVenPedido(String venPedido) {
		this.venPedido = venPedido;
	}

	public BigDecimal getVenTotal() {
		return this.venTotal;
	}

	public void setVenTotal(BigDecimal venTotal) {
		this.venTotal = venTotal;
	}

}