package ec.edu.uce.indicadores.ejb.persistence.dao;

import ec.edu.uce.indicadores.commons.dto.util.CredencialesDTO;
import ec.edu.uce.indicadores.commons.util.IndicadoresException;
import ec.edu.uce.indicadores.ejb.persistence.entities.UsuarioDTO;

public interface UsuarioDAO extends AbstractFacade<UsuarioDTO>{

	UsuarioDTO buscarUsuarioLogin(CredencialesDTO credencialesDTO)
			throws IndicadoresException;


}
