package net.ciespal.redxxi.web.datamanager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import net.ciespal.redxxi.ejb.persistence.entities.espejo.NoticiaEspejoDTO;
import net.ciespal.redxxi.ejb.persistence.entities.espejo.PremioDTO;

@ViewScoped
@ManagedBean(name="premioPeriodisticoDataManager")
public class PremioPeriodisticoDataManager implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private PremioDTO premioDTO;
	private List<PremioDTO> premioList;
	
	private NoticiaEspejoDTO noticia;
	private List<NoticiaEspejoDTO> noticiaList;
	
	public PremioPeriodisticoDataManager() {
		premioDTO=new PremioDTO();
		premioList=new ArrayList<PremioDTO>();
		
		noticia=new NoticiaEspejoDTO();
		noticiaList=new ArrayList<NoticiaEspejoDTO>();
	}


	public PremioDTO getPremioDTO() {
		return premioDTO;
	}


	public void setPremioDTO(PremioDTO premioDTO) {
		this.premioDTO = premioDTO;
	}


	public List<PremioDTO> getPremioList() {
		return premioList;
	}


	public void setPremioList(List<PremioDTO> premioList) {
		this.premioList = premioList;
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
