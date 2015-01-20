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

import ec.edu.uce.besg.common.util.CorvustecException;
import ec.edu.uce.besg.ejb.entity.EmpresaDTO;
import ec.edu.uce.besg.ejb.persistence.entity.security.UsuarioDTO;
import ec.edu.uce.besg.ejb.service.ServicioCatalogo;
import ec.edu.uce.besg.ejb.service.ServicioEmpresa;
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

	@EJB
	private ServicioCatalogo servicioCatalogo;
	
	public EmpresaController() {
	
	}
	
	@PostConstruct
	private void init()
	{
		readSector();
		readPais();
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
			empresa.setEmpresaDTO(empresaDataManager.getEmpresaDTO());
			empresa.getEmpresaDTO().setEmpSector(empresaDataManager.getCodigoSector());
			empresa.getEmpresaDTO().setEmpUbicacion(empresaDataManager.getCodigoCiudad());
			
			servicioEmpresa.registrarActualizarEmpresa(empresa);
			RequestContext.getCurrentInstance().execute("mensajeDialog.show()");
			JsfUtil.addInfoMessage("Su registro esta en proceso de aprobación. Recibirá una notificación de autorización al correo electrónico de registro");
			empresaDataManager.setEmpresaDTO(new EmpresaDTO());
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
	
	public void readSector() {
		try {
			this.empresaDataManager.setSectorCatalogoList(servicioCatalogo.readSector());
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.getMessage());
		}
	}
	
	public void readPais() {
		try {
			this.empresaDataManager.setPaisCatalogoList(servicioCatalogo.readPais());
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.getMessage());
		}
	}
	
	private void readEmpresa()
	{
		List<EmpresaDTO> listaEmpresas=null;
		EmpresaDTO empresaDTO;
		try {
			empresaDTO=new EmpresaDTO();
			empresaDTO.setSegUsuario((UsuarioDTO)JsfUtil.getObject("UsuarioEmpresa"));
			
			listaEmpresas = this.servicioEmpresa.obtenerEmpresa(empresaDTO);
			if (CollectionUtils.isEmpty(listaEmpresas) && listaEmpresas.size()==0) {
				JsfUtil.addInfoMessage("Busqueda vacia");
			} else {
				this.empresaDataManager.setEmpresaDTO(listaEmpresas.get(0));
//				catalogoDTO=servicioEmpresa.obtenerCatalogoId(this.empresaDataManager.getEmpresaInsertar().getEmpUbicacion());
//				empresaDataManager.setCodigoPais(catalogoDTO.getSegCatalogo().getSegCatalogo().getCatCodigo());
//				buscarProvincia();
//				empresaDataManager.setCodigoProvincia(catalogoDTO.getSegCatalogo().getCatCodigo());
//				buscarCiudad();
//				empresaDataManager.setCodigoCiudad(catalogoDTO.getCatCodigo());
//				this.empresaDataManager.setCodigoSector(listaEmpresas.get(0).getEmpSector());
			}
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}

	

}
