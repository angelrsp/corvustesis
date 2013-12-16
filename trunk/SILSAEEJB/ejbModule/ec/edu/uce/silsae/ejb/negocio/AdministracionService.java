package ec.edu.uce.silsae.ejb.negocio;

import java.util.List;

import javax.ejb.Local;

import ec.edu.uce.silsae.commons.util.SilsaeException;
import ec.edu.uce.silsae.ejb.persistence.entities.CatalogoDTO;
import ec.edu.uce.silsae.ejb.persistence.entities.EmpresaDTO;

@Local
public interface AdministracionService {

	List<CatalogoDTO> getCatalogo(CatalogoDTO catalogo) throws SilsaeException;

	List<EmpresaDTO> obtenerEmpresas() throws SilsaeException;

	void cambiarEstadoEmpresa(EmpresaDTO empresa) throws SilsaeException;
	
}
