package net.ciespal.redxxi.web.datamanager.home;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import net.ciespal.redxxi.ejb.persistence.entities.NoticiaDTO;


@SessionScoped
@ManagedBean(name = "noticiaVisorDataManager")
public class NoticiaVisorDataManager implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		
	private NoticiaDTO noticiaDTO;
	private List<NoticiaDTO> noticiaList;
	
	
	public NoticiaVisorDataManager() {
	
	}
	
	@PostConstruct
	private void init()
	{
		noticiaDTO=new NoticiaDTO();
		noticiaList=new ArrayList<NoticiaDTO>();
	}

	public NoticiaDTO getNoticiaDTO() {
		return noticiaDTO;
	}

	public void setNoticiaDTO(NoticiaDTO noticiaDTO) {
		this.noticiaDTO = noticiaDTO;
	}

	public List<NoticiaDTO> getNoticiaList() {
		return noticiaList;
	}

	public void setNoticiaList(List<NoticiaDTO> noticiaList) {
		this.noticiaList = noticiaList;
	}
	
	
	
}
