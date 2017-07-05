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
 * File Name			:	NotCorrectDBRecordException.java
 * Package Name			:	om.edu.squ.squportal.portlet.dps.dao.db.exception
 * Date of creation		:	Jul 5, 2017  8:46:32 AM
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
package om.edu.squ.squportal.portlet.dps.dao.db.exception;

/**
 * @author Bhabesh
 *
 */
public class NotCorrectDBRecordException extends Exception
{

	private	String message;
	
	public NotCorrectDBRecordException()
	{
		super();
		// TODO Auto-generated constructor stub
	}


	public NotCorrectDBRecordException(String message, Throwable cause)
	{
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public NotCorrectDBRecordException(String message)
	{
		super(message);
		this.message = message;
		
	}

	public NotCorrectDBRecordException(Throwable cause)
	{
		super(cause);
		// TODO Auto-generated constructor stub
	}


	/**
	 * Getter Method	: getMessage
	 * @return the message
	 * 
	 * Date				: Jul 5, 2017
	 */
	public String getMessage()
	{
		return this.message;
	}
	
	
}
