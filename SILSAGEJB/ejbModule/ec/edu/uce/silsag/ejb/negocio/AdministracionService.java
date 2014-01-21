package ec.edu.uce.silsag.ejb.negocio;

import java.util.List;

import javax.ejb.Local;

import ec.edu.uce.silsag.commons.util.SilsagException;
import ec.edu.uce.silsag.ejb.persistence.entities.CandidatoEstudioDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.CatalogoDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.ContactoDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.EmpresaDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.UsuarioDTO;

@Local
public interface AdministracionService {

	List<CatalogoDTO> getCatalogo(CatalogoDTO catalogo) throws SilsagException;

	List<EmpresaDTO> obtenerEmpresas() throws SilsagException;

	void cambiarEstadoEmpresa(EmpresaDTO empresa) throws SilsagException;

	List<ContactoDTO> obtenerContactos(EmpresaDTO empresa)
			throws SilsagException;

	void actualizarClave(UsuarioDTO user) throws SilsagException;

	List<CandidatoEstudioDTO> obtenerCandidatos() throws SilsagException;


	
}

