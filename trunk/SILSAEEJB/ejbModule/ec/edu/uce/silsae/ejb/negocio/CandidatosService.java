package ec.edu.uce.silsae.ejb.negocio;

import javax.ejb.Local;

import ec.edu.uce.silsae.ejb.persistence.entities.CandidatoDTO;

@Local
public interface CandidatosService {
	
	/**
	 * Registrar <code>UsuarioDTO</code> en el sistema
	 * @return
	 */
	CandidatoDTO registrarCandidato(CandidatoDTO candidatoDTO);

}
