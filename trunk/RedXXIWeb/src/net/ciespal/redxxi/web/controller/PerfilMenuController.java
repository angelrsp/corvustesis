package net.ciespal.redxxi.web.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import net.ciespal.redxxi.ejb.negocio.AdministracionService;
import net.ciespal.redxxi.ejb.persistence.entities.security.AccesoVieDTO;
import net.ciespal.redxxi.ejb.persistence.entities.security.PerfilDTO;
import net.ciespal.redxxi.ejb.persistence.entities.util.dto.ObjetoDTO;
import net.ciespal.redxxi.ejb.persistence.entities.vo.AccesoVO;
import net.ciespal.redxxi.web.commons.util.JsfUtil;
import net.ciespal.redxxi.web.datamanager.PerfilMenuDataManager;

import org.primefaces.event.TransferEvent;

import com.corvustec.commons.util.CorvustecException;

@ViewScoped
@ManagedBean(name="perfilMenuController")
public class PerfilMenuController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
		perfilRead();
		menuRead();
		accesoRead();
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
	
	public void accesoRead()
	{
		AccesoVieDTO acc;
		ObjetoDTO obj;
		List<ObjetoDTO> accesoList;
		List<ObjetoDTO> autorizadoList;
		List<AccesoVieDTO> accList;
		try {
			acc=new AccesoVieDTO();
			accesoList=new ArrayList<ObjetoDTO>();
			autorizadoList=new ArrayList<ObjetoDTO>();
	
			acc.setCmeMenu(perfilMenuDataManager.getMenuCode());
		
			accList=administracionService.accesoVieReadPerfilIsNull(acc);
			for(AccesoVieDTO a: accList)
			{
				obj=new ObjetoDTO();
				obj.setCodigo(a.getCmeCodigo());
				obj.setDescripcion(a.getComDescripcion());
				accesoList.add(obj);
			}

			acc=new AccesoVieDTO();
			acc.setCmeMenu(perfilMenuDataManager.getMenuCode());
			acc.setAccPerfil(perfilMenuDataManager.getPerfilCode());
			
			accList=administracionService.accesoVieRead(acc);
			for(AccesoVieDTO a: accList)
			{
				obj=new ObjetoDTO();
				obj.setCodigo(a.getCmeCodigo());
				obj.setDescripcion(a.getComDescripcion());
				autorizadoList.add(obj);
			}

			perfilMenuDataManager.getDualListModel().setSource(accesoList);
			perfilMenuDataManager.getDualListModel().setTarget(autorizadoList);
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
	
	public void onTransfer(TransferEvent event) {
		List<AccesoVieDTO> accList;
		AccesoVO acc;
		AccesoVieDTO accVie;
		PerfilDTO perfil;
        try {
    		accList=new ArrayList<AccesoVieDTO>();
    		acc=new AccesoVO();
    		perfil=new PerfilDTO();
    		perfil.setPerCodigo(perfilMenuDataManager.getPerfilCode());
    		acc.setPerfil(perfil);
            for(Object item : event.getItems()) {
            	accVie=new AccesoVieDTO();
            	accVie.setCmeCodigo(Integer.valueOf(item.toString()));
            	accList.add(accVie);
            }
            acc.setAccesoList(accList);
            if(event.isAdd())
            	administracionService.accesoCreateOrUpdate(acc);
            else
            	administracionService.accesoDelete(acc);
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
    }  
}
