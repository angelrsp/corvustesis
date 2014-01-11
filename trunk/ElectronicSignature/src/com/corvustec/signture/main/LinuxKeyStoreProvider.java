/*    */ package com.corvustec.signture.main;
/*    */ 
/*    */ public class LinuxKeyStoreProvider extends PKCS11KeyStoreProvider
/*    */ {
/*    */   private static final String CONFIG;
/*    */ 
/*    */   public String getConfig()
/*    */   {
/* 33 */     return CONFIG;
/*    */   }
/*    */ 
/*    */   static
/*    */   {
/* 24 */     StringBuffer config = new StringBuffer();
/* 25 */     config.append("name=Safenetikey2032\n");
/* 26 */     config.append("library=/usr/local/SafeNet/lib/libsfntpkcs11.so\n");
/* 27 */     config.append("disabledMechanisms={ CKM_SHA1_RSA_PKCS }");
/* 28 */     CONFIG = config.toString();
/*    */   }
/*    */ }

/* Location:           D:\ComprobantesElectronicos\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.util.key.LinuxKeyStoreProvider
 * JD-Core Version:    0.6.0
 */