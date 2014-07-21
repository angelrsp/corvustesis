package net.ciespal.redxxi.web.controller.home;

import java.io.IOException;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import net.ciespal.redxxi.ejb.negocio.EspejoService;
import net.ciespal.redxxi.ejb.persistence.entities.PaisDTO;
import net.ciespal.redxxi.ejb.persistence.entities.espejo.EspejoDTO;
import net.ciespal.redxxi.web.commons.util.JsfUtil;
import net.ciespal.redxxi.web.datamanager.home.EspejoDataManager;

import com.corvustec.commons.util.CorvustecException;

@ViewScoped
@ManagedBean(name = "espejoController")
public class EspejoController implements Serializable{

	
	private static final long serialVersionUID = 1L;

	@EJB
	private EspejoService espejoService;
	
	@ManagedProperty(value="#{espejoDataManager}")
	private EspejoDataManager espejoDataManager;

	
	public EspejoController() {
	}

	
	
	@PostConstruct
	private void init()
	{
		readEspejo();
		readPais();
	}

	public EspejoDataManager getEspejoDataManager() {
		return espejoDataManager;
	}

	public void setEspejoDataManager(EspejoDataManager espejoDataManager) {
		this.espejoDataManager = espejoDataManager;
	}



	private void readEspejo()
	{
		try {
			espejoDataManager.setEspejoList(espejoService.readEspejo(null));
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}

	private void readPais()
	{
		try {
			espejoDataManager.setPaisList(espejoService.readPais(null));
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}

	
	public void selectEspejo(EspejoDTO espejo)
	{
		try {		
			espejoDataManager.setPaisList(espejoService.readPais(espejo.getTipo()));
			espejoDataManager.setEspejo(espejo);
			
			if(espejo.getTipo()==1)
				espejoDataManager.setTipoConsulta("Etica y Deontologia");
			else if(espejo.getTipo()==2)
				espejoDataManager.setTipoConsulta("Grandes Maestros del Periodismo");
			else if(espejo.getTipo()==3)
				espejoDataManager.setTipoConsulta("Maestros de la Comunicación");
			else if(espejo.getTipo()==4)
				espejoDataManager.setTipoConsulta("Premios Periodísticos");
			else if(espejo.getTipo()==5)
				espejoDataManager.setTipoConsulta("Premio Ciespal");			
			else if(espejo.getTipo()==6)
				espejoDataManager.setTipoConsulta("Códigos de Ética y Leyes de Comunicación");			
			
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
	public void selectPais(PaisDTO pais)
	{
		EspejoDTO espejo;
		try {
			espejoDataManager.setPais(pais);
			espejoDataManager.setEspejoList(espejoService.readEspejo(pais.getCodigo()));
			//reportPublicDataManager.setVisor(ateneaService.infoPais(pais));
			if(espejoDataManager.getEspejo().getTipo()!=0)
				pais.setTipo(espejoDataManager.getEspejo().getTipo());
			else
				pais.setTipo(1);

			espejo=new EspejoDTO();
			espejo.setPais(pais.getCodigo());
			espejo.setTipo(pais.getTipo());
			
			espejoDataManager.setEspejoVisorList(espejoService.visorList(espejo));
			espejoDataManager.getEspejo().setTipo(0);
			JsfUtil.redirect(JsfUtil.getContextPath()+"/public/home/espejoVisor.xhtml");
		} catch (IOException e) {
			JsfUtil.addErrorMessage(e.toString());
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}

	
}
