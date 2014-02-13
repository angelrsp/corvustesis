package ec.edu.uce.indicadores.ejb.negocio;

import java.util.List;

import javax.ejb.Local;

import ec.edu.uce.indicadores.commons.util.IndicadoresException;
import ec.edu.uce.indicadores.ejb.persistence.entities.CatalogoDTO;
import ec.edu.uce.indicadores.ejb.persistence.entities.IesDTO;
import ec.edu.uce.indicadores.ejb.persistence.entities.OpcionDTO;
import ec.edu.uce.indicadores.ejb.persistence.entities.PerfilDTO;
import ec.edu.uce.indicadores.ejb.persistence.entities.UsuarioDTO;

@Local
public interface AdministracionService {

	List<CatalogoDTO> getCatalogo(CatalogoDTO catalogo)
			throws IndicadoresException;

	List<UsuarioDTO> readUser(IesDTO ies) throws IndicadoresException;

	UsuarioDTO createUser(UsuarioDTO user) throws IndicadoresException;

	List<PerfilDTO> readPerfil() throws IndicadoresException;

	PerfilDTO createPerfil(PerfilDTO perfil) throws IndicadoresException;

	List<OpcionDTO> readOpcion(PerfilDTO perfil) throws IndicadoresException;

	List<OpcionDTO> readOpcion() throws IndicadoresException;

	void createAcceso(List<String> option, Object perfil)
			throws IndicadoresException;

}
