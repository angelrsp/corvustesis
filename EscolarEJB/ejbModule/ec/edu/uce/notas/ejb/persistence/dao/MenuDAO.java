package ec.edu.uce.notas.ejb.persistence.dao;

import java.util.List;

import com.corvustec.notas.common.util.CorvustecException;

import ec.edu.uce.notas.ejb.persistence.entity.MenuDTO;

public interface MenuDAO extends AbstractFacade<MenuDTO>{

	List<MenuDTO> getByAnd(MenuDTO MenuDTO) throws CorvustecException;

	List<MenuDTO> getRoot() throws CorvustecException;

}
