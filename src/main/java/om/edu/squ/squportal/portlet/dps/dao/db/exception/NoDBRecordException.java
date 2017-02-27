/**
 * Project				:	prjDPS
 * Organization			:	Sultan Qaboos University | Muscat | Oman
 * Centre				:	Centre for Information System
 * Department			:	Web & E-Services
 * 
 * Author				:	Bhabesh
 *
 * FrameWork			:	Spring 4.0.8
 * 
 * File Name			:	NoDBRecordException.java
 * Package Name			:	om.edu.squ.squportal.portlet.dps.dao.db.exception
 * Date of creation		:	09-January-2017
 * Date of modification :	
 * 
 * Summary				:	
 *
 *
 * Copyright 2015 the original author or authors and Organization.
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
package om.edu.squ.squportal.portlet.dps.dao.db.exception;


/**
 * @author Bhabesh
 *
 */
public class NoDBRecordException extends Exception
{
	private String message;
	
	/**
	 * 
	 * Constructor
	 *
	 */
	public NoDBRecordException() {

		super();
	}
	
	/**
	 * 
	 * Constructor
	 * @param message
	 *
	 */
	public NoDBRecordException(String message) {
		super(message);
		this.message	=	message;
	}
	
	/**
	 * 
	 * Constructor
	 * @param cause
	 *
	 */
	public NoDBRecordException(Throwable cause)
	{
		super(cause);
	}

	
	/**
	 * Getter Method	: getMessage
	 * @return the message
	 * 
	 * Date				: Dec 31, 2015
	 */
	public String getMessage() {
	
		return this.message;
	}
	
	
	
	
}
