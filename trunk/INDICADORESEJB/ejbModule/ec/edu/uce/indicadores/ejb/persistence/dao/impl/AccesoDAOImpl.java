package ec.edu.uce.indicadores.ejb.persistence.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.uce.indicadores.commons.util.IndicadoresException;
import ec.edu.uce.indicadores.ejb.persistence.dao.AccesoDAO;
import ec.edu.uce.indicadores.ejb.persistence.entities.AccesoDTO;
import ec.edu.uce.indicadores.ejb.persistence.entities.PerfilDTO;

public class AccesoDAOImpl extends AbstractFacadeImpl<AccesoDTO> implements AccesoDAO {

	public AccesoDAOImpl() {
		super();
	}

	public AccesoDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	
	@Override
	public void remove(PerfilDTO perfil) throws IndicadoresException
	{
		Query query =entityManager.createQuery("delete from AccesoDTO acc where acc.indPerfil.perCodigo=:codigo");
		query.setParameter("codigo", perfil.getPerCodigo());
		query.executeUpdate();
	}
}
