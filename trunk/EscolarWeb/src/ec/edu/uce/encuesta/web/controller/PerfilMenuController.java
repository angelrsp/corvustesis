package ec.edu.uce.encuesta.web.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.TransferEvent;

import com.corvustec.notas.common.util.CorvustecException;
import com.corvustec.notas.common.util.dto.ObjetoDTO;
import com.corvustec.notas.web.util.JsfUtil;

import ec.edu.uce.notas.ejb.persistence.entity.MenuDTO;
import ec.edu.uce.notas.ejb.persistence.entity.PerfilDTO;
import ec.edu.uce.notas.ejb.persistence.entity.view.AccesoViewDTO;
import ec.edu.uce.notas.ejb.persistence.entity.view.ComponenteMenuViewDTO;
import ec.edu.uce.notas.ejb.persistence.vo.AccesoVO;
import ec.edu.uce.notas.ejb.service.AdministracionService;
import ec.edu.uce.notas.web.datamanager.PerfilMenuDataManager;

@ViewScoped
@ManagedBean(name="perfilMenuController")
public class PerfilMenuController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@EJB
	private AdministracionService administracionService;

	@ManagedProperty(value="#{perfilMenuDataManager}")
	private PerfilMenuDataManager perfilMenuDataManager;

	
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
			perfilMenuDataManager.setPerfilList(administracionService.readPerfil(new PerfilDTO()));
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
	private void menuRead()
	{
		try {
			perfilMenuDataManager.setMenuList(administracionService.readMenu(new MenuDTO()));
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
	public void accesoRead()
	{
		AccesoViewDTO acc;
		ObjetoDTO obj;
		ComponenteMenuViewDTO cme;
		List<ObjetoDTO> accesoList;
		List<ObjetoDTO> autorizadoList;
		List<AccesoViewDTO> accList;
		List<ComponenteMenuViewDTO> cmeList;
		try {
			acc=new AccesoViewDTO();
			cme=new ComponenteMenuViewDTO();
			accesoList=new ArrayList<ObjetoDTO>();
			autorizadoList=new ArrayList<ObjetoDTO>();
	
			acc.setAccPerfil(perfilMenuDataManager.getPerfilCode());
			
			cme.setCmeMenu(perfilMenuDataManager.getMenuCode());
			
			cmeList=administracionService.readComponanteMenuView(cme, acc);
			for(ComponenteMenuViewDTO a: cmeList)
			{
				obj=new ObjetoDTO();
				obj.setCodigo(a.getCmeCodigo());
				obj.setDescripcion(a.getComDescripcion());
				accesoList.add(obj);
			}

			acc=new AccesoViewDTO();
			acc.setCmeMenu(perfilMenuDataManager.getMenuCode());
			acc.setAccPerfil(perfilMenuDataManager.getPerfilCode());
			
			accList=administracionService.readAccesoView(acc);
			for(AccesoViewDTO a: accList)
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
		List<AccesoViewDTO> accList;
		AccesoVO acc;
		AccesoViewDTO accVie;
		PerfilDTO perfil;
        try {
    		accList=new ArrayList<AccesoViewDTO>();
    		acc=new AccesoVO();
    		perfil=new PerfilDTO();
    		perfil.setPerCodigo(perfilMenuDataManager.getPerfilCode());
    		acc.setPerfil(perfil);
            for(Object item : event.getItems()) {
            	accVie=new AccesoViewDTO();
            	accVie.setCmeCodigo(Integer.valueOf(item.toString()));
            	accList.add(accVie);
            }
            acc.setAccesoList(accList);
            if(event.isAdd())
            	administracionService.createOrUpdateAcceso(acc);
            else
            	administracionService.deleteAcceso(acc);
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
    }  
}
