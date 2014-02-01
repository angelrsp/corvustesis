package ec.edu.uce.silsag.commons.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Path;
import java.util.UUID;

import javax.faces.context.FacesContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ApplicationUtil {

	
	private static final Logger logger = LoggerFactory
			.getLogger(ApplicationUtil.class);

	
    public static String getTempPath()
    {
    	String tempFilePath = null;
    	try{
	 		 
    		//create a temp file
    		File temp = File.createTempFile("temp-file-name", ".tmp"); 
 
    		System.out.println("Temp file : " + temp.getAbsolutePath());
 
    		//Get tempropary file path
    		String absolutePath = temp.getAbsolutePath();
    		tempFilePath = absolutePath.
    		    substring(0,absolutePath.lastIndexOf(File.separator));
 
    		logger.info("Temp file path : ",tempFilePath);
    		
    	}catch(IOException e){
    		e.printStackTrace();
    	}
    	return tempFilePath;
    }
	
    
	public static String saveToDisk(byte[] bytefile)
	{
		String file,path,pathAbs = null;
		try {
			file= UUID.randomUUID().toString();
			path=FacesContext.getCurrentInstance().getExternalContext().getRealPath("/");
			pathAbs=path+"\\"+file+".bin";
			FileOutputStream fos=new FileOutputStream(pathAbs);
			fos.write(bytefile);
			fos.close();
		} catch (FileNotFoundException e) {
			logger.info("FileNotFoundException {}",e.toString());
		} catch (IOException e) {
			logger.info("FileNotFoundException {}",e.toString());
		}
		return pathAbs;
	}
	
	public static byte[] getFileToDisk(String filePath)
	{
		
		ObjectInputStream file = new ObjectInputStream(new FileInputStream( filePath ));
		byte[] content=new byte[file.read];
		file.readByte();
	}
    
}
