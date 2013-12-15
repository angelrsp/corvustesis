package ec.edu.uce.silsae.web.controller;

import java.io.IOException;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ec.edu.uce.silsae.commons.util.SilsaeException;
import ec.edu.uce.silsae.ejb.negocio.EmpresaService;
import ec.edu.uce.silsae.ejb.persistence.entities.EmpresaDTO;
import ec.edu.uce.silsae.ejb.persistence.entities.UsuarioDTO;
import ec.edu.uce.silsae.web.util.JsfUtil;

@ViewScoped
@ManagedBean(name = "registroEmpresaController")
public class RegistroEmpresaController extends SelectItemController implements
		Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final Logger log = LoggerFactory
			.getLogger(RegistroCandidatoController.class);

	private EmpresaDTO empresa;
	private UsuarioDTO usuarioRegistro;
	
	private Object tipoEmpresa;
	private Object ubicacion;

	@EJB
	private EmpresaService empresaService;

	@PostConstruct
	public void init() {
		this.usuarioRegistro = new UsuarioDTO();
		this.empresa=new EmpresaDTO();
	}

	public UsuarioDTO getUsuarioRegistro() {
		return usuarioRegistro;
	}

	public void setUsuarioRegistro(UsuarioDTO usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}

	public EmpresaDTO getEmpresa() {
		return empresa;
	}

	public void setEmpresa(EmpresaDTO empresa) {
		this.empresa = empresa;
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

	public void registroEmpresa() {
		log.info("Registrando Empresa");
		try {
			empresa.setBemUsuario(getUsuarioRegistro());
			empresa.setEmpUbicacion(Integer.valueOf(ubicacion.toString()));
			empresa.setEmpSector(Integer.valueOf(tipoEmpresa.toString()));
			empresaService.registrarEmpresa(empresa);
			JsfUtil.redirect("inicioEmpresa.jsf");
		} catch (SilsaeException e) {
			JsfUtil.addErrorMessage("Error " + e.toString());
		} catch (IOException e) {
			log.info("Error Registrando Empresa"+e.toString());
			JsfUtil.addErrorMessage("Error " + e.toString());
		}

	}
}
