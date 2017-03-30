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
 * File Name			:	DropWDTO.java
 * Package Name			:	om.edu.squ.squportal.portlet.dps.registration.dropw.bo
 * Date of creation		:	Mar 29, 2017  6:59:43 PM
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
package om.edu.squ.squportal.portlet.dps.registration.dropw.bo;

import om.edu.squ.squportal.portlet.dps.bo.Course;

/**
 * @author Bhabesh
 *
 */
public class DropWDTO extends Course
{
	private	String	firstWithDrawDate;
	private	String	secondWithDrawDate;
	private	float	tutionFees;
	/**
	 * Getter Method	: getFirstWithDrawDate
	 * @return the firstWithDrawDate
	 * 
	 * Date				: Mar 29, 2017
	 */
	public String getFirstWithDrawDate()
	{
		return this.firstWithDrawDate;
	}
	/**
	 * Setter method : setFirstWithDrawDate
	 * @param firstWithDrawDate the firstWithDrawDate to set
	 * 
	 * Date          : Mar 29, 2017 7:02:20 PM
	 */
	public void setFirstWithDrawDate(String firstWithDrawDate)
	{
		this.firstWithDrawDate = firstWithDrawDate;
	}
	/**
	 * Getter Method	: getSecondWithDrawDate
	 * @return the secondWithDrawDate
	 * 
	 * Date				: Mar 29, 2017
	 */
	public String getSecondWithDrawDate()
	{
		return this.secondWithDrawDate;
	}
	/**
	 * Setter method : setSecondWithDrawDate
	 * @param secondWithDrawDate the secondWithDrawDate to set
	 * 
	 * Date          : Mar 29, 2017 7:02:20 PM
	 */
	public void setSecondWithDrawDate(String secondWithDrawDate)
	{
		this.secondWithDrawDate = secondWithDrawDate;
	}
	
	/**
	 * Getter Method	: getTutionFees
	 * @return the tutionFees
	 * 
	 * Date				: Mar 30, 2017
	 */
	public float getTutionFees()
	{
		return this.tutionFees;
	}
	/**
	 * Setter method : setTutionFees
	 * @param tutionFees the tutionFees to set
	 * 
	 * Date          : Mar 30, 2017 8:20:02 AM
	 */
	public void setTutionFees(float tutionFees)
	{
		this.tutionFees = tutionFees;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "DropWDTO [firstWithDrawDate=" + this.firstWithDrawDate
				+ ", secondWithDrawDate=" + this.secondWithDrawDate
				+ ", tutionFees=" + this.tutionFees + "]";
	}
	
	
}
