package ec.edu.uce.silsae.ejb.negocio;

import java.util.List;

import javax.ejb.Local;

import ec.edu.uce.silsae.commons.util.SilsaeException;
import ec.edu.uce.silsae.ejb.persistence.entities.AvisoDTO;
import ec.edu.uce.silsae.ejb.persistence.entities.AvisoListDTO;
import ec.edu.uce.silsae.ejb.persistence.entities.ContactoDTO;
import ec.edu.uce.silsae.ejb.persistence.entities.EmpresaDTO;
import ec.edu.uce.silsae.ejb.persistence.entities.PostulacionListDTO;

@Local
public interface EmpresaService {

	EmpresaDTO registrarEmpresa(EmpresaDTO empresa) throws SilsaeException;

	AvisoDTO registrarAviso(AvisoDTO aviso) throws SilsaeException;

	List<AvisoListDTO> obtenerAviso(EmpresaDTO empresa) throws SilsaeException;

	List<ContactoDTO> obtenerContactos(EmpresaDTO empresa)
			throws SilsaeException;

	ContactoDTO agregarContacto(ContactoDTO contacto) throws SilsaeException;

	List<PostulacionListDTO> obtenerPostulacion(EmpresaDTO empresa)
			throws SilsaeException;

	EmpresaDTO actualizarEmpresa(EmpresaDTO empresa) throws SilsaeException;

}
