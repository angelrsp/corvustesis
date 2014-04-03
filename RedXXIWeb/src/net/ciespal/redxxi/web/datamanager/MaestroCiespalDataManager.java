package net.ciespal.redxxi.web.datamanager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import net.ciespal.redxxi.ejb.persistence.entities.espejo.MaestroCiespalDTO;
import net.ciespal.redxxi.ejb.persistence.entities.espejo.NoticiaEspejoDTO;
import net.ciespal.redxxi.ejb.persistence.entities.espejo.ObraEspejoDTO;

@ViewScoped
@ManagedBean(name="maestroCiespalDataManager")
public class MaestroCiespalDataManager implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private MaestroCiespalDTO maestroCiespalDTO;
	private List<MaestroCiespalDTO> maestroCiespalList;
	
	private Date fechaNacimiento;
	
	private NoticiaEspejoDTO noticia;
	private List<NoticiaEspejoDTO> noticiaList;

	private ObraEspejoDTO obra;
	private List<ObraEspejoDTO> obraList;

	
	public MaestroCiespalDataManager() {
		maestroCiespalDTO=new MaestroCiespalDTO();
		maestroCiespalList=new ArrayList<MaestroCiespalDTO>();
		
		noticia=new NoticiaEspejoDTO();
		noticiaList=new ArrayList<NoticiaEspejoDTO>();
		
		obra=new ObraEspejoDTO();
		obraList=new ArrayList<ObraEspejoDTO>();
	}

	public MaestroCiespalDTO getMaestroCiespalDTO() {
		return maestroCiespalDTO;
	}

	public void setMaestroCiespalDTO(MaestroCiespalDTO maestroCiespalDTO) {
		this.maestroCiespalDTO = maestroCiespalDTO;
	}

	public List<MaestroCiespalDTO> getMaestroCiespalList() {
		return maestroCiespalList;
	}

	public void setMaestroCiespalList(List<MaestroCiespalDTO> maestroCiespalList) {
		this.maestroCiespalList = maestroCiespalList;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
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
	
}
