package ec.edu.uce.indicadores.ejb.persistence.dao;

import java.util.List;

import ec.edu.uce.indicadores.ejb.persistence.entities.CatalogoDTO;

public interface CatalogoDAO extends AbstractFacade<CatalogoDTO>{

	
	List<CatalogoDTO> getAll(CatalogoDTO catalogo);

}
