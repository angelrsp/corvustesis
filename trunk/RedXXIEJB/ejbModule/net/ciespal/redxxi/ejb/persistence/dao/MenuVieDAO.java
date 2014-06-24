package net.ciespal.redxxi.ejb.persistence.dao;

import java.util.List;

import com.corvustec.commons.util.CorvustecException;

import net.ciespal.redxxi.ejb.persistence.entities.security.MenuVieDTO;

public interface MenuVieDAO extends AbstractFacade<MenuVieDTO>{

	List<MenuVieDTO> getByAnd(MenuVieDTO objetoDTO) throws CorvustecException;

	List<MenuVieDTO> getByAndPredecesorIsNull(MenuVieDTO objetoDTO)
			throws CorvustecException;

	
}
