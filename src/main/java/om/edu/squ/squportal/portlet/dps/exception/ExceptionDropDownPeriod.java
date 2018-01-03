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
 * File Name			:	ExceptionDropDownPeriod.java
 * Package Name			:	om.edu.squ.squportal.portlet.dps.exception
 * Date of creation		:	Jan 2, 2018  3:28:03 PM
 * Date of modification :	
 * 
 * Summary				:	Exception for Drop with w time period
 *
 *
 * Copyright 2018 the original author or authors and Organization.
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
public class ExceptionDropDownPeriod extends Exception
{
	public ExceptionDropDownPeriod()
	{
		super();
	}
	
	public ExceptionDropDownPeriod(String message, Throwable throwable)
	{
		super(message, throwable);
	}
	public ExceptionDropDownPeriod(String message)
	{
		super(message);
	}
	
	public String getMessage()
	{
		return super.getMessage();
	}
}
