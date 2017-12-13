/**
 * Project				:	prjDPS
 * Organization			:	Sultan Qaboos University | Muscat | Oman
 * Centre				:	Centre for Information System
 * Department			:	Web & E-Services
 * 
 * Author				:	Bhabesh
 *
 * FrameWork			:	Spring 4.0.8 (Annotation) Portlet
 * 
 * File Name			:	CryptoAES.java
 * Package Name			:	om.edu.squ.squportal.portlet.dps.utility
 * Date of creation		:	Nov 15, 2017  11:46:34 AM
 * Date of modification :	
 * 
 * Summary				:	Encrypt and decrypt from crypto-js (https://code.google.com/archive/p/crypto-js/)
 * 							This code mostly shared from Mr.Subhadip Pal's blog post at linkedin pulse.
 * 							Many thanks for this great effort to Mr.Subhadip.
 * Source				:	https://www.linkedin.com/pulse/jshtml5-java-encryption-using-aes-128bit256bit-subhadip-pal/
 *
 *
 * Copyright 2017 the original author or authors and Organization.
 *
 * Licensed under the SQU, CIS policy
 * you may not use this file except in compliance with the License.
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *
 * 
 */
package om.edu.squ.squportal.portlet.dps.security;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.DecoderException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Bhabesh
 *
 */
public class CryptoAES implements Crypto
{
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	 private  	int 		keySize;
	 private  	int 		iterationCount;
	 private  	Cipher 		cipher;
	 private	String		passCode;
	    
	 
	 public CryptoAES(int keySize, int iterationCount) 
	    {
	        this.keySize = keySize;
	        this.iterationCount = iterationCount;
	         try
			{
				cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			}
			catch (NoSuchAlgorithmException | NoSuchPaddingException e)
			{
				logger.error(":: Crypto Error :: Error in cypher initialization. Details : {}",e.getMessage());
			}
	    }
	 
	 public CryptoAES(){
		 
		 this.keySize			=	Crypto.CRYPTO_KEY_SIZE;
		 this.iterationCount	=	Crypto.CRYPTO_ITERATION_COUNT;
		 this.passCode			=	Crypto.CRYPTO_PASSCODE;
		 
		 try
			{
				cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			}
		catch (NoSuchAlgorithmException | NoSuchPaddingException e)
			{
				logger.error(":: Crypto Error :: Error in cypher initialization. Details : {}",e.getMessage());
			}
	 }
			 
	    
	    /**
	 * Setter method : setKeySize
	 * @param keySize the keySize to set
	 * 
	 * Date          : Nov 15, 2017 7:56:54 PM
	 */
	public void setKeySize(int keySize)
	{
		this.keySize = keySize;
	}



	/**
	 * Setter method : setIterationCount
	 * @param iterationCount the iterationCount to set
	 * 
	 * Date          : Nov 15, 2017 7:56:54 PM
	 */
	public void setIterationCount(int iterationCount)
	{
		this.iterationCount = iterationCount;
	}


		/**
	 * Setter method : setPassCode
	 * @param passCode the passCode to set
	 * 
	 * Date          : Nov 15, 2017 8:13:04 PM
	 */
	public void setPassCode(String passCode)
	{
		this.passCode = passCode;
	}
	
	
	
	    /**
	     * 
	     * method name  : encrypt
	     * @param salt
	     * @param iv
	     * @param plaintext
	     * @return
	     * CryptoAES
	     * return type  : String
	     * 
	     * purpose		:
	     *
	     * Date    		:	Nov 15, 2017 8:15:40 PM
	     */
	    public String encrypt(String salt, String iv,  String plaintext) {
	        String strEncrypt	=	null;
	    	try {
	            SecretKey key = generateKey(salt, this.passCode);
	            byte[] encrypted = doFinal(Cipher.ENCRYPT_MODE, key, iv, plaintext.getBytes("UTF-8"));
	            strEncrypt=  base64(encrypted);
	        }
	        catch (UnsupportedEncodingException e) {
	            logger.error(":: Crypto Error :: Error in encrypt. Details : {}",e.getMessage());
	        }
	    	return strEncrypt;
	    }

