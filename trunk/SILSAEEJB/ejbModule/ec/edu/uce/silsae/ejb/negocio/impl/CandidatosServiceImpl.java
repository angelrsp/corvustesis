package ec.edu.uce.silsae.ejb.negocio.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ec.edu.uce.silsae.commons.util.SilsaeException;
import ec.edu.uce.silsae.ejb.negocio.CandidatosService;
import ec.edu.uce.silsae.ejb.persistence.dao.FactoryDAO;
import ec.edu.uce.silsae.ejb.persistence.entities.AvisoListDTO;
import ec.edu.uce.silsae.ejb.persistence.entities.CandidatoDTO;
import ec.edu.uce.silsae.ejb.persistence.entities.CandidatoDatoDTO;
import ec.edu.uce.silsae.ejb.persistence.entities.CandidatoEstudioDTO;
import ec.edu.uce.silsae.ejb.persistence.entities.EstudioDTO;
import ec.edu.uce.silsae.ejb.persistence.entities.EstudioListDTO;
import ec.edu.uce.silsae.ejb.persistence.entities.ExperienciaDTO;
import ec.edu.uce.silsae.ejb.persistence.entities.ExperienciaListDTO;
import ec.edu.uce.silsae.ejb.persistence.entities.IdiomaDTO;
import ec.edu.uce.silsae.ejb.persistence.entities.IdiomaListDTO;
import ec.edu.uce.silsae.ejb.persistence.entities.PostulacionDTO;
import ec.edu.uce.silsae.ejb.persistence.entities.ReferenciaDTO;
import ec.edu.uce.silsae.ejb.persistence.entities.SoftwareDTO;
import ec.edu.uce.silsae.ejb.persistence.entities.SoftwareListDTO;
import ec.edu.uce.silsae.ejb.persistence.entities.UsuarioDTO;

@Stateless
public class CandidatosServiceImpl implements CandidatosService {

	private static final Logger log = LoggerFactory
			.getLogger(CandidatosServiceImpl.class);

	@EJB
	private FactoryDAO factoryDAO;

	@Override
	public CandidatoDTO registrarCandidato(CandidatoDTO candidatoDTO)throws SilsaeException {

		log.info("registrarCandidato");

		try {
			UsuarioDTO user = candidatoDTO.getBemUsuario();
			user.setBemPerfil(factoryDAO.getPerfilDAOImpl().find(1));
			candidatoDTO.setBemUsuario(user);
			return factoryDAO.getCandidatoDAOImpl().create(candidatoDTO);
		} catch (Exception e) {
			log.info("Error al registrar el Candidato {}", e.toString());
			throw new SilsaeException("Error al registrar el Candidato");
		}

	}

	
	@Override
	public CandidatoDTO actualizarCandidato(CandidatoDTO candidatoDTO)throws SilsaeException {

		log.info("registrarCandidato");

		try {
			return factoryDAO.getCandidatoDAOImpl().edit(candidatoDTO);
		} catch (Exception e) {
			log.info("Error al registrar el Candidato {}", e.toString());
			throw new SilsaeException("Error al registrar el Candidato");
		}

	}

	
	
	@Override
	public void agregarEstudio(EstudioDTO estudio) throws SilsaeException {
		log.info("agregarEstudio");

		try {
			factoryDAO.getEstudioDAOImpl().create(estudio);
			CandidatoDTO can=estudio.getBemCandidato();
			Integer es=factoryDAO.getEstudioDAOImpl().getMax(can);
			can.setCanMaxEstudio(es);
			factoryDAO.getCandidatoDAOImpl().edit(can);
		} catch (Exception e) {
			log.info("Error al registrar el Candidato {}", e.toString());
			throw new SilsaeException("Error al registrar el Candidato");
		}
	}
	
