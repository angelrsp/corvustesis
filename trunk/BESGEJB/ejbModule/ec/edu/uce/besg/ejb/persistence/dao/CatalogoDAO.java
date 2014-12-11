package ec.edu.uce.besg.ejb.persistence.dao;

import java.util.List;

import ec.edu.uce.besg.ejb.persistence.entity.security.CatalogoDTO;

public interface CatalogoDAO extends AbstractFacade<CatalogoDTO>{

	List<CatalogoDTO> getAll(CatalogoDTO catalogo);

}
