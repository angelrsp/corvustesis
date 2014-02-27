package ec.edu.uce.indicadores.ejb.negocio.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ec.edu.uce.indicadores.commons.util.ApplicationUtil;
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
	
	private static final Logger log = LoggerFactory.getLogger(IndicadorServiceImpl.class);

	
	
	@Override
	public void createOrUpdateRepresentanteLegal(RepresentanteLegalDTO representanteLegalDTO) throws IndicadoresException
	{
		log.info("createOrUpdateRepresentanteLegal");
		try {
			if(representanteLegalDTO.getRleCodigo()!=null)
				factoryDAO.getRepresentanteLegalDAOImpl().edit(representanteLegalDTO);
			else
				factoryDAO.getRepresentanteLegalDAOImpl().create(representanteLegalDTO);
		} catch (Exception e) {
			log.error("createOrUpdateRepresentanteLegal {}",e.toString());
			throw new IndicadoresException(e);
		}
	}

	@Override
	public void deleteRepresentanteLegal(RepresentanteLegalDTO representanteLegalDTO) throws IndicadoresException
	{
		log.info("deleteRepresentanteLegal");
		try {
			if(obtenerRegistro(representanteLegalDTO)==null)
				factoryDAO.getRepresentanteLegalDAOImpl().remove2(representanteLegalDTO);
			else
				throw new IndicadoresException("No fue posible borrar existen dependencias");
		} catch (Exception e) {
			log.error("obtenerRegistro {}",e.toString());
			throw new IndicadoresException(e);
		}
	}
	
	@Override
	public List<RegistroDTO> obtenerRegistro(RepresentanteLegalDTO rep) throws IndicadoresException
	{
		log.info("obtenerRegistro");
		try {
			return factoryDAO.getRegistroDAOImpl().getAll(rep);
		} catch (Exception e) {
			throw new IndicadoresException(e);
		}
	}

	@Override
	public void deleteRegistro(RegistroDTO registro) throws IndicadoresException
	{
		log.info("deleteRegistro");
		try {
			factoryDAO.getRegistroDAOImpl().remove(registro);
		} catch (Exception e) {
			throw new IndicadoresException(e);
		}
	}

	
	@Override
	public void createOrUpdateContacto(ContactoDTO contactoDTO) throws IndicadoresException
	{
		log.info("createOrUpdateContacto");
		try {
			if(contactoDTO.getConCodigo()!=null)
				factoryDAO.getContactoDAOImpl().edit(contactoDTO);
			else
				factoryDAO.getContactoDAOImpl().create(contactoDTO);
		} catch (Exception e) {
			log.error(e.toString());
			throw new IndicadoresException(e);
		}
	}

	@Override
	public void deleteContacto(ContactoDTO contactoDTO) throws IndicadoresException
	{
		log.info("deleteContacto");
		try {
			factoryDAO.getContactoDAOImpl().remove(contactoDTO);
		} catch (Exception e) {
			log.error(e.toString());
			throw new IndicadoresException(e);
		}
	}

	
	@Override
	public void createOrUpdateIes(IesDTO iesDTO) throws IndicadoresException
	{
		log.info("createOrUpdateIes");
		try {
			if(iesDTO.getIesImagenName()!=null)
				ApplicationUtil.deletefile(iesDTO.getIesImagenName());
			if(iesDTO.getIesCodigo()!=null)
				factoryDAO.getIesDAOImpl().edit(iesDTO);
			else
				factoryDAO.getIesDAOImpl().create(iesDTO);
		} catch (Exception e) {
			log.error("createOrUpdateIes {}",e.toString());
			throw new IndicadoresException(e);
		}
	}

	@Override
	public void deleteIes(IesDTO iesDTO) throws IndicadoresException
	{
		log.info("deleteIes");
		try {
			if(obtenerRegistro(iesDTO)==null)
				factoryDAO.getIesDAOImpl().remove2(iesDTO);
			else
				throw new IndicadoresException("No fue posible borrar existen dependencias");
		} catch (Exception e) {
			log.error("deleteIes {}",e.toString());
			throw new IndicadoresException(e);
		}
	}

	
	
	@Override
	public void createOrUpdateIndicador(IndicadorDTO indicadorDTO) throws IndicadoresException
	{
		log.info("createOrUpdateIndicador");
		try {
			if(indicadorDTO.getIndCodigo()!=null)
				factoryDAO.getIndicadorDAOImpl().edit(indicadorDTO);
			else
				factoryDAO.getIndicadorDAOImpl().create(indicadorDTO);
		} catch (Exception e) {
			log.error(e.toString());
			throw new IndicadoresException(e);
		}
	}

	@Override
	public void deleteIndicador(IndicadorDTO indicador) throws IndicadoresException
	{
		log.info("deleteIndicador");
		try {
			if(indicador.getIndHistoricoIndicadors()!=null)
				factoryDAO.getIndicadorDAOImpl().remove2(indicador);
			else
				throw new IndicadoresException("No se puede eliminar revise las dependencias del indicador seleccionado");
		} catch (Exception e) {
			log.error(e.toString());
			throw new IndicadoresException("No se puede eliminar revise las dependencias del indicador seleccionado");
		}
	}
	
	@Override
	public List<RepresentanteLegalListDTO> obtenerRepresentantes() throws IndicadoresException
	{
		try {
			return factoryDAO.getRepresentanteLegalDAOImpl().getAll();
		} catch (Exception e) {
			throw new IndicadoresException(e);
		}
	}
	
	@Override
	public List<ContactoListDTO> obtenerContactos(RepresentanteLegalDTO representanteLegalDTO) throws IndicadoresException
	{
		try {
			return factoryDAO.getContactoDAOImpl().getAll(representanteLegalDTO);
		} catch (Exception e) {
			throw new IndicadoresException(e);
		}
	}
	
	@Override
	public List<IesDTO> obtenerIes() throws IndicadoresException
	{
		try {
			return factoryDAO.getIesDAOImpl().getAll();
		} catch (Exception e) {
			throw new IndicadoresException(e);
		}
	}

	@Override
	public IesDTO obtenerIes(Object id) throws IndicadoresException
	{
		log.info("obtenerIes");
		try {
			return factoryDAO.getIesDAOImpl().find(id);
		} catch (Exception e) {
			throw new IndicadoresException(e);
		}
	}
	
	@Override
	public List<ModeloDTO> obtenerModelo() throws IndicadoresException
	{
		try {
			return factoryDAO.getModeloDAOImpl().getAll();
		} catch (Exception e) {
			throw new IndicadoresException(e);
		}
	}
	
	@Override
	public ModeloDTO obtenerModelo(Object id) throws IndicadoresException
	{
		log.info("obtenerModelo");
		try {
			return factoryDAO.getModeloDAOImpl().find(id);
		} catch (Exception e) {
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
		log.info("agregarValor");
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
	public List<HistoricoIndicadorDTO> obtenerValores(IndicadorDTO indicadorDTO) throws IndicadoresException
	{
		log.info("obtenerValores");
		try {
			return factoryDAO.getHistoricoIndicadorDAOImpl().getAll(indicadorDTO);
		}catch (Exception e) {
			log.error(e.toString());
			throw new IndicadoresException(e);
		}
		
	}
	
	@Override
	public void actualizarValores(IndicadorDTO indicadorDTO) throws IndicadoresException
	{
		log.info("actualizarValores");
		BigDecimal inicial = BigDecimal.ZERO,actual=BigDecimal.ZERO;

		inicial=valor(indicadorDTO).get(0);
		actual=valor(indicadorDTO).get(1);
		indicadorDTO.setIndValorInicial(inicial);
		indicadorDTO.setIndValorActual(actual);
		factoryDAO.getIndicadorDAOImpl().edit(indicadorDTO);
	}
	
	private List<BigDecimal> valor(IndicadorDTO ind) throws IndicadoresException
	{
		List<HistoricoIndicadorDTO> hisListAux=null;
		hisListAux= factoryDAO.getHistoricoIndicadorDAOImpl().getAll(ind);
		List<BigDecimal> listVal=new ArrayList<BigDecimal>();
		List<BigDecimal> listValTemp=new ArrayList<BigDecimal>();
		
		listVal.add(0, BigDecimal.ZERO);
		listVal.add(1, BigDecimal.ZERO);
		
		int tam;
		//IndicadorDTO indTemp;
		BigDecimal inicial = BigDecimal.ZERO,actual=BigDecimal.ZERO;
		if(hisListAux!=null)
		{
			tam=hisListAux.size();
			listVal.set(0, BigDecimal.valueOf(listVal.get(0).doubleValue()+hisListAux.get(0).getHinValor().doubleValue()));
			listVal.set(1, BigDecimal.valueOf(listVal.get(1).doubleValue()+hisListAux.get(tam-1).getHinValor().doubleValue()));
		}
		else
		{
			for(IndicadorDTO indi: ind.getIndIndicadors())
			{
				listValTemp=valor(indi);
				listVal.set(0, BigDecimal.valueOf(inicial.doubleValue()+ listValTemp.get(0).doubleValue()));
				listVal.set(1,BigDecimal.valueOf(actual.doubleValue()+listValTemp.get(1).doubleValue()));
				
				inicial=listVal.get(0);
				actual=listVal.get(1);				
			}
			if(ind.getIndIndicadors().size()>0)
			{
				ind.setIndValorInicial(inicial);
				ind.setIndValorActual(actual);
				factoryDAO.getIndicadorDAOImpl().edit(ind);
			}			
		}
		return listVal;
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
			if(obtenerRegistro(registroDTO.getIndRepresentanteLegal(),registroDTO.getIndy())==null)
				factoryDAO.getRegistroDAOImpl().create(registroDTO);
			else
				throw new IndicadoresException("Ya ha sido asignado");
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
	public ModeloDTO createOrUpdateModelo(ModeloDTO modeloDTO) throws IndicadoresException
	{
		log.info("agregarModelo");
		try {
			if(modeloDTO.getModCodigo()!=null)
				return factoryDAO.getModeloDAOImpl().edit(modeloDTO);
			else
				return factoryDAO.getModeloDAOImpl().create(modeloDTO);
		} catch (Exception e) {
			log.error("Error agregarModelo {}",e.toString());
			throw new IndicadoresException(e);
		}
	}
	
	@Override
	public void deleteModelo(ModeloDTO modeloDTO) throws IndicadoresException
	{
		log.info("agregarModelo");
		try {
			if(obtenerIndicador(modeloDTO)==null)
				factoryDAO.getModeloDAOImpl().remove2(modeloDTO);
			else
				throw new IndicadoresException("No se puede borrar existen dependencias");
		} catch (Exception e) {
			log.error("Error agregarModelo {}",e.toString());
			throw new IndicadoresException(e);
		}
	}
	
	public List<IndicadorDTO> obtenerIndicador(ModeloDTO modelo) throws IndicadoresException
	{
		try {
			return factoryDAO.getIndicadorDAOImpl().getAll(modelo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new IndicadoresException(e);
		}

	}
}
