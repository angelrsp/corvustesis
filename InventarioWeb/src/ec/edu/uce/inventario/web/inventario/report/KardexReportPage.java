package ec.edu.uce.inventario.web.inventario.report;

import java.io.Serializable;
import java.util.ArrayList;


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

	public KardexReportPage() {
		listKardek = new ArrayList<InvKardex>();

	}

	public List<InvKardex> getListKardek() {
		return listKardek;
	}

	public void setListKardek(List<InvKardex> listKardek) {
		this.listKardek = listKardek;
	}

	JasperPrint jasperPrint;  
	public void read() {
		listKardek=new ArrayList<InvKardex>();
		listKardek=reportService.reportKardex();
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
