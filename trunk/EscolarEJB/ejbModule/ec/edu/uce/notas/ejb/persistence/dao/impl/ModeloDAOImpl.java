package ec.edu.uce.notas.ejb.persistence.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import com.corvustec.notas.common.util.CorvustecException;

import ec.edu.uce.notas.ejb.persistence.dao.ModeloDAO;
import ec.edu.uce.notas.ejb.persistence.entity.ModeloDTO;

public class ModeloDAOImpl extends AbstractFacadeImpl<ModeloDTO> implements ModeloDAO{

//	private static final Logger log = LoggerFactory
//			.getLogger(ModeloDAOImpl.class);
	
	public ModeloDAOImpl() {
	
	}

	public ModeloDAOImpl(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<ModeloDTO> getAll() throws CorvustecException
	{
		//log.info("getAll");
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<ModeloDTO> cq=cb.createQuery(ModeloDTO.class);
		//Root<ModeloDTO> from= 
		cq.from(ModeloDTO.class);
		
		//cq.where(cb.greaterThan(from.get("iesCodigo").as(Integer.class), 1));
		//cq.orderBy(cb.asc(from.get("modVersion")));
		
		List<ModeloDTO> list=entityManager.createQuery(cq).getResultList();	
		if(list.isEmpty())
			return null;
		else
			return list;
	}
	
	@Override
	public void remove2(ModeloDTO modelo)
	{
		Query query;
		query=entityManager.createQuery("delete from ModeloDTO mod where mod.modCodigo=:codigo");
		query.setParameter("codigo", modelo.getModCodigo());
		query.executeUpdate();

	}
}
