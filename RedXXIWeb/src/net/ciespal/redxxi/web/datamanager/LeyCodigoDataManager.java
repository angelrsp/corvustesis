package net.ciespal.redxxi.web.datamanager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import net.ciespal.redxxi.ejb.persistence.entities.espejo.LeyDTO;
import net.ciespal.redxxi.ejb.persistence.entities.espejo.NoticiaEspejoDTO;

@ViewScoped
@ManagedBean(name="leyCodigoDataManager")
public class LeyCodigoDataManager implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private LeyDTO leyDTO;
	private List<LeyDTO> leyList;
	
	private NoticiaEspejoDTO noticia;
	private List<NoticiaEspejoDTO> noticiaList;
	
	private Object tipoDocumento;
	
	public LeyCodigoDataManager() {
		leyDTO=new LeyDTO();
		leyList=new ArrayList<LeyDTO>();
		
		noticia=new NoticiaEspejoDTO();
		noticiaList=new ArrayList<NoticiaEspejoDTO>();
	}


	public LeyDTO getLeyDTO() {
		return leyDTO;
	}


	public void setLeyDTO(LeyDTO leyDTO) {
		this.leyDTO = leyDTO;
	}


	public List<LeyDTO> getLeyList() {
		return leyList;
	}


	public void setLeyList(List<LeyDTO> leyList) {
		this.leyList = leyList;
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


	public Object getTipoDocumento() {
		return tipoDocumento;
	}


	public void setTipoDocumento(Object tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}


}
