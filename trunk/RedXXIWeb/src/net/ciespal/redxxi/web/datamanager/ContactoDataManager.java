package net.ciespal.redxxi.web.datamanager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import net.ciespal.redxxi.ejb.persistence.entities.ContactoDTO;
import net.ciespal.redxxi.ejb.persistence.entities.ContactoListDTO;

@SessionScoped
@ManagedBean(name="contactoDataManager")
public class ContactoDataManager implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ContactoDTO contacto;
	private Object tipoContacto;
	private List<ContactoListDTO> contactoList;
	
	public ContactoDataManager() {
		
	}
	
	@PostConstruct
	private void init()
	{
		contacto=new ContactoDTO();
		contactoList=new ArrayList<ContactoListDTO>();
	}

	public ContactoDTO getContacto() {
		return contacto;
	}

	public void setContacto(ContactoDTO contacto) {
		this.contacto = contacto;
	}

	public Object getTipoContacto() {
		return tipoContacto;
	}

	public void setTipoContacto(Object tipoContacto) {
		this.tipoContacto = tipoContacto;
	}

	public List<ContactoListDTO> getContactoList() {
		return contactoList;
	}

	public void setContactoList(List<ContactoListDTO> contactoList) {
		this.contactoList = contactoList;
	}
	
	
}
