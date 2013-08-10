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

import org.primefaces.event.SelectEvent;

import ec.edu.uce.inventario.entidades.InvUnidad;
import ec.edu.uce.inventario.sistema.servicio.CrudService;

@ManagedBean(name = "unidadPage")
@ViewScoped
public class UnidadPage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB(name = "crudService/local")
	private CrudService crudService;

	private List<InvUnidad> unidades;

	private InvUnidad unidad;

	public UnidadPage() {
		unidad = new InvUnidad();
		unidades = new ArrayList<InvUnidad>();
	}

	public InvUnidad getUnidad() {
		return unidad;
	}

	public void setUnidad(InvUnidad unidad) {
		this.unidad = unidad;
	}

	public List<InvUnidad> getUnidades() {
		return unidades;
	}

	public void setUnidades(List<InvUnidad> unidades) {
		this.unidades = unidades;
	}

	public void create() {
		try {
			crudService.create(unidad);
			readAll();
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e
							.getMessage()));
		}
	}

	public void clear()
	{
		unidad=new InvUnidad();
	}
	
	public void onRowSelect(SelectEvent event) {
		this.unidad = (InvUnidad) event.getObject();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void readAll() {
		this.unidades = (List<InvUnidad>) (List) crudService.find("InvUnidad");
	}

	@PostConstruct
	private void init() {
		readAll();
	}
}
