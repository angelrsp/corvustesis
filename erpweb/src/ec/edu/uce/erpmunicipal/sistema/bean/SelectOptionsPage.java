package ec.edu.uce.erpmunicipal.sistema.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import ec.edu.uce.erpmunicipal.contabilidad.orm.ConPeriodo;
import ec.edu.uce.erpmunicipal.sistema.bsl.SelectOptionService;

@ManagedBean(name = "selectOptionsPage")
@SessionScoped
public class SelectOptionsPage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB(name = "selectOptionService/local")
	private SelectOptionService selectOptionService;

	private List<ConPeriodo> listPeriodo;

	public SelectOptionsPage() {
		listPeriodo = new ArrayList<ConPeriodo>();
	}

	public List<ConPeriodo> getListPeriodo() {
		return listPeriodo;
	}

	public void setListPeriodo(List<ConPeriodo> listPeriodo) {
		this.listPeriodo = listPeriodo;
	}

	@PostConstruct
	public void init() {
		this.listPeriodo = selectOptionService.readYear();
	}

}
