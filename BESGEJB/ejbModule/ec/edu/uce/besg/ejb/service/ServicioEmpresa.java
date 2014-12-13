package ec.edu.uce.besg.ejb.service;

import java.util.List;

import javax.ejb.Local;

import ec.edu.uce.besg.ejb.entity.ContactoDTO;
import ec.edu.uce.besg.ejb.entity.ContactoListDTO;
import ec.edu.uce.besg.ejb.entity.EmpresaDTO;
import ec.edu.uce.besg.ejb.persistence.entity.security.CatalogoDTO;
import ec.edu.uce.besg.ejb.util.SeguridadesException;
import ec.edu.uce.besg.ejb.vo.EmpresaVO;

@Local
public interface ServicioEmpresa {

	EmpresaDTO actualizarEmpresa(EmpresaDTO empresa)
			throws SeguridadesException;

	ContactoDTO agregarContacto(ContactoDTO contacto) throws SecurityException;

	EmpresaDTO registrarActualizarEmpresa(EmpresaVO empresa)
			throws SeguridadesException;

	List<CatalogoDTO> buscarCatalogo(CatalogoDTO catalogoDTO)
			throws SeguridadesException;

	List<EmpresaDTO> obtenerEmpresa(EmpresaDTO empresa)
			throws SecurityException;

	ContactoDTO obtenerContactos(ContactoListDTO contacto)
			throws SecurityException;

	List<ContactoListDTO> buscarContacto(ContactoListDTO contacto)
			throws SecurityException;

	CatalogoDTO obtenerCatalogoId(int id) throws SecurityException;

	
}
