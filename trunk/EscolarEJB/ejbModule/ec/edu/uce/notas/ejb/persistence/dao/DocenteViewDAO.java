package ec.edu.uce.notas.ejb.persistence.dao;

import java.util.List;

import com.corvustec.notas.common.util.CorvustecException;

import ec.edu.uce.notas.ejb.persistence.entity.view.DocenteViewDTO;

public interface DocenteViewDAO extends AbstractFacade<DocenteViewDTO> {

	List<DocenteViewDTO> getByAnd(DocenteViewDTO objectDTO)
			throws CorvustecException;

}
