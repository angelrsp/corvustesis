package net.ciespal.redxxi.ejb.negocio.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import net.ciespal.redxxi.ejb.negocio.EspejoService;
import net.ciespal.redxxi.ejb.persistence.dao.FactoryDAO;
import net.ciespal.redxxi.ejb.persistence.entities.CatalogoDTO;
import net.ciespal.redxxi.ejb.persistence.entities.PaisDTO;
import net.ciespal.redxxi.ejb.persistence.entities.argos.ArgosDTO;
import net.ciespal.redxxi.ejb.persistence.entities.argos.ArgosVisorDTO;
import net.ciespal.redxxi.ejb.persistence.entities.argos.DefensorVieDTO;
import net.ciespal.redxxi.ejb.persistence.entities.argos.ObservatorioDTO;
import net.ciespal.redxxi.ejb.persistence.entities.argos.VeeduriaDTO;
import net.ciespal.redxxi.ejb.persistence.entities.espejo.EntidadEspejoDTO;
import net.ciespal.redxxi.ejb.persistence.entities.espejo.EspejoDTO;
import net.ciespal.redxxi.ejb.persistence.entities.espejo.EspejoVisorDTO;
import net.ciespal.redxxi.ejb.persistence.entities.espejo.EticaDTO;
import net.ciespal.redxxi.ejb.persistence.entities.espejo.GranMaestroDTO;
import net.ciespal.redxxi.ejb.persistence.entities.espejo.LeyDTO;
import net.ciespal.redxxi.ejb.persistence.entities.espejo.MaestroCiespalDTO;
import net.ciespal.redxxi.ejb.persistence.entities.espejo.NoticiaEspejoDTO;
import net.ciespal.redxxi.ejb.persistence.entities.espejo.ObraEspejoDTO;
import net.ciespal.redxxi.ejb.persistence.entities.espejo.PremioCiespalDTO;
import net.ciespal.redxxi.ejb.persistence.entities.espejo.PremioDTO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.corvustec.commons.util.CorvustecException;

@Stateless
public class EspejoServiceImpl implements EspejoService{

	private static final Logger logger = LoggerFactory.getLogger(EspejoServiceImpl.class);
	
	@EJB
	private FactoryDAO factoryDAO;

	@Override
	public List<EspejoDTO> readEspejo(Object pais) throws CorvustecException
	{
		List<EspejoDTO> espejoList;
		EspejoDTO espejo;
		logger.info("readEspejo");
		try{
			espejoList=new ArrayList<EspejoDTO>();

			//Etica y Deontologia
			espejo=new EspejoDTO();
			espejo.setTipo(1);
			espejo.setDescripcion("Etica y Deontologia: ");
			espejo.setCount(factoryDAO.getEticaDAOImpl().count(pais));
			espejoList.add(espejo);

			//Veedurias
//			argos=new ArgosDTO();
//			argos.setTipo(2);
//			argos.setDescripcion("Veedurías: ");
//			argos.setCount(factoryDAO.getVeeduriaDAOImpl().count(pais));
//			argosList.add(argos);			
//
//			//Defensores de Audiencia
//			argos=new ArgosDTO();
//			argos.setTipo(3);
//			argos.setDescripcion("Defensores de Audiencia: ");
//			argos.setCount(factoryDAO.getOpinionDAOImpl().count(pais));
//			argosList.add(argos);			

		}
		catch(Exception e){
			logger.info("Error readEspejo {}",e.toString());
			throw new CorvustecException("Error al readEspejo "+e.toString());
		}
		return espejoList;
	}

	
	@Override
	public int readEspejoCount() throws CorvustecException
	{
		int total;
		try {
			total = factoryDAO.getEticaDAOImpl().count(null);
			//factoryDAO.getCentroDAOImpl().getFacultadCount(null)+
//			factoryDAO.getCarreraDAOImpl().getPregradoCount(null)+
//			factoryDAO.getCarreraDAOImpl().getPosgradoCount(null)+
//			factoryDAO.getPublicacionDAOImpl().getCountByType(null,null)+
			//factoryDAO.getEventoDAOImpl().getCount(null)+
			//factoryDAO.getProyectoInvestigacionDAOImpl().getCount(null)+
//			factoryDAO.getOrganizacioDAOImpl().getCount(null)+
//			factoryDAO.getDoctorDAOImpl().getCount(null);
		}catch(Exception e)
		{
			logger.info("Error readEspejoCount {}",e.toString());
			throw new CorvustecException("Error al readEspejoCount " + e.toString());
		}
		return total;
	}

