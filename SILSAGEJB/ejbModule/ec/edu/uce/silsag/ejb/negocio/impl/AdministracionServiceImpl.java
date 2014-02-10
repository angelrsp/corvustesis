package ec.edu.uce.silsag.ejb.negocio.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ec.edu.uce.silsag.commons.dto.util.CredencialesDTO;
import ec.edu.uce.silsag.commons.dto.util.ResultadoReportDTO;
import ec.edu.uce.silsag.commons.util.MailUtil;
import ec.edu.uce.silsag.commons.util.SilsagException;
import ec.edu.uce.silsag.ejb.negocio.AdministracionService;
import ec.edu.uce.silsag.ejb.persistence.dao.FactoryDAO;
import ec.edu.uce.silsag.ejb.persistence.entities.CandidatoEstudioDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.CatalogoDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.ContactoDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.EmpresaDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.ParametroDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.PreguntaDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.UsuarioDTO;

@Stateless
public class AdministracionServiceImpl implements AdministracionService{
	
	
	private static final Logger log = LoggerFactory.getLogger(AdministracionServiceImpl.class);
	
	@EJB
	private FactoryDAO factoryDAO;

	@Override
	public List<CatalogoDTO> getCatalogo(CatalogoDTO catalogo) throws SilsagException
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
			throw new SilsagException("Error al obtener catalogo");
		}
	}

	
	@Override
	public List<EmpresaDTO> obtenerEmpresas() throws SilsagException
	{
		log.info("obtenerEmpresas");
		try{
			return factoryDAO.getEmpresaDAOImpl().getAll();
		}
		catch(Exception e)
		{
			log.info("Error al obtenerEmpresas" +e.toString());
			throw new SilsagException("Error al obtenerEmpresas");
		}
	}
	
	@Override
	public List<CandidatoEstudioDTO> obtenerCandidatos() throws SilsagException
	{
		log.info("obtenerCandidatos");
		try{
			return factoryDAO.getCandidatoDAOImpl().getCandidatoEstudio();
		}
		catch(Exception e)
		{
			log.info("Error al obtenerCandidatos" +e.toString());
			throw new SilsagException("Error al obtenerCandidatos");
		}
	}

	@Override
	public List<ContactoDTO> obtenerContactos(EmpresaDTO empresa) throws SilsagException
	{
		log.info("obtenerEmpresas");
		try{
			return factoryDAO.getContactoDAOImpl().getAll(empresa);
		}
		catch(Exception e)
		{
			log.info("Error al obtener obtenerContactos" +e.toString());
			throw new SilsagException("Error al obtener obtenerContactos");
		}
	}
	
	@Override
	public void cambiarEstadoEmpresa(EmpresaDTO empresa) throws SilsagException
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
			throw new SilsagException("Error al obtener obtenerContactos");
		}
	}

	
	@Override
	public void actualizarClave(UsuarioDTO user) throws SilsagException
	{
		log.info("actualizarClave");
		try{
			CredencialesDTO credencialesDTO=new CredencialesDTO();
			credencialesDTO.setPassword(user.getUsuPassword());
			credencialesDTO.setUsername(user.getUsuLogin());
			if(!user.getNpUsuPassword().equals(user.getNpUsuPassword2())){
				throw new SilsagException("Las contraseÃ±as no coinciden");
			}
			else if(user.getUsuPassword().equals(user.getNpUsuPassword())){
				throw new SilsagException("La contraseÃ±a anterior no puede ser igual a la actual");
			}
			else if(factoryDAO.getUsuarioDAOImpl().buscarUsuarioLogin(credencialesDTO)!=null){
				user.setUsuPassword(user.getNpUsuPassword());
				factoryDAO.getUsuarioDAOImpl().edit(user);	
			}
			else{
				throw new SilsagException("Contraseña actual incorrecta");
			}
			
		}catch(Exception e){
			log.info("Error al actualizarClave " +e.toString());
			throw new SilsagException(e.getMessage());
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
	
	@Override
	public ParametroDTO obtenerParametro(Object id) throws SilsagException
	{
		log.info("obtenerParametro");
		try{
			return factoryDAO.getParametroDAOImpl().find(id);
		}
		catch(Exception e)
		{
			log.info("Error al obtenerParametro" +e.toString());
			throw new SilsagException("Error al obtenerParametro");
		}
	}
	
	@Override
	public List<ResultadoReportDTO> obtenerResultadoPorPregunta(PreguntaDTO pregunta) throws SilsagException
	{
		log.info("obtenerParametro");
		try{
			return factoryDAO.getResultadoDAOImpl().getAllByPregunta(pregunta);
		}
		catch(Exception e)
		{
			log.info("Error al obtenerParametro" +e.toString());
			throw new SilsagException("Error al obtenerParametro");
		}
	}

}
