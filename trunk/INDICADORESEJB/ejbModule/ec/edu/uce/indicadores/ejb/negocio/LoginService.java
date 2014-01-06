package ec.edu.uce.indicadores.ejb.negocio;

import javax.ejb.Local;

import ec.edu.uce.indicadores.commons.dto.util.CredencialesDTO;
import ec.edu.uce.indicadores.commons.util.IndicadoresException;
import ec.edu.uce.indicadores.ejb.persistence.entities.UsuarioDTO;

@Local
public interface LoginService {

	UsuarioDTO autenticarUsuario(CredencialesDTO credencialesDTO)
			throws IndicadoresException;

}
