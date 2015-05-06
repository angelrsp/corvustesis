package ec.edu.uce.besg.ejb.service;

import java.util.List;

import javax.ejb.Local;

import ec.edu.uce.besg.common.util.CorvustecException;
import ec.edu.uce.besg.ejb.persistence.entity.ContactoDTO;
import ec.edu.uce.besg.ejb.persistence.entity.EmpresaDTO;
import ec.edu.uce.besg.ejb.persistence.entity.security.CatalogoDTO;
import ec.edu.uce.besg.ejb.persistence.entity.view.ContactoViewDTO;
import ec.edu.uce.besg.ejb.vo.EmpresaVO;

@Local
public interface EmpresaService {

	EmpresaDTO actualizarEmpresa(EmpresaDTO empresa)
			throws CorvustecException;

	ContactoDTO agregarContacto(ContactoDTO contacto) throws CorvustecException;

	EmpresaDTO registrarActualizarEmpresa(EmpresaVO empresa)
			throws CorvustecException;

	List<EmpresaDTO> obtenerEmpresa(EmpresaDTO empresa)
			throws CorvustecException;

	ContactoDTO obtenerContactos(ContactoViewDTO contacto)
			throws CorvustecException;

	List<ContactoViewDTO> buscarContacto(ContactoViewDTO contacto)
			throws CorvustecException;

	CatalogoDTO obtenerCatalogoId(int id) throws CorvustecException;

	EmpresaDTO readEmpresa(EmpresaDTO empresa) throws CorvustecException;

	EmpresaDTO updateEmpresa(EmpresaDTO empresa) throws CorvustecException;

	
}
