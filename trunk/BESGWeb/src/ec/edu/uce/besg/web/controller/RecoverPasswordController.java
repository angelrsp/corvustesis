package ec.edu.uce.besg.web.controller;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.primefaces.context.RequestContext;

import ec.edu.uce.besg.common.util.CorvustecException;
import ec.edu.uce.besg.ejb.service.SecurityService;
import ec.edu.uce.besg.web.datamanager.RecoverPasswordDataManager;
import ec.edu.uce.besg.web.util.JsfUtil;


@ViewScoped
@ManagedBean(name="recoverPasswordController")
public class RecoverPasswordController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private SecurityService securityService;
	
	@ManagedProperty(value="#{recoverPasswordDataManager}")
	private RecoverPasswordDataManager recoverPasswordDataManager;

	public RecoverPasswordController() {
	
	}
	
	public RecoverPasswordDataManager getRecoverPasswordDataManager() {
		return recoverPasswordDataManager;
	}


	public void setRecoverPasswordDataManager(
			RecoverPasswordDataManager recoverPasswordDataManager) {
		this.recoverPasswordDataManager = recoverPasswordDataManager;
	}


	public void onClickRecover()
	{
		try {
			securityService.recoverPassword(recoverPasswordDataManager.getUsuarioDTO());
			RequestContext.getCurrentInstance().execute("PF('dlgConfirmar').show();");
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.getMessage());
		}
		
		
	}
	
}


