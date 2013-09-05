package ec.edu.uce.inventario.web.inventario.report;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import net.sf.jasperreports.engine.JasperPrint;
import ec.edu.uce.inventario.entidades.InvKardex;
import ec.edu.uce.inventario.inventario.servicio.ReportService;

@ManagedBean(name = "egresoReportPage")
@ViewScoped
public class EgresoReportPage implements Serializable {

	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;

	@EJB(name = "reportService/local")
	private ReportService reportService;

	private List<InvKardex> listReport;

	private Date desde;
	private Date hasta;
	
	public EgresoReportPage() {
		listReport = new ArrayList<InvKardex>();
		Calendar cal=Calendar.getInstance();
		desde=cal.getTime();
		hasta=cal.getTime();
	}

	public List<InvKardex> getlistReport() {
		return listReport;
	}

	public void setlistReport(List<InvKardex> listReport) {
		this.listReport = listReport;
	}

	public Date getDesde() {
		return desde;
	}

	public void setDesde(Date desde) {
		this.desde = desde;
	}

	public Date getHasta() {
		return hasta;
	}

	public void setHasta(Date hasta) {
		this.hasta = hasta;
	}

	JasperPrint jasperPrint;  
	public void read() {
		
		if(desde.after(hasta))
		{
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
							"La fecha desde no puede ser mayor a la fecha hasta"));
			return;
		}
		
		listReport=new ArrayList<InvKardex>();
		listReport=reportService.reportEgreso(desde,hasta);
//		JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(
//				listReport);
//		String path = FacesContext.getCurrentInstance()
//				.getExternalContext().getRealPath("/jasper/kardex.jasper");
//		try {
//			jasperPrint = JasperFillManager.fillReport(path, new HashMap(),
//					beanCollectionDataSource);
//		} catch (JRException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

	@PostConstruct
	public void init() {
		read();
	}
}
