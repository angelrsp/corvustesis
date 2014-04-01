package net.ciespal.redxxi.web.datamanager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import net.ciespal.redxxi.ejb.persistence.entities.espejo.GranMaestroDTO;
import net.ciespal.redxxi.ejb.persistence.entities.espejo.NoticiaEspejoDTO;
import net.ciespal.redxxi.ejb.persistence.entities.espejo.ObraEspejoDTO;

@ViewScoped
@ManagedBean(name = "maestroPeriodismoDataManager")
public class MaestroPeriodismoDataManager implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private GranMaestroDTO granMaestroDTO;
	private List<GranMaestroDTO> granMaestroList;
	private Date fechaNacimiento;
	private Date fechaFallecimiento;
	
	private NoticiaEspejoDTO noticia;
	private List<NoticiaEspejoDTO> noticiaList;
	
	private ObraEspejoDTO obra;
	private List<ObraEspejoDTO> obraList;
	
	private ObraEspejoDTO obraSobre;
	private List<ObraEspejoDTO> obraSobreList;
	
	public MaestroPeriodismoDataManager() {
		granMaestroDTO=new GranMaestroDTO();
		granMaestroList=new ArrayList<GranMaestroDTO>();
		noticia=new NoticiaEspejoDTO();
		noticiaList=new ArrayList<NoticiaEspejoDTO>();
		
		obra=new ObraEspejoDTO();
		obraSobre=new ObraEspejoDTO();
		
		obraList=new ArrayList<ObraEspejoDTO>();
		obraSobreList=new ArrayList<ObraEspejoDTO>();
	}

	public GranMaestroDTO getGranMaestroDTO() {
		return granMaestroDTO;
	}

	public void setGranMaestroDTO(GranMaestroDTO granMaestroDTO) {
		this.granMaestroDTO = granMaestroDTO;
	}

	public List<GranMaestroDTO> getGranMaestroList() {
		return granMaestroList;
	}

	public void setGranMaestroList(List<GranMaestroDTO> granMaestroList) {
		this.granMaestroList = granMaestroList;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Date getFechaFallecimiento() {
		return fechaFallecimiento;
	}

	public void setFechaFallecimiento(Date fechaFallecimiento) {
		this.fechaFallecimiento = fechaFallecimiento;
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

	public ObraEspejoDTO getObra() {
		return obra;
	}

	public void setObra(ObraEspejoDTO obra) {
		this.obra = obra;
	}

	public List<ObraEspejoDTO> getObraList() {
		return obraList;
	}

	public void setObraList(List<ObraEspejoDTO> obraList) {
		this.obraList = obraList;
	}

	public ObraEspejoDTO getObraSobre() {
		return obraSobre;
	}

	public void setObraSobre(ObraEspejoDTO obraSobre) {
		this.obraSobre = obraSobre;
	}

	public List<ObraEspejoDTO> getObraSobreList() {
		return obraSobreList;
	}

	public void setObraSobreList(List<ObraEspejoDTO> obraSobreList) {
		this.obraSobreList = obraSobreList;
	}
	
	
}
