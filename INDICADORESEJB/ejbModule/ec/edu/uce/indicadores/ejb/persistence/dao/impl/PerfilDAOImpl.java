package ec.edu.uce.indicadores.ejb.persistence.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.uce.indicadores.commons.util.IndicadoresException;
import ec.edu.uce.indicadores.ejb.persistence.dao.PerfilDAO;
import ec.edu.uce.indicadores.ejb.persistence.entities.PerfilDTO;

public class PerfilDAOImpl extends AbstractFacadeImpl<PerfilDTO> implements PerfilDAO {

	public PerfilDAOImpl() {
		super();
	}

	public PerfilDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public void remove2(PerfilDTO perfil) throws IndicadoresException
	{
		Query query;
		query=entityManager.createQuery("delete from PerfilDTO where perCodigo=:codigo");
		query.setParameter("codigo", perfil.getPerCodigo());
		query.executeUpdate();
	}
}
