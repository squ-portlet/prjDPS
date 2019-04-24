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
 * File Name			:	NameValue.java
 * Package Name			:	om.edu.squ.squportal.portlet.dps.bo
 * Date of creation		:	Jan 14, 2019  3:39:12 PM
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
package om.edu.squ.squportal.portlet.dps.bo;

/**
 * @author Bhabesh
 *
 */
public class NameValue
{
	private	boolean	applicable;
	private String 	name;
	private	String	value;
	
	public NameValue(){}
	public NameValue(boolean applicable, String name, String value)
	{
		this.applicable = applicable;
		this.name = name;
		this.value = value;
	}
	public NameValue(String name, String value)
	{
		super();
		this.name = name;
		this.value = value;
	}
	/**
	 * Getter Method	: isApplicable
	 * @return the applicable
	 * 
	 * Date				: Jan 14, 2019
	 */
	public boolean isApplicable()
	{
		return this.applicable;
	}
	/**
	 * Setter method : setApplicable
	 * @param applicable the applicable to set
	 * 
	 * Date          : Jan 14, 2019 3:45:35 PM
	 */
	public void setApplicable(boolean applicable)
	{
		this.applicable = applicable;
	}
	/**
	 * Getter Method	: getName
	 * @return the name
	 * 
	 * Date				: Jan 14, 2019
	 */
	public String getName()
	{
		return this.name;
	}
	/**
	 * Setter method : setName
	 * @param name the name to set
	 * 
	 * Date          : Jan 14, 2019 3:39:48 PM
	 */
	public void setName(String name)
	{
		this.name = name;
	}
	/**
	 * Getter Method	: getValue
	 * @return the value
	 * 
	 * Date				: Jan 14, 2019
	 */
	public String getValue()
	{
		return this.value;
	}
	/**
	 * Setter method : setValue
	 * @param value the value to set
	 * 
	 * Date          : Jan 14, 2019 3:39:48 PM
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
		return "NameValue [applicable=" + this.applicable + ", name="
				+ this.name + ", value=" + this.value + "]";
	}
	
	
}
