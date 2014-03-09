package com.corvustec.tiempofila.ejb.negocio;

import javax.ejb.Local;

import com.corvustec.commons.util.CorvustecException;
import com.corvustec.tiempofila.ejb.persistence.util.dto.CredencialesDTO;

@Local
public interface AdministracionService {

	Boolean authentication(CredencialesDTO credencialesDTO)
			throws CorvustecException;

}
