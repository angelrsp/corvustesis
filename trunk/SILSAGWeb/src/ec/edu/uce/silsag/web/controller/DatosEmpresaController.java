package ec.edu.uce.silsag.web.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ec.edu.uce.silsag.commons.util.SilsagException;
import ec.edu.uce.silsag.ejb.negocio.EmpresaService;
import ec.edu.uce.silsag.ejb.persistence.entities.ContactoDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.EmpresaDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.UsuarioDTO;
import ec.edu.uce.silsag.web.util.JsfUtil;

@ViewScoped
@ManagedBean(name = "datosEmpresaController")
public class DatosEmpresaController extends SelectItemController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private EmpresaService empresaService;
	
	private EmpresaDTO empresa;
	private UsuarioDTO user;
	private ContactoDTO contacto;
	
	private Object tipoEmpresa;
	private Object ubicacion;


	private List<ContactoDTO> contactos;
	
	public DatosEmpresaController() {

	}
	
	@PostConstruct
	private void init() {
		user=new UsuarioDTO();
		empresa=new EmpresaDTO();
		contacto=new ContactoDTO();
		user=(UsuarioDTO)JsfUtil.getObject("UsuarioDTO");
		empresa=user.getBemEmpresas().get(0);
		tipoEmpresa=empresa.getEmpSector();
		ubicacion=empresa.getEmpUbicacion();
		contactos=new ArrayList<ContactoDTO>();
	}

	public Object getTipoEmpresa() {
		return tipoEmpresa;
	}

	public void setTipoEmpresa(Object tipoEmpresa) {
		this.tipoEmpresa = tipoEmpresa;
	}

	public Object getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(Object ubicacion) {
		this.ubicacion = ubicacion;
	}

	public EmpresaDTO getEmpresa() {
		return empresa;
	}

	public void setEmpresa(EmpresaDTO empresa) {
		this.empresa = empresa;
	}

	public UsuarioDTO getUser() {
		return user;
	}

	public void setUser(UsuarioDTO user) {
		this.user = user;
	}

	public ContactoDTO getContacto() {
		return contacto;
	}

	public void setContacto(ContactoDTO contacto) {
		this.contacto = contacto;
	}

	public List<ContactoDTO> getContactos() throws SilsagException {
		this.contactos=empresaService.obtenerContactos(getEmpresa());
		return contactos;
	}

	
	public void agregarContactos()
	{
		try {
			contacto.setBemEmpresa(empresa);
			empresaService.agregarContacto(getContacto());
			getContactos();
			contacto=new ContactoDTO();
		} catch (SilsagException e) {
			JsfUtil.addErrorMessage(e.getMessage());
		}
		catch (Exception e) {
			JsfUtil.addErrorMessage(e.getMessage());
		}
	}
	
}
