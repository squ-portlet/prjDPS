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
 * File Name			:	CodeValue.java
 * Package Name			:	om.edu.squ.squportal.portlet.dps.bo
 * Date of creation		:	Feb 5, 2018  11:45:31 AM
 * Date of modification :	
 * 
 * Summary				:	
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
package om.edu.squ.squportal.portlet.dps.bo;

/**
 * @author Bhabesh
 *
 */
public class CodeValue
{
	private	String	code;
	private	String	value;
	/**
	 * Getter Method	: getCode
	 * @return the code
	 * 
	 * Date				: Feb 5, 2018
	 */
	public String getCode()
	{
		return this.code;
	}
	/**
	 * Setter method : setCode
	 * @param code the code to set
	 * 
	 * Date          : Feb 5, 2018 11:45:56 AM
	 */
	public void setCode(String code)
	{
		this.code = code;
	}
	/**
	 * Getter Method	: getValue
	 * @return the value
	 * 
	 * Date				: Feb 5, 2018
	 */
	public String getValue()
	{
		return this.value;
	}
	/**
	 * Setter method : setValue
	 * @param value the value to set
	 * 
	 * Date          : Feb 5, 2018 11:45:56 AM
	 */
	public void setValue(String value)
	{
		this.value = value;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "CodeValue [code=" + this.code + ", value=" + this.value + "]";
	}
	
	
	
}
