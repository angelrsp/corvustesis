package com.corvustec.firmaelectronica.formato;

import org.w3c.dom.Document;

import es.mityc.firmaJava.libreria.xades.DataToSign;
import es.mityc.firmaJava.libreria.xades.XAdESSchemas;
import es.mityc.javasign.xml.refs.InternObjectToSign;
import es.mityc.javasign.xml.refs.ObjectToSign;

public class XAdESBESSignature extends GenericXMLSignature{


	
		private static String nameFile;
		private static String pathFile; 
		/**
		* <p>
		* Recurso a firmar
		* </p>
		*/
		private String fileToSign;
		  
		/**
		* <p>
		* Fichero donde se desea guardar la firma
		* </p>
		*/
		public XAdESBESSignature(String fileToSign) {
			super();
			this.fileToSign = fileToSign;
		}

		/**
	       * <p>
	       * Punto de entrada al programa
	       * </p>
	       * 
	       * @param args
	       *            Argumentos del programa
	       */
	  

		public static void firmar(String xmlPath,String pathSignature,String passSignature,String pathOut,String nameFileOut)
	    {			
	          //Document document=UtilApplication.convertStringToDocument(xml);

	          //String pathXml=UtilApplication.getTempPath()+"\\"+UUID.randomUUID().toString()+".xml";

	          //UtilApplication.saveDocumenteDisk(document, pathXml);

			
			
	    	  XAdESBESSignature signature = new XAdESBESSignature(xmlPath);
	    	  signature.setPassSignature(passSignature);
	    	  signature.setPathSignature(pathSignature);
	    	  pathFile=pathOut;
	    	  nameFile=nameFileOut;
	          
	          signature.execute();
	      }
	      
	      
	      @Override
	      protected DataToSign createDataToSign() {
	          
	          DataToSign datosAFirmar = new DataToSign();

	          datosAFirmar.setXadesFormat(es.mityc.javasign.EnumFormatoFirma.XAdES_BES);
	           
	          datosAFirmar.setEsquema(XAdESSchemas.XAdES_132);
	          datosAFirmar.setXMLEncoding("UTF-8");
	          datosAFirmar.setEnveloped(true);
	          datosAFirmar.addObject(new ObjectToSign(new InternObjectToSign("comprobante"), "contenido comprobante", null, "text/xml", null));
	          datosAFirmar.setParentSignNode("comprobante");

	          Document docToSign = getDocument(fileToSign);
	          datosAFirmar.setDocument(docToSign);

	          return datosAFirmar;
	      }
	  

		@Override
		protected String getSignatureFileName() {
			return XAdESBESSignature.nameFile;
		}
		
		@Override
		protected String getPathOut() {
			return XAdESBESSignature.pathFile;
		}
	
}
