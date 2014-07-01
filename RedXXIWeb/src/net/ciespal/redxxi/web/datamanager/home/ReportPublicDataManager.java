package net.ciespal.redxxi.web.datamanager.home;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import net.ciespal.redxxi.ejb.persistence.entities.AteneaDTO;
import net.ciespal.redxxi.ejb.persistence.entities.AteneaVisorDTO;
import net.ciespal.redxxi.ejb.persistence.entities.PaisDTO;


@SessionScoped
@ManagedBean(name = "reportPublicDataManager")
public class ReportPublicDataManager implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<PaisDTO> paisList;
	private List<AteneaDTO> ateneaList;
	private List<AteneaVisorDTO> ateneaVisorList;
	
	
	private AteneaDTO atenea;
	
	private String visor;
	
	private PaisDTO pais;
	
	
	private int ateneaCount;
	private int argosCount;
	private int espejoCount;
	
	private String tipoConsulta;
	
	public ReportPublicDataManager() {
		paisList=new ArrayList<PaisDTO>();
		ateneaList=new ArrayList<AteneaDTO>();
		pais=new PaisDTO();
		atenea=new AteneaDTO();
		ateneaVisorList=new ArrayList<AteneaVisorDTO>();
	}

	public List<PaisDTO> getPaisList() {
		return paisList;
	}

	public void setPaisList(List<PaisDTO> paisList) {
		this.paisList = paisList;
	}

	public List<AteneaDTO> getAteneaList() {
		return ateneaList;
	}

	public void setAteneaList(List<AteneaDTO> ateneaList) {
		this.ateneaList = ateneaList;
	}

	public String getVisor() {
		return visor;
	}

	public void setVisor(String visor) {
		this.visor = visor;
	}

	public PaisDTO getPais() {
		return pais;
	}

	public AteneaDTO getAtenea() {
		return atenea;
	}

	public void setAtenea(AteneaDTO atenea) {
		this.atenea = atenea;
	}

	public void setPais(PaisDTO pais) {
		this.pais = pais;
	}

	public List<AteneaVisorDTO> getAteneaVisorList() {
		return ateneaVisorList;
	}

	public void setAteneaVisorList(List<AteneaVisorDTO> ateneaVisorList) {
		this.ateneaVisorList = ateneaVisorList;
	}

	public int getAteneaCount() {
		return ateneaCount;
	}

	public void setAteneaCount(int ateneaCount) {
		this.ateneaCount = ateneaCount;
	}

	public int getArgosCount() {
		return argosCount;
	}

	public void setArgosCount(int argosCount) {
		this.argosCount = argosCount;
	}

	public int getEspejoCount() {
		return espejoCount;
	}

	public void setEspejoCount(int espejoCount) {
		this.espejoCount = espejoCount;
	}

	public String getTipoConsulta() {
		return tipoConsulta;
	}

	public void setTipoConsulta(String tipoConsulta) {
		this.tipoConsulta = tipoConsulta;
	}

	
}
