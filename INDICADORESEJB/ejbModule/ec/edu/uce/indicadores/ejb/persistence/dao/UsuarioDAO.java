package ec.edu.uce.indicadores.ejb.persistence.dao;

import java.util.List;

import ec.edu.uce.indicadores.commons.dto.util.CredencialesDTO;
import ec.edu.uce.indicadores.commons.util.IndicadoresException;
import ec.edu.uce.indicadores.ejb.persistence.entities.IesDTO;
import ec.edu.uce.indicadores.ejb.persistence.entities.UsuarioDTO;

public interface UsuarioDAO extends AbstractFacade<UsuarioDTO>{

	UsuarioDTO buscarUsuarioLogin(CredencialesDTO credencialesDTO)
			throws IndicadoresException;

	List<UsuarioDTO> getAll(IesDTO ies) throws IndicadoresException;

	void remove2(UsuarioDTO user);

	UsuarioDTO buscarUsuario(UsuarioDTO user) throws IndicadoresException;


}
