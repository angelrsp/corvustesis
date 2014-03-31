package net.ciespal.redxxi.web.datamanager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import net.ciespal.redxxi.ejb.persistence.entities.espejo.EticaDTO;
import net.ciespal.redxxi.ejb.persistence.entities.espejo.NoticiaEspejoDTO;

@ViewScoped
@ManagedBean(name = "eticaDataManager")
public class EticaDataManager implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private EticaDTO eticaDTO;
	private List<EticaDTO> eticaList;

	private NoticiaEspejoDTO noticia;
	private List<NoticiaEspejoDTO> noticiaList;
	
	public EticaDataManager() {
		eticaDTO=new EticaDTO();
		eticaList=new ArrayList<EticaDTO>();
		
		noticia=new NoticiaEspejoDTO();
		noticiaList=new ArrayList<NoticiaEspejoDTO>();
	}

	
	public EticaDTO getEticaDTO() {
		return eticaDTO;
	}

	public void setEticaDTO(EticaDTO eticaDTO) {
		this.eticaDTO = eticaDTO;
	}

	public List<EticaDTO> getEticaList() {
		return eticaList;
	}

	public void setEticaList(List<EticaDTO> eticaList) {
		this.eticaList = eticaList;
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
