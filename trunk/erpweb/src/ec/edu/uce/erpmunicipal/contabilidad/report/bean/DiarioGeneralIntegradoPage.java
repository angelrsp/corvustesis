package ec.edu.uce.erpmunicipal.contabilidad.report.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ec.edu.uce.erpmunicipal.contabilidad.bsl.ReportService;
import ec.edu.uce.erpmunicipal.contabilidad.orm.RepDiarioGeneralIntegrado;

@ManagedBean(name = "diarioGeneralIntegradoPage")
@ViewScoped
public class DiarioGeneralIntegradoPage implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
    @EJB(name = "reportService/local")
    private ReportService reportService;

    private List<RepDiarioGeneralIntegrado> listReport;
    
    public DiarioGeneralIntegradoPage()
    {
    	listReport=new ArrayList<RepDiarioGeneralIntegrado>();
    }

	public List<RepDiarioGeneralIntegrado> getListReport() {
		return listReport;
	}

	public void setListReport(List<RepDiarioGeneralIntegrado> listReport) {
		this.listReport = listReport;
	}

	public void read() {
        listReport=new ArrayList<RepDiarioGeneralIntegrado>();
        listReport=reportService.readDiarioGeneralIntegrado();
	}
    
    @PostConstruct
    public void init() {
            read();
    }

}
