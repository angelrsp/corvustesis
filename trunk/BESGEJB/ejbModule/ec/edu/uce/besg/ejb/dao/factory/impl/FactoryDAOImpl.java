package ec.edu.uce.besg.ejb.dao.factory.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.uce.besg.ejb.dao.factory.FactoryDAO;
import ec.edu.uce.besg.ejb.persistence.dao.AvisoDAO;
import ec.edu.uce.besg.ejb.persistence.dao.AvisoPostulacionViewDAO;
import ec.edu.uce.besg.ejb.persistence.dao.AvisoViewDAO;
import ec.edu.uce.besg.ejb.persistence.dao.CandidatoDAO;
import ec.edu.uce.besg.ejb.persistence.dao.CandidatoPostulacionViewDAO;
import ec.edu.uce.besg.ejb.persistence.dao.CatalogoDAO;
import ec.edu.uce.besg.ejb.persistence.dao.CategoriaDAO;
import ec.edu.uce.besg.ejb.persistence.dao.ContactoDAO;
import ec.edu.uce.besg.ejb.persistence.dao.ControlDAO;
import ec.edu.uce.besg.ejb.persistence.dao.CuestionarioViewDAO;
import ec.edu.uce.besg.ejb.persistence.dao.EmpresaDAO;
import ec.edu.uce.besg.ejb.persistence.dao.EncuestaDAO;
import ec.edu.uce.besg.ejb.persistence.dao.ExperienciaDAO;
import ec.edu.uce.besg.ejb.persistence.dao.HabilidadDAO;
import ec.edu.uce.besg.ejb.persistence.dao.HabilidadViewDAO;
import ec.edu.uce.besg.ejb.persistence.dao.HistorialPasswordDAO;
import ec.edu.uce.besg.ejb.persistence.dao.PostulacionDAO;
import ec.edu.uce.besg.ejb.persistence.dao.PreguntaDAO;
import ec.edu.uce.besg.ejb.persistence.dao.ReferenciaDAO;
import ec.edu.uce.besg.ejb.persistence.dao.RespuestaDAO;
import ec.edu.uce.besg.ejb.persistence.dao.ResultadoDAO;
import ec.edu.uce.besg.ejb.persistence.dao.ResultadoViewDAO;
import ec.edu.uce.besg.ejb.persistence.dao.UsuarioDAO;
import ec.edu.uce.besg.ejb.persistence.dao.impl.AvisoDAOImpl;
import ec.edu.uce.besg.ejb.persistence.dao.impl.AvisoPostulacionViewDAOImpl;
import ec.edu.uce.besg.ejb.persistence.dao.impl.AvisoViewDAOImpl;
import ec.edu.uce.besg.ejb.persistence.dao.impl.CandidatoDAOImpl;
import ec.edu.uce.besg.ejb.persistence.dao.impl.CandidatoPostulacionViewDAOImpl;
import ec.edu.uce.besg.ejb.persistence.dao.impl.CatalogoDAOImpl;
import ec.edu.uce.besg.ejb.persistence.dao.impl.CategoriaDAOImpl;
import ec.edu.uce.besg.ejb.persistence.dao.impl.ContactoDAOImpl;
import ec.edu.uce.besg.ejb.persistence.dao.impl.ControlDAOImpl;
import ec.edu.uce.besg.ejb.persistence.dao.impl.CuestionarioViewDAOImpl;
import ec.edu.uce.besg.ejb.persistence.dao.impl.EmpresaDAOImpl;
import ec.edu.uce.besg.ejb.persistence.dao.impl.EncuestaDAOImpl;
import ec.edu.uce.besg.ejb.persistence.dao.impl.ExperienciaDAOImpl;
import ec.edu.uce.besg.ejb.persistence.dao.impl.HabilidadDAOImpl;
import ec.edu.uce.besg.ejb.persistence.dao.impl.HabilidadViewDAOImpl;
import ec.edu.uce.besg.ejb.persistence.dao.impl.HistorialPasswordDAOImpl;
import ec.edu.uce.besg.ejb.persistence.dao.impl.PostulacionDAOImpl;
import ec.edu.uce.besg.ejb.persistence.dao.impl.PreguntaDAOImpl;
import ec.edu.uce.besg.ejb.persistence.dao.impl.ReferenciaDAOImpl;
import ec.edu.uce.besg.ejb.persistence.dao.impl.RespuestaDAOImpl;
import ec.edu.uce.besg.ejb.persistence.dao.impl.ResultadoDAOImpl;
import ec.edu.uce.besg.ejb.persistence.dao.impl.ResultadoViewDAOImpl;
import ec.edu.uce.besg.ejb.persistence.dao.impl.UsuarioDAOImpl;

@Stateless
public class FactoryDAOImpl implements FactoryDAO {

	@PersistenceContext(unitName = "besgPU")
	private EntityManager entityManager;

	private UsuarioDAO usuarioDAO;
	private CatalogoDAO catalogoDAO;
	private CandidatoDAO candidatoDAO;
	private HabilidadDAO habilidadDAO;
	private HabilidadViewDAO habilidadViewDAO;
	private ExperienciaDAO experienciaDAO;
	private ReferenciaDAO referenciaDAO;

