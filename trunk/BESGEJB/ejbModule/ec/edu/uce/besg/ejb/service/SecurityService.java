package ec.edu.uce.besg.ejb.service;

import javax.ejb.Local;

import ec.edu.uce.besg.common.util.CorvustecException;
import ec.edu.uce.besg.ejb.persistence.entity.security.UsuarioDTO;

@Local
public interface SecurityService {

	UsuarioDTO loginEmpresa(UsuarioDTO usuarioDTO) throws CorvustecException;

}
