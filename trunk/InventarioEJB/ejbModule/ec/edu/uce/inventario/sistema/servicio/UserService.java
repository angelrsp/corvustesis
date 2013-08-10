package ec.edu.uce.inventario.sistema.servicio;

import java.util.List;

import javax.ejb.Local;

import ec.edu.uce.inventario.entidades.SisUsuario;

@Local
public interface UserService {

	boolean authenticate(String user, String password);

	SisUsuario getUserInformation(String user);

	boolean existsUser(String user);

	List<SisUsuario> readAll();

	Boolean update(SisUsuario user);

	Boolean create(SisUsuario user, int perfil);

}
