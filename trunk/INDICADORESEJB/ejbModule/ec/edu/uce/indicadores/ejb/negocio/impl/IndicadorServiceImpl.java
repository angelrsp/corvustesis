package ec.edu.uce.indicadores.ejb.negocio.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
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
	
	private static final Logger log = LoggerFactory.getLogger(IndicadorServiceImpl.class);

	
	
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
