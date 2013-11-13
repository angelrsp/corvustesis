package ec.edu.uce.silsae.ejb.persistence.dao;

import java.util.List;

import javax.ejb.Local;

import ec.edu.uce.silsae.ejb.persistence.entities.CatalogoDTO;

@Local
public interface CatalogoDAO extends AbstractFacade<CatalogoDTO>{
	
	List<CatalogoDTO> getAll(CatalogoDTO catalogo);

}