	@Override
	public List<PaisDTO> readPais(Object type) throws CorvustecException
	{
		List<PaisDTO> paisList=new ArrayList<PaisDTO>();
		PaisDTO pais;
		CatalogoDTO catalogo;

		catalogo=new CatalogoDTO();
		catalogo.setCatCodigo(13);
		
		if(type==null)
		{
			for(CatalogoDTO cat: factoryDAO.getCatalogoImpl().getAll(catalogo)){
				pais=new PaisDTO();
				pais.setCodigo(cat.getCatCodigo());
				pais.setImagenPath(cat.getCatImagenPath());
				pais.setNombre(cat.getCatDescripcion());
				paisList.add(pais);
			}
		}
		//Etica
		else if(type.equals(1))
		{
			for(CatalogoDTO cat: factoryDAO.getCatalogoImpl().getAll(catalogo)){
				pais=new PaisDTO();
				pais.setCodigo(cat.getCatCodigo());
				pais.setImagenPath(cat.getCatImagenPath());
				pais.setNombre(cat.getCatDescripcion());
				pais.setCount(factoryDAO.getEticaDAOImpl().count(cat.getCatCodigo()));
				pais.setTipo(Integer.valueOf(type.toString()));
				paisList.add(pais);
			}
		}
		return paisList;
	}
	
	@Override
	public List<EspejoVisorDTO> visorList(EspejoDTO espejo) throws CorvustecException
	{
		List<EspejoVisorDTO> espejoVisorList=new ArrayList<EspejoVisorDTO>();
		EspejoVisorDTO espejoVisor;
		
		if(espejo.getTipo()==0)
		{
		}
		//Etica
		else if(espejo.getTipo()==1)
		{
			EticaDTO eti=new EticaDTO();
			eti.setEtiPais(espejo.getPais());
			List<EticaDTO> listEtica=new ArrayList<EticaDTO>();
			
			listEtica=factoryDAO.getEticaDAOImpl().getByAnd(eti);
			
			for(EticaDTO objeto:listEtica){
					
				espejoVisor=new EspejoVisorDTO();
				espejoVisor.setCodigo(objeto.getEtiCodigo());
				
				espejoVisor.setTitulo("Etica y Deodologia: " +objeto.getEtiAutorNombre());
				espejoVisor.setDescripcion1("Datos Institucionales :"+objeto.getObsDatosInstitucionales());
				espejoVisor.setTipo(espejo.getTipo());

				espejoVisorList.add(espejoVisor);
				
			}	
		}
		return espejoVisorList;
	}

	
	
	/*Etica*/
	@Override
	public EticaDTO createOrUpdateEtica(EticaDTO etica) throws CorvustecException
	{
		logger.info("createOrUpdateEtica");
		try{
			if(etica.getEtiCodigo()!=null)
				return factoryDAO.getEticaDAOImpl().edit(etica);
			else			
			{
				etica.setEspEntidad(new EntidadEspejoDTO());
				return factoryDAO.getEticaDAOImpl().create(etica);
			}
		}
		catch(Exception e){
			logger.info("Error createOrUpdateRed {}",e.toString());
			throw new CorvustecException("Error al createOrUpdateRed");
		}
	}

	@Override
	public List<EticaDTO> readEtica(Object ciudad) throws CorvustecException
	{
		logger.info("readEtica");
		try{
			return factoryDAO.getEticaDAOImpl().findAll(ciudad);
		}
		catch(Exception e)
		{
			logger.info("Error readEtica {}",e.toString());
			throw new CorvustecException("Error al readEtica");
		}
	}

