package ec.edu.uce.silsae.web.controller;

import java.io.IOException;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.context.RequestContext;
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
			if(!getUsuarioRegistro().getNpUsuPassword().equals(getUsuarioRegistro().getUsuPassword()))
			{
				JsfUtil.addErrorMessage("Las contraseñas no coinciden");
				return;
			}
			
			empresa.setBemUsuario(getUsuarioRegistro());
			empresa.setEmpSector(Integer.valueOf(tipoEmpresa.toString()));
			empresaService.registrarEmpresa(empresa);
			RequestContext.getCurrentInstance().execute("mensajeDialog.show()");
			//JsfUtil.addWarningMessage("Su registro esta en proceso de aprobación. Recibirá una notificación de autroización al correo electrónico de registro");
		} catch (SilsaeException e) {
			JsfUtil.addErrorMessage("Error " + e.toString());
		} catch (Exception e) {
			log.info("Error Registrando Empresa"+e.toString());
			JsfUtil.addErrorMessage("Error " + e.toString());
		}
	}
	
	public void redireccionar() {
		try {
			JsfUtil.redirect("bienvenido.jsf");
		} catch (IOException e) {
			JsfUtil.addErrorMessage("Error " + e.toString());
		}
	}
}
