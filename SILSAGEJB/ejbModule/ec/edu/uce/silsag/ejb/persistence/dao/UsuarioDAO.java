package ec.edu.uce.silsag.ejb.persistence.dao;

import javax.ejb.Local;

import ec.edu.uce.silsag.commons.dto.util.CredencialesDTO;
import ec.edu.uce.silsag.commons.util.SilsagException;
import ec.edu.uce.silsag.ejb.persistence.entities.UsuarioDTO;

@Local
public interface UsuarioDAO extends AbstractFacade<UsuarioDTO>{
	
	/**
	 * Buscar usuario por sus credenciales
	 * @param credencialesDTO
	 * @return
	 * @throws SilsagException
	 */
	UsuarioDTO buscarUsuarioLogin (CredencialesDTO credencialesDTO) throws SilsagException;

	UsuarioDTO buscarUsuario(CredencialesDTO credencialesDTO)
			throws SilsagException;

}
