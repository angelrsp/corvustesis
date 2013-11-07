package com.corvustec.signature.xml;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.KeyStoreSpi;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Collection;
import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Random;

import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.xml.security.c14n.Canonicalizer;
import org.apache.xml.security.exceptions.XMLSecurityException;
import org.apache.xml.security.signature.ObjectContainer;
import org.apache.xml.security.signature.XMLSignature;
import org.apache.xml.security.signature.XMLSignatureException;
import org.apache.xml.security.transforms.Transforms;
import org.apache.xml.security.utils.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;

import com.corvustec.signature.xml.commons.util.MessagesApplication;
import com.corvustec.signature.xml.exception.SignatureException;
import com.corvustec.util.EncryptedUtil;

/**
 * 
 * @author corvustec
 * 
 * Firma Electronica Banco Central del Ecuador
 * Firma archivos Xml con el estandar pkcs12
 *
 */


public class Signature {

    private static Random rnd = new Random(new Date().getTime());

    private final static Logger logger = LoggerFactory.getLogger(Signature.class);
   
    private static final String KEYSTORE_TYPE=MessagesApplication.getInstancia().getString("com.corvustec.signature.xml.key.file");
   
    public static Boolean Xml(File file, String pathSignature,String pass) throws SignatureException{
    	
        String alias;
        Boolean firmo;
        try {
           
            if (file.exists()) {
               
                String xmlPath = file.getAbsolutePath();
                //abrimos el archivo xml
                Document doc=DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(xmlPath);
               
               
                org.apache.xml.security.Init.init();
               
                //Creamos la instancia con del keystore con el tipo esto puede ser JKS, PCSK12, etc
                KeyStore keyStore  = KeyStore.getInstance(KEYSTORE_TYPE);
                keyStore.load(new FileInputStream(pathSignature), EncryptedUtil.getInstancia().desencriptar(pass).toCharArray()); 
               
                //Cargamos los alias en el keyStore
                fixAliases(keyStore);
               
                //Obtenemos el alias
                alias=getAlias(keyStore);
               
                // Obtenemos la clave privada, pues la necesitaremos para encriptar. 
                PrivateKey privateKey = (PrivateKey) keyStore.getKey(alias, EncryptedUtil.getInstancia().desencriptar(pass).toCharArray()); 
               
                // Instanciamos un objeto XMLSignature desde el Document. El algoritmo de firma ser� DSA 
                XMLSignature xmlSignature = new XMLSignature(doc, null, XMLSignature.ALGO_ID_SIGNATURE_RSA_SHA1); 
               
                String idSignature=newID("Signature");
                String idObject=newID("Object");
               
                xmlSignature.setId(idSignature);
                xmlSignature.getSignedInfo().setId(newID("Signature-SignedInfo"));
               
                // A�adimos el nodo de la firma a la raiz antes de firmar. 
                // Observe que ambos elementos pueden ser mezclados en una forma con referencias separadas
                doc.getDocumentElement().appendChild(xmlSignature.getElement()); 
               
                // Creamos el objeto que mapea: Document/Reference 
                Transforms transforms = new Transforms(doc); 
                transforms.addTransform(Transforms.TRANSFORM_ENVELOPED_SIGNATURE); 
               
                // A�adimos lo anterior Documento / Referencia 
                // ALGO_ID_DIGEST_SHA1 = "http://www.w3.org/2000/09/xmldsig#sha1"; 
                xmlSignature.addDocument("", transforms, Constants.ALGO_ID_DIGEST_SHA1); 
               
                // A�adimos el KeyInfo del certificado cuya clave privada usamos 
                X509Certificate cert = (X509Certificate) keyStore.getCertificate(alias); 
                xmlSignature.addKeyInfo(cert); 
                xmlSignature.addKeyInfo(cert.getPublicKey()); 
               
               
               
                ObjectContainer objectContainer=new ObjectContainer(doc);
               
                objectContainer.setId(idSignature+"-"+idObject);
               
               
                //xmlSignature.appendObject(objectContainer);
               
                // Realizamos la firma 
                xmlSignature.sign(privateKey);
               
                // Guardamos archivo de firma en disco
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                outputStream.write(Canonicalizer.getInstance(Canonicalizer.ALGO_ID_C14N_WITH_COMMENTS).canonicalizeSubtree(doc));
               
                OutputStream fileOutputStream = new FileOutputStream(xmlPath);
               
                fileOutputStream.write(outputStream.toByteArray());
                fileOutputStream.flush();
               
                fileOutputStream.close();
                firmo=true;
            } else {
                firmo=false;
                throw new SignatureException("Archivo no hay");
            }
           
        } catch (KeyStoreException e) {
            firmo=false;
            logger.error("Error {}",e.toString());
            throw new SignatureException(e);
        } catch (NoSuchAlgorithmException e) {
            firmo=false;
            logger.error("Error {}",e.toString());
            throw new SignatureException(e);
        } catch (CertificateException e) {
            firmo=false;
            logger.error("Error {}",e.toString());
            throw new SignatureException(e);
        } catch (FileNotFoundException e) {
            firmo=false;
            logger.error("Error {}",e.toString());
            throw new SignatureException(e);
        } catch (IOException e) {
            firmo=false;
            logger.error("Error {}",e.toString());
            throw new SignatureException(e);
        } catch (UnrecoverableKeyException e) {
            firmo=false;
            logger.error("Error {}",e.toString());
            throw new SignatureException(e);           
        } catch (XMLSignatureException e) {
            firmo=false;
            logger.error("Error {}",e.toString());
            throw new SignatureException(e);
        } catch (XMLSecurityException e) {
            firmo=false;
            logger.error("Error {}",e.toString());
            throw new SignatureException(e);
        } catch (Exception e) {
            firmo=false;
            logger.error("Error {}",e.toString());
            throw new SignatureException(e);
        }
        return firmo;
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
                  field.setAccessible(true);
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
     
     
      public static String newID(String prefix)
      {
        String newID = prefix + rnd.nextInt(1048576);
        newID = prefix + rnd.nextInt(1048576);
        return newID;
      }


}
