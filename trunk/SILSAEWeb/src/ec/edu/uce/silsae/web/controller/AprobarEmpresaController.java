package ec.edu.uce.silsae.web.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ec.edu.uce.silsae.commons.util.SilsaeException;
import ec.edu.uce.silsae.ejb.negocio.AdministracionService;
import ec.edu.uce.silsae.ejb.persistence.entities.EmpresaDTO;
import ec.edu.uce.silsae.web.util.JsfUtil;

@ViewScoped
@ManagedBean (name = "aprobarEmpresaController")
public class AprobarEmpresaController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private AdministracionService administracionService;
	
	private EmpresaDTO empresa;
	private List<EmpresaDTO> empresaList;
	
	public AprobarEmpresaController()
	{
		
	}
	
	@PostConstruct
	private void init()
	{
		empresa=new EmpresaDTO();
		empresaList=new ArrayList<EmpresaDTO>();
	}

	public EmpresaDTO getEmpresa() {
		return empresa;
	}

	public void setEmpresa(EmpresaDTO empresa) {
		this.empresa = empresa;
	}

	public List<EmpresaDTO> getEmpresaList() throws SilsaeException {
		this.empresaList=administracionService.obtenerEmpresas();
		return empresaList;
	}

	public void cambiarEstado(EmpresaDTO emp)
	{
		try {
			if(emp.getEmpActiva())
				emp.setEmpActiva(false);
			else
				emp.setEmpActiva(true);
			administracionService.cambiarEstadoEmpresa(emp);
			getEmpresaList();
			JsfUtil.addInfoMessage("Cambiado Exitosamente");
		} catch (SilsaeException e) {
			JsfUtil.addErrorMessage(e.getMessage());
		}
		catch (Exception e) {
			JsfUtil.addErrorMessage(e.getMessage());
		}
	}
}
