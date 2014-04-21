package ec.edu.uce.indicadores.web.controller;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
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
	
	
	private Boolean desactivado;
	
	private Boolean desactivarIes;
	
	
	private Boolean visible;
	
	public InicioController() {
		visible=true;
	}
	
	@PostConstruct
	private void init()
	{
		desactivarIes=true;
		indicadorDataManager.setUser((UsuarioDTO)JsfUtil.getObject("UsuarioDTO"));		
		menuModel=new DefaultMenuModel();
		desactivado=false;
		visible=true;
		indicadorDataManager.setIes(indicadorDataManager.getUser().getIndy().getIesCodigo());
		if(indicadorDataManager.getUser().getUsuCodigo()==1)
			desactivarIes=false;
	}
	
	public void aceptar()
	{
		try {
			indicadorDataManager.setIesDTO(indicadorService.obtenerIes(Integer.valueOf(indicadorDataManager.getIes().toString())));
			indicadorDataManager.setModeloDTO(indicadorService.obtenerModelo(Integer.valueOf(indicadorDataManager.getModelo().toString())));
			desactivado=true;
			visible=false;
		} catch (IndicadoresException e) {
			e.printStackTrace();
		}
	}

	public IndicadorDataManager getIndicadorDataManager() {
		return indicadorDataManager;
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
	        	DefaultMenuItem item = new DefaultMenuItem("  "+opt.getOpcNombre());
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
	
	
	public StreamedContent getImage(){
		String mime;
		FacesContext context = FacesContext.getCurrentInstance();
		if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
            // So, we're rendering the HTML. Return a stub StreamedContent so that it will generate right URL.
            return new DefaultStreamedContent();
        }else{
			if(indicadorDataManager.getUser().getIndy().getIesImagen()!=null)
			{
				mime=JsfUtil.getTypeFile(indicadorDataManager.getUser().getIndy().getIesImagen());
				return new DefaultStreamedContent(new ByteArrayInputStream(indicadorDataManager.getUser().getIndy().getIesImagen()),mime);
			}
			else
				return new DefaultStreamedContent();
        }
	}

	public Boolean getDesactivado() {
		return desactivado;
	}

	public void setDesactivado(Boolean desactivado) {
		this.desactivado = desactivado;
	}

	public Boolean getVisible() {
		return visible;
	}

	public void setVisible(Boolean visible) {
		this.visible = visible;
	}

	public Boolean getDesactivarIes() {
		return desactivarIes;
	}

	public void setDesactivarIes(Boolean desactivarIes) {
		this.desactivarIes = desactivarIes;
	}
	
}
