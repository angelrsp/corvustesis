package ec.edu.uce.indicadores.ejb.negocio.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ec.edu.uce.indicadores.commons.util.IndicadoresException;
import ec.edu.uce.indicadores.ejb.negocio.IndicadorService;
import ec.edu.uce.indicadores.ejb.persistence.dao.FactoryDAO;
import ec.edu.uce.indicadores.ejb.persistence.entities.ContactoDTO;
import ec.edu.uce.indicadores.ejb.persistence.entities.ContactoListDTO;
import ec.edu.uce.indicadores.ejb.persistence.entities.EvidenciaDTO;
import ec.edu.uce.indicadores.ejb.persistence.entities.HistoricoIndicadorDTO;
import ec.edu.uce.indicadores.ejb.persistence.entities.IesDTO;
import ec.edu.uce.indicadores.ejb.persistence.entities.IndicadorDTO;
import ec.edu.uce.indicadores.ejb.persistence.entities.ModeloDTO;
import ec.edu.uce.indicadores.ejb.persistence.entities.RegistroDTO;
import ec.edu.uce.indicadores.ejb.persistence.entities.RepresentanteLegalDTO;
import ec.edu.uce.indicadores.ejb.persistence.entities.RepresentanteLegalListDTO;

@Stateless
public class IndicadorServiceImpl implements IndicadorService {

	@EJB
	private FactoryDAO factoryDAO;
	
	private static final Logger log = LoggerFactory
			.getLogger(IndicadorServiceImpl.class);

	
	
	@Override
	public void agregarRepresentanteLegal(RepresentanteLegalDTO representanteLegalDTO) throws IndicadoresException
	{
		log.info("agregarRepresentanteLegal");
		try {
			factoryDAO.getRepresentanteLegalDAOImpl().create(representanteLegalDTO);
		} catch (Exception e) {
			log.error(e.toString());
			throw new IndicadoresException(e);
		}
	}

	@Override
	public void agregarContacto(ContactoDTO contactoDTO) throws IndicadoresException
	{
		log.info("agregarContacto");
		try {
			factoryDAO.getContactoDAOImpl().create(contactoDTO);
		} catch (Exception e) {
			log.error(e.toString());
			throw new IndicadoresException(e);
		}
	}

	@Override
	public void agregarIes(IesDTO iesDTO) throws IndicadoresException
	{
		log.info("agregarIes");
		try {
			factoryDAO.getIesDAOImpl().create(iesDTO);
		} catch (Exception e) {
			log.error("agregarIes {}",e.toString());
			throw new IndicadoresException(e);
		}
	}

	@Override
	public void agregarIndicador(IndicadorDTO indicadorDTO) throws IndicadoresException
	{
		log.info("agregarIndicador");
		try {
			factoryDAO.getIndicadorDAOImpl().create(indicadorDTO);
		} catch (Exception e) {
			log.error(e.toString());
			throw new IndicadoresException(e);
		}
	}

	
	@Override
	public List<RepresentanteLegalListDTO> obtenerRepresentantes() throws IndicadoresException
	{
		try {
			return factoryDAO.getRepresentanteLegalDAOImpl().getAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new IndicadoresException(e);
		}
	}
	
