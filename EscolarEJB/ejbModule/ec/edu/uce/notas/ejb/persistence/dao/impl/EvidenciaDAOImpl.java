package ec.edu.uce.notas.ejb.persistence.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import com.corvustec.notas.common.util.CorvustecException;

import ec.edu.uce.notas.ejb.persistence.dao.EvidenciaDAO;
import ec.edu.uce.notas.ejb.persistence.entity.EvidenciaDTO;
import ec.edu.uce.notas.ejb.persistence.entity.HistoricoIndicadorDTO;

public class EvidenciaDAOImpl extends AbstractFacadeImpl<EvidenciaDTO> implements EvidenciaDAO{

	
	public EvidenciaDAOImpl() {
		super();
	}

	public EvidenciaDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<EvidenciaDTO> getAll(HistoricoIndicadorDTO historicoIndicadorDTO) throws CorvustecException
	{
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<EvidenciaDTO> cq=cb.createQuery(EvidenciaDTO.class);
		Root<EvidenciaDTO> from= cq.from(EvidenciaDTO.class);
		Path<HistoricoIndicadorDTO> join=from.join("indHistoricoIndicador");
		
		cq.where(cb.equal(join.get("hinCodigo"), historicoIndicadorDTO.getHinCodigo()));
		
		List<EvidenciaDTO> list=entityManager.createQuery(cq).getResultList();	
		if(list.isEmpty())
			return null;
		else
			return list;
	}
}
