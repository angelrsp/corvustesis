package ec.edu.uce.notas.ejb.persistence.dao;

import java.util.List;

import com.corvustec.notas.common.util.CorvustecException;

import ec.edu.uce.notas.ejb.persistence.entity.UsuarioPerfilDTO;

public interface UsuarioPerfilDAO extends AbstractFacade<UsuarioPerfilDTO>{

	List<UsuarioPerfilDTO> getByAnd(UsuarioPerfilDTO objetoDTO)
			throws CorvustecException;

	List<UsuarioPerfilDTO> getBySubquery(UsuarioPerfilDTO objetoDTO)
			throws CorvustecException;

	
	
}
