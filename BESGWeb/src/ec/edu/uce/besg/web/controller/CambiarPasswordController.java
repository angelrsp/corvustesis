package ec.edu.uce.besg.web.controller;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import ec.edu.uce.besg.common.util.CorvustecException;
import ec.edu.uce.besg.ejb.persistence.entity.security.UsuarioDTO;
import ec.edu.uce.besg.ejb.service.SecurityService;
import ec.edu.uce.besg.web.datamanager.CambiarPasswordDataManager;
import ec.edu.uce.besg.web.util.JsfUtil;

@ViewScoped
@ManagedBean(name = "cambiarPasswordController")
public class CambiarPasswordController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private SecurityService securityService;
	
	@ManagedProperty(value="#{cambiarPasswordDataManager}")
	private CambiarPasswordDataManager cambiarPasswordDataManager;

	
	public CambiarPasswordController() {
	
	}

	public CambiarPasswordDataManager getCambiarPasswordDataManager() {
		return cambiarPasswordDataManager;
	}

	public void setCambiarPasswordDataManager(
			CambiarPasswordDataManager cambiarPasswordDataManager) {
		this.cambiarPasswordDataManager = cambiarPasswordDataManager;
	}
	
	
	public void onClickUpdate()
	{
		try {
			cambiarPasswordDataManager.getPasswordDTO().setUsuarioDTO((UsuarioDTO)JsfUtil.getObject("UsuarioDTO"));
			securityService.changePassword(cambiarPasswordDataManager.getPasswordDTO());
			JsfUtil.addInfoMessage("Cambiado Exitosamente");
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
}
