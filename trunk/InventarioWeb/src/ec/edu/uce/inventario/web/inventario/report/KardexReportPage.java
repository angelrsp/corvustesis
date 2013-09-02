package ec.edu.uce.inventario.web.inventario.report;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import net.sf.jasperreports.engine.JasperPrint;
import ec.edu.uce.inventario.entidades.InvKardex;
import ec.edu.uce.inventario.inventario.servicio.ReportService;

@ManagedBean(name = "kardexReportPage")
@ViewScoped
public class KardexReportPage implements Serializable {

	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;

	@EJB(name = "reportService/local")
	private ReportService reportService;

	private List<InvKardex> listKardek;

	private Date desde;
	private Date hasta;
	
	public KardexReportPage() {
		listKardek = new ArrayList<InvKardex>();
		Calendar cal=Calendar.getInstance();
		desde=cal.getTime();
		hasta=cal.getTime();
	}

	public List<InvKardex> getListKardek() {
		return listKardek;
	}

	public void setListKardek(List<InvKardex> listKardek) {
		this.listKardek = listKardek;
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
		listKardek=new ArrayList<InvKardex>();
		listKardek=reportService.reportKardex(desde,hasta);
//		JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(
//				listKardek);
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
