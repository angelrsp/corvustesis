package ec.edu.uce.silsag.ejb.persistence.dao.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;

import ec.edu.uce.silsag.ejb.persistence.dao.AvisoDAO;
import ec.edu.uce.silsag.ejb.persistence.entities.AvisoDTO;

@Stateless
public class AvisoDAOImpl extends AbstractFacadeImpl<AvisoDTO> implements AvisoDAO{

	public AvisoDAOImpl () {}
	
	public AvisoDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

//	@Override
//	public List<AvisoListDTO> getAll(EmpresaDTO empresa) throws SilsagException
//	{
//		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
//		CriteriaQuery<AvisoListDTO> cq=cb.createQuery(AvisoListDTO.class);
//		Root<AvisoListDTO> from = cq.from(AvisoListDTO.class);
//		cq.where(cb.equal(from.get("aviEmpresa"), empresa.getEmpCodigo()));
//		List<AvisoListDTO> list=entityManager.createQuery(cq).getResultList();
//		if(list.isEmpty())
//			return null;
//		else
//			return list;
//	}
//	
//	@Override
//	public List<AvisoListDTO> getOfertas() throws SilsagException
//	{
//		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
//		CriteriaQuery<AvisoListDTO> cq=cb.createQuery(AvisoListDTO.class);
//		Root<AvisoListDTO> from = cq.from(AvisoListDTO.class);
//		cq.where(cb.greaterThanOrEqualTo(from.get("aviFechaCaducidad").as(Date.class),CalendarUtil.getTimeNowTimestamp()));
//		List<AvisoListDTO> list=entityManager.createQuery(cq).getResultList();
//		if(list.isEmpty())
//			return null;
//		else
//			return list;
//	}

}
