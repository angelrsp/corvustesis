package ec.edu.uce.notas.ejb.persistence.dao;

import java.util.List;

import com.corvustec.notas.common.util.CorvustecException;

import ec.edu.uce.notas.ejb.persistence.entity.DocenteDTO;

public interface DocenteDAO extends AbstractFacade<DocenteDTO> {

	List<DocenteDTO> getByAnd(DocenteDTO objectDTO) throws CorvustecException;

}