	private ContactoDAO contactoDAO;
	private EmpresaDAO empresaDAO;
	
	private HistorialPasswordDAO historialPasswordDAO;
	private AvisoDAO avisoDAO;
	private AvisoViewDAO avisoViewDAO;
	private AvisoPostulacionViewDAO avisoPostulacionViewDAO;
	private PostulacionDAO postulacionDAO;
	private CandidatoPostulacionViewDAO candidatoPostulacionViewDAO;
	
	private CuestionarioViewDAO cuestionarioViewDAO;
	private PreguntaDAO preguntaDAO;
	private EncuestaDAO encuestaDAO;
	private CategoriaDAO categoriaDAO;
	private ControlDAO controlDAO;
	private RespuestaDAO respuestaDAO;
	private ResultadoDAO resultadoDAO;
	private ResultadoViewDAO resultadoViewDAO;
	
	@Override
	public UsuarioDAO getUsuarioDAOImpl() {
		if (usuarioDAO == null) {
			usuarioDAO = new UsuarioDAOImpl(entityManager);
		}
		return usuarioDAO;
	}

	@Override
	public CandidatoDAO getCandidatoDAOImpl() {
		if (candidatoDAO == null) {
			candidatoDAO = new CandidatoDAOImpl(entityManager);
		}
		return candidatoDAO;
	}
	
	@Override
	public CatalogoDAO getCatalogoDAOImpl() {
		if (catalogoDAO == null) {
			catalogoDAO = new CatalogoDAOImpl(entityManager);
		}
		return catalogoDAO;
	}

	@Override
	public HabilidadDAO getHabilidadDAOImpl() {
		if (habilidadDAO == null) {
			habilidadDAO = new HabilidadDAOImpl(entityManager);
		}
		return habilidadDAO;
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

	@Override
	public HistorialPasswordDAO getHistorialPasswordDAOImpl() {
		if (historialPasswordDAO == null) {
			historialPasswordDAO = new HistorialPasswordDAOImpl(entityManager);
		}
		return historialPasswordDAO;
	}


	@Override
	public HabilidadViewDAO getHabilidadViewDAOImpl() {
		if (habilidadViewDAO == null) {
			habilidadViewDAO = new HabilidadViewDAOImpl(entityManager);
		}
		return habilidadViewDAO;
	}

	@Override
	public AvisoDAO getAvisoDAOImpl() {
		if (avisoDAO == null) {
			avisoDAO = new AvisoDAOImpl(entityManager);
		}
		return avisoDAO;
	}

	@Override
	public AvisoViewDAO getAvisoViewDAOImpl() {
		if (avisoViewDAO == null) {
			avisoViewDAO = new AvisoViewDAOImpl(entityManager);
		}
		return avisoViewDAO;
	}

	@Override
	public PostulacionDAO getPostulacionDAOImpl() {
		if (postulacionDAO == null) {
			postulacionDAO = new PostulacionDAOImpl(entityManager);
		}
		return postulacionDAO;
	}

	@Override
	public AvisoPostulacionViewDAO getAvisoPostulacionViewDAOImpl() {
		if (avisoPostulacionViewDAO == null) {
			avisoPostulacionViewDAO = new AvisoPostulacionViewDAOImpl(entityManager);
		}
		return avisoPostulacionViewDAO;
	}

	@Override
	public CandidatoPostulacionViewDAO getCandidatoPostulacionViewDAOImpl() {
		if (candidatoPostulacionViewDAO == null) {
			candidatoPostulacionViewDAO = new CandidatoPostulacionViewDAOImpl(entityManager);
		}
		return candidatoPostulacionViewDAO;
	}

	
	@Override
	public CuestionarioViewDAO getCuestionarioViewDAOImpl() {
		if (cuestionarioViewDAO == null) {
			cuestionarioViewDAO = new CuestionarioViewDAOImpl(entityManager);
		}
		return cuestionarioViewDAO;
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
	public EncuestaDAO getEncuestaDAOImpl() {
		if (encuestaDAO == null) {
			encuestaDAO = new EncuestaDAOImpl(entityManager);
		}
		return encuestaDAO;
	}

	@Override
	public CategoriaDAO getCategoriaDAOImpl() {
		if (categoriaDAO == null) {
			categoriaDAO = new CategoriaDAOImpl(entityManager);
		}
		return categoriaDAO;
	}

	
	@Override
	public ControlDAO getControlDAOImpl() {
		if (controlDAO == null) {
			controlDAO = new ControlDAOImpl(entityManager);
		}
		return controlDAO;
	}

	
	@Override
	public ResultadoDAO getResultadoDAOImpl() {
		if (resultadoDAO == null) {
			resultadoDAO = new ResultadoDAOImpl(entityManager);
		}
		return resultadoDAO;
	}

	
	@Override
	public ResultadoViewDAO getResultadoViewDAOImpl() {
		if (resultadoViewDAO == null) {
			resultadoViewDAO = new ResultadoViewDAOImpl(entityManager);
		}
		return resultadoViewDAO;
	}


}
