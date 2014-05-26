package net.ciespal.redxxi.web.controller.home;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import net.ciespal.redxxi.ejb.negocio.ArgosService;
import net.ciespal.redxxi.ejb.persistence.vo.DefensorVO;
import net.ciespal.redxxi.web.commons.util.JsfUtil;
import net.ciespal.redxxi.web.datamanager.home.RegistroDefensorDataManager;

import com.corvustec.commons.util.CorvustecException;

@ViewScoped
@ManagedBean (name = "registroDefensorController")
public class RegistroDefensorController {

	
	@ManagedProperty(value="#{registroDefensorDataManager}")
	private RegistroDefensorDataManager registroDefensorDataManager;

	@EJB
	private ArgosService argosService;
	
	public RegistroDefensorController() {
	
	}
	
	public RegistroDefensorDataManager getRegistroDefensorDataManager() {
		return registroDefensorDataManager;
	}

	public void setRegistroDefensorDataManager(
			RegistroDefensorDataManager registroDefensorDataManager) {
		this.registroDefensorDataManager = registroDefensorDataManager;
	}

	
	public void registrar()
	{
		DefensorVO defensor;
		try {
			defensor=new DefensorVO();
			defensor.setUser(registroDefensorDataManager.getUser());
			argosService.defensorCreateOrUpdate(defensor);
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}	
	}
}
