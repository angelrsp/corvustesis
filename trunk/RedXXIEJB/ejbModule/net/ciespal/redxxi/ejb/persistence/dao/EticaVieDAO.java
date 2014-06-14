package net.ciespal.redxxi.ejb.persistence.dao;

import java.util.List;

import net.ciespal.redxxi.ejb.persistence.entities.espejo.EticaVieDTO;

import com.corvustec.commons.util.CorvustecException;

public interface EticaVieDAO {

	List<EticaVieDTO> getByAnd(EticaVieDTO objetoDTO) throws CorvustecException;

}
