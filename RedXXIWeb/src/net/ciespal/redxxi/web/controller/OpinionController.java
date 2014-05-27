package net.ciespal.redxxi.web.controller;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.corvustec.commons.util.CorvustecException;

import net.ciespal.redxxi.ejb.negocio.ArgosService;
import net.ciespal.redxxi.web.commons.util.JsfUtil;
import net.ciespal.redxxi.web.datamanager.OpinionDataManager;

@ViewScoped
@ManagedBean(name = "opinionController")
public class OpinionController {

	
	@EJB
	private ArgosService argosService;
	
	@ManagedProperty(value="#{opinionDataManager}")
	private OpinionDataManager opinionDataManager;


	public OpinionController() {
	
	}
	
	public void save()
	{
		try {
			
			argosService.opinionCreateOrUpdate(opinionDataManager.getOpinionDTO());
			JsfUtil.addInfoMessage("Su comentario ingresara a lista de validación sera aprobado en poco tiempo");
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
}
