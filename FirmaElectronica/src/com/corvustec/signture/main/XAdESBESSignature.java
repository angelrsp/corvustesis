package com.corvustec.signture.main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import com.corvustec.signature.xml.GenericXMLSignature;

import es.mityc.firmaJava.libreria.xades.DataToSign;
import es.mityc.firmaJava.libreria.xades.XAdESSchemas;
import es.mityc.firmaJava.role.SimpleClaimedRole;
import es.mityc.javasign.EnumFormatoFirma;
import es.mityc.javasign.xml.refs.AllXMLToSign;
import es.mityc.javasign.xml.refs.ObjectToSign;


public class XAdESBESSignature extends GenericXMLSignature{

/**
      * <p>
       * Recurso a firmar
       * </p>
       */
      private final static String RESOURCE_TO_SIGN = "/home/fernando/FacturacionElectronica/clientes/Prueba/xml/0710201301179125123700110010650000000107791051216.xml";
  
      /**
       * <p>
       * Fichero donde se desea guardar la firma
       * </p>
       */
      private final static String SIGN_FILE_NAME = "/home/fernando/FacturacionElectronica/clientes/Prueba/firmado/XAdES-BES-Sign.xml";
  
      /**
       * <p>
       * Punto de entrada al programa
       * </p>
       * 
       * @param args
       *            Argumentos del programa
       */
      public static void main(String[] args) {
          XAdESBESSignature signature = new XAdESBESSignature();
          try {
			signature.execute();
		} catch (UnrecoverableKeyException | KeyStoreException
				| NoSuchAlgorithmException | CertificateException
				| IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      }
  
      @Override
      protected DataToSign createDataToSign() {
          DataToSign dataToSign = new DataToSign();
          dataToSign.setXadesFormat(EnumFormatoFirma.XAdES_BES);
          dataToSign.setEsquema(XAdESSchemas.XAdES_132);
          dataToSign.setXMLEncoding("UTF-8");
          // Se añade un rol de firma
          dataToSign.addClaimedRol(new SimpleClaimedRole("Rol de firma"));
          dataToSign.setEnveloped(true);
          dataToSign.addObject(new ObjectToSign(new AllXMLToSign(), "Documento de ejemplo", null, "text/xml", null));
          Document docToSign = null;
		try {
			docToSign = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(RESOURCE_TO_SIGN);
		} catch (SAXException | IOException | ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
          dataToSign.setDocument(docToSign);
          return dataToSign;
      }
  
      @Override
      protected String getSignatureFileName() {
          return SIGN_FILE_NAME;
      }
	
}
