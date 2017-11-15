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
 * File Name			:	Crypto.java
 * Package Name			:	om.edu.squ.squportal.portlet.dps.security
 * Date of creation		:	Nov 15, 2017  7:52:40 PM
 * Date of modification :	
 * 
 * Summary				:	
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

/**
 * @author Bhabesh
 *
 */
public interface Crypto
{
	
	public 	static 	final	int		CRYPTO_ITERATION_COUNT	=	1000;
	public 	static 	final	int		CRYPTO_KEY_SIZE			=	128;
	public	static	final	String	CRYPTO_PASSCODE			=	"abcdef";
	
	
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
    public String encrypt(String salt, String iv,  String plaintext);
	
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
    public String encrypt(String salt, String iv, String passphrase, String plaintext);
    
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
    public String decrypt(String salt, String iv,  String ciphertext);
    
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
    public String decrypt(String salt, String iv, String passphrase, String ciphertext);
}
