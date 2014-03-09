package com.corvustec.tiempofila.ejb.negocio;

import javax.ejb.Local;

import com.corvustec.commons.util.CorvustecException;
import com.corvustec.tiempofila.ejb.persistence.vo.TomaVO;

@Local
public interface TiempoService {

	Boolean createTomaInicio(TomaVO toma) throws CorvustecException;

	
	
}
