package ec.edu.uce.besg.ejb.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ec.edu.uce.besg.common.util.CorvustecException;
import ec.edu.uce.besg.common.util.EncryptionUtility;
import ec.edu.uce.besg.common.util.dto.PasswordDTO;
import ec.edu.uce.besg.ejb.dao.factory.FactoryDAO;
import ec.edu.uce.besg.ejb.persistence.entity.security.HistorialPasswordDTO;
import ec.edu.uce.besg.ejb.persistence.entity.security.UsuarioDTO;
import ec.edu.uce.besg.ejb.service.SecurityService;

@Stateless
public class SecurityServiceImpl implements SecurityService {

	private static final Logger logger = LoggerFactory.getLogger(EmpresaServiceImpl.class);

	@EJB
	private FactoryDAO factoryDAO;

	
	@Override
	public UsuarioDTO authenticateEmpresa(UsuarioDTO usuarioDTO) throws CorvustecException
	{
		List<UsuarioDTO> userList;
		try {
			usuarioDTO.setUsuPassword(EncryptionUtility.getInstance().encriptar(usuarioDTO.getUsuPassword()));
			userList= factoryDAO.getUsuarioDAOImpl().getByAndJoinEntity(usuarioDTO);
			if(!userList.isEmpty())
				return userList.get(0);
			else
				throw new CorvustecException("Usuario o contraseña incorrectos");
			
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
	public UsuarioDTO authenticateCandidato(UsuarioDTO usuarioDTO) throws CorvustecException
	{
		List<UsuarioDTO> usuarioList;
		try {
			usuarioDTO.setUsuPassword(EncryptionUtility.getInstance().encriptar(usuarioDTO.getUsuPassword()));
			usuarioList=factoryDAO.getUsuarioDAOImpl().getByAndJoinCandidato(usuarioDTO);
			if(usuarioList.size()==1)
				return usuarioList.get(0);
			else
				throw new CorvustecException("Los datos ingresados son incorrectos");
		} catch (Exception e) {
			throw new CorvustecException(e);
		}
		finally{
			usuarioDTO=null;	
		}
	}

	
	@Override
	public UsuarioDTO authenticateUser(UsuarioDTO usuarioDTO) throws CorvustecException
	{
		List<UsuarioDTO> usuarioList;
		try {
			usuarioDTO.setUsuPassword(EncryptionUtility.getInstance().encriptar(usuarioDTO.getUsuPassword()));
			usuarioList=factoryDAO.getUsuarioDAOImpl().getByAnd(usuarioDTO);
			if(usuarioList.size()==1)
				return usuarioList.get(0);
			else
				throw new CorvustecException("Los datos ingresados son incorrectos");
		} catch (Exception e) {
			throw new CorvustecException(e);
		}
		finally{
			usuarioDTO=null;	
		}
	}

	
	@Override
	public void changePassword(PasswordDTO passwordDTO) throws CorvustecException
	{
		try {
			if(!EncryptionUtility.getInstance().encriptar(passwordDTO.getActualPassword()).equals(passwordDTO.getUsuarioDTO().getUsuPassword()))
			{
				throw new CorvustecException("La constraseña ingresada con coincide con la cotraseña actual");
			}
			else
			{
				passwordDTO.getUsuarioDTO().setUsuPassword(EncryptionUtility.getInstance().encriptar(passwordDTO.getNuevoPassword()));
				factoryDAO.getUsuarioDAOImpl().update(passwordDTO.getUsuarioDTO());	
			}
		} catch (Exception e) {
			throw new CorvustecException(e);
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
	
	@Override
	public void recoverPassword(UsuarioDTO usuarioDTO) throws CorvustecException
	{
//		List<UsuarioDTO> usuarioList;
//		UsuarioDTO usuarioDTO2;
		try {
//			usuarioList=factoryDAO.getUsuarioDAOImpl().getByAnd(usuarioDTO);
//			if(!usuarioList.isEmpty())
//			{
//				usuarioDTO=usuarioList.get(0);
//				usuarioDTO.setUsuPassword(RandomUtility.getInstance().getRandomString2());
//				
//				usuarioDTO2=(UsuarioDTO)BeanUtils.cloneBean(usuarioDTO);
//				
//				mailService.sendRecovery(usuarioDTO2);
//				
//				usuarioDTO.setUsuPassword(EncryptionUtility.getInstance().encriptar(usuarioDTO.getUsuPassword()));
//				usuarioDTO.setUsuTemporalPass(true);
//				
//				factoryDAO.getUsuarioDAOImpl().update(usuarioDTO);	
//			}
//			else
//				throw new Exception("Identificacion no encontrada");
			
		} catch (Exception e) {
			logger.info(e.toString());
			throw new CorvustecException(e);
		}		
	}
	
}
