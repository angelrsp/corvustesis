package ec.edu.uce.inventario.web.facturacion.report;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import ec.edu.uce.inventario.entidades.RepFactura;

@ManagedBean(name = "facturaReportViewPage")
@ViewScoped
public class FacturaReportViewPage implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private List<RepFactura> listReport;
	
	public FacturaReportViewPage()
	{
		listReport=new ArrayList<RepFactura>();
	}

	public List<RepFactura> getListReport() {
		return listReport;
	}

	public void setListReport(List<RepFactura> listReport) {
		this.listReport = listReport;
	}
	
	@SuppressWarnings("unchecked")
	@PostConstruct
	public void init()
	{
		this.listReport=new ArrayList<RepFactura>();
		this.listReport=(List<RepFactura>) FacesContext.getCurrentInstance()
		.getExternalContext().getSessionMap().get("listRepFactura");		
	}
	
}
