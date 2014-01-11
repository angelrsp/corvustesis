/*    */ package com.corvustec.signture.main;
/*    */ 
/*    */ public class WindowsOtherKeyStoreProvider extends PKCS11KeyStoreProvider
/*    */ {
/*    */   private static final String config;
/*    */ 
/*    */   public String getConfig()
/*    */   {
/* 37 */     return config;
/*    */   }
/*    */ 
/*    */   static
/*    */   {
/* 28 */     StringBuffer sb = new StringBuffer();
/* 29 */     sb.append("name=Safenetikey2032\n");
/* 30 */     sb.append("library=C:\\WINDOWS\\SYSTEM32\\dkck201.dll\n");
/* 31 */     sb.append("disabledMechanisms={ CKM_SHA1_RSA_PKCS }");
/* 32 */     config = sb.toString();
/*    */   }
/*    */ }

/* Location:           D:\ComprobantesElectronicos\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.util.key.WindowsOtherKeyStoreProvider
 * JD-Core Version:    0.6.0
 */