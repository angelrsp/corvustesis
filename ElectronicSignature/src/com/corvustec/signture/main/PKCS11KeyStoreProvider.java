/*    */ package com.corvustec.signture.main;
/*    */ 
/*    */ import java.io.ByteArrayInputStream;
/*    */ import java.io.IOException;
/*    */ import java.io.InputStream;
/*    */ import java.lang.reflect.Constructor;
/*    */ import java.lang.reflect.InvocationTargetException;
/*    */ import java.security.KeyStore;
/*    */ import java.security.KeyStoreException;
/*    */ import java.security.NoSuchAlgorithmException;
/*    */ import java.security.Provider;
/*    */ import java.security.Security;
/*    */ import java.security.cert.CertificateException;
/*    */ 
/*    */ public abstract class PKCS11KeyStoreProvider
/*    */   implements KeyStoreProvider
/*    */ {
/*    */   public abstract String getConfig();
/*    */ 
/*    */   public KeyStore getKeystore(char[] password)
/*    */     throws KeyStoreException
/*    */   {
/*    */     try
/*    */     {
/* 46 */       InputStream configStream = new ByteArrayInputStream(getConfig().getBytes());
/*    */ 
/* 48 */       Provider sunPKCS11Provider = createSunPKCS11Provider(configStream);
/* 49 */       Security.addProvider(sunPKCS11Provider);
/*    */ 
/* 51 */       KeyStore keyStore = KeyStore.getInstance("PKCS11");
/* 52 */       keyStore.load(null, password);
/*    */ 
/* 54 */       return keyStore;
/*    */     } catch (CertificateException e) {
/* 56 */       throw new KeyStoreException(e);
/*    */     } catch (NoSuchAlgorithmException e) {
/* 58 */       throw new KeyStoreException(e); } 
				catch (IOException e) {
					throw new KeyStoreException(e);
/*    */     }
/* 60 */     //throw new KeyStoreException(e);
/*    */   }
/*    */ 
/*    */   private Provider createSunPKCS11Provider(InputStream configStream)
/*    */     throws KeyStoreException
/*    */   {
/*    */     try
/*    */     {
/* 73 */       Class sunPkcs11Class = Class.forName("sun.security.pkcs11.SunPKCS11");
/* 74 */       Constructor pkcs11Constr = sunPkcs11Class.getConstructor(new Class[] { InputStream.class });
/* 75 */       return (Provider)pkcs11Constr.newInstance(new Object[] { configStream });
/*    */     } catch (ClassNotFoundException e) {
/* 77 */       throw new KeyStoreException(e);
/*    */     } catch (NoSuchMethodException e) {
/* 79 */       throw new KeyStoreException(e);
/*    */     } catch (InvocationTargetException e) {
/* 81 */       throw new KeyStoreException(e);
/*    */     } catch (IllegalAccessException e) {
/* 83 */       throw new KeyStoreException(e); } 
			catch (InstantiationException e) {
				throw new KeyStoreException(e);
/*    */     }
/* 85 */     //
/*    */   }
/*    */ }

/* Location:           D:\ComprobantesElectronicos\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.util.key.PKCS11KeyStoreProvider
 * JD-Core Version:    0.6.0
 */