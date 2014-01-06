package ec.edu.uce.indicadores.ejb.persistence.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ec.edu.uce.indicadores.commons.dto.util.CredencialesDTO;
import ec.edu.uce.indicadores.commons.util.IndicadoresException;
import ec.edu.uce.indicadores.ejb.persistence.dao.UsuarioDAO;
import ec.edu.uce.indicadores.ejb.persistence.entities.UsuarioDTO;

public class UsuarioDAOImpl extends AbstractFacadeImpl<UsuarioDTO> implements UsuarioDAO{

	private static final Logger log = LoggerFactory
			.getLogger(UsuarioDAOImpl.class);

	
	public UsuarioDAOImpl() {
	}

	public UsuarioDAOImpl(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings({ "unchecked" })
	@Override
	public UsuarioDTO buscarUsuarioLogin(CredencialesDTO credencialesDTO) throws IndicadoresException
			 {

		UsuarioDTO usuarioLogin = null;

		try {
			// u inner join u.bemCandidatos c where c.canIdentificacion =? and
			// u.usuPassword =?
			Query query = entityManager
					.createQuery("select u from UsuarioDTO u where u.usuLogin =? and u.usuClave =?");
			query.setParameter(1, credencialesDTO.getUsername());
			query.setParameter(2, credencialesDTO.getPassword());
			List<UsuarioDTO> usuariosEncontrados = query.getResultList();
			usuarioLogin=usuariosEncontrados.get(0);

		} catch (Exception e) {
			log.info("Error al autenticar el usuario {}", e.toString());
			throw new IndicadoresException("Error al autenticar el usuario" + e);
		}
		return usuarioLogin;
	}

	
}
