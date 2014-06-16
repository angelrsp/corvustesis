package net.ciespal.redxxi.ejb.persistence.dao;

import java.util.List;

import net.ciespal.redxxi.ejb.persistence.entities.UniversidadVieDTO;

import com.corvustec.commons.util.CorvustecException;

public interface UniversidadVieDAO {

	List<UniversidadVieDTO> getByAnd(UniversidadVieDTO objetoDTO)
			throws CorvustecException;

}