		/**
	     * 
	     * method name  : encrypt
	     * @param salt
	     * @param iv
	     * @param passphrase
	     * @param plaintext
	     * @return
	     * CryptoAES
	     * return type  : String
	     * 
	     * purpose		:
	     *
	     * Date    		:	Nov 15, 2017 7:23:54 PM
	     */
	    public String encrypt(String salt, String iv, String passphrase, String plaintext) {
	        String strEncrypt	=	null;
	    	try {
	            SecretKey key = generateKey(salt, passphrase);
	            byte[] encrypted = doFinal(Cipher.ENCRYPT_MODE, key, iv, plaintext.getBytes("UTF-8"));
	            strEncrypt=  base64(encrypted);
	        }
	        catch (UnsupportedEncodingException e) {
	            logger.error(":: Crypto Error :: Error in encrypt. Details : {}",e.getMessage());
	        }
	    	return strEncrypt;
	    }
	    
	    
	    /**
	     * 
	     * method name  : decrypt
	     * @param salt
	     * @param iv
	     * @param ciphertext
	     * @return
	     * CryptoAES
	     * return type  : String
	     * 
	     * purpose		:
	     *
	     * Date    		:	Nov 15, 2017 8:14:18 PM
	     */
	    public String decrypt(String salt, String iv,  String ciphertext) {
	        String	strDecrypt	=	null;
	    	try {
	            SecretKey key = generateKey(salt, this.passCode);
	            byte[] decrypted = doFinal(Cipher.DECRYPT_MODE, key, iv, base64(ciphertext));
	            strDecrypt =  new String(decrypted, "UTF-8");
	        }
	        catch (UnsupportedEncodingException e) {
	        	logger.error(" :: Crypto Error :: Error in deCrypt. Details : {}",e.getMessage());
	        }
	    	return strDecrypt;
	    }
	    
	    /**
	     * 
	     * method name  : decrypt
	     * @param salt
	     * @param iv
	     * @param passphrase
	     * @param ciphertext
	     * @return
	     * CryptoAES
	     * return type  : String
	     * 
	     * purpose		:
	     *
	     * Date    		:	Nov 15, 2017 7:25:06 PM
	     */
	    public String decrypt(String salt, String iv, String passphrase, String ciphertext) {
	        String	strDecrypt	=	null;
	    	try {
	            SecretKey key = generateKey(salt, passphrase);
	            byte[] decrypted = doFinal(Cipher.DECRYPT_MODE, key, iv, base64(ciphertext));
	            strDecrypt =  new String(decrypted, "UTF-8");
	        }
	        catch (UnsupportedEncodingException e) {
	        	logger.error(" :: Crypto Error :: Error in deCrypt. Details : {}",e.getMessage());
	        }
	    	return strDecrypt;
	    }

	   

	    

	    
	    
	    /**
	     * 
	     * method name  : doFinal
	     * @param encryptMode
	     * @param key
	     * @param iv
	     * @param bytes
	     * @return
	     * CryptoAES
	     * return type  : byte[]
	     * 
	     * purpose		:
	     *
	     * Date    		:	Nov 15, 2017 7:28:27 PM
	     */
	    private byte[] doFinal(int encryptMode, SecretKey key, String iv, byte[] bytes) {
	    	byte[]	byteFinal	=	null;
	    	try {
	            cipher.init(encryptMode, key, new IvParameterSpec(hex(iv)));
	            byteFinal =  cipher.doFinal(bytes);
	        }
	        catch (InvalidKeyException
	                | InvalidAlgorithmParameterException
	                | IllegalBlockSizeException
	                | BadPaddingException e) 
	    	{
	        	logger.error(":: Crypto Error :: Error in final. Details : {}",e.getMessage());
	        }
	    	return byteFinal;
	    }
	    
	    /**
	     * 
	     * method name  : generateKey
	     * @param salt
	     * @param passphrase
	     * @return
	     * CryptoAES
	     * return type  : SecretKey
	     * 
	     * purpose		:
	     *
	     * Date    		:	Nov 15, 2017 7:30:08 PM
	     */
	    private SecretKey generateKey(String salt, String passphrase) {
	    	SecretKey	secretKey	=	null;
	    	try {
	            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
	            KeySpec spec = new PBEKeySpec(passphrase.toCharArray(), hex(salt), iterationCount, keySize);
	            SecretKey key = new SecretKeySpec(factory.generateSecret(spec).getEncoded(), "AES");
	            secretKey = key;
	        }
	        catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
	        	logger.error(":: Crypto Error :: Error in key generation : {}",e.getMessage());
	        }
	    	return secretKey;
	    }
	    
	    
	    public static String random(int length) {
	        byte[] salt = new byte[length];
	        new SecureRandom().nextBytes(salt);
	        return hex(salt);
	    }
	    
	    public static String base64(byte[] bytes) {
	        return Base64.encodeBase64String(bytes);
	    }
	    
	    public  byte[] base64(String str) {
	        return Base64.decodeBase64(str);
	    }
	    
	    public static String hex(byte[] bytes) {
	        return Hex.encodeHexString(bytes);
	    }
	    
	    public static byte[] hex(String str) {
	        try {
	            return Hex.decodeHex(str.toCharArray());
	        }
	        catch (DecoderException e) {
	            throw new IllegalStateException(e);
	        }
	    }
	    
	    private IllegalStateException fail(Exception e) {
	        return new IllegalStateException(e);
	    }
}
