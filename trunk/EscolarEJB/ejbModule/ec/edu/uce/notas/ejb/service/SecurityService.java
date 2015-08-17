package ec.edu.uce.notas.ejb.service;

import javax.ejb.Local;

import com.corvustec.notas.common.util.CorvustecException;
import com.corvustec.notas.common.util.dto.CredencialDTO;
import com.corvustec.notas.common.util.dto.PasswordDTO;

import ec.edu.uce.notas.ejb.persistence.entity.UsuarioDTO;

@Local
public interface SecurityService {

	void changePassword(PasswordDTO passwordDTO) throws CorvustecException;

	void recoverPassword(UsuarioDTO usuarioDTO) throws CorvustecException;

	UsuarioDTO authenticateUser(CredencialDTO credencialDTO)
			throws CorvustecException;

}
