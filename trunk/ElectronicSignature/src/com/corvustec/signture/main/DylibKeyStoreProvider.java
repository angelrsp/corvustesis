/*    */ package com.corvustec.signture.main;
/*    */ 
/*    */ public class DylibKeyStoreProvider extends PKCS11KeyStoreProvider
/*    */ {
/*    */   private static String CONFIG;
/*    */ 
/*    */   public DylibKeyStoreProvider()
/*    */   {
/* 25 */     StringBuffer config = new StringBuffer();
/* 26 */     config.append("name=eToken\n");
/* 27 */     config.append("library=/usr/local/lib/libeTPkcs11.dylib\n");
/*    */ 
/* 29 */     CONFIG = config.toString();
/*    */   }
/*    */ 
/*    */   public String getConfig()
/*    */   {
/* 34 */     return CONFIG;
/*    */   }
/*    */ }

/* Location:           D:\ComprobantesElectronicos\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.util.key.DylibKeyStoreProvider
 * JD-Core Version:    0.6.0
 */