package net.ciespal.redxxi.web.controller;

import java.sql.Timestamp;
import java.text.ParseException;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.corvustec.commons.util.ApplicationUtil;
import com.corvustec.commons.util.CalendarUtil;
import com.corvustec.commons.util.CorvustecException;

import net.ciespal.redxxi.ejb.negocio.ArgosService;
import net.ciespal.redxxi.ejb.persistence.entities.argos.DefensorDTO;
import net.ciespal.redxxi.ejb.persistence.entities.argos.OpinionDTO;
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
			opinionDataManager.getOpinionDTO().setOpiPais(def.getDefPais());
			opinionDataManager.getOpinionDTO().setOpiProvincia(def.getDefProvincia());
			opinionDataManager.getOpinionDTO().setOpiCiudad(def.getDefCiudad());
			opinionDataManager.getOpinionDTO().setArgDefensor(def);
			opinionDataManager.getOpinionDTO().setOpiEstado(Boolean.FALSE);
			opinionDataManager.getOpinionDTO().setOpiFechaRefenrencia(new Timestamp(CalendarUtil.converStringToCalendar(opinionDataManager.getFecha(), "yyyy-MM-dd").getTimeInMillis()));
			argosService.opinionCreateOrUpdate(opinionDataManager.getOpinionDTO());
			JsfUtil.addInfoMessage("Su comentario ingresara a lista de validación sera aprobado en poco tiempo");
			cancel();
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		} catch (ParseException e) {
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
	
	public void cancel()
	{
		opinionDataManager.setFecha("");
		opinionDataManager.setOpinionDTO(new OpinionDTO());		
	}
}
