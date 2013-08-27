package ec.edu.uce.inventario.sistema.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

import ec.edu.uce.inventario.entidades.SisModulo;
import ec.edu.uce.inventario.entidades.SisOpcion;
import ec.edu.uce.inventario.entidades.SisPerfil;
import ec.edu.uce.inventario.entidades.SisPerfilOpcion;
import ec.edu.uce.inventario.sistema.servicio.PerfilOpcionService;

@Stateless(name = "perfilOpcionService")
public class PerfilOpcionServiceBean implements PerfilOpcionService {

	@PersistenceContext(name = "inventarioPU", type = PersistenceContextType.TRANSACTION)
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
    @Override
    public List<SisOpcion> readOptions(int perfilCode, int moduleCode) {
        Query query = entityManager.createNativeQuery("select * "
                + "from sis_opcion a " + "left join sis_perfil_opcion b "
                + "on a.opc_codigo=b.pop_opcion and b.pop_perfil=" + perfilCode
                + " where a.opc_padre=0 and a.opc_modulo=" + moduleCode
                + " order by a.opc_padre");

        List<Object[]> lista = query.getResultList();

        List<SisOpcion> options = new ArrayList<SisOpcion>();

        for (Object[] listaTemp : lista) {
            SisOpcion option = new SisOpcion();
            SisModulo module = new SisModulo();
            List<SisPerfilOpcion> roleP = new ArrayList<SisPerfilOpcion>();
            SisPerfilOpcion roleObj = new SisPerfilOpcion();
            option.setOpcCodigo((Integer) listaTemp[0]);
            module.setModCodigo((Integer) listaTemp[1]);
            option.setSisModulo(module);
            option.setOpcNombre((String) listaTemp[2]);
            option.setOpcUrl((String) listaTemp[3]);
            option.setOpcOrden((Integer) listaTemp[4]);
            option.setOpcPadre((Integer) listaTemp[5]);
            roleObj.setPopCodigo(listaTemp[6] != null ? (Integer) listaTemp[6]
                    : 0);
            roleP.add(roleObj);
            option.setSisPerfilOpcions(roleP);
            options.add(option);
        }

        return options;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<SisModulo> readModules() {
        Query query = entityManager.createQuery("select distinct mdl from SisOpcion opc inner join opc.sisModulo mdl order by mdl.modCodigo");
        List<SisModulo> modulos = query.getResultList();
        return modulos;
    }
   
    @Override
    public Boolean isFather(int fatherCode)
    {
        Query query = entityManager
                .createQuery("select opc "
                        + "from SisOpcion opc "
                        + "where opc.opcPadre=:fatherCode order by opc.opcOrden");
        query.setParameter("fatherCode", fatherCode);
        if (query.getResultList().size() > 0)
            return true;
        else
            return false;
    }
   
    @SuppressWarnings("unchecked")
    @Override
    public List<SisOpcion> readChildren(int perfilCode, int moduleCode, int father) {
        Query query = entityManager.createNativeQuery("select * "
                + "from sis_opcion a " + "left join sis_perfil_opcion b "
                + "on a.opc_codigo=b.pop_opcion and b.pop_perfil=" + perfilCode
                + " where a.opc_padre="+father+" and a.opc_modulo=" + moduleCode
                + " order by a.opc_padre");

        List<Object[]> lista = query.getResultList();

        List<SisOpcion> options = new ArrayList<SisOpcion>();

        for (Object[] listaTemp : lista) {
            SisOpcion option = new SisOpcion();
            SisModulo module = new SisModulo();
            List<SisPerfilOpcion> roleP = new ArrayList<SisPerfilOpcion>();
            SisPerfilOpcion roleObj = new SisPerfilOpcion();
            option.setOpcCodigo((Integer) listaTemp[0]);
            module.setModCodigo((Integer) listaTemp[1]);
            option.setSisModulo(module);
            option.setOpcNombre((String) listaTemp[2]);
            option.setOpcUrl((String) listaTemp[3]);
            option.setOpcOrden((Integer) listaTemp[4]);
            option.setOpcPadre((Integer) listaTemp[5]);
            roleObj.setPopCodigo(listaTemp[6] != null ? (Integer) listaTemp[6]
                    : 0);
            roleP.add(roleObj);
            option.setSisPerfilOpcions(roleP);
            options.add(option);
        }

        return options;
    }

    @Override   
    public Boolean update(Integer option, Integer perfil, Boolean insert) {
        Query query = entityManager
                .createQuery("from SisPerfilOpcion rp where rp.sisOpcion.opcCodigo=:option and rp.sisPerfil.prlCodigo=:perfil");
        query.setParameter("option", option);
        query.setParameter("perfil", perfil);

        SisPerfilOpcion rolPermiso = new SisPerfilOpcion();
        SisOpcion op = new SisOpcion();
        SisPerfil ro = new SisPerfil();

        op.setOpcCodigo(option);
        ro.setPrlCodigo(perfil);

        rolPermiso.setSisOpcion(op);
        rolPermiso.setSisPerfil(ro);

        if (!query.getResultList().isEmpty()) {
            rolPermiso=(SisPerfilOpcion) query.getSingleResult();
            if (!insert)
                entityManager.remove(rolPermiso);
        } else {
            if (insert)
                entityManager.persist(rolPermiso);
        }
        return true;
    }
}
