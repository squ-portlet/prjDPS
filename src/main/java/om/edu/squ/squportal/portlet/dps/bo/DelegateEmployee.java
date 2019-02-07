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
 * File Name			:	DelegateEmployee.java
 * Package Name			:	om.edu.squ.squportal.portlet.dps.bo
 * Date of creation		:	May 29, 2018  8:45:29 AM
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
public class DelegateEmployee
{
	private	String	empNumberDelegated;
	private	String	userNameDelegated;
	private	String	empNumberDelegatee;
	private	String	userNameDelegatee;
	private	String	delegatedFromDate;
	private	String	delegatedToDate;
	/**
	 * Getter Method	: getEmpNumberDelegated
	 * @return the empNumberDelegated
	 * 
	 * Date				: May 29, 2018
	 */
	public String getEmpNumberDelegated()
	{
		return this.empNumberDelegated;
	}
	/**
	 * Setter method : setEmpNumberDelegated
	 * @param empNumberDelegated the empNumberDelegated to set
	 * 
	 * Date          : May 29, 2018 8:48:42 AM
	 */
	public void setEmpNumberDelegated(String empNumberDelegated)
	{
		this.empNumberDelegated = empNumberDelegated;
	}
	/**
	 * Getter Method	: getUserNameDelegated
	 * @return the userNameDelegated
	 * 
	 * Date				: May 29, 2018
	 */
	public String getUserNameDelegated()
	{
		return this.userNameDelegated;
	}
	/**
	 * Setter method : setUserNameDelegated
	 * @param userNameDelegated the userNameDelegated to set
	 * 
	 * Date          : May 29, 2018 8:48:42 AM
	 */
	public void setUserNameDelegated(String userNameDelegated)
	{
		this.userNameDelegated = userNameDelegated;
	}
	/**
	 * Getter Method	: getEmpNumberDelegatee
	 * @return the empNumberDelegatee
	 * 
	 * Date				: May 29, 2018
	 */
	public String getEmpNumberDelegatee()
	{
		return this.empNumberDelegatee;
	}
	/**
	 * Setter method : setEmpNumberDelegatee
	 * @param empNumberDelegatee the empNumberDelegatee to set
	 * 
	 * Date          : May 29, 2018 8:48:42 AM
	 */
	public void setEmpNumberDelegatee(String empNumberDelegatee)
	{
		this.empNumberDelegatee = empNumberDelegatee;
	}
	/**
	 * Getter Method	: getUserNameDelegatee
	 * @return the userNameDelegatee
	 * 
	 * Date				: May 29, 2018
	 */
	public String getUserNameDelegatee()
	{
		return this.userNameDelegatee;
	}
	/**
	 * Setter method : setUserNameDelegatee
	 * @param userNameDelegatee the userNameDelegatee to set
	 * 
	 * Date          : May 29, 2018 8:48:42 AM
	 */
	public void setUserNameDelegatee(String userNameDelegatee)
	{
		this.userNameDelegatee = userNameDelegatee;
	}
	/**
	 * Getter Method	: getDelegatedFromDate
	 * @return the delegatedFromDate
	 * 
	 * Date				: May 29, 2018
	 */
	public String getDelegatedFromDate()
	{
		return this.delegatedFromDate;
	}
	/**
	 * Setter method : setDelegatedFromDate
	 * @param delegatedFromDate the delegatedFromDate to set
	 * 
	 * Date          : May 29, 2018 8:48:42 AM
	 */
	public void setDelegatedFromDate(String delegatedFromDate)
	{
		this.delegatedFromDate = delegatedFromDate;
	}
	/**
	 * Getter Method	: getDelegatedToDate
	 * @return the delegatedToDate
	 * 
	 * Date				: May 29, 2018
	 */
	public String getDelegatedToDate()
	{
		return this.delegatedToDate;
	}
	/**
	 * Setter method : setDelegatedToDate
	 * @param delegatedToDate the delegatedToDate to set
	 * 
	 * Date          : May 29, 2018 8:48:42 AM
	 */
	public void setDelegatedToDate(String delegatedToDate)
	{
		this.delegatedToDate = delegatedToDate;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "DelegateEmployee [empNumberDelegated="
				+ this.empNumberDelegated + ", userNameDelegated="
				+ this.userNameDelegated + ", empNumberDelegatee="
				+ this.empNumberDelegatee + ", userNameDelegatee="
				+ this.userNameDelegatee + ", delegatedFromDate="
				+ this.delegatedFromDate + ", delegatedToDate="
				+ this.delegatedToDate + "]";
	}
	
	
	
		
}
