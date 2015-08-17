package ec.edu.uce.notas.ejb.persistence.dao;

import java.util.List;

import com.corvustec.notas.common.util.CorvustecException;

import ec.edu.uce.notas.ejb.persistence.entity.view.UsuarioViewDTO;

public interface UsuarioViewDAO extends AbstractFacade<UsuarioViewDTO>{

	List<UsuarioViewDTO> getByAnd(UsuarioViewDTO objeto) throws CorvustecException;

}
