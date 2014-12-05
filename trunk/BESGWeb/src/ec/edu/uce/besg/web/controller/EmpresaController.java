package ec.edu.uce.besg.web.controller;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import ec.edu.uce.besg.ejb.service.ServicioEmpresa;
import ec.edu.uce.besg.web.datamanager.EmpresaDataManager;

@ViewScoped
@ManagedBean(name = "empresaController")
public class EmpresaController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ManagedProperty(value="#{empresaDataManager}")
	private EmpresaDataManager empresaDataManager;

	@EJB
	private ServicioEmpresa servicioEmpresa;

	public EmpresaController() {
	
	}

	

}
