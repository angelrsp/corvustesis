package ec.edu.uce.besg.web.controller;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import ec.edu.uce.besg.ejb.service.EmpresaService;
import ec.edu.uce.besg.ejb.vo.EmpresaVO;
import ec.edu.uce.besg.web.datamanager.RegistroEmpresaDataManager;
import ec.edu.uce.besg.web.util.JsfUtil;

@ViewScoped
@ManagedBean(name = "registroEmpresaController")
public class RegistroEmpresaController implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@ManagedProperty(value="#{registroEmpresaDataManager}")
	private RegistroEmpresaDataManager registroEmpresaDataManager;

	
	@EJB
	private EmpresaService servicioEmpresa;

	public RegistroEmpresaController () {
		
	}
	
	public RegistroEmpresaDataManager getRegistroEmpresaDataManager() {
		return registroEmpresaDataManager;
	}

	public void setRegistroEmpresaDataManager(
			RegistroEmpresaDataManager registroEmpresaDataManager) {
		this.registroEmpresaDataManager = registroEmpresaDataManager;
	}


	public void registrar()
	{
		EmpresaVO empresa;
		try {
			empresa=new EmpresaVO();
			empresa.setEmpresaDTO(registroEmpresaDataManager.getEmpresaDTO());
			empresa.setUsuarioDTO(registroEmpresaDataManager.getUsuarioDTO());
			servicioEmpresa.registrarActualizarEmpresa(empresa);
			JsfUtil.addInfoMessage("Registro Exitoso");
			JsfUtil.redirect("pages/empresa/inicio.xhtml");
		} catch (Exception e) {
			JsfUtil.addErrorMessage(e.toString());
		}
		finally{
			empresa=null;
		}
	}
	
}
