package ec.edu.uce.erpmunicipal.contabilidad.report.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ec.edu.uce.erpmunicipal.contabilidad.bsl.ReportService;
import ec.edu.uce.erpmunicipal.contabilidad.orm.RepMayorGeneral;

@ManagedBean(name = "mayorGeneralPage")
@ViewScoped
public class MayorGeneralPage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB(name = "reportService/local")
	private ReportService reportService;

	private List<RepMayorGeneral> listReport;

	public MayorGeneralPage() {
		listReport = new ArrayList<RepMayorGeneral>();
	}

	public List<RepMayorGeneral> getListReport() {
		return listReport;
	}

	public void setListReport(List<RepMayorGeneral> listReport) {
		this.listReport = listReport;
	}

	public void read() {
		listReport = new ArrayList<RepMayorGeneral>();
		listReport = reportService.readMayorGeneral();
	}

	@PostConstruct
	public void init() {
		read();
	}

}
