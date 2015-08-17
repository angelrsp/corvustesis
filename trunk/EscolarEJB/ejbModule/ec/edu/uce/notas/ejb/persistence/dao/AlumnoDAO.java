package ec.edu.uce.notas.ejb.persistence.dao;

import java.util.List;

import com.corvustec.notas.common.util.CorvustecException;

import ec.edu.uce.notas.ejb.persistence.entity.AlumnoDTO;

public interface AlumnoDAO extends AbstractFacade<AlumnoDTO>{

	List<AlumnoDTO> getByAnd(AlumnoDTO objectDTO) throws CorvustecException;

	
	
}
