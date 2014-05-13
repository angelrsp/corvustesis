package net.ciespal.redxxi.ejb.negocio.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import net.ciespal.redxxi.ejb.negocio.AteneaService;
import net.ciespal.redxxi.ejb.persistence.dao.FactoryDAO;
import net.ciespal.redxxi.ejb.persistence.entities.AteneaDTO;
import net.ciespal.redxxi.ejb.persistence.entities.AteneaVisorDTO;
import net.ciespal.redxxi.ejb.persistence.entities.CarreraDTO;
import net.ciespal.redxxi.ejb.persistence.entities.CatalogoDTO;
import net.ciespal.redxxi.ejb.persistence.entities.CentroDTO;
import net.ciespal.redxxi.ejb.persistence.entities.ContactoDTO;
import net.ciespal.redxxi.ejb.persistence.entities.ContactoListDTO;
import net.ciespal.redxxi.ejb.persistence.entities.DoctorDTO;
import net.ciespal.redxxi.ejb.persistence.entities.DoctorListDTO;
import net.ciespal.redxxi.ejb.persistence.entities.EntidadDTO;
import net.ciespal.redxxi.ejb.persistence.entities.EventoDTO;
import net.ciespal.redxxi.ejb.persistence.entities.FacultadListDTO;
import net.ciespal.redxxi.ejb.persistence.entities.MencionDTO;
import net.ciespal.redxxi.ejb.persistence.entities.ModalidadDTO;
import net.ciespal.redxxi.ejb.persistence.entities.NoticiaDTO;
import net.ciespal.redxxi.ejb.persistence.entities.ObraDTO;
import net.ciespal.redxxi.ejb.persistence.entities.OrganizacionDTO;
import net.ciespal.redxxi.ejb.persistence.entities.PaisDTO;
import net.ciespal.redxxi.ejb.persistence.entities.ProyectoInvestigacionDTO;
import net.ciespal.redxxi.ejb.persistence.entities.PublicacionDTO;
import net.ciespal.redxxi.ejb.persistence.entities.UniversidadListDTO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.corvustec.commons.util.CorvustecException;

@Stateless
public class AteneaServiceImpl implements AteneaService{

	private static final Logger logger = LoggerFactory.getLogger(AteneaServiceImpl.class);
	
	@EJB
	private FactoryDAO factoryDAO;
	
	/* Atenea*/
	@Override
	public List<AteneaDTO> readAtenea(Object pais) throws CorvustecException	
	{
		List<AteneaDTO> ateneaList=new ArrayList<AteneaDTO>();
		AteneaDTO atenea;
		
		try {
			atenea=new AteneaDTO();
			atenea.setCodigo(1);
			atenea.setDescripcion("Universidades: ");
			atenea.setCount(factoryDAO.getCentroDAOImpl().getUniversidadCount(pais));
			atenea.setTipo(2);
			ateneaList.add(atenea);
			
//			atenea=new AteneaDTO();
//			atenea.setCodigo(2);
//			atenea.setDescripcion("Facultades: ");
//			atenea.setCount(factoryDAO.getCentroDAOImpl().getFacultadCount(pais));
//			atenea.setTipo(3);
//			ateneaList.add(atenea);
	
			atenea=new AteneaDTO();
			atenea.setCodigo(3);
			atenea.setDescripcion("Carreras de Pregrado: ");
			atenea.setCount(factoryDAO.getCarreraDAOImpl().getPregradoCount(pais));
			atenea.setTipo(6);
			ateneaList.add(atenea);
			
			atenea=new AteneaDTO();
			atenea.setCodigo(4);
			atenea.setDescripcion("Carreras de Posgrado: ");
			atenea.setCount(factoryDAO.getCarreraDAOImpl().getPosgradoCount(pais));
			atenea.setTipo(7);
			ateneaList.add(atenea);
			
//			atenea=new AteneaDTO();
//			atenea.setCodigo(5);
//			atenea.setDescripcion("Revistas Científicas: ");
//			atenea.setCount(factoryDAO.getPublicacionDAOImpl().getCountByType(34,pais));
//			atenea.setTipo(34);
//			ateneaList.add(atenea);
	
//			atenea=new AteneaDTO();
//			atenea.setCodigo(6);
//			atenea.setDescripcion("Eventos Científicos: ");
//			atenea.setCount(factoryDAO.getEventoDAOImpl().getCount(pais));
//			atenea.setTipo(101);
//			ateneaList.add(atenea);
	
//			atenea=new AteneaDTO();
//			atenea.setCodigo(7);
//			atenea.setDescripcion("Proyectos de Investigación: ");
//			atenea.setCount(factoryDAO.getProyectoInvestigacionDAOImpl().getCount(pais));
//			atenea.setTipo(102);
//			ateneaList.add(atenea);
			
			atenea=new AteneaDTO();
			atenea.setCodigo(8);
			atenea.setDescripcion("Organizaciones Científicas: ");
			atenea.setCount(factoryDAO.getOrganizacioDAOImpl().getCount(pais));
			atenea.setTipo(103);			
			ateneaList.add(atenea);
	
			atenea=new AteneaDTO();
			atenea.setCodigo(9);
			atenea.setDescripcion("Doctores en Ciencias: ");
			atenea.setCount(factoryDAO.getDoctorDAOImpl().getCount(pais));
			atenea.setTipo(104);
			ateneaList.add(atenea);
						
			atenea=new AteneaDTO();
			atenea.setCodigo(10);
			atenea.setDescripcion("Articulos, Monografías, Tesis, Libros, Revistas: ");
			atenea.setCount(factoryDAO.getPublicacionDAOImpl().getCountByType(null,pais));
			atenea.setTipo(105);
			ateneaList.add(atenea);

		}catch(Exception e)
		{
			logger.info("Error createCentro {}",e.toString());
			throw new CorvustecException("Error al createCentro");
		}
		return ateneaList;
	}
	
