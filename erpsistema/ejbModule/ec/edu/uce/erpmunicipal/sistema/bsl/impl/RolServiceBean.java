package ec.edu.uce.erpmunicipal.sistema.bsl.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

import ec.edu.uce.erpmunicipal.sistema.bsl.RolService;
import ec.edu.uce.erpmunicipal.sistema.orm.SisModulo;
import ec.edu.uce.erpmunicipal.sistema.orm.SisPantalla;
import ec.edu.uce.erpmunicipal.sistema.orm.SisRole;

@Stateless(name = "rolService")
public class RolServiceBean implements RolService {

	@PersistenceContext(name = "erpmunicipalPU", type = PersistenceContextType.TRANSACTION)
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<SisPantalla> readMenu(int rolCode, int moduleCode) {
		Query query = entityManager
				.createQuery("select pan "
						+ "from SisPantalla pan "
						+ "inner join pan.sisModulo mdl "
						+ "inner join pan.sisRolPermisos rpe "
						+ "where rpe.sisRole.rolCodigo=:rolCode and mdl.modCodigo=:moduleCode and pan.panPadre=0 order by pan.panOrden");
		query.setParameter("rolCode", rolCode);
		query.setParameter("moduleCode", moduleCode);
		List<SisPantalla> pantallas = query.getResultList();
		return pantallas;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SisModulo> readModule(int rolCode) {

		Query query = entityManager
				.createQuery("select distinct mdl "
						+ "from SisPantalla pan "
						+ "inner join pan.sisModulo mdl "
						+ "inner join pan.sisRolPermisos rpe "
						+ "where rpe.sisRole.rolCodigo=:rolCode order by mdl.modCodigo");
		query.setParameter("rolCode", rolCode);
		List<SisModulo> modulos = query.getResultList();
		return modulos;
	}

	@Override
	public boolean isFather(int rolCode, int fatherCode) {
		Query query = entityManager
				.createQuery("select pan "
						+ "from SisPantalla pan "
						+ "inner join pan.sisRolPermisos rpe "
						+ "where rpe.sisRole.rolCodigo=:rolCode and pan.panPadre=:fatherCode order by pan.panOrden");
		query.setParameter("rolCode", rolCode);
		query.setParameter("fatherCode", fatherCode);
		if (query.getResultList().size() > 0)
			return true;
		else
			return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SisPantalla> readChildren(int rolCode, int fatherCode) {
		Query query = entityManager
				.createQuery("select pan "
						+ "from SisPantalla pan "
						+ "inner join pan.sisRolPermisos rpe "
						+ "where rpe.sisRole.rolCodigo=:rolCode and pan.panPadre=:fatherCode order by pan.panOrden");
		query.setParameter("rolCode", rolCode);
		query.setParameter("fatherCode", fatherCode);
		List<SisPantalla> pantallas = query.getResultList();
		return pantallas;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SisRole> readAll(int rolCode) {
		Query query;
		if (rolCode > 1)
			query = entityManager.createQuery("from SisRole where rolCodigo>1");
		else
			query = entityManager.createQuery("from SisRole");
		List<SisRole> rols = query.getResultList();
		return rols;
	}

	@Override
	public boolean existsName(String name) {
		Query query = entityManager
				.createNamedQuery("from SisRole rol where rol.rolDescripcion=:name");
		query.setParameter("name", name);
		if (query.getResultList().isEmpty())
			return false;
		else
			return true;
	}

	
}
