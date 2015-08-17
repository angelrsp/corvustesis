package ec.edu.uce.notas.ejb.persistence.dao;

import java.util.List;

import com.corvustec.notas.common.util.CorvustecException;

import ec.edu.uce.notas.ejb.persistence.entity.ModeloDTO;

public interface ModeloDAO extends AbstractFacade<ModeloDTO>{

	List<ModeloDTO> getAll() throws CorvustecException;

	void remove2(ModeloDTO modelo);

}
