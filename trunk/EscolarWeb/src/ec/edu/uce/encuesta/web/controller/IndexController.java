package ec.edu.uce.encuesta.web.controller;

import java.io.IOException;
import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.corvustec.notas.common.util.CorvustecException;
import com.corvustec.notas.web.util.JsfUtil;

import ec.edu.uce.notas.ejb.persistence.entity.UsuarioDTO;
import ec.edu.uce.notas.ejb.service.SecurityService;
import ec.edu.uce.notas.web.datamanager.IndexDataManager;

@ViewScoped
@ManagedBean(name = "indexController")
public class IndexController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EJB
	private SecurityService securityService;
	
	@ManagedProperty(value="#{indexDataManager}")
	private IndexDataManager indexDataManager;
	
	public IndexController() {
	
	}

	public IndexDataManager getIndexDataManager() {
		return indexDataManager;
	}
	public void setIndexDataManager(IndexDataManager indexDataManager) {
		this.indexDataManager = indexDataManager;
	}

	public void onClickLogin()
	{
		try {
			UsuarioDTO usuarioDTO= securityService.authenticateUser(indexDataManager.getCredencialDTO());
			if(usuarioDTO!=null)
			{
				JsfUtil.putObject("UsuarioDTO", usuarioDTO);
				indexDataManager.setUsuarioDTO(usuarioDTO);
				JsfUtil.redirect("/pages/inicio.xhtml");
			}
			else
				JsfUtil.addErrorMessage2("Problema al iniciar");				
			
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		} catch (IOException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
	public void onClickLogout()
	{
	}
	
}
