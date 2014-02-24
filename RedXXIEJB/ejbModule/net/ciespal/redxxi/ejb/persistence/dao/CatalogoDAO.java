package net.ciespal.redxxi.ejb.persistence.dao;

import java.util.List;

import net.ciespal.redxxi.ejb.persistence.entities.CatalogoDTO;

public interface CatalogoDAO extends AbstractFacade<CatalogoDTO> {

	List<CatalogoDTO> getAll(CatalogoDTO catalogo);

	void remove2(CatalogoDTO catalogo);
}
