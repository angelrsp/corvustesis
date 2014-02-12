package net.ciespal.redxxi.ejb.persistence.dao;

import java.util.List;

import net.ciespal.redxxi.ejb.persistence.entities.OrganizacionDTO;

public interface OrganizacioDAO extends AbstractFacade<OrganizacionDTO> {

	List<OrganizacionDTO> getAll(Object ubicacion);

	
}
