package net.ciespal.redxxi.ejb.persistence.dao;

import java.util.List;

import com.corvustec.commons.util.CorvustecException;

import net.ciespal.redxxi.ejb.persistence.entities.OrganizacionDTO;

public interface OrganizacioDAO extends AbstractFacade<OrganizacionDTO> {

	List<OrganizacionDTO> getAll(Object ubicacion);

	List<OrganizacionDTO> getAll();

	Integer getCount(Object pais) throws CorvustecException;

	void remove2(OrganizacionDTO organizacion) throws CorvustecException;

	List<OrganizacionDTO> getAll2(Object pais);

	
}
