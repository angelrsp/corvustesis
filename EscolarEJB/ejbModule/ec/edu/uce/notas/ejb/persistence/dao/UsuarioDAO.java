package ec.edu.uce.notas.ejb.persistence.dao;

import java.util.List;

import com.corvustec.notas.common.util.CorvustecException;

import ec.edu.uce.notas.ejb.persistence.entity.UsuarioDTO;

public interface UsuarioDAO extends AbstractFacade<UsuarioDTO>{

	List<UsuarioDTO> getByAnd(UsuarioDTO objectDTO) throws CorvustecException;

	List<UsuarioDTO> getByAndGreath(UsuarioDTO objectDTO)
			throws CorvustecException;


}
