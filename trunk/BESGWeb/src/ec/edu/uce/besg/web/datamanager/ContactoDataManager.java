package ec.edu.uce.besg.web.datamanager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ec.edu.uce.besg.ejb.persistence.entity.ContactoDTO;
import ec.edu.uce.besg.ejb.persistence.entity.EmpresaDTO;
import ec.edu.uce.besg.ejb.persistence.entity.security.CatalogoDTO;
import ec.edu.uce.besg.ejb.persistence.entity.view.ContactoViewDTO;

@ViewScoped
@ManagedBean(name = "contactoDataManager")
public class ContactoDataManager implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	private ContactoDTO contactoDTO;
	private EmpresaDTO empresaDTO;
	private List<ContactoViewDTO> contactoList;
	
	private int cargo;
	
	private List<CatalogoDTO> cargoCatalogoList;

	public ContactoDataManager() {
		contactoDTO=new ContactoDTO();
		contactoList=new ArrayList<ContactoViewDTO>();
		empresaDTO=new EmpresaDTO();
		cargoCatalogoList=new ArrayList<CatalogoDTO>();
	}


	public int getCargo() {
		return cargo;
	}

	public void setCargo(int cargo) {
		this.cargo = cargo;
	}

	public List<CatalogoDTO> getCargoCatalogoList() {
		return cargoCatalogoList;
	}

	public void setCargoCatalogoList(List<CatalogoDTO> cargoCatalogoList) {
		this.cargoCatalogoList = cargoCatalogoList;
	}

	public EmpresaDTO getEmpresaDTO() {
		return empresaDTO;
	}

	public void setEmpresaDTO(EmpresaDTO empresaDTO) {
		this.empresaDTO = empresaDTO;
	}


	public ContactoDTO getContactoDTO() {
		return contactoDTO;
	}


	public void setContactoDTO(ContactoDTO contactoDTO) {
		this.contactoDTO = contactoDTO;
	}


	public List<ContactoViewDTO> getContactoList() {
		return contactoList;
	}


	public void setContactoList(List<ContactoViewDTO> contactoList) {
		this.contactoList = contactoList;
	}

}
