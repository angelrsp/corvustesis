package ec.edu.uce.silsae.web.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ec.edu.uce.silsae.commons.util.SilsaeException;
import ec.edu.uce.silsae.ejb.negocio.EmpresaService;
import ec.edu.uce.silsae.ejb.persistence.entities.EmpresaDTO;
import ec.edu.uce.silsae.ejb.persistence.entities.PostulacionListDTO;
import ec.edu.uce.silsae.ejb.persistence.entities.UsuarioDTO;
import ec.edu.uce.silsae.web.util.JsfUtil;

@ViewScoped
@ManagedBean(name = "verPostulacionController")
public class VerPostulacionController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private EmpresaService empresaService;

	private EmpresaDTO empresa;
	private UsuarioDTO user;
	
	private List<PostulacionListDTO> postulacionList;	
	
	public VerPostulacionController() {
		
	}
	
	@PostConstruct
	private void init()
	{
		user=new UsuarioDTO();
		empresa=new EmpresaDTO();
		user=(UsuarioDTO)JsfUtil.getObject("UsuarioDTO");
		empresa=user.getBemEmpresas().get(0);
		postulacionList= new ArrayList<PostulacionListDTO>();
	}

	public List<PostulacionListDTO> getPostulacionList() throws SilsaeException {
		this.postulacionList=empresaService.obtenerPostulacion(empresa);
		return postulacionList;
	}
	
	
	
}
