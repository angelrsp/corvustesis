package com.corvustec.signture.main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
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
import java.util.GregorianCalendar;
import java.util.Iterator;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.corvustec.signature.xml.FirmasGenericasXAdES;
import com.corvustec.signature.xml.commons.util.MessagesApplication;

public class Test {

	private static final String KEYSTORE_TYPE=MessagesApplication.getInstancia().getString("com.corvustec.signature.xml.key.file");
	
	public static void main(String[] args) {
		String alias;
		String pass="Paquitovel11";
		Provider provider = null;
		 KeyStore keyStore;
		 
		 PrivateKey clavePrivada = null;
		 
		 try {
			 keyStore = KeyStore.getInstance(KEYSTORE_TYPE);
			keyStore.load(new FileInputStream("D:\\FacturacionElectronica\\clientes\\Prueba\\firma\\francisco_arturo_velez_rojas.p12"), pass.toCharArray());
			
			 //Cargamos los alias en el keyStore
            fixAliases(keyStore);
          
            //Obtenemos el alias
            alias=getAlias(keyStore);
          
            //keyStore = KeyStoreProviderFactory.createKeyStoreProvider().getKeystore(pass.toCharArray());
            
            // Obtenemos la clave privada, pues la necesitaremos para encriptar.
            
            KeyStore tmpKs = keyStore;
            
            PrivateKey privateKey = (PrivateKey) tmpKs.getKey(alias, pass.toCharArray()); 
            
            clavePrivada=privateKey;
            
            provider = keyStore.getProvider();
            
            FirmasGenericasXAdES firmador = new FirmasGenericasXAdES();
            X509Certificate certificado = (X509Certificate)keyStore.getCertificate(alias);

            certificado.checkValidity(new GregorianCalendar().getTime());
            
            firmador.ejecutarFirmaXades("D:\\FacturacionElectronica\\clientes\\Prueba\\xml\\0710201301179125123700110010650000000107791051216.xml", null, "D:\\FacturacionElectronica\\clientes\\Prueba\\xml\\firmado.xml", provider, certificado, privateKey);
			
		} catch (NoSuchAlgorithmException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (CertificateException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 catch (KeyStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnrecoverableKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         
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
