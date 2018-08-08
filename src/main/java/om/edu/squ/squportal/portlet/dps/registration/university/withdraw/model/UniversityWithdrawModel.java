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
 * File Name			:	UniversityWithdrawModel.java
 * Package Name			:	om.edu.squ.squportal.portlet.dps.registration.university.withdraw.model
 * Date of creation		:	Feb 5, 2018  9:03:47 AM
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
package om.edu.squ.squportal.portlet.dps.registration.university.withdraw.model;

/**
 * @author Bhabesh
 *
 */
public class UniversityWithdrawModel
{
	private	String	reasonCode;
	private	String	reason;

	/**
	 * Getter Method	: getReason
	 * @return the reason
	 * 
	 * Date				: Feb 5, 2018
	 */
	public String getReason()
	{
		return this.reason;
	}

	/**
	 * Setter method : setReason
	 * @param reason the reason to set
	 * 
	 * Date          : Feb 5, 2018 9:04:25 AM
	 */
	public void setReason(String reason)
	{
		this.reason = reason;
	}

	/**
	 * Getter Method	: getReasonCode
	 * @return the reasonCode
	 * 
	 * Date				: Feb 18, 2018
	 */
	public String getReasonCode()
	{
		return this.reasonCode;
	}

	/**
	 * Setter method : setReasonCode
	 * @param reasonCode the reasonCode to set
	 * 
	 * Date          : Feb 18, 2018 12:23:58 PM
	 */
	public void setReasonCode(String reasonCode)
	{
		this.reasonCode = reasonCode;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "UniversityWithdrawModel [reasonCode=" + this.reasonCode
				+ ", reason=" + this.reason + "]";
	}
	
	
}
