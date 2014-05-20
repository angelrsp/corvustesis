package net.ciespal.redxxi.ejb.negocio;

import java.util.List;

import javax.ejb.Local;

import net.ciespal.redxxi.ejb.persistence.entities.CatalogoDTO;
import net.ciespal.redxxi.ejb.persistence.entities.security.UsuarioDTO;
import net.ciespal.redxxi.ejb.persistence.entities.util.dto.CredencialesDTO;

import com.corvustec.commons.util.CorvustecException;

@Local
public interface AdministracionService {

	List<CatalogoDTO> getCatalogo(CatalogoDTO catalogo)
			throws CorvustecException;

	CatalogoDTO getCatalogo(Object id) throws CorvustecException;

	CatalogoDTO createOrUpdateCatalogo(CatalogoDTO catalogo)
			throws CorvustecException;

	void deleteCatalogo(CatalogoDTO catalogo) throws CorvustecException;

	UsuarioDTO userAuthentication(CredencialesDTO credenciales)
			throws CorvustecException;

	UsuarioDTO createOrUpdateUsuario(UsuarioDTO usuarioDTO)
			throws CorvustecException;

	List<UsuarioDTO> readUser(UsuarioDTO usuarioDTO) throws CorvustecException;

	List<UsuarioDTO> readAllUser() throws CorvustecException;

}
