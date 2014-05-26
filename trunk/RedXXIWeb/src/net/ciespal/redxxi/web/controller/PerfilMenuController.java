package net.ciespal.redxxi.web.controller;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import net.ciespal.redxxi.ejb.negocio.AdministracionService;
import net.ciespal.redxxi.web.commons.util.JsfUtil;
import net.ciespal.redxxi.web.datamanager.PerfilMenuDataManager;

import org.primefaces.event.TransferEvent;

import com.corvustec.commons.util.CorvustecException;

@ViewScoped
@ManagedBean(name="perfilMenuController")
public class PerfilMenuController {

	
	@ManagedProperty(value="#{perfilMenuDataManager}")
	private PerfilMenuDataManager perfilMenuDataManager;

	@EJB
	private AdministracionService administracionService;

	
	public PerfilMenuController() {

	}


	public PerfilMenuDataManager getPerfilMenuDataManager() {
		return perfilMenuDataManager;
	}


	public void setPerfilMenuDataManager(PerfilMenuDataManager perfilMenuDataManager) {
		this.perfilMenuDataManager = perfilMenuDataManager;
	}
	
	@PostConstruct
	private void init()
	{
		read();
		perfilRead();
		menuRead();
	}
	
	private void read()
	{
		
	}
	
	private void perfilRead()
	{
		try {
			perfilMenuDataManager.setPerfilList(administracionService.perfilReadAll());
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
	private void menuRead()
	{
		try {
			perfilMenuDataManager.setMenuList(administracionService.menuReadAll());
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
	public void onTransfer(TransferEvent event) {
//        StringBuilder builder = new StringBuilder();
//        for(Object item : event.getItems()) {
//            builder.append(((Theme) item).getName()).append("<br />");
//        }
//         
//        FacesMessage msg = new FacesMessage();
//        msg.setSeverity(FacesMessage.SEVERITY_INFO);
//        msg.setSummary("Items Transferred");
//        msg.setDetail(builder.toString());
//         
//        FacesContext.getCurrentInstance().addMessage(null, msg);
    }  
}
