package ec.edu.uce.silsae.ejb.persistence.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import ec.edu.uce.silsae.ejb.persistence.dao.CatalogoDAO;
import ec.edu.uce.silsae.ejb.persistence.entities.CatalogoDTO;

public class CatalogoDAOImpl extends AbstractFacadeImpl<CatalogoDTO> implements CatalogoDAO{

	public CatalogoDAOImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CatalogoDAOImpl(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}

	public List<CatalogoDTO> getList(CatalogoDTO catalogo)
	{
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<CatalogoDTO> cq = cb.createQuery(CatalogoDTO.class);
		cq.from(CatalogoDTO.class);
		
		Root<CatalogoDTO> from = cq.from(CatalogoDTO.class);
		
		//cq.where(cb.equal("bemCatalogos", arg1))

		
		return null;
	}
}
