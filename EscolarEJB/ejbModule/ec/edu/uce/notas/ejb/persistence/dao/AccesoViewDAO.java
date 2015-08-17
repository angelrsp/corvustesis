package ec.edu.uce.notas.ejb.persistence.dao;

import java.util.List;

import com.corvustec.notas.common.util.CorvustecException;

import ec.edu.uce.notas.ejb.persistence.entity.view.AccesoViewDTO;

public interface AccesoViewDAO extends AbstractFacade<AccesoViewDTO>{

	List<AccesoViewDTO> getByAnd(AccesoViewDTO menuDTO) throws CorvustecException;

	List<AccesoViewDTO> getByAndPerfilIsNull(AccesoViewDTO objetoDTO)
			throws CorvustecException;

	List<AccesoViewDTO> getByAndDistinctMenu(AccesoViewDTO objetoDTO)
			throws CorvustecException;

	List<AccesoViewDTO> getBySubquery(AccesoViewDTO objetoDTO)
			throws CorvustecException;

	
	
}
