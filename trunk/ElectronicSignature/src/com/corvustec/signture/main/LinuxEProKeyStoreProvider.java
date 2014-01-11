/*    */ package com.corvustec.signture.main;
/*    */ 
/*    */ import java.io.File;
/*    */ 
/*    */ public class LinuxEProKeyStoreProvider extends PKCS11KeyStoreProvider
/*    */ {
/*    */   private static String CONFIG;
/*    */   private static String PATH;
/*    */ 
/*    */   public LinuxEProKeyStoreProvider()
/*    */   {
/* 26 */     File lib = new File("/usr/lib/libeTPkcs11.so");
/* 27 */     File lib32 = new File("/usr/lib32/libeTPkcs11.so");
/* 28 */     File lib64 = new File("/usr/lib64/libeTPkcs11.so");
/*    */ 
/* 30 */     if (lib.exists() == true)
/* 31 */       PATH = "/usr/lib/";
/* 32 */     else if (lib32.exists() == true)
/* 33 */       PATH = "/usr/lib32/";
/* 34 */     else if (lib64.exists() == true) {
/* 35 */       PATH = "/usr/lib64/";
/*    */     }
/*    */ 
/* 38 */     StringBuffer config = new StringBuffer();
/* 39 */     config.append("name=eToken\n");
/* 40 */     config.append("library=");
/* 41 */     config.append(PATH);
/* 42 */     config.append("libeTPkcs11.so\n");
/*    */ 
/* 44 */     CONFIG = config.toString();
/*    */   }
/*    */ 
/*    */   public String getConfig()
/*    */   {
/* 49 */     return CONFIG;
/*    */   }
/*    */ }

/* Location:           D:\ComprobantesElectronicos\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.util.key.LinuxEProKeyStoreProvider
 * JD-Core Version:    0.6.0
 */