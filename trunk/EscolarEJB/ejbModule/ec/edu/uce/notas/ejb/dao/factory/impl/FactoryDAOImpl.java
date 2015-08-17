package ec.edu.uce.notas.ejb.dao.factory.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.uce.notas.ejb.dao.factory.FactoryDAO;
import ec.edu.uce.notas.ejb.persistence.dao.AccesoDAO;
import ec.edu.uce.notas.ejb.persistence.dao.AccesoViewDAO;
import ec.edu.uce.notas.ejb.persistence.dao.AlumnoDAO;
import ec.edu.uce.notas.ejb.persistence.dao.AlumnoViewDAO;
import ec.edu.uce.notas.ejb.persistence.dao.CatalogoDAO;
import ec.edu.uce.notas.ejb.persistence.dao.ComponenteDAO;
import ec.edu.uce.notas.ejb.persistence.dao.ComponenteMenuDAO;
import ec.edu.uce.notas.ejb.persistence.dao.ComponenteMenuViewDAO;
import ec.edu.uce.notas.ejb.persistence.dao.CursoDAO;
import ec.edu.uce.notas.ejb.persistence.dao.DocenteDAO;
import ec.edu.uce.notas.ejb.persistence.dao.DocenteViewDAO;
import ec.edu.uce.notas.ejb.persistence.dao.EvidenciaDAO;
import ec.edu.uce.notas.ejb.persistence.dao.HistorialPasswordDAO;
import ec.edu.uce.notas.ejb.persistence.dao.HistoricoIndicadorDAO;
import ec.edu.uce.notas.ejb.persistence.dao.IndicadorDAO;
import ec.edu.uce.notas.ejb.persistence.dao.MateriaDAO;
import ec.edu.uce.notas.ejb.persistence.dao.MenuDAO;
import ec.edu.uce.notas.ejb.persistence.dao.MenuViewDAO;
import ec.edu.uce.notas.ejb.persistence.dao.ModeloDAO;
import ec.edu.uce.notas.ejb.persistence.dao.PerfilDAO;
import ec.edu.uce.notas.ejb.persistence.dao.UsuarioDAO;
import ec.edu.uce.notas.ejb.persistence.dao.UsuarioPerfilDAO;
import ec.edu.uce.notas.ejb.persistence.dao.UsuarioViewDAO;
import ec.edu.uce.notas.ejb.persistence.dao.impl.AccesoDAOImpl;
import ec.edu.uce.notas.ejb.persistence.dao.impl.AccesoViewDAOImpl;
import ec.edu.uce.notas.ejb.persistence.dao.impl.AlumnoDAOImpl;
import ec.edu.uce.notas.ejb.persistence.dao.impl.AlumnoViewDAOImpl;
import ec.edu.uce.notas.ejb.persistence.dao.impl.CatalogoDAOImpl;
import ec.edu.uce.notas.ejb.persistence.dao.impl.ComponenteDAOImpl;
import ec.edu.uce.notas.ejb.persistence.dao.impl.ComponenteMenuDAOImpl;
import ec.edu.uce.notas.ejb.persistence.dao.impl.ComponenteMenuViewDAOImpl;
import ec.edu.uce.notas.ejb.persistence.dao.impl.CursoDAOImpl;
import ec.edu.uce.notas.ejb.persistence.dao.impl.DocenteDAOImpl;
import ec.edu.uce.notas.ejb.persistence.dao.impl.DocenteViewDAOImpl;
import ec.edu.uce.notas.ejb.persistence.dao.impl.EvidenciaDAOImpl;
import ec.edu.uce.notas.ejb.persistence.dao.impl.HistorialPasswordDAOImpl;
import ec.edu.uce.notas.ejb.persistence.dao.impl.HistoricoIndicadorDAOImpl;
import ec.edu.uce.notas.ejb.persistence.dao.impl.IndicadorDAOImpl;
import ec.edu.uce.notas.ejb.persistence.dao.impl.MateriaDAOImpl;
import ec.edu.uce.notas.ejb.persistence.dao.impl.MenuDAOImpl;
import ec.edu.uce.notas.ejb.persistence.dao.impl.MenuViewDAOImpl;
import ec.edu.uce.notas.ejb.persistence.dao.impl.ModeloDAOImpl;
import ec.edu.uce.notas.ejb.persistence.dao.impl.PerfilDAOImpl;
import ec.edu.uce.notas.ejb.persistence.dao.impl.UsuarioDAOImpl;
import ec.edu.uce.notas.ejb.persistence.dao.impl.UsuarioPerfilDAOImpl;
import ec.edu.uce.notas.ejb.persistence.dao.impl.UsuarioViewDAOImpl;

@Stateless
public class FactoryDAOImpl implements FactoryDAO {

	@PersistenceContext(unitName = "notasPU")
	private EntityManager entityManager;

	private UsuarioDAO usuarioDAO;
	

