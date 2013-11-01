package ec.edu.uce.silsae.ejb.persistence.dao.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.uce.silsae.commons.dto.util.CredencialesDTO;
import ec.edu.uce.silsae.commons.util.SilsaeException;
import ec.edu.uce.silsae.ejb.persistence.dao.UsuarioDAO;
import ec.edu.uce.silsae.ejb.persistence.entities.UsuarioDTO;

@Stateless
public class UsuarioDAOImpl extends AbstractFacadeImpl<UsuarioDTO> implements UsuarioDAO{
	
	public UsuarioDAOImpl () {}
	
	public UsuarioDAOImpl (EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public UsuarioDTO buscarUsuarioLogin(CredencialesDTO credencialesDTO)
			throws SilsaeException {
		
		try {
			
			Query query = entityManager.createNativeQuery("select u from UsuarioDTO u inner join u.bemCandidatos c where c.canIdentificacion =? and u.usuPassword =?");
			query.setParameter(0, credencialesDTO.getUsername());
			query.setParameter(1, credencialesDTO.getPassword());
			query.getResultList();
			
		} catch (Exception e) {
			throw new SilsaeException("Error al autenticar el usuario");
		}
		return null;
	}

}
