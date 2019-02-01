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
 * File Name			:	WithdrawPeriod.java
 * Package Name			:	om.edu.squ.squportal.portlet.dps.rule.bo
 * Date of creation		:	Jan 31, 2019  2:42:01 PM
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
package om.edu.squ.squportal.portlet.dps.rule.bo;

/**
 * @author Bhabesh
 *
 */
public class WithdrawPeriod
{
	private	String	firstWithDrawDate;
	private	String	secondWithDrawDate;
	/**
	 * Getter Method	: getFirstWithDrawDate
	 * @return the firstWithDrawDate
	 * 
	 * Date				: Jan 31, 2019
	 */
	public String getFirstWithDrawDate()
	{
		return this.firstWithDrawDate;
	}
	/**
	 * Setter method : setFirstWithDrawDate
	 * @param firstWithDrawDate the firstWithDrawDate to set
	 * 
	 * Date          : Jan 31, 2019 2:42:49 PM
	 */
	public void setFirstWithDrawDate(String firstWithDrawDate)
	{
		this.firstWithDrawDate = firstWithDrawDate;
	}
	/**
	 * Getter Method	: getSecondWithDrawDate
	 * @return the secondWithDrawDate
	 * 
	 * Date				: Jan 31, 2019
	 */
	public String getSecondWithDrawDate()
	{
		return this.secondWithDrawDate;
	}
	/**
	 * Setter method : setSecondWithDrawDate
	 * @param secondWithDrawDate the secondWithDrawDate to set
	 * 
	 * Date          : Jan 31, 2019 2:42:49 PM
	 */
	public void setSecondWithDrawDate(String secondWithDrawDate)
	{
		this.secondWithDrawDate = secondWithDrawDate;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "WithdrawPeriod [firstWithDrawDate=" + this.firstWithDrawDate
				+ ", secondWithDrawDate=" + this.secondWithDrawDate + "]";
	}
	
	
}
