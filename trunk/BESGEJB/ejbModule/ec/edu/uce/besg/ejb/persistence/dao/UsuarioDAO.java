package ec.edu.uce.besg.ejb.persistence.dao;

import java.util.List;

import ec.edu.uce.besg.common.util.CorvustecException;
import ec.edu.uce.besg.ejb.persistence.entity.security.UsuarioDTO;

public interface UsuarioDAO extends AbstractFacade<UsuarioDTO>{

	List<UsuarioDTO> getByAnd(UsuarioDTO objeto) throws CorvustecException;

	List<UsuarioDTO> getByAndJoinEntity(UsuarioDTO objeto)
			throws CorvustecException;

	List<UsuarioDTO> getByAndJoinCandidato(UsuarioDTO objeto)
			throws CorvustecException;

}
