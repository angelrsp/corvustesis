package ec.edu.uce.inventario.web.inventario;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import net.sf.jasperreports.engine.JasperPrint;
import ec.edu.uce.inventario.entidades.InvArticulo;
import ec.edu.uce.inventario.inventario.servicio.ArticuloService;
import ec.edu.uce.inventario.web.util.ReportUtil;

@ManagedBean(name = "actualizarPrecioPage")
@ViewScoped
public class ActualizarPrecioPage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB(name = "articuloService/local")
	private ArticuloService articuloService;

	private double porcentaje;

	public ActualizarPrecioPage() {

	}

	public double getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(double porcentaje) {
		this.porcentaje = porcentaje;
	}

	public void actualizar() {
		articuloService.actualizarPrecios(porcentaje);
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Informacion",
						"Actulizados Exitosamente"));
		clear();
	}

	public void clear() {
		porcentaje = 0.0;
	}

	public void XLSX()
	{
		FacesContext facesContext = FacesContext.getCurrentInstance();
		List<InvArticulo> list;
		list = articuloService.readAll();
		JasperPrint jp = ReportUtil.jasperPrint (facesContext,list,"articulos");
		ReportUtil.generarReporte(jp, "articulos");
	}
}
