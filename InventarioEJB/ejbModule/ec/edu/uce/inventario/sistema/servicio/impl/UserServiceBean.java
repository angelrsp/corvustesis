package ec.edu.uce.inventario.sistema.servicio.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

import ec.edu.uce.inventario.entidades.SisPerfil;
import ec.edu.uce.inventario.entidades.SisUsuario;
import ec.edu.uce.inventario.sistema.servicio.UserService;
import ec.edu.uce.inventario.util.Encrypted;

@Stateless(name="userService")
public class UserServiceBean implements UserService{

	@PersistenceContext(name = "inventarioPU", type = PersistenceContextType.TRANSACTION)
    private EntityManager entityManager;
    
	@Override
    public boolean authenticate(String user, String password) {
        // TODO Auto-generated method stub
		
		Encrypted encr=new Encrypted();
		String pass=encr.enc(password);
		
        Query query=entityManager.createQuery("from SisUsuario where usrLogin=:user and usrPassword=:password");
        query.setParameter("user", user);
        query.setParameter("password", pass);
        if(query.getResultList().size()==1)
            return true;
        else
            return false;
    }
	
	@Override
    public SisUsuario getUserInformation(String user)
    {
        Query query=entityManager.createQuery("select usu from SisUsuario usu inner join usu.sisPerfil usp where usu.usrLogin=:user");
        query.setParameter("user", user);
        if(query.getResultList().size()==1)
            return (SisUsuario)query.getResultList().get(0);
        else
            return null;
    }

    @Override
    public boolean existsUser(String user) {
        // TODO Auto-generated method stub
        Query query=entityManager.createQuery("from SisUsuario where usrLogin=:user");
        query.setParameter("user", user);
        if(query.getResultList().size()>0)
            return true;
        else
            return false;
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public List<SisUsuario> readAll()
    {
        List<SisUsuario> objects;
        Query query=entityManager.createQuery("from SisUsuario");
        objects=query.getResultList();
        return objects;
    }
    
	@Override
	public Boolean create(SisUsuario user,int perfil)
	{
    	Encrypted enc=new Encrypted();
		
		String passEnc=enc.enc(user.getUsrPassword());
		
		user.setUsrPassword(passEnc);
		
		SisPerfil per=new SisPerfil();
		per.setPrlCodigo(perfil);
		user.setSisPerfil(per);
		
		entityManager.persist(user);
	
		return true;
	}
    
    @Override
    public Boolean update(SisUsuario user)
    {
    	Encrypted enc=new Encrypted();
		
		String passEnc=enc.enc(user.getUsrPassword());
		
		user.setUsrPassword(passEnc);
		
		entityManager.merge(user);
		
        return true;
    }
}
