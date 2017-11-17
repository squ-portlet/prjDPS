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

/**
 * @author Bhabesh
 *
 */
public class GradeDTO
{
	private		String	studentId;
	private		String	studentNo;
	private		String	stdStatCode;
	private		String	courseYear;
	private		String	semester;
	
	private		Course	course;
	private		String	sectionNo;
	private		Grade	grade;
	
	
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
				+ this.sectionNo + ", grade=" + this.grade + "]";
	}
	
	
	
	
}
