package com.corvustec.rtoqab.process.util;

import java.security.spec.KeySpec;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.xerces.impl.dv.util.Base64;

public class Cryptography {

    final static char[] PASSWORD="ElSecretosOme*ShaREd*SecreT".toCharArray();
    final static String IV = "TZuWY0W5Yn9l9F2DEiU0hg==";

    private static Cryptography instance;
    
    public static Cryptography getInstance() {
		if(instance==null)
			instance=new Cryptography();
		return instance;
	}
    
    private SecretKeySpec generateKey() throws Exception {
    	
    	byte[] salt = new byte[]{-84, -119, 25, 56, -100, 100, -120, -45, 84, 67, 96, 10, 24, 111, 112, -119, 3};
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        KeySpec spec = new PBEKeySpec(PASSWORD, salt, 1024, 128);
        SecretKey tmp = factory.generateSecret(spec);
        SecretKeySpec secret = new SecretKeySpec(tmp.getEncoded(), "AES");
        return secret;
    }
	
	 public String encrypt(String cleartext) throws Exception {
	    	SecretKeySpec secret=generateKey();
	    	byte[] iv=Base64.decode(IV);
	        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
	        cipher.init(Cipher.ENCRYPT_MODE, secret,iv == null ? null : new IvParameterSpec(iv));
	        byte[] ciphertext = cipher.doFinal(cleartext.getBytes("UTF-8"));
	        String result=Base64.encode(ciphertext);
	        return result;
	    }

	    /**
	     * Decrypts the cipher text using the previously generated AES key and IV.
	     */
	    public String decrypt(String etext) throws Exception {
	    	byte[] ciphertext=Base64.decode(etext);
	    	SecretKeySpec secret=generateKey();
	    	byte[] iv=Base64.decode(IV);
	        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
	        cipher.init(Cipher.DECRYPT_MODE, secret, new IvParameterSpec(iv));
	        String plaintext = new String(cipher.doFinal(ciphertext), "UTF-8");
	        return plaintext;
	    }
	
}
