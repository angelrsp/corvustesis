package ec.edu.uce.erpmunicipal.sistema.bsl.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

import org.jboss.logging.Logger;

import ec.edu.uce.erpmunicipal.sistema.bsl.UserService;
import ec.edu.uce.erpmunicipal.sistema.orm.SisHistorialPass;
import ec.edu.uce.erpmunicipal.sistema.orm.SisRole;
import ec.edu.uce.erpmunicipal.sistema.orm.SisUsuario;
import ec.edu.uce.erpmunicipal.sistema.orm.SisUsuarioRol;
import ec.edu.uce.erpmunicipal.util.Encrypted;

@Stateless(name="userService")
public class UserServiceBean implements UserService {

	@PersistenceContext(name="erpmunicipalPU", type=PersistenceContextType.TRANSACTION)
	private EntityManager entityManager; 
	
	
	@Override
	public boolean authenticate(String user, String password) {
		// TODO Auto-generated method stub
		
		Encrypted encr=new Encrypted();
		String pass=encr.enc(password);

		Logger.getLogger(this.getClass()).info(pass);
		
		Query query=entityManager.createQuery("from SisUsuario where usuLogin=:user and usuClave=:password");
		query.setParameter("user", user);
		query.setParameter("password", pass);

		if(query.getResultList().size()==1)
			return true;
		else
			return false;
	}

	@Override
	public boolean existsUser(String user) {
		// TODO Auto-generated method stub
		Query query=entityManager.createQuery("from SisUsuario where usuLogin=:user");
		query.setParameter("user", user);
		if(query.getResultList().size()>0)
			return true;
		else
			return false;
	}

	
	@Override
	public SisUsuario getUserInformation(String user)
	{
		Query query=entityManager.createQuery("select usu from SisUsuario usu inner join usu.sisUsuarioRols usr where usu.usuLogin=:user");
		query.setParameter("user", user);
		if(query.getResultList().size()==1)
			return (SisUsuario)query.getResultList().get(0);
		else
			return null;
	}

	@Override
	public SisUsuarioRol readUserRol(String user)
	{
		Query query=entityManager.createQuery("select rol from SisUsuario usu inner join usu.sisUsuarioRols rol where usu.usuLogin=:user");
		query.setParameter("user", user);
		if(query.getResultList().size()==1)
			return (SisUsuarioRol)query.getSingleResult();
		else
			return null;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<SisUsuario> readAll(int entity)
	{
		List<SisUsuario> objects;
		Query query=entityManager.createQuery("from SisUsuario where sisInstitucion.insCodigo=:entity");
		query.setParameter("entity", entity);
		objects=query.getResultList();
		return objects;
	}
	
	@Override
	public Boolean create(SisUsuario user,int rol)
	{
		SisUsuarioRol userRol=new SisUsuarioRol();
		SisRole role=new SisRole();
		Date date=new Date();
		
		entityManager.persist(user);
		entityManager.flush();
		entityManager.refresh(user);
		
		userRol.setSisUsuario(user);
		role.setRolCodigo(rol);
		userRol.setSisRole(role);
		userRol.setUsrActivo(user.getUsuActivo());
		userRol.setUsrFechaCambio(new Timestamp(date.getTime()));
		entityManager.persist(userRol);
		
		return true;
	}
	
	
	@Override
	public Boolean updatePass(SisUsuario user)
	{
		SisHistorialPass hisPass=new SisHistorialPass();
		Date date=new Date();
		Encrypted enc=new Encrypted();
		
		String passEnc=enc.enc(user.getUsuClave());
		
		Logger.getLogger(this.getClass()).info(passEnc);
		
		user.setUsuClave(passEnc);
		
		hisPass.setHpaFechaRegistro(new Timestamp(date.getTime()));
		hisPass.setSisUsuario(user);
		hisPass.setHpaPass(passEnc);
		
		entityManager.merge(user);
		
		entityManager.persist(hisPass);
		
		return true;
	}
}
