package net.ciespal.redxxi.web.datamanager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import net.ciespal.redxxi.ejb.persistence.entities.argos.ContactoArgosDTO;
import net.ciespal.redxxi.ejb.persistence.entities.argos.ContactoArgosListDTO;
import net.ciespal.redxxi.ejb.persistence.entities.argos.VeeduriaDTO;

@ViewScoped
@ManagedBean(name="veeduriaDataManager")
public class VeeduriaDataManager implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private VeeduriaDTO veeduria;
	private List<VeeduriaDTO> veeduriaList;
	
	private ContactoArgosDTO contacto;
	private List<ContactoArgosListDTO> contactoList;

	private Object tipoContacto;
	
	
	public VeeduriaDataManager() {
		veeduria=new VeeduriaDTO();
		veeduriaList=new ArrayList<VeeduriaDTO>();
		
		contacto=new ContactoArgosDTO();
		contactoList=new ArrayList<ContactoArgosListDTO>();
	}

	public VeeduriaDTO getVeeduria() {
		return veeduria;
	}

	public void setVeeduria(VeeduriaDTO veeduria) {
		this.veeduria = veeduria;
	}

	public List<VeeduriaDTO> getVeeduriaList() {
		return veeduriaList;
	}

	public void setVeeduriaList(List<VeeduriaDTO> veeduriaList) {
		this.veeduriaList = veeduriaList;
	}

	public ContactoArgosDTO getContacto() {
		return contacto;
	}

	public void setContacto(ContactoArgosDTO contacto) {
		this.contacto = contacto;
	}

	public List<ContactoArgosListDTO> getContactoList() {
		return contactoList;
	}

	public void setContactoList(List<ContactoArgosListDTO> contactoList) {
		this.contactoList = contactoList;
	}

	public Object getTipoContacto() {
		return tipoContacto;
	}

	public void setTipoContacto(Object tipoContacto) {
		this.tipoContacto = tipoContacto;
	}
}
