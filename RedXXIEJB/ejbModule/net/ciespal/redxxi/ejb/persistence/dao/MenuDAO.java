package net.ciespal.redxxi.ejb.persistence.dao;

import java.util.List;

import net.ciespal.redxxi.ejb.persistence.entities.security.MenuDTO;

import com.corvustec.commons.util.CorvustecException;

public interface MenuDAO extends AbstractFacade<MenuDTO>{

	List<MenuDTO> getByAnd(MenuDTO MenuDTO) throws CorvustecException;

	List<MenuDTO> getRoot() throws CorvustecException;

}
