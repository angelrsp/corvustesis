package ec.edu.uce.besg.ejb.service;

import java.util.List;

import javax.ejb.Local;

import ec.edu.uce.besg.ejb.entity.ContactoDTO;
import ec.edu.uce.besg.ejb.entity.EmpresaDTO;
import ec.edu.uce.besg.ejb.util.SeguridadesException;
import ec.edu.uce.besg.ejb.vo.EmpresaVO;

@Local
public interface ServicioEmpresa {

	EmpresaDTO registrarEmpresa(EmpresaVO empresa) throws SeguridadesException;

	EmpresaDTO actualizarEmpresa(EmpresaDTO empresa)
			throws SeguridadesException;

	ContactoDTO agregarContacto(ContactoDTO contacto) throws SecurityException;

	List<ContactoDTO> obtenerContactos(ContactoDTO contacto)
			throws SecurityException;



}
