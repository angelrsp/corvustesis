package ec.edu.uce.indicadores.ejb.persistence.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ec.edu.uce.indicadores.commons.dto.util.CredencialesDTO;
import ec.edu.uce.indicadores.commons.util.IndicadoresException;
import ec.edu.uce.indicadores.ejb.persistence.dao.UsuarioDAO;
import ec.edu.uce.indicadores.ejb.persistence.entities.IesDTO;
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
			usuarioLogin=usuariosEncontrados.size()!=0? usuariosEncontrados.get(0):null;

		} catch (Exception e) {
			log.info("Error al autenticar el usuario {}", e.toString());
			throw new IndicadoresException("Error al autenticar el usuario" + e);
		}
		return usuarioLogin;
	}

	@Override
	public List<UsuarioDTO> getAll(IesDTO ies) throws IndicadoresException
	{
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<UsuarioDTO> cq=cb.createQuery(UsuarioDTO.class);
		Root<UsuarioDTO> from= cq.from(UsuarioDTO.class);
		Path<IesDTO> join2=from.join("indy");
		
		cq.where(cb.equal(join2.get("iesCodigo"), ies.getIesCodigo()));
		
		List<UsuarioDTO> list=entityManager.createQuery(cq).getResultList();	
		if(list.isEmpty())
			return null;
		else
			return list;
	}
	
	@Override
	public void remove2(UsuarioDTO user)
	{
		Query query;
		query=entityManager.createQuery("delete from UsuarioPerfilDTO uspe where uspe.indUsuario.usuCodigo=:codigo");
		query.setParameter("codigo", user.getUsuCodigo());
		query.executeUpdate();

		query=entityManager.createQuery("delete from UsuarioDTO usu where usu.usuCodigo=:codigo");
		query.setParameter("codigo", user.getUsuCodigo());
		query.executeUpdate();

	}
	
	
	
	@SuppressWarnings({ "unchecked" })
	@Override
	public UsuarioDTO buscarUsuario(UsuarioDTO user) throws IndicadoresException
	 {
		UsuarioDTO usuarioLogin = null;
		try {
			Query query = entityManager
					.createQuery("select u from UsuarioDTO u where u.usuLogin=?");
			query.setParameter(1, user.getUsuLogin());
			List<UsuarioDTO> usuariosEncontrados = query.getResultList();
			usuarioLogin=usuariosEncontrados.size()!=0? usuariosEncontrados.get(0):null;

		} catch (Exception e) {
			log.info("Error al autenticar el usuario {}", e.toString());
			throw new IndicadoresException("Error al autenticar el usuario" + e);
		}
		return usuarioLogin;
	}
}
