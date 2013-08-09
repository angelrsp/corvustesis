package ec.edu.uce.erpmunicipal.sistema.bsl;

import java.util.List;

import javax.ejb.Local;

import ec.edu.uce.erpmunicipal.sistema.orm.SisUsuario;
import ec.edu.uce.erpmunicipal.sistema.orm.SisUsuarioRol;

@Local
public interface UserService {
	boolean authenticate(String user, String password);
	SisUsuario getUserInformation(String user);
	SisUsuarioRol readUserRol(String user);
	List<SisUsuario> readAll(int entity);
	boolean existsUser(String user);
	Boolean create(SisUsuario user, int rol);
	Boolean updatePass(SisUsuario user);
}
