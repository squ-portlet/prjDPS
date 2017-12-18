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
 * File Name			:	GradeDTO.java
 * Package Name			:	om.edu.squ.squportal.portlet.dps.grade.gradechange.bo
 * Date of creation		:	Nov 15, 2017  9:28:42 AM
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
package om.edu.squ.squportal.portlet.dps.grade.gradechange.bo;

import om.edu.squ.squportal.portlet.dps.role.bo.DPSAsstDean;
import om.edu.squ.squportal.portlet.dps.role.bo.DpsDean;
import om.edu.squ.squportal.portlet.dps.role.bo.HOD;

/**
 * @author Bhabesh
 *
 */
public class GradeDTO
{
	private		String			recordSequence;
	private		String			studentId;
	private		String			studentNo;
	private		String			studentName;
	private		String			stdStatCode;
	private		String			courseYear;
	private		String			semester;
	
	private		String			sectCode;					// Sect Code is not Section number - it is unique and will change for the course in each semester
	private		Course			course;
	private		String			sectionNo;
	private		Grade			grade;
	private		String			comments;
	private		boolean			updatable;
	private		boolean			changable;
	private		String			statusCode;
	private		String			statusDesc;
	
	private		String			userName;
	
	private		String			roleType;
	private		HOD				hod;
	private		DPSAsstDean		dpsAsstDean;
	private		DpsDean			dpsDean;
	
	private		boolean			approver;
	
	
	
	
	
	/**
	 * Getter Method	: getRecordSequence
	 * @return the recordSequence
	 * 
	 * Date				: Dec 6, 2017
	 */
	public String getRecordSequence()
	{
		return this.recordSequence;
	}
	/**
	 * Setter method : setRecordSequence
	 * @param recordSequence the recordSequence to set
	 * 
	 * Date          : Dec 6, 2017 7:07:11 PM
	 */
	public void setRecordSequence(String recordSequence)
	{
		this.recordSequence = recordSequence;
	}
	/**
	 * Getter Method	: getStudentId
	 * @return the studentId
	 * 
	 * Date				: Nov 16, 2017
	 */
	public String getStudentId()
	{
		return this.studentId;
	}
	/**
	 * Setter method : setStudentId
	 * @param studentId the studentId to set
	 * 
	 * Date          : Nov 16, 2017 10:42:55 AM
	 */
	public void setStudentId(String studentId)
	{
		this.studentId = studentId;
	}
	/**
	 * Getter Method	: getStudentNo
	 * @return the studentNo
	 * 
	 * Date				: Nov 16, 2017
	 */
	public String getStudentNo()
	{
		return this.studentNo;
	}
	/**
	 * Setter method : setStudentNo
	 * @param studentNo the studentNo to set
	 * 
	 * Date          : Nov 16, 2017 10:33:26 AM
	 */
	public void setStudentNo(String studentNo)
	{
		this.studentNo = studentNo;
	}
	
	/**
	 * Getter Method	: getStudentName
	 * @return the studentName
	 * 
	 * Date				: Dec 16, 2017
	 */
	public String getStudentName()
	{
		return this.studentName;
	}
	/**
	 * Setter method : setStudentName
	 * @param studentName the studentName to set
	 * 
	 * Date          : Dec 16, 2017 8:34:00 PM
	 */
	public void setStudentName(String studentName)
	{
		this.studentName = studentName;
	}
	/**
	 * Getter Method	: getStdStatCode
	 * @return the stdStatCode
	 * 
	 * Date				: Nov 16, 2017
	 */
	public String getStdStatCode()
	{
		return this.stdStatCode;
	}
	/**
	 * Setter method : setStdStatCode
	 * @param stdStatCode the stdStatCode to set
	 * 
	 * Date          : Nov 16, 2017 10:43:11 AM
	 */
	public void setStdStatCode(String stdStatCode)
	{
		this.stdStatCode = stdStatCode;
	}
	/**
	 * Getter Method	: getCourseYear
	 * @return the courseYear
	 * 
	 * Date				: Nov 16, 2017
	 */
	public String getCourseYear()
	{
		return this.courseYear;
	}
	/**
	 * Setter method : setCourseYear
	 * @param courseYear the courseYear to set
	 * 
	 * Date          : Nov 16, 2017 10:33:27 AM
	 */
	public void setCourseYear(String courseYear)
	{
		this.courseYear = courseYear;
	}
	/**
	 * Getter Method	: getSemester
	 * @return the semester
	 * 
	 * Date				: Nov 16, 2017
	 */
	public String getSemester()
	{
		return this.semester;
	}
	/**
	 * Setter method : setSemester
	 * @param semester the semester to set
	 * 
	 * Date          : Nov 16, 2017 10:33:27 AM
	 */
	public void setSemester(String semester)
	{
		this.semester = semester;
	}
	
