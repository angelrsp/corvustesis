package ec.edu.uce.silsag.ejb.persistence.dao.impl;

import javax.persistence.EntityManager;

import ec.edu.uce.silsag.ejb.persistence.dao.ExperienciaDAO;
import ec.edu.uce.silsag.ejb.persistence.entities.ExperienciaDTO;

public class ExperienciaDAOImpl extends AbstractFacadeImpl<ExperienciaDTO> implements ExperienciaDAO{

	public ExperienciaDAOImpl() {
		super();
	}

	public ExperienciaDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

//	@Override
//	public List<ExperienciaListDTO> getAll(CandidatoDTO candidato) throws SilsagException
//	{
//		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
//		CriteriaQuery<ExperienciaListDTO> cq=cb.createQuery(ExperienciaListDTO.class);
//		Root<ExperienciaListDTO> from = cq.from(ExperienciaListDTO.class);
//		cq.where(cb.equal(from.get("expCandidato"), candidato.getCanCodigo()));
//		List<ExperienciaListDTO> list=entityManager.createQuery(cq).getResultList();
//		if(list.isEmpty())
//			return null;
//		else
//			return list;
//	}
}
