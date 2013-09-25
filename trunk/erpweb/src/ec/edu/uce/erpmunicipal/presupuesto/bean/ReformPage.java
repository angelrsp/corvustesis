package ec.edu.uce.erpmunicipal.presupuesto.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ec.edu.uce.erpmunicipal.presupuesto.bsl.PresupuestoService;
import ec.edu.uce.erpmunicipal.presupuesto.orm.PreReforma;
import ec.edu.uce.erpmunicipal.presupuesto.orm.PreVerificacion;

@ManagedBean(name = "reformPage")
@ViewScoped
public class ReformPage implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB(name = "presupuestoService/local")
	private PresupuestoService presupuestoService;
	
	private List<PreVerificacion> verificacionList;
	
	private int verificacionCode;
	
	private PreReforma reform;
	
	
	public ReformPage()
	{
		verificacionList=new ArrayList<PreVerificacion>();
		verificacionCode=2;
	}


	public PreReforma getReform() {
		return reform;
	}

	public void setReform(PreReforma reform) {
		this.reform = reform;
	}


	public List<PreVerificacion> getVerificacionList() {
		this.verificacionList=presupuestoService.readVerification();
		return verificacionList;
	}


	public void setVerificacionList(List<PreVerificacion> verificacionList) {
		this.verificacionList = verificacionList;
	}


	public int getVerificacionCode() {
		return verificacionCode;
	}


	public void setVerificacionCode(int verificacionCode) {
		this.verificacionCode = verificacionCode;
	}
	
	
}
