package net.ciespal.redxxi.web.datamanager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import net.ciespal.redxxi.ejb.persistence.entities.espejo.NoticiaEspejoDTO;
import net.ciespal.redxxi.ejb.persistence.entities.espejo.PremioCiespalDTO;

@ViewScoped
@ManagedBean(name="premioCiespalDataManager")
public class PremioCiespalDataManager implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private PremioCiespalDTO premioCiespalDTO;
	private List<PremioCiespalDTO> premioCiespalList;
	
	private NoticiaEspejoDTO noticia;
	private List<NoticiaEspejoDTO> noticiaList;
	
	public PremioCiespalDataManager() {
		premioCiespalDTO=new PremioCiespalDTO();
		premioCiespalList=new ArrayList<PremioCiespalDTO>();
		
		noticia=new NoticiaEspejoDTO();
		noticiaList=new ArrayList<NoticiaEspejoDTO>();
	}


	public PremioCiespalDTO getPremioCiespalDTO() {
		return premioCiespalDTO;
	}


	public void setPremioCiespalDTO(PremioCiespalDTO premioCiespalDTO) {
		this.premioCiespalDTO = premioCiespalDTO;
	}


	public List<PremioCiespalDTO> getPremioCiespalList() {
		return premioCiespalList;
	}


	public void setPremioCiespalList(List<PremioCiespalDTO> premioCiespalList) {
		this.premioCiespalList = premioCiespalList;
	}

	public NoticiaEspejoDTO getNoticia() {
		return noticia;
	}

	public void setNoticia(NoticiaEspejoDTO noticia) {
		this.noticia = noticia;
	}

	public List<NoticiaEspejoDTO> getNoticiaList() {
		return noticiaList;
	}

	public void setNoticiaList(List<NoticiaEspejoDTO> noticiaList) {
		this.noticiaList = noticiaList;
	}


}
