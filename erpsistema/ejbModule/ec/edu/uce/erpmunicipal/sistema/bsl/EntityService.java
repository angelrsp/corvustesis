package ec.edu.uce.erpmunicipal.sistema.bsl;

import java.util.List;

import javax.ejb.Local;

import ec.edu.uce.erpmunicipal.sistema.orm.SisInstitucion;
import ec.edu.uce.erpmunicipal.sistema.orm.SisUsuario;


@Local
public interface EntityService {
	
	List<SisInstitucion> readAll();
	List<SisInstitucion> readAll(SisUsuario user, int rolCode);
	Boolean delete(SisInstitucion ent);
	
}
