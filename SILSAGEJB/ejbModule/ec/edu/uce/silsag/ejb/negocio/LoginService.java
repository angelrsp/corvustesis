package ec.edu.uce.silsag.ejb.negocio;

import javax.ejb.Local;

import ec.edu.uce.silsag.commons.dto.util.CredencialesDTO;
import ec.edu.uce.silsag.commons.util.SilsagException;
import ec.edu.uce.silsag.ejb.persistence.entities.UsuarioDTO;

@Local
public interface LoginService {
	
	UsuarioDTO autenticarUsuario (CredencialesDTO credencialesDTO) throws SilsagException;

	Boolean recuperarClave(CredencialesDTO credencialesDTO)
			throws SilsagException;

}
