package ec.edu.uce.silsag.ejb.persistence.dao;

import java.util.List;

import javax.ejb.Local;

import ec.edu.uce.silsag.ejb.persistence.entities.CatalogoDTO;

@Local
public interface CatalogoDAO extends AbstractFacade<CatalogoDTO>{
	
	List<CatalogoDTO> getAll(CatalogoDTO catalogo);

}
