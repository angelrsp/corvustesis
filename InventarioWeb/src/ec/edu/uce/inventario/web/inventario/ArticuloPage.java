package ec.edu.uce.inventario.web.inventario;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

import ec.edu.uce.inventario.entidades.InvArticulo;
import ec.edu.uce.inventario.entidades.InvUnidad;
import ec.edu.uce.inventario.inventario.servicio.ArticuloService;

@ManagedBean(name = "articuloPage")
@ViewScoped
public class ArticuloPage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB(name = "articuloService/local")
	private ArticuloService articuloService;

	private InvArticulo articulo;

	private List<InvUnidad> unidades;
	private List<InvArticulo> articulos;

	private int unidadCode;

	public ArticuloPage() {
		articulo = new InvArticulo();
		unidades = new ArrayList<InvUnidad>();
		articulos = new ArrayList<InvArticulo>();
	}

	public InvArticulo getArticulo() {
		return articulo;
	}

	public void setArticulo(InvArticulo articulo) {
		this.articulo = articulo;
	}

	public int getUnidadCode() {
		return unidadCode;
	}

	public void setUnidadCode(int unidadCode) {
		this.unidadCode = unidadCode;
	}

	public List<InvUnidad> getUnidades() {
		this.unidades = articuloService.readUnidades();
		return unidades;
	}

	public void setUnidades(List<InvUnidad> unidades) {
		this.unidades = unidades;
	}

	public List<InvArticulo> getArticulos() {
		return articulos;
	}

	public void setArticulos(List<InvArticulo> articulos) {
		this.articulos = articulos;
	}

	public void create() {
		try {
			if (articulo.getArtCodigo() == null) {
				articuloService.create(articulo, unidadCode);
			} else {
				articuloService.update(articulo, unidadCode);
			}
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Informacion",
							"Guardado Exitosamente"));
			readAll();
			clean();
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e
							.toString()));
		}
	}

	public void clean() {
		this.articulo = new InvArticulo();
	}

	public void onRowSelect(SelectEvent event) {
		this.articulo = (InvArticulo) event.getObject();
		this.unidadCode = articulo.getInvUnidad().getUniCodigo();
	}

	public void onRowDeleting(InvArticulo art) {
		RequestContext.getCurrentInstance().execute("confirmation1.show();");
		articulo = new InvArticulo();
		articulo = art;
	}

	public void delete() {
		if (articuloService.delete(articulo)) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Informacion",
							"Articulo Eliminado"));
			readAll();
		} else {
			RequestContext.getCurrentInstance()
					.execute("confirmation2.show();");
		}
	}

	public void updateEstado() {
		articuloService.updateEstado(articulo);
		readAll();
	}

	public void readAll() {
		this.articulos = articuloService.readAll();
	}

	@PostConstruct
	private void init() {
		readAll();
	}
}
