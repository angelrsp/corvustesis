 package ec.edu.uce.silsae.ejb.negocio.impl;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.edu.uce.silsae.commons.dto.util.CredencialesDTO;
import ec.edu.uce.silsae.commons.util.SilsaeException;
import ec.edu.uce.silsae.ejb.negocio.LoginService;
import ec.edu.uce.silsae.ejb.persistence.dao.FactoryDAO;
import ec.edu.uce.silsae.ejb.persistence.entities.UsuarioDTO;

@Stateless
public class LoginServiceImpl implements LoginService{
	
	@EJB
	private FactoryDAO factoryDAO;
	
	@Override
	public UsuarioDTO autenticarUsuario(CredencialesDTO credencialesDTO) throws SilsaeException{
		
		try {
			
			return factoryDAO.getUsuarioDAOImpl().buscarUsuarioLogin(credencialesDTO);
			
		} catch (SilsaeException e) {
			throw new SilsaeException(e);
		} catch (Exception e) {
			throw new SilsaeException(e);
		}
		
	}
	
}
