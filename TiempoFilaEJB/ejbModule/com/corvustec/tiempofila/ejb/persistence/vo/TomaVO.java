package com.corvustec.tiempofila.ejb.persistence.vo;

import java.io.Serializable;

import com.corvustec.tiempofila.ejb.persistence.entities.ClienteDTO;
import com.corvustec.tiempofila.ejb.persistence.entities.TiempoDTO;

public class TomaVO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	private ClienteDTO cliente;
	private TiempoDTO tiempo;
	
	public TomaVO() {
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
