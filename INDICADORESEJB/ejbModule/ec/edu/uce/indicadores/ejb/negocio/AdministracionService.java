package ec.edu.uce.indicadores.ejb.negocio;

import java.util.List;

import javax.ejb.Local;

import ec.edu.uce.indicadores.commons.util.IndicadoresException;
import ec.edu.uce.indicadores.ejb.persistence.entities.CatalogoDTO;

@Local
public interface AdministracionService {

	List<CatalogoDTO> getCatalogo(CatalogoDTO catalogo)
			throws IndicadoresException;

}