	/*Maestro Periodismo*/
	@Override
	public GranMaestroDTO createOrUpdateMaestroPeriodismo(GranMaestroDTO granMaestro) throws CorvustecException
	{
		logger.info("createOrUpdateMaestroPeriodismo");
		try{
			if(granMaestro.getGmaCodigo()!=null)
				return factoryDAO.getGranMaestroDAOImpl().edit(granMaestro);
			else			
			{
				granMaestro.setEspEntidad(new EntidadEspejoDTO());
				return factoryDAO.getGranMaestroDAOImpl().create(granMaestro);
			}
		}
		catch(Exception e){
			logger.info("Error createOrUpdateMaestroPeriodismo {}",e.toString());
			throw new CorvustecException("Error al createOrUpdateMaestroPeriodismo");
		}
	}

	@Override
	public List<GranMaestroDTO> readMaestroPeriodismo(Object ciudad) throws CorvustecException
	{
		logger.info("readMaestroPeriodismo");
		try{
			return factoryDAO.getGranMaestroDAOImpl().findAll(ciudad);
		}
		catch(Exception e)
		{
			logger.info("Error readMaestroPeriodismo {}",e.toString());
			throw new CorvustecException("Error al readMaestroPeriodismo");
		}
	}

	
	@Override
	public GranMaestroDTO getRandomGranMaesto() throws CorvustecException
	{
		logger.info("getRandomGranMaesto");
		int ran;
		try{
			List<GranMaestroDTO> list=factoryDAO.getGranMaestroDAOImpl().getByAnd(new GranMaestroDTO());
			if(!list.isEmpty())
			{
				ran = (int) (Math.random () * list.size());
				return list.get(ran);
			}
			else
				return new GranMaestroDTO();
		}
		catch(Exception e){
			logger.info("Error readDoctor {}",e.toString());
			throw new CorvustecException("Error al readDoctor");
		}		
	}
	
	/*Maestro Ciespal*/
	@Override
	public MaestroCiespalDTO createOrUpdateMaestroCiespal(MaestroCiespalDTO maestro) throws CorvustecException
	{
		logger.info("createOrUpdateMaestroCiespal");
		try{
			if(maestro.getMciCodigo()!=null)
				return factoryDAO.getMaestroCiespalDAOImpl().edit(maestro);
			else			
			{
				maestro.setEspEntidad(new EntidadEspejoDTO());
				return factoryDAO.getMaestroCiespalDAOImpl().create(maestro);
			}
		}
		catch(Exception e){
			logger.info("Error createOrUpdateMaestroCiespal {}",e.toString());
			throw new CorvustecException("Error al createOrUpdateMaestroCiespal");
		}
	}

	@Override
	public List<MaestroCiespalDTO> readMaestroCiespal(Object ciudad) throws CorvustecException
	{
		logger.info("readMaestroCiespal");
		try{
			return factoryDAO.getMaestroCiespalDAOImpl().findAll(ciudad);
		}
		catch(Exception e)
		{
			logger.info("Error readMaestroCiespal {}",e.toString());
			throw new CorvustecException("Error al readMaestroCiespal");
		}
	}

	@Override
	public MaestroCiespalDTO getRandomMaestoCiespal() throws CorvustecException
	{
		logger.info("getRandomMaestoCiespal");
		int ran;
		try{
			List<MaestroCiespalDTO> list=factoryDAO.getMaestroCiespalDAOImpl().getByAnd(new MaestroCiespalDTO());
			if(!list.isEmpty())
			{
				ran = (int) (Math.random () * list.size());
				return list.get(ran);
			}
			else
				return new MaestroCiespalDTO();
		}
		catch(Exception e){
			logger.info("Error getRandomMaestoCiespal {}",e.toString());
			throw new CorvustecException("Error al getRandomMaestoCiespal "+e.toString());
		}		
	}
	
