package ec.edu.uce.besg.ejb.persistence.dao;

import java.util.List;

import ec.edu.uce.besg.common.util.CorvustecException;
import ec.edu.uce.besg.ejb.persistence.entity.EmpresaDTO;

public interface EmpresaDAO extends AbstractFacade<EmpresaDTO>{

	List<EmpresaDTO> getByAnd(EmpresaDTO empresaDTO) throws CorvustecException;

}
