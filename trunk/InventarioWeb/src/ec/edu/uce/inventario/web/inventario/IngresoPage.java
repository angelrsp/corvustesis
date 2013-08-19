package ec.edu.uce.inventario.web.inventario;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.SelectEvent;

import ec.edu.uce.inventario.entidades.InvArticulo;
import ec.edu.uce.inventario.entidades.InvKardex;
import ec.edu.uce.inventario.inventario.servicio.ArticuloService;
import ec.edu.uce.inventario.inventario.servicio.KardexService;

@ManagedBean(name = "ingresoPage")
@ViewScoped
public class IngresoPage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB(name = "kardexService/local")
	private KardexService kardexService;
	@EJB(name = "articuloService/local")
	private ArticuloService articuloService;

	private InvKardex kardex;

	private String searchText;

	private InvArticulo articulo;

	private List<InvArticulo> listArticulos;

	public IngresoPage() {
		kardex = new InvKardex();
	}

	public InvKardex getKardex() {
		return kardex;
	}

	public void setKardex(InvKardex kardex) {
		this.kardex = kardex;
	}

	public String getSearchText() {
		return searchText;
	}

	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}

	public List<InvArticulo> getListArticulos() {
		return listArticulos;
	}

	public void setListArticulos(List<InvArticulo> listArticulos) {
		this.listArticulos = listArticulos;
	}

	public InvArticulo getArticulo() {
		return articulo;
	}

	public void setArticulo(InvArticulo articulo) {
		this.articulo = articulo;
	}

	public void calcularTotal() {
		if (this.kardex.getKarCantidad() != null
				&& this.kardex.getKarValorUnitario() != null)
			this.kardex.setKarValorTotal(BigDecimal.valueOf(this.redondear(
					this.kardex.getKarCantidad().doubleValue()
							* this.kardex.getKarValorUnitario().doubleValue(),
					4)));
	}

	public void clean() {
		kardex = new InvKardex();
	}

	public void create() {
		// 1 . Ingreso
		kardexService.create(1, kardex, articulo,true);
	}

	private double redondear(double valor, int decimales) {
		long mult = (long) Math.pow(10, decimales);
		double resultado = (Math.round(valor * mult)) / (double) mult;
		return resultado;
	}

	public void search() {
		listArticulos = new ArrayList<InvArticulo>();
		listArticulos = articuloService.dynamicSearch(searchText);
	}

	public void onRowSelect(SelectEvent event) {
		this.articulo = (InvArticulo) event.getObject();
		this.searchText = "";
		this.listArticulos = new ArrayList<InvArticulo>();
	}
}