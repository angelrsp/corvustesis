package ec.edu.uce.silsag.commons.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

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
			pathAbs=path+"\\"+file+".bin";
			pathSave=pathSave+"\\"+file+".bin";
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
	
	public static byte[] getFileToDisk(String filePath)
	{
		logger.info("Reading in binary file named : " + filePath);
	    File file = new File(filePath);
	    logger.info("File size: " + file.length());
	    byte[] result = new byte[(int)file.length()];
	    try {
	      InputStream input = null;
	      try {
	        int totalBytesRead = 0;
	        input = new BufferedInputStream(new FileInputStream(file));
	        while(totalBytesRead < result.length){
	          int bytesRemaining = result.length - totalBytesRead;
	          //input.read() returns -1, 0, or more :
	          int bytesRead = input.read(result, totalBytesRead, bytesRemaining); 
	          if (bytesRead > 0){
	            totalBytesRead = totalBytesRead + bytesRead;
	          }
	        }
	        /*
	         the above style is a bit tricky: it places bytes into the 'result' array; 
	         'result' is an output parameter;
	         the while loop usually has a single iteration only.
	        */
	        logger.info("Num bytes read: " + totalBytesRead);
	      }
	      finally {
	    	  logger.info("Closing input stream.");
	        input.close();
	      }
	    }
	    catch (FileNotFoundException ex) {
	    	logger.info("File not found.");
	    }
	    catch (IOException ex) {
	    	logger.info(ex.toString());
	    }
	    return result;
	}
    
}
