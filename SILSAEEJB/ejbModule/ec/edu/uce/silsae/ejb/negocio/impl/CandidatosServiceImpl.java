package ec.edu.uce.silsae.ejb.negocio.impl;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ec.edu.uce.silsae.commons.util.SilsaeException;
import ec.edu.uce.silsae.ejb.negocio.CandidatosService;
import ec.edu.uce.silsae.ejb.persistence.dao.FactoryDAO;
import ec.edu.uce.silsae.ejb.persistence.entities.CandidatoDTO;

@Stateless
public class CandidatosServiceImpl implements CandidatosService{
	
	private static final Logger log = LoggerFactory.getLogger(CandidatosServiceImpl.class);
	
	@EJB
	private FactoryDAO factoryDAO;

	@Override
	public CandidatoDTO registrarCandidato(CandidatoDTO candidatoDTO) throws SilsaeException {
		
		log.info("registrarCandidato");
		
		try {
			
			return factoryDAO.getCandidatoDAOImpl().create(candidatoDTO);
		} catch (Exception e) {
			log.info("Error al registrar el Candidato {}", e.toString());
			throw new SilsaeException("Error al registrar el Candidato");
		}
		
	}

}
