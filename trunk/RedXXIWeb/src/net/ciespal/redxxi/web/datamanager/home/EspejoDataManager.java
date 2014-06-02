package net.ciespal.redxxi.web.datamanager.home;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import net.ciespal.redxxi.ejb.persistence.entities.PaisDTO;
import net.ciespal.redxxi.ejb.persistence.entities.espejo.EspejoDTO;
import net.ciespal.redxxi.ejb.persistence.entities.espejo.EspejoVisorDTO;

@SessionScoped
@ManagedBean(name = "espejoDataManager")
public class EspejoDataManager implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<EspejoDTO> espejoList;
	private List<PaisDTO> paisList;
	private List<EspejoVisorDTO> espejoVisorList;
	
	private PaisDTO pais;
	
	private EspejoDTO espejo;

	public EspejoDataManager() {
		espejoList=new ArrayList<EspejoDTO>();
		paisList=new ArrayList<PaisDTO>();
		espejoVisorList=new ArrayList<EspejoVisorDTO>();
		
		pais=new PaisDTO();
		
		espejo=new EspejoDTO();
	}

	public List<EspejoDTO> getEspejoList() {
		return espejoList;
	}

	public void setEspejoList(List<EspejoDTO> espejoList) {
		this.espejoList = espejoList;
	}

	public List<PaisDTO> getPaisList() {
		return paisList;
	}

	public void setPaisList(List<PaisDTO> paisList) {
		this.paisList = paisList;
	}

	public List<EspejoVisorDTO> getEspejoVisorList() {
		return espejoVisorList;
	}

	public void setEspejoVisorList(List<EspejoVisorDTO> espejoVisorList) {
		this.espejoVisorList = espejoVisorList;
	}

	public PaisDTO getPais() {
		return pais;
	}

	public void setPais(PaisDTO pais) {
		this.pais = pais;
	}

	public EspejoDTO getEspejo() {
		return espejo;
	}

	public void setEspejo(EspejoDTO espejo) {
		this.espejo = espejo;
	}
	
}
