package ec.edu.uce.silsae.ejb.persistence.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.uce.silsae.ejb.persistence.dao.CatalogoDAO;
import ec.edu.uce.silsae.ejb.persistence.entities.CatalogoDTO;

public class CatalogoDAOImpl extends AbstractFacadeImpl<CatalogoDTO> implements CatalogoDAO{

	public CatalogoDAOImpl() {
		super();
	}

	public CatalogoDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@SuppressWarnings("unchecked")
	public List<CatalogoDTO> getAll(CatalogoDTO catalogo)
	{
		Query query = entityManager.createQuery("select cat from CatalogoDTO cat inner join cat.bemCatalogo catP where catP.catCodigo=?");
		query.setParameter(1, catalogo.getCatCodigo());

		List<CatalogoDTO> list=query.getResultList();
		
		return list;
	}
}
