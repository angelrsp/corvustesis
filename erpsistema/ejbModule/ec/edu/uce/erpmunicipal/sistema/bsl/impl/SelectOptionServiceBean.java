package ec.edu.uce.erpmunicipal.sistema.bsl.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import ec.edu.uce.erpmunicipal.contabilidad.orm.ConPeriodo;
import ec.edu.uce.erpmunicipal.sistema.bsl.SelectOptionService;
import ec.edu.uce.erpmunicipal.util.CalendarUtil;

@Stateless(name = "selectOptionService")
public class SelectOptionServiceBean implements SelectOptionService{


	@PersistenceContext(name = "erpmunicipalPU", type = PersistenceContextType.TRANSACTION)
	private EntityManager entityManager;
	
	
	private List<ConPeriodo> readYears()
	{
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<ConPeriodo> cq = cb.createQuery(ConPeriodo.class);

		Root<ConPeriodo> from = cq.from(ConPeriodo.class);
		
		cq.multiselect(from.get("perAnio")).distinct(true);
		cq.where(cb.equal(from.get("perActivo").as(Boolean.class), true));
		
		List<ConPeriodo> list= entityManager.createQuery(cq).getResultList();
		if(list.isEmpty())
			return null;
		else
			return list;
	}
	
	@Override
	public List<ConPeriodo> readYear()
	{
		
		if(readYears()!=null)
			return readYears();
		else
		{
			ConPeriodo periodo=new ConPeriodo();
			periodo.setPerAnio(CalendarUtil.getYear());
			List<ConPeriodo> periodos=new ArrayList<ConPeriodo>();
			periodos.add(periodo);
			return periodos;
		}
			
	}
}
