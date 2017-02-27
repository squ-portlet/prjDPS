/**
 * Project				:	prjDPS
 * Organization			:	Sultan Qaboos University | Muscat | Oman
 * Centre				:	Centre for Information System
 * Department			:	Web & E-Services
 * 
 * Author				:	Bhabesh
 *
 * FrameWork			:	Spring 3.2.3 (Annotation) Portlet
 * 
 * File Name			:	Student.java
 * Package Name			:	om.edu.squ.squportal.portlet.dps.bo
 * Date of creation		:	Jan 9, 2017  9:54:40 AM
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
package om.edu.squ.squportal.portlet.dps.bo;

/**
 * @author Bhabesh
 *
 */
public class Student
{
	private	PersonalDetail	personalDetail;
	private	AcademicDetail	academicDetail;
	/**
	 * Getter Method	: getPersonalDetail
	 * @return the personalDetail
	 * 
	 * Date				: Jan 9, 2017
	 */
	public PersonalDetail getPersonalDetail()
	{
		return this.personalDetail;
	}
	/**
	 * Setter method : setPersonalDetail
	 * @param personalDetail the personalDetail to set
	 * 
	 * Date          : Jan 9, 2017 10:42:24 AM
	 */
	public void setPersonalDetail(PersonalDetail personalDetail)
	{
		this.personalDetail = personalDetail;
	}
	/**
	 * Getter Method	: getAcademicDetail
	 * @return the academicDetail
	 * 
	 * Date				: Jan 9, 2017
	 */
	public AcademicDetail getAcademicDetail()
	{
		return this.academicDetail;
	}
	/**
	 * Setter method : setAcademicDetail
	 * @param academicDetail the academicDetail to set
	 * 
	 * Date          : Jan 9, 2017 10:42:24 AM
	 */
	public void setAcademicDetail(AcademicDetail academicDetail)
	{
		this.academicDetail = academicDetail;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "Student [personalDetail=" + this.personalDetail
				+ ", academicDetail=" + this.academicDetail + "]";
	}
	
	
}
