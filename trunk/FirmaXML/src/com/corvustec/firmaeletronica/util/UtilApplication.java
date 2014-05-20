package com.corvustec.firmaeletronica.util;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;

public class UtilApplication {

	
	 public static Document convertStringToDocument(String xmlStr) {
	        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance(); 
	        DocumentBuilder builder; 
	        try 
	        { 
	        	factory.setNamespaceAware(true);
	            builder = factory.newDocumentBuilder();
	            Document doc = builder.parse( new InputSource( new StringReader( xmlStr ) ) );
	            return doc;
	        } catch (Exception e) { 
	            e.printStackTrace(); 
	        }
	        return null;
	    }
	    
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
	 
	    		
	    		
	    	}catch(IOException e){
	    		e.printStackTrace();
	    	}
	    	return tempFilePath;
	    }
	 
	 
     public static void saveDocumenteDisk(Document document,String pathXml)
     {
         try {
                 DOMSource source = new DOMSource(document);
                 StreamResult result = new StreamResult(new File(pathXml));

                 TransformerFactory transformerFactory = TransformerFactory.newInstance();
                 Transformer transformer;
                 transformer = transformerFactory.newTransformer();
                 transformer.transform(source, result);
         } catch (TransformerConfigurationException e) {
                 // TODO Auto-generated catch block
                 e.printStackTrace();
         } catch (TransformerException e) {
                 // TODO Auto-generated catch block
                 e.printStackTrace();
         }
     }
}