	/*Premio Periodistico*/
	@Override
	public PremioDTO createOrUpdatePremio(PremioDTO premio) throws CorvustecException
	{
		logger.info("createOrUpdatePremio");
		try{
			if(premio.getPreCodigo()!=null)
				return factoryDAO.getPremioDAOImpl().edit(premio);
			else			
			{
				premio.setEspEntidad(new EntidadEspejoDTO());
				return factoryDAO.getPremioDAOImpl().create(premio);
			}
		}
		catch(Exception e){
			logger.info("Error createOrUpdatePremio {}",e.toString());
			throw new CorvustecException("Error al createOrUpdateMaestroCiespal");
		}
	}

	@Override
	public List<PremioDTO> readPremio(Object ciudad) throws CorvustecException
	{
		logger.info("readPremio");
		try{
			return factoryDAO.getPremioDAOImpl().findAll(ciudad);
		}
		catch(Exception e)
		{
			logger.info("Error readPremio {}",e.toString());
			throw new CorvustecException("Error al readPremio");
		}
	}
	
	
	/*Premio Ciespal*/
	@Override
	public PremioCiespalDTO createOrUpdatepremioCiespal(PremioCiespalDTO premioCiespal) throws CorvustecException
	{
		logger.info("createOrUpdatepremioCiespal");
		try{
			if(premioCiespal.getPciCodigo()!=null)
				return factoryDAO.getPremioCiespalDAOImpl().edit(premioCiespal);
			else			
			{
				premioCiespal.setEspEntidad(new EntidadEspejoDTO());
				return factoryDAO.getPremioCiespalDAOImpl().create(premioCiespal);
			}
		}
		catch(Exception e){
			logger.info("Error createOrUpdatepremioCiespal {}",e.toString());
			throw new CorvustecException("Error al createOrUpdatepremioCiespal");
		}
	}

	@Override
	public List<PremioCiespalDTO> readPremioCiespal(Object ciudad) throws CorvustecException
	{
		logger.info("readPremioCiespal");
		try{
			return factoryDAO.getPremioCiespalDAOImpl().findAll(ciudad);
		}
		catch(Exception e)
		{
			logger.info("Error readPremio {}",e.toString());
			throw new CorvustecException("Error al readPremio");
		}
	}
	
	
	/*LeyCodigo */
	@Override
	public LeyDTO createOrUpdateley(LeyDTO leyDTO) throws CorvustecException
	{
		logger.info("createOrUpdateley");
		try{
			if(leyDTO.getLeyCodigo()!=null)
				return factoryDAO.getLeyDAOImpl().edit(leyDTO);
			else			
			{
				leyDTO.setEspEntidad(new EntidadEspejoDTO());
				return factoryDAO.getLeyDAOImpl().create(leyDTO);
			}
		}
		catch(Exception e){
			logger.info("Error createOrUpdateley {}",e.toString());
			throw new CorvustecException("Error al createOrUpdateley");
		}
	}

	@Override
	public List<LeyDTO> readLey(Object ciudad) throws CorvustecException
	{
		logger.info("readLey");
		try{
			return factoryDAO.getLeyDAOImpl().findAll(ciudad);
		}
		catch(Exception e)
		{
			logger.info("Error readLey {}",e.toString());
			throw new CorvustecException("Error al readLey");
		}
	}
	
	/*Noticia*/
	@Override
	public NoticiaEspejoDTO createOrUpdateNoticia(NoticiaEspejoDTO noticia) throws CorvustecException
	{
		logger.info("createOrUpdateNoticia");
		try{
			if(noticia.getNotCodigo()!=null)
				return factoryDAO.getNoticiaEspejoDAOImpl().edit(noticia);
			else			
				return factoryDAO.getNoticiaEspejoDAOImpl().create(noticia);
		}
		catch(Exception e){
			logger.info("Error createOrUpdateNoticia {}",e.toString());
			throw new CorvustecException("Error al createOrUpdateNoticia");
		}		
	}
	
	@Override
	public List<NoticiaEspejoDTO> readNoticia(NoticiaEspejoDTO noticia) throws CorvustecException
	{
		logger.info("readNoticia");
		try{
			return factoryDAO.getNoticiaEspejoDAOImpl().findAll(noticia);
		}
		catch(Exception e)
		{
			logger.info("Error readNoticia {}",e.toString());
			throw new CorvustecException("Error al readNoticia");
		}
	}

