package ec.edu.uce.notas.ejb.persistence.dao;

import java.util.List;

import com.corvustec.notas.common.util.CorvustecException;

import ec.edu.uce.notas.ejb.persistence.entity.view.AlumnoViewDTO;

public interface AlumnoViewDAO {

	List<AlumnoViewDTO> getByAnd(AlumnoViewDTO objectDTO)
			throws CorvustecException;

	List<AlumnoViewDTO> getAutocomplete(AlumnoViewDTO objetoDTO)
			throws CorvustecException;

}
