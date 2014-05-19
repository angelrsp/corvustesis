package com.corvustec.facturacionelectronica.firma.xml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Enumeration;
import java.util.List;
  

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;


import org.w3c.dom.Document;
import org.xml.sax.SAXException;
  

import es.mityc.firmaJava.libreria.utilidades.UtilidadTratarNodo;
import es.mityc.firmaJava.libreria.xades.DataToSign;
import es.mityc.firmaJava.libreria.xades.FirmaXML;
import es.mityc.javasign.pkstore.CertStoreException;
import es.mityc.javasign.pkstore.IPKStoreManager;
import es.mityc.javasign.pkstore.keystore.KSStore;
  
/**
  * <p>
   * Clase base que deber�an extender los diferentes ejemplos para realizar firmas
   * XML.
   * </p>
   * 
   */
  public abstract class GenericXMLSignature {
  
      /**
       * <p>
       * Almac�n PKCS12 con el que se desea realizar la firma
       * </p>
       */
      public final static String PKCS12_RESOURCE = "D:\\FacturacionElectronica\\jose_luis_beltran_aviles.p12";
  
      /**
       * <p>
       * Constrase�a de acceso a la clave privada del usuario
      * </p>
       */
      public final static String PKCS12_PASSWORD = "Jose Luis Beltran";
  
      /**
       * <p>
       * Directorio donde se almacenar� el resultado de la firma
       * </p>
       */
  
      public final static String OUTPUT_DIRECTORY = "D:\\FacturacionElectronica";
      /**
       * <p>
       * Ejecuci�n del ejemplo. La ejecuci�n consistir� en la firma de los datos
       * creados por el m�todo abstracto <code>createDataToSign</code> mediante el
       * certificado declarado en la constante <code>PKCS12_FILE</code>. El
       * resultado del proceso de firma ser� almacenado en un fichero XML en el
       * directorio correspondiente a la constante <code>OUTPUT_DIRECTORY</code>
       * del usuario bajo el nombre devuelto por el m�todo abstracto
       * <code>getSignFileName</code>
       * </p>
       */
      protected void execute() {
 
          // Obtencion del gestor de claves
    	  KeyStore keyStore = getKeyStore();
          if (keyStore == null) {
             System.err.println("El gestor de claves no se ha obtenido correctamente.");
             return;
         }
 
          String alias=getAlias(keyStore);
          
         // Obtencion del certificado para firmar. Utilizaremos el primer
         // certificado del almacen.
         X509Certificate certificate = null;
		try {
			certificate = (X509Certificate) keyStore.getCertificate(alias);
	         if (certificate == null) {
	             System.err.println("No existe ning�n certificado para firmar.");
	             return;
	        }
		} catch (KeyStoreException e1) {
			e1.printStackTrace();
		}
 
         // Obtenci�n de la clave privada asociada al certificado
         PrivateKey privateKey = null;
         try {
             privateKey = (PrivateKey) keyStore.getKey(alias, PKCS12_PASSWORD.toCharArray());
         } catch (UnrecoverableKeyException e) {
			e.printStackTrace();
		} catch (KeyStoreException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
 
         // Obtenci�n del provider encargado de las labores criptogr�ficas
         Provider provider = keyStore.getProvider();
 
         /*
          * Creaci�n del objeto que contiene tanto los datos a firmar como la
          * configuraci�n del tipo de firma
          */
         DataToSign dataToSign = createDataToSign();
 
         /*
          * Creaci�n del objeto encargado de realizar la firma
          */
         FirmaXML firma = new FirmaXML();
 
         // Firmamos el documento
         Document docSigned = null;
         try {
             Object[] res = firma.signFile(certificate, dataToSign, privateKey, provider);
            docSigned = (Document) res[0];
        } catch (Exception ex) {
             System.err.println("Error realizando la firma");
             ex.printStackTrace();
             return;
         }
 
         // Guardamos la firma a un fichero en el home del usuario
         String filePath = OUTPUT_DIRECTORY + File.separatorChar + getSignatureFileName();
         System.out.println("Firma salvada en en: " + filePath);
         saveDocumentToFile(docSigned, filePath);
     }
 
      private KeyStore getKeyStore()
      {
    	  KeyStore ks = null;
 		try {
 			ks = KeyStore.getInstance("PKCS12");
 			ks.load(new FileInputStream(PKCS12_RESOURCE), PKCS12_PASSWORD.toCharArray());
 		} catch (KeyStoreException e) {
 			e.printStackTrace();
 		} catch (NoSuchAlgorithmException e) {
 			e.printStackTrace();
 		} catch (CertificateException e) {
 			e.printStackTrace();
 		} catch (IOException e) {
 			e.printStackTrace();
 		}
          return ks;
      }
	/**
      * <p>
      * Crea el objeto DataToSign que contiene toda la informaci�n de la firma
      * que se desea realizar. Todas las implementaciones deber�n proporcionar
      * una implementaci�n de este m�todo
      * </p>
      * 
      * @return El objeto DataToSign que contiene toda la informaci�n de la firma
      *         a realizar
      */
     protected abstract DataToSign createDataToSign();
 
     /**
      * <p>
      * Nombre del fichero donde se desea guardar la firma generada. Todas las
      * implementaciones deber�n proporcionar este nombre.
      * </p>
      * 
      * @return El nombre donde se desea guardar la firma generada
      */
     protected abstract String getSignatureFileName();
 
     /**
      * <p>
      * Escribe el documento a un fichero.
      * </p>
      * 
      * @param document
      *            El documento a imprmir
     * @param pathfile
      *            El path del fichero donde se quiere escribir.
      */
     private void saveDocumentToFile(Document document, String pathfile) {
         try {
             FileOutputStream fos = new FileOutputStream(pathfile);
             UtilidadTratarNodo.saveDocumentToOutputStream(document, fos, true);
         } catch (FileNotFoundException e) {
             System.err.println("Error al salvar el documento");
             e.printStackTrace();
             System.exit(-1);
         }
     }
 
     /**
      * <p>
      * Escribe el documento a un fichero. Esta implementacion es insegura ya que
      * dependiendo del gestor de transformadas el contenido podr�a ser alterado,
      * con lo que el XML escrito no ser�a correcto desde el punto de vista de
      * validez de la firma.
      * </p>
      * 
      * @param document
      *            El documento a imprmir
      * @param pathfile
      *            El path del fichero donde se quiere escribir.
      */
     @SuppressWarnings("unused")
     private void saveDocumentToFileUnsafeMode(Document document, String pathfile) {
        TransformerFactory tfactory = TransformerFactory.newInstance();
         Transformer serializer;
         try {
             serializer = tfactory.newTransformer();

             serializer.transform(new DOMSource(document), new StreamResult(new File(pathfile)));
         } catch (TransformerException e) {
             System.err.println("Error al salvar el documento");
             e.printStackTrace();
             System.exit(-1);
         }
     }
 
     /**
      * <p>
      * Devuelve el <code>Document</code> correspondiente al
      * <code>resource</code> pasado como par�metro
      * </p>
      * 
      * @param resource
      *            El recurso que se desea obtener
      * @return El <code>Document</code> asociado al <code>resource</code>
      */
     protected Document getDocument(String resource) {
         Document doc = null;
         DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
         dbf.setNamespaceAware(true);
         DocumentBuilder db=null;
         File file=new File(resource);
         try {
        	 db=dbf.newDocumentBuilder();
             doc=db.parse(file);
         } catch (SAXException ex) {
             System.err.println("Error al parsear el documento");
             ex.printStackTrace();
             System.exit(-1);
         } catch (IOException ex) {
             System.err.println("Error al parsear el documento");
             ex.printStackTrace();
             System.exit(-1);
         } catch (IllegalArgumentException ex) {
             System.err.println("Error al parsear el documento");
             ex.printStackTrace();
             System.exit(-1);
         } catch (ParserConfigurationException e) {
        	 System.err.println("Error al parsear el documento");
			e.printStackTrace();
		}
         return doc;
     }
 
     /**
      * <p>
      * Devuelve el contenido del documento XML
      * correspondiente al <code>resource</code> pasado como par�metro
      * </p> como un <code>String</code>
      * 
      * @param resource
      *            El recurso que se desea obtener
      * @return El contenido del documento XML como un <code>String</code>
      */
     protected String getDocumentAsString(String resource) {
         Document doc = getDocument(resource);
         TransformerFactory tfactory = TransformerFactory.newInstance();
         Transformer serializer;
         StringWriter stringWriter = new StringWriter();
         try {
             serializer = tfactory.newTransformer();
             serializer.transform(new DOMSource(doc), new StreamResult(stringWriter));
         } catch (TransformerException e) {
             System.err.println("Error al imprimir el documento");
             e.printStackTrace();
             System.exit(-1);
         }
 
         return stringWriter.toString();
     }
 
     /**
      * <p>
      * Devuelve el gestor de claves que se va a utilizar
      * </p>
      * 
      * @return El gestor de claves que se va a utilizar</p>
      */
     private IPKStoreManager getPKStoreManager() {
         IPKStoreManager storeManager = null;
         try {
             KeyStore ks = KeyStore.getInstance("PKCS12");
             ks.load(this.getClass().getResourceAsStream(PKCS12_RESOURCE), PKCS12_PASSWORD.toCharArray());
             storeManager = new KSStore(ks, new PassStoreKS(PKCS12_PASSWORD));
         } catch (KeyStoreException ex) {
             System.err.println("No se puede generar KeyStore PKCS12");
             ex.printStackTrace();
             System.exit(-1);
         } catch (NoSuchAlgorithmException ex) {
             System.err.println("No se puede generar KeyStore PKCS12");
             ex.printStackTrace();
             System.exit(-1);
         } catch (CertificateException ex) {
             System.err.println("No se puede generar KeyStore PKCS12");
             ex.printStackTrace();
             System.exit(-1);
         } catch (IOException ex) {
             System.err.println("No se puede generar KeyStore PKCS12");
             ex.printStackTrace();
             System.exit(-1);
         }
         return storeManager;
     }
 
     /**
      * <p>
      * Recupera el primero de los certificados del almac�n.
      * </p>
      * 
      * @param storeManager
      *            Interfaz de acceso al almac�n
      * @return Primer certificado disponible en el almac�n
      */
     private X509Certificate getFirstCertificate(
             final IPKStoreManager storeManager) {
         List<X509Certificate> certs = null;
         try {
             certs = storeManager.getSignCertificates();
         } catch (CertStoreException ex) {
             System.err.println("Fallo obteniendo listado de certificados");
             System.exit(-1);
         }
         if ((certs == null) || (certs.size() == 0)) {
             System.err.println("Lista de certificados vac�a");
             System.exit(-1);
         }
 
         X509Certificate certificate = certs.get(0);
         return certificate;
     }
 
     
     private static String getAlias(KeyStore keyStore)
     {
         String alias = null;
         Enumeration<String> nombres;
           try {
               nombres = keyStore.aliases();
                   
               while(nombres.hasMoreElements())
               {
                   String tmpAlias = (String)nombres.nextElement();
                   if(keyStore.isKeyEntry(tmpAlias))
                   alias=tmpAlias;
               }
           }
           catch (KeyStoreException e) {
               e.printStackTrace();
           }
           return alias;
     }
     
 }