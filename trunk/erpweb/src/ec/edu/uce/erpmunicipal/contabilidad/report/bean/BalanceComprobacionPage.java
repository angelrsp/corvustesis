package ec.edu.uce.erpmunicipal.contabilidad.report.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ec.edu.uce.erpmunicipal.contabilidad.bsl.ReportService;
import ec.edu.uce.erpmunicipal.contabilidad.orm.RepBalanceComprobacion;

@ManagedBean(name = "balanceComprobacionPage")
@ViewScoped
public class BalanceComprobacionPage implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
    @EJB(name = "reportService/local")
    private ReportService reportService;

    private List<RepBalanceComprobacion> listReport;
    
    public BalanceComprobacionPage()
    {
    	listReport=new ArrayList<RepBalanceComprobacion>();
    }

	public List<RepBalanceComprobacion> getListReport() {
		return listReport;
	}

	public void setListReport(List<RepBalanceComprobacion> listReport) {
		this.listReport = listReport;
	}

	public void read() {
        listReport=new ArrayList<RepBalanceComprobacion>();
        listReport=reportService.readBalanceComprobacion();
	}
    
    @PostConstruct
    public void init() {
            read();
    }

}
