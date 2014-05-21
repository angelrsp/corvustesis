package net.ciespal.redxxi.ejb.persistence.dao;

import java.util.List;

import com.corvustec.commons.util.CorvustecException;

import net.ciespal.redxxi.ejb.persistence.entities.security.MenuDTO;

public interface MenuDAO extends AbstractFacade<MenuDTO>{

	List<MenuDTO> getByAnd(MenuDTO MenuDTO) throws CorvustecException;

	List<MenuDTO> getRoot() throws CorvustecException;

}
