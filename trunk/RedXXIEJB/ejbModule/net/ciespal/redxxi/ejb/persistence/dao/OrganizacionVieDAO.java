package net.ciespal.redxxi.ejb.persistence.dao;

import java.util.List;

import com.corvustec.commons.util.CorvustecException;

import net.ciespal.redxxi.ejb.persistence.entities.OrganizacionVieDTO;

public interface OrganizacionVieDAO extends AbstractFacade<OrganizacionVieDTO>{

	List<OrganizacionVieDTO> getByAnd(OrganizacionVieDTO doctorVieDTO)
			throws CorvustecException;

	
}