	@Override
	public void eliminarEstudio(EstudioDTO estudio) throws SilsaeException {
		log.info("eliminarEstudio");

		try {
			CandidatoDTO can=estudio.getBemCandidato();
			factoryDAO.getEstudioDAOImpl().remove(estudio);
			if(factoryDAO.getEstudioDAOImpl().getAll(can)!=null)
			{
				Integer es=factoryDAO.getEstudioDAOImpl().getMax(can);
				can.setCanMaxEstudio(es);
			}
			else
			{
				can.setCanMaxEstudio(null);
			}
			factoryDAO.getCandidatoDAOImpl().edit(can);
		} catch (Exception e) {
			log.info("Error al eliminarEstudio {}", e.toString());
			throw new SilsaeException("Error al eliminarEstudio");
		}
	}
	
	@Override
	public void agregarExperiencia(ExperienciaDTO experiencia) throws SilsaeException {
		log.info("agregarEstudio");

		try {
			factoryDAO.getExperienciaDAOImpl().create(experiencia);
		} catch (Exception e) {
			log.info("Error al registrar el Candidato {}", e.toString());
			throw new SilsaeException("Error al registrar el Candidato");
		}
	}
	
	@Override
	public void eliminarExperiencia(ExperienciaDTO experiencia) throws SilsaeException {
		log.info("eliminarExperiencia");

		try {
			factoryDAO.getExperienciaDAOImpl().remove(experiencia);
		} catch (Exception e) {
			log.info("Error al registrar el Candidato {}", e.toString());
			throw new SilsaeException("Error al registrar el Candidato");
		}
	}

	@Override
	public void agregarHerramientas(SoftwareDTO software) throws SilsaeException {
		log.info("agregarHerramientas");

		try {
			factoryDAO.getSoftwareDAOImpl().create(software);
		} catch (Exception e) {
			log.info("Error al registrar el Candidato {}", e.toString());
			throw new SilsaeException("Error al registrar el Candidato");
		}
	}

	@Override
	public void eliminarHerramientas(SoftwareDTO software) throws SilsaeException {
		log.info("eliminarHerramientas");

		try {
			factoryDAO.getSoftwareDAOImpl().remove(software);
		} catch (Exception e) {
			log.info("Error al registrar el Candidato {}", e.toString());
			throw new SilsaeException("Error al registrar el Candidato");
		}
	}

	
	@Override
	public void agregarIdioma(IdiomaDTO idioma) throws SilsaeException {
		log.info("agregarHerramientas");

		try {factoryDAO.getIdiomaDAOImpl().create(idioma);
		} catch (Exception e) {
			log.info("Error al registrar el Candidato {}", e.toString());
			throw new SilsaeException("Error al registrar el Candidato");
		}
	}
	
	@Override
	public void eliminarIdioma(IdiomaDTO idioma) throws SilsaeException {
		log.info("eliminarIdioma");

		try {factoryDAO.getIdiomaDAOImpl().remove(idioma);
		} catch (Exception e) {
			log.info("Error al registrar el Candidato {}", e.toString());
			throw new SilsaeException("Error al registrar el Candidato");
		}
	}
	
	@Override
	public void agregarReferencia(ReferenciaDTO referencia) throws SilsaeException {
		log.info("agregarHerramientas");

		try {
			factoryDAO.getReferenciaDAOImpl().create(referencia);
		} catch (Exception e) {
			log.info("Error al registrar el Candidato {}", e.toString());
			throw new SilsaeException("Error al registrar el Candidato");
		}
	}
	
	@Override
	public void eliminarReferencia(ReferenciaDTO referencia) throws SilsaeException {
		log.info("eliminarReferencia");

		try {
			factoryDAO.getReferenciaDAOImpl().remove(referencia);
		} catch (Exception e) {
			log.info("Error al registrar el Candidato {}", e.toString());
			throw new SilsaeException("Error al registrar el Candidato");
		}
	}
	
	@Override
	public List<EstudioListDTO> obtenerEstudio(CandidatoDTO candidato)throws SilsaeException {
		try {
			return factoryDAO.getEstudioDAOImpl().getAll(candidato);
		} catch (Exception e) {
			log.info("Error al obtener datos de Estudio {}", e.toString());
			throw new SilsaeException("Error al registrar el Candidato");

		}
	}

