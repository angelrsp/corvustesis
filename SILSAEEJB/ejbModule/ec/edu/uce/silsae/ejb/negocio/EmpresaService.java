package ec.edu.uce.silsae.ejb.negocio;

import javax.ejb.Local;

import ec.edu.uce.silsae.commons.util.SilsaeException;
import ec.edu.uce.silsae.ejb.persistence.entities.EmpresaDTO;

@Local
public interface EmpresaService {

	EmpresaDTO registrarEmpresa(EmpresaDTO empresa) throws SilsaeException;

}
