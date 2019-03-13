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
 * File Name			:	ExceptionExtensionExists.java
 * Package Name			:	om.edu.squ.squportal.portlet.dps.exception
 * Date of creation		:	Mar 3, 2019  1:55:32 PM
 * Date of modification :	
 * 
 * Summary				:	
 *
 *
 * Copyright 2019 the original author or authors and Organization.
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
package om.edu.squ.squportal.portlet.dps.exception;

/**
 * @author Bhabesh
 *
 */
public class ExceptionExtensionExists extends Exception
{
	private static final long	serialVersionUID	= 1L;

	/**
	 * 
	 * Constructor
	 *
	 */
	public ExceptionExtensionExists()
	{
		super();
		
	}
	
	/**
	 * 
	 * Constructor
	 * @param message
	 * @param cause
	 *
	 */
	public ExceptionExtensionExists(String message, Throwable cause)
	{
		super(message, cause);
		
	}
	
	/**
	 * 
	 * Constructor
	 * @param message
	 *
	 */
	public ExceptionExtensionExists(String message)
	{
		super(message);
		
	}

	/* (non-Javadoc)
	 * @see java.lang.Throwable#getMessage()
	 */
	@Override
	public String getMessage()
	{
		return super.getMessage();
	}
	
}
