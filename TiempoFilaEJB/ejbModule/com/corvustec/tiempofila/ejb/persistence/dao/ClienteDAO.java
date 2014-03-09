package com.corvustec.tiempofila.ejb.persistence.dao;

import java.util.List;

import com.corvustec.tiempofila.ejb.persistence.entities.ClienteDTO;

public interface ClienteDAO extends AbstractFacade<ClienteDTO> {

	ClienteDTO getByIdentificator(ClienteDTO cliente);

}
