package com.corvustec.signature.xml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.lang.reflect.Field;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.KeyStoreSpi;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;
  
import com.corvustec.signature.xml.commons.util.MessagesApplication;
import com.corvustec.util.EncryptedUtil;

import es.mityc.firmaJava.libreria.utilidades.UtilidadTratarNodo;
import es.mityc.firmaJava.libreria.xades.DataToSign;
import es.mityc.firmaJava.libreria.xades.FirmaXML;
//import es.mityc.javasign.issues.PassStoreKS;
import es.mityc.javasign.pkstore.CertStoreException;
import es.mityc.javasign.pkstore.IPKStoreManager;
import es.mityc.javasign.pkstore.keystore.KSStore;

public abstract class GenericXMLSignature {
  
      /**
       * <p>
       * Almacén PKCS12 con el que se desea realizar la firma
       * </p>
       */
      public final static String PKCS12_RESOURCE = "/home/fernando/FacturacionElectronica/clientes/Prueba/Firma/francisco_arturo_velez_rojas.p12";
  
      /**
       * <p>
       * Constraseña de acceso a la clave privada del usuario
       * </p>
       */
      public final static String PKCS12_PASSWORD = EncryptedUtil.getInstancia().desencriptar("ulygGd+Hh/4di7WinfA1NA==");
  
      /**
       * <p>
       * Directorio donde se almacenará el resultado de la firma
       * </p>
       */
      public final static String OUTPUT_DIRECTORY = ".";
      
      
      private static final String KEYSTORE_TYPE=MessagesApplication.getInstancia().getString("com.corvustec.signature.xml.key.file");
  
      /**
       * <p>
       * Ejecución del ejemplo. La ejecución consistirá en la firma de los datos
       * creados por el método abstracto <code>createDataToSign</code> mediante el
       * certificado declarado en la constante <code>PKCS12_FILE</code>. El
       * resultado del proceso de firma será almacenado en un fichero XML en el
       * directorio correspondiente a la constante <code>OUTPUT_DIRECTORY</code>
       * del usuario bajo el nombre devuelto por el método abstracto
       * <code>getSignFileName</code>
       * </p>
     * @throws KeyStoreException 
     * @throws IOException 
     * @throws FileNotFoundException 
     * @throws CertificateException 
     * @throws NoSuchAlgorithmException 
     * @throws UnrecoverableKeyException 
       */
      protected void execute() throws KeyStoreException, NoSuchAlgorithmException, CertificateException, FileNotFoundException, IOException, UnrecoverableKeyException {
  
    	  String alias;

    	  KeyStore keyStore  = KeyStore.getInstance(KEYSTORE_TYPE);
          keyStore.load(new FileInputStream(PKCS12_RESOURCE), PKCS12_PASSWORD.toCharArray()); 
         
          //Cargamos los alias en el keyStore
          fixAliases(keyStore);
         
          //Obtenemos el alias
          alias=getAlias(keyStore);
         
          // Obtenemos la clave privada, pues la necesitaremos para encriptar. 
          PrivateKey privateKey = (PrivateKey) keyStore.getKey(alias, PKCS12_PASSWORD.toCharArray()); 
    	  
          X509Certificate certificate = (X509Certificate) keyStore.getCertificate(alias);
 
         // Obtención del provider encargado de las labores criptográficas
         Provider provider = keyStore.getProvider();
 
         /*
          * Creación del objeto que contiene tanto los datos a firmar como la
          * configuración del tipo de firma
          */
         DataToSign dataToSign = createDataToSign();
 
         /*
          * Creación del objeto encargado de realizar la firma
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
         saveDocumentToFile(docSigned, getSignatureFileName());
     }
 
     /**
      * <p>
      * Crea el objeto DataToSign que contiene toda la información de la firma
      * que se desea realizar. Todas las implementaciones deberán proporcionar
      * una implementación de este método
      * </p>
      * 
      * @return El objeto DataToSign que contiene toda la información de la firma
      *         a realizar
      */
     protected abstract DataToSign createDataToSign();
 
     /**
      * <p>
      * Nombre del fichero donde se desea guardar la firma generada. Todas las
      * implementaciones deberán proporcionar este nombre.
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
      * dependiendo del gestor de transformadas el contenido podría ser alterado,
      * con lo que el XML escrito no sería correcto desde el punto de vista de
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
      * <code>resource</code> pasado como parámetro
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
         try {
             doc = dbf.newDocumentBuilder().parse(this.getClass().getResourceAsStream(resource));
         } catch (ParserConfigurationException ex) {
             System.err.println("Error al parsear el documento");
             ex.printStackTrace();
             System.exit(-1);
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
         }
         return doc;
     }
 
     /**
      * <p>
      * Devuelve el contenido del documento XML
      * correspondiente al <code>resource</code> pasado como parámetro
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
 

     private static void fixAliases(KeyStore keyStore) {
         Field field;
         //Iterator i$;
         try
           {
             field = keyStore.getClass().getDeclaredField("keyStoreSpi");
             field.setAccessible(true);
             KeyStoreSpi keyStoreVeritable = (KeyStoreSpi)field.get(keyStore);

             if ("sun.security.mscapi.KeyStore$MY".equals(keyStoreVeritable.getClass().getName()))
             {
               field = keyStoreVeritable.getClass().getEnclosingClass().getDeclaredField("entries");
               field.setAccessible(true);
               @SuppressWarnings("rawtypes")
               Collection entries = (Collection)field.get(keyStoreVeritable);

               for (@SuppressWarnings("rawtypes")
               Iterator i$ = entries.iterator(); i$.hasNext(); ) { Object entry = i$.next();
                 field = entry.getClass().getDeclaredField("certChain");
                 field.setAccessible(true);
                 X509Certificate[] certificates = (X509Certificate[])(X509Certificate[])field.get(entry);

                 String hashCode = Integer.toString(certificates[0].hashCode());

                 field = entry.getClass().getDeclaredField("alias");
                 String alias = (String)field.get(entry);

                 if (!alias.equals(hashCode))
                   field.set(entry, alias.concat(" - ").concat(hashCode));
               }
             }
           }
           catch (Exception e)
           {
               e.printStackTrace();
           }
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
               // TODO Auto-generated catch block
               e.printStackTrace();
           }
           return alias;
     }

     
     
}    