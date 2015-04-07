package ec.edu.uce.besg.web.datamanager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ec.edu.uce.besg.ejb.persistence.entity.ContactoDTO;
import ec.edu.uce.besg.ejb.persistence.entity.ContactoListDTO;
import ec.edu.uce.besg.ejb.persistence.entity.EmpresaDTO;
import ec.edu.uce.besg.ejb.persistence.entity.security.CatalogoDTO;

@ViewScoped
@ManagedBean(name = "contactoDataManager")
public class ContactoDataManager implements Serializable {
private static final long serialVersionUID = 1L;
	
	private ContactoDTO contactoInsertar;
	private EmpresaDTO empresa;
	private List<ContactoListDTO> contactoDTOs;
	
	private int cargo;
	
	private List<CatalogoDTO> cargoCatalogoList;

	public ContactoDataManager() {
		contactoInsertar=new ContactoDTO();
		contactoDTOs=new ArrayList<ContactoListDTO>();
		empresa=new EmpresaDTO();
		cargoCatalogoList=new ArrayList<CatalogoDTO>();
	}

	public ContactoDTO getContactoInsertar() {
		return contactoInsertar;
	}

	public void setContactoInsertar(ContactoDTO contactoInsertar) {
		this.contactoInsertar = contactoInsertar;
	}

	public EmpresaDTO getEmpresa() {
		return empresa;
	}

	public void setEmpresa(EmpresaDTO empresa) {
		this.empresa = empresa;
	}

	public List<ContactoListDTO> getContactoDTOs() {
		return contactoDTOs;
	}

	public void setContactoDTOs(List<ContactoListDTO> contactoDTOs) {
		this.contactoDTOs = contactoDTOs;
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

}
