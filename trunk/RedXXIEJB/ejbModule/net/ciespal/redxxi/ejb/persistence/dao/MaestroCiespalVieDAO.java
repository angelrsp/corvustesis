package net.ciespal.redxxi.ejb.persistence.dao;

import java.util.List;

import com.corvustec.commons.util.CorvustecException;

import net.ciespal.redxxi.ejb.persistence.entities.espejo.MaestroCiespalVieDTO;

public interface MaestroCiespalVieDAO extends AbstractFacade<MaestroCiespalVieDTO>{

	List<MaestroCiespalVieDTO> getByAnd(MaestroCiespalVieDTO objetoDTO)
			throws CorvustecException;

	
	
}
