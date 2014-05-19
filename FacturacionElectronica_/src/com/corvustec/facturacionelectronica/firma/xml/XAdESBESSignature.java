package com.corvustec.facturacionelectronica.firma.xml;

import org.w3c.dom.Document;

import es.mityc.firmaJava.libreria.xades.DataToSign;
import es.mityc.firmaJava.libreria.xades.XAdESSchemas;
import es.mityc.javasign.xml.refs.InternObjectToSign;
import es.mityc.javasign.xml.refs.ObjectToSign;
  
  /**
   * <p>
   * Clase de ejemplo para la firma XAdES-BES enveloped de un documento
   * </p>
   * <p>
   * Para realizar la firma se utilizará el almacén PKCS#12 definido en la
   * constante <code>GenericXMLSignature.PKCS12_FILE</code>, al que se accederá
   * mediante la password definida en la constante
   * <code>GenericXMLSignature.PKCS12_PASSWORD</code>. El directorio donde quedará
   * el archivo XML resultante será el indicado en al constante
   * <code>GenericXMLSignature.OUTPUT_DIRECTORY</code>
  * </p>
   * 
  */
  public class XAdESBESSignature extends GenericXMLSignature {
  
      /**
       * <p>
       * Recurso a firmar
       * </p>
       */
      private final static String RESOURCE_TO_SIGN = "D:\\FacturacionElectronica\\factura.xml";
  
      /**
       * <p>
       * Fichero donde se desea guardar la firma
       * </p>
       */
      private final static String SIGN_FILE_NAME = "prueba.xml";
  
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
          signature.execute();
      }
 
      @Override
      protected DataToSign createDataToSign() {
          DataToSign dataToSign = new DataToSign();
          
          dataToSign.setXadesFormat(es.mityc.javasign.EnumFormatoFirma.XAdES_BES);
          dataToSign.setEsquema(XAdESSchemas.XAdES_132);
          dataToSign.setXMLEncoding("UTF-8");
          dataToSign.setEnveloped(true);
          dataToSign.addObject(new ObjectToSign(new InternObjectToSign("comprobante"), "contenido comprobante", null, "text/xml", null));
          
          dataToSign.setParentSignNode("comprobante");
          Document docToSign = getDocument(RESOURCE_TO_SIGN);
          dataToSign.setDocument(docToSign);
          return dataToSign;
      }
  
      @Override
      protected String getSignatureFileName() {
          return SIGN_FILE_NAME;
      }
  }