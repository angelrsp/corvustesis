package com.corvustec.firmaelectronica.formato;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Enumeration;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import com.corvustec.firmaeletronica.util.UtilApplication;

import es.mityc.firmaJava.libreria.xades.DataToSign;
import es.mityc.firmaJava.libreria.xades.FirmaXML;

public abstract class GenericXMLSignature {


	//Path de la firma electronica
	private String pathSignature;
	//calve de la firma electronica
	private String passSignature;
	  
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
	
	/*Metodos Getters y Setters (Propiedades)*/
	public String getPathSignature() {
		return pathSignature;
	}

	public void setPathSignature(String pathSignature) {
		this.pathSignature = pathSignature;
	}

	public String getPassSignature() {
		return passSignature;
	}

	public void setPassSignature(String passSignature) {
		this.passSignature = passSignature;
	}
	
	protected void execute() {
	  
		// Obtencion del gestor de claves
		KeyStore keyStore = getKeyStore();
		
		if(keyStore==null){
			System.err.println("No se pudo obtener almacen de firma.");
			return;
		}
		String alias=getAlias(keyStore);
		
		// Obtencion del certificado para firmar. Utilizaremos el primer
		// certificado del almacen.			
		X509Certificate certificate = null;
		try {
			certificate = (X509Certificate)keyStore.getCertificate(alias);
			if (certificate == null) {
				System.err.println("No existe ning�n certificado para firmar.");
				return;
			}
		} catch (KeyStoreException e1) {
			e1.printStackTrace();
		}
	 
		// Obtenci�n de la clave privada asociada al certificado
		PrivateKey privateKey = null;
		KeyStore tmpKs = keyStore;
		try {
			privateKey = (PrivateKey) tmpKs.getKey(alias, this.passSignature.toCharArray()); 
		} catch (UnrecoverableKeyException e) {
			System.err.println("No existe clave privada para firmar.");
			e.printStackTrace();
		} catch (KeyStoreException e) {
			System.err.println("No existe clave privada para firmar.");
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			System.err.println("No existe clave privada para firmar.");
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
         String filePath = getPathOut() + File.separatorChar + getSignatureFileName();
         System.out.println("Firma salvada en en: " + filePath);
         
         UtilApplication.saveDocumenteDisk(docSigned, filePath);
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
    
    protected abstract String getPathOut();
     
 
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
         File file = new File(resource);
         try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            
            doc=db.parse(file);
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
 
     
     private KeyStore getKeyStore()
     {
         KeyStore ks = null;
		try {
			ks = KeyStore.getInstance("PKCS12");
			ks.load(new FileInputStream(pathSignature), passSignature.toCharArray());
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