	/**
	 * Getter Method	: getSectCode
	 * @return the sectCode
	 * 
	 * Date				: Dec 13, 2017
	 */
	public String getSectCode()
	{
		return this.sectCode;
	}
	/**
	 * Setter method : setSectCode
	 * @param sectCode the sectCode to set
	 * 
	 * Date          : Dec 13, 2017 11:02:09 AM
	 */
	public void setSectCode(String sectCode)
	{
		this.sectCode = sectCode;
	}
	/**
	 * Getter Method	: getCourse
	 * @return the course
	 * 
	 * Date				: Nov 15, 2017
	 */
	public Course getCourse()
	{
		return this.course;
	}
	/**
	 * Setter method : setCourse
	 * @param course the course to set
	 * 
	 * Date          : Nov 15, 2017 9:35:47 AM
	 */
	public void setCourse(Course course)
	{
		this.course = course;
	}
	/**
	 * Getter Method	: getSectionNo
	 * @return the sectionNo
	 * 
	 * Date				: Nov 15, 2017
	 */
	public String getSectionNo()
	{
		return this.sectionNo;
	}
	/**
	 * Setter method : setSectionNo
	 * @param sectionNo the sectionNo to set
	 * 
	 * Date          : Nov 15, 2017 9:35:47 AM
	 */
	public void setSectionNo(String sectionNo)
	{
		this.sectionNo = sectionNo;
	}
	/**
	 * Getter Method	: getGrade
	 * @return the grade
	 * 
	 * Date				: Nov 15, 2017
	 */
	public Grade getGrade()
	{
		return this.grade;
	}
	/**
	 * Setter method : setGrade
	 * @param grade the grade to set
	 * 
	 * Date          : Nov 15, 2017 9:35:47 AM
	 */
	public void setGrade(Grade grade)
	{
		this.grade = grade;
	}
	
	
	/**
	 * Getter Method	: getComments
	 * @return the comments
	 * 
	 * Date				: Nov 22, 2017
	 */
	public String getComments()
	{
		return this.comments;
	}
	/**
	 * Setter method : setComments
	 * @param comments the comments to set
	 * 
	 * Date          : Nov 22, 2017 2:56:37 PM
	 */
	public void setComments(String comments)
	{
		this.comments = comments;
	}
	
