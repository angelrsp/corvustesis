package ec.edu.uce.besg.ejb.persistence.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.uce.besg.ejb.persistence.dao.CatalogoDAO;
import ec.edu.uce.besg.ejb.persistence.entity.security.CatalogoDTO;

public class CatalogoDAOImpl extends AbstractFacadeImpl<CatalogoDTO> implements CatalogoDAO {

	public CatalogoDAOImpl() {
		super();
	}

	public CatalogoDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}
	
	@SuppressWarnings({ "unchecked" })
	@Override 
	public List<CatalogoDTO> getAll(CatalogoDTO catalogo) 
	{ 
		List<CatalogoDTO> list = null; 
		
			Query query = entityManager.createQuery("select cat from CatalogoDTO cat inner join cat.segCatalogo catP where catP.catCodigo= :codigo order by cat.catDescripcion");
			if(catalogo.getCatCodigo()!=null)
				query.setParameter("codigo", catalogo.getCatCodigo());
			else
				query.setParameter("codigo", 0);
			
			list=query.getResultList();
			return  list;
	}		
	}


