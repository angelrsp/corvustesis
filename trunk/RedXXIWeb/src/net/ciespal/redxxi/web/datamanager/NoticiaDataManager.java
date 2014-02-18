package net.ciespal.redxxi.web.datamanager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import net.ciespal.redxxi.ejb.persistence.entities.NoticiaDTO;

@ViewScoped
@ManagedBean(name="noticiaDataManager")
public class NoticiaDataManager implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private NoticiaDTO noticia;
	private List<NoticiaDTO> noticiaList;
	
	@PostConstruct
	private void init()
	{
		noticia=new NoticiaDTO();
		noticiaList=new ArrayList<NoticiaDTO>();
	}

	public NoticiaDTO getNoticia() {
		return noticia;
	}

	public void setNoticia(NoticiaDTO noticia) {
		this.noticia = noticia;
	}

	public List<NoticiaDTO> getNoticiaList() {
		return noticiaList;
	}

	public void setNoticiaList(List<NoticiaDTO> noticiaList) {
		this.noticiaList = noticiaList;
	}
	
	
}
