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
 * File Name			:	NotSuccessFulDBUpdate.java
 * Package Name			:	om.edu.squ.squportal.portlet.dps.dao.db.exception
 * Date of creation		:	May 7, 2017  12:41:51 PM
 * Date of modification :	
 * 
 * Summary				:	Generally this Exception used to address to raise issue of not successful DB operation 
 * 							(mainly DML, sometimes executed by function/stored procedure etc.)
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
public class NotSuccessFulDBUpdate extends Exception
{
	private	String message;

	public NotSuccessFulDBUpdate(String message)
	{
		super();
		this.message = message;
	}

	public NotSuccessFulDBUpdate()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	public NotSuccessFulDBUpdate(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace)
	{
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public NotSuccessFulDBUpdate(String message, Throwable cause)
	{
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public NotSuccessFulDBUpdate(Throwable cause)
	{
		super(cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Getter Method	: getMessage
	 * @return the message
	 * 
	 * Date				: May 7, 2017
	 */
	public String getMessage()
	{
		return this.message;
	}
	
	
	
}
