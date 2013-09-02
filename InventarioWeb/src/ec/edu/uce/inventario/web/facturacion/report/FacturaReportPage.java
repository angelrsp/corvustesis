package ec.edu.uce.inventario.web.facturacion.report;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import net.sf.jasperreports.engine.JasperPrint;
import ec.edu.uce.inventario.entidades.RepFactura;
import ec.edu.uce.inventario.inventario.servicio.ReportService;

@ManagedBean(name = "facturaReportPage")
@ViewScoped
public class FacturaReportPage implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB(name = "reportService/local")
	private ReportService reportService;

	private List<RepFactura> listReport;
	private Date desde;
	private Date hasta;

	public FacturaReportPage() {
		listReport = new ArrayList<RepFactura>();
		Calendar cal=Calendar.getInstance();
		desde=cal.getTime();
		hasta=cal.getTime();
	}

	public List<RepFactura> getlistReport() {
		return listReport;
	}

	public void setlistReport(List<RepFactura> listReport) {
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
		listReport=new ArrayList<RepFactura>();
		listReport=reportService.reportFactura(desde, hasta);
		
		FacesContext.getCurrentInstance().getExternalContext()
		.getSessionMap().put("listRepFactura", listReport);

		
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
