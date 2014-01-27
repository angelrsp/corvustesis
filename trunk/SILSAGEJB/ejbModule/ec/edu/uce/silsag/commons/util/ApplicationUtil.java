package ec.edu.uce.silsag.commons.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

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
	
    
	public static String saveToDisk(byte[] bytefile,String filename)
	{
		try {
			FileOutputStream fos=new FileOutputStream(filename);
			fos.write(bytefile);
			fos.close();
		} catch (FileNotFoundException e) {
			logger.info("FileNotFoundException {}",e.toString());
		} catch (IOException e) {
			logger.info("FileNotFoundException {}",e.toString());
		}
		return filename;
	}
    
}
