package net.ciespal.redxxi.ejb.persistence.dao;

import java.util.List;

import com.corvustec.commons.util.CorvustecException;

import net.ciespal.redxxi.ejb.persistence.entities.CarreraDTO;
import net.ciespal.redxxi.ejb.persistence.entities.OrganizacionDTO;
import net.ciespal.redxxi.ejb.persistence.entities.ProyectoInvestigacionDTO;

public interface ProyectoInvestigacionDAO extends AbstractFacade<ProyectoInvestigacionDTO> {

	List<ProyectoInvestigacionDTO> getAll(CarreraDTO carrera)
			throws CorvustecException;

	void remove2(ProyectoInvestigacionDTO pro);

	List<ProyectoInvestigacionDTO> getAll(OrganizacionDTO org)
			throws CorvustecException;

}
