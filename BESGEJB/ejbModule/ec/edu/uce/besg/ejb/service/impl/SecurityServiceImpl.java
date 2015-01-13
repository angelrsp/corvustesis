package ec.edu.uce.besg.ejb.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.edu.uce.besg.common.util.CorvustecException;
import ec.edu.uce.besg.common.util.UtilEncryption;
import ec.edu.uce.besg.ejb.dao.factory.FactoryDAO;
import ec.edu.uce.besg.ejb.persistence.entity.security.UsuarioDTO;
import ec.edu.uce.besg.ejb.service.SecurityService;

@Stateless
public class SecurityServiceImpl implements SecurityService {

	
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
			{
				return userList.get(0);
			}
			else
				return null;
			
		} catch (Exception e) {
			throw new CorvustecException(e);
		}
		finally{
			userList=null;
			usuarioDTO=null;
		}
	}
	
}
