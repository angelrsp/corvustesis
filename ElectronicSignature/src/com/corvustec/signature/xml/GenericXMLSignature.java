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
import es.mityc.javasign.issues.PassStoreKS;
import es.mityc.javasign.pkstore.CertStoreException;
import es.mityc.javasign.pkstore.IPKStoreManager;
import es.mityc.javasign.pkstore.keystore.KSStore;

public abstract class GenericXMLSignature {
  
      /**
       * <p>
       * AlmacÃ©n PKCS12 con el que se desea realizar la firma
       * </p>
       */
      public final static String PKCS12_RESOURCE = "D:\\FacturacionElectronica\\clientes\\Prueba\\firma\\francisco_arturo_velez_rojas.p12";
  
      /**
       * <p>
       * ConstraseÃ±a de acceso a la clave privada del usuario
       * </p>
       */
      //public final static String PKCS12_PASSWORD = EncryptedUtil.getInstancia().desencriptar("ulygGd+Hh/4di7WinfA1NA==");
      
      public final static String PKCS12_PASSWORD ="Paquitovel11";
  
      /**
       * <p>
       * Directorio donde se almacenarÃ¡ el resultado de la firma
       * </p>
       */
      public final static String OUTPUT_DIRECTORY = ".";
      
      
      private static final String KEYSTORE_TYPE=MessagesApplication.getInstancia().getString("com.corvustec.signature.xml.key.file");
  
      /**
       * <p>
       * EjecuciÃ³n del ejemplo. La ejecuciÃ³n consistirÃ¡ en la firma de los datos
       * creados por el mÃ©todo abstracto <code>createDataToSign</code> mediante el
       * certificado declarado en la constante <code>PKCS12_FILE</code>. El
       * resultado del proceso de firma serÃ¡ almacenado en un fichero XML en el
       * directorio correspondiente a la constante <code>OUTPUT_DIRECTORY</code>
       * del usuario bajo el nombre devuelto por el mÃ©todo abstracto
       * <code>getSignFileName</code>
       * </p>
     * @throws KeyStoreException 
     * @throws IOException 
     * @throws FileNotFoundException 
     * @throws CertificateException 
     * @throws NoSuchAlgorithmException 
     * @throws UnrecoverableKeyException 
       */
  protected void execute() {
  
          // Obtencion del gestor de claves
         IPKStoreManager storeManager = getPKStoreManager();
         if (storeManager == null) {
              System.err.println("El gestor de claves no se ha obtenido correctamente.");
              return;
         }
 
         // Obtencion del certificado para firmar. Utilizaremos el primer
         // certificado del almacen.
         X509Certificate certificate = getFirstCertificate(storeManager);
         if (certificate == null) {
             System.err.println("No existe ningún certificado para firmar.");
             return;
         }
 
         // Obtención de la clave privada asociada al certificado
         PrivateKey privateKey;
         try {
             privateKey = storeManager.getPrivateKey(certificate);
         } catch (CertStoreException e) {
             System.err.println("Error al acceder al almacén.");
             return;
         }
 
         // Obtención del provider encargado de las labores criptográficas
         Provider provider = storeManager.getProvider(certificate);
 
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
      * Recupera el primero de los certificados del almacén.
      * </p>
      * 
      * @param storeManager
      *            Interfaz de acceso al almacén
      * @return Primer certificado disponible en el almacén
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
             System.err.println("Lista de certificados vacía");
             System.exit(-1);
         }
 
         X509Certificate certificate = certs.get(0);
         return certificate;
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