	/**
	 * Getter Method	: isUpdatable
	 * @return the updatable
	 * 
	 * Date				: Nov 22, 2017
	 */
	public boolean isUpdatable()
	{
		return this.updatable;
	}
	/**
	 * Setter method : setUpdatable
	 * @param updatable the updatable to set
	 * 
	 * Date          : Nov 22, 2017 5:47:17 PM
	 */
	public void setUpdatable(boolean updatable)
	{
		this.updatable = updatable;
	}
	/**
	 * Getter Method	: isChangable
	 * @return the changable
	 * 
	 * Date				: Dec 18, 2017
	 */
	public boolean isChangable()
	{
		return this.changable;
	}
	/**
	 * Setter method : setChangable
	 * @param changable the changable to set
	 * 
	 * Date          : Dec 18, 2017 12:34:46 PM
	 */
	public void setChangable(boolean changable)
	{
		this.changable = changable;
	}
	/**
	 * Getter Method	: getStatusCode
	 * @return the statusCode
	 * 
	 * Date				: Dec 10, 2017
	 */
	public String getStatusCode()
	{
		return this.statusCode;
	}
	/**
	 * Setter method : setStatusCode
	 * @param statusCode the statusCode to set
	 * 
	 * Date          : Dec 10, 2017 2:26:06 PM
	 */
	public void setStatusCode(String statusCode)
	{
		this.statusCode = statusCode;
	}
	/**
	 * Getter Method	: getStatusDesc
	 * @return the statusDesc
	 * 
	 * Date				: Nov 22, 2017
	 */
	public String getStatusDesc()
	{
		return this.statusDesc;
	}
	/**
	 * Setter method : setStatusDesc
	 * @param statusDesc the statusDesc to set
	 * 
	 * Date          : Nov 22, 2017 6:13:33 PM
	 */
	public void setStatusDesc(String statusDesc)
	{
		this.statusDesc = statusDesc;
	}
	/**
	 * Getter Method	: getUserName
	 * @return the userName
	 * 
	 * Date				: Nov 21, 2017
	 */
	public String getUserName()
	{
		return this.userName;
	}
	/**
	 * Setter method : setUserName
	 * @param userName the userName to set
	 * 
	 * Date          : Nov 21, 2017 12:25:25 PM
	 */
	public void setUserName(String userName)
	{
		this.userName = userName;
	}
	
	
	/**
	 * Getter Method	: getRoleType
	 * @return the roleType
	 * 
	 * Date				: Dec 6, 2017
	 */
	public String getRoleType()
	{
		return this.roleType;
	}
	/**
	 * Setter method : setRoleType
	 * @param roleType the roleType to set
	 * 
	 * Date          : Dec 6, 2017 9:05:31 PM
	 */
	public void setRoleType(String roleType)
	{
		this.roleType = roleType;
	}
	/**
	 * Getter Method	: getHod
	 * @return the hod
	 * 
	 * Date				: Nov 22, 2017
	 */
	public HOD getHod()
	{
		return this.hod;
	}
	/**
	 * Setter method : setHod
	 * @param hod the hod to set
	 * 
	 * Date          : Nov 22, 2017 2:45:57 PM
	 */
	public void setHod(HOD hod)
	{
		this.hod = hod;
	}
	/**
	 * Getter Method	: getDpsAsstDean
	 * @return the dpsAsstDean
	 * 
	 * Date				: Nov 22, 2017
	 */
	public DPSAsstDean getDpsAsstDean()
	{
		return this.dpsAsstDean;
	}
	/**
	 * Setter method : setDpsAsstDean
	 * @param dpsAsstDean the dpsAsstDean to set
	 * 
	 * Date          : Nov 22, 2017 2:45:57 PM
	 */
	public void setDpsAsstDean(DPSAsstDean dpsAsstDean)
	{
		this.dpsAsstDean = dpsAsstDean;
	}
	/**
	 * Getter Method	: getDpsDean
	 * @return the dpsDean
	 * 
	 * Date				: Nov 22, 2017
	 */
	public DpsDean getDpsDean()
	{
		return this.dpsDean;
	}
	/**
	 * Setter method : setDpsDean
	 * @param dpsDean the dpsDean to set
	 * 
	 * Date          : Nov 22, 2017 2:45:57 PM
	 */
	public void setDpsDean(DpsDean dpsDean)
	{
		this.dpsDean = dpsDean;
	}
	
	/**
	 * Getter Method	: isApprover
	 * @return the approver
	 * 
	 * Date				: Dec 6, 2017
	 */
	public boolean isApprover()
	{
		return this.approver;
	}
	/**
	 * Setter method : setApprover
	 * @param approver the approver to set
	 * 
	 * Date          : Dec 6, 2017 8:37:48 PM
	 */
	public void setApprover(boolean approver)
	{
		this.approver = approver;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "GradeDTO [recordSequence=" + this.recordSequence
				+ ", studentId=" + this.studentId + ", studentNo="
				+ this.studentNo + ", studentName=" + this.studentName
				+ ", stdStatCode=" + this.stdStatCode + ", courseYear="
				+ this.courseYear + ", semester=" + this.semester
				+ ", sectCode=" + this.sectCode + ", course=" + this.course
				+ ", sectionNo=" + this.sectionNo + ", grade=" + this.grade
				+ ", comments=" + this.comments + ", updatable="
				+ this.updatable + ", changable=" + this.changable
				+ ", statusCode=" + this.statusCode + ", statusDesc="
				+ this.statusDesc + ", userName=" + this.userName
				+ ", roleType=" + this.roleType + ", hod=" + this.hod
				+ ", dpsAsstDean=" + this.dpsAsstDean + ", dpsDean="
				+ this.dpsDean + ", approver=" + this.approver + "]";
	}
	
	
	
	
}
