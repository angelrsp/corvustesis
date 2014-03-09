package com.corvustec.tiempofila.web.controller;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.corvustec.commons.util.CorvustecException;
import com.corvustec.tiempofila.ejb.negocio.TiempoService;
import com.corvustec.tiempofila.ejb.persistence.entities.ClienteDTO;
import com.corvustec.tiempofila.ejb.persistence.entities.TiempoDTO;
import com.corvustec.tiempofila.ejb.persistence.vo.TomaVO;
import com.corvustec.tiempofila.web.datamanager.InicioTomaDataManager;
import com.corvustec.web.commons.util.JsfUtil;

@ViewScoped
@ManagedBean(name="inicioTomaController")
public class InicioTomaController {

	@EJB
	private TiempoService tiempoService;

	@ManagedProperty(value="#{inicioTomaDataManager}")
	private InicioTomaDataManager inicioTomaDataManager;
	
	public InicioTomaController() {
		
	}

	public InicioTomaDataManager getInicioTomaDataManager() {
		return inicioTomaDataManager;
	}

	public void setInicioTomaDataManager(InicioTomaDataManager inicioTomaDataManager) {
		this.inicioTomaDataManager = inicioTomaDataManager;
	}
	
	
	public void save()
	{
		TomaVO toma;
		try {
			toma=new TomaVO();
			toma.setCliente(inicioTomaDataManager.getCliente());
			toma.setTiempo(inicioTomaDataManager.getTiempo());
			tiempoService.createTomaInicio(toma);
			inicioTomaDataManager.setCliente(new ClienteDTO());
			inicioTomaDataManager.setTiempo(new TiempoDTO());
			JsfUtil.addInfoMessage("Guardado Exitosamente");
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
		
	}
}
