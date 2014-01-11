/*    */ package com.corvustec.signture.main;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.util.logging.Logger;
/*    */ 
/*    */ public class KeyStoreProviderFactory
/*    */ {
/* 12 */   private static final Logger log = Logger.getLogger(KeyStoreProviderFactory.class.getName());
/*    */ 
/*    */   public static KeyStoreProvider createKeyStoreProvider()
/*    */   {
/* 25 */     String osName = System.getProperty("os.name");
/*    */ 
/* 27 */     if (osName.toUpperCase().indexOf("WINDOWS") == 0)
/* 28 */       return new WindowsOtherKeyStoreProvider();
/* 29 */     if (osName.toUpperCase().indexOf("LINUX") == 0) {
/* 30 */       if (existeLibreriaLinux() == true) {
/* 31 */         return new LinuxEProKeyStoreProvider();
/*    */       }
/* 33 */       return new LinuxKeyStoreProvider();
/*    */     }
/* 35 */     if (osName.toUpperCase().indexOf("MAC") == 0) {
/* 36 */       if (existeLibreriaMac() == true) {
/* 37 */         return new DylibKeyStoreProvider();
/*    */       }
/* 39 */       return new AppleKeyStoreProvider();
/*    */     }
/*    */ 
/* 42 */     throw new IllegalArgumentException("Sistema operativo no soportado!");
/*    */   }
/*    */ 
/*    */   private static boolean existeLibreriaLinux()
/*    */   {
/* 53 */     boolean resultado = false;
/*    */ 
/* 55 */     File lib = new File("/usr/lib/libeTPkcs11.so");
/* 56 */     File lib32 = new File("/usr/lib32/libeTPkcs11.so");
/* 57 */     File lib64 = new File("/usr/lib64/libeTPkcs11.so");
/*    */ 
/* 59 */     if ((lib.exists() == true) || (lib32.exists() == true) || (lib64.exists() == true)) {
/* 60 */       resultado = true;
/*    */     }
/* 62 */     return resultado;
/*    */   }
/*    */ 
/*    */   public static boolean existeLibreriaMac()
/*    */   {
/* 73 */     boolean resultado = false;
/*    */ 
/* 75 */     File lib = new File("/usr/local/lib/libeTPkcs11.dylib");
/*    */ 
/* 77 */     if (lib.exists() == true) {
/* 78 */       resultado = true;
/*    */     }
/* 80 */     return resultado;
/*    */   }
/*    */ }

/* Location:           D:\ComprobantesElectronicos\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.util.key.KeyStoreProviderFactory
 * JD-Core Version:    0.6.0
 */