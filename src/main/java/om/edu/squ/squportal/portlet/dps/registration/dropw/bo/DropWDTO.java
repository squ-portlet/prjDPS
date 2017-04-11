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
	private	String	studentNo;
	private	String	studentStatCode;
	private	String	userName;	
	private	String	firstWithDrawDate;
	private	String	secondWithDrawDate;
	private	float	tutionFees;
	private	String	statusDesc;
	
	public DropWDTO()
	{
		super();
	}
	/**
	 * Getter Method	: getStudentNo
	 * @return the studentNo
	 * 
	 * Date				: Apr 10, 2017
	 */
	public String getStudentNo()
	{
		return this.studentNo;
	}
	/**
	 * Setter method : setStudentNo
	 * @param studentNo the studentNo to set
	 * 
	 * Date          : Apr 10, 2017 6:59:54 PM
	 */
	public void setStudentNo(String studentNo)
	{
		this.studentNo = studentNo;
	}
	/**
	 * Getter Method	: getStudentStatCode
	 * @return the studentStatCode
	 * 
	 * Date				: Apr 10, 2017
	 */
	public String getStudentStatCode()
	{
		return this.studentStatCode;
	}
	/**
	 * Setter method : setStudentStatCode
	 * @param studentStatCode the studentStatCode to set
	 * 
	 * Date          : Apr 10, 2017 6:59:54 PM
	 */
	public void setStudentStatCode(String studentStatCode)
	{
		this.studentStatCode = studentStatCode;
	}
	/**
	 * Getter Method	: getUserName
	 * @return the userName
	 * 
	 * Date				: Apr 10, 2017
	 */
	public String getUserName()
	{
		return this.userName;
	}
	/**
	 * Setter method : setUserName
	 * @param userName the userName to set
	 * 
	 * Date          : Apr 10, 2017 6:59:54 PM
	 */
	public void setUserName(String userName)
	{
		this.userName = userName;
	}
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
	
	/**
	 * Getter Method	: getStatusDesc
	 * @return the statusDesc
	 * 
	 * Date				: Apr 11, 2017
	 */
	public String getStatusDesc()
	{
		return this.statusDesc;
	}
	/**
	 * Setter method : setStatusDesc
	 * @param statusDesc the statusDesc to set
	 * 
	 * Date          : Apr 11, 2017 4:01:19 PM
	 */
	public void setStatusDesc(String statusDesc)
	{
		this.statusDesc = statusDesc;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "DropWDTO [studentNo=" + this.studentNo + ", studentStatCode="
				+ this.studentStatCode + ", userName=" + this.userName
				+ ", firstWithDrawDate=" + this.firstWithDrawDate
				+ ", secondWithDrawDate=" + this.secondWithDrawDate
				+ ", tutionFees=" + this.tutionFees + ", statusDesc="
				+ this.statusDesc + "]";
	}
	
	
}
