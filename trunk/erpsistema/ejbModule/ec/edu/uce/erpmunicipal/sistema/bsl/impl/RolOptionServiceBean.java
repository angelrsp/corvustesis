package ec.edu.uce.erpmunicipal.sistema.bsl.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

import ec.edu.uce.erpmunicipal.sistema.bsl.RolOptionService;
import ec.edu.uce.erpmunicipal.sistema.orm.SisModulo;
import ec.edu.uce.erpmunicipal.sistema.orm.SisPantalla;
import ec.edu.uce.erpmunicipal.sistema.orm.SisRolPermiso;
import ec.edu.uce.erpmunicipal.sistema.orm.SisRole;

@Stateless(name = "rolOptionService")
public class RolOptionServiceBean implements RolOptionService {

	@PersistenceContext(name = "erpmunicipalPU", type = PersistenceContextType.TRANSACTION)
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<SisPantalla> readOptions(int rolCode, int moduleCode) {
		Query query = entityManager.createNativeQuery("select * "
				+ "from sis_pantalla a " + "left join sis_rol_permiso b "
				+ "on a.pan_codigo=b.rop_pantalla and b.rop_rol=" + rolCode
				+ " where a.pan_padre=0 and a.pan_modulo=" + moduleCode
				+ " order by a.pan_padre");

		List<Object[]> lista = query.getResultList();

		List<SisPantalla> options = new ArrayList<SisPantalla>();

		for (Object[] listaTemp : lista) {
			SisPantalla option = new SisPantalla();
			SisModulo module = new SisModulo();
			List<SisRolPermiso> roleP = new ArrayList<SisRolPermiso>();
			SisRolPermiso roleObj = new SisRolPermiso();
			option.setPanCodigo((Integer) listaTemp[0]);
			module.setModCodigo((Integer) listaTemp[1]);
			option.setSisModulo(module);
			option.setPanDescripcion((String) listaTemp[2]);
			option.setPanUrl((String) listaTemp[3]);
			option.setPanOrden((Integer) listaTemp[4]);
			option.setPanPadre((Integer) listaTemp[5]);
			roleObj.setRopCodigo(listaTemp[6] != null ? (Integer) listaTemp[6]
					: 0);
			roleP.add(roleObj);
			option.setSisRolPermisos(roleP);
			options.add(option);
		}

		return options;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SisModulo> readModules() {
		Query query = entityManager.createQuery("select distinct mdl from SisPantalla pan inner join pan.sisModulo mdl order by mdl.modCodigo");
		List<SisModulo> modulos = query.getResultList();
		return modulos;
	}
	
	@Override
	public Boolean isFather(int fatherCode)
	{
		Query query = entityManager
				.createQuery("select pan "
						+ "from SisPantalla pan "
						+ "where pan.panPadre=:fatherCode order by pan.panOrden");
		query.setParameter("fatherCode", fatherCode);
		if (query.getResultList().size() > 0)
			return true;
		else
			return false;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<SisPantalla> readChildren(int rolCode, int moduleCode, int father) {
		Query query = entityManager.createNativeQuery("select * "
				+ "from sis_pantalla a " + "left join sis_rol_permiso b "
				+ "on a.pan_codigo=b.rop_pantalla and b.rop_rol=" + rolCode
				+ " where a.pan_padre="+father+" and a.pan_modulo=" + moduleCode
				+ " order by a.pan_padre");

		List<Object[]> lista = query.getResultList();

		List<SisPantalla> options = new ArrayList<SisPantalla>();

		for (Object[] listaTemp : lista) {
			SisPantalla option = new SisPantalla();
			SisModulo module = new SisModulo();
			List<SisRolPermiso> roleP = new ArrayList<SisRolPermiso>();
			SisRolPermiso roleObj = new SisRolPermiso();
			option.setPanCodigo((Integer) listaTemp[0]);
			module.setModCodigo((Integer) listaTemp[1]);
			option.setSisModulo(module);
			option.setPanDescripcion((String) listaTemp[2]);
			option.setPanUrl((String) listaTemp[3]);
			option.setPanOrden((Integer) listaTemp[4]);
			option.setPanPadre((Integer) listaTemp[5]);
			roleObj.setRopCodigo(listaTemp[6] != null ? (Integer) listaTemp[6]
					: 0);
			roleP.add(roleObj);
			option.setSisRolPermisos(roleP);
			options.add(option);
		}

		return options;
	}

	@Override	
	public Boolean update(Integer option, Integer role, Boolean insert) {
		Query query = entityManager
				.createQuery("from SisRolPermiso rp where rp.sisPantalla.panCodigo=:option and rp.sisRole.rolCodigo=:role");
		query.setParameter("option", option);
		query.setParameter("role", role);

		SisRolPermiso rolPermiso = new SisRolPermiso();
		SisPantalla op = new SisPantalla();
		SisRole ro = new SisRole();

		op.setPanCodigo(option);
		ro.setRolCodigo(role);

		rolPermiso.setSisPantalla(op);
		rolPermiso.setSisRole(ro);

		if (!query.getResultList().isEmpty()) {
			rolPermiso=(SisRolPermiso) query.getSingleResult();
			if (!insert)
				entityManager.remove(rolPermiso);
		} else {
			if (insert)
			{
				entityManager.persist(rolPermiso);
			}
		}
		return true;
	}
	
//	public Boolean fatherChecked(SisPantalla pan)
	//{
		
		//return null;
	//}
}
