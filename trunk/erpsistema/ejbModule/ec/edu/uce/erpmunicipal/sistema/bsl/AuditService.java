package ec.edu.uce.erpmunicipal.sistema.bsl;

import javax.ejb.Local;

import ec.edu.uce.erpmunicipal.sistema.orm.SisAuditoriaMenu;

@Local
public interface AuditService {

	void create(SisAuditoriaMenu object);

}
