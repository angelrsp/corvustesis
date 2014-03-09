package com.corvustec.tiempofila.web.datamanager;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.corvustec.tiempofila.ejb.persistence.entities.ClienteDTO;
import com.corvustec.tiempofila.ejb.persistence.entities.TiempoDTO;

@SessionScoped
@ManagedBean(name="inicioTomaDataManager")
public class InicioTomaDataManager implements Serializable{

	private static final long serialVersionUID = 1L;

	private ClienteDTO cliente;	
	private TiempoDTO tiempo;
	
	public InicioTomaDataManager() {
		cliente=new ClienteDTO();
		tiempo=new TiempoDTO();
	}

	public ClienteDTO getCliente() {
		return cliente;
	}

	public void setCliente(ClienteDTO cliente) {
		this.cliente = cliente;
	}

	public TiempoDTO getTiempo() {
		return tiempo;
	}

	public void setTiempo(TiempoDTO tiempo) {
		this.tiempo = tiempo;
	}
	
	
}
