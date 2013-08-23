package ec.edu.uce.erpmunicipal.sistema.bean;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import ec.edu.uce.erpmunicipal.contabilidad.orm.ConPeriodo;
import ec.edu.uce.erpmunicipal.sistema.bsl.SelectOptionService;
import ec.edu.uce.erpmunicipal.util.orm.SessionObject;

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

	private int anio;
	
	public SelectOptionsPage() {
		listPeriodo = new ArrayList<ConPeriodo>();
	}

	public List<ConPeriodo> getListPeriodo() {
		return listPeriodo;
	}

	public void setListPeriodo(List<ConPeriodo> listPeriodo) {
		this.listPeriodo = listPeriodo;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	@PostConstruct
	public void init() {
		this.listPeriodo = selectOptionService.readYear();
	}

	public void next() {
		SessionObject obj= (SessionObject) FacesContext.getCurrentInstance()
				.getExternalContext().getSessionMap().get("sessionObject");
		FacesContext.getCurrentInstance()
		.getExternalContext().getSessionMap().remove("sessionObject");
		
		obj.setAnio(anio);
		
		FacesContext.getCurrentInstance()
		.getExternalContext().getSessionMap().put("sessionObject", obj);
		
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("pages/system/home.jsf");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
