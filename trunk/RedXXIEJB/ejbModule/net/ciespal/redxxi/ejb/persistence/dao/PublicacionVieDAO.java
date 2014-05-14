package net.ciespal.redxxi.ejb.persistence.dao;

import java.util.List;

import net.ciespal.redxxi.ejb.persistence.entities.PublicacionVieDTO;

import com.corvustec.commons.util.CorvustecException;

public interface PublicacionVieDAO {

	List<PublicacionVieDTO> get(PublicacionVieDTO publicacion)
			throws CorvustecException;

}
