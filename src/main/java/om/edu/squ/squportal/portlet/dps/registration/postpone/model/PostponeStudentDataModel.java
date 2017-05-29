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
 * File Name			:	PostponeStudentDataModel.java
 * Package Name			:	om.edu.squ.squportal.portlet.dps.registration.postpone.model
 * Date of creation		:	May 29, 2017  2:05:24 PM
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
package om.edu.squ.squportal.portlet.dps.registration.postpone.model;

/**
 * @author Bhabesh
 *
 */
public class PostponeStudentDataModel
{
	private	String	yearSem;
	private	String	reasonCode;
	private	String	reasonOther;
	/**
	 * Getter Method	: getYearSem
	 * @return the yearSem
	 * 
	 * Date				: May 29, 2017
	 */
	public String getYearSem()
	{
		return this.yearSem;
	}
	/**
	 * Setter method : setYearSem
	 * @param yearSem the yearSem to set
	 * 
	 * Date          : May 29, 2017 2:20:44 PM
	 */
	public void setYearSem(String yearSem)
	{
		this.yearSem = yearSem;
	}
	/**
	 * Getter Method	: getReasonCode
	 * @return the reasonCode
	 * 
	 * Date				: May 29, 2017
	 */
	public String getReasonCode()
	{
		return this.reasonCode;
	}
	/**
	 * Setter method : setReasonCode
	 * @param reasonCode the reasonCode to set
	 * 
	 * Date          : May 29, 2017 2:20:44 PM
	 */
	public void setReasonCode(String reasonCode)
	{
		this.reasonCode = reasonCode;
	}
	/**
	 * Getter Method	: getReasonOther
	 * @return the reasonOther
	 * 
	 * Date				: May 29, 2017
	 */
	public String getReasonOther()
	{
		return this.reasonOther;
	}
	/**
	 * Setter method : setReasonOther
	 * @param reasonOther the reasonOther to set
	 * 
	 * Date          : May 29, 2017 2:20:44 PM
	 */
	public void setReasonOther(String reasonOther)
	{
		this.reasonOther = reasonOther;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "PostponeStudentDataModel [yearSem=" + this.yearSem
				+ ", reasonCode=" + this.reasonCode + ", reasonOther="
				+ this.reasonOther + "]";
	}
	
	
	
}
