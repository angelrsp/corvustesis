package net.ciespal.redxxi.ejb.persistence.dao;

import java.util.List;

import com.corvustec.commons.util.CorvustecException;

import net.ciespal.redxxi.ejb.persistence.entities.espejo.GranMaestroVieDTO;

public interface GranMaestroVieDAO extends AbstractFacade<GranMaestroVieDTO>{

	List<GranMaestroVieDTO> getByAnd(GranMaestroVieDTO objetoDTO)
			throws CorvustecException;

	
}
