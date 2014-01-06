package ec.edu.uce.indicadores.ejb.negocio.impl;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.edu.uce.indicadores.commons.dto.util.CredencialesDTO;
import ec.edu.uce.indicadores.commons.util.IndicadoresException;
import ec.edu.uce.indicadores.ejb.negocio.LoginService;
import ec.edu.uce.indicadores.ejb.persistence.dao.FactoryDAO;
import ec.edu.uce.indicadores.ejb.persistence.entities.UsuarioDTO;

@Stateless
public class LoginServiceImpl implements LoginService{
	
	
	@EJB
	private FactoryDAO factoryDAO;
	
	@Override
	public UsuarioDTO autenticarUsuario(CredencialesDTO credencialesDTO) throws IndicadoresException{
		
		try {
			
			return factoryDAO.getUsuarioDAOImpl().buscarUsuarioLogin(credencialesDTO);
			
		} catch (IndicadoresException e) {
			throw new IndicadoresException(e);
		} catch (Exception e) {
			throw new IndicadoresException(e);
		}
		
	}


}
