package ec.edu.uce.silsae.ejb.negocio;

import javax.ejb.Local;

import ec.edu.uce.silsae.ejb.persistence.entities.UsuarioDTO;

@Local
public interface LoginService {
	
	UsuarioDTO autenticarUsuario (String usuario, String clave);

}
