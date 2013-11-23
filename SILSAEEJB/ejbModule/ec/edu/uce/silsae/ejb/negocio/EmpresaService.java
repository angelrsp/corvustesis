package ec.edu.uce.silsae.ejb.negocio;

import java.util.List;

import javax.ejb.Local;

import ec.edu.uce.silsae.commons.util.SilsaeException;
import ec.edu.uce.silsae.ejb.persistence.entities.AvisoDTO;
import ec.edu.uce.silsae.ejb.persistence.entities.AvisoListDTO;
import ec.edu.uce.silsae.ejb.persistence.entities.EmpresaDTO;

@Local
public interface EmpresaService {

	EmpresaDTO registrarEmpresa(EmpresaDTO empresa) throws SilsaeException;

	AvisoDTO registrarAviso(AvisoDTO aviso) throws SilsaeException;

	List<AvisoListDTO> obtenerAviso(EmpresaDTO empresa) throws SilsaeException;

}