	private PerfilDAO perfilDAO;
	private MenuDAO menuDAO;
	private MenuViewDAO menuViewDAO;
	private ComponenteDAO componenteDAO;
	private ComponenteMenuDAO componenteMenuDAO;
	private ComponenteMenuViewDAO componenteMenuViewDAO;
	private AccesoDAO accesoDAO;
	private AccesoViewDAO accesoViewDAO;
	private UsuarioPerfilDAO usuarioPerfilDAO;
	private HistorialPasswordDAO historialPasswordDAO;
	private UsuarioViewDAO usuarioViewDAO;

	
	private DocenteDAO docenteDAO;
	private DocenteViewDAO docenteViewDAO;
	private AlumnoDAO alumnoDAO;
	private AlumnoViewDAO alumnoViewDAO;
	private CursoDAO cursoDAO;
	private MateriaDAO materiaDAO;
	
	private ModeloDAO modeloDAO;
	private IndicadorDAO indicadorDAO;
	private HistoricoIndicadorDAO historicoIndicadorDAO;
	private EvidenciaDAO evidenciaDAO;
	private CatalogoDAO catalogoDAO;
		

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
	public CatalogoDAO getCatalogoDAOImpl() {
		if (catalogoDAO == null) {
			catalogoDAO = new CatalogoDAOImpl(entityManager);
		}
		return catalogoDAO;
	}	

	@Override
	public UsuarioDAO getUsuarioDAOImpl() {
		if (usuarioDAO == null) {
			usuarioDAO = new UsuarioDAOImpl(entityManager);
		}
		return usuarioDAO;
	}	

	@Override
	public DocenteDAO getDocenteDAOImpl() {
		if (docenteDAO == null) {
			docenteDAO = new DocenteDAOImpl(entityManager);
		}
		return docenteDAO;
	}	

	@Override
	public DocenteViewDAO getDocenteViewDAOImpl() {
		if (docenteViewDAO == null) {
			docenteViewDAO = new DocenteViewDAOImpl(entityManager);
		}
		return docenteViewDAO;
	}	

	@Override
	public PerfilDAO getPerfilDAOImpl() {
		if (perfilDAO == null) {
			perfilDAO = new PerfilDAOImpl(entityManager);
		}
		return perfilDAO;
	}

	@Override
	public MenuDAO getMenuDAOImpl() {
		if (menuDAO == null) {
			menuDAO = new MenuDAOImpl(entityManager);
		}
		return menuDAO;
	}

	@Override
	public MenuViewDAO getMenuViewDAOImpl() {
		if (menuViewDAO == null) {
			menuViewDAO = new MenuViewDAOImpl(entityManager);
		}
		return menuViewDAO;
	}

	@Override
	public ComponenteDAO getComponenteDAOImpl() {
		if (componenteDAO == null) {
			componenteDAO = new ComponenteDAOImpl(entityManager);
		}
		return componenteDAO;
	}

	@Override
	public ComponenteMenuDAO getComponenteMenuDAOImpl() {
		if (componenteMenuDAO == null) {
			componenteMenuDAO = new ComponenteMenuDAOImpl(entityManager);
		}
		return componenteMenuDAO;
	}
	
	@Override
	public ComponenteMenuViewDAO getComponenteMenuViewDAOImpl() {
		if (componenteMenuViewDAO == null) {
			componenteMenuViewDAO = new ComponenteMenuViewDAOImpl(entityManager);
		}
		return componenteMenuViewDAO;
	}

	@Override
	public AccesoDAO getAccesoDAOImpl() {
		if (accesoDAO == null) {
			accesoDAO = new AccesoDAOImpl(entityManager);
		}
		return accesoDAO;
	}
	
	@Override
	public AccesoViewDAO getAccesoViewDAOImpl() {
		if (accesoViewDAO == null) {
			accesoViewDAO = new AccesoViewDAOImpl(entityManager);
		}
		return accesoViewDAO;
	}

	@Override
	public UsuarioPerfilDAO getUsuarioPerfilDAOImpl() {
		if (usuarioPerfilDAO == null) {
			usuarioPerfilDAO = new UsuarioPerfilDAOImpl(entityManager);
		}
		return usuarioPerfilDAO;
	}
	
	@Override
	public HistorialPasswordDAO getHistorialPasswordDAOImpl() {
		if (historialPasswordDAO == null) {
			historialPasswordDAO = new HistorialPasswordDAOImpl(entityManager);
		}
		return historialPasswordDAO;
	}
	
	@Override
	public UsuarioViewDAO getUsuarioViewDAOImpl() {
		if (usuarioViewDAO == null) {
			usuarioViewDAO = new UsuarioViewDAOImpl(entityManager);
		}
		return usuarioViewDAO;
	}

	@Override
	public AlumnoDAO getAlumnoDAOImpl() {
		if (alumnoDAO == null) {
			alumnoDAO = new AlumnoDAOImpl(entityManager);
		}
		return alumnoDAO;
	}

	@Override
	public AlumnoViewDAO getAlumnoViewDAOImpl() {
		if (alumnoViewDAO == null) {
			alumnoViewDAO = new AlumnoViewDAOImpl(entityManager);
		}
		return alumnoViewDAO;
	}

	@Override
	public CursoDAO getCursoDAOImpl() {
		if (cursoDAO == null) {
			cursoDAO = new CursoDAOImpl(entityManager);
		}
		return cursoDAO;
	}
	
	@Override
	public MateriaDAO getMateriaDAOImpl() {
		if (materiaDAO == null) {
			materiaDAO = new MateriaDAOImpl(entityManager);
		}
		return materiaDAO;
	}
}
