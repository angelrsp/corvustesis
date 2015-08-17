package ec.edu.uce.notas.ejb.persistence.dao.impl;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import com.corvustec.notas.common.util.CorvustecException;

import ec.edu.uce.notas.ejb.persistence.dao.HistoricoIndicadorDAO;
import ec.edu.uce.notas.ejb.persistence.entity.EvidenciaDTO;
import ec.edu.uce.notas.ejb.persistence.entity.HistoricoIndicadorDTO;
import ec.edu.uce.notas.ejb.persistence.entity.IndicadorDTO;

public class HistoricoIndicadorDAOImpl extends AbstractFacadeImpl<HistoricoIndicadorDTO> implements HistoricoIndicadorDAO{

	
	public HistoricoIndicadorDAOImpl() {
		super();
	}

	public HistoricoIndicadorDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<HistoricoIndicadorDTO> getAll(IndicadorDTO indicadorDTO) throws CorvustecException
	{
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<HistoricoIndicadorDTO> cq=cb.createQuery(HistoricoIndicadorDTO.class);
		Root<HistoricoIndicadorDTO> from= cq.from(HistoricoIndicadorDTO.class);
		Path<IndicadorDTO> join=from.join("indIndicador");
		
		cq.where(cb.equal(join.get("indCodigo"), indicadorDTO.getIndCodigo()));
		
		cq.orderBy(cb.asc(from.get("hinFecha").as(Timestamp.class)));
		
		List<HistoricoIndicadorDTO> list=entityManager.createQuery(cq).getResultList();	
		if(list.isEmpty())
			return null;
		else
			return list;
	}
	
	@Override
	public void remove2(HistoricoIndicadorDTO historicoIndicadorDTO)
	{
		Query query;
		
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<EvidenciaDTO> cq=cb.createQuery(EvidenciaDTO.class);
		Root<EvidenciaDTO> from= cq.from(EvidenciaDTO.class);

		cq.where(cb.equal(from.get("indHistoricoIndicador"), historicoIndicadorDTO));
		 
		
		List<EvidenciaDTO> list=entityManager.createQuery(cq).getResultList();
		
		
		for(EvidenciaDTO evi: list)
		{
			query=entityManager.createQuery("delete from EvidenciaDTO where eviCodigo=:codigo");
			query.setParameter("codigo", evi.getEviCodigo());
			query.executeUpdate();
		}
		
		query=entityManager.createQuery("delete from HistoricoIndicadorDTO where hinCodigo=:codigo");
		query.setParameter("codigo", historicoIndicadorDTO.getHinCodigo());
		query.executeUpdate();
	}
}
