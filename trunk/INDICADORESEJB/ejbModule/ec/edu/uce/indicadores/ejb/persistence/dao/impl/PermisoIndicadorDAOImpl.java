package ec.edu.uce.indicadores.ejb.persistence.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import ec.edu.uce.indicadores.ejb.persistence.dao.PermisoIndicadorDAO;
import ec.edu.uce.indicadores.ejb.persistence.entities.IndicadorDTO;
import ec.edu.uce.indicadores.ejb.persistence.entities.PerfilDTO;
import ec.edu.uce.indicadores.ejb.persistence.entities.PermisoIndicadorDTO;

public class PermisoIndicadorDAOImpl extends AbstractFacadeImpl<PermisoIndicadorDTO> implements PermisoIndicadorDAO{

	public PermisoIndicadorDAOImpl() {
		super();
	}

	public PermisoIndicadorDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public void remove2(PerfilDTO perfil)
	{
		Query query;
		query=entityManager.createQuery("delete from PermisoIndicadorDTO per where per.indPerfil.perCodigo=:codigo");
		query.setParameter("codigo", perfil.getPerCodigo());
		query.executeUpdate();
	}
	
	@Override
	public void remove3(Object perfil)
	{
		Query query;
		query=entityManager.createQuery("delete from PermisoIndicadorDTO per where per.indPerfil.perCodigo=:codigo");
		query.setParameter("codigo", perfil);
		query.executeUpdate();
	}

	@Override
	public Boolean existe(IndicadorDTO indicador,PerfilDTO perfil)
	{
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<PermisoIndicadorDTO> cq=cb.createQuery(PermisoIndicadorDTO.class);
		Root<PermisoIndicadorDTO> from= cq.from(PermisoIndicadorDTO.class);
		
		cq.where(cb.and(cb.equal(from.get("peiIndicador"), indicador.getIndCodigo()),cb.equal(from.get("indPerfil").get("perCodigo"), perfil.getPerCodigo())));
		
		List<PermisoIndicadorDTO> list=entityManager.createQuery(cq).getResultList();	
		if(list.isEmpty())
			return false;
		else
			return true;

	}
	
}
