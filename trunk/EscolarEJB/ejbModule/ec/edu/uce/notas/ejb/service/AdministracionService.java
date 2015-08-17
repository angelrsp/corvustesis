package ec.edu.uce.notas.ejb.service;

import java.util.List;

import javax.ejb.Local;

import com.corvustec.notas.common.util.CorvustecException;

import ec.edu.uce.notas.ejb.persistence.entity.AccesoDTO;
import ec.edu.uce.notas.ejb.persistence.entity.ComponenteDTO;
import ec.edu.uce.notas.ejb.persistence.entity.ComponenteMenuDTO;
import ec.edu.uce.notas.ejb.persistence.entity.EmpresaDTO;
import ec.edu.uce.notas.ejb.persistence.entity.MenuDTO;
import ec.edu.uce.notas.ejb.persistence.entity.PerfilDTO;
import ec.edu.uce.notas.ejb.persistence.entity.UsuarioDTO;
import ec.edu.uce.notas.ejb.persistence.entity.view.AccesoViewDTO;
import ec.edu.uce.notas.ejb.persistence.entity.view.ComponenteMenuViewDTO;
import ec.edu.uce.notas.ejb.persistence.entity.view.MenuViewDTO;
import ec.edu.uce.notas.ejb.persistence.entity.view.UsuarioViewDTO;
import ec.edu.uce.notas.ejb.persistence.vo.AccesoVO;
import ec.edu.uce.notas.ejb.persistence.vo.UsuarioVO;

@Local
public interface AdministracionService {

	List<PerfilDTO> readPerfil(PerfilDTO perfilDTO) throws CorvustecException;

	PerfilDTO createOrUpdatePerfil(PerfilDTO perfilDTO)
			throws CorvustecException;

	MenuDTO createOrUpdateMenu(MenuDTO menuDTO) throws CorvustecException;

	List<MenuDTO> readMenuRoot() throws CorvustecException;

	List<MenuDTO> readMenu(MenuDTO menuDTO) throws CorvustecException;

	List<MenuViewDTO> menuReadAuthorized(PerfilDTO perfil)
			throws CorvustecException;

	ComponenteDTO createOrUpdateComponente(ComponenteDTO componenteDTO)
			throws CorvustecException;

	ComponenteMenuDTO createOrUpdateComponenteMenu(
			ComponenteMenuDTO componenteDTO) throws CorvustecException;

	List<ComponenteMenuDTO> readComponenteMenu(
			ComponenteMenuDTO componenteMenuDTO) throws CorvustecException;

	List<ComponenteMenuViewDTO> readComponanteMenuView(
			ComponenteMenuViewDTO componenteMenuVieDTO,
			AccesoViewDTO accesoVieDTO) throws CorvustecException;

	List<AccesoViewDTO> readAccesoView(AccesoViewDTO acceso)
			throws CorvustecException;

	List<AccesoViewDTO> readAccesoViewSubquery(AccesoViewDTO acceso)
			throws CorvustecException;

	List<AccesoViewDTO> readAccesoViewPerfilIsNull(AccesoViewDTO accesoViewDTO)
			throws CorvustecException;

	List<AccesoDTO> readAccesoDistincMenu(AccesoDTO accesoDTO)
			throws CorvustecException;

	void createOrUpdateAcceso(AccesoVO acceso) throws CorvustecException;

	void deleteAcceso(AccesoVO acceso) throws CorvustecException;

	List<ComponenteDTO> readComponente(ComponenteDTO componenteDTO)
			throws CorvustecException;

	UsuarioDTO readUsuario(UsuarioDTO usuario) throws CorvustecException;

	List<UsuarioDTO> readUsuarios(UsuarioDTO usuario) throws CorvustecException;

	List<UsuarioViewDTO> readUsuarioView(UsuarioViewDTO usuarioViewDTO)
			throws CorvustecException;

	List<UsuarioDTO> readUsuarioDynamic(UsuarioDTO usuarioDTO)
			throws CorvustecException;

	UsuarioDTO createUpdateUsuario(UsuarioVO usuarioVO)
			throws CorvustecException;

	EmpresaDTO createOrUpdateEmpresa(EmpresaDTO empresaDTO)
			throws CorvustecException;

	List<EmpresaDTO> readEmpresa(EmpresaDTO empresa) throws CorvustecException;

	List<EmpresaDTO> readDynamicEmpresa(EmpresaDTO empresaDTO)
			throws CorvustecException;



}
