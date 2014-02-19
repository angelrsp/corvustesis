package net.ciespal.redxxi.web.datamanager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import net.ciespal.redxxi.ejb.persistence.entities.CatalogoDTO;

@SessionScoped
@ManagedBean(name="ubicacionDataManager")
public class UbicacionDataManager implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private CatalogoDTO pais;
	private List<CatalogoDTO> paisList;
	
	private CatalogoDTO provincia;
	private List<CatalogoDTO> provinciaList;

	private CatalogoDTO ciudad;
	private List<CatalogoDTO> ciudadList;

	private byte[] imageBytePais;
	
	public UbicacionDataManager() {
	}
	
	@PostConstruct
	private void init()
	{
		pais=new CatalogoDTO();
		provincia=new CatalogoDTO();
		ciudad=new CatalogoDTO();
		
		paisList=new ArrayList<CatalogoDTO>();
		provinciaList=new ArrayList<CatalogoDTO>();
		ciudadList=new ArrayList<CatalogoDTO>();
	}

	public CatalogoDTO getPais() {
		return pais;
	}

	public void setPais(CatalogoDTO pais) {
		this.pais = pais;
	}

	public List<CatalogoDTO> getPaisList() {
		return paisList;
	}

	public void setPaisList(List<CatalogoDTO> paisList) {
		this.paisList = paisList;
	}

	public CatalogoDTO getProvincia() {
		return provincia;
	}

	public void setProvincia(CatalogoDTO provincia) {
		this.provincia = provincia;
	}

	public List<CatalogoDTO> getProvinciaList() {
		return provinciaList;
	}

	public void setProvinciaList(List<CatalogoDTO> provinciaList) {
		this.provinciaList = provinciaList;
	}

	public CatalogoDTO getCiudad() {
		return ciudad;
	}

	public void setCiudad(CatalogoDTO ciudad) {
		this.ciudad = ciudad;
	}

	public List<CatalogoDTO> getCiudadList() {
		return ciudadList;
	}

	public void setCiudadList(List<CatalogoDTO> ciudadList) {
		this.ciudadList = ciudadList;
	}

	public byte[] getImageBytePais() {
		return imageBytePais;
	}

	public void setImageBytePais(byte[] imageBytePais) {
		this.imageBytePais = imageBytePais;
	}
	
}
