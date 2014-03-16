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
import net.ciespal.redxxi.ejb.persistence.entities.CarreraDTO;
import net.ciespal.redxxi.ejb.persistence.entities.CatalogoDTO;
import net.ciespal.redxxi.ejb.persistence.entities.CentroDTO;
import net.ciespal.redxxi.ejb.persistence.entities.ContactoDTO;
import net.ciespal.redxxi.ejb.persistence.entities.ContactoListDTO;
import net.ciespal.redxxi.ejb.persistence.entities.DoctorDTO;
import net.ciespal.redxxi.ejb.persistence.entities.EntidadDTO;
import net.ciespal.redxxi.ejb.persistence.entities.EventoDTO;
import net.ciespal.redxxi.ejb.persistence.entities.FacultadListDTO;
import net.ciespal.redxxi.ejb.persistence.entities.MencionDTO;
import net.ciespal.redxxi.ejb.persistence.entities.ModalidadDTO;
import net.ciespal.redxxi.ejb.persistence.entities.NoticiaDTO;
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
		CatalogoDTO cat;
		if(pais==null)
		{
			atenea=new AteneaDTO();
			atenea.setCodigo(1);
			atenea.setDescripcion("Universidades: ");
			atenea.setCount(factoryDAO.getCentroDAOImpl().getUniversidadCount());
			atenea.setTipo(2);
			ateneaList.add(atenea);
			
			atenea=new AteneaDTO();
			atenea.setCodigo(2);
			atenea.setDescripcion("Facultades: ");
			atenea.setCount(factoryDAO.getCentroDAOImpl().getFacultadCount());
			atenea.setTipo(3);
			ateneaList.add(atenea);

			atenea=new AteneaDTO();
			atenea.setCodigo(3);
			atenea.setDescripcion("Carreras de Pregrado: ");
			atenea.setCount(factoryDAO.getCarreraDAOImpl().getPregradoCount());
			atenea.setTipo(6);
			ateneaList.add(atenea);

			atenea=new AteneaDTO();
			atenea.setCodigo(4);
			atenea.setDescripcion("Carreras de Posgrado: ");
			atenea.setCount(factoryDAO.getCarreraDAOImpl().getPosgradoCount());
			atenea.setTipo(7);
			ateneaList.add(atenea);

			atenea=new AteneaDTO();
			atenea.setCodigo(5);
			atenea.setDescripcion("Revistas Científicas: ");
			atenea.setCount(factoryDAO.getPublicacionDAOImpl().getCountByType(34));
			atenea.setTipo(34);
			ateneaList.add(atenea);

			atenea=new AteneaDTO();
			atenea.setCodigo(6);
			atenea.setDescripcion("Eventos Científicos: ");
			atenea.setCount(factoryDAO.getEventoDAOImpl().getCount());
			atenea.setTipo(101);
			ateneaList.add(atenea);
			
			atenea=new AteneaDTO();
			atenea.setCodigo(7);
			atenea.setDescripcion("Proyectos de Investigación: ");
			atenea.setCount(factoryDAO.getProyectoInvestigacionDAOImpl().getCount());
			atenea.setTipo(102);
			ateneaList.add(atenea);

			atenea=new AteneaDTO();
			atenea.setCodigo(8);
			atenea.setDescripcion("Organizaciones Científicas: ");
			atenea.setCount(factoryDAO.getOrganizacioDAOImpl().getCount());
			atenea.setTipo(103);			
			ateneaList.add(atenea);

			atenea=new AteneaDTO();
			atenea.setCodigo(9);
			atenea.setDescripcion("Doctores en Ciencias: ");
			atenea.setCount(factoryDAO.getDoctorDAOImpl().getCount());
			atenea.setTipo(104);
			ateneaList.add(atenea);
		}
		else
		{
			cat=new CatalogoDTO();
			cat.setCatCodigo(Integer.valueOf(pais.toString()));
			atenea=new AteneaDTO();
			atenea.setCodigo(1);
			atenea.setDescripcion("Universidades: ");
			atenea.setCount(factoryDAO.getCentroDAOImpl().getUniversidadCount(cat.getCatCodigo()));
			atenea.setTipo(2);
			atenea.setPais(Integer.valueOf(pais.toString()));
			ateneaList.add(atenea);
			
			atenea=new AteneaDTO();
			atenea.setCodigo(2);
			atenea.setDescripcion("Facultades: ");
			atenea.setCount(factoryDAO.getCentroDAOImpl().getFacultadCount(cat.getCatCodigo()));
			atenea.setTipo(3);
			atenea.setPais(Integer.valueOf(pais.toString()));
			ateneaList.add(atenea);

			atenea=new AteneaDTO();
			atenea.setCodigo(3);
			atenea.setDescripcion("Carreras de Pregrado: ");
			atenea.setCount(factoryDAO.getCarreraDAOImpl().getPregradoCount(cat.getCatCodigo()));
			atenea.setTipo(6);
			atenea.setPais(Integer.valueOf(pais.toString()));
			ateneaList.add(atenea);

			atenea=new AteneaDTO();
			atenea.setCodigo(4);
			atenea.setDescripcion("Carreras de Posgrado: ");
			atenea.setCount(factoryDAO.getCarreraDAOImpl().getPosgradoCount(cat.getCatCodigo()));
			atenea.setTipo(7);
			atenea.setPais(Integer.valueOf(pais.toString()));
			ateneaList.add(atenea);

			atenea=new AteneaDTO();
			atenea.setCodigo(5);
			atenea.setDescripcion("Revistas Científicas: ");
			atenea.setCount(factoryDAO.getPublicacionDAOImpl().getCountByType(34,cat.getCatCodigo()));
			atenea.setTipo(34);
			atenea.setPais(Integer.valueOf(pais.toString()));
			ateneaList.add(atenea);

			atenea=new AteneaDTO();
			atenea.setCodigo(6);
			atenea.setDescripcion("Eventos Científicos: ");
			atenea.setCount(factoryDAO.getEventoDAOImpl().getCount(cat.getCatCodigo()));
			atenea.setTipo(101);
			atenea.setPais(Integer.valueOf(pais.toString()));
			ateneaList.add(atenea);
			
			atenea=new AteneaDTO();
			atenea.setCodigo(7);
			atenea.setDescripcion("Proyectos de Investigación: ");
			atenea.setCount(factoryDAO.getProyectoInvestigacionDAOImpl().getCount(cat.getCatCodigo()));
			atenea.setTipo(102);
			atenea.setPais(Integer.valueOf(pais.toString()));
			ateneaList.add(atenea);

			atenea=new AteneaDTO();
			atenea.setCodigo(8);
			atenea.setDescripcion("Organizaciones Científicas: ");
			atenea.setCount(factoryDAO.getOrganizacioDAOImpl().getCount(cat.getCatCodigo()));
			atenea.setTipo(103);			
			atenea.setPais(Integer.valueOf(pais.toString()));
			ateneaList.add(atenea);

			atenea=new AteneaDTO();
			atenea.setCodigo(9);
			atenea.setDescripcion("Doctores en Ciencias: ");
			atenea.setCount(factoryDAO.getDoctorDAOImpl().getCount(cat.getCatCodigo()));
			atenea.setTipo(104);
			atenea.setPais(Integer.valueOf(pais.toString()));
			ateneaList.add(atenea);
		}
		return ateneaList;
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
		}
		return paisList;
	}
	
	@Override
	public String visor(AteneaDTO atenea) throws CorvustecException
	{
		StringBuilder sb=new StringBuilder();
		CatalogoDTO catalogo;
		List<CentroDTO> listCentroChild;
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
				listPais=factoryDAO.getCentroDAOImpl().distinctPais(atenea.getTipo());
			else
			{
				listPais=new ArrayList<CentroDTO>();
				listPais.add(new CentroDTO(atenea.getPais()));
			}
			sb.append("<table>");
			
			for(CentroDTO centroPais:listPais){
				
				catalogo=factoryDAO.getCatalogoImpl().find(centroPais.getCenPais());
				
				sb.append("<tr>");
					sb.append("<td colspan='2' align='center'>");
					sb.append("<img src='/RedXXIWeb"+catalogo.getCatImagenPath()+"' height='30' width='50'>");
					sb.append("</td>");				
				sb.append("</tr>");					
				
				sb.append("<tr>");				
					sb.append("<td><b>");
					sb.append("País: ");
					sb.append("</b></td>");
					
					sb.append("<td>");
					sb.append(catalogo.getCatDescripcion());
					sb.append("</td>");
				sb.append("</tr>");										
				
				for(CentroDTO centro: factoryDAO.getCentroDAOImpl().getCentro(atenea.getTipo(),centroPais.getCenPais()))
				{
					listCentroChild= factoryDAO.getCentroDAOImpl().findAllChild(centro);
					
					sb.append("<tr>");
						sb.append("<td>");
						sb.append("Nombre: ");
						sb.append("</td>");
							
						sb.append("<td>");
						if(centro.getCenPaginaWeb()!=null)
							sb.append("<a href='"+centro.getCenPaginaWeb()+"' target='_blank'>"+centro.getCenNombre()+"</a>");
						else
							sb.append(centro.getCenNombre());
						sb.append("</td>");
					sb.append("</tr>");
					
					for(CentroDTO centroChild:listCentroChild)
					{
						sb.append("<tr>");
						
							sb.append("<td>");
							sb.append("Facultad: ");
							sb.append("</td>");

							sb.append("<td>");
							sb.append(centroChild.getCenNombre());
							sb.append("</td>");
						
						sb.append("</tr>");							
						sb.append("<tr>");
							
							sb.append("<td>");
							sb.append("Datos Institucionales: ");
							sb.append("</td>");

							sb.append("<td>");
							sb.append(centroChild.getCenDatoInstitucional());
							sb.append("</td>");
							
						sb.append("</tr>");
					}					
					sb.append(spacer());												
				}				
			}
			sb.append("</table>");
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
			
			sb.append("<table>");
			
			for(CentroDTO centroPais:listPais){
				
				catalogo=factoryDAO.getCatalogoImpl().find(centroPais.getCenPais());
				
				sb.append("<tr>");
					sb.append("<td colspan='2' align='center'>");
					sb.append("<img src='/RedXXIWeb"+catalogo.getCatImagenPath()+"' height='30' width='50'>");
					sb.append("</td>");				
				sb.append("</tr>");					
				
				sb.append("<tr>");				
					sb.append("<td><b>");
					sb.append("País: ");
					sb.append("</b></td>");
					
					sb.append("<td>");
					sb.append(catalogo.getCatDescripcion());
					sb.append("</td>");
				sb.append("</tr>");										
				
				for(CentroDTO centro: factoryDAO.getCentroDAOImpl().getCentro(atenea.getTipo(),centroPais.getCenPais()))
				{	
					sb.append("<tr>");
						sb.append("<td>");
						sb.append("Universidad: ");
						sb.append("</td>");
							
						sb.append("<td>");
						if(centro.getAteCentro().getCenPaginaWeb()!=null)
							sb.append("<a href='"+centro.getAteCentro().getCenPaginaWeb()+"' target='_blank'>"+centro.getAteCentro().getCenNombre()+"</a>");
						else
							sb.append(centro.getAteCentro().getCenNombre());
						sb.append("</td>");
					sb.append("</tr>");
					
					sb.append("<tr>");
					
						sb.append("<td>");
						sb.append("Nombre: ");
						sb.append("</td>");

						sb.append("<td>");
						sb.append(centro.getCenNombre());
						sb.append("</td>");
					
					sb.append("</tr>");							
					sb.append("<tr>");
						
						sb.append("<td>");
						sb.append("Datos Institucionales: ");
						sb.append("</td>");

						sb.append("<td>");
						sb.append(centro.getCenDatoInstitucional());
						sb.append("</td>");
						
					sb.append("</tr>");
					
					sb.append(spacer());					
					
				}					
				
			}
			sb.append("</table>");
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
			
			sb.append("<table>");
							
			for(CentroDTO cen:listPais)
			{
				catalogo=factoryDAO.getCatalogoImpl().find(cen.getCenPais());
				
				sb.append("<table>");
				
				sb.append("<tr>");
				
					sb.append("<td colspan='2' align='center'>");
					sb.append("<img src='/RedXXIWeb"+catalogo.getCatImagenPath()+"' height='30' width='50'>");
					sb.append("</td>");
			
				sb.append("</tr>");				
				
				sb.append("<tr>");				
					sb.append("<td><b>");
					sb.append("País: ");
					sb.append("</b></td>");
					
					sb.append("<td>");
					sb.append(catalogo.getCatDescripcion());
					sb.append("</td>");
				sb.append("</tr>");		
				
				for(CarreraDTO car: factoryDAO.getCarreraDAOImpl().getAll(atenea.getTipo(),cen.getCenPais())){
					
					if(car.getAteCentro().getCenTipo()==4)
					{
						sb.append("<tr>");
							sb.append("<td>");
							sb.append("Universidad: ");
							sb.append("</td>");
						
							sb.append("<td>");
							sb.append(car.getAteCentro().getAteCentro().getAteCentro().getCenNombre());
							sb.append("</td>");
						sb.append("</tr>");

						sb.append("<tr>");							
							sb.append("<td>");
							sb.append("Facultad: ");
							sb.append("</td>");
							
							sb.append("<td>");
							sb.append(car.getAteCentro().getAteCentro().getCenNombre());
							sb.append("</td>");
						sb.append("</tr>");

						sb.append("<tr>");							
							sb.append("<td>");
							sb.append("Escuela: ");
							sb.append("</td>");
							
							sb.append("<td>");
							sb.append(car.getAteCentro().getCenNombre());
							sb.append("</td>");
						sb.append("</tr>");							

						sb.append("<tr>");							
							sb.append("<td>");
							sb.append("Carrera: ");
							sb.append("</td>");
							
							sb.append("<td>");
							sb.append(car.getCarNombre());
							sb.append("</td>");
						sb.append("</tr>");														
					}
					else{
						
						sb.append("<tr>");							
							sb.append("<td>");
							sb.append("Universidad: ");
							sb.append("</td>");
						
							sb.append("<td>");
							sb.append(car.getAteCentro().getAteCentro().getCenNombre());
							sb.append("</td>");
						sb.append("</tr>");

						sb.append("<tr>");							
							sb.append("<td>");
							sb.append("Facultad: ");
							sb.append("</td>");
							
							sb.append("<td>");
							sb.append(car.getAteCentro().getCenNombre());
							sb.append("</td>");
						sb.append("</tr>");
						
						sb.append("<tr>");							
							sb.append("<td>");
							sb.append("Carrera: ");
							sb.append("</td>");
							
							sb.append("<td>");
							sb.append(car.getCarNombre());
							sb.append("</td>");
						sb.append("</tr>");							
												
					}
					sb.append(spacer());					
				}
			}			
			sb.append("</table>");
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
			
			sb.append("<table>");
							
			for(CentroDTO cen:listPais)
			{
				catalogo=factoryDAO.getCatalogoImpl().find(cen.getCenPais());
				
				sb.append("<table>");
				
				sb.append("<tr>");
				
					sb.append("<td colspan='2' align='center'>");
					sb.append("<img src='/RedXXIWeb"+catalogo.getCatImagenPath()+"' height='30' width='50'>");
					sb.append("</td>");
			
				sb.append("</tr>");				
				
				sb.append("<tr>");				
					sb.append("<td><b>");
					sb.append("País: ");
					sb.append("</b></td>");
					
					sb.append("<td>");
					sb.append(catalogo.getCatDescripcion());
					sb.append("</td>");
				sb.append("</tr>");		
				
				for(CarreraDTO car: factoryDAO.getCarreraDAOImpl().getAll(atenea.getTipo(),cen.getCenPais())){
					
					if(car.getAteCentro().getCenTipo()==4)
					{
						sb.append("<tr>");
							sb.append("<td>");
							sb.append("Universidad: ");
							sb.append("</td>");
						
							sb.append("<td>");
							sb.append(car.getAteCentro().getAteCentro().getAteCentro().getCenNombre());
							sb.append("</td>");
						sb.append("</tr>");

						sb.append("<tr>");							
							sb.append("<td>");
							sb.append("Facultad: ");
							sb.append("</td>");
							
							sb.append("<td>");
							sb.append(car.getAteCentro().getAteCentro().getCenNombre());
							sb.append("</td>");
						sb.append("</tr>");

						sb.append("<tr>");							
							sb.append("<td>");
							sb.append("Escuela: ");
							sb.append("</td>");
							
							sb.append("<td>");
							sb.append(car.getAteCentro().getCenNombre());
							sb.append("</td>");
						sb.append("</tr>");							

						sb.append("<tr>");							
							sb.append("<td>");
							sb.append("Carrera: ");
							sb.append("</td>");
							
							sb.append("<td>");
							sb.append(car.getCarNombre());
							sb.append("</td>");
						sb.append("</tr>");														
					}
					else{
						sb.append("<tr>");							
							sb.append("<td>");
							sb.append("Universidad: ");
							sb.append("</td>");
						
							sb.append("<td>");
							sb.append(car.getAteCentro().getAteCentro().getCenNombre());
							sb.append("</td>");
						sb.append("</tr>");

						sb.append("<tr>");							
							sb.append("<td>");
							sb.append("Facultad: ");
							sb.append("</td>");
							
							sb.append("<td>");
							sb.append(car.getAteCentro().getCenNombre());
							sb.append("</td>");
						sb.append("</tr>");
						
						sb.append("<tr>");							
							sb.append("<td>");
							sb.append("Carrera: ");
							sb.append("</td>");
							
							sb.append("<td>");
							sb.append(car.getCarNombre());
							sb.append("</td>");
						sb.append("</tr>");							
												
					}
					sb.append(spacer());					
				}
			}			
			sb.append("</table>");
		}//Revista
		else if(atenea.getTipo()==34)
		{
			for(PublicacionDTO pub: factoryDAO.getPublicacionDAOImpl().getByType(34)){
				
				sb.append("<table>");
					sb.append("<tr>");
						sb.append("<td>");
						sb.append(pub.getPubTitulo());
						sb.append("</td>");
					sb.append("</tr>");
				sb.append("</table>");
				
			}
		}//Eventos
		else if(atenea.getTipo()==101)
		{
			for(EventoDTO eve: factoryDAO.getEventoDAOImpl().getAll()){
				sb.append("<table>");
				sb.append("<tr>");
				sb.append("<td>");
				sb.append(eve.getEveNombre());
				sb.append("</td>");
				sb.append("</tr>");
				sb.append("</table>");
			}
		}//Proyectos de Investigacion
		else if(atenea.getTipo()==102)
		{
			for(ProyectoInvestigacionDTO pro: factoryDAO.getProyectoInvestigacionDAOImpl().getAll()){
				sb.append("<table>");
				sb.append("<tr>");
				sb.append("<td>");
				sb.append(pro.getPinNombre());
				sb.append("</td>");
				sb.append("</tr>");
				sb.append("</table>");
			}
		}//Organizacion
		else if(atenea.getTipo()==103)
		{
//			for(CatalogoDTO cat: factoryDAO.getCatalogoImpl().getAll(catalogo)){
//				pais=new PaisDTO();
//				pais.setCodigo(cat.getCatCodigo());
//				pais.setImagenPath(cat.getCatImagenPath());
//				pais.setNombre(cat.getCatDescripcion());
//				pais.setCount(factoryDAO.getOrganizacioDAOImpl().getCount(cat.getCatCodigo()));
//				pais.setTipo(Integer.valueOf(type.toString()));
//				paisList.add(pais);
//			}
		}//Doctor
		else if(atenea.getTipo()==104)
		{
//			for(CatalogoDTO cat: factoryDAO.getCatalogoImpl().getAll(catalogo)){
//				pais=new PaisDTO();
//				pais.setCodigo(cat.getCatCodigo());
//				pais.setImagenPath(cat.getCatImagenPath());
//				pais.setNombre(cat.getCatDescripcion());
//				pais.setCount(factoryDAO.getDoctorDAOImpl().getCount(cat.getCatCodigo()));
//				pais.setTipo(Integer.valueOf(type.toString()));
//				paisList.add(pais);
//			}
		}
		return sb.toString();
	}
	
	@Override
	public String visor(PaisDTO pais) throws CorvustecException
	{
		StringBuilder sb=new StringBuilder();
		CatalogoDTO catalogo;
		List<CentroDTO> listCentroChild;
		if(pais.getTipo()==0)
		{
		}
		//Universidad
		else if(pais.getTipo()==2)
		{
			catalogo=factoryDAO.getCatalogoImpl().find(pais.getCodigo());
			
			sb.append("<table>");
			
			sb.append("<tr>");
			
				sb.append("<td colspan='2' align='center'>");
				sb.append("<img src='/RedXXIWeb"+catalogo.getCatImagenPath()+"' height='30' width='50'>");
				sb.append("</td>");
		
			sb.append("</tr>");			
			
			sb.append("<tr>");				
				sb.append("<td><b>");
				sb.append("País: ");
				sb.append("</b></td>");
				
				sb.append("<td>");
				sb.append(catalogo.getCatDescripcion());
				sb.append("</td>");
			sb.append("</tr>");		
			
			for(CentroDTO centro: factoryDAO.getCentroDAOImpl().getCentro(pais.getTipo(),pais.getCodigo()))
			{
				listCentroChild= factoryDAO.getCentroDAOImpl().findAllChild(centro);
				
				sb.append("<tr>");
					sb.append("<td>");
					sb.append("Nombre: ");
					sb.append("</td>");
					sb.append("<td>");
					if(centro.getCenPaginaWeb()!=null)
						sb.append("<a href='http://"+centro.getCenPaginaWeb()+"' target='_blank'>"+centro.getCenNombre()+"</a>");
					else
						sb.append(centro.getCenNombre());
					sb.append("</td>");
				sb.append("</tr>");
				
				for(CentroDTO centroChild:listCentroChild)
				{
					sb.append("<tr>");
						sb.append("<td>");
						sb.append("Facultad: ");
						sb.append("</td>");

						sb.append("<td>");
						sb.append(centroChild.getCenNombre());
						sb.append("</td>");
					sb.append("</tr>");			
					
					sb.append("<tr>");
						sb.append("<td>");
						sb.append("Datos Institucionales: ");
						sb.append("</td>");

						sb.append("<td>");
						sb.append(centroChild.getCenDatoInstitucional());
						sb.append("</td>");
					sb.append("</tr>");
				}
				
				sb.append(spacer());				
			}
			sb.append("</table>");
		}//Facultad
		else if(pais.getTipo()==3)
		{
			catalogo=factoryDAO.getCatalogoImpl().find(pais.getCodigo());
			
			sb.append("<table>");
			
			sb.append("<tr>");
			
				sb.append("<td colspan='2' align='center'>");
				sb.append("<img src='/RedXXIWeb"+catalogo.getCatImagenPath()+"' height='30' width='50'>");
				sb.append("</td>");
			
			sb.append("</tr>");
			
			sb.append("<tr>");				
				sb.append("<td><b>");
				sb.append("País: ");
				sb.append("</b></td>");
				
				sb.append("<td>");
				sb.append(catalogo.getCatDescripcion());
				sb.append("</td>");
			sb.append("</tr>");		
			
			for(CentroDTO centro: factoryDAO.getCentroDAOImpl().getCentro(pais.getTipo(),pais.getCodigo()))
			{
				sb.append("<tr>");
					sb.append("<td>");
					sb.append("Universidad: ");
					sb.append("</td>");
						
					sb.append("<td>");
					sb.append(centro.getAteCentro().getCenNombre());
					sb.append("</td>");
				sb.append("</tr>");

				sb.append("<tr>");
				
					sb.append("<td>");
					sb.append("Nombre: ");
					sb.append("</td>");

					sb.append("<td>");
					sb.append(centro.getCenNombre());
					sb.append("</td>");
				
				sb.append("</tr>");							
				sb.append("<tr>");
					
					sb.append("<td>");
					sb.append("Datos Institucionales: ");
					sb.append("</td>");

					sb.append("<td>");
					sb.append(centro.getCenDatoInstitucional());
					sb.append("</td>");
					
				sb.append("</tr>");
				
				sb.append(spacer());
					
			}
			sb.append("</table>");
		}//Pregrado
		else if(pais.getTipo()==6)
		{			
			catalogo=factoryDAO.getCatalogoImpl().find(pais.getCodigo());
			
			sb.append("<table>");
			
			sb.append("<tr>");
				sb.append("<td colspan='2' align='center'>");
				sb.append("<img src='/RedXXIWeb"+catalogo.getCatImagenPath()+"' height='30' width='50'>");
				sb.append("</td>");		
			sb.append("</tr>");				
			
			sb.append("<tr>");				
				sb.append("<td><b>");
				sb.append("País: ");
				sb.append("</b></td>");
				
				sb.append("<td>");
				sb.append(catalogo.getCatDescripcion());
				sb.append("</td>");
			sb.append("</tr>");		
				
			for(CarreraDTO car: factoryDAO.getCarreraDAOImpl().getAll(pais.getTipo(),pais.getCodigo())){
				
				if(car.getAteCentro().getCenTipo()==4)
				{
					sb.append("<tr>");
						sb.append("<td>");
						sb.append("Universidad: ");
						sb.append("</td>");
					
						sb.append("<td>");
						sb.append(car.getAteCentro().getAteCentro().getAteCentro().getCenNombre());
						sb.append("</td>");
					sb.append("</tr>");

					sb.append("<tr>");							
						sb.append("<td>");
						sb.append("Facultad: ");
						sb.append("</td>");
						
						sb.append("<td>");
						sb.append(car.getAteCentro().getAteCentro().getCenNombre());
						sb.append("</td>");
					sb.append("</tr>");

					sb.append("<tr>");							
						sb.append("<td>");
						sb.append("Escuela: ");
						sb.append("</td>");
						
						sb.append("<td>");
						sb.append(car.getAteCentro().getCenNombre());
						sb.append("</td>");
					sb.append("</tr>");							

					sb.append("<tr>");							
						sb.append("<td>");
						sb.append("Carrera: ");
						sb.append("</td>");
						
						sb.append("<td>");
						sb.append(car.getCarNombre());
						sb.append("</td>");
					sb.append("</tr>");														
				}
				else{
					
					sb.append("<tr>");							
						sb.append("<td>");
						sb.append("Universidad: ");
						sb.append("</td>");
					
						sb.append("<td>");
						sb.append(car.getAteCentro().getAteCentro().getCenNombre());
						sb.append("</td>");
					sb.append("</tr>");

					sb.append("<tr>");							
						sb.append("<td>");
						sb.append("Facultad: ");
						sb.append("</td>");
						
						sb.append("<td>");
						sb.append(car.getAteCentro().getCenNombre());
						sb.append("</td>");
					sb.append("</tr>");
					
					sb.append("<tr>");							
						sb.append("<td>");
						sb.append("Carrera: ");
						sb.append("</td>");
						
						sb.append("<td>");
						sb.append(car.getCarNombre());
						sb.append("</td>");
					sb.append("</tr>");							
											
				}
				sb.append(spacer());					
			}
		
			sb.append("</table>");			
		}//Posgrado
		else if(pais.getTipo()==7)
		{
			catalogo=factoryDAO.getCatalogoImpl().find(pais.getCodigo());
			
			sb.append("<table>");
			
			sb.append("<tr>");
				sb.append("<td colspan='2' align='center'>");
				sb.append("<img src='/RedXXIWeb"+catalogo.getCatImagenPath()+"' height='30' width='50'>");
				sb.append("</td>");		
			sb.append("</tr>");				
			
			sb.append("<tr>");				
				sb.append("<td><b>");
				sb.append("País: ");
				sb.append("</b></td>");
				
				sb.append("<td>");
				sb.append(catalogo.getCatDescripcion());
				sb.append("</td>");
			sb.append("</tr>");		
				
			for(CarreraDTO car: factoryDAO.getCarreraDAOImpl().getAll(pais.getTipo(),pais.getCodigo())){
				
				if(car.getAteCentro().getCenTipo()==4)
				{
					sb.append("<tr>");
						sb.append("<td>");
						sb.append("Universidad: ");
						sb.append("</td>");
					
						sb.append("<td>");
						sb.append(car.getAteCentro().getAteCentro().getAteCentro().getCenNombre());
						sb.append("</td>");
					sb.append("</tr>");

					sb.append("<tr>");							
						sb.append("<td>");
						sb.append("Facultad: ");
						sb.append("</td>");
						
						sb.append("<td>");
						sb.append(car.getAteCentro().getAteCentro().getCenNombre());
						sb.append("</td>");
					sb.append("</tr>");

					sb.append("<tr>");							
						sb.append("<td>");
						sb.append("Escuela: ");
						sb.append("</td>");
						
						sb.append("<td>");
						sb.append(car.getAteCentro().getCenNombre());
						sb.append("</td>");
					sb.append("</tr>");							

					sb.append("<tr>");							
						sb.append("<td>");
						sb.append("Carrera: ");
						sb.append("</td>");
						
						sb.append("<td>");
						sb.append(car.getCarNombre());
						sb.append("</td>");
					sb.append("</tr>");														
				}
				else{
					
					sb.append("<tr>");							
						sb.append("<td>");
						sb.append("Universidad: ");
						sb.append("</td>");
					
						sb.append("<td>");
						sb.append(car.getAteCentro().getAteCentro().getCenNombre());
						sb.append("</td>");
					sb.append("</tr>");

					sb.append("<tr>");							
						sb.append("<td>");
						sb.append("Facultad: ");
						sb.append("</td>");
						
						sb.append("<td>");
						sb.append(car.getAteCentro().getCenNombre());
						sb.append("</td>");
					sb.append("</tr>");
					
					sb.append("<tr>");							
						sb.append("<td>");
						sb.append("Carrera: ");
						sb.append("</td>");
						
						sb.append("<td>");
						sb.append(car.getCarNombre());
						sb.append("</td>");
					sb.append("</tr>");							
											
				}
				sb.append(spacer());					
			}
			sb.append("</table>");				
		}//Revista
		else if(pais.getTipo()==34)
		{
			for(PublicacionDTO pub: factoryDAO.getPublicacionDAOImpl().getByType(34)){
				sb.append("<table>");
				sb.append("<tr>");
				sb.append("<td>");
				sb.append(pub.getPubTitulo());
				sb.append("</td>");
				sb.append("</tr>");
				sb.append("</table>");
			}
		}//Eventos
		else if(pais.getTipo()==101)
		{
			for(EventoDTO eve: factoryDAO.getEventoDAOImpl().getAll()){
				sb.append("<table>");
				sb.append("<tr>");
				sb.append("<td>");
				sb.append(eve.getEveNombre());
				sb.append("</td>");
				sb.append("</tr>");
				sb.append("</table>");
			}
		}//Proyectos de Investigacion
		else if(pais.getTipo()==102)
		{
			for(ProyectoInvestigacionDTO pro: factoryDAO.getProyectoInvestigacionDAOImpl().getAll()){
				sb.append("<table>");
				sb.append("<tr>");
				sb.append("<td>");
				sb.append(pro.getPinNombre());
				sb.append("</td>");
				sb.append("</tr>");
				sb.append("</table>");
			}
		}//Organizacion
		else if(pais.getTipo()==103)
		{
//			for(CatalogoDTO cat: factoryDAO.getCatalogoImpl().getAll(catalogo)){
//				pais=new PaisDTO();
//				pais.setCodigo(cat.getCatCodigo());
//				pais.setImagenPath(cat.getCatImagenPath());
//				pais.setNombre(cat.getCatDescripcion());
//				pais.setCount(factoryDAO.getOrganizacioDAOImpl().getCount(cat.getCatCodigo()));
//				pais.setTipo(Integer.valueOf(type.toString()));
//				paisList.add(pais);
//			}
		}//Doctor
		else if(pais.getTipo()==104)
		{
//			for(CatalogoDTO cat: factoryDAO.getCatalogoImpl().getAll(catalogo)){
//				pais=new PaisDTO();
//				pais.setCodigo(cat.getCatCodigo());
//				pais.setImagenPath(cat.getCatImagenPath());
//				pais.setNombre(cat.getCatDescripcion());
//				pais.setCount(factoryDAO.getDoctorDAOImpl().getCount(cat.getCatCodigo()));
//				pais.setTipo(Integer.valueOf(type.toString()));
//				paisList.add(pais);
//			}
		}
		return sb.toString();
	}
	
	private static String spacer()
	{
		StringBuilder sb=new StringBuilder();
		sb.append("<tr>");												
			sb.append("<td colspan='2' align='center'>");
			sb.append("---");
			sb.append("</td>");
		sb.append("</tr>");
		return sb.toString();
	}
	
	@Override
	public String infoPais(PaisDTO pais)
	{
		CatalogoDTO catalogo= factoryDAO.getCatalogoImpl().find(pais.getCodigo());
		StringBuilder sb=new StringBuilder();
		
		sb.append("<table>");

			sb.append("<tr>");
						
				sb.append("<td colspan='2' align='center'>");
				sb.append("<img src='/RedXXIWeb"+catalogo.getCatImagenPath()+"' height='30' width='50'>");
				sb.append("</td>");
				
			sb.append("</tr>");
		
			sb.append("<tr>");
				
				sb.append("<td>");
				sb.append("Pais: ");
				sb.append("</td>");
				
				sb.append("<td>");
				sb.append(catalogo.getCatDescripcion());
				sb.append("</td>");
				
			sb.append("</tr>");
			
			sb.append("<tr>");

				sb.append("<td>");
				sb.append("Pablación: ");
				sb.append("</td>");

				sb.append("<td>");
				sb.append(catalogo.getCatAuxiliar());
				sb.append("</td>");				
				
			sb.append("</tr>");
		
		sb.append("</table>");
		
		return sb.toString();
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
		try{
			return factoryDAO.getNoticiaDAOImpl().getAll();
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
		try{
			return factoryDAO.getNoticiaDAOImpl().getAllPublic();
		}
		catch(Exception e)
		{
			logger.info("Error readNoticia {}",e.toString());
			throw new CorvustecException("Error al readNoticia");
		}
	}

	/*Nmodalidad*/
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
	
}
