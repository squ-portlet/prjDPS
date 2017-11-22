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
	private		String			studentId;
	private		String			studentNo;
	private		String			stdStatCode;
	private		String			courseYear;
	private		String			semester;
	
	private		Course			course;
	private		String			sectionNo;
	private		Grade			grade;
	private		String			comments;
	
	private		String			userName;
	
	private		HOD				hod;
	private		DPSAsstDean		dpsAsstDean;
	private		DpsDean			dpsDean;
	
	
	
	
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
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "GradeDTO [studentId=" + this.studentId + ", studentNo="
				+ this.studentNo + ", stdStatCode=" + this.stdStatCode
				+ ", courseYear=" + this.courseYear + ", semester="
				+ this.semester + ", course=" + this.course + ", sectionNo="
				+ this.sectionNo + ", grade=" + this.grade + ", comments="
				+ this.comments + ", userName=" + this.userName + ", hod="
				+ this.hod + ", dpsAsstDean=" + this.dpsAsstDean + ", dpsDean="
				+ this.dpsDean + "]";
	}
	
	
	
	
}
