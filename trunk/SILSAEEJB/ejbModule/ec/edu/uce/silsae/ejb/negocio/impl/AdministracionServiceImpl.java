package ec.edu.uce.silsae.ejb.negocio.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ec.edu.uce.silsae.commons.dto.util.CredencialesDTO;
import ec.edu.uce.silsae.commons.util.MailUtil;
import ec.edu.uce.silsae.commons.util.SilsaeException;
import ec.edu.uce.silsae.ejb.negocio.AdministracionService;
import ec.edu.uce.silsae.ejb.persistence.dao.FactoryDAO;
import ec.edu.uce.silsae.ejb.persistence.entities.CandidatoDTO;
import ec.edu.uce.silsae.ejb.persistence.entities.CatalogoDTO;
import ec.edu.uce.silsae.ejb.persistence.entities.ContactoDTO;
import ec.edu.uce.silsae.ejb.persistence.entities.EmpresaDTO;
import ec.edu.uce.silsae.ejb.persistence.entities.UsuarioDTO;

@Stateless
public class AdministracionServiceImpl implements AdministracionService{
	
	
	private static final Logger log = LoggerFactory.getLogger(CandidatosServiceImpl.class);
	
	@EJB
	private FactoryDAO factoryDAO;

	@Override
	public List<CatalogoDTO> getCatalogo(CatalogoDTO catalogo) throws SilsaeException
	{
		log.info("obtener catalogo");
		log.info("Valor codigo catalogo "+catalogo.getCatCodigo());
		try{
			factoryDAO.getCatalogoImpl().getAll(catalogo);
			return factoryDAO.getCatalogoImpl().getAll(catalogo);
		}
		catch(Exception e)
		{
			log.info("Error al obtener catalogo" +e.toString());
			throw new SilsaeException("Error al obtener catalogo");
		}
	}

	
	@Override
	public List<EmpresaDTO> obtenerEmpresas() throws SilsaeException
	{
		log.info("obtenerEmpresas");
		try{
			return factoryDAO.getEmpresaDAOImpl().getAll();
		}
		catch(Exception e)
		{
			log.info("Error al obtenerEmpresas" +e.toString());
			throw new SilsaeException("Error al obtenerEmpresas");
		}
	}
	
	@Override
	public List<CandidatoDTO> obtenerCandidatos() throws SilsaeException
	{
		log.info("obtenerCandidatos");
		try{
			return factoryDAO.getCandidatoDAOImpl().getAll();
		}
		catch(Exception e)
		{
			log.info("Error al obtenerCandidatos" +e.toString());
			throw new SilsaeException("Error al obtenerCandidatos");
		}
	}

	@Override
	public List<ContactoDTO> obtenerContactos(EmpresaDTO empresa) throws SilsaeException
	{
		log.info("obtenerEmpresas");
		try{
			return factoryDAO.getContactoDAOImpl().getAll(empresa);
		}
		catch(Exception e)
		{
			log.info("Error al obtener obtenerContactos" +e.toString());
			throw new SilsaeException("Error al obtener obtenerContactos");
		}
	}
	
	@Override
	public void cambiarEstadoEmpresa(EmpresaDTO empresa) throws SilsaeException
	{
		log.info("cambiarEstadoEmpresa");
		try{
			if(empresa.getEmpActiva()){
				StringBuilder sb=new StringBuilder();
				sb.append("BIENVENIDO.<br/>");
				sb.append("La empresa registrada cumple con los requisitos.<br/>");
				sb.append("Usted ya es miembro de SILSAG.<br/>");
				sb.append("Facultad de Odontología");
				new MailUtil().send(empresa.getBemUsuario().getUsuMail(), "SILSAG: Verificación y aprobación de Empresa", sb.toString());
			}
			else{
				new MailUtil().send(empresa.getBemUsuario().getUsuMail(), "SILSAG: Verificación y aprobación de Empresa", "La empresa a sido cancelada del sistema SILSAG");
			}			
			factoryDAO.getEmpresaDAOImpl().edit(empresa);
		}
		catch(Exception e)
		{
			log.info("Error al obtener obtenerContactos" +e.toString());
			throw new SilsaeException("Error al obtener obtenerContactos");
		}
	}

	
	@Override
	public void actualizarClave(UsuarioDTO user) throws SilsaeException
	{
		log.info("actualizarClave");
		try{
			CredencialesDTO credencialesDTO=new CredencialesDTO();
			credencialesDTO.setPassword(user.getUsuPassword());
			credencialesDTO.setUsername(user.getUsuLogin());
			if(!user.getNpUsuPassword().equals(user.getNpUsuPassword2())){
				throw new SilsaeException("Las contraseñas no coinciden");
			}
			else if(user.getUsuPassword().equals(user.getNpUsuPassword())){
				throw new SilsaeException("La contraseña anterior no puede ser igual a la actual");
			}
			else if(factoryDAO.getUsuarioDAOImpl().buscarUsuarioLogin(credencialesDTO)!=null){
				user.setUsuPassword(user.getNpUsuPassword());
				factoryDAO.getUsuarioDAOImpl().edit(user);	
			}
			else{
				throw new SilsaeException("Contraseña actual incorrecta");
			}
			
		}catch(Exception e){
			log.info("Error al actualizarClave " +e.toString());
			throw new SilsaeException(e.getMessage());
		}
	}

	
//	@Override
//	public EmpresaDTO obtenerEmpresa(UsuarioDTO user) throws SilsaeException
//	{
//		log.info("obtenerEmpresa");
//		try{
//			return factoryDAO.getUsuarioDAOImpl().find(user.getUsuCodigo()).getBemEmpresas().get(0);
//		}
//		catch(Exception e)
//		{
//			log.info("Error al obtener catalogo" +e.toString());
//			throw new SilsaeException("Error al obtener catalogo");
//		}
//	}
	
	
}
