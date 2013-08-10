package ec.edu.uce.inventario.sistema.servicio.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

import ec.edu.uce.inventario.entidades.SisModulo;
import ec.edu.uce.inventario.entidades.SisOpcion;
import ec.edu.uce.inventario.entidades.SisPerfil;
import ec.edu.uce.inventario.sistema.servicio.PerfilService;

@Stateless(name = "perfilService")
public class PerfilServiceBean implements PerfilService {

	@PersistenceContext(name = "inventarioPU", type = PersistenceContextType.TRANSACTION)
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<SisOpcion> readMenu(int perfilCode, int moduleCode) {
		Query query = entityManager
				.createQuery("select opc from SisOpcion opc "
						+ "inner join opc.sisModulo mdl "
						+ "inner join opc.sisPerfilOpcions pop "
						+ "where pop.sisPerfil.prlCodigo=:perfilCode and mdl.modCodigo=:moduleCode and opc.opcPadre=0 order by opc.opcOrden");
		query.setParameter("perfilCode", perfilCode);
		query.setParameter("moduleCode", moduleCode);
		List<SisOpcion> pantallas = query.getResultList();
		return pantallas;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SisModulo> readModule(int perfilCode) {

		Query query = entityManager
				.createQuery("select distinct mdl "
						+ "from SisOpcion opc "
						+ "inner join opc.sisModulo mdl "
						+ "inner join opc.sisPerfilOpcions pop "
						+ "where pop.sisPerfil.prlCodigo=:perfilCode order by mdl.modCodigo");
		query.setParameter("perfilCode", perfilCode);
		List<SisModulo> modulos = query.getResultList();
		return modulos;
	}

	@Override
	public boolean isFather(int perfilCode, int fatherCode) {
		Query query = entityManager
				.createQuery("select opc "
						+ "from SisOpcion opc "
						+ "inner join opc.sisPerfilOpcions pop "
						+ "where pop.sisPerfil.prlCodigo=:perfilCode and opc.opcPadre=:fatherCode order by opc.opcOrden");
		query.setParameter("perfilCode", perfilCode);
		query.setParameter("fatherCode", fatherCode);
		if (query.getResultList().size() > 0)
			return true;
		else
			return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SisOpcion> readChildren(int perfilCode, int fatherCode) {
		Query query = entityManager
				.createQuery("select opc "
						+ "from SisOpcion opc "
						+ "inner join opc.sisPerfilOpcions pop "
						+ "where pop.sisPerfil.prlCodigo=:perfilCode and opc.opcPadre=:fatherCode order by opc.opcOrden");
		query.setParameter("perfilCode", perfilCode);
		query.setParameter("fatherCode", fatherCode);
		List<SisOpcion> pantallas = query.getResultList();
		return pantallas;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SisPerfil> readAll() {
		Query query;
		query = entityManager.createQuery("from SisPerfil");
		List<SisPerfil> rols = query.getResultList();
		return rols;
	}

	@Override
	public boolean existsName(String name) {
		Query query = entityManager
				.createQuery("from SisPerfil per where per.prlDescripcion=:name");
		query.setParameter("name", name);
		if (query.getResultList().isEmpty())
			return false;
		else
			return true;
	}
}
