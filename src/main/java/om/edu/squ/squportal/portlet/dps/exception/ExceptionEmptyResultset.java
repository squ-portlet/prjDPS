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
 * File Name			:	ExceptionEmptyResultset.java
 * Package Name			:	om.edu.squ.squportal.portlet.dps.exception
 * Date of creation		:	Feb 20, 2017  12:20:49 AM
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
package om.edu.squ.squportal.portlet.dps.exception;

/**
 * @author Bhabesh
 *
 */
public class ExceptionEmptyResultset extends Exception
{

	private static final long	serialVersionUID	= 1L;
	
	public ExceptionEmptyResultset()
	{
		super();
	}
	
	public ExceptionEmptyResultset(String message, Throwable throwable)
	{
		super(message, throwable);
	}
	
	public ExceptionEmptyResultset(String message)
	{
		super(message);
	}
	
	@Override
	public String getMessage()
	{
		// TODO Auto-generated method stub
		return super.getMessage();
	}
	
	
}
