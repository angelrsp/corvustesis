package ec.edu.uce.silsag.web.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ec.edu.uce.silsag.commons.util.SilsagException;
import ec.edu.uce.silsag.ejb.negocio.AdministracionService;
import ec.edu.uce.silsag.ejb.persistence.entities.ContactoDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.EmpresaDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.UsuarioDTO;
import ec.edu.uce.silsag.web.util.JsfUtil;

@ViewScoped
@ManagedBean(name = "aprobarEmpresaController")
public class AprobarEmpresaController extends SelectItemController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private AdministracionService administracionService;

	private EmpresaDTO empresa;
	private UsuarioDTO user;
	private List<EmpresaDTO> empresaList;
	private List<ContactoDTO> contactoList;

	private Object tipoEmpresa;
	private Object ubicacion;

	public AprobarEmpresaController() {

	}

	@PostConstruct
	private void init() {
		empresa = new EmpresaDTO();
		empresaList = new ArrayList<EmpresaDTO>();
		contactoList = new ArrayList<ContactoDTO>();
		user = new UsuarioDTO();	
	}

	public EmpresaDTO getEmpresa() {
		return empresa;
	}

	public void setEmpresa(EmpresaDTO empresa) {
		this.empresa = empresa;
	}

	public List<EmpresaDTO> getEmpresaList() throws SilsagException {
		this.empresaList = administracionService.obtenerEmpresas();
		return empresaList;
	}

	public void cambiarEstado(EmpresaDTO emp) {
		try {
			if (emp.getEmpActiva())
				emp.setEmpActiva(false);
			else
				emp.setEmpActiva(true);
			administracionService.cambiarEstadoEmpresa(emp);
			getEmpresaList();
			JsfUtil.addInfoMessage("Cambiado Exitosamente");
		} catch (SilsagException e) {
			JsfUtil.addErrorMessage(e.getMessage());
		} catch (Exception e) {
			JsfUtil.addErrorMessage(e.getMessage());
		}
	}

	public List<ContactoDTO> getContactoList() {
		return contactoList;
	}

	public Object getTipoEmpresa() {
		return tipoEmpresa;
	}

	public Object getUbicacion() {
		return ubicacion;
	}

	public UsuarioDTO getUser() {
		return user;
	}

	public void setUser(UsuarioDTO user) {
		this.user = user;
	}

	public void buscarEmpresa(EmpresaDTO emp) {
		try {
			empresa=emp;
			contactoList=administracionService.obtenerContactos(empresa);
			setUser(emp.getBemUsuario());
			tipoEmpresa=emp.getEmpSector();
			ubicacion=emp.getEmpUbicacion();
		} catch (Exception e) {
			JsfUtil.addErrorMessage(e.getMessage());
		}

	}
}
