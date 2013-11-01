package ec.edu.uce.silsae.ejb.negocio;

import javax.ejb.Local;

import ec.edu.uce.silsae.commons.dto.util.CredencialesDTO;
import ec.edu.uce.silsae.commons.util.SilsaeException;
import ec.edu.uce.silsae.ejb.persistence.entities.UsuarioDTO;

@Local
public interface LoginService {
	
	UsuarioDTO autenticarUsuario (CredencialesDTO credencialesDTO) throws SilsaeException;

}