	@Override
	public List<ContactoListDTO> obtenerContactos(RepresentanteLegalDTO representanteLegalDTO) throws IndicadoresException
	{
		try {
			return factoryDAO.getContactoDAOImpl().getAll(representanteLegalDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new IndicadoresException(e);
		}
	}
	
	@Override
	public List<IesDTO> obtenerIes() throws IndicadoresException
	{
		try {
			return factoryDAO.getIesDAOImpl().getAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new IndicadoresException(e);
		}
	}

	@Override
	public List<ModeloDTO> obtenerModelo() throws IndicadoresException
	{
		try {
			return factoryDAO.getModeloDAOImpl().getAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new IndicadoresException(e);
		}
	}
	
	@Override
	public List<IndicadorDTO> obtenerIndicador() throws IndicadoresException
	{
		try {
			return factoryDAO.getIndicadorDAOImpl().getAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new IndicadoresException(e);
		}
	}
	
	
	@Override
	public IndicadorDTO obtenerIndicador(Object id) throws IndicadoresException
	{
		try {
			return factoryDAO.getIndicadorDAOImpl().find(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new IndicadoresException(e);
		}
	}
	
	@Override
	public List<IndicadorDTO> obtenerRaizIndicador(IndicadorDTO indicadorDTO) throws IndicadoresException
	{
		try {
			return factoryDAO.getIndicadorDAOImpl().getRoot(indicadorDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new IndicadoresException(e);
		}
	}

	@Override
	public List<IndicadorDTO> obtenerHijosIndicador(IndicadorDTO indicadorDTO) throws IndicadoresException
	{
		try {
			return factoryDAO.getIndicadorDAOImpl().getChildren(indicadorDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new IndicadoresException(e);
		}
	}

	
	@Override
	public void agregarValor(HistoricoIndicadorDTO historicoIndicadorDTO) throws IndicadoresException
	{
		log.info("agregarIndicador");
		try {
			
			IndicadorDTO ind= factoryDAO.getIndicadorDAOImpl().find(historicoIndicadorDTO.getIndIndicador().getIndCodigo());
			if(ind.getIndValorInicial()==null)
				ind.setIndValorInicial(historicoIndicadorDTO.getHinValor());				
			ind.setIndValorActual(historicoIndicadorDTO.getHinValor());
			factoryDAO.getIndicadorDAOImpl().edit(ind);
			factoryDAO.getHistoricoIndicadorDAOImpl().create(historicoIndicadorDTO);
		} catch (Exception e) {
			log.error(e.toString());
			throw new IndicadoresException(e);
		}
	}
	
	
	@Override
	/*
	 * (non-Javadoc)
	 * @see ec.edu.uce.indicadores.ejb.negocio.IndicadorService#obtenerValores(ec.edu.uce.indicadores.ejb.persistence.entities.IndicadorDTO)
	 * Valores para reporte
	 */
	public List<HistoricoIndicadorDTO> obtenerValores(IndicadorDTO indicadorDTO) throws IndicadoresException
	{
		List<HistoricoIndicadorDTO> hisList=null;
		List<HistoricoIndicadorDTO> hisListAux=null;
		IndicadorDTO indTemp;
		try {
			if(indicadorDTO.getIndIndicadors().isEmpty())
				hisList= factoryDAO.getHistoricoIndicadorDAOImpl().getAll(indicadorDTO);
			else
			{
				int tam;
				BigDecimal inicial = BigDecimal.ZERO,actual=BigDecimal.ZERO;
				for(IndicadorDTO ind: indicadorDTO.getIndIndicadors())
				{
					hisListAux=factoryDAO.getHistoricoIndicadorDAOImpl().getAll(ind);
					if(hisListAux!=null)
					{
						tam=hisListAux.size();
						inicial=BigDecimal.valueOf(inicial.doubleValue()+hisListAux.get(0).getHinValor().doubleValue());
						actual=BigDecimal.valueOf(actual.doubleValue()+ hisListAux.get(tam-1).getHinValor().doubleValue());
					}
				}
				indicadorDTO=factoryDAO.getIndicadorDAOImpl().find(indicadorDTO.getIndCodigo());
				indicadorDTO.setIndValorActual(actual);
				indicadorDTO.setIndValorInicial(inicial);
				factoryDAO.getIndicadorDAOImpl().edit(indicadorDTO);	
				
				inicial = BigDecimal.ZERO;actual=BigDecimal.ZERO;
				
					for(IndicadorDTO ind: indicadorDTO.getIndIndicadors())
					{
						indTemp= factoryDAO.getIndicadorDAOImpl().find(ind.getIndCodigo());
						inicial=BigDecimal.valueOf(inicial.doubleValue()+(indTemp.getIndValorInicial()!=null? indTemp.getIndValorInicial().doubleValue():0));
						actual=BigDecimal.valueOf(actual.doubleValue()+(indTemp.getIndValorActual()!=null?indTemp.getIndValorActual().doubleValue():0));
					}
					indicadorDTO=factoryDAO.getIndicadorDAOImpl().find(indicadorDTO.getIndCodigo());
					indicadorDTO.setIndValorActual(actual);
					indicadorDTO.setIndValorInicial(inicial);
					factoryDAO.getIndicadorDAOImpl().edit(indicadorDTO);										
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new IndicadoresException(e);
		}
		return hisList;
	}
	
	
	@Override
	public void agregarEvidencia(EvidenciaDTO evidenciaDTO) throws IndicadoresException
	{
		log.info("agregarEvidencia");
		try {
			factoryDAO.getEvidenciaDAOImpl().create(evidenciaDTO);
		} catch (Exception e) {
			log.error(e.toString());
			throw new IndicadoresException(e);
		}
	}
	
	
	@Override
	public List<EvidenciaDTO> obtenerEvidencias(HistoricoIndicadorDTO historicoIndicadorDTO) throws IndicadoresException
	{
		try {
			return factoryDAO.getEvidenciaDAOImpl().getAll(historicoIndicadorDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new IndicadoresException(e);
		}
	}
	

	@Override
	public void agregarRegistro(RegistroDTO registroDTO) throws IndicadoresException
	{
		log.info("agregarRegistro");
		try {
			factoryDAO.getRegistroDAOImpl().create(registroDTO);
		} catch (Exception e) {
			log.error(e.toString());
			throw new IndicadoresException(e);
		}
	}
	
	
	@Override
	public List<RegistroDTO> obtenerRegistro(RepresentanteLegalDTO representanteLegalDTO,IesDTO iesDTO) throws IndicadoresException
	{
		try {
			return factoryDAO.getRegistroDAOImpl().getAll(representanteLegalDTO, iesDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new IndicadoresException(e);
		}
	}

	@Override
	public List<RegistroDTO> obtenerRegistro(IesDTO iesDTO) throws IndicadoresException
	{
		try {
			return factoryDAO.getRegistroDAOImpl().getAll(iesDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new IndicadoresException(e);
		}
	}
	
	@Override
	public ModeloDTO agregarModelo(ModeloDTO modeloDTO) throws IndicadoresException
	{
		log.info("agregarModelo");
		try {
			return factoryDAO.getModeloDAOImpl().create(modeloDTO);
		} catch (Exception e) {
			log.error("Error agregarModelo {}",e.toString());
			throw new IndicadoresException(e);
		}
	}
}
