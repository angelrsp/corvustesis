package ec.edu.uce.indicadores.ejb.persistence.dao.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.uce.indicadores.ejb.persistence.dao.AccesoDAO;
import ec.edu.uce.indicadores.ejb.persistence.dao.CatalogoDAO;
import ec.edu.uce.indicadores.ejb.persistence.dao.ContactoDAO;
import ec.edu.uce.indicadores.ejb.persistence.dao.EvidenciaDAO;
import ec.edu.uce.indicadores.ejb.persistence.dao.FactoryDAO;
import ec.edu.uce.indicadores.ejb.persistence.dao.HistoricoIndicadorDAO;
import ec.edu.uce.indicadores.ejb.persistence.dao.IesDAO;
import ec.edu.uce.indicadores.ejb.persistence.dao.IndicadorDAO;
import ec.edu.uce.indicadores.ejb.persistence.dao.ModeloDAO;
import ec.edu.uce.indicadores.ejb.persistence.dao.OpcionDAO;
import ec.edu.uce.indicadores.ejb.persistence.dao.ParametroDAO;
import ec.edu.uce.indicadores.ejb.persistence.dao.PerfilDAO;
import ec.edu.uce.indicadores.ejb.persistence.dao.RegistroDAO;
import ec.edu.uce.indicadores.ejb.persistence.dao.RepresentanteLegalDAO;
import ec.edu.uce.indicadores.ejb.persistence.dao.UsuarioDAO;


@Stateless
public class FactoryDAOImpl implements FactoryDAO{
	
	@PersistenceContext(unitName = "indicadoresPU")
	private EntityManager entityManager;

	private UsuarioDAO usuarioDAO;
	
	private RepresentanteLegalDAO representanteLegalDAO;

	private ContactoDAO contactoDAO;
	
	private IesDAO iesDAO;
	
	private ModeloDAO modeloDAO;
	
	private IndicadorDAO indicadorDAO;
	
	private HistoricoIndicadorDAO historicoIndicadorDAO;
	
	private EvidenciaDAO evidenciaDAO;
	
	private RegistroDAO registroDAO;
	
	private CatalogoDAO catalogoDAO;
	
	private PerfilDAO perfilDAO;
	
	private AccesoDAO accesoDAO;
	
	private OpcionDAO opcionDAO;
	
	private ParametroDAO parametroDAO;
	
	@Override
	public UsuarioDAO getUsuarioDAOImpl() {
		if (usuarioDAO == null) {
			usuarioDAO = new UsuarioDAOImpl(entityManager);
		}
		return usuarioDAO;
	}
	
	@Override
	public RepresentanteLegalDAO getRepresentanteLegalDAOImpl() {
		if (representanteLegalDAO == null) {
			representanteLegalDAO = new RepresentanteLegalDAOImpl(entityManager);
		}
		return representanteLegalDAO;
	}

	@Override
	public ContactoDAO getContactoDAOImpl() {
		if (contactoDAO == null) {
			contactoDAO = new ContactoDAOImpl(entityManager);
		}
		return contactoDAO;
	}

	@Override
	public IesDAO getIesDAOImpl() {
		if (iesDAO == null) {
			iesDAO = new IesDAOImpl(entityManager);
		}
		return iesDAO;
	}

	@Override
	public ModeloDAO getModeloDAOImpl() {
		if (modeloDAO == null) {
			modeloDAO = new ModeloDAOImpl(entityManager);
		}
		return modeloDAO;
	}
	
	@Override
	public IndicadorDAO getIndicadorDAOImpl() {
		if (indicadorDAO == null) {
			indicadorDAO = new IndicadorDAOImpl(entityManager);
		}
		return indicadorDAO;
	}
	
	
	@Override
	public HistoricoIndicadorDAO getHistoricoIndicadorDAOImpl() {
		if (historicoIndicadorDAO == null) {
			historicoIndicadorDAO = new HistoricoIndicadorDAOImpl(entityManager);
		}
		return historicoIndicadorDAO;
	}	
	
	@Override
	public EvidenciaDAO getEvidenciaDAOImpl() {
		if (evidenciaDAO == null) {
			evidenciaDAO = new EvidenciaDAOImpl(entityManager);
		}
		return evidenciaDAO;
	}	
	
	@Override
	public RegistroDAO getRegistroDAOImpl() {
		if (registroDAO == null) {
			registroDAO = new RegistroDAOImpl(entityManager);
		}
		return registroDAO;
	}

	@Override
	public CatalogoDAO getCatalogoImpl() {
		if (catalogoDAO == null) {
			catalogoDAO = new CatalogoDAOImpl(entityManager);
		}
		return catalogoDAO;
	}	
	
	@Override
	public PerfilDAO getPerfilDAOImpl() {
		if (perfilDAO == null) {
			perfilDAO = new PerfilDAOImpl(entityManager);
		}
		return perfilDAO;
	}
	
	@Override
	public AccesoDAO getAccesoDAOImpl() {
		if (accesoDAO == null) {
			accesoDAO = new AccesoDAOImpl(entityManager);
		}
		return accesoDAO;
	}
	
	@Override
	public OpcionDAO getOpcionDAOImpl() {
		if (opcionDAO == null) {
			opcionDAO = new OpcionDAOImpl(entityManager);
		}
		return opcionDAO;
	}
	
	@Override
	public ParametroDAO getParametroDAOImpl() {
		if (parametroDAO == null) {
			parametroDAO = new ParametroDAOImpl(entityManager);
		}
		return parametroDAO;
	}

}
