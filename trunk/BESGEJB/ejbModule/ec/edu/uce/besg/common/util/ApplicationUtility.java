package ec.edu.uce.besg.common.util;

import java.io.ByteArrayInputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;

public class ApplicationUtility {

	private static ApplicationUtility applicationUtility;
	
	public static ApplicationUtility getInstance() {
		if(applicationUtility==null)
			applicationUtility=new ApplicationUtility();
		return applicationUtility;
	}
	
	public StringBuilder appendStringBuilder(Object... values)
	{
		StringBuilder stringBuilder=new StringBuilder();
		for(Object value: values)
		{
			if(value==null){
				stringBuilder.append(String.valueOf(value));	
			}
			stringBuilder.append(value);
		}
		return stringBuilder;
	}
	
	public Document byteToDocument(byte[] documentoXml) throws Exception {
	    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	    factory.setNamespaceAware(true);
	    DocumentBuilder builder = factory.newDocumentBuilder();
	    return builder.parse(new ByteArrayInputStream(documentoXml));
	}
	
 
	public Date stringToDate(String date) throws ParseException
	{
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		return formatter.parse(date);
	}
	
	public Document stringToDocument(String xmlStr) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();  
		DocumentBuilder builder;  
		try  
		{  
		    builder = factory.newDocumentBuilder();  
		    Document doc = builder.parse( new InputSource( new StringReader( xmlStr ) ) ); 
		    return doc;
		} catch (Exception e) {  
		    e.printStackTrace();  
		} 
		return null;
	}
	 
	public String documentToString(Document document) {
		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer transformer;
		try {
		    transformer = tf.newTransformer();
		    // below code to remove XML declaration
		    // transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
		    StringWriter writer = new StringWriter();
		    transformer.transform(new DOMSource(document), new StreamResult(writer));
		    String output = writer.getBuffer().toString();
		    return output;
		} catch (TransformerException e) {
		    e.printStackTrace();
		}
		return null;
	}
	
	
}
