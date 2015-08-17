package ec.edu.uce.notas.ejb.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.corvustec.notas.common.util.CorvustecException;
import com.corvustec.notas.common.util.EncryptionUtility;
import com.corvustec.notas.common.util.dto.CredencialDTO;
import com.corvustec.notas.common.util.dto.PasswordDTO;

import ec.edu.uce.notas.ejb.dao.factory.FactoryDAO;
import ec.edu.uce.notas.ejb.persistence.entity.HistoryPasswordDTO;
import ec.edu.uce.notas.ejb.persistence.entity.UsuarioDTO;
import ec.edu.uce.notas.ejb.service.SecurityService;

@Stateless
public class SecurityServiceImpl implements SecurityService {

	private static final Logger slf4jLogger = LoggerFactory.getLogger(SecurityServiceImpl.class);

	@EJB
	private FactoryDAO factoryDAO;

	
	@Override
	public UsuarioDTO authenticateUser(CredencialDTO credencialDTO) throws CorvustecException
	{
		List<UsuarioDTO> usuarioList;
		UsuarioDTO usuarioDTO;
		try {
			usuarioDTO=new UsuarioDTO();
			usuarioDTO.setUsuPassword(EncryptionUtility.getInstance().encriptar(credencialDTO.getPass()));
			usuarioDTO.setUsuIdentificacion(credencialDTO.getUser());
			usuarioList=factoryDAO.getUsuarioDAOImpl().getByAnd(usuarioDTO);
			if(usuarioList.size()==1)
				return usuarioList.get(0);
			else
				throw new CorvustecException("Los datos ingresados son incorrectos");
		} catch (Exception e) {
			slf4jLogger.info(e.toString());
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
				throw new CorvustecException("La constrase�a ingresada con coincide con la cotrase�a actual");
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
		HistoryPasswordDTO historialPasswordDTO = null;
		UsuarioDTO usuarioDTO2;
		List<HistoryPasswordDTO> historialPasswordList;
		try {
			usuarioDTO2=new UsuarioDTO();
			historialPasswordDTO=new HistoryPasswordDTO();
			
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
			slf4jLogger.info(e.toString());
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
			slf4jLogger.info(e.toString());
			throw new CorvustecException(e);
		}		
	}
	
}
