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
import ec.edu.uce.inventario.inventario.servicio.UnidadService;

@ManagedBean(name = "unidadPage")
@ViewScoped
public class UnidadPage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB(name = "unidadService/local")
	private UnidadService unidadService;

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
			if(unidad.getUniCodigo()==null)
				unidadService.create(unidad);
			else
				unidadService.update(unidad);
			readAll();
			clear();
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

	private void readAll() {
		this.unidades = unidadService.readAll();
	}
	
	public void onRowDeleting(InvUnidad unidad)
	{
		if(unidadService.delete(unidad))
		{
			readAll();
			clear();
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Informacion", "Eliminado Exitosamente"));			
		}
		else
		{
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No se pudo eliminar revise dependencias"));			
		}
	}

	@PostConstruct
	private void init() {
		readAll();
	}
}
