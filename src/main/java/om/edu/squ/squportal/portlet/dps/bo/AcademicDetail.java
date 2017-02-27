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
 * File Name			:	AcademicDetail.java
 * Package Name			:	om.edu.squ.squportal.portlet.dps.bo
 * Date of creation		:	09-January-2017
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
public class AcademicDetail
{
	private	String	id;
	private	String	studentNo;
	private	String	college;
	private	String	major;
	private	String	supervisorId;
	private	String	advisorId;
	private	String	degree;
	private	String	stdStatCode;
	private	String	status;
	/**
	 * Getter Method	: getId
	 * @return the id
	 * 
	 * Date				: Jan 9, 2017
	 */
	public String getId()
	{
		return this.id;
	}
	/**
	 * Setter method : setId
	 * @param id the id to set
	 * 
	 * Date          : Jan 9, 2017 10:34:35 AM
	 */
	public void setId(String id)
	{
		this.id = id;
	}
	
	/**
	 * Getter Method	: getStudentNo
	 * @return the studentNo
	 * 
	 * Date				: Jan 23, 2017
	 */
	public String getStudentNo()
	{
		return this.studentNo;
	}
	/**
	 * Setter method : setStudentNo
	 * @param studentNo the studentNo to set
	 * 
	 * Date          : Jan 23, 2017 5:37:32 PM
	 */
	public void setStudentNo(String studentNo)
	{
		this.studentNo = studentNo;
	}
	/**
	 * Getter Method	: getCollege
	 * @return the college
	 * 
	 * Date				: Jan 9, 2017
	 */
	public String getCollege()
	{
		return this.college;
	}
	/**
	 * Setter method : setCollege
	 * @param college the college to set
	 * 
	 * Date          : Jan 9, 2017 10:34:35 AM
	 */
	public void setCollege(String college)
	{
		this.college = college;
	}
	/**
	 * Getter Method	: getMajor
	 * @return the major
	 * 
	 * Date				: Jan 9, 2017
	 */
	public String getMajor()
	{
		return this.major;
	}
	/**
	 * Setter method : setMajor
	 * @param major the major to set
	 * 
	 * Date          : Jan 9, 2017 10:34:35 AM
	 */
	public void setMajor(String major)
	{
		this.major = major;
	}

	/**
	 * Getter Method	: getSupervisorId
	 * @return the supervisorId
	 * 
	 * Date				: Jan 9, 2017
	 */
	public String getSupervisorId()
	{
		return this.supervisorId;
	}
	/**
	 * Setter method : setSupervisorId
	 * @param supervisorId the supervisorId to set
	 * 
	 * Date          : Jan 9, 2017 10:40:01 AM
	 */
	public void setSupervisorId(String supervisorId)
	{
		this.supervisorId = supervisorId;
	}
	/**
	 * Getter Method	: getAdvisorId
	 * @return the advisorId
	 * 
	 * Date				: Jan 9, 2017
	 */
	public String getAdvisorId()
	{
		return this.advisorId;
	}
	/**
	 * Setter method : setAdvisorId
	 * @param advisorId the advisorId to set
	 * 
	 * Date          : Jan 9, 2017 10:40:01 AM
	 */
	public void setAdvisorId(String advisorId)
	{
		this.advisorId = advisorId;
	}
	/**
	 * Getter Method	: getDegree
	 * @return the degree
	 * 
	 * Date				: Jan 9, 2017
	 */
	public String getDegree()
	{
		return this.degree;
	}
	/**
	 * Setter method : setDegree
	 * @param degree the degree to set
	 * 
	 * Date          : Jan 9, 2017 10:34:35 AM
	 */
	public void setDegree(String degree)
	{
		this.degree = degree;
	}
	/**
	 * Getter Method	: getStdStatCode
	 * @return the stdStatCode
	 * 
	 * Date				: Jan 10, 2017
	 */
	public String getStdStatCode()
	{
		return this.stdStatCode;
	}
	/**
	 * Setter method : setStdStatCode
	 * @param stdStatCode the stdStatCode to set
	 * 
	 * Date          : Jan 10, 2017 3:05:15 PM
	 */
	public void setStdStatCode(String stdStatCode)
	{
		this.stdStatCode = stdStatCode;
	}
	/**
	 * Getter Method	: getStatus
	 * @return the status
	 * 
	 * Date				: Jan 9, 2017
	 */
	public String getStatus()
	{
		return this.status;
	}
	/**
	 * Setter method : setStatus
	 * @param status the status to set
	 * 
	 * Date          : Jan 9, 2017 10:34:35 AM
	 */
	public void setStatus(String status)
	{
		this.status = status;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "AcademicDetail [id=" + this.id + ", studentNo="
				+ this.studentNo + ", college=" + this.college + ", major="
				+ this.major + ", supervisorId=" + this.supervisorId
				+ ", advisorId=" + this.advisorId + ", degree=" + this.degree
				+ ", stdStatCode=" + this.stdStatCode + ", status="
				+ this.status + "]";
	}

	
	

	
}
