package ec.edu.uce.besg.ejb.service;

import javax.ejb.Local;

import ec.edu.uce.besg.common.util.CorvustecException;
import ec.edu.uce.besg.common.util.dto.PasswordDTO;
import ec.edu.uce.besg.ejb.persistence.entity.security.UsuarioDTO;

@Local
public interface SecurityService {

	UsuarioDTO authenticateEmpresa(UsuarioDTO usuarioDTO) throws CorvustecException;

	UsuarioDTO authenticateCandidato(UsuarioDTO usuarioDTO) throws CorvustecException;

	void changePassword(PasswordDTO passwordDTO) throws CorvustecException;

}
