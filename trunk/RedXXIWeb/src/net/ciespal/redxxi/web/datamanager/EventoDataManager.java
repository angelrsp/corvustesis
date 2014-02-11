package net.ciespal.redxxi.web.datamanager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import net.ciespal.redxxi.ejb.persistence.entities.EventoDTO;

@SessionScoped
@ManagedBean(name="eventoDataManager")
public class EventoDataManager implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private EventoDTO evento;
	private List<EventoDTO> eventoList;
	
	public EventoDataManager() {
	}
	
	@PostConstruct
	private void init()
	{
		evento=new EventoDTO();
		eventoList=new ArrayList<EventoDTO>();
	}

	public EventoDTO getEvento() {
		return evento;
	}

	public void setEvento(EventoDTO evento) {
		this.evento = evento;
	}

	public List<EventoDTO> getEventoList() {
		return eventoList;
	}

	public void setEventoList(List<EventoDTO> eventoList) {
		this.eventoList = eventoList;
	}
}
