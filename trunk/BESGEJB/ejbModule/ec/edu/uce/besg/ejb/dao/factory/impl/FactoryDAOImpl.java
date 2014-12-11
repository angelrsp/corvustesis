package ec.edu.uce.besg.ejb.dao.factory.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.uce.besg.ejb.dao.factory.FactoryDAO;
import ec.edu.uce.besg.ejb.persistence.dao.CatalogoDAO;
import ec.edu.uce.besg.ejb.persistence.dao.ContactoDAO;
import ec.edu.uce.besg.ejb.persistence.dao.EmpresaDAO;
import ec.edu.uce.besg.ejb.persistence.dao.UsuarioDAO;
import ec.edu.uce.besg.ejb.persistence.dao.impl.CatalogoDAOImpl;
import ec.edu.uce.besg.ejb.persistence.dao.impl.ContactoDAOImpl;
import ec.edu.uce.besg.ejb.persistence.dao.impl.EmpresaDAOImpl;
import ec.edu.uce.besg.ejb.persistence.dao.impl.UsuarioDAOImpl;

@Stateless
public class FactoryDAOImpl implements FactoryDAO {

	@PersistenceContext(unitName = "besgPU")
	private EntityManager entityManager;

	private UsuarioDAO usuarioDAO;
	private CatalogoDAO catalogoDAO;
	/*private CandidatoDAO candidatoDAO;
	private AvisoDAO avisoDAO;
	private PerfilDAO perfilDAO;
	private CatalogoDAO catalogoDAO;
	private EstudioDAO estudioDAO;
	private ExperienciaDAO experienciaDAO;
	private ReferenciaDAO referenciaDAO;
	private EmpresaDAO empresaDAO;
	private PostulacionDAO postulacionDAO;
	private ResultadoDAO resultadoDAO;
	private PreguntaDAO preguntaDAO;
	private RespuestaDAO respuestaDAO;
	private CursoDAO cursoDAO;
	private AdicionalDAO adicionalDAO;
	private ParametroDAO parametroDAO;
*/
		private ContactoDAO contactoDAO;
		private EmpresaDAO empresaDAO;
	
	@Override
	public UsuarioDAO getUsuarioDAOImpl() {
		if (usuarioDAO == null) {
			usuarioDAO = new UsuarioDAOImpl(entityManager);
		}
		return usuarioDAO;
	}

	/*@Override
	public CandidatoDAO getCandidatoDAOImpl() {
		if (candidatoDAO == null) {
			candidatoDAO = new CandidatoDAOImpl(entityManager);
		}
		return candidatoDAO;
	}

	@Override
	public AvisoDAO getAvisoDAOImpl() {
		if (avisoDAO == null) {
			avisoDAO = new AvisoDAOImpl(entityManager);
		}
		return avisoDAO;
	}

	@Override
	public PerfilDAO getPerfilDAOImpl() {
		if (perfilDAO == null) {
			perfilDAO = new PerfilDAOImpl(entityManager);
		}
		return perfilDAO;
	}
*/
	@Override
	public CatalogoDAO getCatalogoDAOImpl() {
		if (catalogoDAO == null) {
			catalogoDAO = new CatalogoDAOImpl(entityManager);
		}
		return catalogoDAO;
	}
/*
	@Override
	public EstudioDAO getEstudioDAOImpl() {
		if (estudioDAO == null) {
			estudioDAO = new EstudioDAOImpl(entityManager);
		}
		return estudioDAO;
	}

	@Override
	public ExperienciaDAO getExperienciaDAOImpl() {
		if (experienciaDAO == null) {
			experienciaDAO = new ExperienciaDAOImpl(entityManager);
		}
		return experienciaDAO;
	}

	@Override
	public ReferenciaDAO getReferenciaDAOImpl() {
		if (referenciaDAO == null) {
			referenciaDAO = new ReferenciaDAOImpl(entityManager);
		}
		return referenciaDAO;
	}
*/
	@Override
	public EmpresaDAO getEmpresaDAOImpl() {
		if (empresaDAO == null) {
			empresaDAO = new EmpresaDAOImpl(entityManager);
		}
		return empresaDAO;
	}

	@Override
	public ContactoDAO getContactoDAOImpl() {
		if (contactoDAO == null) {
			contactoDAO = new ContactoDAOImpl(entityManager);
		}
		return contactoDAO;
	}
	
	/*
	@Override
	public PostulacionDAO getPostulacionDAOImpl() {
		if (postulacionDAO == null) {
			postulacionDAO = new PostulacionDAOImpl(entityManager);
		}
		return postulacionDAO;
	}

	
	
	@Override
	public ResultadoDAO getResultadoDAOImpl() {
		if (resultadoDAO == null) {
			resultadoDAO = new ResultadoDAOImpl(entityManager);
		}
		return resultadoDAO;
	}
	
	@Override
	public PreguntaDAO getPreguntaDAOImpl() {
		if (preguntaDAO == null) {
			preguntaDAO = new PreguntaDAOImpl(entityManager);
		}
		return preguntaDAO;
	}
	
	@Override
	public RespuestaDAO getRespuestaDAOImpl() {
		if (respuestaDAO == null) {
			respuestaDAO = new RespuestaDAOImpl(entityManager);
		}
		return respuestaDAO;
	}

	@Override
	public CursoDAO getCursoDAOImpl() {
		if (cursoDAO == null) {
			cursoDAO = new CursoDAOImpl(entityManager);
		}
		return cursoDAO;
	}
	
	@Override
	public AdicionalDAO getAdicionalDAOImpl() {
		if (adicionalDAO == null) {
			adicionalDAO = new AdicionalDAOImpl(entityManager);
		}
		return adicionalDAO;
	}
	
	@Override
	public ParametroDAO getParametroDAOImpl() {
		if (parametroDAO == null) {
			parametroDAO = new ParametroDAOImpl(entityManager);
		}
		return parametroDAO;
	}*/
}
