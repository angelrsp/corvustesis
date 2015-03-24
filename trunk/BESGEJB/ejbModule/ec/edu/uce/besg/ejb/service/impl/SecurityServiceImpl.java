package ec.edu.uce.besg.ejb.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ec.edu.uce.besg.common.util.CorvustecException;
import ec.edu.uce.besg.common.util.UtilEncryption;
import ec.edu.uce.besg.ejb.dao.factory.FactoryDAO;
import ec.edu.uce.besg.ejb.persistence.entity.security.HistorialPasswordDTO;
import ec.edu.uce.besg.ejb.persistence.entity.security.UsuarioDTO;
import ec.edu.uce.besg.ejb.service.SecurityService;

@Stateless
public class SecurityServiceImpl implements SecurityService {

	private static final Logger logger = LoggerFactory.getLogger(ServicioEmpresaImpl.class);

	@EJB
	private FactoryDAO factoryDAO;

	
	@Override
	public UsuarioDTO loginEmpresa(UsuarioDTO usuarioDTO) throws CorvustecException
	{
		List<UsuarioDTO> userList;
		try {
			usuarioDTO.setUsuPassword(UtilEncryption.getInstancia().encriptar(usuarioDTO.getUsuPassword()));
			userList= factoryDAO.getUsuarioDAOImpl().getByAndJoinEntity(usuarioDTO);
			if(!userList.isEmpty())
				return userList.get(0);
			else
				return null;
			
		} catch (Exception e) {
			logger.info(e.toString());
			throw new CorvustecException(e);
		}
		finally{
			userList=null;
			usuarioDTO=null;
		}
	}
	
	
	@Override
	public UsuarioDTO loginCandidato(UsuarioDTO usuarioDTO) throws CorvustecException
	{
		List<UsuarioDTO> userList;
		try {
			usuarioDTO.setUsuPassword(UtilEncryption.getInstancia().encriptar(usuarioDTO.getUsuPassword()));
			userList= factoryDAO.getUsuarioDAOImpl().getByAndJoinEntity(usuarioDTO);
			if(!userList.isEmpty())
				return userList.get(0);
			else
				return null;
			
		} catch (Exception e) {
			logger.info(e.toString());
			throw new CorvustecException(e);
		}
		finally{
			userList=null;
			usuarioDTO=null;
		}
	}

	
	
	public UsuarioDTO cambiarContrasenaEmpresa(UsuarioDTO usuarioDTO) throws CorvustecException
	{
		HistorialPasswordDTO historialPasswordDTO = null;
		UsuarioDTO usuarioDTO2;
		List<HistorialPasswordDTO> historialPasswordList;
		try {
			usuarioDTO2=new UsuarioDTO();
			historialPasswordDTO=new HistorialPasswordDTO();
			
			usuarioDTO2.setUsuCodigo(usuarioDTO.getUsuCodigo());
			
			historialPasswordDTO.setHpaPassword(usuarioDTO.getUsuPassword());
			historialPasswordDTO.setSegUsuario(usuarioDTO2);
			
			historialPasswordList= factoryDAO.getHistorialPasswordDAOImpl().getByAnd(historialPasswordDTO);
			
			if(historialPasswordList.size()>0)
			{
				factoryDAO.getUsuarioDAOImpl().update(usuarioDTO);
				factoryDAO.getHistorialPasswordDAOImpl().create(historialPasswordDTO);
			}
			return usuarioDTO;
		} catch (Exception e) {
			logger.info(e.toString());
			throw new CorvustecException(e);
		}
		finally{
			historialPasswordDTO=null;
			usuarioDTO2=null;
			historialPasswordList=null;
		}
	}
	
}
