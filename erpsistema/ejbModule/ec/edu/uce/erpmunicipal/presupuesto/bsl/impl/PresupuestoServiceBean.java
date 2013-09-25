package ec.edu.uce.erpmunicipal.presupuesto.bsl.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import ec.edu.uce.erpmunicipal.contabilidad.bsl.AccoutingService;
import ec.edu.uce.erpmunicipal.contabilidad.orm.ConCuenta;
import ec.edu.uce.erpmunicipal.presupuesto.bsl.PresupuestoService;
import ec.edu.uce.erpmunicipal.presupuesto.orm.PreEstado;
import ec.edu.uce.erpmunicipal.presupuesto.orm.PrePresupuesto;
import ec.edu.uce.erpmunicipal.presupuesto.orm.PrePrograma;
import ec.edu.uce.erpmunicipal.presupuesto.orm.PreProgramaCuenta;
import ec.edu.uce.erpmunicipal.presupuesto.orm.PreReforma;
import ec.edu.uce.erpmunicipal.presupuesto.orm.PreReformaDetalle;
import ec.edu.uce.erpmunicipal.presupuesto.orm.PreTipoProgramaCuenta;
import ec.edu.uce.erpmunicipal.presupuesto.orm.PreTipoReforma;
import ec.edu.uce.erpmunicipal.presupuesto.orm.PreVerificacion;
import ec.edu.uce.erpmunicipal.util.CalendarUtil;

@Stateless(name="presupuestoService")
public class PresupuestoServiceBean implements PresupuestoService{


	@PersistenceContext(name = "erpmunicipalPU", type = PersistenceContextType.TRANSACTION)
	private EntityManager entityManager;

	@EJB(name = "accoutingService/local")
	public AccoutingService accoutingService;
	
	@Override
	public AccoutingService getAccoutingService() {
		return accoutingService;
	}
	
	@Override
	public List<PrePrograma> readPrograms()
	{
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<PrePrograma> cq = cb.createQuery(PrePrograma.class);

		cq.select(cq.from(PrePrograma.class));
		
		List<PrePrograma> list = entityManager.createQuery(cq).getResultList();

		return list;
	}
	
	@Override
	public List<PreVerificacion> readVerification()
	{
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<PreVerificacion> cq = cb.createQuery(PreVerificacion.class);

		cq.select(cq.from(PreVerificacion.class));
		
		List<PreVerificacion> list = entityManager.createQuery(cq).getResultList();

		return list;		
	}
	
	@Override
	public PreTipoProgramaCuenta findByIdProgramCuenta(int code)
	{
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<PreTipoProgramaCuenta> cq = cb.createQuery(PreTipoProgramaCuenta.class);
		Root<PreTipoProgramaCuenta> from=	cq.from(PreTipoProgramaCuenta.class);
		
		cq.where(cb.equal(from.get("tpcCodigo"), code));
		
		List<PreTipoProgramaCuenta> list= entityManager.createQuery(cq).getResultList();
		if(!list.isEmpty())
			return list.get(0);
		else
			return null;
	}
	
	@Override
	public void initialRegister(int programCode,List<PreProgramaCuenta> proCuenta)
	{
		PrePrograma programa=entityManager.find(PrePrograma.class, programCode);
		PrePresupuesto presupuesto;
		ConCuenta cuenta;
		for(PreProgramaCuenta proCue:proCuenta)
		{
			cuenta=new ConCuenta();
			cuenta=findAccountByNum(proCue.getConCuenta().getCueNumero());
		    proCue.setConCuenta(cuenta);
		    proCue.setPrePrograma(programa);
		    proCue.setPreTipoProgramaCuenta(entityManager.find(PreTipoProgramaCuenta.class, proCue.getPreTipoProgramaCuenta().getTpcCodigo()));
		    entityManager.persist(proCue);
		    
		    presupuesto=new PrePresupuesto();
		    presupuesto.setConCuenta(cuenta);
		    presupuesto.setPreFecha(CalendarUtil.getTimeNowTimestamp());
		    presupuesto.setPreInicial(true);
		    presupuesto.setPreUltimo(false);
		    if(proCue.getPreTipoProgramaCuenta().getTpcCodigo()==1)
		    {
		    	presupuesto.setPreIngreso(proCue.getPcuValor());
		    	presupuesto.setPreSaldo(proCue.getPcuValor());
		    }
		    else if(proCue.getPreTipoProgramaCuenta().getTpcCodigo()==2)
		    {
		    	presupuesto.setPreEgreso(proCue.getPcuValor());
		    	presupuesto.setPreSaldo(BigDecimal.valueOf(proCue.getPcuValor().doubleValue()*-1));
		    }
		    entityManager.persist(presupuesto);
		}
	}
	
	private ConCuenta findAccountByNum(String num) {

		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<ConCuenta> cq = cb.createQuery(ConCuenta.class);

		Root<ConCuenta> root = cq.from(ConCuenta.class);
		cq.where(cb.equal(root.get("cueNumero"), num));

		List<ConCuenta> list = entityManager.createQuery(cq).getResultList();
		if (list.isEmpty())
			return null;
		else
			return list.get(0);

	}
	
	@Override
	public void reform(PreReforma reform, List<PreReformaDetalle> detail)
	{
		reform.setPreEstado(entityManager.find(PreEstado.class, 1));
		reform.setPreVerificacion(entityManager.find(PreVerificacion.class, 1));
		entityManager.persist(reform);
		entityManager.refresh(reform);
		entityManager.flush();
		for(PreReformaDetalle refDet:detail)
		{
			refDet.setPreReforma(reform);
			refDet.setPreTipoReforma(entityManager.find(PreTipoReforma.class, 1));
			refDet.setConCuenta(entityManager.find(ConCuenta.class,refDet.getConCuenta().getCueCodigo()));
		}
	}

}