	@Override
	public List<CandidatoDatoDTO> obtenerCandidatoDato(CandidatoDTO candidato)throws SilsaeException {
		try {
			return factoryDAO.getCandidatoDAOImpl().getData(candidato);
		} catch (Exception e) {
			log.info("Error al obtener datos de Estudio {}", e.toString());
			throw new SilsaeException("Error al registrar el Candidato");

		}
	}
	
	@Override
	public List<CandidatoEstudioDTO> obtenerCandidatoEstudio(CandidatoDTO candidato)throws SilsaeException {
		try {
			List<CandidatoEstudioDTO> list=factoryDAO.getCandidatoDAOImpl().getCandidatoEstudio(candidato);
			CandidatoDTO can=new CandidatoDTO();
			can.setCanCodigo(candidato.getCanCodigo());
			list.get(0).setCanEstudios(obtenerEstudio(can));
			list.get(0).setCanExperiencia(obtenerExperiencia(can));
			return list;
		} catch (Exception e) {
			log.info("Error al obtener datos de Estudio {}", e.toString());
			throw new SilsaeException("Error al registrar el Candidato");

		}
	}
	
	
	@Override
	public List<ExperienciaListDTO> obtenerExperiencia(CandidatoDTO candidato)throws SilsaeException {
		try {
			return factoryDAO.getExperienciaDAOImpl().getAll(candidato);
		} catch (Exception e) {
			log.info("Error al obtener datos de Estudio {}", e.toString());
			throw new SilsaeException("Error al registrar el Candidato");

		}
	}

	@Override
	public List<SoftwareListDTO> obtenerHerramientas(CandidatoDTO candidato)throws SilsaeException {
		try {
			return factoryDAO.getSoftwareDAOImpl().getAll(candidato);
		} catch (Exception e) {
			log.info("Error al obtener datos de Herramientas {}", e.toString());
			throw new SilsaeException("Error al obtener datos de Herramientas "+e.toString());

		}
	}

	
	@Override
	public List<IdiomaListDTO> obtenerIdioma(CandidatoDTO candidato)throws SilsaeException {
		try {
			return factoryDAO.getIdiomaDAOImpl().getAll(candidato);
		} catch (Exception e) {
			log.info("Error al obtener datos de Herramientas {}", e.toString());
			throw new SilsaeException("Error al obtener datos de Herramientas "+e.toString());

		}
	}

	@Override
	public List<ReferenciaDTO> obtenerReferencia(CandidatoDTO candidato)throws SilsaeException {
		try {
			return factoryDAO.getReferenciaDAOImpl().getAll(candidato);
		} catch (Exception e) {
			log.info("Error al obtener datos de Herramientas {}", e.toString());
			throw new SilsaeException("Error al obtener datos de Herramientas "+e.toString());

		}
	}

	
	@Override
	public List<AvisoListDTO> verOfertas() throws SilsaeException
	{
		try {
			return factoryDAO.getAvisoDAOImpl().getOfertas();
		} catch (Exception e) {
			log.info("Error al obtener datos de Estudio {}", e.toString());
			throw new SilsaeException("Error al obtener datos Ofertas");

		}
	}
	
	@Override
	public PostulacionDTO postular(PostulacionDTO postulacionDTO) throws SilsaeException{
		try {
			return factoryDAO.getPostulacionDAOImpl().create(postulacionDTO);
		} catch (Exception e) {
			log.info("Error al insertar postulacion {}", e.toString());
			throw new SilsaeException("Error al insertar postulacion");
		}
		
	}
	
	@Override
	public CandidatoDTO obtenerCandidato(Object id)throws SilsaeException {

		log.info("obtenerCandidato");

		try {
			return factoryDAO.getCandidatoDAOImpl().find(id);
		} catch (Exception e) {
			log.info("Error al registrar el Candidato {}", e.toString());
			throw new SilsaeException("Error al registrar el Candidato");
		}

	}
}
