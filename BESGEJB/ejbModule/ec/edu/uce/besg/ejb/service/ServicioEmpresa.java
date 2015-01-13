package ec.edu.uce.besg.ejb.service;

import java.util.List;

import javax.ejb.Local;

import ec.edu.uce.besg.common.util.CorvustecException;
import ec.edu.uce.besg.ejb.entity.ContactoDTO;
import ec.edu.uce.besg.ejb.entity.ContactoListDTO;
import ec.edu.uce.besg.ejb.entity.EmpresaDTO;
import ec.edu.uce.besg.ejb.persistence.entity.security.CatalogoDTO;
import ec.edu.uce.besg.ejb.vo.EmpresaVO;

@Local
public interface ServicioEmpresa {

	EmpresaDTO actualizarEmpresa(EmpresaDTO empresa)
			throws CorvustecException;

	ContactoDTO agregarContacto(ContactoDTO contacto) throws CorvustecException;

	EmpresaDTO registrarActualizarEmpresa(EmpresaVO empresa)
			throws CorvustecException;

	List<CatalogoDTO> buscarCatalogo(CatalogoDTO catalogoDTO)
			throws CorvustecException;

	List<EmpresaDTO> obtenerEmpresa(EmpresaDTO empresa)
			throws CorvustecException;

	ContactoDTO obtenerContactos(ContactoListDTO contacto)
			throws CorvustecException;

	List<ContactoListDTO> buscarContacto(ContactoListDTO contacto)
			throws CorvustecException;

	CatalogoDTO obtenerCatalogoId(int id) throws CorvustecException;

	
}