	@Override
	public List<NoticiaEspejoDTO> readNoticia(EticaDTO etica) throws CorvustecException
	{
		logger.info("readNoticia");
		try{
			return factoryDAO.getNoticiaEspejoDAOImpl().findAll(etica);
		}
		catch(Exception e)
		{
			logger.info("Error readNoticia {}",e.toString());
			throw new CorvustecException("Error al readNoticia");
		}
	}

	@Override
	public List<NoticiaEspejoDTO> readNoticia(GranMaestroDTO maestro) throws CorvustecException
	{
		logger.info("readNoticia");
		try{
			return factoryDAO.getNoticiaEspejoDAOImpl().findAll(maestro);
		}
		catch(Exception e)
		{
			logger.info("Error readNoticia {}",e.toString());
			throw new CorvustecException("Error al readNoticia");
		}
	}

	@Override
	public List<NoticiaEspejoDTO> readNoticia(MaestroCiespalDTO maestro) throws CorvustecException
	{
		logger.info("readNoticia");
		try{
			return factoryDAO.getNoticiaEspejoDAOImpl().findAll(maestro);
		}
		catch(Exception e)
		{
			logger.info("Error readNoticia {}",e.toString());
			throw new CorvustecException("Error al readNoticia");
		}
	}

	@Override
	public List<NoticiaEspejoDTO> readNoticia(PremioDTO premio) throws CorvustecException
	{
		logger.info("readNoticia");
		try{
			return factoryDAO.getNoticiaEspejoDAOImpl().findAll(premio);
		}
		catch(Exception e)
		{
			logger.info("Error readNoticia {}",e.toString());
			throw new CorvustecException("Error al readNoticia");
		}
	}

	@Override
	public List<NoticiaEspejoDTO> readNoticia(PremioCiespalDTO premio) throws CorvustecException
	{
		logger.info("readNoticia");
		try{
			return factoryDAO.getNoticiaEspejoDAOImpl().findAll(premio);
		}
		catch(Exception e)
		{
			logger.info("Error readNoticia {}",e.toString());
			throw new CorvustecException("Error al readNoticia");
		}
	}

	@Override
	public List<NoticiaEspejoDTO> readNoticia(LeyDTO ley) throws CorvustecException
	{
		logger.info("readNoticia");
		try{
			return factoryDAO.getNoticiaEspejoDAOImpl().findAll(ley);
		}
		catch(Exception e)
		{
			logger.info("Error readNoticia {}",e.toString());
			throw new CorvustecException("Error al readNoticia");
		}
	}

	/*Obra*/
	@Override
	public ObraEspejoDTO createOrUpdateObra(ObraEspejoDTO obra) throws CorvustecException
	{
		logger.info("createOrUpdateObra");
		try{
			if(obra.getObrCodigo()!=null)
				return factoryDAO.getObraEspejoDAOImpl().edit(obra);
			else			
				return factoryDAO.getObraEspejoDAOImpl().create(obra);
		}
		catch(Exception e){
			logger.info("Error createOrUpdateObra {}",e.toString());
			throw new CorvustecException("Error al createOrUpdateObra");
		}		
	}
	
	@Override
	public List<ObraEspejoDTO> readObra(GranMaestroDTO maestro, Object type) throws CorvustecException
	{
		logger.info("readObra");
		try{
			return factoryDAO.getObraEspejoDAOImpl().findAll(maestro, type);
		}
		catch(Exception e)
		{
			logger.info("Error readObra {}",e.toString());
			throw new CorvustecException("Error al readObra");
		}
	}

	@Override
	public List<ObraEspejoDTO> readObra(MaestroCiespalDTO maestro, Object type) throws CorvustecException
	{
		logger.info("readObra");
		try{
			return factoryDAO.getObraEspejoDAOImpl().findAll(maestro, type);
		}
		catch(Exception e)
		{
			logger.info("Error readObra {}",e.toString());
			throw new CorvustecException("Error al readObra");
		}
	}

}
