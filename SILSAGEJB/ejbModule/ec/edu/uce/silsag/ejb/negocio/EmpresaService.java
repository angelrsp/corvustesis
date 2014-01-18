package ec.edu.uce.silsag.ejb.negocio;

import java.util.List;

import javax.ejb.Local;

import ec.edu.uce.silsag.commons.util.SilsagException;
import ec.edu.uce.silsag.ejb.persistence.entities.AvisoDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.ContactoDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.EmpresaDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.PostulacionDTO;

@Local
public interface EmpresaService {

	EmpresaDTO registrarEmpresa(EmpresaDTO empresa) throws SilsagException;

	AvisoDTO registrarAviso(AvisoDTO aviso) throws SilsagException;

	List<ContactoDTO> obtenerContactos(EmpresaDTO empresa)
			throws SilsagException;

	ContactoDTO agregarContacto(ContactoDTO contacto) throws SilsagException;

	EmpresaDTO actualizarEmpresa(EmpresaDTO empresa) throws SilsagException;

	List<AvisoDTO> obtenerAviso(EmpresaDTO empresa) throws SilsagException;

	List<PostulacionDTO> obtenerPostulacion(EmpresaDTO empresa)
			throws SilsagException;

	void aceptarPostulacion(PostulacionDTO postulacionDTO)
			throws SilsagException;

}
