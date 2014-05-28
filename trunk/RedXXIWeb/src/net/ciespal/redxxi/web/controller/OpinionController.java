package net.ciespal.redxxi.web.controller;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.corvustec.commons.util.ApplicationUtil;
import com.corvustec.commons.util.CorvustecException;

import net.ciespal.redxxi.ejb.negocio.ArgosService;
import net.ciespal.redxxi.ejb.persistence.entities.argos.DefensorDTO;
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
	
	public OpinionDataManager getOpinionDataManager() {
		return opinionDataManager;
	}

	public void setOpinionDataManager(OpinionDataManager opinionDataManager) {
		this.opinionDataManager = opinionDataManager;
	}

	public void save()
	{
		try {
			if(!verificarFecha())
			{
				JsfUtil.addErrorMessage("Fecha no valida");
				return;
			}
			
			DefensorDTO def= (DefensorDTO) JsfUtil.getObject("DefensorDTO");
			if(def==null)
			{
				JsfUtil.addErrorMessage("Usuario no logueado");
				return;
			}
			opinionDataManager.getOpinionDTO().setArgDefensor(def);
			argosService.opinionCreateOrUpdate(opinionDataManager.getOpinionDTO());
			JsfUtil.addInfoMessage("Su comentario ingresara a lista de validación sera aprobado en poco tiempo");
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
	public Boolean verificarFecha()
	{
		Boolean flag;
		if(!ApplicationUtil.validarFecha(opinionDataManager.getFecha()))
		{
			JsfUtil.addErrorMessage("Fecha no valida");
			flag=Boolean.FALSE;
		}
		else
			flag=Boolean.TRUE;
		return flag;
	}
	
}
