package ec.edu.uce.silsae.ejb.negocio.impl;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.uce.silsae.ejb.negocio.LoginService;
import ec.edu.uce.silsae.ejb.persistence.dao.UsuarioDAO;
import ec.edu.uce.silsae.ejb.persistence.entities.UsuarioDTO;

@Stateless
public class LoginServiceImpl implements LoginService{
	
	@Inject
	UsuarioDAO usuarioDAO;
	
	@Override
	public UsuarioDTO autenticarUsuario(String usuario, String clave) {
		return null;
	}

}