	@Override
	public int rearAteneaCount() throws CorvustecException
	{
		int total;
		try {
			total = factoryDAO.getCentroDAOImpl().getUniversidadCount(null)+
			//factoryDAO.getCentroDAOImpl().getFacultadCount(null)+
			factoryDAO.getCarreraDAOImpl().getPregradoCount(null)+
			factoryDAO.getCarreraDAOImpl().getPosgradoCount(null)+
			factoryDAO.getPublicacionDAOImpl().getCountByType(null,null)+
			//factoryDAO.getEventoDAOImpl().getCount(null)+
			//factoryDAO.getProyectoInvestigacionDAOImpl().getCount(null)+
			factoryDAO.getOrganizacioDAOImpl().getCount(null)+
			factoryDAO.getDoctorDAOImpl().getCount(null);
		}catch(Exception e)
		{
			logger.info("Error createCentro {}",e.toString());
			throw new CorvustecException("Error al createCentro");
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
		//Universidad
		else if(type.equals(2))
		{
			for(CatalogoDTO cat: factoryDAO.getCatalogoImpl().getAll(catalogo)){
				pais=new PaisDTO();
				pais.setCodigo(cat.getCatCodigo());
				pais.setImagenPath(cat.getCatImagenPath());
				pais.setNombre(cat.getCatDescripcion());
				pais.setCount(factoryDAO.getCentroDAOImpl().getUniversidadCount(cat.getCatCodigo()));
				pais.setTipo(Integer.valueOf(type.toString()));
				paisList.add(pais);
			}
		}//Facultad
		else if(type.equals(3))
		{
			for(CatalogoDTO cat: factoryDAO.getCatalogoImpl().getAll(catalogo)){
				pais=new PaisDTO();
				pais.setCodigo(cat.getCatCodigo());
				pais.setImagenPath(cat.getCatImagenPath());
				pais.setNombre(cat.getCatDescripcion());
				pais.setCount(factoryDAO.getCentroDAOImpl().getFacultadCount(cat.getCatCodigo()));
				pais.setTipo(Integer.valueOf(type.toString()));
				paisList.add(pais);
			}			
		}//Pregrado
		else if(type.equals(6))
		{
			for(CatalogoDTO cat: factoryDAO.getCatalogoImpl().getAll(catalogo)){
				pais=new PaisDTO();
				pais.setCodigo(cat.getCatCodigo());
				pais.setImagenPath(cat.getCatImagenPath());
				pais.setNombre(cat.getCatDescripcion());
				pais.setCount(factoryDAO.getCarreraDAOImpl().getPregradoCount(cat.getCatCodigo()));
				pais.setTipo(Integer.valueOf(type.toString()));
				paisList.add(pais);
			}			
		}//Posgrado
		else if(type.equals(7))
		{
			for(CatalogoDTO cat: factoryDAO.getCatalogoImpl().getAll(catalogo)){
				pais=new PaisDTO();
				pais.setCodigo(cat.getCatCodigo());
				pais.setImagenPath(cat.getCatImagenPath());
				pais.setNombre(cat.getCatDescripcion());
				pais.setCount(factoryDAO.getCarreraDAOImpl().getPosgradoCount(cat.getCatCodigo()));
				pais.setTipo(Integer.valueOf(type.toString()));
				paisList.add(pais);
			}
		}//Revista
		else if(type.equals(34))
		{
			for(CatalogoDTO cat: factoryDAO.getCatalogoImpl().getAll(catalogo)){
				pais=new PaisDTO();
				pais.setCodigo(cat.getCatCodigo());
				pais.setImagenPath(cat.getCatImagenPath());
				pais.setNombre(cat.getCatDescripcion());
				pais.setCount(factoryDAO.getPublicacionDAOImpl().getCountByType(34,cat.getCatCodigo()));
				pais.setTipo(Integer.valueOf(type.toString()));
				paisList.add(pais);
			}
		}//Eventos
		else if(type.equals(101))
		{
			for(CatalogoDTO cat: factoryDAO.getCatalogoImpl().getAll(catalogo)){
				pais=new PaisDTO();
				pais.setCodigo(cat.getCatCodigo());
				pais.setImagenPath(cat.getCatImagenPath());
				pais.setNombre(cat.getCatDescripcion());
				pais.setCount(factoryDAO.getEventoDAOImpl().getCount(cat.getCatCodigo()));
				pais.setTipo(Integer.valueOf(type.toString()));
				paisList.add(pais);
			}
		}//Proyectos de Investigacion
		else if(type.equals(102))
		{
			for(CatalogoDTO cat: factoryDAO.getCatalogoImpl().getAll(catalogo)){
				pais=new PaisDTO();
				pais.setCodigo(cat.getCatCodigo());
				pais.setImagenPath(cat.getCatImagenPath());
				pais.setNombre(cat.getCatDescripcion());
				pais.setCount(factoryDAO.getProyectoInvestigacionDAOImpl().getCount(cat.getCatCodigo()));
				pais.setTipo(Integer.valueOf(type.toString()));
				paisList.add(pais);
			}
		}//Organizacion
		else if(type.equals(103))
		{
			for(CatalogoDTO cat: factoryDAO.getCatalogoImpl().getAll(catalogo)){
				pais=new PaisDTO();
				pais.setCodigo(cat.getCatCodigo());
				pais.setImagenPath(cat.getCatImagenPath());
				pais.setNombre(cat.getCatDescripcion());
				pais.setCount(factoryDAO.getOrganizacioDAOImpl().getCount(cat.getCatCodigo()));
				pais.setTipo(Integer.valueOf(type.toString()));
				paisList.add(pais);
			}
		}//Doctor
		else if(type.equals(104))
		{
			for(CatalogoDTO cat: factoryDAO.getCatalogoImpl().getAll(catalogo)){
				pais=new PaisDTO();
				pais.setCodigo(cat.getCatCodigo());
				pais.setImagenPath(cat.getCatImagenPath());
				pais.setNombre(cat.getCatDescripcion());
				pais.setCount(factoryDAO.getDoctorDAOImpl().getCount(cat.getCatCodigo()));
				pais.setTipo(Integer.valueOf(type.toString()));
				paisList.add(pais);
			}
		}//articulos revistas tesis libros
		else if(type.equals(105))
		{
			for(CatalogoDTO cat: factoryDAO.getCatalogoImpl().getAll(catalogo)){
				pais=new PaisDTO();
				pais.setCodigo(cat.getCatCodigo());
				pais.setImagenPath(cat.getCatImagenPath());
				pais.setNombre(cat.getCatDescripcion());
				pais.setCount(factoryDAO.getPublicacionDAOImpl().getCountByType(null,cat.getCatCodigo()));
				pais.setTipo(Integer.valueOf(type.toString()));
				paisList.add(pais);
			}
		}
		return paisList;
	}
		

	@Override
	public List<AteneaVisorDTO> visorList(AteneaDTO atenea) throws CorvustecException
	{
		List<AteneaVisorDTO> ateneaVisorList=new ArrayList<AteneaVisorDTO>();
		//List<AteneaVisorChildDTO> ateneaChildList=new ArrayList<AteneaVisorChildDTO>();
		AteneaVisorDTO ateneaVisor;
		//AteneaVisorChildDTO ateneaChild;		
		
		//CatalogoDTO catalogo;
		//List<CentroDTO> listCentroChild;
		List<CentroDTO> listPais;
		
		if(atenea.getTipo()==0)
		{
		}
		//Universidad
		else if(atenea.getTipo()==2)
		{
			//Si en el objeto no esta el pais quiere decir que son todos
			//Obtengo los paises para realizar el visor organizado por pais	
			if(atenea.getPais()==0)
				listPais=factoryDAO.getCentroDAOImpl().distinctPais(3);
			else
			{
				listPais=new ArrayList<CentroDTO>();
				listPais.add(new CentroDTO(atenea.getPais()));
			}
			
//			for(CentroDTO centroPais:listPais){
//				
//				for(CentroDTO centro: factoryDAO.getCentroDAOImpl().getCentro(atenea.getTipo(),centroPais.getCenPais()))
//				{
//					listCentroChild= factoryDAO.getCentroDAOImpl().findAllChild(centro);
//					
//					ateneaVisor=new AteneaVisorDTO();
//					ateneaVisor.setCodigo(centro.getCenCodigo());
//					ateneaVisor.setTitulo(centro.getCenNombre());
//					ateneaVisor.setTipo(atenea.getTipo());
//										
//					for(CentroDTO centroChild:listCentroChild)
//					{
//						ateneaChild=new AteneaVisorChildDTO();
//						
//						ateneaChild.setCodigo(centroChild.getCenCodigo());
//						ateneaChild.setTitulo(centroChild.getCenNombre());
//						ateneaChild.setDescripcion1(centroChild.getCenDatoInstitucional());
//
//						ateneaChildList.add(ateneaChild);
//					}
//					ateneaVisor.setAteneaChildList(ateneaChildList);
//					ateneaVisorList.add(ateneaVisor);
//				}
//				
//			}
			
			
			for(CentroDTO centroPais:listPais){
				for(CentroDTO centro: factoryDAO.getCentroDAOImpl().getCentro(3,centroPais.getCenPais()))
				{	
					ateneaVisor=new AteneaVisorDTO();
					ateneaVisor.setCodigo(centro.getCenCodigo());
					
					ateneaVisor.setTitulo("Universidad: " +centro.getAteCentro().getCenNombre());
					ateneaVisor.setDescripcion1("Facultad :"+centro.getCenNombre());
					ateneaVisor.setDescripcion2("Datos Institucionales: "+centro.getCenDatoInstitucional());
					ateneaVisor.setTipo(atenea.getTipo());

					ateneaVisorList.add(ateneaVisor);
				}
			}
			
		}//Facultad
		else if(atenea.getTipo()==3)
		{
			//Si en el objeto no esta el pais quiere decir que son todos
			//Obtengo los paises para realizar el visor organizado por pais	
			if(atenea.getPais()==0)
				listPais=factoryDAO.getCentroDAOImpl().distinctPais(atenea.getTipo());
			else
			{
				listPais=new ArrayList<CentroDTO>();
				listPais.add(new CentroDTO(atenea.getPais()));
			}	
			
			for(CentroDTO centroPais:listPais){
				
				for(CentroDTO centro: factoryDAO.getCentroDAOImpl().getCentro(atenea.getTipo(),centroPais.getCenPais()))
				{	
					ateneaVisor=new AteneaVisorDTO();
					ateneaVisor.setCodigo(centro.getCenCodigo());
					ateneaVisor.setTitulo("Universidad:" +centro.getAteCentro().getCenNombre());
					ateneaVisor.setDescripcion1("Facultad: "+centro.getCenNombre());
					ateneaVisor.setDescripcion2("Datos Institucionales:"+ centro.getAteCentro().getCenDatoInstitucional());
					ateneaVisor.setTipo(atenea.getTipo());

					ateneaVisorList.add(ateneaVisor);
				}
				
			}
			
		}//Pregrado
		else if(atenea.getTipo()==6)
		{
			
			if(atenea.getPais()==0)
				listPais= factoryDAO.getCarreraDAOImpl().distinctPais(atenea.getTipo());
			else
			{
				listPais=new ArrayList<CentroDTO>();
				listPais.add(new CentroDTO(atenea.getPais()));
			}
			
			for(CentroDTO cen:listPais)
			{
								
				for(CarreraDTO car: factoryDAO.getCarreraDAOImpl().getAll(atenea.getTipo(),cen.getCenPais())){
					
					if(car.getAteCentro().getCenTipo()==4)
					{
						ateneaVisor=new AteneaVisorDTO();
						
						ateneaVisor.setCodigo(car.getCarCodigo());

						ateneaVisor.setTipo(atenea.getTipo());
						ateneaVisor.setTitulo("Universidad: "+car.getAteCentro().getAteCentro().getAteCentro().getCenNombre());
						ateneaVisor.setDescripcion1("Facultad: "+car.getAteCentro().getAteCentro().getCenNombre());
						ateneaVisor.setDescripcion2("Carrera:" +car.getAteCentro().getCenNombre());
						
						ateneaVisorList.add(ateneaVisor);
					}
					else{
						ateneaVisor=new AteneaVisorDTO();
						
						ateneaVisor.setCodigo(car.getCarCodigo());
						
						ateneaVisor.setTitulo("Universidad:"+car.getAteCentro().getAteCentro().getCenNombre());
						ateneaVisor.setDescripcion1("Facultad: "+car.getAteCentro().getCenNombre());
						ateneaVisor.setDescripcion2("Carrera: "+car.getCarNombre());						
						
						ateneaVisor.setTipo(atenea.getTipo());
						ateneaVisorList.add(ateneaVisor);
					}
										
				}
			}			
			
		}//Posgrado
		else if(atenea.getTipo()==7)
		{
			if(atenea.getPais()==0)
				listPais= factoryDAO.getCarreraDAOImpl().distinctPais(atenea.getTipo());
			else
			{
				listPais=new ArrayList<CentroDTO>();
				listPais.add(new CentroDTO(atenea.getPais()));
			}
							
			for(CentroDTO cen:listPais)
			{
								
				for(CarreraDTO car: factoryDAO.getCarreraDAOImpl().getAll(atenea.getTipo(),cen.getCenPais())){
					
					if(car.getAteCentro().getCenTipo()==4)
					{
						ateneaVisor=new AteneaVisorDTO();
						
						ateneaVisor.setCodigo(car.getCarCodigo());
						ateneaVisor.setTipo(atenea.getTipo());
						ateneaVisor.setTitulo("Universidad: "+car.getAteCentro().getAteCentro().getAteCentro().getCenNombre());
						ateneaVisor.setDescripcion1("Facultad: "+car.getAteCentro().getAteCentro().getCenNombre());
						ateneaVisor.setDescripcion2("Carrera: "+car.getCarNombre());
						
						ateneaVisorList.add(ateneaVisor);
					}
					else{
						
						ateneaVisor=new AteneaVisorDTO();
						ateneaVisor.setCodigo(car.getCarCodigo());
						
						ateneaVisor.setTipo(atenea.getTipo());
						ateneaVisor.setTitulo("Universidad: "+car.getAteCentro().getAteCentro().getCenNombre());
						ateneaVisor.setDescripcion2("Facultad: "+car.getAteCentro().getCenNombre());
						ateneaVisor.setDescripcion2("Carrera: "+car.getCarNombre());
						
						ateneaVisorList.add(ateneaVisor);
					}
				}
			}			

		}//Revista
		else if(atenea.getTipo()==34)
		{
			List<PublicacionDTO> listPublicacion=new ArrayList<PublicacionDTO>();
			if(atenea.getPais()==0)
				listPublicacion=factoryDAO.getPublicacionDAOImpl().getByType(34);
			else
				listPublicacion=factoryDAO.getPublicacionDAOImpl().getByType(34,atenea.getPais());

			for(PublicacionDTO pub: listPublicacion){
				
				ateneaVisor=new AteneaVisorDTO();
				ateneaVisor.setCodigo(pub.getPubCodigo());
				ateneaVisor.setTitulo("Titulo: "+pub.getPubTitulo());
				
				ateneaVisor.setTipo(atenea.getTipo());
				
				ateneaVisorList.add(ateneaVisor);
				
			}
		}//Eventos
		else if(atenea.getTipo()==101)
		{
			List<EventoDTO> listEvento=new ArrayList<EventoDTO>();
			if(atenea.getPais()==0)
				listEvento=factoryDAO.getEventoDAOImpl().getAll();
			else
				listEvento=factoryDAO.getEventoDAOImpl().getAll(atenea.getPais());
			
			for(EventoDTO eve: listEvento){

				ateneaVisor=new AteneaVisorDTO();
				ateneaVisor.setCodigo(eve.getEveCodigo());
				ateneaVisor.setTitulo(eve.getEveNombre());
				ateneaVisor.setTipo(atenea.getTipo());
				
				ateneaVisorList.add(ateneaVisor);

			}
		}//Proyectos de Investigacion
		else if(atenea.getTipo()==102)
		{
			List<ProyectoInvestigacionDTO> listProyecto=new ArrayList<ProyectoInvestigacionDTO>();
			if(atenea.getPais()==0)
				listProyecto=factoryDAO.getProyectoInvestigacionDAOImpl().getAll();
			else
				listProyecto=factoryDAO.getProyectoInvestigacionDAOImpl().getAll(atenea.getPais());
			
			for(ProyectoInvestigacionDTO pro: listProyecto){

				ateneaVisor=new AteneaVisorDTO();
				ateneaVisor.setCodigo(pro.getPinCodigo());
				ateneaVisor.setTitulo(pro.getPinNombre());
				ateneaVisor.setDescripcion1(pro.getPinPerfil());
				ateneaVisor.setTipo(atenea.getTipo());
				
				ateneaVisorList.add(ateneaVisor);
			}
		}//Organizacion
		else if(atenea.getTipo()==103)
		{
			List<OrganizacionDTO> listOrg=new ArrayList<OrganizacionDTO>();
			if(atenea.getPais()==0)
				listOrg=factoryDAO.getOrganizacioDAOImpl().getAll();
			else
				listOrg=factoryDAO.getOrganizacioDAOImpl().getAll2(atenea.getPais());
			
			for(OrganizacionDTO org: listOrg){

				ateneaVisor=new AteneaVisorDTO();
				ateneaVisor.setCodigo(org.getOrgCodigo());
				ateneaVisor.setTitulo("Nombre: "+ org.getOrgNombre());
				ateneaVisor.setDescripcion1("Datos Institucionales: "+org.getOrgDatosInstitucionales());
				ateneaVisor.setTipo(atenea.getTipo());
				
				ateneaVisorList.add(ateneaVisor);
			}
		}//Doctor
		else if(atenea.getTipo()==104)
		{
			List<DoctorDTO> listDoc=new ArrayList<DoctorDTO>();
			if(atenea.getPais()==0)
				listDoc=factoryDAO.getDoctorDAOImpl().getAll();
			else
				listDoc=factoryDAO.getDoctorDAOImpl().getAll2(atenea.getPais());
			
			for(DoctorDTO doc: listDoc){
				ateneaVisor=new AteneaVisorDTO();
				ateneaVisor.setCodigo(doc.getDocCodigo());
				ateneaVisor.setTitulo("Nombres: "+doc.getDocNombres()+" "+doc.getDocApellidos());
				ateneaVisor.setDescripcion1("Fecha de Nacimiento: "+doc.getDocFechaNacimiento().toString().substring(0, 10));
				ateneaVisor.setTipo(atenea.getTipo());
				
				ateneaVisorList.add(ateneaVisor);
			}
		}//Articulo libros revistas
		else if(atenea.getTipo()==105)
		{
			List<PublicacionDTO> listPublicacion=new ArrayList<PublicacionDTO>();
			if(atenea.getPais()==0)
				listPublicacion=factoryDAO.getPublicacionDAOImpl().getByType(null);
			else
				listPublicacion=factoryDAO.getPublicacionDAOImpl().getByType(null,atenea.getPais());

			for(PublicacionDTO pub: listPublicacion){
				
				ateneaVisor=new AteneaVisorDTO();
				ateneaVisor.setCodigo(pub.getPubCodigo());
				ateneaVisor.setTitulo("Titulo: "+pub.getPubTitulo());
				
				ateneaVisor.setTipo(atenea.getTipo());
				
				ateneaVisorList.add(ateneaVisor);
				
			}
		}		
		return ateneaVisorList;
	}

	
	
	/* Centro */
	@Override
	public CentroDTO createOrUpdateCentro(CentroDTO centro) throws CorvustecException
	{
		logger.info("createCentro");
		try{
			if(centro.getCenCodigo()!=null)
				return factoryDAO.getCentroDAOImpl().edit(centro);
			else
			{
				return factoryDAO.getCentroDAOImpl().create(centro);
			}
		}
		catch(Exception e)
		{
			logger.info("Error createCentro {}",e.toString());
			throw new CorvustecException("Error al createCentro");
		}
	}
	
	@Override
	public void deleteCentro(CentroDTO centro) throws CorvustecException
	{
		logger.info("deleteCentro");
		try{
			factoryDAO.getCentroDAOImpl().remove(centro);
		}
		catch(Exception e){
			logger.info("Error eliminarCentro {}",e.toString());
			throw new CorvustecException("Error al eliminarCentro");
		}
	}

	@Override
	public void deleteUniversidad(CentroDTO universidad) throws CorvustecException
	{
		logger.info("deleteCentro");
		try{
			List<CarreraDTO> pregradoList;
			List<CarreraDTO> posgradoList;
			
			List<CentroDTO> listFacultad= factoryDAO.getCentroDAOImpl().findAllChild(universidad);
			List<CentroDTO> listEscuela;
			if(listFacultad!=null)
			{
				for(CentroDTO facultad:listFacultad)
				{
					listEscuela= factoryDAO.getCentroDAOImpl().findAllChild(facultad);
					if(listEscuela!=null)
					{
						for(CentroDTO escuela:listEscuela)
						{
							pregradoList=factoryDAO.getCarreraDAOImpl().getAll(escuela, 6);
							posgradoList=factoryDAO.getCarreraDAOImpl().getAll(escuela, 7);
							if(pregradoList!=null)
							{
								for(CarreraDTO carrera:pregradoList)
									deleteCarreraPregrado(carrera);	
							}
							if(posgradoList!=null)
							{
								for(CarreraDTO carrera:posgradoList)
									deleteCarreraPosgrado(carrera);	
							}
							factoryDAO.getCentroDAOImpl().remove(escuela);
						}
					}
					
					pregradoList=factoryDAO.getCarreraDAOImpl().getAll(facultad, 6);
					posgradoList=factoryDAO.getCarreraDAOImpl().getAll(facultad, 7);
					if(pregradoList!=null)
					{
						for(CarreraDTO carrera:pregradoList)
							deleteCarreraPregrado(carrera);	
					}
					if(posgradoList!=null)
					{
						for(CarreraDTO carrera:posgradoList)
							deleteCarreraPosgrado(carrera);	
					}
					factoryDAO.getCentroDAOImpl().remove(facultad);
				}
			}
			factoryDAO.getCentroDAOImpl().remove(universidad);
		}
		catch(Exception e){
			logger.info("Error eliminarCentro {}",e.toString());
			throw new CorvustecException("Error al eliminarCentro");
		}
	}

	
	@Override
	public void updateCentro(CentroDTO centro) throws CorvustecException
	{
		logger.info("updateCentro");
		try{
			factoryDAO.getCentroDAOImpl().edit(centro);
		}
		catch(Exception e){
			logger.info("Error updateCentro {}",e.toString());
			throw new CorvustecException("Error al updateCentro");
		}		
	}
	
	@Override
	public List<CentroDTO> obtenerCentroPadre() throws CorvustecException
	{
		logger.info("obtenerCentroPadre");
		try{
			return factoryDAO.getCentroDAOImpl().findAllPather();
		}
		catch(Exception e)
		{
			logger.info("Error obtenerCentroPadre {}",e.toString());
			throw new CorvustecException("Error al obtenerCentroPadre");
		}
	}

	@Override
	public List<CentroDTO> obtenerCentroPadre(Object ubicacion) throws CorvustecException
	{
		logger.info("obtenerCentroPadre");
		try{
			return factoryDAO.getCentroDAOImpl().findAllPather(ubicacion);
		}
		catch(Exception e)
		{
			logger.info("Error obtenerCentroPadre {}",e.toString());
			throw new CorvustecException("Error al obtenerCentroPadre");
		}
	}

	
	@Override
	public List<CentroDTO> obtenerCentroHijo(CentroDTO centro) throws CorvustecException
	{
		logger.info("obtenerCentroHijo");
		try{
			return factoryDAO.getCentroDAOImpl().findAllChild(centro);
		}
		catch(Exception e)
		{
			logger.info("Error obtenerCentroHijo {}",e.toString());
			throw new CorvustecException("Error al obtenerCentroHijo");
		}
	}

	@Override
	public List<CentroDTO> readCentroByType(Object type) throws CorvustecException
	{
		logger.info("readCentroByType");
		try{
			return factoryDAO.getCentroDAOImpl().findByType(type);
		}
		catch(Exception e)
		{
			logger.info("Error readCentroByType {}",e.toString());
			throw new CorvustecException("Error al readCentroByType");
		}
	}

	@Override
	public List<UniversidadListDTO> readUniversidad() throws CorvustecException
	{
		logger.info("readUniversidad");
		try{
			return factoryDAO.getCentroDAOImpl().getUniversidad();
		}
		catch(Exception e)
		{
			logger.info("Error readUniversidad {}",e.toString());
			throw new CorvustecException("Error al readUniversidad");
		}
	}

	@Override
	public List<FacultadListDTO> readFacultad() throws CorvustecException
	{
		logger.info("readFacultad");
		try{
			return factoryDAO.getCentroDAOImpl().getFacultad();
		}
		catch(Exception e)
		{
			logger.info("Error readFacultad {}",e.toString());
			throw new CorvustecException("Error al readFacultad");
		}
	}

	@Override
	public CentroDTO readCentro(Object id) throws CorvustecException
	{
		logger.info("readCentro");
		try{
			return factoryDAO.getCentroDAOImpl().find(Integer.valueOf(id.toString()));
		}
		catch(Exception e)
		{
			logger.info("Error readCentro {}",e.toString());
			throw new CorvustecException("Error al readCentro");
		}
	}

	@Override
	public List<FacultadListDTO> readUniversidadComplete(Object code) throws CorvustecException
	{
		try {
			return factoryDAO.getCentroDAOImpl().getUniversidad(code);
		} catch (CorvustecException e) {
			logger.info("Error readCentro {}",e.toString());
			throw new CorvustecException("Error al readCentro");
		}
	}
	
	/* Carrera */
	@Override
	public CarreraDTO createOrUpdateCarrera(CarreraDTO carrera) throws CorvustecException
	{
		logger.info("createCarrera");
		try{
			if(carrera.getCarCodigo()!=null)
				return factoryDAO.getCarreraDAOImpl().edit(carrera);
			else
			{
				carrera.addAteEntidad(new EntidadDTO());
				return factoryDAO.getCarreraDAOImpl().create(carrera);
			}
		}
		catch(Exception e)
		{
			logger.info("Error createCarrera {}",e.toString());
			throw new CorvustecException("Error al createCarrera");
		}
	}	
	
	@Override
	public List<CarreraDTO> readCarrera(CentroDTO centro,Object tipo) throws CorvustecException
	{
		logger.info("readCarrera");
		try{
			return factoryDAO.getCarreraDAOImpl().getAll(centro,tipo);
		}
		catch(Exception e)
		{
			logger.info("Error readCarrera {}",e.toString());
			throw new CorvustecException("Error al readCarrera");
		}
	}	
	
	@Override
	public List<CarreraDTO> readCarrera(Object type) throws CorvustecException
	{
		logger.info("readCarrera");
		try{
			return factoryDAO.getCarreraDAOImpl().getByType(type);
		}
		catch(Exception e)
		{
			logger.info("Error readCarrera {}",e.toString());
			throw new CorvustecException("Error al readCarrera");
		}
	}	

	@Override
	public void deleteCarreraPregrado(CarreraDTO carrera) throws CorvustecException
	{
		logger.info("deleteCarreraPregrado");
		List<ContactoListDTO> contactoList;
		List<MencionDTO> mencionList;
		List<ProyectoInvestigacionDTO> proyectoList;
		List<PublicacionDTO> publicacionList;
		List<EventoDTO> eventoList;
		List<EntidadDTO> entidadList;
		List<ModalidadDTO> modalidadList;
		ContactoDTO contacto;
		try{
			contactoList= factoryDAO.getContactoDAOImpl().getAll(carrera);
			if(contactoList!=null)
			{
				for(ContactoListDTO conLis:contactoList)
				{
					contacto=new ContactoDTO(conLis.getConCodigo());
					factoryDAO.getContactoDAOImpl().remove2(contacto);
				}
			}
			mencionList=factoryDAO.getMencionDAOImpl().getAll(carrera);
			if(mencionList!=null)
			{
				for(MencionDTO men:mencionList)
				{
					factoryDAO.getMencionDAOImpl().remove2(men);
				}
			}
			proyectoList= factoryDAO.getProyectoInvestigacionDAOImpl().getAll(carrera);
			if(proyectoList!=null)
			{
				for(ProyectoInvestigacionDTO pro:proyectoList)
				{
					factoryDAO.getProyectoInvestigacionDAOImpl().remove2(pro);
				}
			}
			publicacionList= factoryDAO.getPublicacionDAOImpl().getAll(carrera);
			if(publicacionList!=null)
			{
				for(PublicacionDTO pub:publicacionList)
				{
					factoryDAO.getPublicacionDAOImpl().remove2(pub);
				}
			}
			eventoList= factoryDAO.getEventoDAOImpl().getAll(carrera);
			if(eventoList!=null)
			{
				for(EventoDTO even:eventoList)
				{
					factoryDAO.getEventoDAOImpl().remove2(even);
				}
			}
			
			modalidadList=factoryDAO.getModalidadDAOImpl().getAll(carrera);
			
			if(modalidadList!=null)
			{
				for(ModalidadDTO moda:modalidadList)
				{
					factoryDAO.getModalidadDAOImpl().remove2(moda);
				}
			}
			
			entidadList= factoryDAO.getEntidadDAOImpl().getAll(carrera);
			for(EntidadDTO ent:entidadList)
			{
				factoryDAO.getEntidadDAOImpl().remove2(ent);
			}
			factoryDAO.getCarreraDAOImpl().remove2(carrera);
		}
		catch(Exception e)
		{
			logger.info("Error deleteCarreraPregrado {}",e.toString());
			throw new CorvustecException("Error al deleteCarreraPregrado");
		}
	}	

	
	@Override
	public void deleteCarreraPosgrado(CarreraDTO carrera) throws CorvustecException
	{
		logger.info("deleteCarreraPosgrado");
		List<ContactoListDTO> contactoList;
		List<MencionDTO> mencionList;
		List<ProyectoInvestigacionDTO> proyectoList;
		List<EntidadDTO> entidadList;
		List<ModalidadDTO> modalidadList;
		ContactoDTO contacto;
		try{
			contactoList= factoryDAO.getContactoDAOImpl().getAll(carrera);
			if(contactoList!=null)
			{
				for(ContactoListDTO conLis:contactoList)
				{
					contacto=new ContactoDTO(conLis.getConCodigo());
					factoryDAO.getContactoDAOImpl().remove2(contacto);
				}
			}
			mencionList=factoryDAO.getMencionDAOImpl().getAll(carrera);
			if(mencionList!=null)
			{
				for(MencionDTO men:mencionList)
				{
					factoryDAO.getMencionDAOImpl().remove2(men);
				}
			}
			proyectoList= factoryDAO.getProyectoInvestigacionDAOImpl().getAll(carrera);
			if(proyectoList!=null)
			{
				for(ProyectoInvestigacionDTO pro:proyectoList)
				{
					factoryDAO.getProyectoInvestigacionDAOImpl().remove2(pro);
				}
			}
			
			
			modalidadList=factoryDAO.getModalidadDAOImpl().getAll(carrera);
			
			if(modalidadList!=null)
			{
				for(ModalidadDTO moda:modalidadList)
				{
					factoryDAO.getModalidadDAOImpl().remove2(moda);
				}
			}
			
			entidadList= factoryDAO.getEntidadDAOImpl().getAll(carrera);
			for(EntidadDTO ent:entidadList)
			{
				factoryDAO.getEntidadDAOImpl().remove2(ent);
			}
			factoryDAO.getCarreraDAOImpl().remove2(carrera);
		}
		catch(Exception e)
		{
			logger.info("Error deleteCarreraPosgrado {}",e.toString());
			throw new CorvustecException("Error al deleteCarreraPosgrado");
		}
	}		
	
	/* Entidad */
	@Override
	public EntidadDTO createEntidad(EntidadDTO entidad) throws CorvustecException
	{
		logger.info("createEntidad");
		try{
			return factoryDAO.getEntidadDAOImpl().create(entidad);
		}
		catch(Exception e)
		{
			logger.info("Error createEntidad {}",e.toString());
			throw new CorvustecException("Error al createEntidad");
		}		
	}
	
	@Override
	public void updateEntidad(EntidadDTO entidad) throws CorvustecException
	{
		logger.info("updateEntidad");
		try{
			factoryDAO.getEntidadDAOImpl().edit(entidad);
		}
		catch(Exception e){
			logger.info("Error updateEntidad {}",e.toString());
			throw new CorvustecException("Error al updateEntidad");
		}
	}
	

	
	/* Contacto */
	@Override
	public ContactoDTO createOrUpdateContacto(ContactoDTO contactoDTO) throws CorvustecException
	{
		logger.info("createOrUpdateContacto");
		try{
			if(contactoDTO.getConCodigo()!=null)
				return factoryDAO.getContactoDAOImpl().edit(contactoDTO);
			else
				return factoryDAO.getContactoDAOImpl().create(contactoDTO);
		}
		catch(Exception e)
		{
			logger.info("Error createOrUpdateContacto {}",e.toString());
			throw new CorvustecException("Error al createOrUpdateContacto");
		}		
	}

	@Override
	public void deleteContacto(ContactoDTO contactoDTO) throws CorvustecException
	{
		logger.info("deleteContacto");
		try{
			factoryDAO.getContactoDAOImpl().remove(contactoDTO);
		}
		catch(Exception e)
		{
			logger.info("Error createEntidad {}",e.toString());
			throw new CorvustecException("Error al createEntidad");
		}		
	}

	
	@Override
	public List<ContactoListDTO> readContacto(EntidadDTO entidad) throws CorvustecException
	{
		logger.info("readContacto");
		try{
			return factoryDAO.getContactoDAOImpl().getAll(entidad);
		}
		catch(Exception e)
		{
			logger.info("Error readContacto {}",e.toString());
			throw new CorvustecException("Error al readContacto");
		}		
	}

	@Override
	public List<ContactoListDTO> readContacto(CarreraDTO carrera) throws CorvustecException
	{
		logger.info("readContacto");
		try{
			return factoryDAO.getContactoDAOImpl().getAll(carrera);
		}
		catch(Exception e)
		{
			logger.info("Error readContacto {}",e.toString());
			throw new CorvustecException("Error al readContacto");
		}		
	}
	
	@Override
	public List<ContactoListDTO> readContacto(OrganizacionDTO organizacion) throws CorvustecException
	{
		logger.info("readContacto");
		try{
			return factoryDAO.getContactoDAOImpl().getAll(organizacion);
		}
		catch(Exception e)
		{
			logger.info("Error readContacto {}",e.toString());
			throw new CorvustecException("Error al readContacto");
		}		
	}	
	
	@Override
	public List<ContactoListDTO> readContacto(DoctorDTO doctor) throws CorvustecException
	{
		logger.info("readContacto");
		try{
			return factoryDAO.getContactoDAOImpl().getAll(doctor);
		}
		catch(Exception e)
		{
			logger.info("Error readContacto {}",e.toString());
			throw new CorvustecException("Error al readContacto");
		}		
	}	
	/* Mencion */
	@Override
	public MencionDTO createOrUpdateMencion(MencionDTO mencion) throws CorvustecException
	{
		logger.info("createMencion");
		try{
			if(mencion.getMenCodigo()!=null)
				return factoryDAO.getMencionDAOImpl().edit(mencion);
			else
				return factoryDAO.getMencionDAOImpl().create(mencion);
		}
		catch(Exception e)
		{
			logger.info("Error createMencion {}",e.toString());
			throw new CorvustecException("Error al createMencion");
		}		
	}
	
	@Override
	public void deleteMencion(MencionDTO mencion) throws CorvustecException
	{
		logger.info("deleteMencion");
		try{
			factoryDAO.getMencionDAOImpl().remove(mencion);
		}
		catch(Exception e)
		{
			logger.info("Error deleteMencion {}",e.toString());
			throw new CorvustecException("Error al deleteMencion");
		}		
	}
	
	@Override
	public List<MencionDTO> readMencion(CarreraDTO carrera) throws CorvustecException
	{
		logger.info("readContacto");
		try{
			return factoryDAO.getMencionDAOImpl().getAll(carrera);
		}
		catch(Exception e)
		{
			logger.info("Error readContacto {}",e.toString());
			throw new CorvustecException("Error al readContacto");
		}		
	}
	
	/* Proyecto */
	@Override
	public ProyectoInvestigacionDTO createOrUpdateProyectoInvestigacion(ProyectoInvestigacionDTO proyecto) throws CorvustecException
	{
		logger.info("createOrUpdateProyectoInvestigacion");
		try{
			if(proyecto.getPinCodigo()!=null)
				return factoryDAO.getProyectoInvestigacionDAOImpl().edit(proyecto);
			else	
			{
				proyecto.addAteEntidad(new EntidadDTO());
				return factoryDAO.getProyectoInvestigacionDAOImpl().create(proyecto);
			}
		}
		catch(Exception e){
			logger.info("Error createOrUpdateProyectoInvestigacion {}",e.toString());
			throw new CorvustecException("Error al createOrUpdateProyectoInvestigacion");
		}
	}

	@Override
	public void deleteProyectoInvestigacion(ProyectoInvestigacionDTO proyecto) throws CorvustecException
	{
		logger.info("deleteProyectoInvestigacion");
		try{
			factoryDAO.getProyectoInvestigacionDAOImpl().remove2(proyecto);
		}
		catch(Exception e){
			logger.info("Error deleteProyectoInvestigacion {}",e.toString());
			throw new CorvustecException("Error al deleteProyectoInvestigacion");
		}
	}

	
	@Override
	public List<ProyectoInvestigacionDTO> readProyectoInvestigacion(CarreraDTO carrera) throws CorvustecException
	{
		logger.info("obtenerProyectoInvestigacion");
		try{
			return factoryDAO.getProyectoInvestigacionDAOImpl().getAll(carrera);
		}
		catch(Exception e)
		{
			logger.info("Error obtenerProyectoInvestigacion {}",e.toString());
			throw new CorvustecException("Error al obtenerProyectoInvestigacion");
		}
	}
	
	@Override
	public List<ProyectoInvestigacionDTO> readProyectoInvestigacion(OrganizacionDTO org) throws CorvustecException
	{
		logger.info("obtenerProyectoInvestigacion");
		try{
			return factoryDAO.getProyectoInvestigacionDAOImpl().getAll(org);
		}
		catch(Exception e)
		{
			logger.info("Error obtenerProyectoInvestigacion {}",e.toString());
			throw new CorvustecException("Error al obtenerProyectoInvestigacion");
		}
	}
	
	@Override
	public List<ProyectoInvestigacionDTO> readProyectoInvestigacion() throws CorvustecException
	{
		logger.info("readProyectoInvestigacion");
		try{
			return factoryDAO.getProyectoInvestigacionDAOImpl().getAll();
		}
		catch(Exception e)
		{
			logger.info("Error readProyectoInvestigacion {}",e.toString());
			throw new CorvustecException("Error al readProyectoInvestigacion");
		}
	}
	/* Evento */
	@Override
	public EventoDTO createOrUpdateEvento(EventoDTO evento) throws CorvustecException
	{
		logger.info("createProyectoInvestigacion");
		try{
			if(evento.getEveCodigo()!=null)
				return factoryDAO.getEventoDAOImpl().edit(evento);
			else
			{
				evento.addAteEntidad(new EntidadDTO());
				return factoryDAO.getEventoDAOImpl().create(evento);
			}
		}
		catch(Exception e){
			logger.info("Error createProyectoInvestigacion {}",e.toString());
			throw new CorvustecException("Error al createProyectoInvestigacion");
		}
	}
	
	@Override
	public void deleteEvento(EventoDTO evento) throws CorvustecException
	{
		logger.info("createProyectoInvestigacion");
		try{
			factoryDAO.getEventoDAOImpl().remove2(evento);
		}
		catch(Exception e){
			logger.info("Error createProyectoInvestigacion {}",e.toString());
			throw new CorvustecException("Error al createProyectoInvestigacion");
		}
	}
	
	@Override
	public List<EventoDTO> readEvento(CarreraDTO carrera) throws CorvustecException
	{
		logger.info("readEvento");
		try{
			return factoryDAO.getEventoDAOImpl().getAll(carrera);
		}
		catch(Exception e)
		{
			logger.info("Error readEvento {}",e.toString());
			throw new CorvustecException("Error al readEvento");
		}
	}

	@Override
	public List<EventoDTO> readEvento(OrganizacionDTO org) throws CorvustecException
	{
		logger.info("readEvento");
		try{
			return factoryDAO.getEventoDAOImpl().getAll(org);
		}
		catch(Exception e)
		{
			logger.info("Error readEvento {}",e.toString());
			throw new CorvustecException("Error al readEvento");
		}
	}
	@Override
	public List<EventoDTO> readEvento() throws CorvustecException
	{
		logger.info("readEvento");
		try{
			return factoryDAO.getEventoDAOImpl().getAll();
		}
		catch(Exception e)
		{
			logger.info("Error readEvento {}",e.toString());
			throw new CorvustecException("Error al readEvento");
		}
	}
	
	
	/* Publicacion */
	@Override
	public PublicacionDTO createOrUpdatePublicacion(PublicacionDTO publicacion,Boolean entidad) throws CorvustecException
	{
		logger.info("createOrUpdatePublicacion");
		try{
			if(publicacion.getPubCodigo()!=null)
				return factoryDAO.getPublicacionDAOImpl().edit(publicacion);
			else			
			{
				if(entidad)
					publicacion.addAteEntidad(new EntidadDTO());
				return factoryDAO.getPublicacionDAOImpl().create(publicacion);
			}
		}
		catch(Exception e){
			logger.info("Error createOrUpdatePublicacion {}",e.toString());

			throw new CorvustecException("Error al createOrUpdatePublicacion");
		}
	}

	
	@Override
	public void deletePublicacion(PublicacionDTO publicacion) throws CorvustecException
	{
		logger.info("deletePublicacion");
		try{
			factoryDAO.getPublicacionDAOImpl().remove2(publicacion);
		}
		catch(Exception e){
			logger.info("Error deletePublicacion {}",e.toString());
			throw new CorvustecException("Error al deletePublicacion");
		}
	}
	
	@Override
	public List<PublicacionDTO> readPublicacion(CarreraDTO carrera) throws CorvustecException
	{
		logger.info("readPublicacion");
		try{
			return factoryDAO.getPublicacionDAOImpl().getAll(carrera);
		}
		catch(Exception e)
		{
			logger.info("Error readPublicacion {}",e.toString());
			throw new CorvustecException("Error al readPublicacion");
		}
	}

	@Override
	public List<PublicacionDTO> readPublicacion(DoctorDTO doctor) throws CorvustecException
	{
		logger.info("readPublicacion");
		try{
			return factoryDAO.getPublicacionDAOImpl().getAll(doctor);
		}
		catch(Exception e)
		{
			logger.info("Error readPublicacion {}",e.toString());
			throw new CorvustecException("Error al readPublicacion");
		}
	}

	@Override
	public List<PublicacionDTO> readPublicacion(OrganizacionDTO organizacion) throws CorvustecException
	{
		logger.info("readPublicacion");
		try{
			return factoryDAO.getPublicacionDAOImpl().getAll(organizacion);
		}
		catch(Exception e)
		{
			logger.info("Error readPublicacion {}",e.toString());
			throw new CorvustecException("Error al readPublicacion");
		}
	}

	
	@Override
	public List<PublicacionDTO> readPublicacion(Object ubicacion) throws CorvustecException
	{
		logger.info("readPublicacion");
		try{
			return factoryDAO.getPublicacionDAOImpl().getAll(ubicacion);
		}
		catch(Exception e)
		{
			logger.info("Error readPublicacion {}",e.toString());
			throw new CorvustecException("Error al readPublicacion");
		}
	}

	@Override
	public List<PublicacionDTO> readPublicacion() throws CorvustecException
	{
		logger.info("readPublicacion");
		try{
			return factoryDAO.getPublicacionDAOImpl().getAll();
		}
		catch(Exception e)
		{
			logger.info("Error readPublicacion {}",e.toString());
			throw new CorvustecException("Error al readPublicacion");
		}
	}

	@Override
	public List<PublicacionDTO> readPublicacionByType(Object type) throws CorvustecException
	{
		logger.info("readPublicacion");
		try{
			return factoryDAO.getPublicacionDAOImpl().getByType(type);
		}
		catch(Exception e)
		{
			logger.info("Error readPublicacion {}",e.toString());
			throw new CorvustecException("Error al readPublicacion");
		}
	}

	@Override
	public List<PublicacionDTO> readPublicacionNoEntity(Object ubicacion) throws CorvustecException
	{
		logger.info("readPublicacionNoEntity");
		try{
			return factoryDAO.getPublicacionDAOImpl().getAllNoEntity(ubicacion);
		}
		catch(Exception e)
		{
			logger.info("Error readPublicacionNoEntity {}",e.toString());
			throw new CorvustecException("Error al readPublicacion");
		}
	}
	
	/* Organizacion */
	@Override
	public OrganizacionDTO createOrUpdateOrganizacion(OrganizacionDTO organizacion) throws CorvustecException
	{
		logger.info("createOrganizacion");
		try{
			if(organizacion.getOrgCodigo()!=null)
				return factoryDAO.getOrganizacioDAOImpl().edit(organizacion);
			else
			{
				organizacion.addAteEntidad(new EntidadDTO());
				return factoryDAO.getOrganizacioDAOImpl().create(organizacion);
			}
		}
		catch(Exception e){
			logger.info("Error createOrganizacion {}",e.toString());
			throw new CorvustecException("Error al createOrganizacion");
		}
	}

	@Override
	public List<OrganizacionDTO> readOrganizacion(Object ubicacion) throws CorvustecException
	{
		logger.info("readOrganizacion");
		try{
			return factoryDAO.getOrganizacioDAOImpl().getAll(ubicacion);
		}
		catch(Exception e){
			logger.info("Error readOrganizacion {}",e.toString());
			throw new CorvustecException("Error al readOrganizacion");
		}
	}
	
	@Override
	public List<OrganizacionDTO> readOrganizacion() throws CorvustecException
	{
		logger.info("readOrganizacion");
		try{
			return factoryDAO.getOrganizacioDAOImpl().getAll();
		}
		catch(Exception e){
			logger.info("Error readOrganizacion {}",e.toString());
			throw new CorvustecException("Error al readOrganizacion");
		}
	}
	
	@Override
	public void deleteOrganizacion(OrganizacionDTO organizacion) throws CorvustecException
	{
		logger.info("deleteOrganizacion");
		List<ContactoListDTO> contactoList;
		List<ProyectoInvestigacionDTO> proyectoList;
		List<EventoDTO> eventoList;
		List<EntidadDTO> entidadList;
		
		ContactoDTO contacto;
		try{
			contactoList= factoryDAO.getContactoDAOImpl().getAll(organizacion);
			if(contactoList!=null)
			{
				for(ContactoListDTO conLis:contactoList)
				{
					contacto=new ContactoDTO(conLis.getConCodigo());
					factoryDAO.getContactoDAOImpl().remove2(contacto);
				}
			}
			proyectoList= factoryDAO.getProyectoInvestigacionDAOImpl().getAll(organizacion);
			if(proyectoList!=null)
			{
				for(ProyectoInvestigacionDTO pro:proyectoList)
				{
					factoryDAO.getProyectoInvestigacionDAOImpl().remove2(pro);
				}
			}
			eventoList= factoryDAO.getEventoDAOImpl().getAll(organizacion);
			if(eventoList!=null)
			{
				for(EventoDTO even:eventoList)
				{
					factoryDAO.getEventoDAOImpl().remove2(even);
				}
			}
			entidadList= factoryDAO.getEntidadDAOImpl().getAll(organizacion);
			for(EntidadDTO ent:entidadList)
			{
				factoryDAO.getEntidadDAOImpl().remove2(ent);
			}
			factoryDAO.getOrganizacioDAOImpl().remove2(organizacion);
		}
		catch(Exception e)
		{
			logger.info("Error deleteCarreraPregrado {}",e.toString());
			throw new CorvustecException("Error al deleteCarreraPregrado");
		}
	}
	
	/* Doctor */
	@Override
	public DoctorDTO createOrUpdateDoctor(DoctorDTO doctor) throws CorvustecException
	{
		logger.info("createOrUpdateDoctor");
		try{
			if(doctor.getDocCodigo()!=null)
				return factoryDAO.getDoctorDAOImpl().edit(doctor);
			else
			{
				doctor.addAteEntidad(new EntidadDTO());
				return factoryDAO.getDoctorDAOImpl().create(doctor);
			}
		}
		catch(Exception e){
			logger.info("Error createOrUpdateDoctor {}",e.toString());
			throw new CorvustecException("Error al createOrUpdateDoctor");
		}
	}
	
	@Override
	public List<DoctorDTO> readDoctor(Object ubicacion) throws CorvustecException
	{
		logger.info("readDoctor");
		try{
			return factoryDAO.getDoctorDAOImpl().getAll(ubicacion);
		}
		catch(Exception e)
		{
			logger.info("Error readDoctor {}",e.toString());
			throw new CorvustecException("Error al readDoctor");
		}
	}
	
	@Override
	public List<DoctorDTO> readDoctor() throws CorvustecException
	{
		logger.info("readDoctor");
		try{
			return factoryDAO.getDoctorDAOImpl().getAll();
		}
		catch(Exception e){
			logger.info("Error readDoctor {}",e.toString());
			throw new CorvustecException("Error al readDoctor");
		}
	}

	@Override
	public List<DoctorListDTO> readDoctorList(Object codigo) throws CorvustecException
	{
		logger.info("readDoctor");
		try{
			return factoryDAO.getDoctorDAOImpl().get(codigo);
		}
		catch(Exception e){
			logger.info("Error readDoctor {}",e.toString());
			throw new CorvustecException("Error al readDoctor");
		}
	}

	
	
	@Override
	public DoctorDTO getRandomDoctor() throws CorvustecException
	{
		logger.info("readDoctor");
		int ran;
		try{
			List<DoctorDTO> doctorList=factoryDAO.getDoctorDAOImpl().getAll(); 
			if(!doctorList.isEmpty())
			{
				ran = (int) (Math.random () * doctorList.size());
				return factoryDAO.getDoctorDAOImpl().getAll().get(ran);
			}
			else
				return new DoctorDTO();
		}
		catch(Exception e){
			logger.info("Error readDoctor {}",e.toString());
			throw new CorvustecException("Error al readDoctor");
		}		
	}
	
	
	@Override
	public void deleteDoctor(DoctorDTO doctor) throws CorvustecException
	{
		List<ContactoListDTO> contactoList;
		List<ObraDTO> obraList;
		
		List<EntidadDTO> entidadList;
		
		ContactoDTO contacto;
		try{
			contactoList= factoryDAO.getContactoDAOImpl().getAll(doctor);
			if(contactoList!=null)
			{
				for(ContactoListDTO conLis:contactoList)
				{
					contacto=new ContactoDTO(conLis.getConCodigo());
					factoryDAO.getContactoDAOImpl().remove2(contacto);
				}
			}

			obraList= factoryDAO.getObraDAOImpl().getAll(doctor);
			if(obraList!=null)
			{
				for(ObraDTO obr:obraList)
				{
					factoryDAO.getObraDAOImpl().remove2(obr);
				}
			}
			
			entidadList= factoryDAO.getEntidadDAOImpl().getAll(doctor);
			for(EntidadDTO ent:entidadList)
			{
				factoryDAO.getEntidadDAOImpl().remove2(ent);
			}
			factoryDAO.getDoctorDAOImpl().remove2(doctor);
		}
		catch(Exception e)
		{
			logger.info("Error deleteCarreraPregrado {}",e.toString());
			throw new CorvustecException("Error al deleteCarreraPregrado");
		}

	}
	
	/* Noticia */	
	@Override
	public NoticiaDTO createOrUpdateNoticia(NoticiaDTO noticia) throws CorvustecException
	{
		logger.info("createNoticia");
		try{
			noticia.setNotFecha(new Timestamp(new Date().getTime()));
			if(noticia.getNotCodigo()!=null)
				return factoryDAO.getNoticiaDAOImpl().edit(noticia);
			else
				return factoryDAO.getNoticiaDAOImpl().create(noticia);
		}
		catch(Exception e){
			logger.info("Error createNoticia {}",e.toString());
			throw new CorvustecException("Error al createNoticia");
		}
	}

	@Override
	public void deleteNoticia(NoticiaDTO noticia) throws CorvustecException
	{
		logger.info("createNoticia");
		try{
			factoryDAO.getNoticiaDAOImpl().remove2(noticia);
		}
		catch(Exception e){
			logger.info("Error createNoticia {}",e.toString());
			throw new CorvustecException("Error al createNoticia");
		}
	}

	@Override
	public List<NoticiaDTO> readNoticia() throws CorvustecException
	{
		logger.info("readNoticia");
		List<NoticiaDTO> notiList=new ArrayList<NoticiaDTO>();
		try{
			List<NoticiaDTO> notiListAux=factoryDAO.getNoticiaDAOImpl().getAll();
			CatalogoDTO catalogoDTO;
			if(notiListAux!=null)
			{
				for(NoticiaDTO noticia:notiListAux)
				{
					if(noticia.getNotPais()!=null)
					{
						catalogoDTO=factoryDAO.getCatalogoImpl().find(noticia.getNotPais());
						if(catalogoDTO!=null)
						{
							noticia.setNotPaisPath(catalogoDTO.getCatImagenPath());
						}
					}
					notiList.add(noticia);
				}
			}
			return notiList;
		}
		catch(Exception e)
		{
			logger.info("Error readNoticia {}",e.toString());
			throw new CorvustecException("Error al readNoticia");
		}
	}

	@Override
	public List<NoticiaDTO> readNoticiaPublic() throws CorvustecException
	{
		logger.info("readNoticia");
		List<NoticiaDTO> notiList=new ArrayList<NoticiaDTO>();
		try{
			List<NoticiaDTO> notiListAux=factoryDAO.getNoticiaDAOImpl().getAllPublic();
			CatalogoDTO catalogoDTO;
			if(notiListAux!=null)
			{
				for(NoticiaDTO noticia:notiListAux)
				{
					if(noticia.getNotPais()!=null)
					{
						catalogoDTO=factoryDAO.getCatalogoImpl().find(noticia.getNotPais());
						if(catalogoDTO!=null)
						{
							noticia.setNotPaisPath(catalogoDTO.getCatImagenPath());
						}
					}
					notiList.add(noticia);
				}
			}
			return notiList;
		}
		catch(Exception e)
		{
			logger.info("Error readNoticia {}",e.toString());
			throw new CorvustecException("Error al readNoticia");
		}
	}
	
	@Override
	public NoticiaDTO readNoticia(NoticiaDTO noticia) throws CorvustecException
	{
		logger.info("readNoticia");
		try{
			return factoryDAO.getNoticiaDAOImpl().find(noticia.getNotCodigo());
		}
		catch(Exception e)
		{
			logger.info("Error readNoticia {}",e.toString());
			throw new CorvustecException("Error al readNoticia");
		}
	}
	
	/*Modalidad*/
	@Override
	public List<ModalidadDTO> readModalidad(CarreraDTO carrera) throws CorvustecException
	{
		logger.info("readModalidad");
		try{
			return factoryDAO.getModalidadDAOImpl().getAll(carrera);
		}
		catch(Exception e)
		{
			logger.info("Error readModalidad {}",e.toString());
			throw new CorvustecException("Error al readModalidad");
		}
	}
	
	/*Entidad*/
	@Override
	public EntidadDTO readEntidad(DoctorDTO doctor) throws CorvustecException
	{
		logger.info("readEntidad");
		try{
			return factoryDAO.getEntidadDAOImpl().get(doctor);
		}
		catch(Exception e)
		{
			logger.info("Error readModalidad {}",e.toString());
			throw new CorvustecException("Error al readModalidad");
		}		
	}

	@Override
	public EntidadDTO readEntidad(ObraDTO obra) throws CorvustecException
	{
		logger.info("readEntidad");
		try{
			return factoryDAO.getEntidadDAOImpl().get(obra);
		}
		catch(Exception e)
		{
			logger.info("Error readModalidad {}",e.toString());
			throw new CorvustecException("Error al readModalidad");
		}		
	}

	/* Obra */
	@Override
	public ObraDTO createOrUpdateObra(ObraDTO obra) throws CorvustecException
	{
		logger.info("createOrUpdateObra");
		try{
			if(obra.getObrCodigo()!=null)
				return factoryDAO.getObraDAOImpl().edit(obra);
			else
			{
				obra.addAteEntidad(new EntidadDTO());
				return factoryDAO.getObraDAOImpl().create(obra);
			}
		}
		catch(Exception e){
			logger.info("Error createOrUpdateObra {}",e.toString());
			throw new CorvustecException("Error al createOrUpdateObra");
		}
	}

	
	@Override
	public void deleteObra(ObraDTO obra) throws CorvustecException
	{
		logger.info("deleteObra");
		try{
			factoryDAO.getObraDAOImpl().remove2(obra);
		}
		catch(Exception e){
			logger.info("Error deleteObra {}",e.toString());
			throw new CorvustecException("Error al deleteObra");
		}
	}
	
	@Override
	public List<ObraDTO> readObra(DoctorDTO doctor) throws CorvustecException
	{
		logger.info("readObra");
		try{
			return factoryDAO.getObraDAOImpl().getAll(doctor);
		}
		catch(Exception e)
		{
			logger.info("Error readObra {}",e.toString());
			throw new CorvustecException("Error al readObra");
		}
	}


}
