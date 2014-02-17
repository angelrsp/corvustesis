package ec.edu.uce.indicadores.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.MenuModel;

import ec.edu.uce.indicadores.commons.util.IndicadoresException;
import ec.edu.uce.indicadores.ejb.negocio.AdministracionService;
import ec.edu.uce.indicadores.ejb.negocio.IndicadorService;
import ec.edu.uce.indicadores.ejb.persistence.entities.OpcionDTO;
import ec.edu.uce.indicadores.ejb.persistence.entities.UsuarioDTO;
import ec.edu.uce.indicadores.web.datamanager.IndicadorDataManager;
import ec.edu.uce.indicadores.web.util.JsfUtil;

@SessionScoped
@ManagedBean(name="inicioController")
public class InicioController extends SelectItemController {

	
	@ManagedProperty(value="#{indicadorDataManager}")
	private IndicadorDataManager indicadorDataManager;
	
	@EJB
	private IndicadorService indicadorService;
	
	@EJB
	private AdministracionService administracionService;
	
	private MenuModel menuModel;
	
	@PostConstruct
	private void init()
	{
		indicadorDataManager.setUser((UsuarioDTO)JsfUtil.getObject("UsuarioDTO"));
		menuModel=new DefaultMenuModel();
	}
	
	public void aceptar()
	{
		try {
			indicadorDataManager.setIesDTO(indicadorService.obtenerIes(Integer.valueOf(indicadorDataManager.getIes().toString())));
			indicadorDataManager.setModeloDTO(indicadorService.obtenerModelo(Integer.valueOf(indicadorDataManager.getModelo().toString())));
		} catch (IndicadoresException e) {
			e.printStackTrace();
		}
	}

	public void setIndicadorDataManager(IndicadorDataManager indicadorDataManager) {
		this.indicadorDataManager = indicadorDataManager;
	}
	
	
	public MenuModel getMenuModel() {
		List<OpcionDTO> listOption;
		try {
			listOption=new ArrayList<OpcionDTO>();
			listOption= administracionService.readOpcion(indicadorDataManager.getUser().getIndUsuarioPerfils().get(0).getIndPerfil());
			
			menuModel.getElements().clear();
	        
	        for(OpcionDTO opt:listOption)
	        {
	        	DefaultMenuItem item = new DefaultMenuItem(opt.getOpcNombre());
		        item.setUrl(opt.getOpcUrl());
		        item.setIcon(opt.getOpcIcono());

		        menuModel.addElement(item);
	        }
	        
        	DefaultMenuItem item2 = new DefaultMenuItem("Salir");
	        item2.setCommand("#{loginController.logout}");
	        item2.setIcon("exit");
	        //menuModel.addElement(item2);
			
		} catch (IndicadoresException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
		
		return menuModel;
	}

	public void setMenuModel(MenuModel menuModel) {
		this.menuModel = menuModel;
	}
	
}
