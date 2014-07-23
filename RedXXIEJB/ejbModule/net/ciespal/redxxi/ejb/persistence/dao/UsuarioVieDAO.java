package net.ciespal.redxxi.ejb.persistence.dao;

import java.util.List;

import net.ciespal.redxxi.ejb.persistence.entities.security.UsuarioVieDTO;

import com.corvustec.commons.util.CorvustecException;

public interface UsuarioVieDAO {

	List<UsuarioVieDTO> getByAnd(UsuarioVieDTO objetoDTO)
			throws CorvustecException;

}
