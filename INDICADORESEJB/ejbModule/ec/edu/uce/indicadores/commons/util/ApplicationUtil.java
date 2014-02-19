package ec.edu.uce.indicadores.commons.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

import javax.ejb.EJB;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ec.edu.uce.indicadores.ejb.persistence.dao.FactoryDAO;


public class ApplicationUtil {

	private static final Logger logger = LoggerFactory.getLogger(ApplicationUtil.class);
		
	public static String saveToDiskBin(byte[] bytefile)
	{
		String file,path,date,pathAbs,pathSave = null;
		try {
			file= UUID.randomUUID().toString();
			//path=FacesContext.getCurrentInstance().getExternalContext().getRealPath("/");
			date=String.valueOf(CalendarUtil.getYear())+"\\"+String.valueOf(CalendarUtil.getMonth())+"\\"+String.valueOf(CalendarUtil.getDay());
			pathSave="\\SILSAG\\"+date;
			path=System.getProperty("jboss.server.data.dir")+"\\SILSAG\\"+date;
			File f= new File(path);
			if(!f.exists())
				f.mkdirs();
			pathAbs=path+"\\"+file+".bin";//+mime;
			pathSave=pathSave+"\\"+file+".bin";//+mime;
			FileOutputStream fos=new FileOutputStream(pathAbs);
			fos.write(bytefile);
			fos.close();
		} catch (FileNotFoundException e) {
			logger.info("FileNotFoundException {}",e.toString());
		} catch (IOException e) {
			logger.info("FileNotFoundException {}",e.toString());
		}
		return pathSave;
	}
	
	
	public static String saveToDisk(byte[] bytefile,String name)
	{
		String file,path,date,pathAbs,exten,pathSave = null;
		
		try {
			exten=name.split("\\.")[1];
			file= UUID.randomUUID().toString();
			//path=FacesContext.getCurrentInstance().getExternalContext().getRealPath("/");
			date=String.valueOf(CalendarUtil.getYear())+"\\"+String.valueOf(CalendarUtil.getMonth())+"\\"+String.valueOf(CalendarUtil.getDay());
			path=System.getProperty("jboss.home.dir")+"\\standalone\\deployments\\INDICADORES.ear\\INDICADORESWeb.war\\images\\tmp\\"+date;
			
			File f= new File(path);
			if(!f.exists())
				f.mkdirs();
			pathAbs=path+"\\"+file+"."+exten;
			pathSave="images\\tmp\\"+date+"\\"+file+"."+exten;
			FileOutputStream fos=new FileOutputStream(pathAbs);
			fos.write(bytefile);
			fos.close();
		} catch (FileNotFoundException e) {
			logger.info("FileNotFoundException {}",e.toString());
		} catch (IOException e) {
			logger.info("FileNotFoundException {}",e.toString());
		}
		return pathSave;
	}
	
	public static String saveToDisk(byte[] bytefile)
	{
		String file,path,date,pathAbs,pathSave = null;
		try {
			//mime=getTypeFile(bytefile);
			//mime=mime.split("/")[1];
			file= UUID.randomUUID().toString();
			//path=FacesContext.getCurrentInstance().getExternalContext().getRealPath("/");
			date=String.valueOf(CalendarUtil.getYear())+"\\"+String.valueOf(CalendarUtil.getMonth())+"\\"+String.valueOf(CalendarUtil.getDay());
			pathSave="\\SILSAG\\"+date;
			path=System.getProperty("jboss.server.data.dir")+"\\SILSAG\\"+date;
			File f= new File(path);
			if(!f.exists())
				f.mkdirs();
			pathAbs=path+"\\"+file+".jpg";//+mime;
			pathSave=pathSave+"\\"+file+".jpg";//+mime;
			FileOutputStream fos=new FileOutputStream(pathAbs);
			fos.write(bytefile);
			fos.close();
		} catch (FileNotFoundException e) {
			logger.info("FileNotFoundException {}",e.toString());
		} catch (IOException e) {
			logger.info("FileNotFoundException {}",e.toString());
		}
		return pathSave;
	}
	
//	public static String getTypeFile(byte[] content)
//	{
//		String mimeType = null;
//		try {		
//			MagicMatch match = Magic.getMagicMatch(content);
//			mimeType = match.getMimeType();
//		} catch (MagicParseException e) {
//			e.printStackTrace();
//		} catch (MagicMatchNotFoundException e) {
//			e.printStackTrace();
//		} catch (MagicException e) {
//			e.printStackTrace();
//		}
//		return mimeType;
//	}
}
