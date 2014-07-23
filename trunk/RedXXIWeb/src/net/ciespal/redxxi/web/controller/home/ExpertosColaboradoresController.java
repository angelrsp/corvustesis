package net.ciespal.redxxi.web.controller.home;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import net.ciespal.redxxi.ejb.negocio.AdministracionService;
import net.ciespal.redxxi.ejb.persistence.entities.security.UsuarioVieDTO;
import net.ciespal.redxxi.web.commons.util.JsfUtil;
import net.ciespal.redxxi.web.datamanager.home.ExpertosColaboradoresDataManager;

import com.corvustec.commons.util.CorvustecException;

@ViewScoped
@ManagedBean(name = "expertosColaboradoresController")
public class ExpertosColaboradoresController {

	
	@ManagedProperty(value="#{expertosColaboradoresDataManager}")
	private ExpertosColaboradoresDataManager expertosColaboradoresDataManager;

	@EJB
	private AdministracionService administracionService;
	
	
	public ExpertosColaboradoresController() {
	
	}
	
	public ExpertosColaboradoresDataManager getExpertosColaboradoresDataManager() {
		return expertosColaboradoresDataManager;
	}

	public void setExpertosColaboradoresDataManager(
			ExpertosColaboradoresDataManager expertosColaboradoresDataManager) {
		this.expertosColaboradoresDataManager = expertosColaboradoresDataManager;
	}

	@PostConstruct
	private void init()
	{
		readAll();
	}
	
	private void readAll()
	{
		UsuarioVieDTO user;
		try {
			user=new UsuarioVieDTO();
			user.setUsuTipo(3);
			expertosColaboradoresDataManager.setUserVieList(administracionService.readAllUserVie(user));
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
}
