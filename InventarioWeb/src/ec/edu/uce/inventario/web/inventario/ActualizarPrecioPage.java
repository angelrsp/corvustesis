package ec.edu.uce.inventario.web.inventario;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import ec.edu.uce.inventario.inventario.servicio.ArticuloService;

@ManagedBean(name = "actualizarPrecioPage")
@ViewScoped
public class ActualizarPrecioPage implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB(name = "articuloService/local")
	private ArticuloService articuloService;
	
	private double porcentaje;
	
	
	public ActualizarPrecioPage()
	{
		
	}
		
	public double getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(double porcentaje) {
		this.porcentaje = porcentaje;
	}

	public void actualizar()
	{
		articuloService.actualizarPrecios(porcentaje);
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Informacion",
						"Actulizados Exitosamente"));
		clear();
	}
	public void clear() {
		porcentaje=0.0;
	}
}
