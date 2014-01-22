package ec.edu.uce.silsag.ejb.persistence.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import ec.edu.uce.silsag.commons.dto.util.EstudioReportDTO;
import ec.edu.uce.silsag.commons.util.SilsagException;
import ec.edu.uce.silsag.ejb.persistence.dao.CandidatoDAO;
import ec.edu.uce.silsag.ejb.persistence.entities.AnioEstudioDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.CandidatoDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.CandidatoEstudioDTO;

@Stateless
public class CandidatoDAOImpl extends AbstractFacadeImpl<CandidatoDTO> implements CandidatoDAO{
	
	public CandidatoDAOImpl () {}
	
	public CandidatoDAOImpl (EntityManager entityManager) {
		super(entityManager);
	}

	
	
	@Override
	public List<CandidatoDTO> getAll() throws SilsagException
	{
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<CandidatoDTO> cq=cb.createQuery(CandidatoDTO.class);
		cq.from(CandidatoDTO.class);
				
		List<CandidatoDTO> list=entityManager.createQuery(cq).getResultList();
		if(list.isEmpty())
			return null;
		else
			return list;
	}
	
	@Override
	public Boolean getByIdentificacion(CandidatoDTO candidatoDTO) {
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<CandidatoDTO> cq=cb.createQuery(CandidatoDTO.class);
		Root<CandidatoDTO> from= cq.from(CandidatoDTO.class);
		
		cq.where(cb.equal(from.get("canIdentificacion"), candidatoDTO.getCanIdentificacion()));
		
		List<CandidatoDTO> list=entityManager.createQuery(cq).getResultList();
		if(list.isEmpty())
			return false;
		else
			return true;	
	}
	
	
//	@Override
//	public List<CandidatoDatoDTO> getData(CandidatoDTO can) throws SilsagException
//	{
//		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
//		CriteriaQuery<CandidatoDatoDTO> cq=cb.createQuery(CandidatoDatoDTO.class);
//		Root<CandidatoDatoDTO> from =cq.from(CandidatoDatoDTO.class);
//		
//		cq.where(cb.equal(from.get("canCodigo"), can.getCanCodigo()));
//				
//		List<CandidatoDatoDTO> list=entityManager.createQuery(cq).getResultList();
//		
//		if(list.isEmpty())
//			return null;
//		else
//			return list;
//	}
	
	
	
	
	

	@Override
	public List<CandidatoEstudioDTO> getCandidatoEstudio() throws SilsagException
	{
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<CandidatoEstudioDTO> cq=cb.createQuery(CandidatoEstudioDTO.class);
		cq.from(CandidatoEstudioDTO.class);
				
		List<CandidatoEstudioDTO> list=entityManager.createQuery(cq).getResultList();
		if(list.isEmpty())
			return null;
		else
			return list;
	}
	
//	@Override
//	public List<CandidatoEstudioDTO> getCandidatoEstudio(CandidatoDTO candidatoDTO) throws SilsagException
//	{
//		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
//		CriteriaQuery<CandidatoEstudioDTO> cq=cb.createQuery(CandidatoEstudioDTO.class);
//		Root<CandidatoEstudioDTO> from= cq.from(CandidatoEstudioDTO.class);
//		
//		cq.where(cb.equal(from.get("canCodigo"),candidatoDTO.getCanCodigo()));
//		
//		List<CandidatoEstudioDTO> list=entityManager.createQuery(cq).getResultList();
//		if(list.isEmpty())
//			return null;
//		else
//			return list;
//	}
	
	
	@Override
	public List<CandidatoEstudioDTO> getCandidatoEstudio(int nivelEstudio,int genero) throws SilsagException
	{
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<CandidatoEstudioDTO> cq=cb.createQuery(CandidatoEstudioDTO.class);
		Root<CandidatoEstudioDTO> from= cq.from(CandidatoEstudioDTO.class);
		
		if(nivelEstudio!=0)
			cq.where(cb.and(cb.equal(from.get("canSexo"), genero),cb.equal(from.get("canMaxEstudio"), nivelEstudio)));
		else
			cq.where(cb.equal(from.get("canSexo"), genero));
				
		List<CandidatoEstudioDTO> list=entityManager.createQuery(cq).getResultList();
		if(list.isEmpty())
			return null;
		else
			return list;
	}

	
	@Override
	public List<AnioEstudioDTO> getYearEstudio() throws SilsagException
	{
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<AnioEstudioDTO> cq=cb.createQuery(AnioEstudioDTO.class);
		cq.from(AnioEstudioDTO.class);
		
		List<AnioEstudioDTO> list=entityManager.createQuery(cq).getResultList();
		if(list.isEmpty())
			return null;
		else
			return list;
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<EstudioReportDTO> getNivel(int anio) throws SilsagException
	{
		Query query=entityManager.createNativeQuery("select count(can_max_estudio) as est_numero,can_max_estudio as est_codigo,extract(month from est_fecha_fin) as est_mes "+
													"from bem_candidato "+
													"inner join bem_estudio on est_nivel=can_max_estudio "+
													"where extract(year from est_fecha_fin)=? "+
													"group by can_max_estudio,est_fecha_fin; ");
		query.setParameter(1, anio);
		
		List<Object[]> listRet= query.getResultList();
		
		List<EstudioReportDTO> list=new ArrayList<EstudioReportDTO>();
		
		EstudioReportDTO es;
		
		for(Object[] obj:listRet)
		{
			es=new EstudioReportDTO();
			es.setEstNumero(obj[0].toString());
			es.setEstCodigo(obj[1].toString());
			es.setEstMes(String.valueOf(Double.valueOf(obj[2].toString()).intValue()));
			list.add(es);
		}
		return list;
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<EstudioReportDTO> getNivel() throws SilsagException
	{
		Query query=entityManager.createNativeQuery("select count(can_max_estudio) as est_numero,can_max_estudio as est_codigo,extract(year from est_fecha_fin) as est_mes "+
				"from bem_candidato "+
				"inner join bem_estudio on est_nivel=can_max_estudio "+
				"group by can_max_estudio,est_fecha_fin; ");


		List<Object[]> listRet= query.getResultList();
		
		List<EstudioReportDTO> list=new ArrayList<EstudioReportDTO>();
		
		EstudioReportDTO es;
		
		for(Object[] obj:listRet)
		{
			es=new EstudioReportDTO();
			es.setEstNumero(obj[0].toString());
			es.setEstCodigo(obj[1].toString());
			es.setEstMes(String.valueOf(Double.valueOf(obj[2].toString()).intValue()));
			list.add(es);
		}
		return list;
	}

	
//	@Override
//	public List<Integer> getCountEstudio(Timestamp fechaDesde,Timestamp fechaHasta) throws SilsagException
//	{
//		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
//		CriteriaQuery<Integer> cq=cb.createQuery(Integer.class);
//		Root<CandidatoEstudioDTO> from= cq.from(CandidatoEstudioDTO.class);
//		
//		cq.multiselect(from.get("canMaxEstudios")).distinct(true);
//		
//		cq.where(cb.between(from.get("canFechaUltima").as(Timestamp.class), fechaDesde, fechaHasta));
//				
//		List<Integer> list=entityManager.createQuery(cq).getResultList();
//		if(list.isEmpty())
//			return null;
//		else
//			return list;
//	}
	
	

}
