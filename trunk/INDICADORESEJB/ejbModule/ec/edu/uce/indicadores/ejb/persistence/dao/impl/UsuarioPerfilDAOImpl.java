package ec.edu.uce.indicadores.ejb.persistence.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.uce.indicadores.commons.util.IndicadoresException;
import ec.edu.uce.indicadores.ejb.persistence.dao.UsuarioPerfilDAO;
import ec.edu.uce.indicadores.ejb.persistence.entities.UsuarioPerfilDTO;

public class UsuarioPerfilDAOImpl extends AbstractFacadeImpl<UsuarioPerfilDTO> implements UsuarioPerfilDAO {

	public UsuarioPerfilDAOImpl() {
		super();
	}

	public UsuarioPerfilDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public void remove2(UsuarioPerfilDTO userPerf)throws IndicadoresException
	{
		Query query;
		query=entityManager.createQuery("delete from UsuarioPerfilDTO uspe where uspe.indUsuario.usuCodigo=:codigo");
		query.setParameter("codigo", userPerf.getIndUsuario().getUsuCodigo());
		query.executeUpdate();
	}
}
