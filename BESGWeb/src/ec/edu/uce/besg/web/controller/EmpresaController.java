package ec.edu.uce.besg.web.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.apache.commons.collections.CollectionUtils;
import org.primefaces.context.RequestContext;

import ec.edu.uce.besg.ejb.entity.EmpresaDTO;
import ec.edu.uce.besg.ejb.persistence.entity.security.CatalogoDTO;
import ec.edu.uce.besg.ejb.service.ServicioEmpresa;
import ec.edu.uce.besg.ejb.util.SeguridadesException;
import ec.edu.uce.besg.ejb.vo.EmpresaVO;
import ec.edu.uce.besg.web.datamanager.EmpresaDataManager;
import ec.edu.uce.besg.web.util.JsfUtil;

@ViewScoped
@ManagedBean(name = "empresaController")
public class EmpresaController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ManagedProperty(value="#{empresaDataManager}")
	private EmpresaDataManager empresaDataManager;

	
	public EmpresaDataManager getEmpresaDataManager() {
		return empresaDataManager;
	}

	public void setEmpresaDataManager(EmpresaDataManager empresaDataManager) {
		this.empresaDataManager = empresaDataManager;
	}

	@EJB
	private ServicioEmpresa servicioEmpresa;

	public EmpresaController() {
	
	}
	
	@PostConstruct
	private void init()
	{
		buscarSector();
		buscarPais();
		readEmpresa();
	}
	
	public void registroEmpresa() {
		//log.info("Registrando Empresa");
		EmpresaVO empresa;
		try {
			empresa=new EmpresaVO();
			/*if(!getEmpresaDataManager().getUsuarioDTO().getUsuPassword().equals(empresaDataManager.getUsuarioDTO().get))
			{
				JsfUtil.addErrorMessage("Las contraseÃ±as no coinciden");
				return;
			}
			*/
			//empresa.getEmpresaDTO().setEmpUsuario(empresaDataManager.getUsuarioDTO().getUsuCodigo());
			empresa.setEmpresaDTO(empresaDataManager.getEmpresaInsertar());
			empresa.getEmpresaDTO().setEmpSector(empresaDataManager.getCodigoSector());
			empresa.getEmpresaDTO().setEmpUbicacion(empresaDataManager.getCodigoCiudad());
			
			servicioEmpresa.registrarActualizarEmpresa(empresa);
			RequestContext.getCurrentInstance().execute("mensajeDialog.show()");
			JsfUtil.addInfoMessage("Su registro esta en proceso de aprobación. Recibirá una notificación de autorización al correo electrónico de registro");
			empresaDataManager.setEmpresaInsertar(new EmpresaDTO());
			empresaDataManager.setCodigoCiudad(0);
			empresaDataManager.setCodigoPais(0);
			empresaDataManager.setCodigoProvincia(0);
		} catch (SecurityException e) {
			JsfUtil.addErrorMessage("Error " + e.toString());
		} catch (Exception e) {
			//log.info("Error Registrando Empresa"+e.toString());
			JsfUtil.addErrorMessage("Error " + e.toString());
		}
	}
	
	/*public void redireccionar() {
		try {
			JsfUtil.redirect("bienvenido.jsf");
		} catch (IOException e) {
			JsfUtil.addErrorMessage("Error " + e.toString());
		}
	}
	*/
	
		
	/*public void actualizar()
	{
		try {
			empresaDataManager.getEmpresaInsertar().setEmpUsuario(empresaDataManager.getUsuarioDTO().getUsuCodigo());
			servicioEmpresa.actualizarEmpresa(empresa)
			getEmpresa().setBemUsuario(getUser());
			empresaService.actualizarEmpresa(getEmpresa());
			JsfUtil.addInfoMessage("Empresa Actualizada Exitosamante");
		} catch (SeguridadesException e) {
			JsfUtil.addErrorMessage(e.getMessage());
		}
	}*/
	
	public void buscarSector() {
		List<CatalogoDTO> listaCatalogo = null;
		try {
			CatalogoDTO cat = new CatalogoDTO();
			cat.setCatCodigo(1);
			listaCatalogo = this.servicioEmpresa.buscarCatalogo(cat);
			if (CollectionUtils.isEmpty(listaCatalogo) && listaCatalogo.size() == 0) {
				JsfUtil.addWarningMessage("Busqueda vacia");
			} else {
				this.empresaDataManager.setSecCatalogoDTOs(listaCatalogo);
			}
		} catch (SeguridadesException e) {
			//slf4jLogger.info("Error al buscarCatalogo {} ", e);
			JsfUtil.addErrorMessage(e.getMessage());
		}
	}
	
	public void buscarPais() {
		//slf4jLogger.info("buscarCatalogo");
		List<CatalogoDTO> listaCatalogo = null;
		try {
			CatalogoDTO cat = new CatalogoDTO();
			cat.setCatCodigo(4);
			listaCatalogo = this.servicioEmpresa.buscarCatalogo(cat);
			if (CollectionUtils.isEmpty(listaCatalogo)
					&& listaCatalogo.size() == 0) {
				JsfUtil.addWarningMessage("Busqueda vacia");
			} else {
				this.empresaDataManager
						.setPaiCatalogoDTOs(listaCatalogo);
			}
		} catch (SeguridadesException e) {
			JsfUtil.addWarningMessage(e.getMessage());
		}

	}

	public void buscarProvincia() {
		//slf4jLogger.info("buscarCanton");
		List<CatalogoDTO> listaCatalogo = null;
		try {
			CatalogoDTO cat = new CatalogoDTO();
			cat.setCatCodigo(empresaDataManager.getCodigoPais());
			listaCatalogo = this.servicioEmpresa.buscarCatalogo(cat);
			if (CollectionUtils.isEmpty(listaCatalogo)
					&& listaCatalogo.size() == 0) {
				JsfUtil.addWarningMessage("Busqueda vacia");
			} else {
				this.empresaDataManager
						.setProCatalogoDTOs(listaCatalogo);
			}
		} catch (SeguridadesException e) {
			JsfUtil.addWarningMessage(e.getMessage());
		}
	}

	public void buscarCiudad() {
		//slf4jLogger.info("buscarParroquia");
		List<CatalogoDTO> listaCatalogo = null;
		try {
			CatalogoDTO cat = new CatalogoDTO();
			cat.setCatCodigo(empresaDataManager.getCodigoProvincia());
			listaCatalogo = this.servicioEmpresa.buscarCatalogo(cat);
			if (CollectionUtils.isEmpty(listaCatalogo)
					&& listaCatalogo.size() == 0) {
				JsfUtil.addWarningMessage("Busqueda vacia");
			} else {
				this.empresaDataManager
				.setCiuCatalogoDTOs(listaCatalogo);
			}
		} catch (SeguridadesException e) {
			//slf4jLogger.info("Error al buscarCiudad {} ", e);
			JsfUtil.addWarningMessage(e.getMessage());
		}
	}
	
	private void readEmpresa()
	{
		List<EmpresaDTO> listaEmpresas=null;
		CatalogoDTO catalogoDTO;
		try {
			//ojo se manda de parametro new empresadto pero deberia mandar la empresa logeada
			listaEmpresas = this.servicioEmpresa.obtenerEmpresa(new EmpresaDTO());
			if (CollectionUtils.isEmpty(listaEmpresas) && listaEmpresas.size()==0) {
				JsfUtil.addInfoMessage("Busqueda vacia");
			} else {
				this.empresaDataManager.setEmpresaInsertar(listaEmpresas.get(0));
				catalogoDTO=servicioEmpresa.obtenerCatalogoId(this.empresaDataManager.getEmpresaInsertar().getEmpUbicacion());
				empresaDataManager.setCodigoPais(catalogoDTO.getSegCatalogo().getSegCatalogo().getCatCodigo());
				buscarProvincia();
				empresaDataManager.setCodigoProvincia(catalogoDTO.getSegCatalogo().getCatCodigo());
				buscarCiudad();
				empresaDataManager.setCodigoCiudad(catalogoDTO.getCatCodigo());
				this.empresaDataManager.setCodigoSector(listaEmpresas.get(0).getEmpSector());
			}
		} catch (SecurityException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}

	

}
