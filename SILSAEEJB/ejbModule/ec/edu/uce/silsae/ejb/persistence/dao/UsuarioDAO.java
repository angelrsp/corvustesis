package ec.edu.uce.silsae.ejb.persistence.dao;

import javax.ejb.Local;

import ec.edu.uce.silsae.commons.dto.util.CredencialesDTO;
import ec.edu.uce.silsae.commons.util.SilsaeException;
import ec.edu.uce.silsae.ejb.persistence.entities.UsuarioDTO;

@Local
public interface UsuarioDAO extends AbstractFacade<UsuarioDTO>{
	
	/**
	 * Buscar usuario por sus credenciales
	 * @param credencialesDTO
	 * @return
	 * @throws SilsaeException
	 */
	UsuarioDTO buscarUsuarioLogin (CredencialesDTO credencialesDTO) throws SilsaeException;

	UsuarioDTO buscarUsuario(CredencialesDTO credencialesDTO)
			throws SilsaeException;

}
