package ec.edu.uce.notas.ejb.persistence.dao;

import java.util.List;

import com.corvustec.notas.common.util.CorvustecException;

import ec.edu.uce.notas.ejb.persistence.entity.view.MenuViewDTO;


public interface MenuViewDAO extends AbstractFacade<MenuViewDTO>{

	List<MenuViewDTO> getByAnd(MenuViewDTO objetoDTO) throws CorvustecException;

	List<MenuViewDTO> getByAndPredecesorIsNull(MenuViewDTO objetoDTO)
			throws CorvustecException;

	
}
