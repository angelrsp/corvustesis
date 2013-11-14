package ec.edu.uce.erpmunicipal.contabilidad.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ec.edu.uce.erpmunicipal.contabilidad.bsl.CloseService;
import ec.edu.uce.erpmunicipal.contabilidad.orm.ConPeriodo;


@ManagedBean(name = "closePage")
@ViewScoped
public class ClosePage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB(name = "closeService/local")
	private CloseService closeService;

	public List<ConPeriodo> listPeriodo;
	
	public ClosePage()
	{
		
	}

	public List<ConPeriodo> getListPeriodo() {
		return listPeriodo;
	}

	public void setListPeriodo(List<ConPeriodo> listPeriodo) {
		this.listPeriodo = listPeriodo;
	}
	
	private void read()
	{
		this.listPeriodo=closeService.readAll(2013);
	}
	
	@PostConstruct
	private void init()
	{
		read();
	}
}
